package loggerSinks;

import enums.LoggerLevel;

public class FileLogSink implements LogObserver {

  @Override
  public void notifyLog(LoggerLevel loggerLevel, String message) {
    System.out.println("Pushed to FILE : {" + loggerLevel.name() +" : " + message + "}");
  }
}
