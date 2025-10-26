package com.example.flutter_clean_arch_notes.feature_note.presentation.ui.notes

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(
    navController: NavController,
    onSaveNote: (String) -> Unit
) {
    var title by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Note") },
    navigationIcon = {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
        }
    }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { if (title.isNotBlank()) onSaveNote(title) },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Save Note")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Note title") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
