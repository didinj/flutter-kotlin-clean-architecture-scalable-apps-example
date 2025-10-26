package com.example.flutter_clean_arch_notes.feature_note.presentation.ui.notes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flutter_clean_arch_notes.feature_note.domain.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesListScreen(
    notes: List<Note>,
    onAddNoteClick: () -> Unit,
    onDeleteNoteClick: (Note) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("My Notes") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddNoteClick) {
                Icon(Icons.Default.Add, contentDescription = "Add Note")
            }
        }
    ) { padding ->
        if (notes.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("No notes yet. Tap + to add one.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(notes) { note ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(note.title, style = MaterialTheme.typography.titleMedium)
                            IconButton(onClick = { onDeleteNoteClick(note) }) {
                                Icon(Icons.Default.Delete, contentDescription = "Delete Note")
                            }
                        }
                    }
                }
            }
        }
    }
}
