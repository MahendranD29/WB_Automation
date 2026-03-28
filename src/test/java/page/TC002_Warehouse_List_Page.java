package page;

import cukeTests.web.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import qa.data.utils.AppSpecificUtility;
import qa.data.utils.Dictionary;
import qa.data.utils.TestBaseClass;
import qa.data.utils.log4jBaseClass;

import java.time.Duration;
import java.util.List;

import static cukeTests.web.Hooks.scenario;

public class TC002_Warehouse_List_Page extends TC001_Items_Page {

    // Warehouse List
    private static final String ADD_WAREHOUSE = "//span[text()='Add Warehouse']//ancestor::button";
    private static final String WAREHOUSE_NAME = "//input[@id='name']";
    private static final String WAREHOUSE_LOCATION = "//input[@id='address']";
    private static final String WAREHOUSE_SAVE_BTN = "//button[text()='Add Warehouse']";
    private static final String EXPECTED_WAREHOUSE_NAME = "(//div[text()='Warehouse Name']/ancestor::thead/following::tbody//child::td)[2]";
    private static final String EXPECTED_WAREHOUSE_LOCATION = "(//div[text()='Warehouse Name']/ancestor::thead/following::tbody//child::td)[3]";
    private static final String ACTIONS = "(//div[text()='Warehouse Name']/ancestor::thead/following::tbody//child::td)[8]//child::button";
    private static final String ADD_ITEMS = "(//span[text()='Add Items'])[1]";
    private static final String LIST_PRODUCT = "//button[@class='p-2 cursor-pointer hover:bg-gray-100 w-full text-start border-b']";
    private static final String SELECT_PRODUCT = "(//label[text()='Item List']/following::div)[1]";
    private static final String ADD_ITEM_WAREHOUSE = "(//span[text()='Add Item'])[1]";
    private static final String OPENING_STOCK_WAREHOUSELIST = "//input[@id='opening_stock']";
    private static final String SELLING_PRICE_WAREHOUSELIST = "(//input[@id='selling_price'])[1]";
    private static final String WHOLESALE_PRICE_WAREHOUSELIST = "(//input[@id='wholesale_price'])[1]";
    private static final String MIN_QUNATITY_WAREHOUSELIST = "(//input[@id='minimum_qty'])[1]";
    private static final String EXPECTED_ITEMNAME = "//span[text()='Quantity']/ancestor::thead/following::tbody//child::td[3]";
    private static final String EXPECTED_QUANTITY = "//span[text()='Quantity']/ancestor::thead/following::tbody//child::td[4]/child::span";
    private static final String EXPECTED_SELLINGPRICE = "//span[text()='Quantity']/ancestor::thead/following::tbody//child::td[8]//child::span";
    private static final String EXPECTED_WHOLESALEPRICE = "//span[text()='Quantity']/ancestor::thead/following::tbody//child::td[9]//child::span";
    private static final String EDIT_BTN_SELLINGPRICE = "(//span[text()='Quantity']/ancestor::thead/following::tbody//child::td[8]//child::button)[1]";
    private static final String EDIT_BTN_WHOLESALEPRICE = "(//span[text()='Quantity']/ancestor::thead/following::tbody//child::td[9]//child::button)[1]";
    private static final String EDIT_SELLING_PRICE = "(//span[text()='Quantity']/ancestor::thead/following::tbody//child::td[8]//child::input)";
    private static final String EDIT_WHOLESALE_PRICE = "(//span[text()='Quantity']/ancestor::thead/following::tbody//child::td[9]//child::input)";
    private static final String ERROR_MESSAGE = "//div[contains(@class,'toastify-container')]//div[@class='text-sm']";
    private static final String SAVE_BTN_PRICE = "//button[@title='Save (Enter)']";
    private static final String CANCEL_BTN_PRICE = "//button[@title='Cancel (Esc)']";

    @FindBy(xpath = WAREHOUSE_NAME)
    private WebElement warehouseName;

    @FindBy(xpath = WAREHOUSE_LOCATION)
    private WebElement warehouseLocation;

    @FindBy(xpath = WAREHOUSE_SAVE_BTN)
    private WebElement warehouseSave;

