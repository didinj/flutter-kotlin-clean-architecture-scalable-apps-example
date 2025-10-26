package com.example.flutter_clean_arch_notes.feature_note.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.flutter_clean_arch_notes.feature_note.domain.usecase.AddNoteUseCase
import com.example.flutter_clean_arch_notes.feature_note.domain.usecase.DeleteNoteUseCase
import com.example.flutter_clean_arch_notes.feature_note.domain.usecase.GetNotesUseCase
import com.example.flutter_clean_arch_notes.feature_note.domain.model.Note
import com.example.flutter_clean_arch_notes.feature_note.domain.repository.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class NotesViewModel(
    repository: NotesRepository
) : ViewModel() {

    // ✅ Instantiate use cases with repository
    private val getNotesUseCase = GetNotesUseCase(repository)
    private val addNoteUseCase = AddNoteUseCase(repository)
    private val deleteNoteUseCase = DeleteNoteUseCase(repository)

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    init {
        // Load initial notes
        viewModelScope.launch {
            getNotesUseCase().collectLatest { notesList ->
                _notes.value = notesList
            }
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            addNoteUseCase(note)
        }
    }

    fun deleteNote(id: Int) {
        viewModelScope.launch {
            deleteNoteUseCase(id)
        }
    }
}
