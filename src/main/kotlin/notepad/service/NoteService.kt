package com.prajith.notepad.service

import com.prajith.notepad.dto.noteRequest
import com.prajith.notepad.dto.noteResponse
import com.prajith.notepad.model.notes
import com.prajith.notepad.repository.NoteRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class NoteService(private val noteRepository: NoteRepository) {

    fun getAllNotes(): List<noteResponse> =
        noteRepository.findAll().map { note ->
            noteResponse(
                id = note.id ?: "",
                title = note.title,
                content = note.content,
                createdAt = note.createdAt
            )
        }
    fun getNoteById(id: String): noteResponse? =
        noteRepository.findById(id).orElse(null)?.let {
            noteResponse(
                id = it.id ?: "",
                title = it.title,
                content = it.content,
                createdAt = it.createdAt
            )
        }
    fun createNote(request: noteRequest): noteResponse {
        val now = Instant.now()
        val note = notes(
            title = request.title,
            content = request.content,
            createdAt = now
        )
        val saved = noteRepository.save(note)
        return noteResponse(
            id = saved.id ?: "",
            title = saved.title,
            content = saved.content,
            createdAt = saved.createdAt
        )
    }
    fun updateNote(id: String, request: noteRequest): noteResponse? {
        val existing = noteRepository.findById(id).orElse(null)
        return existing?.let {
            val updated = it.copy(
                title = request.title,
                content = request.content
            )
            val saved = noteRepository.save(updated)
            noteResponse(
                id = saved.id ?: "",
                title = saved.title,
                content = saved.content,
                createdAt = saved.createdAt
            )
        }
    }
    fun deleteNote(id: String) {
        noteRepository.deleteById(id)
    }
}
