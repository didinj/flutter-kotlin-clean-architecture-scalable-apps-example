package com.example.flutter_clean_arch_notes.feature_note.domain.usecase

import com.example.flutter_clean_arch_notes.feature_note.domain.repository.NotesRepository

class DeleteNoteUseCase(private val repository: NotesRepository) {
    suspend operator fun invoke(noteId: Int) {
        repository.deleteNote(noteId)
    }
}