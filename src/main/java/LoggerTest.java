public class LoggerTest {

  public static void main(String[] args) {
    Logger logger = Logger.getLogger();

    logger.info("Hello first info log which should be pushed to console only");
    logger.debug("Hello first debug log which should be pushed to console only");
    logger.error("Hello first error log which should be pushed to console as well as file");
  }
}
