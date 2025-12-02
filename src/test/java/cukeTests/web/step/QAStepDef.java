package cukeTests.web.step;

import cukeTests.web.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import qa.data.utils.Report;
import page.QAPage;
import static qa.data.utils.TestBaseClass.getDriver;

public class QAStepDef {
    String ScenarioName = Hooks.scenario.getName();
    QAPage QAPage;


    @When("User login on {string} in Wakanda Books")
    public void userLoginOnInWakandaBooks(String role) throws Exception {
        QAPage = new QAPage(getDriver());
        Report.info("******STEPS STARTED: User login on {string} in Wakanda Books****** ");
        QAPage.loginUsers(role);
        Report.info("******STEPS ENDED: User login on {string} in Wakanda Books****** ");
    }

    @When("User select {string} on login page")
    public void userSelectOnLoginPage(String company) throws Exception {
        QAPage = new QAPage(getDriver());
        Report.info("******STEPS STARTED: User select {string} on login page****** ");
        QAPage.companySelect(company);
        Report.info("******STEPS ENDED: User select {string} on login page****** ");
    }

    @When("User clicks on {string} and Select {string}")
    public void userClicksOnAndSelect(String module, String sub) throws Exception {
        QAPage = new QAPage(getDriver());
        Report.info("User clicks on {string} and Select {string}");
        QAPage.selectModuleAndSub(module,sub);
        Report.info("User clicks on {string} and Select {string}");
    }

    @When("User clicks on {string} in Items list")
    public void userClicksOnInItemsList(String add) throws Exception {
        QAPage = new QAPage(getDriver());
        Report.info("User clicks on {string} in Items list");
        QAPage.addSection(add);
        Report.info("User clicks on {string} in Items list");
    }


    @And("User add {string}, {string} and {string} details in add products")
    public void userAddAndDetailsInAddProducts(String productName, String arg1, String arg2) throws Exception {
        QAPage = new QAPage(getDriver());
        Report.info("User add {string}, {string} and {string} details in add products");
        QAPage.basicItemDetails("Raise","KG","Grocery","04-25-2025");
        Report.info("User add {string}, {string} and {string} details in add products");
    }

    @And("User add price details {string} and {string} in Additional Information")
    public void userAddPriceDetailsAndInAdditionalInformation(String parchase, String sell) {

        QAPage = new QAPage(getDriver());
        Report.info("User add price details {string} and {string} in Additional Information");
        QAPage.additionalInfo("1000","2000");
        Report.info("User add price details {string} and {string} in Additional Information");
    }



    @And("User select {string} details and Information details")
    public void userSelectDetailsAndInformationDetails(String warehouse) {
        QAPage = new QAPage(getDriver());
        Report.info("User select {string} details and Information details");
        QAPage.warehouseInfo(warehouse,"1000","03-12-2025","1000","1500","50");
        Report.info("User select {string} details and Information details");
    }

    @When("User Clicks on {string} in Wakanda Books")
    public void userClicksOnInWakandaBooks(String store) {
        QAPage = new QAPage(getDriver());
        Report.info("User Clicks on {string} in Wakanda Books");
        QAPage.storeThePrdoct(store);
        Report.info("User Clicks on {string} in Wakanda Books");
    }
}
