package com.prajith.notepad.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
data class notes(
    @Id
    val id: String? = null,
    val title: String,
    val content: String,
    val createdAt: Instant

)