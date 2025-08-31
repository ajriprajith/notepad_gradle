package com.prajith.notepad.repository

import com.prajith.notepad.model.notes
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : MongoRepository<notes, String>
