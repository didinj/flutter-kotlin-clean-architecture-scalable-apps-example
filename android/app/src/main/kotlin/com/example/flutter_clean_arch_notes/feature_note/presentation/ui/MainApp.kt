package com.example.flutter_clean_arch_notes.feature_note.presentation.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flutter_clean_arch_notes.feature_note.presentation.ui.navigation.Screen
import com.example.flutter_clean_arch_notes.feature_note.presentation.ui.notes.AddNoteScreen
import com.example.flutter_clean_arch_notes.feature_note.presentation.ui.notes.NotesListScreen
import com.example.flutter_clean_arch_notes.feature_note.domain.model.Note

@Composable
fun NotesApp(viewModel: NotesViewModel = viewModel()) {
    val navController = rememberNavController()
    val notes = viewModel.notes

    NavHost(navController = navController, startDestination = Screen.NotesList.route) {
        composable(Screen.NotesList.route) {
            NotesListScreen(
                notes = notes,
                onAddNoteClick = { navController.navigate(Screen.AddNote.route) },
                onDeleteNoteClick = { viewModel.deleteNote(it) }
            )
        }

        composable(Screen.AddNote.route) {
            AddNoteScreen(
                onBackClick = { navController.popBackStack() },
                onSaveNote = {
                    viewModel.addNote(Note(title = it, content = ""))
                    navController.popBackStack()
                }
            )
        }
    }
}
