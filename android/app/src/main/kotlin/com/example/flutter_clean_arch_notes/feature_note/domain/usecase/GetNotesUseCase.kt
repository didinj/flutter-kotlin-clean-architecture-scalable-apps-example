package com.example.flutter_clean_arch_notes.feature_note.domain.usecase

import com.example.flutter_clean_arch_notes.feature_note.domain.model.Note
import com.example.flutter_clean_arch_notes.feature_note.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(private val repository: NotesRepository) {
    operator fun invoke(): Flow<List<Note>> = repository.getAllNotes()
}