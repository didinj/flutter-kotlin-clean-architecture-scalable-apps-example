import 'package:dio/dio.dart';
import '../models/note_model.dart';

abstract class NotesRemoteDataSource {
  Future<List<NoteModel>> getAllNotes();
  Future<void> addNote(NoteModel note);
  Future<void> deleteNote(int id);
}

class NotesRemoteDataSourceImpl implements NotesRemoteDataSource {
  final Dio client;

  NotesRemoteDataSourceImpl({required this.client});

  @override
  Future<List<NoteModel>> getAllNotes() async {
    final response = await client.get('https://api.example.com/notes');
    if (response.statusCode == 200) {
      final data = response.data as List;
      return data.map((json) => NoteModel.fromJson(json)).toList();
    } else {
      throw Exception('Failed to load notes');
    }
  }

  @override
  Future<void> addNote(NoteModel note) async {
    await client.post('https://api.example.com/notes', data: note.toJson());
  }

  @override
  Future<void> deleteNote(int id) async {
    await client.delete('https://api.example.com/notes/$id');
  }
}
