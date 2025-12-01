package cukeTests.web;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = { "@target/cucumber-reports/rerun-reports/rerun.txt" },
        plugin = { "pretty","html:target/cucumber-reports/cucumber-pretty_rerun.html","json:target/cucumber-reports/json-reports/reRunner/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun-reports/failedrerun.txt" },
        monochrome= true
)


public class RunCukesByFeatureWebFailed extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
