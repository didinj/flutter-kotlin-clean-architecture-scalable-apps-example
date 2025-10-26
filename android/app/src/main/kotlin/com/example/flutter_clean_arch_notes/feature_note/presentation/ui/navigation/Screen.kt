package com.example.flutter_clean_arch_notes.feature_note.presentation.ui.navigation

sealed class Screen(val route: String) {
    object NotesList : Screen("notes_list")
    object AddNote : Screen("add_note")
}