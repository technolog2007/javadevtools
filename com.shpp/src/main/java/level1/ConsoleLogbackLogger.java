package level1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleLogbackLogger {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleLogbackLogger.class);

    public static void main(String[] args) {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
    }
}
