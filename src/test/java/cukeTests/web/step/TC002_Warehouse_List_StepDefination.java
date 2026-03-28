package cukeTests.web.step;

import cukeTests.web.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.TC001_Items_Page;
import page.TC002_Warehouse_List_Page;
import qa.data.utils.Report;

import static qa.data.utils.TestBaseClass.getDriver;

public class TC002_Warehouse_List_StepDefination  {

    String ScenarioName = Hooks.scenario.getName();
    TC002_Warehouse_List_Page warehouseListPage;
    TC001_Items_Page itemsPage;




    @And("User Enter Warehouse name{string} and Location{string}")
    public void userEnterWarehouseNameAndLocation(String warehouse_Name, String location) {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED: User Enter Warehouse name{string} and Location{string}****** ");
        warehouseListPage.userEnterWarehouseName(warehouse_Name, location);
        Report.info("******STEPS ENDED: User Enter Warehouse name{string} and Location{string}****** ");
    }

    @Then("User Validate the Warehouse in Warehouse List")
    public void userValidateTheWarehouseInWarehouseList() throws Exception {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the Warehouse in Warehouse List****** ");
        warehouseListPage.validateWarehouseList();
        Report.info("******STEPS ENDED: User Validate the Warehouse in Warehouse List****** ");
    }

    @When("User clicks on Action button in Warehouse list")
    public void userClicksOnActionButtonInWarehouseList() throws InterruptedException {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED: User clicks on Action button in Warehouse list****** ");
        warehouseListPage.clickOnActionButton();
        Report.info("******STEPS ENDED: User clicks on Action button in Warehouse list****** ");
    }

    @When("User clicks on {string} Warehouse List")
    public void userClicksOnWarehouseList(String action) throws Exception {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED: User clicks on {string} Warehouse List****** ");
        warehouseListPage.clickOnWarehouseList(action);
        Report.info("******STEPS ENDED: User clicks on {string} Warehouse List****** ");
    }

    @When("User clicks on {string}")
    public void userClicksOn(String btn) throws Exception {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED: User clicks on {string}****** ");
        warehouseListPage.clickOn(btn);
        Report.info("******STEPS ENDED: User clicks on {string}****** ");
    }

    @And("User selects item from {string}")
    public void userSelectsItemFrom(String name) throws InterruptedException {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED: User selects item from {string}****** ");
        warehouseListPage.selectItemFrom(name);
        Report.info("******STEPS ENDED: User clicks on {string}****** ");
    }

    @And("User enters valid Opening Stock")
    public void userEntersValidOpeningStock() {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED:User enters valid Opening Stock****** ");
        warehouseListPage.enterOpeningStock();
        Report.info("******STEPS ENDED: User enters valid Opening Stock****** ");
    }


    @And("User enters Selling Wholesale Price and Minimum Quantity")
    public void userEntersSellingWholesalePriceAndMinimumQuantity() throws InterruptedException {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED:User enters Selling Wholesale Price and Minimum Quantity****** ");
        warehouseListPage.enterSellingWholesalePriceAndMinimumQuantity();
        Report.info("******STEPS ENDED: User enters Selling Wholesale Price and Minimum Quantity****** ");
    }

    @Then("Item should be successfully added in warehouse list")
    public void itemShouldBeSuccessfullyAddedInWarehouseList() {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED:Item should be successfully added in warehouse list****** ");
        warehouseListPage.validateAddedItemInWarehouseList();
        Report.info("******STEPS ENDED: Item should be successfully added in warehouse list****** ");
    }

    @When("User Update Selling Price as less than average purchase price")
    public void userUpdateSellingPriceAsLessThanAveragePurchasePrice() {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED:User Update Selling Price as less than average purchase price****** ");
        warehouseListPage.updateSellingPriceAsLessThanAveragePurchasePrice();
        Report.info("******STEPS ENDED: User Update Selling Price as less than average purchase price****** ");
    }

    @Then("User should be able to see error message {string}")
    public void userShouldBeAbleToSeeErrorMessage(String message) {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED:User should be able to see error message {string}****** ");
        warehouseListPage.validateErrorMessage(message);
        Report.info("******STEPS ENDED: User should be able to see error message {string}****** ");
    }

    @When("User Update Wholesale Price as less than average purchase price")
    public void userUpdateWholesalePriceAsLessThanAveragePurchasePrice() {
        warehouseListPage  = new TC002_Warehouse_List_Page(getDriver());
        Report.info("******STEPS STARTED:User Update Wholesale Price as less than average purchase price****** ");
        warehouseListPage.updateWholesalePriceAsLessThanAveragePurchasePrice();
        Report.info("******STEPS ENDED: User Update Wholesale Price as less than average purchase price****** ");
    }
}
