package entities

data class Log(
    val date: String,
    val url: String,
    val logLevel: LogLevel,
    val loggingClass: String,
    val thread: String
)