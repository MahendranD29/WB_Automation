package cukeTests.web.step;

import cukeTests.web.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.data.utils.Report;
import page.TC001_Items_Page;

import static qa.data.utils.TestBaseClass.getDriver;

public class TC001_Items_Stepdefination {
    String ScenarioName = Hooks.scenario.getName();
    TC001_Items_Page QAPage;


    @When("User login on {string} in Wakanda Books")
    public void userLoginOnInWakandaBooks(String role) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User login on {string} in Wakanda Books****** ");
        QAPage.loginUsers(role);
        Report.info("******STEPS ENDED: User login on {string} in Wakanda Books****** ");
    }

    @When("User select {string} on login page")
    public void userSelectOnLoginPage(String company) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User select {string} on login page****** ");
        QAPage.companySelect(company);
        Report.info("******STEPS ENDED: User select {string} on login page****** ");
    }

    @When("User clicks on {string} and Select {string}")
    public void userClicksOnAndSelect(String module, String sub) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User clicks on {string} and Select {string}****** ");
        QAPage.selectModuleAndSub(module, sub);
        Report.info("******STEPS ENDED: User clicks on {string} and Select {string}****** ");
    }

    @When("User clicks on {string} in Items list")
    public void userClicksOnInItemsList(String add) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User clicks on {string} in Items list****** ");
        QAPage.addSection(add);
        Report.info("******STEPS ENDED: User clicks on {string} in Items list****** ");
    }


    @And("User add {string} and {string},{string},{string},{string},{string} details in add products")
    public void userAddAndDetailsInAddProducts(String unit, String category, String lenth, String depth, String size, String quality) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User add {string} and {string},{string},{string},{string},{string} details in add products****** ");
        QAPage.basicItemDetails(unit, category, lenth, depth, size, quality);
        Report.info("******STEPS ENDED: User add {string} and {string},{string},{string},{string},{string} details in add products****** ");
    }


    @And("User add price details {string} and {string} {string} in Additional Information")
    public void userAddPriceDetailsAndInAdditionalInformation(String parchase, String sell, String vendor) throws InterruptedException {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED:User add price details {string} and {string} {string} in Additional Information****** ");
        QAPage.additionalInfo(parchase, sell, vendor);
        Report.info("******STEPS ENDED: User add price details {string} and {string} {string} in Additional Information****** ");
    }


    @And("User select {string} details and Information details")
    public void userSelectDetailsAndInformationDetails(String warehouse) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User select {string} details and Information details****** ");
        QAPage.fillWarehouseInfo(warehouse);
        Report.info("******STEPS ENDED: User select {string} details and Information details****** ");
    }

    @When("User Clicks on {string} in Wakanda Books")
    public void userClicksOnInWakandaBooks(String store) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Clicks on {string} in Wakanda Books****** ");
        QAPage.storeThePrdoct(store);
        Report.info("******STEPS ENDED:User Clicks on {string} in Wakanda Books****** ");
    }


    @Then("User Validate the in Items List")
    public void userValidateTheProductInItemsList() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the Product in Items List****** ");
        QAPage.validateItem();
        Report.info("******STEPS ENDED:User Validate the Product in Items List****** ");
    }


    @And("User Field as {string} and add Values {string}, {string},{string},{string} details")
    public void userFieldAsAndAddValuesDetailsInAddProducts(String dep, String name, String unitSymbol, String unitname, String category) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Field as {string} and add Values {string}, {string},{string} details****** ");
        QAPage.entersDetils(dep, name, unitSymbol, unitname, category);
        Report.info("******STEPS ENDED: User Field as {string} and add Values {string}, {string},{string} details****** ");
    }

    @And("User add Additional {string} Information details")
    public void userAddInAdditionalInformationDetails(String vendor) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED:User add {string} in Additional Information details****** ");
        QAPage.fillAdditionalInfo(vendor);
        Report.info("******STEPS ENDED: User add {string} in Additional Information details****** ");
    }

    @When("User clicks on {string} and fill the details")
    //@When("User cliks on {string} and fill the detaitais")
    public void userCliksOnAndFillTheDetaitais(String action) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User clicks on action and fill the details****** ");
        QAPage.actions(action);
        Report.info("******STEPS ENDED: User clicks on action and fill the details****** ");
    }

    @When("User fill the update details")
