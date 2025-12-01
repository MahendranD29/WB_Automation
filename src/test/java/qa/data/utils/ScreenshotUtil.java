package qa.data.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

public class ScreenshotUtil {
    public static String fileName;

    public ScreenshotUtil() {
    }

    public static String getScreenShot(Scenario scenario, WebDriver driver) throws Exception {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            String ts = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")).format(new Date());
            fileName = System.getProperty("user.dir") + "/target/site/serenity/screenshots/" + ts + "-" + scenario.getName() + "-screenshot.png";
            System.out.println("***** File name along with path is :" + fileName);
            FileUtils.copyFile(scrFile, new File(fileName));
        } catch (Exception var4) {
            var4.printStackTrace();
            log4jBaseClass.error("Error while capturing screenshot. StackTrace:" + Arrays.toString(var4.getStackTrace()));
        }

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        //scenario.embed(screenshot, "image/png");
        scenario.attach(screenshot, "image/png", "FailedScreenshot");
        return fileName;
    }
    public static String captureScreenshot(WebDriver driver, String screenshotName)throws Exception {
        try {
            // Create directories if they don't exist
            File reportsDir = new File("test-output/ExtentReports");
            if (!reportsDir.exists()) {
                reportsDir.mkdirs();
            }

            File screenshotsDir = new File("test-output/ExtentReports/screenshots");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
            String fileName = screenshotName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timeStamp + ".png";
            String relativePath = "screenshots/" + fileName; // Relative to ExtentReports folder
            String fullPath = "test-output/ExtentReports/" + relativePath;

            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(fullPath));

            System.out.println("Screenshot saved: " + fullPath);
            return relativePath; // Return relative path for Extent Reports
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
            return "";
        }
    }

    // Method specifically for Extent Reports
    public static String captureScreenshotForReport(WebDriver driver, String scenarioName)throws Exception {
        String cleanName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_");
        if (cleanName.length() > 50) {
            cleanName = cleanName.substring(0, 50);
        }
        return captureScreenshot(driver, cleanName);
    }

    //Ashot--> Capture Alert
    public static String getRemoteScreenshot(Scenario scenario, WebDriver driver) throws Exception {
        //Remote Execution Screen Capture
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

        try {
            String ts = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")).format(new Date());
            fileName = System.getProperty("user.dir") + "/target/site/serenity/screenshots/" + ts + "-" + "-Remotescreenshot.png";
            System.out.println("***** File name along with path is :" + fileName);
            ImageIO.write(screenshot.getImage(), "png", new File(fileName));
        } catch (Exception exception) {
            exception.printStackTrace();
            log4jBaseClass.error("Error while capturing screenshot. StackTrace:" + Arrays.toString(exception.getStackTrace()));
        }

        scenario.attach(String.valueOf(screenshot.getImage()), "image/png", "Remote Screenshot");
        return fileName;
    }
}
