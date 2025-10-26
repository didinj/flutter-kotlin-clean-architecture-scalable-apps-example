import 'package:dartz/dartz.dart';
import '../../../../core/error/failures.dart';
import '../../../../core/usecases/usecase.dart';
import '../entities/note.dart';
import '../repositories/notes_repository.dart';

class AddNote extends UseCase<void, Note> {
  final NotesRepository repository;

  AddNote(this.repository);

  @override
  Future<Either<Failure, void>> call(Note note) async {
    return await repository.addNote(note);
  }
}