//    @When("User fill the update detaitais")
    public void userFillTheUpdateDetaitais() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User fill the update details****** ");
        QAPage.updateFiled_Product();
        Report.info("******STEPS ENDED: User fill the update details****** ");
    }


    @When("User Clicks on delete in Wakanda Books")
    public void userClicksOnDeleteInWakandaBooks() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Clicks on delete in Wakanda Books****** ");
        QAPage.clickDelete();
        Report.info("******STEPS ENDED: User Clicks on delete in Wakanda Books****** ");
    }


    @Then("User validated updated the message")
    public void userValidatedUpdatedTheMessage() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User validated updated the message****** ");
        QAPage.validateUpdate();
        Report.info("******STEPS ENDED: User validated updated the message****** ");
    }

    @Then("User validated deleted the message")
    public void userValidatedDeletedTheMessage() throws InterruptedException {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User validated deleted the message****** ");
        QAPage.validateDelete();
        Report.info("******STEPS ENDED: User validated deleted the message****** ");
    }

    @When("User Click on {string} module")
    public void userClickOnModule(String button) {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Click on {string} module****** ");
        QAPage.clickOnButton(button);
        Report.info("******STEPS ENDED: User Click on {string} module****** ");
    }

    @And("User add price details and in Additional Information")
    public void userAddPriceDetailsAndInAdditionalInformation() {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User add price details and in Additional Information****** ");
        QAPage.addtionalInfo();
        Report.info("******STEPS ENDED: User add price details and in Additional Information****** ");
    }

    @Then("User Validate the View Page")
    public void userValidateTheViewPage() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the View in {string}****** ");
        QAPage.validateView();
        Report.info("******STEPS ENDED: User Validate the View in {string}****** ");
    }

    @When("User Clicks on deleted List")
    public void userClicksOnDeletedList() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Clicks on deleted List****** ");
        QAPage.list_Deleted();
        Report.info("******STEPS ENDED: User Clicks on deleted List****** ");
    }

    @Then("User validated deleted Item")
    public void userValidatedDeletedItem() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User validated deleted Item****** ");
        QAPage.validate_Delete_List();
        Report.info("******STEPS ENDED: User validated deleted Item****** ");
    }

    @When("User Restore the deleted item")
    @When("User Restore the deteted item")
    public void userRestoreTheDetetedItem() {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Restore the deleted item****** ");
        QAPage.restoreItem();
        Report.info("******STEPS ENDED: User Restore the deleted item****** ");
    }


    @Then("User Validate the Restore the item")
    public void userValidateTheRestoreTheItem() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the Restore the item****** ");
        QAPage.validateRestoreItem();
        Report.info("******STEPS ENDED: User Validate the Restore the item****** ");
    }

    @And("User enter {string} details with name {string} unit {string} and category {string}")
    public void userEnterDetailsWithNameUnitAndCategory(String dep, String itemName, String unit, String category) {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User enter {string} details with name {string} unit {string} and category {string}****** ");
        QAPage.addItemWithoutMandotryFileds(dep, itemName, unit, category);
        Report.info("******STEPS ENDED: User enter {string} details with name {string} unit {string} and category {string}****** ");
    }

    @Then("User should see validation message {string} and product should not be created")
    public void userShouldSeeValidationMessageAndProductShouldNotBeCreated(String message) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User should see validation message {string} and product should not be created****** ");
        QAPage.validate_ErrorMassge(message);
        Report.info("******STEPS ENDED: User should see validation message {string} and product should not be created****** ");
    }

    @And("User Click on {string} option")
    public void userClickOnOption(String option) {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Click on {string} option****** ");
        QAPage.categoryOption(option);
        Report.info("******STEPS ENDED: User Click on {string} option****** ");
    }

    @And("User Enter the {string}name and Description")
    public void userEnterTheNameAndDescription(String categoryName) throws InterruptedException {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Enter the {string}name and Description****** ");
        QAPage.categoryCreation(categoryName);
        Report.info("******STEPS ENDED: User Enter the {string}name and Description****** ");
    }


    @Then("User Validate the in List")
    public void userValidateTheInList() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the in List****** ");
        QAPage.validate_Category();
        Report.info("******STEPS ENDED: User Validate the in List****** ");
    }

    @Then("User validated deleted Item in category")
    public void userValidatedDeletedItemInCategory() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User validated deleted Item in category****** ");
        QAPage.validate_Delete_Category();
        Report.info("******STEPS ENDED: User validated deleted Item in category****** ");
    }

    @Then("User Validate the Restore the item in category")
    public void userValidateTheRestoreTheItemInCategory() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the Restore the item in category****** ");
        QAPage.validateRestoreItem_Category();
        Report.info("******STEPS ENDED: User Validate the Restore the item in category****** ");
    }

    @And("User Enter the {string}name and {string}")
    public void userEnterTheNameAnd(String name, String symbol) {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Enter the {string}name and {string}****** ");
        QAPage.create_Unit(name, symbol);
        Report.info("******STEPS ENDED: User Enter the {string}name and {string}****** ");
    }

    @Then("User Validate the in List on Unit")
    public void userValidateTheInListOnUnit() {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the in List on Unit****** ");
        QAPage.valid_Text();
        Report.info("******STEPS ENDED: User Validate the in List on Unit****** ");
    }


    @When("User clicks on Edit Button")
    @When("User cliks on Edit Button")
    public void userCliksOnEditButton() {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User clicks on Edit Button****** ");
        QAPage.edit_Unit();
        Report.info("******STEPS ENDED: User clicks on Edit Button****** ");
    }

    @When("User clicks on Delete Button")
    @When("User cliks on Delete Button")
    public void userCliksOnDeleteButton() {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User clicks on Delete Button****** ");
        QAPage.delete_Unit();
        Report.info("******STEPS ENDED: User clicks on Delete Button****** ");
    }

    @Then("User validated deleted Unit Validation")
    public void userValidatedDeletedUnitValidation() {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User validated deleted Unit Validation****** ");
        QAPage.delete_Unit();
        Report.info("******STEPS ENDED: User validated deleted Unit Validation****** ");
    }

    @Then("User Validate the Item in Full validation")
    public void userValidateTheItemInFullValidation() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the Item in Full validation****** ");
        QAPage.validateItemInFullValidation();
        Report.info("******STEPS ENDED: User Validate the Item in Full validation****** ");
    }


    @And("User Field Values {string}, {string},{string},{string},{string} details")
    public void userFieldValuesDetails(String productName, String unitSymbol, String UnitName, String alternative_Unit, String Category) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Field Values {string}, {string},{string},{string},{string} details****** ");
        QAPage.alternative_details(productName, unitSymbol, UnitName, alternative_Unit, Category);
        Report.info("******STEPS ENDED: User Field Values {string}, {string},{string},{string},{string} details****** ");
    }

    @Then("User Validate the Service View Page")
    public void userValidateTheServiceViewPage() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the Service View Page****** ");
        QAPage.validate_ServiceView();
        Report.info("******STEPS ENDED: User Validate the Service View Page****** ");
    }

    @Then("User fill the update details in Service")
    public void userFillTheUpdateDetailsInService() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User fill the update details in Service****** ");
        QAPage.update_Service_Details();
        Report.info("******STEPS ENDED: User fill the update details in Service****** ");
    }

    @Then("User validated updated the message in Service")
    public void userValidatedUpdatedTheMessageInService() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User validated updated the message in Service****** ");
        QAPage.validate_Service_Details();
        Report.info("******STEPS ENDED: User validated updated the message in Service****** ");
    }

    @Then("User Validate the list before {string} Creation")
    public void userValidateTheListBeforeCreation(String name) {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the list before {string} Creation****** ");
        QAPage.validate_List_Before_Creation(name);
        Report.info("******STEPS ENDED: User Validate the list before {string} Creation****** ");
    }

    @Then("User Validate the list before {string} Creation in service")
    public void userValidateTheListBeforeCreationInService(String name) {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the list before {string} Creation****** ");
        QAPage.validate_List_Before_Creation_Service_List(name);
        Report.info("******STEPS ENDED: User Validate the list before {string} Creation****** ");
    }

    @Then("User Validate the in Service List")
    public void userValidateTheInServiceList() {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the in Service List****** ");
        QAPage.validate_Service_List();
        Report.info("******STEPS ENDED: User Validate the in Service List****** ");
    }

    @Then("User Validate the Warehouse in Item details")
    public void userValidateTheWarehouseInItemDetails(String warehouse) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the Warehouse in Item details****** ");
        QAPage.validate_the_Product_In_Warehouse(warehouse);
        Report.info("******STEPS ENDED: User Validate the Warehouse in Item details****** ");
    }

    @Then("User Validate the {string} in Item details")
    public void userValidateTheInItemDetails(String warehouse) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the {string} in Item details****** ");
        QAPage.validate_the_Product_In_Warehouse(warehouse);
        Report.info("******STEPS ENDED: User Validate the {string} in Item details****** ");
    }

    @When("User enters product name {string} in search field")
    public void userEntersProductNameInSearchField(String name) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User enters product name {string} in search field****** ");
        QAPage.searchProduct(name);
        Report.info("******STEPS ENDED: User enters product name {string} in search field****** ");
    }

    @Then("Product with name {string} should be displayed in the list")
    public void productWithNameShouldBeDisplayedInTheList(String name) {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: Product with name {string} should be displayed in the list****** ");
        QAPage.validateSearchedProduct(name);
        Report.info("******STEPS ENDED: Product with name {string} should be displayed in the list****** ");
    }

    @When("User enters product ref id in search field")
    public void userEntersProductRefIdInSearchField() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User enters product ref id in search field****** ");
        QAPage.searchProductRefId();
        Report.info("******STEPS ENDED: User enters product ref id in search field****** ");
    }

    @Then("Product with ref id should be displayed in the list")
    public void productWithRefIdShouldBeDisplayedInTheList() {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: Product with ref id should be displayed in the list****** ");
        QAPage.validateSearchedProductRefId();
        Report.info("******STEPS ENDED: Product with ref id should be displayed in the list****** ");
    }


    @Then("No product should be displayed and user should see message {string}")
    public void noProductShouldBeDisplayedAndUserShouldSeeMessage(String message) {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: No product should be displayed and user should see message {string}****** ");
        QAPage.validateNoProductAndMessage(message);
        Report.info("******STEPS ENDED: No product should be displayed and user should see message {string}****** ");
    }

    @When("User clicks on category filter")
    public void userClicksOnCategoryFilter() throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User clicks on category filter****** ");
        QAPage.clickCategoryFilter();
        Report.info("******STEPS ENDED: User clicks on category filter****** ");
    }

    @When("User Search the category {string} in category filter")
    public void userSearchTheCategoryInCategoryFilter(String category) throws InterruptedException {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Search the category {string} in category filter****** ");
        QAPage.searchCategoryInFilter(category);
        Report.info("******STEPS ENDED: User Search the category {string} in category filter****** ");
    }

    @When("User selects category {string}")
    public void userSelectsCategory(String category) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User selects category {string}****** ");
        QAPage.selectCategory(category);
        Report.info("******STEPS ENDED: User selects category {string}****** ");

    }

    @Then("Only products from category {string} should be displayed")
    public void onlyProductsFromCategoryShouldBeDisplayed(String category) throws InterruptedException {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: Only products from category {string} should be displayed****** ");
        QAPage.validateProductsFromCategory(category);
        Report.info("******STEPS ENDED: Only products from category {string} should be displayed****** ");

    }

    @Then("Product {string} should be displayed under {string}")
    public void productShouldBeDisplayedUnder(String Product, String Category) {
            QAPage = new TC001_Items_Page(getDriver());
            Report.info("******STEPS STARTED: Product {string} should be displayed under {string}****** ");
            QAPage.validateProductUnderTheCategory(Product, Category);
            Report.info("******STEPS ENDED: Product {string} should be displayed under {string}****** ");
    }

    @And("User select the {string} details and Information details")
    public void userSelectTheDetailsAndInformationDetails(String Warehouse) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
            Report.info("******STEPS STARTED: User select the {string} details and Information details****** ");
            QAPage.fillWarehouseInformation(Warehouse);
            Report.info("******STEPS ENDED: User select the {string} details and Information details****** ");
    }

    @Then("Error message should be displayed {string}")
    public void errorMessageShouldBeDisplayed(String errorMessage) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: Error message should be displayed {string}****** ");
        QAPage.validateErrorMessage(errorMessage);
        Report.info("******STEPS ENDED: Error message should be displayed {string}****** ");
    }

    @And("User select the {string} and enter selling price less than purchase price details")
    public void userSelectTheAndEnterSellingPriceLessThanPurchasePriceDetails(String warehouse) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User select the {string} and enter selling price less than purchase price details****** ");
        QAPage.enterSellingPriceLessThanPurchasePrice(warehouse);
        Report.info("******STEPS ENDED: User select the {string} and enter selling price less than purchase price details****** ");
    }

    @And("User select the {string} and enter Wholesale price less than purchase price details")
    public void userSelectTheAndEnterWholesalePriceLessThanPurchasePriceDetails(String Warehouse) throws Exception {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User select the {string} and enter Wholesale price less than purchase price details****** ");
        QAPage.enterWholesalePriceLessThanPurchasePrice(Warehouse);
        Report.info("******STEPS ENDED: User select the {string} and enter Wholesale price less than purchase price details****** ");
    }

    @Then("User Validate the error message {string}")
    public void userValidateTheErrorMessage(String errorMessage) throws Exception {
            QAPage = new TC001_Items_Page(getDriver());
            Report.info("******STEPS STARTED: User Validate the error message {string}****** ");
            QAPage.validateErrorMessage(errorMessage);
            Report.info("******STEPS ENDED: User Validate the error message {string}****** ");
    }

    @When("User Clicks on Transaction Tab in Item details")
    public void userClicksOnTransactionTabInItemDetails() {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Clicks on Transaction Tab in Item details****** ");
        QAPage.clickTransactionTab();
        Report.info("******STEPS ENDED: User Clicks on Transaction Tab in Item details****** ");
    }

    @Then("User Validate the in Transaction List")
    public void userValidateTheInTransactionList() {
        QAPage = new TC001_Items_Page(getDriver());
        Report.info("******STEPS STARTED: User Validate the in Transaction List****** ");
        QAPage.validateTransactionList();
        Report.info("******STEPS ENDED: User Validate the in Transaction List****** ");
    }


}
