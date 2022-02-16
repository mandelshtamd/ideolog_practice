import entities.Log

object LogsAnalyzer {
    fun findTopNThreads(logs: List<Log>, num: Int = 10): List<Pair<String, Int>> {
        return logs
            .asSequence()
            .map { it.thread }
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedByDescending { it.second }
            .take(num)
    }
}