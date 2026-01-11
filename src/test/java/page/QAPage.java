package page;

import cukeTests.web.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import qa.data.utils.AppSpecificUtility;
import qa.data.utils.Dictionary;
import qa.data.utils.TestBaseClass;
import qa.data.utils.log4jBaseClass;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private static final String NAME = "(//input[@id='name'])[1]";
    private static final String UNIT = "//input[@placeholder='Select unit here...']";
    private static final String KG_TEXT = "//span[text()='KG']";
    private static final String PCS_BUTTON = "//span[text()='pcs']/..";
    private static final String CATEGORY = "//input[@placeholder='Select category']";
    private static final String GROCERY_TEXT = "//button[text()='Grocery']";
    private static final String COMICS_TEXT = "//button[text()='Comics']']";
    private static final String PRICE_DATE = "//input[@id='custom_field_values[3].value']";
    private static final String PUCHASE_PRICE = "//input[@id='purchase_price']";
    private static final String SELLING_PRICE = "//input[@id='selling_price']";
    private static final String WAREHOUSE = "//span[text()='Warehouse']";
    private static final String ABC_STOCK_BUTTON = "//span[text()='Tony Warehouse']";
    private static final String OPPENING_STOCK = "//input[@id='warehouseItem[0].opening_stock']";
    private static final String OPPENING_STOCK_DATE = "//input[@id='warehouseItem[0].opening_stock_date']";
    private static final String OPPENING_PURCHARE_PRICE = "//input[@id='warehouseItem[0].opening_purchase_price']";
    private static final String OPPENING_STOCK_VALUE = "//input[@id='warehouseItem[0].opening_stock_value']";
    private static final String SELLING_PRICE_WAREHOUSE = "//input[@id='warehouseItem[0].selling_price']";
    private static final String MIN_QUTANTITY = "//input[@id='warehouseItem[0].minimum_qty']";
    private static final String SAVE_BUTTON = "//button[text()='Save']";
    private static final String LENGTH = "//input[@id='custom_field_values[0].value']";
    private static final String DEPTH = "//input[@id='custom_field_values[1].value']";
    private static final String SIZE = "//input[@id='custom_field_values[2].value']";
    private static final String MATRIALQUALITY = "//input[@id='custom_field_values[4].value']";
    private static final String KNOWNVENDOR = "/html/body/div/div[1]/div/div/div[2]/main/div/div/main[1]/section/div/form/div[3]/div/div[4]/div/div/div/div/div[1]/div[2]/input";
    private static final String TXT_ITEM = "(//div[@class='text-text-primary text-[12px] font-[400] flex justify-between gap-1'])[1]";
    private static final String EDIT = "//span[text()='Edit']";
    private static final String WHOLESALE_PRICE = "//input[@id='wholesale_price']";
    private static final String TXT_UPDATE = "//div[text()='Item updated successfully!']";
    private static final String DELETE = "//span[text()='Delete']";
    private static final String DELETE_BUTTON = "//button[text()='Delete']";
    private static final String TXT_DELETE = "//p[text()='Your file has been deleted.']";
    private static final String DELETED_LIST = "//button[text()='Deleted']";
    private static final String LIST = "//button[text()='List']";
    private static final String ID = "(//span[@class='text-text-secondary'])[1]";
    private static final String ITEM_CODE = "(//td[contains(@class,'p-[6px] text-[14px] text-text-secondary')])[1]";
    private static final String RESTORE_NANE = "(//td[contains(@class,'p-[6px] text-[14px] text-text-secondary')])[3]";
    private static final String SELECT_DELETE_ITEM = "(//input[@type='checkbox'])[2]";
    private static final String RESTORE_ITEM = "//button[text()='Restore Items']";
    private static final String ITEM_NAME = "(//td[@class=\"p-[6px] text-[14px] text-text-secondary font-normal px-6 border border-border-inactive text-center align-middle\"])[4]";


    // Services Section
    private static final String SERVICE_BUTTON = "//button[text()='Service']";
    private static final String ADD_SERVICE_BUTTON = "(//span[text()='Add Service'])[1]";
    private static final String SERVICE_NAME = "//input[@placeholder='Service Name']";
    private static final String SERVICE_UNIT_LIST = "//div[@class='max-h-60 overflow-y-auto z-40']//button";
    private static final String ELECTRONIC = "//button[text()='Electronics Service']";
    private static final String SERVICE_CATEGORY_LIST = "//button[text()='Mobile Repairing']";
    private static final String DESCRIPTION_BOX = "//textarea[@name='description']";
    private static final String ADD_CATEGORY = "//span[text()='Add Category']/parent::button";
    private static final String ADD_UNIT = "//span[text()='Add Unit']";
    private static final String UNIT_NAME = "//input[@placeholder='Enter Primary Unit']";
    private static final String UNIT_SYMBOL = "//input[@placeholder='Enter Primary Unit Symbol']";
    private static final String UNIT_BUTTON = "//button[text()='Add Unit']";
    private static final String TYPE_PRODUCT = "//span[text()='Product']/parent::label";
    private static final String TYPE_SERVICE = "//span[text()='Service']/parent::label";
    private static final String CATEGORY_NAME = "//input[@placeholder='Write the Category here...']";
    private static final String CATEGORY_DESCRIPTION = "//input[@id='description']";
    private static final String SAVE_CATEGORY = "//button[text()='Save Category']";
    private static final String UPDATE_CATEGORY = "//button[text()='Update Category']";

    private static final String VIEW = "//span[text()='View']/ancestor::button";
    private static final String NEW_UNIT_BTN = "//span[text()='Add Unit']/parent::button";
    private static final String CATEGORY_SECTION = "//button[text()='Category']";
    private static final String ADD_CATEGORY_BTN = "//span[text()='Add Category']//ancestor::button";
    private static final String TXT_CATEGORY = "(//p[@class=\"text-[#606770] text-[14px] font-[400]\"])[1]";
    private static final String CATEGORY_SUCCESS = "//div[@class='text-sm']";
    private static final String UNIT_SECTION = "//button[text()='Unit']";
    private static final String ADD_UNIT_BUTTON = "//span[text()='Add Unit']";
    private static final String TXT_UNIT_NAME = "//input[@placeholder='Enter Primary Unit']";
    private static final String TXT_UNIT_SYMBOL = "//input[@id='symbol']";
    private static final String UNIT_TEXT_VALID = "//span[@class='font-[400] text-[#606770]  text-start pl-2']";
    private static final String EDIT_UNIT = "(//img[@alt='Delete']/parent::button)[1]";
    private static final String DELETE_UNIT = "(//img[@alt='Delete']/parent::button)[2]";
    private static final String UPDATE_UNIT = "//button[text()='Update Unit']";


    @FindBy(xpath = UNIT_SECTION)
    private WebElement unit_Section;

    @FindBy(xpath = EDIT_UNIT)
    private WebElement edit_Unit;

    @FindBy(xpath = DELETE_UNIT)
    private WebElement delete_Unit;

    @FindBy(xpath = UPDATE_UNIT)
    private WebElement update_Unit;

