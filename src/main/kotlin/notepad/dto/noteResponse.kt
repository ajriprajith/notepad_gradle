package com.prajith.notepad.dto

import org.springframework.data.annotation.Id
import java.time.Instant


data class noteResponse (

        @Id
        val id: String ?= null,
        val title: String,
        val content: String,
        val createdAt: Instant
)