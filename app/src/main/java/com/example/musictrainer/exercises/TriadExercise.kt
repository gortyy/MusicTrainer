package com.example.musictrainer.exercises

import com.example.musictrainer.musicLogic.Note
import com.example.musictrainer.musicLogic.Triad

object TriadExercise: Exercise {
    private val circleOfFifthNotes = listOf("C", "F", "Bb", "Eb", "Ab", "Db", "F#", "B", "E", "A", "D", "G")
    private val triadTypes = listOf("major", "minor", "diminished", "augmented")
    private val inversions = listOf("root", "first", "second")

    override fun getQA(): QuestionAnswer {
        val note = circleOfFifthNotes.random()
        val triadType = triadTypes.random()
        val inversion = inversions.random()

        val inversionString = when(inversion) {
            "root" -> "position"
            else -> "inversion"
        }
        val question = "$note $triadType triad in $inversion $inversionString"
        val answer = triadMapping(note, triadType, inversion)

        return QuestionAnswer(question, answer)
    }

    override fun category(): String {
        return "Triads in all inversions"
    }

    private fun triadMapping(note: String, triadType: String, inversion: String): String {
        val useFlats = when(note) {
            "C", "F", "Bb", "Eb", "Ab", "Db", "Gb" -> true
            else -> false
        }
        val startingNote = Note(note, useFlats)
        val triad = when(triadType) {
            "major" -> Triad.major(startingNote)
            "minor" -> Triad.minor(startingNote)
            "diminished" -> Triad.diminished(startingNote)
            else -> Triad.augmented(startingNote)
        }

        return when(inversion) {
            "root" -> triad.joinToString()
            "first" -> listOf(triad[1], triad[2], triad[0]).joinToString()
            else -> listOf(triad[2], triad[0], triad[1]).joinToString()
        }
    }



}