//    @FindBy(xpath = UNIT_TEXT_VALID)
//    private List<WebElement> txt_Unit_Valid;

//    @FindBy(xpath = ADD_UNIT_BUTTON)
//    private WebElement add_Unit;

    @FindBy(xpath = TXT_UNIT_NAME)
    private WebElement txt_Unit_Name;

    @FindBy(xpath = TXT_UNIT_SYMBOL)
    private WebElement txt_Unit_Symbol;

    @FindBy(xpath = COUTRYCODE)
    private WebElement contryCode;


    @FindBy(xpath = NEW_UNIT_BTN)
    private WebElement btn_New_Unit;

    @FindBy(xpath = COUTRYCODE_BUTTON)
    private WebElement btn_ContryCode;

    @FindBy(xpath = USERPHONENUMBER)
    private WebElement phoneNumber;

    @FindBy(xpath = LOGINBUTTON)
    private WebElement btnLogin;

    @FindBy(xpath = PASSWORD)
    private WebElement password;

    @FindBy(xpath = PCS_BUTTON)
    private WebElement pcs;

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
    @FindBy(xpath = NAME)
    private WebElement Product_Name;
    @FindBy(xpath = UNIT)
    private WebElement Unit;

    @FindBy(xpath = KG_TEXT)
    private WebElement kg;

    @FindBy(xpath = CATEGORY)
    private WebElement category;

    @FindBy(xpath = GROCERY_TEXT)
    private WebElement grocery;

    @FindBy(xpath = COMICS_TEXT)
    private WebElement comics;

    @FindBy(xpath = PRICE_DATE)
    private WebElement price_Date;

    @FindBy(xpath = PUCHASE_PRICE)
    private WebElement purchase_Price;

    @FindBy(xpath = SELLING_PRICE)
    private WebElement selling_Price;

    @FindBy(xpath = WAREHOUSE)
    private WebElement warehouse;

    @FindBy(xpath = ABC_STOCK_BUTTON)
    private WebElement abcStock;

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

    @FindBy(xpath = KNOWNVENDOR)
    private WebElement knownVendor;

    @FindBy(xpath = LENGTH)
    private WebElement length;

    @FindBy(xpath = DEPTH)
    private WebElement depth;

    @FindBy(xpath = SIZE)
    private WebElement size;

    @FindBy(xpath = MATRIALQUALITY)
    private WebElement matrialQuality;

    @FindBy(xpath = TXT_ITEM)
    private WebElement item_Name;

    @FindBy(xpath = ID)
    private WebElement id_Item;

    @FindBy(xpath = ITEM_CODE)
    private WebElement item_Code;

    @FindBy(xpath = VIEW)
    private WebElement view;

    @FindBy(xpath = DELETED_LIST)
    private WebElement deleted_List;

    @FindBy(xpath = LIST)
    private WebElement list;

    @FindBy(xpath = SELECT_DELETE_ITEM)
    private WebElement chk_Box_Delete_Item;

    @FindBy(xpath = RESTORE_ITEM)
    private WebElement restore;


    @FindBy(xpath = SERVICE_BUTTON)
    private WebElement serive_Section;

    @FindBy(xpath = ADD_SERVICE_BUTTON)
    private WebElement btn_AddSerivce;

    @FindBy(xpath = SERVICE_NAME)
    private WebElement txt_Service_Name;

    @FindBy(xpath = EDIT)
    private WebElement edit;

    @FindBy(xpath = SERVICE_UNIT_LIST)
    private WebElement txt_Service_Unit_List;

    @FindBy(xpath = WHOLESALE_PRICE)
    private WebElement wholesale_Price;

    @FindBy(xpath = TXT_UPDATE)
    private WebElement txt_Update;

    @FindBy(xpath = DELETE)
    private WebElement delete;

    @FindBy(xpath = DELETE_BUTTON)
    private WebElement btn_Delete;

    @FindBy(xpath = TXT_DELETE)
    private WebElement txt_Delete;

    @FindBy(xpath = DESCRIPTION_BOX)
    private WebElement description;

    @FindBy(xpath = ELECTRONIC)
    private WebElement electronic;

    @FindBy(xpath = ADD_CATEGORY)
    private WebElement add_Category;

    @FindBy(xpath = ADD_UNIT)
    private WebElement add_Unit;

    @FindBy(xpath = UNIT_NAME)
    private WebElement unit_Name;

    @FindBy(xpath = UNIT_SYMBOL)
    private WebElement symbol;

    @FindBy(xpath = UNIT_BUTTON)
    private WebElement btn_Add_Unit;

    @FindBy(xpath = TYPE_PRODUCT)
    private WebElement type_Prpduct;

    @FindBy(xpath = TYPE_SERVICE)
    private WebElement type_Service;

    @FindBy(xpath = CATEGORY_NAME)
    private WebElement category_Name;

    @FindBy(xpath = CATEGORY_DESCRIPTION)
    private WebElement category_Description;

    @FindBy(xpath = SAVE_CATEGORY)
    private WebElement save_Category;

    @FindBy(xpath = UPDATE_CATEGORY)
    private WebElement update_Category;

    @FindBy(xpath = ITEM_NAME)
    private WebElement delete_Item_Name;

    @FindBy(xpath = CATEGORY_SECTION)
    private WebElement category_Section;

    @FindBy(xpath = ADD_CATEGORY_BTN)
    private WebElement btn_Add_Category;

    @FindBy(xpath = TXT_CATEGORY)
    private WebElement txt_Category;

    @FindBy(xpath = CATEGORY_SUCCESS)
    private WebElement category_Success_Mesg;

    @FindBy(xpath = RESTORE_NANE)
    private WebElement restore_Name;


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
                break;

        }
    }

    public void companySelect(String company) throws Exception {

        switch (company) {
            case "wsolution":
                Hooks.captureT(scenario);
                setWait(wait).until(ExpectedConditions.visibilityOf(companyName));
                clickElement(companyName);
                setWait(wait).until(ExpectedConditions.visibilityOf(btnConfrim));
                clickElement(btnConfrim);
                Hooks.captureT(scenario);
                break;

        }

    }


    public void selectModuleAndSub(String module, String sub) throws Exception {

        switch (module) {
            case "Items":
                //Thread.sleep(DELAY_IN_MILLI_SECS);
                setWait(wait).until(ExpectedConditions.visibilityOf(items));
                clickElement(items);
                if (sub.equalsIgnoreCase("Items List")) {
                    //Thread.sleep(DELAY_IN_MILLI_SECS);
                    setWait(wait).until(ExpectedConditions.visibilityOf(itemsList));
                    clickElement(itemsList);
                }

                break;

        }
    }

    List<WebElement> elements;

    public void clickOnButton(String button) {
        switch (button) {
            case "Service":
                setWait(wait).until(ExpectedConditions.visibilityOf(serive_Section));
                clickOperation(serive_Section);
                elements = getDriver().findElements(By.xpath("//button[contains(@class,'border-b w-full')]"));
                break;

            case "Category":
                setWait(wait).until(ExpectedConditions.visibilityOf(category_Section));
                clickOperation(category_Section);
                setWait(wait).until(ExpectedConditions.visibilityOf(txt_Category));
                String expectedtext = getText(txt_Category);
                Dictionary.storeInGlobalDictionary("Category Name", expectedtext);
                break;

            case "Unit":
                setWait(wait).until(ExpectedConditions.visibilityOf(unit_Section));
                clickOperation(unit_Section);
//                setWait(wait).until(ExpectedConditions.visibilityOf(txt_Category));
//                String expectedtext = getText(txt_Category);
//                Dictionary.storeInGlobalDictionary("Category Name", expectedtext);
                break;
        }

    }

    public void addSection(String add) throws Exception {

        switch (add) {
            case "Add Product":
                setWait(wait).until(ExpectedConditions.visibilityOf(add_Product));
                clickElement(add_Product);
                break;
            case "Add Service":
                setWait(wait).until(ExpectedConditions.visibilityOf(btn_AddSerivce));
                clickElement(btn_AddSerivce);
                break;
            case "Add Category":
                setWait(wait).until(ExpectedConditions.visibilityOf(btn_Add_Category));
                clickElement(btn_Add_Category);
                break;
            case "Add Unit":
                setWait(wait).until(ExpectedConditions.visibilityOf(add_Unit));
                clickElement(add_Unit);
                break;

//            case " ":
//                setWait(wait).until(ExpectedConditions.visibilityOf(update_Unit));
//                clickElement(update_Unit);
//                break;
//
//            case "Delete":
//                setWait(wait).until(ExpectedConditions.visibilityOf(delete_Unit));
//                clickElement(delete_Unit);
//                break;


        }

    }

    public void entersDetils(String dep, String name, String unit, String categoryField) throws Exception {
        String unitList = "//span[text()='" + unit + "']";
        String categoryList = "//button[text()='" + categoryField + "']";
        switch (dep) {
            case "Product":
                setWait(wait).until(ExpectedConditions.visibilityOf(Product_Name));
                populateField(Product_Name, name);
                Dictionary.storeInGlobalDictionary("Product", name);
                setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                clickElement(Unit);
                if (getDriver().findElement(By.xpath(unitList)).getText().equalsIgnoreCase(unit)) {
                    getDriver().findElement(By.xpath(unitList)).click();
                    setWait(wait).until(ExpectedConditions.visibilityOf(category));
                    clickElement(category);

                    if (getDriver().findElement(By.xpath(categoryList)).getText().equalsIgnoreCase(categoryField)) {
                        getDriver().findElement(By.xpath(categoryList)).click();
                    } else {
                        setWait(wait).until(ExpectedConditions.visibilityOf(add_Category));
                        clickElement(add_Category);
                        setWait(wait).until(ExpectedConditions.visibilityOf(type_Prpduct));
                        clickElement(type_Prpduct);
                        populateField(category_Name, categoryField);
                        populateField(category_Description, "Good");
                        setWait(wait).until(ExpectedConditions.visibilityOf(save_Category));
                        clickElement(save_Category);
                        setWait(wait).until(ExpectedConditions.visibilityOf(category));
                        clickElement(category);
                        getDriver().findElement(By.xpath(categoryList)).click();
                    }
                } else {
                    setWait(wait).until(ExpectedConditions.visibilityOf(btn_New_Unit));
                    clickElement(btn_New_Unit);
                    populateField(unit_Name, unit);
                    populateField(symbol, "ABC");
                    clickElement(btn_Add_Unit);
                    setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                    clickElement(Unit);
                    if (unitList.equalsIgnoreCase(unit)) {
                        getDriver().findElement(By.xpath(unitList)).click();
                    }
                }
                break;

            case "Service":
                setWait(wait).until(ExpectedConditions.visibilityOf(Product_Name));
                populateField(Product_Name, name);
                Dictionary.storeInGlobalDictionary("Product", name);
                setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                clickElement(Unit);
                if (getDriver().findElement(By.xpath(unitList)).getText().equalsIgnoreCase(unit)) {
                    getDriver().findElement(By.xpath(unitList)).click();
                    setWait(wait).until(ExpectedConditions.visibilityOf(category));
                    clickElement(category);
                    if (getDriver().findElement(By.xpath(categoryList)).getText().equalsIgnoreCase(categoryField)) {
                        getDriver().findElement(By.xpath(categoryList)).click();
                    } else {
                        setWait(wait).until(ExpectedConditions.visibilityOf(add_Category));
                        clickElement(add_Category);
                        setWait(wait).until(ExpectedConditions.visibilityOf(type_Service));
                        clickElement(type_Service);
                        populateField(category_Name, categoryField);
                        populateField(category_Description, "Good");
                        setWait(wait).until(ExpectedConditions.visibilityOf(save_Category));
                        clickElement(save_Category);
                        setWait(wait).until(ExpectedConditions.visibilityOf(category));
                        clickElement(category);
                        getDriver().findElement(By.xpath(categoryList)).click();
                    }
                }
                break;
        }
    }

    public void addItemWithoutMandotryFileds(String dep, String itemName, String unit, String categoryField) {
        String unitList = "//span[text()='" + unit + "']";
        String categoryList = "//button[text()='" + categoryField + "']";
        switch (dep) {
            case "Product":
                setWait(wait).until(ExpectedConditions.visibilityOf(Product_Name));
                populateField(Product_Name, itemName);
                if (getDriver().findElement(By.xpath(unitList)).getText().equalsIgnoreCase(unit)) {
                    setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                    clickElement(Unit);
                    getDriver().findElement(By.xpath(unitList)).click();
                    if (getDriver().findElement(By.xpath(unitList)).getText().equalsIgnoreCase(categoryField)) {
                        setWait(wait).until(ExpectedConditions.visibilityOf(category));
                        clickElement(category);
                        getDriver().findElement(By.xpath(categoryList)).click();
                    }
                }
                break;
            case "Service":
                setWait(wait).until(ExpectedConditions.visibilityOf(txt_Service_Name));
                populateField(txt_Service_Name, itemName);
                if (unitList.equalsIgnoreCase(unit)) {
                    setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                    clickElement(Unit);
                    getDriver().findElement(By.xpath(unitList)).click();
                    if (categoryList.equalsIgnoreCase(categoryField)) {
                        setWait(wait).until(ExpectedConditions.visibilityOf(category));
                        clickElement(category);
                        getDriver().findElement(By.xpath(categoryList)).click();
                    }
                    break;


                }
        }
    }

    public void basicItemDetails(String unit, String categoryName, String lenth, String depth1, String sizes, String matrialQualitys) throws Exception {


        setWait(wait).until(ExpectedConditions.visibilityOf(Product_Name));
        populateField(Product_Name, prop.getProperty("Product"));
        setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
        clickElement(Unit);
        setWait(wait).until(ExpectedConditions.visibilityOf(kg));
        clickElement(kg);
        setWait(wait).until(ExpectedConditions.visibilityOf(category));
        clickElement(category);
//        setWait(wait).until(ExpectedConditions.visibilityOf(category_List));
//        clickElement(category_List);
        populateField(length, lenth);
        populateField(depth, depth1);
        populateField(size, sizes);
        setWait(wait).until(ExpectedConditions.visibilityOf(price_Date));
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dynamicDate = today.format(dateTimeFormatter);
        populateField(price_Date, dynamicDate);
        populateField(matrialQuality, matrialQualitys);
    }

    public void additionalInfo(String parchase, String sell, String vendorName) throws InterruptedException {
        populateField(purchase_Price, parchase);
        populateField(selling_Price, sell);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        // setWait(wait).until(ExpectedConditions.visibilityOf(knownVendor));
        clickElement(knownVendor);
        knownVendor.sendKeys(vendorName, Keys.ENTER);

    }

    public void fillAdditionalInfo(String vendor) throws Exception {
        switch (vendor) {
            case "Sriniva":
                populateField(purchase_Price, "1000");
                populateField(selling_Price, "2000");
                Thread.sleep(3000);
                clickElement(knownVendor);
                knownVendor.sendKeys(vendor, Keys.ENTER);
                break;
        }


    }

    public void fillWarehouseInfo(String warehouseField) {
        switch (warehouseField) {
            case "Tony Warehouse":
                setWait(wait).until(ExpectedConditions.visibilityOf(warehouse));
                clickElement(warehouse);
                setWait(wait).until(ExpectedConditions.visibilityOf(abcStock));
                clickElement(abcStock);

                populateField(opening_Stock_Value, "200");
                LocalDate today = LocalDate.now();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String asOfDate = today.format(dateTimeFormatter);
                populateField(opening_stock_Date, asOfDate);
                populateField(opening_Purchase_Price, "200");
                populateField(selling_Price_Warehouse, "300");
                populateField(min_Quantity, "10");
                break;
        }
    }


    public void warehouseInfo(String warehouseName, String openingStock, String openingPurchase,
                              String sellingPrice, String minQuantity) {
        setWait(wait).until(ExpectedConditions.visibilityOf(warehouse));
        clickElement(warehouse);
        /*setWait(wait).until(ExpectedConditions.visibilityOf(warehouse_List));
        clickElement(warehouse_List);*/


        switch (warehouseName) {
            case "ABC - Stock":
                populateField(opening_Stock_Value, openingStock);
                LocalDate today = LocalDate.now();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String asOfDate = today.format(dateTimeFormatter);
                populateField(opening_stock_Date, asOfDate);
                populateField(opening_Purchase_Price, openingPurchase);
                populateField(selling_Price_Warehouse, sellingPrice);
                populateField(min_Quantity, minQuantity);
                break;
        }

    }

    public void storeThePrdoct(String btn) throws Exception {
        switch (btn) {
            case "Save":
                setWait(wait).until(ExpectedConditions.visibilityOf(btnSave));
                clickElement(btnSave);
//                Thread.sleep(DELAY_IN_MILLI_SECS);
                Hooks.captureT(scenario);
                break;
            case "Save Category":
                setWait(wait).until(ExpectedConditions.visibilityOf(save_Category));
                clickElement(save_Category);
                Hooks.captureT(scenario);
                break;

            case "Update Category":
                setWait(wait).until(ExpectedConditions.visibilityOf(update_Category));
                clickElement(update_Category);
                Hooks.captureT(scenario);
                break;

            case "Add Unit":
                setWait(wait).until(ExpectedConditions.visibilityOf(btn_Add_Unit));
                clickElement(btn_Add_Unit);
                Hooks.captureT(scenario);
                break;

            case "Update Unit":
                setWait(wait).until(ExpectedConditions.visibilityOf(update_Unit));
                clickElement(update_Unit);
                Hooks.captureT(scenario);
                break;
        }

    }

    public void validateItem() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        setWait(wait).until(ExpectedConditions.visibilityOf(item_Name));
        String id = getText(id_Item).substring(1);
        Dictionary.storeInGlobalDictionary("ID", id);
        String expectedtext = getText(item_Name);
        String name = Dictionary.getFromGlobalDictionary("Product");
        Assert.assertEquals(name, expectedtext, "Verify the Item is Shown");

    }

    public void validate_ErrorMassge(String errorMessage) throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        String error = "//div[text()='" + errorMessage + "']";
        String expectedText = getDriver().findElement(By.xpath(error)).getText();
        Assert.assertEquals(errorMessage, expectedText);

    }

    public void actions(String action) throws Exception {
        switch (action) {
            case "View":
                setWait(wait).until(ExpectedConditions.visibilityOf(view));
                clickElement(view);
                break;
            case "Edit":
                    setWait(wait).until(ExpectedConditions.visibilityOf(edit));
                    clickElement(edit);
                break;
            case "Delete":
                setWait(wait).until(ExpectedConditions.visibilityOf(delete));
                clickElement(delete);
                break;
        }

    }

    public void updateFiled() throws Exception {
        if (wholesale_Price.isDisplayed() && wholesale_Price.isEnabled()) {
            wholesale_Price.clear();
            populateField(wholesale_Price, "700");
        } else if (selling_Price.isEnabled() && selling_Price.isEnabled()) {
            selling_Price.clear();
            populateField(selling_Price, "800");

        } else if (category_Name.isEnabled() && category_Name.isDisplayed()) {
            category_Name.clear();
            populateField(category_Name, "Garments");
        }

    }

    public void validateUpdate() throws Exception {
        Hooks.captureT(scenario);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement toastMessage = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toastify-container div.text-sm")));
        System.out.println(toastMessage.getText());
        if ("Item updated successfully!".equalsIgnoreCase(toastMessage.getText())) {
            Assert.assertEquals("Item updated successfully!", toastMessage.getText());
        }
        else if ("Category updated".equalsIgnoreCase(toastMessage.getText())) {
            Assert.assertEquals("Category updated", toastMessage.getText());
        }
        else if ("Unit deleted successfully.".equalsIgnoreCase(toastMessage.getText())) {
            Assert.assertEquals("Unit deleted successfully.", toastMessage.getText());
        }
    }

    public void clickDelete() throws Exception {
        setWait(wait).until(ExpectedConditions.visibilityOf(btn_Delete));
        clickElement(btn_Delete);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        // Hooks.captureT(scenario);

    }

    public void validateDelete() throws InterruptedException {
        String expectedText = getText(txt_Delete);
        System.out.println(expectedText);
        Assert.assertEquals("Your file has been deleted.", expectedText);
    }

    public void addtionalInfo() {
        populateField(selling_Price, "1000");
    }

    public void validateView(String module) throws Exception {

        String expectedText = Product_Name.getAttribute("value");
        String actualText = Dictionary.getFromGlobalDictionary("Product");
        Assert.assertEquals(actualText, expectedText);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
    }

    public void list_Deleted() throws Exception {
        setWait(wait).until(ExpectedConditions.visibilityOf(deleted_List));
        clickElement(deleted_List);
        Dictionary.storeInGlobalDictionary("Delete_Item_Name", delete_Item_Name.getText());
    }

    public void validate_Delete_List() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        String actualText = Dictionary.getFromGlobalDictionary("ID");
        String expectedText = item_Code.getText();
        Dictionary.storeInGlobalDictionary("Item Code", expectedText);
        Assert.assertEquals(actualText, expectedText);

    }

    public void validate_Delete_List_Category() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        String actualText = Dictionary.getFromGlobalDictionary("ID");
        String expectedText = restore_Name.getText();
        Dictionary.storeInGlobalDictionary("Item Code", expectedText);
        Assert.assertEquals(actualText, expectedText);

    }

    public void restoreItem() {
        setWait(wait).until(ExpectedConditions.visibilityOf(chk_Box_Delete_Item));
        clickElement(chk_Box_Delete_Item);
        setWait(wait).until(ExpectedConditions.visibilityOf(restore));
        clickElement(restore);

    }

    public void validateRestoreItem() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        setWait(wait).until(ExpectedConditions.visibilityOf(list));
        clickElement(list);
        String actualText = Dictionary.getFromGlobalDictionary("ID");
        String expectedText = Dictionary.getFromGlobalDictionary("Item Code");
        Assert.assertEquals(actualText, expectedText);

    }

    public void validateRestoreItem_Category() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        setWait(wait).until(ExpectedConditions.visibilityOf(list));
        clickElement(list);
        String actualText = Dictionary.getFromGlobalDictionary("Deleted List Category Name");
        String expectedText = Dictionary.getFromGlobalDictionary("Category Name");
        Assert.assertEquals(actualText, expectedText);
        System.out.println();

    }

    public void categoryOption(String option) {
        String type = "//span[text()='" + option + "']";
        if (getDriver().findElement(By.xpath(type)).isSelected()) {
            System.out.println();
        } else if (!getDriver().findElement(By.xpath(type)).isSelected()) {
            String text = getDriver().findElement(By.xpath(type)).getText();
            if (option.equalsIgnoreCase(text)) {
                setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(type))));
                clickElement(getDriver().findElement(By.xpath(type)));
            }
        }
    }

    public void categoryCreation(String CategoryName) throws InterruptedException {
        category_Name.sendKeys(Keys.CONTROL + "a");
        category_Name.sendKeys(Keys.DELETE);
        populateField(category_Name, CategoryName);
        Dictionary.storeInGlobalDictionary("Name", CategoryName);
        category_Description.sendKeys(Keys.CONTROL + "a");
        category_Description.sendKeys(Keys.DELETE);
        populateField(category_Description, "Good");
    }

    public void validate_Category() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        setWait(wait).until(ExpectedConditions.visibilityOf(txt_Category));
        String expectedtext = getText(txt_Category);
        //  Dictionary.storeInGlobalDictionary("Category Name" , expectedtext);
        String name = Dictionary.getFromGlobalDictionary("Name");
        Assert.assertEquals(name, expectedtext, "Verify the Item is Shown");

    }

    public void validate_Delete_Category() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        setWait(wait).until(ExpectedConditions.visibilityOf(restore_Name));
        String expectedtext = getText(restore_Name);
        Dictionary.storeInGlobalDictionary("Deleted List Category Name", expectedtext);
        String actualText = Dictionary.getFromGlobalDictionary("Category Name");
        System.out.println(actualText);
        Assert.assertEquals(actualText, expectedtext, "Verify the Item is Shown");
    }

    public void create_Unit(String unit_Name, String symbol) {
        txt_Unit_Name.sendKeys(Keys.CONTROL + "a");
        txt_Unit_Name.sendKeys(Keys.DELETE);
        populateField(txt_Unit_Name, unit_Name);
        Dictionary.storeInGlobalDictionary("UnitName", unit_Name);
        txt_Unit_Symbol.sendKeys(Keys.CONTROL + "a");
        txt_Unit_Symbol.sendKeys(Keys.DELETE);
        populateField(txt_Unit_Symbol, symbol);

    }

    public boolean valid_Text() {


        String unitName =
                Dictionary.getFromGlobalDictionary("UnitName");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By unitLocator =
                By.xpath("//span[normalize-space()='" + unitName + "']");

        String actualText =
                wait.until(ExpectedConditions.visibilityOfElementLocated(unitLocator))
                        .getText()
                        .trim();

        Assert.assertEquals(actualText, unitName, "Unit not found in list");

        return false;
    }

    public void edit_Unit(){
        setWait(wait).until(ExpectedConditions.visibilityOf(edit_Unit));
        clickElement(edit_Unit);
    }

    public void delete_Unit(){
        setWait(wait).until(ExpectedConditions.visibilityOf(delete_Unit));
        clickElement(delete_Unit);
    }
}


