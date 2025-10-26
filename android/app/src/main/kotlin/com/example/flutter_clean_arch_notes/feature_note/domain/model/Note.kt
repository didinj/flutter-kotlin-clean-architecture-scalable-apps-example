package com.example.flutter_clean_arch_notes.feature_note.domain.model

data class Note(
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)