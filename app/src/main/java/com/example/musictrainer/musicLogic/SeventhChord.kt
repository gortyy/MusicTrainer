package com.example.musictrainer.musicLogic

object SeventhChord {
    fun major(startingNote: Note): List<Note> {
        return listOf(
            startingNote,
            startingNote.majorThirdUp(),
            startingNote.perfectFifthUp(),
            startingNote.majorSeventhUp()
        )
    }
    fun minor(startingNote: Note): List<Note> {
        return listOf(
            startingNote,
            startingNote.minorThirdUp(),
            startingNote.perfectFifthUp(),
            startingNote.minorSeventhUp()
        )
    }
    fun dominant(startingNote: Note): List<Note> {
        return listOf(
            startingNote,
            startingNote.majorThirdUp(),
            startingNote.perfectFifthUp(),
            startingNote.minorSeventhUp()
        )
    }
}