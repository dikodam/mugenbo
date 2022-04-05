package de.dikodam.musicgenbot.lilypond.model

import de.dikodam.musicgenbot.lilypond.model.Accidental.NATURAL

data class Note(val pitch: Pitch, val duration: NoteDuration) {
    override fun toString(): String =
        pitch.toString() + duration.toString()
}

data class NoteDuration(val primitiveDuration: PrimitiveDuration, val dotCount: Int = 0) {
    override fun toString(): String =
        primitiveDuration.toString() + ".".repeat(dotCount)
}

enum class PrimitiveDuration(val notation: String) {
    WHOLE("1"),
    HALF("2"),
    QUARTER("4"),
    EIGHTH("8"),
    SIXTEENTH("16"),
    THIRTY_SECOND("32");

    override fun toString(): String = notation
}

data class Pitch(val pitch: PrimitivePitch, val accidental: Accidental = NATURAL) {
    override fun toString(): String = pitch.toString() + accidental.toString()
}

enum class PrimitivePitch {
    C, D, E, F, G, A, B, R;

    override fun toString(): String = name.lowercase()
}

enum class Accidental(val notation: String) {
    DOUBLE_FLAT("eses"), FLAT("es"), NATURAL(""), SHARP("is"), DOUBLE_SHARP("isis");

    override fun toString(): String = notation
}