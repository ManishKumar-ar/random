package com.example.dbroom.viewModel

import androidx.room.Delete
import androidx.room.Query
import com.example.dbroom.roomDb.Note
import com.example.dbroom.roomDb.NoteDatabase

class Repository(private val db: NoteDatabase) {

    suspend fun upsertNote(note: Note){
        db.dao.upsertNote(note)
    }

    suspend fun deleteNote(note: Note){
        db.dao.deleteNote(note)
    }

    fun getAllNotes() = db.dao.getAllNotes()
}