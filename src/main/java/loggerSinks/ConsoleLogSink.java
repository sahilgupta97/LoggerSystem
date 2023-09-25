package loggerSinks;

import enums.LoggerLevel;

public class ConsoleLogSink implements LogObserver{

  @Override
  public void notifyLog(LoggerLevel loggerLevel, String message) {
    System.out.println("Pushed to CONSOLE : {" + loggerLevel.name() +" : " + message + "}");
  }
}
