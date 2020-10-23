package com.example.musictrainer.musicLogic

object TwoFiveOne {
    fun major(startingNote: Note): List<List<Note>> {
        return listOf(
            Triad.minor(startingNote.stepUp()),
            Triad.major(startingNote.perfectFifthUp()),
            Triad.major(startingNote)
        )
    }

    fun minor(startingNote: Note): List<List<Note>> {
        return listOf(
            Triad.diminished(startingNote.stepUp()),
            Triad.major(startingNote.perfectFifthUp()),
            Triad.minor(startingNote)
        )
    }
}