package abstractLogger;

import enums.LoggerLevel;

public class DebugLogger extends AbstractLogger {

  public DebugLogger() {
    this.loggerLevel = LoggerLevel.DEBUG;
  }

  @Override
  public void display(String message) {
    System.out.println(this.loggerLevel.name() + " : " + message);
  }
}
