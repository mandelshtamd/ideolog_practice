import parsers.LogParser
import java.io.FileNotFoundException

const val defaultFilePath = "src\\main\\resources\\hz_all_nodes.log"

fun main(args: Array<String>) {
    try {
        val parsedLogs = LogParser(defaultFilePath).parseFile()
        val topNThreads = LogsAnalyzer.findTopNThreads(parsedLogs)

        topNThreads.forEach{
            println("${it.first} ${it.second}")
        }
    } catch(ex: FileNotFoundException) {
        println(ex.message)
    }
}