package qa.data.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jBaseClass {
    private static final Logger logtest = LogManager.getLogger(log4jBaseClass.class.getName());

    public log4jBaseClass() {
    }

    public static void startTestCase(String sTestCaseName) {
        logtest.info("****************************************************************************************");
        logtest.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
        logtest.info("****************************************************************************************");
    }

    public static void endTestCase(String sTestCaseName) {
        logtest.info("XXXXXXXXXXXXXXXXXXXXXXX             -E---N---D-             XXXXXXXXXXXXXXXXXXXXXX");
    }

    public static void info(String message) {
        logtest.info(message);
    }

    public static void warn(String message) {
        logtest.warn(message);
    }

    public static void error(String message) {
        logtest.error(message);
    }

    public static void fatal(String message) {
        logtest.fatal(message);
    }

    public static void debug(String message) {
        logtest.debug(message);
    }
}
