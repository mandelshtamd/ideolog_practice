package parsers

import entities.Log
import toLogLevel
import java.lang.IndexOutOfBoundsException

class LogParser(filePath: String) : AbstractLogParser(filePath) {
    override fun parseLog(logString: String): Log {
        try {
            val splittedLogString = logString.split("\t")

            return Log(
                date = splittedLogString[0],
                url = splittedLogString[1],
                logLevel = splittedLogString[2].toLogLevel(),
                loggingClass = splittedLogString[3],
                thread = splittedLogString[4]
            )
        } catch(ex: IndexOutOfBoundsException) {
            throw IllegalArgumentException("Unsupported log structure")
        }
    }
}