# Logging Framework (LLD)

## Problem Statement
Design and implement a flexible and extensible logging framework that can be used by applications to log messages at different levels (INFO, DEBUG, ERROR, etc.), support multiple output destinations (console, file, etc.), and allow for custom formatting of log messages.

---

## Flow
1. Application -> Logger with the log level
2. Logger:
   - Check the configured level < passed level by user 
   - if yes -> proceed
   - if no -> ignore that log message
3. Formatter:
    - Converts the message to desired format [LOG LEVEL] - [TIMESTAMP] - Message
4. Appenders:
   - ConsoleAppender -> prints the log messages to the console
   - FileAppender -> writes the logs to a log file

---

## Requirements:
- Support multiple log levels 
- Support multiple appenders
- Support custom formatting
- User -> configure log levels, appenders, formatting
- Thread Safety
- Extensible: Easy to add -> log level, appender, formatting strategy 

--- 
## Actors:
**Primary Actors:**
- User / Developer
- Application Code

**Secondary Actors:**
- Logger
- Appender
- Formatter
- ConfigurationManager

--- 
## Use case diagram
**Developer/User**
- Log Messge
- Configure Logger -> Add log destination (configure appenders)
- Define Log Format

**Logger**
- Display log -> check config level -> print or ignore message

---
## Entities:
- User {Client}
- Logger 
- LogLevel (enum) -> DEBUG, INFO, WARN, ERROR, FATAL
- LogFormatter (I) -> DefaultFormatterStrategy, some other strategy (extensible)
- LogAppender (I) -> ConsoleAppenderStrategy , FileAppenderStrategy, RemoteAppenderStrategy, DbAppenderStrategy, etc 
- LoggerConfig
- LogMessage 

----
## Design Pattern
1. Singleton Pattern - Logger
   - Global access point
   - Consistency > chaos
   - Thread safety - Bill Pugh Singleton
   - Avoids redundancy
   - Easy to extend and maintain
2. StrategyPattern
    - Log Formatting Strategies
    - Log Appending Strategies
3. Builder Pattern
    - Log Manager -- prevent constructor explosion