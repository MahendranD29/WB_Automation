package qa.data.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.input.TaggedReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WebPageOperations extends TestBaseClass {
    static int maxNoOfRetries = 5;
    public static int DELAY_IN_MILLI_SECS = (int) Long.parseLong(prop.getProperty("DELAY_IN_MILLISECS"));
    public static final int DELAY_IN_SECS = (int) Long.parseLong(prop.getProperty("DELAY_IN_SECS"));


    public WebPageOperations() {
    }

    public static void clickOperation(WebElement element) {
        int counter = 0;

        while (maxNoOfRetries > 0 && counter != maxNoOfRetries) {
            try {
                waitForElement(element);
                hoverOnElement(element);
                element.click();
                break;
            } catch (Exception var3) {
              //  getDriver().manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICT_WAIT_TIME")), TimeUnit.SECONDS);
                ++counter;
            }
        }

    }

    public static void selection(WebElement element, String value) {
        Select drpdown = new Select(element);
        drpdown.selectByVisibleText(value);

    }

    // public static void hoverOnElement(WebElement menu, WebElement subMenu)  {
    public static void hoverOnElement(WebElement menu) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(menu).build().perform();

    }


    public static void selectDropdownByIndex(WebElement element, int value) {
        (new Select(element)).selectByIndex(value);
    }

    public static Boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception var2) {
            return false;
        }
    }

    public static void refresh() throws InterruptedException {
        getDriver().navigate().refresh();
        Thread.sleep(1000L);
    }

    /*
     * NOT TESTED
     * */
    public static void switchFrame() {

        String[] iframeName = WriteToCSV.GetiFrameName();
        String iFrameNameSwitchTo = iframeName[iframeName.length - 1];
        getDriver().switchTo().frame(iFrameNameSwitchTo);
    }

    /*
     *
     * Switch To Frame Based On FrameName
     * */
    public static void switchFrame(String frameName) {
        try {
            getDriver().switchTo().frame(frameName);
        } catch (NoSuchFrameException N) {
            getDriver().navigate().refresh();
            getDriver().switchTo().frame(frameName);
        }

    }

    /*
     *
     * Switch To Frame Based On Index
     * */
    public static void switchFrame(int frameIndex) {

        getDriver().switchTo().frame(frameIndex);
    }

    /*
     *
     * Switch To Nested Frame
     * */
    public static void switchNestedFrame(String frameName1, String frameName2) {

        getDriver().switchTo().frame(frameName1).switchTo().frame(frameName2);
    }


    /*
     * Switch to Parent Frame
     * */
    public static void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
        System.out.println("Switched to default Frame ");
    }

    public static void waitForPageLoad() {
      //  getDriver().manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("EXPLICT_WAIT_TIME")), TimeUnit.SECONDS);
    }

    public static void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Long.parseLong(prop.getProperty("EXPLICT_WAIT_TIME"))));
        setWait(wait).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static String getPopupMessage() {
        String message = null;

        try {
            Alert alert = getDriver().switchTo().alert();
            message = alert.getText();
            alert.accept();
        } catch (Exception var2) {
            message = null;
        }

        System.out.println("message" + message);
        return message;
    }

    public static void populateField(WebElement element, String text) {
        int counter = 0;

        while (maxNoOfRetries >= 0 && counter != maxNoOfRetries) {
            try {
                element.clear();
                element.sendKeys(text);
                break;
            } catch (Exception var4) {
              //  getDriver().manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICT_WAIT_TIME")), TimeUnit.SECONDS);
                ++counter;
            }
        }

    }

    public static String getPageTitle() {
        System.out.println("page title is: " + getDriver().getTitle());
        return getDriver().getTitle();
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static void selectDropdownbyVisibleText(WebElement element, String value) {
        (new Select(element)).selectByVisibleText(value);
    }

    public static void selectDropdownByValue(WebElement element, String value) {
        (new Select(element)).selectByValue(value);
    }

    public static WebElement findElementByText(List<WebElement> elements, String text) {
        WebElement result = null;
        Iterator var3 = elements.iterator();

        while (var3.hasNext()) {
            WebElement element = (WebElement) var3.next();
            element.getText().trim();
            if (text.equalsIgnoreCase(element.getText().trim())) {
                Assert.assertEquals(text,element.getText().trim());
                result = element;
                break;
            }
        }

        return result;
    }

    public static boolean isElementPresent(WebElement element) {
        boolean available = false;

        try {
            if (element.isDisplayed()) {
                available = true;
            }

            return available;
        } catch (NoSuchElementException var3) {
            return available;
        }
    }

    public static void hoverOnElement(WebElement menu, WebElement subMenu) throws InterruptedException {
        try {
            //Actions actions = new Actions(getDriver());
            Thread.sleep(20000);
            //actions.moveToElement(menu).build().perform();
            menu.click();
            subMenu.click();
        } catch (Exception ignored) {

        }
    }

    public static void bootStrapDropDown(List<WebElement> menuList, String option) {
        Iterator var2 = menuList.iterator();

        while (var2.hasNext()) {
            WebElement item = (WebElement) var2.next();
            if (item.getAttribute("innerHTML").equalsIgnoreCase(option)) {
                item.click();
                break;
            }
        }

    }

    public static void populateField(WebElement element, int number) {
        int counter = 0;

        while (maxNoOfRetries > 0 && counter != maxNoOfRetries) {
            try {
                element.clear();
                element.sendKeys(String.valueOf(number));
                break;
            } catch (Exception var4) {
              //  getDriver().manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICT_WAIT_TIME")), TimeUnit.SECONDS);
                ++counter;
            }
        }

    }

    public static void findElementByClassName(String className) {
        getDriver().findElement(By.className(className)).click();
    }

    public static void findElemenetByAnchorTagAndText(String AnchorText) {
        getDriver().findElement(By.xpath("//span/a/i[contains(.,'" + AnchorText + "')]")).click();
    }

    public static WebElement findElementByXPath(String xPath) {
        return getDriver().findElement(By.xpath(xPath));
    }

    public static void clickElement(WebElement element) {
        element.click();
    }

    public static void scrollElement(WebElement ele) {
        try {
            try {
                Thread.sleep(1000L);
                setWait(wait).until(ExpectedConditions.visibilityOf(ele));
            } catch (Exception var2) {
                setWait(wait).until(ExpectedConditions.visibilityOf(ele));
            }
        } catch (Exception var3) {
            log4jBaseClass.error("Exception occured in 'scrollElement'. Stack Trace:" + var3.getMessage());
        }

    }

    public static void waitForAjaxToFinish() {
        WebDriverWait wait = new WebDriverWait(TestBaseClass.getDriver(), Duration.of(5000L, ChronoUnit.SECONDS));
        setWait(wait).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) TestBaseClass.getDriver()).executeScript("return jQuery.active == 0").equals(true);
            }
        });
    }

    public static void waitForJQueryToBeActive() {
        Boolean isJqueryUsed = (Boolean) ((JavascriptExecutor) TestBaseClass.getDriver()).executeScript("return (typeof(jQuery) != 'undefined')", new Object[0]);
        if (isJqueryUsed) {
            while (true) {
                Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) TestBaseClass.getDriver()).executeScript("return jQuery.active == 0", new Object[0]);
                if (ajaxIsComplete) {
                    break;
                }

                try {
                    Thread.sleep(100L);
                } catch (InterruptedException ignored) {
                }
            }
        }

    }

    public static void waitForAjax(String action) {
       // TestBaseClass.getDriver().manage().timeouts().setScriptTimeout(Long.parseLong(prop.getProperty("EXPLICT_WAIT_TIME")), TimeUnit.SECONDS);
        ((JavascriptExecutor) TestBaseClass.getDriver()).executeAsyncScript("var callback = arguments[arguments.length - 1];var xhr = new XMLHttpRequest();xhr.open('POST', '/" + action + "', true);xhr.onreadystatechange = function() {  if (xhr.readyState == 4) {    callback(xhr.responseText);  }};xhr.send();");
    }

    public static String readPwdFromConfig(String userID) throws IOException {
        String userIDRelevantPassword = null;

        Properties pr = new Properties();

        try {

            FileInputStream fs = new FileInputStream("resources/unamepwd_config.Properties");
            pr.load(fs);
            userIDRelevantPassword = pr.getProperty(userID);


        } catch (FileNotFoundException var3) {
            var3.printStackTrace();
            log4jBaseClass.error("Error while initialising TestBaseClass. Config.properties not found. Stack trace:" + Arrays.toString(var3.getStackTrace()));
        } catch (IOException var4) {
            var4.printStackTrace();
            log4jBaseClass.error("Error while initialising TestBaseClass. IO exception in Config.properties. Stack trace:" + Arrays.toString(var4.getStackTrace()));
        }

        return userIDRelevantPassword;
    }


