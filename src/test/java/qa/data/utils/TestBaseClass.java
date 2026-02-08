







package qa.data.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public abstract class TestBaseClass implements DriverSource {

    public static Properties prop;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public static WebDriverWait wait;

    public static String seleniumGridUrl;
    public static File folder;

    // ================= CONFIG LOADING =================

    public TestBaseClass() {

        if (prop == null) {
            prop = new Properties();

            try {
                InputStream fs = TestBaseClass.class
                        .getClassLoader()
                        .getResourceAsStream("config.properties");

                if (fs == null) {
                    throw new RuntimeException("config.properties NOT found in classpath");
                }

                prop.load(fs);

            } catch (Exception e) {
                throw new RuntimeException("Failed to load config.properties", e);
            }
        }

        System.setProperty("log4j.configurationFile", "log4j2.properties");
    }

    // ================= INITIALIZATION =================

    public static void initialization(String URL, String browser, boolean viaLDAP) {

        try {
            seleniumGridUrl = prop.getProperty("seleniumgridurl");
        } catch (Exception ignored) {
        }

        if (!viaLDAP) {
            URL = URL.replace("PRWebLDAP1", "");
        }

        if (browser.equalsIgnoreCase("RemoteChrome")) {
            launchRemoteChrome(URL);
        } else {
            launchLocalChrome(URL);
        }

        // Default explicit wait
        wait = new WebDriverWait(getDriver(),
                Duration.ofSeconds(getLongProperty("EXPLICT_WAIT_TIME", "25")));

        // Page load completion
        wait.until(driver ->
                ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    // ================= LOCAL CHROME =================

    private static void launchLocalChrome(String URL) {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");

        // Headless support
        String headless = prop.getProperty("headless");

        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        WebDriverManager.chromedriver().setup();

        tlDriver.set(new ChromeDriver(options));

        configureDriver(URL);
    }

    // ================= REMOTE CHROME =================

    private static void launchRemoteChrome(String URL) {

        try {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");

            tlDriver.set(new RemoteWebDriver(new URL(seleniumGridUrl), options));

            configureDriver(URL);

        } catch (Exception e) {
            throw new RuntimeException("Remote Driver Launch Failed", e);
        }
    }

    // ================= DRIVER COMMON CONFIG =================

    private static void configureDriver(String URL) {

        WebDriver driver = getDriver();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(getLongProperty("EXPLICT_WAIT_TIME", "25")));

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(getLongProperty("IMPLICT_WAIT_TIME", "2")));

        driver.get(URL);
    }

    // ================= SAFE PROPERTY READER =================

    public static long getLongProperty(String key, String defaultVal) {
        return Long.parseLong(prop.getProperty(key, defaultVal));
    }

    public static String getProperty(String key, String defaultVal) {
        return prop.getProperty(key, defaultVal);
    }

    // ================= WAIT HELPERS =================

    public static WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ================= DOWNLOAD PREF =================

    public static void setDownloadPref(ChromeOptions options) {

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.prompt_for_download", false);

        options.setExperimentalOption("prefs", prefs);

        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();
    }

    // ================= DRIVER GETTER =================

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // ================= SCREENSHOT SUPPORT =================

    public boolean takesScreenshots() {
        return true;
    }
}


















