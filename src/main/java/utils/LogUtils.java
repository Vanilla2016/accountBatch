//package utils;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class LogUtils {
//	private static Logger logger = LogManager.getLogger(LogUtils.class);
//	
//	public static void logInfo(String message) {
//		logger.info(message);
//	}
//	
//	public static void logWarning(String message) {
//		logger.warn(message);
//	}
//	
//	public static void logError(String message) {
//		logger.error(message);
//	}
//}
package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils {
    private static final Logger logger = LogManager.getLogger(LogUtils.class);

    public static void logInfo(String message) {
        logger.info(getCallerDetails() + " - " + message);
    }

    public static void logWarning(String message) {
        logger.warn(getCallerDetails() + " - " + message);
    }

    public static void logError(String message) {
        logger.error(getCallerDetails() + " - " + message);
    }

    private static String getCallerDetails() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // Get caller details (3rd index to skip current method and get actual caller)
        StackTraceElement caller = stackTrace[3];

        return "[" + caller.getClassName() + "." + caller.getMethodName() + ":" + caller.getLineNumber() + "]";
    }
}
