import 'package:get_it/get_it.dart';

final sl = GetIt.instance;

Future<void> init() async {
  // Register Blocs
  // sl.registerFactory(() => NotesBloc(getAllNotes: sl(), addNote: sl()));

  // Register Use Cases
  // sl.registerLazySingleton(() => GetAllNotes(repository: sl()));
  // sl.registerLazySingleton(() => AddNote(repository: sl()));

  // Register Repository
  // sl.registerLazySingleton<NotesRepository>(() => NotesRepositoryImpl(
  // remoteDataSource: sl(),
  // localDataSource: sl(),
  // ));

  // Register Data Sources
  // sl.registerLazySingleton<NotesRemoteDataSource>(() => NotesRemoteDataSourceImpl(client: sl()));
  // sl.registerLazySingleton<NotesLocalDataSource>(() => NotesLocalDataSourceImpl(database: sl()));

  // External dependencies
  // sl.registerLazySingleton(() => Dio());
}
