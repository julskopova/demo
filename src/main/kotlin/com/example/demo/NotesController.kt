package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

data class NoteDto(val id: Long?, val text: String)

@RestController
class NotesController(
    private val noteRepository: NoteRepository
) {
    @GetMapping("/notes")
    fun list(): List<NoteDto> =
        noteRepository.findAll().map { NoteDto(it.id, it.text) }
}
