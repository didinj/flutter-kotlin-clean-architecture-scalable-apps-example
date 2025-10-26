package com.example.flutter_clean_arch_notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.flutter_clean_arch_notes.feature_note.presentation.ui.NotesApp
import com.example.flutter_clean_arch_notes.feature_note.presentation.ui.theme.NotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesAppTheme {
                NotesApp()
            }
        }
    }
}