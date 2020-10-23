package com.example.musictrainer.musicLogic

class Note(var n: String, private val useFlats: Boolean) {
    private val allNotesFlats = listOf("Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G")
    private val allNotesSharps = listOf("A","A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
    private val allNotes = if (useFlats) allNotesFlats else allNotesSharps

    init {
        if (!allNotes.contains(n)) {
            throw NoSuchFieldException("Invalid note $n")
        }
    }


    private fun down(interval: Int): Note {
        var index = allNotes.indexOf(n)
        if (index - interval <= 0) {
            index += allNotes.size
        }
        return Note(allNotes[index - interval], useFlats)
    }

    private fun up(interval: Int): Note {
        var index = allNotes.indexOf(n)
        if (index + interval >= allNotes.size) {
            index -= allNotes.size
        }
        return Note(allNotes[index + interval], useFlats)
    }

    fun halfStepUp() = up(1)
    fun stepUp() = up(2)
    fun minorThirdUp() = up(3)
    fun majorThirdUp() = up(4)
    fun perfectFourthUp() = up(5)
    fun tritoneUp() = up(6)
    fun perfectFifthUp() = up(7)
    fun minorSixthUp() = up(8)
    fun majorSixthUp() = up(9)
    fun minorSeventhUp() = up(10)
    fun majorSeventhUp() = up(11)
    fun octaveUp() = up(12)


    fun halfStepDown() = down(1)
    fun stepDown() = down(2)
    fun minorThirdDown() = down(3)
    fun majorThirdDown() = down(4)
    fun perfectFourthDown() = down(5)
    fun tritoneDown() = down(6)
    fun perfectFifthDown() = down(7)
    fun minorSixthDown() = down(8)
    fun majorSixthDown() = down(9)
    fun minorSeventhDown() = down(10)
    fun majorSeventhDown() = down(11)
    fun octaveDown() = down(12)

    override fun toString(): String {
        return n
    }
}