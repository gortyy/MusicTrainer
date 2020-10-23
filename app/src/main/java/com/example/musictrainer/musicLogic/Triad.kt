package com.example.musictrainer.musicLogic

object Triad {
    fun major(startingNote: Note): List<Note> {
        return listOf(startingNote, startingNote.majorThirdUp(), startingNote.perfectFifthUp())
    }

    fun minor(startingNote: Note): List<Note> {
        return listOf(startingNote, startingNote.minorThirdUp(), startingNote.perfectFifthUp())
    }

    fun diminished(startingNote: Note): List<Note> {
        return listOf(startingNote, startingNote.minorThirdUp(), startingNote.tritoneUp())
    }

    fun augmented(startingNote: Note): List<Note> {
        return listOf(startingNote, startingNote.majorThirdUp(), startingNote.minorSixthUp())
    }
}