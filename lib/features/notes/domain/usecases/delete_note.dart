import 'package:dartz/dartz.dart';
import '../../../../core/error/failures.dart';
import '../../../../core/usecases/usecase.dart';
import '../repositories/notes_repository.dart';

class DeleteNote extends UseCase<void, int> {
  final NotesRepository repository;

  DeleteNote(this.repository);

  @override
  Future<Either<Failure, void>> call(int id) async {
    return await repository.deleteNote(id);
  }
}
