package abstractLogger;

import enums.LoggerLevel;

public class ErrorLogger extends AbstractLogger{

  public ErrorLogger() {
    this.loggerLevel = LoggerLevel.ERROR;
  }

  @Override
  public void display(String message) {
    System.out.println(this.loggerLevel.name() + " : " + message);
  }
}
