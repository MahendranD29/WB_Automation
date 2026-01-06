package cukeTests.web;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features_web"},
        tags = "@TC002",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/json-reports/MainRunner/CucumberTestReport.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/cucumber-reports/rerun-reports/rerun.txt"},
        monochrome = true, objectFactory = io.cucumber.picocontainer.PicoFactory.class
)


public class RunCukesByFeatureWeb extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)         //set parallel to true for parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

