package page;

import cukeTests.web.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import qa.data.utils.AppSpecificUtility;
import qa.data.utils.TestBaseClass;
import qa.data.utils.log4jBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static cukeTests.web.Hooks.scenario;

public class QAPage extends AppSpecificUtility {
    private static final String COUTRYCODE = "//span[text()='+91']";
    private static final String COUTRYCODE_BUTTON = "//div[@class='css-ctzjn-control']";
    private static final String USERPHONENUMBER = "//input[@name='phoneNumber']";
    private static final String LOGINBUTTON = "//span[text()='Login']";
    private static final String PASSWORD = "//input[@id='password']";
    private static final String COMPANYNAME = "//h3[text()='wsolution']";
    private static final String CONFRIMBUTTON = "//button[text()='Confirm']";
    private static final String ITEM_MODULE = "//span[text()='Items']";
    private static final String ITEM_LIST_MODULE = "//span[text()='Items List']";
    private static final String ADD_PRODUCT = "//button[@type='button']//child::span[text()='Add Product']";
    private static final String PRODUCT_NAME = "//input[@placeholder='Product Name']";
    private static final String PRODUCT_UNIT = "//input[@placeholder='Select unit here...']";
    private static final String PRODUCT_UNIT_LIST = "//span[text()='KG']";
    private static final String CATEGORY = "//input[@placeholder='Select category']";
    private static final String CATEGORY_LIST = "//button[text()='Grocery']";
    private static final String PRICE_DATE = "//input[@id='custom_field_values[3].value']";
    private static final String PUCHASE_PRICE = "//input[@id='purchase_price']";
    private static final String SELLING_PRICE = "//input[@id='selling_price']";
    private static final String WAREHOUSE = "//span[text()='Warehouse']";
    private static final String WAREHOUSE_List = "//span[text()='ABC - Stock']";
    private static final String OPPENING_STOCK = "//input[@id='warehouseItem[0].opening_stock']";
    private static final String OPPENING_STOCK_DATE = "//input[@id='warehouseItem[0].opening_stock_date']";
    private static final String OPPENING_PURCHARE_PRICE = "//input[@id='warehouseItem[0].opening_purchase_price']";
    private static final String OPPENING_STOCK_VALUE = "//input[@id='warehouseItem[0].opening_stock_value']";
    private static final String SELLING_PRICE_WAREHOUSE = "//input[@id='warehouseItem[0].selling_price']";
    private static final String MIN_QUTANTITY = "//input[@id='warehouseItem[0].minimum_qty']";
    private static final String SAVE_BUTTON = "//button[text()='Save']";
    private static final String LENGTH = "//button[text()='Save']";


    @FindBy(xpath = COUTRYCODE)
    private WebElement contryCode;

    @FindBy(xpath = COUTRYCODE_BUTTON)
    private WebElement btn_ContryCode;

    @FindBy(xpath = USERPHONENUMBER)
    private WebElement phoneNumber;

    @FindBy(xpath = LOGINBUTTON)
    private WebElement btnLogin;

    @FindBy(xpath = PASSWORD)
    private WebElement password;

    @FindBy(xpath = COMPANYNAME)
    private WebElement companyName;

    @FindBy(xpath = CONFRIMBUTTON)
    private WebElement btnConfrim;
    @FindBy(xpath = ITEM_MODULE)
    private WebElement items;

    @FindBy(xpath = ITEM_LIST_MODULE)
    private WebElement itemsList;

    @FindBy(xpath = ADD_PRODUCT)
    private WebElement add_Product;
    @FindBy(xpath = PRODUCT_NAME)
    private WebElement Product_Name;
    @FindBy(xpath = PRODUCT_UNIT)
    private WebElement Product_Unit;

    @FindBy(xpath = PRODUCT_UNIT_LIST)
    private WebElement Product_Unit_list;

    @FindBy(xpath = CATEGORY)
    private WebElement category;

    @FindBy(xpath = CATEGORY_LIST)
    private WebElement category_List;

    @FindBy(xpath = PRICE_DATE)
    private WebElement price_Date;

    @FindBy(xpath = PUCHASE_PRICE)
    private WebElement purchase_Price;

    @FindBy(xpath = SELLING_PRICE)
    private WebElement selling_Price;

