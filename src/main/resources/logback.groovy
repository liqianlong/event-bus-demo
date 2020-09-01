import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter

import static ch.qos.logback.classic.Level.*

statusListener(OnConsoleStatusListener)

def PATTERN = "%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50}.%M\\(%line\\) - %msg%n"

def PATH = "/export/Logs/event-bus-demo/"


appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = PATTERN
    }
}

appender("FILE-ALL", RollingFileAppender) {
    file = "${PATH}/file-all.log"
    append = false
    encoder(PatternLayoutEncoder) {
        pattern = PATTERN
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${PATH}/file-all.log.%d"
        maxHistory = 1
    }
}

appender("FILE-ERROR", RollingFileAppender) {
    file = "${PATH}/file-error.log"
    append = false
    encoder(PatternLayoutEncoder) {
        pattern = PATTERN
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "${PATH}/file-error.log.%d"
        maxHistory = 1
    }
    filter(ThresholdFilter) {
        level = WARN
    }
}

root(INFO, ["CONSOLE", "FILE-ALL", "FILE-ERROR"])