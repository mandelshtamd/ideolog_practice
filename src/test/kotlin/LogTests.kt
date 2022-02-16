import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import parsers.LogParser

internal class LogTests {

    @Test
    fun getTopTenThreadsTest() {
        val answer = """hz.gifted_pare.priority-generic-operation.thread-0 2490
hz.serene_heisenberg.priority-generic-operation.thread-0 1952
hz.serene_heisenberg.generic-operation.thread-15 291
hz.serene_heisenberg.generic-operation.thread-0 285
jettyThreadPool-180 52
jettyThreadPool-184 46
jettyThreadPool-185 44
jettyThreadPool-181 43
jettyThreadPool-179 37
jettyThreadPool-183 37
       """.trimIndent()

        val logs = LogParser("src\\main\\resources\\hz_all_nodes.log").parseFile()
        val topN = LogsAnalyzer.findTopNThreads(logs).joinToString(separator = "\n") { "${it.first} ${it.second}" }

        Assertions.assertEquals(answer, topN)
    }
}