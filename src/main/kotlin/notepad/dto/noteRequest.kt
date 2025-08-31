package com.prajith.notepad.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class noteRequest (

    @field:NotBlank(message = "title cannot be blank")
    @field:Size(max = 100,message = "max size of 100 char")
    val title: String,

    @field:NotBlank(message = "Content cannot be empty")
    @field:Size(max = 1000, message = "Content cannot exceed 1000 characters")
    val content: String
)