    @FindBy(xpath = EXPECTED_WAREHOUSE_NAME)
    private WebElement expectedWarehouseName;

    @FindBy(xpath = EXPECTED_WAREHOUSE_LOCATION)
    private WebElement expectedWarehouseLocation;

    @FindBy(xpath = ACTIONS)
    private WebElement actions;

    @FindBy(xpath = ADD_ITEMS)
    private WebElement addItems;

    @FindBy(xpath = LIST_PRODUCT)
    private List<WebElement> listProduct;

    @FindBy(xpath = ADD_ITEM_WAREHOUSE)
    private WebElement addItemWarehouse;

    @FindBy(xpath = OPENING_STOCK_WAREHOUSELIST)
    private WebElement openingStockWarehouseList;

    @FindBy(xpath = SELLING_PRICE_WAREHOUSELIST)
    private WebElement sellingPriceWarehouseList;

    @FindBy(xpath = WHOLESALE_PRICE_WAREHOUSELIST)
    private WebElement wholesalePriceWarehouseList;

    @FindBy(xpath = MIN_QUNATITY_WAREHOUSELIST)
    private WebElement minQuantityWarehouseList;

    @FindBy(xpath = SELECT_PRODUCT)
    private WebElement selectProduct;

    @FindBy(xpath = EXPECTED_ITEMNAME)
    private WebElement expectedItemName;

    @FindBy(xpath = EXPECTED_QUANTITY)
    private WebElement expectedQuantity;

    @FindBy(xpath = EXPECTED_SELLINGPRICE)
    private WebElement expectedSellingPrice;

    @FindBy(xpath = EXPECTED_WHOLESALEPRICE)
    private WebElement expectedWholesalePrice;

    @FindBy(xpath = EDIT_BTN_SELLINGPRICE)
    private WebElement editBtnSellingPrice;

    @FindBy(xpath = EDIT_BTN_WHOLESALEPRICE)
    private WebElement editBtnWholesalePrice;

    @FindBy(xpath = EDIT_SELLING_PRICE)
    private WebElement editBtnEditPrice;

    @FindBy(xpath = EDIT_WHOLESALE_PRICE)
    private WebElement editWholesalePrice;

    @FindBy(xpath = ERROR_MESSAGE)
    private WebElement errorMessage;

    @FindBy(xpath = SAVE_BTN_PRICE)
    private WebElement saveBtnPrice;

    @FindBy(xpath = CANCEL_BTN_PRICE)
    private WebElement cancelBtnPrice;


    public TC002_Warehouse_List_Page(WebDriver driver) {
        super(driver);

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

    public void userEnterWarehouseName(String name, String location) {
        setWait(wait).until(ExpectedConditions.visibilityOf(warehouseName));
        warehouseName.sendKeys(Keys.CONTROL + "a");
        warehouseName.sendKeys(Keys.DELETE);
        populateField(warehouseName, name);
        Dictionary.storeInGlobalDictionary("warehouse name", name);
        setWait(wait).until(ExpectedConditions.visibilityOf(warehouseLocation));
        warehouseLocation.sendKeys(Keys.CONTROL + "a");
        warehouseLocation.sendKeys(Keys.DELETE);
        populateField(warehouseLocation, location);
        Dictionary.storeInGlobalDictionary("location", location);
    }

    public void validateWarehouseList() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        setWait(wait).until(ExpectedConditions.visibilityOf(expectedWarehouseName));
        Assert.assertEquals(getText(expectedWarehouseName), Dictionary.getFromGlobalDictionary("warehouse name"));
        Assert.assertEquals(getText(expectedWarehouseLocation), Dictionary.getFromGlobalDictionary("location"));

    }

    public void clickOnActionButton() throws InterruptedException {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        setWait(wait).until(ExpectedConditions.visibilityOf(actions));
        clickUsingJavaScript(actions);


    }

