package com.example.flutter_clean_arch_notes.feature_note.presentation.ui.notes

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.flutter_clean_arch_notes.feature_note.domain.model.Note
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotesListScreenTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun notesList_displaysNotesProperly() {
        val notes = listOf(
            Note(1, "First", ""),
            Note(2, "Second", "")
        )

        composeRule.setContent {
            NotesListScreen(
                notes = notes,
                onAddNoteClick = {},
                onDeleteNoteClick = {}
            )
        }

        composeRule.onNodeWithText("First").assertIsDisplayed()
        composeRule.onNodeWithText("Second").assertIsDisplayed()
    }

    @Test
    fun addButton_existsAndClickable() {
        composeRule.setContent {
            NotesListScreen(
                notes = emptyList(),
                onAddNoteClick = {},
                onDeleteNoteClick = {}
            )
        }

        composeRule.onNodeWithContentDescription("Add Note").assertExists()
    }
}
