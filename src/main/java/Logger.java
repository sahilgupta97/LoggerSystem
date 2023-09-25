import abstractLogger.AbstractLogger;
import enums.LoggerLevel;
import factory.LoggerFactory;
import java.io.Serializable;
import loggerSinks.LogPublisher;

public class Logger implements Cloneable, Serializable {
  private static Logger logger;
  private static AbstractLogger abstractLogger;
  private static LogPublisher logMessagePublisher;

  private Logger() {

  }

  public static Logger getLogger() {
    if(logger == null) {
      synchronized (Logger.class) {
        if(logger == null) {
          logger = new Logger();
          abstractLogger = LoggerFactory.buildLoggerChain();
          logMessagePublisher = LoggerFactory.buildLogMessagePublisher();
        }
      }
    }

    return logger;
  }

  public void info(String message) {
    log(LoggerLevel.INFO, message);
  }

  public void error(String message) {
    log(LoggerLevel.ERROR, message);
  }

  public void debug(String message) {
    log(LoggerLevel.DEBUG, message);
  }

  private void log(LoggerLevel loggerLevel, String message) {
    abstractLogger.logMessage(loggerLevel, message);
    logMessagePublisher.notifyAllObservers(loggerLevel, message);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  protected Object readResolve() {
    return logger;
  }
}
