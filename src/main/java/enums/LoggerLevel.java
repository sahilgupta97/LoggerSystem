package enums;

public enum LoggerLevel {
  ERROR(1),
  INFO(2),
  DEBUG(3);

  private final int level;

  public int getLevel() {
    return level;
  }

  // 1 is least and 3 is highest.
  LoggerLevel(int level) {
    this.level = level;
  }
}
