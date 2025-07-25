package com.codewithaman;

import com.codewithaman.appender.LogAppender;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Logger {

    private LogLevel minLevel;
    private final List<LogAppender> appenders;
    private final ExecutorService executor;

    public Logger(LogLevel level, List<LogAppender> appenders) {
        this.minLevel = level;
        this.appenders = appenders;
        executor = Executors.newSingleThreadExecutor();
    }

    private void log(LogLevel level, String message) {
        if(!level.isAsSevereAs(minLevel)) return;
        LogMessage logMessage = new LogMessage(level, message);
        executor.submit(() -> appenders.forEach(a -> a.append(logMessage)));
    }

    public LogLevel getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(LogLevel minLevel) {
        this.minLevel = minLevel;
    }

    public void shutdown() {
        executor.shutdown();
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }
    public void info(String message) {
        log(LogLevel.INFO, message);
    }
    public void warn(String message) {
        log(LogLevel.WARN, message);
    }
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
