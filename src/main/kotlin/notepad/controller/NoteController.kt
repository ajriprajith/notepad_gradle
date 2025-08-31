package com.prajith.notepad.controller

import com.prajith.notepad.dto.noteRequest
import com.prajith.notepad.model.notes
import com.prajith.notepad.service.NoteService
import org.springframework.web.bind.annotation.*
import com.prajith.notepad.dto.noteResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api/notes")
class NoteController(private val noteService: NoteService) {

    @GetMapping
    fun getAllNotes(): List<noteResponse> = noteService.getAllNotes()

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable id: String): noteResponse? =
        noteService.getNoteById(id)

    @PostMapping

    fun createNote(@Valid @RequestBody request: noteRequest): ResponseEntity<noteResponse> {
        val created = noteService.createNote(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(created)
    }


    @PutMapping("/{id}")
    fun updateNote(@PathVariable id: String, @Valid @RequestBody request: noteRequest): noteResponse? =
        noteService.updateNote(id, request)


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteNote(@PathVariable id: String) =
        noteService.deleteNote(id)
}