    @FindBy(xpath = WAREHOUSE)
    private WebElement warehouse;
    @FindBy(xpath = WAREHOUSE_List)
    private WebElement warehouse_List;
    @FindBy(xpath = OPPENING_STOCK)
    private WebElement opening_Stock_Value;
    @FindBy(xpath = OPPENING_STOCK_DATE)
    private WebElement opening_stock_Date;
    @FindBy(xpath = OPPENING_PURCHARE_PRICE)
    private WebElement opening_Purchase_Price;
    @FindBy(xpath = SELLING_PRICE_WAREHOUSE)
    private WebElement selling_Price_Warehouse;

    @FindBy(xpath = MIN_QUTANTITY)
    private WebElement min_Quantity;
    @FindBy(xpath = SAVE_BUTTON)
    private WebElement btnSave;


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


    public void loginUsers(String role) throws Exception {

        switch (role) {
            case "Super Admin":
                clickElement(btn_ContryCode);
                clickElement(contryCode);
                populateField(phoneNumber, prop.getProperty("User"));
                clickElement(btnLogin);
                populateField(password, prop.getProperty("Password"));
                setWait(wait).until(ExpectedConditions.visibilityOf(btnLogin));
                clickElement(btnLogin);
                Thread.sleep(DELAY_IN_MILLI_SECS);
                Hooks.captureT(scenario);

                break;

        }
    }

    public void companySelect(String company) throws Exception {

        switch (company) {
            case "wsolution":
                Thread.sleep(DELAY_IN_MILLI_SECS);
                setWait(wait).until(ExpectedConditions.visibilityOf(companyName));
                clickElement(companyName);
                setWait(wait).until(ExpectedConditions.visibilityOf(btnConfrim));
                clickElement(btnConfrim);
                Thread.sleep(DELAY_IN_MILLI_SECS);
                Hooks.captureT(scenario);
                break;

        }

    }


    public void selectModuleAndSub(String module, String sub) throws Exception {

        switch (module) {
            case "Items":
                Thread.sleep(DELAY_IN_MILLI_SECS);
                setWait(wait).until(ExpectedConditions.visibilityOf(items));
                clickElement(items);
                if (sub.equalsIgnoreCase("Items List")) {
                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    setWait(wait).until(ExpectedConditions.visibilityOf(itemsList));
                    clickElement(itemsList);
                }

                break;

        }
    }

    public void addSection(String add) throws Exception {

        switch (add) {
            case "Add Product":
                //.sleep(DELAY_IN_MILLI_SECS);
                setWait(wait).until(ExpectedConditions.visibilityOf(add_Product));
                clickElement(add_Product);
                break;

        }

    }

    public void basicItemDetails(String productName, String unit, String categoryName, String date) throws Exception {

        setWait(wait).until(ExpectedConditions.visibilityOf(Product_Name));
        populateField(Product_Name, productName);
        setWait(wait).until(ExpectedConditions.visibilityOf(Product_Unit));
        clickElement(Product_Unit);
        setWait(wait).until(ExpectedConditions.visibilityOf(Product_Unit_list));
        clickElement(Product_Unit_list);
        setWait(wait).until(ExpectedConditions.visibilityOf(category));
        clickElement(category);
        setWait(wait).until(ExpectedConditions.visibilityOf(category_List));
        clickElement(category_List);
        setWait(wait).until(ExpectedConditions.visibilityOf(price_Date));
        populateField(price_Date, date);
    }

    public void additionalInfo(String parchase, String sell) {
        populateField(purchase_Price, parchase);
        populateField(selling_Price, sell);

    }

    public void warehouseInfo(String warehouseName, String openingStock, String asOfDate, String openingPurchase,
                              String sellingPrice, String minQuantity) {
        setWait(wait).until(ExpectedConditions.visibilityOf(warehouse));
        clickElement(warehouse);
        setWait(wait).until(ExpectedConditions.visibilityOf(warehouse_List));
        clickElement(warehouse_List);


        switch (warehouseName) {
            case "ABC - Stock":
                populateField(opening_Stock_Value,openingStock);
                populateField(opening_stock_Date,asOfDate);
                populateField(opening_Purchase_Price,openingPurchase);
                populateField(selling_Price_Warehouse,sellingPrice);
                populateField(min_Quantity,minQuantity);
                break;
        }

    }

    public void storeThePrdoct(String btn){
        switch (btn){

            case "Save":
                setWait(wait).until(ExpectedConditions.visibilityOf(btnSave));
                clickElement(btnSave);
        }

    }
}
