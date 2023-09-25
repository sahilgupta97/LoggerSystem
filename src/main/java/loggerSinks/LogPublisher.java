package loggerSinks;

import enums.LoggerLevel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogPublisher implements Subject {
  Map<String, List<LogObserver>> logObserverTable;

  public LogPublisher() {
    this.logObserverTable = new HashMap<>();
  }

  @Override
  public void registerObserver(LoggerLevel loggerLevel, LogObserver logObserver) {
    List<LogObserver> logObservers = logObserverTable.computeIfAbsent(loggerLevel.name(), list -> (new ArrayList<>()));
    logObservers.add(logObserver);
  }

  @Override
  public void removeObserver(LoggerLevel loggerLevel, LogObserver logObserver) {
    List<LogObserver> logObservers = logObserverTable.getOrDefault(loggerLevel.name(), Collections.emptyList());
    logObservers.remove(logObserver);
  }

  @Override
  public void notifyAllObservers(LoggerLevel loggerLevel, String message) {
    List<LogObserver> logObservers = logObserverTable.getOrDefault(loggerLevel.name(), Collections.emptyList());
    for(LogObserver logObserver : logObservers) {
      logObserver.notifyLog(loggerLevel, message);
    }
  }
}
