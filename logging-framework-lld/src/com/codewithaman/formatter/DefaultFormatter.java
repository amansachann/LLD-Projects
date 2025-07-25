package com.codewithaman.formatter;

import com.codewithaman.LogMessage;

public class DefaultFormatter implements LogFormatter {
    @Override
    public String format(LogMessage message) {
        return String.format("[%s] [%s] [%s]: %s",
                message.getTimestamp().toString(),
                message.getLevel().toString(),
                message.getThreadName(),
                message.getMessage());
    }
}