//package qa.data.utils;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import net.thucydides.core.webdriver.DriverSource;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Properties;
//import java.util.*;
//import java.util.logging.Level;
//
//import org.openqa.selenium.logging.LogType;
//import org.openqa.selenium.logging.LoggingPreferences;
//
//
//public abstract class TestBaseClass implements DriverSource {
//    public static Properties prop;
//    //    public  WebDriver driver;
//    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//    //   public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
//    public static WebDriverWait wait;
//    public static String browser;
//    public static String seleniumGridUrl;
//    public static String browserName;
//    public static String browserVersion;
//    public static Boolean mavenProperty = false;
//    public static String Environment;
//    public static File folder;
//    public static String LocalorRemoteBrowser;
//
//
//    public TestBaseClass() {
//        if (prop == null) {
//            prop = new Properties();
//
//            try {
//                FileInputStream fs = new FileInputStream("resources/config.properties");
//                prop.load(fs);
//                LocalorRemoteBrowser = prop.getProperty("Browser");
//            } catch (FileNotFoundException var3) {
//                var3.printStackTrace();
//                log4jBaseClass.error("Error while initialising TestBaseClass. Config.properties not found. Stack trace:" + var3.getStackTrace());
//            } catch (IOException var4) {
//                var4.printStackTrace();
//                log4jBaseClass.error("Error while initialising TestBaseClass. IO exception in Config.properties. Stack trace:" + var4.getStackTrace());
//            }
//        }
//
//        System.setProperty("log4j.configurationFile", "log4j2.properties");
//    }
//
//    public static void initialization(String URL, String Browser, boolean viaLDAP) {
//        try {
//
//            seleniumGridUrl = prop.getProperty("seleniumgridurl");
//            System.out.println("Getting Grid Url :" + seleniumGridUrl);
//
//            System.out.println("\nSeleniumgridurl:" + seleniumGridUrl + ". Browser:" + Browser + ". Version:");
//            log4jBaseClass.info("Seleniumgridurl:" + seleniumGridUrl + ". Browser:" + Browser + ". Version:");
//
//        } catch (Exception var7) {
//            Browser = "LocalChrome";
//            //browser="RemoteChrome";
//            seleniumGridUrl = prop.getProperty("seleniumgridurl");
//        }
//
//        if (viaLDAP) {
//            System.out.println("URL will be accessed via LDAP");
//            log4jBaseClass.info("URL will be accessed via LDAP");
//        } else {
//            URL = URL.replace("PRWebLDAP1", "");
//            System.out.println("Removed PRWebLDAP1 from URL");
//            log4jBaseClass.info("Removed PRWebLDAP1 from URL");
//        }
//
//        if (Browser.equalsIgnoreCase("RemoteChrome")) {
//            System.out.println(" Executing on Remote CHROME");
//            DesiredCapabilities cap = new DesiredCapabilities();
//            ChromeOptions options = new ChromeOptions();
//            cap.setCapability("goog:chromeOptions", options);
//            options.addArguments("--disable-search-engine-choice-screen");
//            options.addArguments("--ignore-certificate-errors");
//            options.addArguments("--start-maximized");
//            setDownloadPref(options);
//
//            if (prop.getProperty("Platform").equals("LINUX")) {
//
//                options.setPlatformName("LINUX");
//                options.setAcceptInsecureCerts(true);
//            } else {
//
//                options.setPlatformName("WINDOWS");
//                options.setAcceptInsecureCerts(true);
//                options.addArguments("--start-maximized");
//            }
//            // options.setBrowserVersion(prop.getProperty("BrowserVersion"));
//            cap.setBrowserName("chrome");
//            options.merge(cap);
//
//            try {
//                System.out.println("current selenium grid URL used by program is : " + seleniumGridUrl + " capabilities are: " + options);
//                tlDriver.set(new RemoteWebDriver(new URL(seleniumGridUrl), options));
//                getDriver().get(URL);
//                System.out.println("printed$$$$");
//
//
//            } catch (MalformedURLException var6) {
//                var6.printStackTrace();
//            }
//        }
////        else if (Browser.equalsIgnoreCase("LocalChrome")) {
////            System.out.println("Executing on LOCAL CHROME");
////            ChromeOptions chromeOptions;
////            LoggingPreferences logPrefs;
////            if (tlDriver != null) {
////               // WebDriverManager.chromedriver().setup();
////                chromeOptions = new ChromeOptions();
////                logPrefs = new LoggingPreferences();
////                logPrefs.enable(LogType.BROWSER, Level.ALL);
////                chromeOptions.setCapability(chromeOptions.LOGGING_PREFS, logPrefs);
////                setDownloadPref(chromeOptions);
////                chromeOptions.addArguments("--disable-search-engine-choice-screen");
////                chromeOptions.addArguments("window-size=1920,1080");
////                chromeOptions.addArguments("--ignore-certificate-errors");
////                chromeOptions.addArguments("--start-maximized");
////                WebDriverManager.chromedriver().clearDriverCache().setup();
////                tlDriver.set(new ChromeDriver(chromeOptions));
////                browserName = chromeOptions.getBrowserName();
////                browserVersion = chromeOptions.getBrowserVersion();
////                getDriver().manage().window().maximize();
////                tlDriver.get().manage().deleteAllCookies();
////                tlDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(prop.getProperty("EXPLICT_WAIT_TIME"))));
////                tlDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("IMPLICT_WAIT_TIME"))));
////                System.out.println("URL is:" + URL);
////                tlDriver.get().get(URL);
////
////            }
////
////        }
//
//        else if (Browser.equalsIgnoreCase("LocalChrome")) {
//
//            System.out.println("Executing on LOCAL CHROME");
//
//            if (tlDriver != null) {
//
//                ChromeOptions chromeOptions = new ChromeOptions();
//
//                LoggingPreferences logPrefs = new LoggingPreferences();
//                logPrefs.enable(LogType.BROWSER, Level.ALL);
//                chromeOptions.setCapability(chromeOptions.LOGGING_PREFS, logPrefs);
//
//                setDownloadPref(chromeOptions);
//
//                chromeOptions.addArguments("--disable-search-engine-choice-screen");
//                chromeOptions.addArguments("window-size=1920,1080");
//                chromeOptions.addArguments("--ignore-certificate-errors");
//                chromeOptions.addArguments("--start-maximized");
//
//                // ⭐ Headless Support (Cloud Execution)
//                String headless = prop.getProperty("headless");
//
//                if (headless != null && headless.equalsIgnoreCase("true")) {
//
//                    System.out.println("Running in HEADLESS mode");
//
//                    chromeOptions.addArguments("--headless=new");
//                    chromeOptions.addArguments("--no-sandbox");
//                    chromeOptions.addArguments("--disable-dev-shm-usage");
//                }
//
//                WebDriverManager.chromedriver().clearDriverCache().setup();
//
//                tlDriver.set(new ChromeDriver(chromeOptions));
//
//                browserName = chromeOptions.getBrowserName();
//                browserVersion = chromeOptions.getBrowserVersion();
//
//                getDriver().manage().window().maximize();
//                tlDriver.get().manage().deleteAllCookies();
//
//                tlDriver.get().manage().timeouts().pageLoadTimeout(
//                        Duration.ofSeconds(Long.parseLong(prop.getProperty("EXPLICT_WAIT_TIME"))));
//
//                tlDriver.get().manage().timeouts().implicitlyWait(
//                        Duration.ofSeconds(Long.parseLong(prop.getProperty("IMPLICT_WAIT_TIME"))));
//
//                System.out.println("URL is:" + URL);
//                tlDriver.get().get(URL);
//            }
//        }
//    }
//
//    public static String getURL(String environmentName) {
//        String URL;
//        try {
//            System.out.println("Environment value :" + environmentName);
//            //byte var3 = -1;
//            switch (environmentName) {
//                case "ACC":
//                    URL = prop.getProperty("AcceptanceUrl");
//                    System.out.println("Environment is Acceptance. URL:" + URL);
//                    break;
//                case "ST":
//                    URL = prop.getProperty("STUrl");
//                    System.out.println("Environment is ST. URL:" + URL);
//                    break;
//                default:
//                    URL = prop.getProperty("CloudUrl");
//                    System.out.println("No matching Environment. Default value is picked. URL:" + URL);
//            }
//        } catch (Exception var4) {
//            URL = prop.getProperty("CloudUrl");
//            System.out.println("No environment passed. Default Environment is picked. URL:" + URL);
//        }
//
//        log4jBaseClass.info("URL for test case:" + URL);
//        return URL;
//    }
//
//
//    public static void setDownloadPref(ChromeOptions options) {
//        HashMap<String, Object> chromePref = new HashMap<>();
//        chromePref.put("download.prompt_for_download", false);
//        List<String> enabledLabsExperiments = new ArrayList<>();
//        enabledLabsExperiments.add("download-bubble@2");
//        enabledLabsExperiments.add("download-bubble-v2@2");
//        chromePref.put("browser.enabled_labs_experiments", enabledLabsExperiments);
//        options.setExperimentalOption("localState", chromePref);
//
//        folder = new File(UUID.randomUUID().toString());
//        folder.mkdir();
//        Report.info("default directory  is:" + folder.getName());
//        Report.info("default Path is:" + folder.getAbsolutePath());
//    }
//
//
//    public static WebDriver getDriver() {
//        try {
//            return tlDriver.get();
//        } catch (Exception var2) {
//            throw new Error(var2);
//        }
//    }
//
//    public boolean takesScreenshots() {
//        return true;
//    }
//
//    public static WebDriverWait setWait(WebDriverWait wait) {
//        return wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Long.parseLong(prop.getProperty("EXPLICT_WAIT_TIME"))));
//
//
//    }
//
//}
//
