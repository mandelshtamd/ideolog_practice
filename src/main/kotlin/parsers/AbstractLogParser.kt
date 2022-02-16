package parsers

import entities.Log
import java.io.File
import java.io.FileNotFoundException

abstract class AbstractLogParser(val filePath: String) {
    fun parseFile(): List<Log> {
        val logsList: MutableList<Log> = mutableListOf()

        if (!File(filePath).exists()) {
            throw FileNotFoundException(filePath)
        }

        File(filePath).forEachLine {
            val log = parseLog(it)
            logsList.add(log)
        }

        return logsList
    }

    abstract fun parseLog(logString: String): Log
}