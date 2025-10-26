import 'package:flutter/foundation.dart';
import 'package:flutter_clean_arch_notes/core/usecases/usecase.dart';
import 'package:flutter_clean_arch_notes/features/notes/domain/entities/note.dart';
import 'package:flutter_clean_arch_notes/features/notes/domain/usecases/add_note.dart';
import 'package:flutter_clean_arch_notes/features/notes/domain/usecases/delete_note.dart';
import 'package:flutter_clean_arch_notes/features/notes/domain/usecases/get_all_notes.dart';

class NotesViewModel extends ChangeNotifier {
  final GetAllNotes getNotesUseCase;
  final AddNote addNoteUseCase;
  final DeleteNote deleteNoteUseCase;

  List<Note> _notes = [];
  List<Note> get notes => _notes;

  NotesViewModel({
    required this.getNotesUseCase,
    required this.addNoteUseCase,
    required this.deleteNoteUseCase,
  });

  Future<void> loadNotes() async {
    _notes = (await getNotesUseCase(NoParams())) as List<Note>;
    notifyListeners();
  }

  Future<void> addNote(Note note) async {
    await addNoteUseCase(note);
    _notes.add(note);
    notifyListeners();
  }

  Future<void> deleteNote(Note note) async {
    await deleteNoteUseCase(note as int);
    _notes.removeWhere((n) => n.id == note.id);
    notifyListeners();
  }
}
