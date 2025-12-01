package cukeTests.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import qa.data.utils.*;

import static qa.data.utils.WebPageOperations.*;
import static qa.data.utils.Dictionary.clearDictionary;

public class Hooks extends TestBaseClass {

    public static Scenario scenario;

    public Hooks() {
    }

    @Before
    public void BeforeSteps(Scenario scenario) {
        Hooks.scenario = scenario;
        log4jBaseClass.startTestCase(scenario.getName());

        try {

            WritePerfResults.createFile();
        } catch (Exception ex) {
            System.out.println("Performance Test File Not Created: \n" + ex.getMessage());
            ex.printStackTrace();
        }

    }

    @After
    public void afterScenario() {
        try {
            Hooks hooks = new Hooks();
            hooks.tearDown(scenario);
            Report.info("Application Exit Initiated");
            getPageTitle();
            Thread.sleep(DELAY_IN_MILLI_SECS);
            getDriver().quit();
            System.out.println("driver closed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            //Get Browser Console
            /*try {
                LogEntries entry = getDriver().manage().logs().get(LogType.BROWSER);
                List<LogEntry> logs = entry.getAll();
                for (LogEntry e : logs) {
                    Report.info("Timestamp" + e.getTimestamp());
                    Report.info("Message" + e.getMessage());
                    Report.info("Level" + e.getLevel());
                }
            } catch (Exception ex) {
                Report.info("No Log Entries Found");
            }*/

            ScreenshotUtil screenshotUtil = new ScreenshotUtil();
            try {
                ScreenshotUtil.getScreenShot(scenario, getDriver());
                log4jBaseClass.error("Test scenario Failed for:" + scenario.getName());
            } catch (Exception e) {
                e.printStackTrace();
                log4jBaseClass.endTestCase(scenario.getName());
            }

        }
        clearDictionary();
        log4jBaseClass.endTestCase(scenario.getName());
    }

    public static void captureAlert(Scenario scenario) throws Exception {
        try {
            ScreenshotUtil.getRemoteScreenshot(scenario, getDriver());
            Report.info("***Alert captured***");

        } catch (Exception e) {
            Report.info("***Alert Not Captured***");
        }


    }

    public static void captureT(Scenario scenario) throws Exception {
        try {
            ScreenshotUtil.getScreenShot(scenario, getDriver());
            Report.info("***captured***");

        } catch (Exception e) {
            Report.info("****Not Captured***");
        }


    }


    @Override
    public WebDriver newDriver() {
        return getDriver();
    }
}



