import entities.LogLevel

fun String.toLogLevel(): LogLevel {
    return when(this) {
        LogLevel.ALL.toString() -> LogLevel.ALL
        LogLevel.DEBUG.toString() -> LogLevel.DEBUG
        LogLevel.ERROR.toString() -> LogLevel.ERROR
        LogLevel.FATAL.toString() -> LogLevel.FATAL
        LogLevel.INFO.toString() -> LogLevel.INFO
        LogLevel.WARN.toString() -> LogLevel.WARN
        LogLevel.TRACE.toString() -> LogLevel.TRACE
        else -> LogLevel.UNKNOWN
    }
}