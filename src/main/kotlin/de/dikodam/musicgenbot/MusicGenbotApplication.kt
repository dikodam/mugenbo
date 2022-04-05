package de.dikodam.musicgenbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MusicGenbotApplication

fun main(args: Array<String>) {
	runApplication<MusicGenbotApplication>(*args)
}