//TODO

    /**
     * NOT WORKING
     * Used when a new window popup comes up on clicking a button/link/icon in IE
     * An alternative for getHandleToWindow in IE
     * Usually this method is called when only one window (ie parent window) is present,
     * and invoking a link/button/icon triggers child window, and total window count would be 2
     *
     * @param childWindowTitle Name of the child window to which the windows focus is transferred to
     * @param objName          object identification information for the link/button/icon which opens up a popup window
     * @return handler to the new popup window
     */

    public WebDriver clickAndWaitForBrowserPopup(String childWindowTitle, WebElement objName) throws InterruptedException {
        WebDriver popupWindow = null;
        Set<String> handles = getDriver().getWindowHandles();
        Report.info("No of windows should be 1 :  " + handles.size());
        clickOperation(objName);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.of(DELAY_IN_SECS, ChronoUnit.SECONDS));
        int currentWindowCount = getWindowCount();

        setWait(wait).until(ExpectedConditions.numberOfWindowsToBe(currentWindowCount));
        Thread.sleep(DELAY_IN_SECS + DELAY_IN_SECS);
        Thread.sleep(DELAY_IN_SECS + DELAY_IN_SECS);
        handles = getDriver().getWindowHandles();
        Report.info("No of windows should be 2 :  " + handles.size());
        for (String s : handles) {
            String windowHandle = s;
            popupWindow = getDriver().switchTo().window(windowHandle);
            waitForPageLoad();
            Report.info("Window Title : " + popupWindow.getTitle());
            Report.info("Window Url : " + popupWindow.getCurrentUrl());

            if (popupWindow.getTitle().contains(childWindowTitle)) {
                Report.info("Selected Window Title : " + popupWindow.getTitle());
                return popupWindow;
            }
        }
        Report.info("Window Title :" + popupWindow.getTitle());
        //		waitForPageLoad();
        return popupWindow;
    }

    public static void switchToNewTab() throws InterruptedException {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        System.out.println("Switched to new tab");
        System.out.println("New Window Title is :" + getDriver().getTitle());
    }

    public static void switchToPreviousTab() throws InterruptedException {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(0));
        System.out.println("Switched to previous tab");
        System.out.println("Previous Window Title is :" + getDriver().getTitle());
    }

    public static void switchToNewWindow(int index) throws InterruptedException {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(index));
        getDriver().manage().window().maximize();
        System.out.println("Switched to new tab");
        System.out.println("New Window Title is :" + getDriver().getTitle());
    }

    public static void maximizeWindow() throws InterruptedException {
        //Thread.sleep(DELAY_IN_MILLI_SECS);

        //getDriver().manage().window().maximize();
        Dimension d = new Dimension(700, 800);
        getDriver().manage().window().setSize(d);

        System.out.println("Maximize the Window");

    }


    /**
     * @param
     * @return
     */
    public String getCurrentWindowHandle() {

        return getDriver().getWindowHandle();
    }

    public int getWindowCount() {
        return getDriver().getWindowHandles().size();
    }


    /**
     * Called when the operations on child windows are done and wanted to navigate back to parent window
     *
     * @param childWindowTitle  Name of the child window
     * @param parentWindowTitle name of the parent window
     * @return handler to parent window
     */
    public WebDriver closePopupWindowAndNavigateToParentWindow(String childWindowTitle, String parentWindowTitle) {
        WebDriver popupWindow = null;
        Set<String> handles = getDriver().getWindowHandles();
        Report.info("No of windows Noticed :  " + handles.size());
        boolean isChildWindowClosed = false;

        for (String s : handles) {
            String windowHandle = s;
            popupWindow = getDriver().switchTo().window(windowHandle);

            if (popupWindow.getTitle().contains(childWindowTitle) && !isChildWindowClosed) {
                getDriver().close();
                Report.info("Successully closed child window with Title : " + childWindowTitle);
                isChildWindowClosed = true;
                break;
            }
        }
        handles = getDriver().getWindowHandles();
        Report.info("No of windows after closing child window :  " + handles.size());
        for (String s : handles) {
            String windowHandle = s;
            popupWindow = getDriver().switchTo().window(windowHandle);

            if (popupWindow.getTitle().contains(parentWindowTitle)) {
                Report.info("Selected Window Title : " + popupWindow.getTitle());

                return popupWindow;
            }
        }
        Report.info("Window Title :" + popupWindow.getTitle());
        return popupWindow;

    }

    //get switched tab URL with tab index and with return type String
    public static String getSwitchedTabURL(int tabindex) throws InterruptedException {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        String URL = getDriver().switchTo().window(tabs.get(tabindex)).getCurrentUrl();
        Thread.sleep(DELAY_IN_MILLI_SECS*3);
        return URL;
    }


    public void upLoadFile(WebElement fileUpLoad, String filePath) throws IOException, InterruptedException {


        String defaultPath = "resources";


        String browserName = LocalorRemoteBrowser;
        if (browserName.equalsIgnoreCase("LocalChrome")) {
            try {
                String attachFile = defaultPath + File.separator + filePath;
                File file = new File(attachFile);
                //setWait(wait).until(ExpectedConditions.visibilityOf(fileUpLoad));
                fileUpLoad.sendKeys(file.getAbsolutePath());
            } catch (Exception exp) {
                exp.printStackTrace();

            }


        } else if (browserName.equalsIgnoreCase("RemoteChrome")) {

            try {

                String attachFile = defaultPath + File.separator + filePath;
                File file = new File(attachFile);
                //setWait(wait).until(ExpectedConditions.visibilityOf(fileUpLoad));
                //LocalFileDetector detector = new LocalFileDetector();
                //((RemoteWebElement) fileUpLoad).setFileDetector(detector);
                //fileUpLoad.sendKeys(file.getAbsolutePath());
                //
                WebElement El = getDriver().findElement(By.xpath("(//input[@type='file'])[1]"));
                ((RemoteWebElement) El).setFileDetector(new LocalFileDetector());
                El.sendKeys(file.getAbsolutePath());


            } catch (Exception exp) {
                exp.printStackTrace();

            }
        }

    }


    public static boolean verifyAllElementsDisplayed(List<WebElement> elements) throws InterruptedException {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        boolean available = false;
        Iterator<WebElement> ele = elements.iterator();
        while (ele.hasNext()) {
            String data = ele.next().getText();
            WebElement ids = getDriver().findElement(By.xpath("//a[text()='" + data + " ']"));
            if (ids.isDisplayed()) {
                available = true;
            }
        }


        return available;
    }

    public static void selectDropDownValue(List<WebElement> elements, String value) {
        try {
            for (WebElement element : elements) {
                String text = element.getText();
                if (text.equalsIgnoreCase(value)) {
                    element.click();
                }
            }

        } catch (StaleElementReferenceException ignored) {

        }
    }

    // To select Random Value from search field
    public static void selectRandomValue(List<WebElement> elements) {
        int randIndex = new Random().nextInt(elements.size());
        WebElement elementToClick = elements.get(randIndex);
        clickOperation(elementToClick);
    }

    public static int getSizeOfElements(List<WebElement> elements) {
        return elements.size();
    }

    @Override
    public WebDriver newDriver() {
        return getDriver();
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }

    public static void setAttributeUsingJS(WebElement element, String attribute, String value) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].setAttribute(" + attribute + "," + value + ")");
    }

    public static String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        Actions actions = new Actions(getDriver());
        waitForPageLoad();
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    public static String getTextUsingJavaScript(WebElement element) {
        waitForElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        String value = (String) executor.executeScript("return arguments[0].innerText", element);
        return value.trim();
    }

    public static void clickUsingJavaScript(WebElement element) {
        waitForElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click()", element);
    }


    public static int countChar(String str, char c) {
        //gets the no of repetition of a character in a string leaving the last occurrence
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public static int nthIndexOf(String text, char needle, int n) {
        // this function returns the index of the repeated character in a text.
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == needle) {
                n--;
                if (n == 0) {
                    return i;
                }
            }
        }
        return -1; // Character not found or nth occurrence doesn't exist
    }


    public static String getTrimmedContentLinesFromEnd(String content, int lines) {
        //this function returns the no of lines that are required from the end in a content
    int noOfLines = countChar(content, '\n');
    if(content.charAt(content.length()-1)!='\n')
        lines = lines+1;
    content = content.substring(nthIndexOf(content, '\n', noOfLines-lines));
    return content;
}
    public static Boolean isEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception var2) {
            return false;
        }
    }

    //this function iterates through all the iframes and switches to the frame where the classname matches
    public void switchFrameByClassUsingIndex(String className)
    {
              List <WebElement> iframe = getDriver().findElements(By.xpath("//iframe"));
        for(int i=1;i<iframe.size();i++)
        {
            if(getAttribute(iframe.get(i),"class").equals(className))
            {
                switchFrame(i);
                break;
            }
        }
    }

    //switch frame based on webelement
    public static void switchFrame(WebElement element) {
        try {
            getDriver().switchTo().frame(element);
        } catch (NoSuchFrameException N) {
            getDriver().navigate().refresh();
            getDriver().switchTo().frame(element);
        }
    }

    //This function is used to input the text using javascript
    public static void setTextUsingJavaScript(WebElement element, String string)
    {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = arguments[1];", element, string);
    }

    public List<WebElement> waitForStaleElement(List<WebElement> WebElements) throws InterruptedException {
        int elementSize =0;
        int trails = 0;
        do {
            Thread.sleep(DELAY_IN_MILLI_SECS);
            elementSize = getSizeOfElements(WebElements);
        }
        while (trails++<7 && elementSize==0);
        return WebElements;
    }
    public void dashBoardFileUpLoad(WebElement fileUpLoad, String filePath) throws IOException, InterruptedException {


        String defaultPath = "resources";


        String browserName = LocalorRemoteBrowser;
        if (browserName.equalsIgnoreCase("LocalChrome")) {
            try {
                String attachFile = defaultPath + File.separator + filePath;
                File file = new File(attachFile);
                //setWait(wait).until(ExpectedConditions.visibilityOf(fileUpLoad));
                fileUpLoad.sendKeys(file.getAbsolutePath());
            } catch (Exception exp) {
                exp.printStackTrace();

            }


        } else if (browserName.equalsIgnoreCase("RemoteChrome")) {

            try {

                String attachFile = defaultPath + File.separator + filePath;
                File file = new File(attachFile);
                //setWait(wait).until(ExpectedConditions.visibilityOf(fileUpLoad));
                //LocalFileDetector detector = new LocalFileDetector();
                //((RemoteWebElement) fileUpLoad).setFileDetector(detector);
                //fileUpLoad.sendKeys(file.getAbsolutePath());
                //
                WebElement El = getDriver().findElement(By.xpath("(//input[@type='file'])[3]"));
                ((RemoteWebElement) El).setFileDetector(new LocalFileDetector());
                El.sendKeys(file.getAbsolutePath());


            } catch (Exception exp) {
                exp.printStackTrace();

            }
        }

    }
    public static void clickUsingJS(WebElement element) throws InterruptedException {
        //setWait(wait).until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);

    }
    public void switchFrameByClass(String className)
    {
        List <WebElement> iframe = getDriver().findElements(By.xpath("//iframe"));
        for(int i=1;i<iframe.size();i++)
        {
            if(getAttribute(iframe.get(i),"class").equals(className))
            {
                switchFrame(i);
                break;
            }
        }
    }
    public static void switchToPopupTab() throws InterruptedException {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(2));
        System.out.println("Switched to new tab");
        System.out.println("New Window Title is :" + getDriver().getTitle());
    }
}