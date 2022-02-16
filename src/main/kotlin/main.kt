import parsers.LogParser
import java.io.FileNotFoundException
import java.nio.file.FileSystems

val fileSeparator = FileSystems.getDefault().separator
val defaultFilePath = "src${fileSeparator}main${fileSeparator}resources${fileSeparator}hz_all_nodes.log"

fun main(args: Array<String>) {
    try {
        val parsedLogs = LogParser(defaultFilePath).parseFile()
        val topNThreads = LogsAnalyzer.findTopNThreads(parsedLogs)

        topNThreads.forEach{
            println("${it.first} ${it.second}")
        }
    } catch(ex: FileNotFoundException) {
        println(ex.message)
    } catch(ex: Exception) {
        println(ex.message)
        println(ex.stackTrace)
    }
}