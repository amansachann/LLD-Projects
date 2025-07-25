package com.codewithaman.appender;

import com.codewithaman.LogMessage;

public interface LogAppender {
    void append(LogMessage message);
}
