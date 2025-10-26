import 'package:dartz/dartz.dart';
import '../../../../core/error/failures.dart';
import '../../domain/entities/note.dart';
import '../../domain/repositories/notes_repository.dart';
import '../datasources/notes_local_data_source.dart';
import '../datasources/notes_remote_data_source.dart';
import '../models/note_model.dart';

class NotesRepositoryImpl implements NotesRepository {
  final NotesRemoteDataSource remoteDataSource;
  final NotesLocalDataSource localDataSource;

  NotesRepositoryImpl({
    required this.remoteDataSource,
    required this.localDataSource,
  });

  @override
  Future<Either<Failure, List<Note>>> getAllNotes() async {
    try {
      final remoteNotes = await remoteDataSource.getAllNotes();
      await localDataSource.cacheNotes(remoteNotes);
      return Right(remoteNotes);
    } catch (_) {
      try {
        final localNotes = await localDataSource.getCachedNotes();
        return Right(localNotes);
      } catch (e) {
        return Left(CacheFailure());
      }
    }
  }

  @override
  Future<Either<Failure, void>> addNote(Note note) async {
    try {
      final noteModel = NoteModel(
        id: note.id,
        title: note.title,
        content: note.content,
        createdAt: note.createdAt,
      );
      await remoteDataSource.addNote(noteModel);
      await localDataSource.addNote(noteModel);
      return const Right(null);
    } catch (e) {
      return Left(ServerFailure());
    }
  }

  @override
  Future<Either<Failure, void>> deleteNote(int id) async {
    try {
      await remoteDataSource.deleteNote(id);
      await localDataSource.deleteNote(id);
      return const Right(null);
    } catch (e) {
      return Left(ServerFailure());
    }
  }
}
