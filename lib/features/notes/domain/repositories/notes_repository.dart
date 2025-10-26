import 'package:dartz/dartz.dart';
import '../../../../core/error/failures.dart';
import '../entities/note.dart';

abstract class NotesRepository {
  Future<Either<Failure, List<Note>>> getAllNotes();
  Future<Either<Failure, void>> addNote(Note note);
  Future<Either<Failure, void>> deleteNote(int id);
}
