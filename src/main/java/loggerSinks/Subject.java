package loggerSinks;

import enums.LoggerLevel;

public interface Subject {
  void registerObserver(LoggerLevel loggerLevel, LogObserver logObserver);
  void removeObserver(LoggerLevel loggerLevel, LogObserver logObserver);
  void notifyAllObservers(LoggerLevel loggerLevel, String message);
}
