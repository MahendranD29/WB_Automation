package cukeTests.web.step;

import cukeTests.web.Hooks;
import io.cucumber.java.en.When;
import qa.data.utils.Report;
import page.QAPage;
import static qa.data.utils.TestBaseClass.getDriver;

public class QAStepDef {
    String ScenarioName = Hooks.scenario.getName();
    QAPage QAPage;

    @When("User clicks on {string} in Dashboard")
    public void userClicksOnInDashboard(String arg0) throws Exception {
        QAPage = new QAPage(getDriver());
        Report.info("******STEPS STARTED: User Clicks on Tab ****** ");
        QAPage.checking();
        Report.info("******STEPS ENDED: userClicks on Tab ****** ");

    }
}
