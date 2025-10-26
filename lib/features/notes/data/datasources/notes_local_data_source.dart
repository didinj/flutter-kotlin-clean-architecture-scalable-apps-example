import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';
import '../models/note_model.dart';

abstract class NotesLocalDataSource {
  Future<List<NoteModel>> getCachedNotes();
  Future<void> cacheNotes(List<NoteModel> notes);
  Future<void> addNote(NoteModel note);
  Future<void> deleteNote(int id);
}

class NotesLocalDataSourceImpl implements NotesLocalDataSource {
  static const tableName = 'notes';
  late Database _db;

  Future<void> _initDB() async {
    final path = join(await getDatabasesPath(), 'notes.db');
    _db = await openDatabase(
      path,
      version: 1,
      onCreate: (db, version) {
        return db.execute(
          'CREATE TABLE $tableName(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, createdAt TEXT)',
        );
      },
    );
  }

  @override
  Future<List<NoteModel>> getCachedNotes() async {
    await _initDB();
    final maps = await _db.query(tableName);
    return List.generate(maps.length, (i) => NoteModel.fromJson(maps[i]));
  }

  @override
  Future<void> cacheNotes(List<NoteModel> notes) async {
    await _initDB();
    await _db.delete(tableName);
    for (final note in notes) {
      await _db.insert(tableName, note.toJson());
    }
  }

  @override
  Future<void> addNote(NoteModel note) async {
    await _initDB();
    await _db.insert(tableName, note.toJson());
  }

  @override
  Future<void> deleteNote(int id) async {
    await _initDB();
    await _db.delete(tableName, where: 'id = ?', whereArgs: [id]);
  }
}
