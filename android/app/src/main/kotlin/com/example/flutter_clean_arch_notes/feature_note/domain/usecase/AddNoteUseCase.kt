package com.example.flutter_clean_arch_notes.feature_note.domain.usecase

import com.example.flutter_clean_arch_notes.feature_note.domain.model.Note
import com.example.flutter_clean_arch_notes.feature_note.domain.repository.NotesRepository

class AddNoteUseCase(private val repository: NotesRepository) {
    suspend operator fun invoke(note: Note) {
        repository.addNote(note)
    }
}