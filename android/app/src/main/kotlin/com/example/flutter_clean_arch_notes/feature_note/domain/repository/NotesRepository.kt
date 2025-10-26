package com.example.flutter_clean_arch_notes.feature_note.domain.repository

import kotlinx.coroutines.flow.Flow
import com.example.flutter_clean_arch_notes.feature_note.domain.model.Note

/**
 * NotesRepository defines the abstract contract for
 * all data operations related to notes.
 *
 * The Domain layer depends on this interface, not on
 * any concrete data implementation (like Room or Retrofit).
 */
interface NotesRepository {

    /**
     * Fetch all notes from the data source.
     * Returns a Flow that emits updates whenever data changes.
     */
    fun getAllNotes(): Flow<List<Note>>

    /**
     * Add or update a note in the data source.
     */
    suspend fun addNote(note: Note)

    /**
     * Delete a note by its ID.
     */
    suspend fun deleteNote(noteId: Int)
}
