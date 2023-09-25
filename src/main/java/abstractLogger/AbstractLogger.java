package abstractLogger;

import enums.LoggerLevel;

public abstract class AbstractLogger {
  LoggerLevel loggerLevel;
  AbstractLogger nextLogger;

  public void setNextLogger(AbstractLogger nextLogger) {
    this.nextLogger = nextLogger;
  }

  public void logMessage(LoggerLevel loggerLevel, String message) {
    if(loggerLevel.getLevel() == this.loggerLevel.getLevel()) {
      display(message);
    }
    if(this.nextLogger != null) {
      nextLogger.logMessage(loggerLevel, message);
    }
  }

  public abstract void display(String message);
}
