package abstractLogger;

import enums.LoggerLevel;

public class InfoLogger extends AbstractLogger{

  public InfoLogger() {
    this.loggerLevel = LoggerLevel.INFO;
  }

  @Override
  public void display(String message) {
    System.out.println(this.loggerLevel.name() + " : " + message);
  }
}
