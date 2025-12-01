package page;

import cukeTests.web.Hooks;
import qa.data.utils.AppSpecificUtility;
import qa.data.utils.TestBaseClass;
import qa.data.utils.log4jBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static cukeTests.web.Hooks.scenario;

public class QAPage extends AppSpecificUtility {
    public QAPage(WebDriver driver) {
        TestBaseClass testBaseClass = new TestBaseClass() {
            @Override
            public WebDriver newDriver() {
                return getDriver();
            }
        };
        try {
            initElems(driver);

            log4jBaseClass.debug("Driver initialized for PartySelectorPage");

        } catch (Exception ex) {
            log4jBaseClass.error("Error while initialising Web Driver for PartySelectorPage");
        }
    }

    public void initElems(WebDriver driver) {
        try {
            PageFactory.initElements(driver, this);
            log4jBaseClass.debug("Page factory initialized for Login Page");
        } catch (Exception ex) {
            log4jBaseClass.error("Error while initialising Page Factory for Login Page");
        }

    }

    public void checking() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
    }


}