    public void clickOn(String btn) throws InterruptedException {

        Thread.sleep(DELAY_IN_MILLI_SECS);
        if (btn.equalsIgnoreCase("Add Items")) {
            setWait(wait).until(ExpectedConditions.visibilityOf(addItems));
            clickUsingJavaScript(addItems);
            Thread.sleep(DELAY_IN_MILLI_SECS);
        } else if (btn.equalsIgnoreCase("Add Item")) {
            setWait(wait).until(ExpectedConditions.visibilityOf(addItemWarehouse));
            clickUsingJavaScript(addItemWarehouse);
        } else {
            log4jBaseClass.error("Invalid button name provided: " + btn);
            throw new IllegalArgumentException("Invalid button name: " + btn);
        }


    }

    public void selectItemFrom(String itemName) throws InterruptedException {
        Dictionary.storeInGlobalDictionary("itemName", itemName);
        By dropdown = By.xpath("//input[@placeholder='Select Item List here...']");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // wait + click input
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(dropdown));

        // JS click (safe)
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", input);

        // TYPE (now works correctly)
        input.sendKeys(itemName);

        // wait for dropdown option
        By option = By.xpath("//button[contains(text(),'" + itemName + "')]");

        WebElement optionEle = wait.until(ExpectedConditions.visibilityOfElementLocated(option));

        // click option
        js.executeScript("arguments[0].click();", optionEle);

    }

    public void enterOpeningStock() {
        setWait(wait).until(ExpectedConditions.visibilityOf(openingStockWarehouseList));
        populateField(openingStockWarehouseList, 100);
        Dictionary.storeInGlobalDictionary("opening stock warehouse", 100);
    }

    public void enterSellingWholesalePriceAndMinimumQuantity() throws InterruptedException {
        setWait(wait).until(ExpectedConditions.visibilityOf(sellingPriceWarehouseList));
        populateField(sellingPriceWarehouseList, 500);
        Dictionary.storeInGlobalDictionary("selling price warehouse", 500);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        setWait(wait).until(ExpectedConditions.visibilityOf(wholesalePriceWarehouseList));
        populateField(wholesalePriceWarehouseList, 400);
        Dictionary.storeInGlobalDictionary("wholesale price warehouse", 400);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        setWait(wait).until(ExpectedConditions.visibilityOf(minQuantityWarehouseList));
        populateField(minQuantityWarehouseList, 10);
        Dictionary.storeInGlobalDictionary("minimum quantity warehouse", 10);
    }

    public void validateAddedItemInWarehouseList() {
        // item name
        Assert.assertEquals(getText(expectedItemName), Dictionary.getFromGlobalDictionary("itemName"));
        // Quatity
        Assert.assertEquals(getText(expectedQuantity).split(",")[0], Dictionary.getFromGlobalDictionary("quantity").toString());

//        // Selling Price
//        Assert.assertEquals(getText(expectedSellingPrice).replace("₹", "").trim(), Dictionary.getFromGlobalDictionary("selling price warehouse").toString());
//
//        // Wholesale Price
//        Assert.assertEquals(getText(expectedWholesalePrice).replace("₹", "").trim(), Dictionary.getFromGlobalDictionary("selling price warehouse").toString());


    }

    public void updateSellingPriceAsLessThanAveragePurchasePrice() {
        clickUsingJavaScript(editBtnSellingPrice);
        setWait(wait).until(ExpectedConditions.visibilityOf(editBtnEditPrice));
        editBtnEditPrice.sendKeys(Keys.CONTROL + "a");
        editBtnEditPrice.sendKeys(Keys.DELETE);
        populateField(editBtnEditPrice, 80);
        clickUsingJavaScript(saveBtnPrice);

    }

    public void validateErrorMessage(String message) {
        setWait(wait).until(ExpectedConditions.visibilityOf(errorMessage));
        Assert.assertEquals(getText(errorMessage), message);
        clickUsingJavaScript(cancelBtnPrice);
    }

    public void updateWholesalePriceAsLessThanAveragePurchasePrice(){
        clickUsingJavaScript(editBtnWholesalePrice);
        setWait(wait).until(ExpectedConditions.visibilityOf(editWholesalePrice));
        editWholesalePrice.sendKeys(Keys.CONTROL + "a");
        editWholesalePrice.sendKeys(Keys.DELETE);
        populateField(editWholesalePrice, 80);
        clickUsingJavaScript(saveBtnPrice);
    }

}
