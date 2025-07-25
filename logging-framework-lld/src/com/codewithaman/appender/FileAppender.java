package com.codewithaman.appender;

import com.codewithaman.LogMessage;
import com.codewithaman.formatter.LogFormatter;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender {
    private FileWriter writer;
    private LogFormatter logFormatter;

    public FileAppender(String filePath, LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
        try {
            this.writer = new FileWriter(filePath, true);
        } catch (Exception e) {
            System.out.println("Failed to create a file writer");
        }
    }

    @Override
    public void append(LogMessage message) {
        try {
            writer.write(logFormatter.format(message) + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
