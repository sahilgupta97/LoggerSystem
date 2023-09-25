package factory;

import abstractLogger.AbstractLogger;
import abstractLogger.DebugLogger;
import abstractLogger.ErrorLogger;
import abstractLogger.InfoLogger;
import enums.LoggerLevel;
import loggerSinks.ConsoleLogSink;
import loggerSinks.FileLogSink;
import loggerSinks.LogPublisher;

public class LoggerFactory {

  /**
   * info = info, error
   * error = error
   * debug = info error debug
   * @return
   */
  public static AbstractLogger buildLoggerChain() {
    AbstractLogger errorLogger = new ErrorLogger();
    AbstractLogger infoLogger = new InfoLogger();
    AbstractLogger debugLogger = new DebugLogger();

    debugLogger.setNextLogger(errorLogger);
    errorLogger.setNextLogger(infoLogger);

    return debugLogger;
  }

  public static LogPublisher buildLogMessagePublisher() {
    LogPublisher logPublisher = new LogPublisher();

    ConsoleLogSink consoleLogSink = new ConsoleLogSink();
    FileLogSink fileLogSink = new FileLogSink();

    logPublisher.registerObserver(LoggerLevel.INFO, consoleLogSink);

    logPublisher.registerObserver(LoggerLevel.DEBUG, consoleLogSink);

    logPublisher.registerObserver(LoggerLevel.ERROR, consoleLogSink);
    logPublisher.registerObserver(LoggerLevel.ERROR, fileLogSink);

    return logPublisher;
  }
}
