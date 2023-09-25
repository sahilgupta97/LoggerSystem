package loggerSinks;

import enums.LoggerLevel;

public interface LogObserver {
  void notifyLog(LoggerLevel loggerLevel, String message);
}
