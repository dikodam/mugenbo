package de.dikodam.musicgenbot.service

import de.dikodam.musicgenbot.lilypond.model.*
import de.dikodam.musicgenbot.lilypond.model.PrimitiveDuration.HALF
import de.dikodam.musicgenbot.lilypond.model.PrimitiveDuration.QUARTER
import de.dikodam.musicgenbot.lilypond.model.PrimitivePitch.*
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Paths

private const val relative = "\\relative "

fun printMusicAtCwd() {
    val cwd = Paths.get("").toAbsolutePath().toString()

    val music = listOf(
        Note(Pitch(C), NoteDuration(QUARTER)),
        Note(Pitch(C), NoteDuration(QUARTER)),
        Note(Pitch(G), NoteDuration(QUARTER)),
        Note(Pitch(G), NoteDuration(QUARTER)),
        Note(Pitch(A), NoteDuration(QUARTER)),
        Note(Pitch(A), NoteDuration(QUARTER)),
        Note(Pitch(G), NoteDuration(HALF)),
        Note(Pitch(R), NoteDuration(HALF))
    ).joinToString(separator = " ")

    FileOutputStream(cwd + File.separator + "output.ly", false)
        .use { fos ->
            fos.writer().use {
                it.write(relative)
                it.write("c'' ")
                it.write("{ $music }")
            }
        }

}