package MyLog;
import java.util.logging.Logger;
public class MyLogger {
	private static final Logger LOGGER = Logger.getLogger(MyLogger.class.getName());




    public static void logInfo(String message) {
        LOGGER.info(message);
    }

    public static void logWarning(String message) {
        LOGGER.warning(message);
    }

    public static void logError(String message) {
        LOGGER.severe(message);
    }
}
