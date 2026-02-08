package page;

import cukeTests.web.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import qa.data.testdata.WarehouseDate;
import qa.data.utils.AppSpecificUtility;
import qa.data.utils.Dictionary;
import qa.data.utils.TestBaseClass;
import qa.data.utils.log4jBaseClass;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

import static cukeTests.web.Hooks.scenario;

public class QAPage extends AppSpecificUtility {
    private static final String COUTRYCODE = "//span[text()='+91']";
    private static final String COUTRYCODE_BUTTON = "//div[@class='css-ctzjn-control']";
    private static final String USERPHONENUMBER = "//input[@name='phoneNumber']";
    private static final String LOGINBUTTON = "//span[text()='Login']";
    private static final String PASSWORD = "//input[@id='password']";
    private static final String COMPANYNAME = "//h3[text()='Wakanda Books']";
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
    private static final String COMICS_TEXT = "//button[text()='Comics']";
    private static final String PRICE_DATE = "//input[@id='custom_field_values[3].value']";
    private static final String PUCHASE_PRICE = "//input[@id='purchase_price']";
    private static final String SELLING_PRICE = "//input[@id='selling_price']";
    private static final String WAREHOUSE = "//div[@class='relative w-full']/child::div[@class='flex']";
    private static final String ABC_STOCK_BUTTON = "//span[text()='Tony Warehouse']";
    private static final String OPPENING_STOCK = ".//input[@placeholder='Enter Opening Stock...']";
    private static final String OPPENING_STOCK_DATE = "//input[@id='warehouseItem[0].opening_stock_date']";
    private static final String OPPENING_PURCHARE_PRICE = ".//input[@placeholder='Enter Opening Purchase Price...']";
    private static final String OPPENING_STOCK_VALUE = "//input[@id='warehouseItem[0].opening_stock_value']";
    private static final String SELLING_PRICE_WAREHOUSE = ".//input[@placeholder='Enter Retail Price here...']";
    private static final String WHOLESALE_PRICE_WAREHOUSE = ".//input[@placeholder='Enter Wholesale Price here']";
    private static final String MIN_QUTANTITY = ".//input[@placeholder='Write the Minimum Quantity here to get notified']";
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
    private static final String CATEGORY_LIST = "//button[@class='p-2 cursor-pointer hover:bg-gray-100 w-full text-start border-b']";
    private static final String PURCAHSE_PRICE_TEXT = "//div[normalize-space()='Purchase Price']/following-sibling::div//span";
    private static final String PRODUCT_IMAGE = "//input[@type='file']";
    private static final String CONTAINERS_WAREHOUSELIST = "//div[@class='bg-bg-white p-5 rounded-md mt-[40px]']";
    private static final String ITEM_IMAGE = "//div[text()='Item Image']";
    private static final String PPURICE_EXPECT = "//div[text()='Purchase Price']/parent::div/child::div[2]";
    private static final String AVAILABLE_QUANTITY = "//div[normalize-space()='Available Quantity']/following-sibling::div/span";


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
//td[text()='Unit Two']
    //span[text()='Unit Two']

    @FindBy(xpath = UNIT_SECTION)
    private WebElement unit_Section;

  @FindBy(xpath = PPURICE_EXPECT)
    private WebElement purchase_Price_Expect;
 @FindBy(xpath = AVAILABLE_QUANTITY)
    private WebElement available_Quantity_Expect;

    @FindBy(xpath = ITEM_IMAGE)
    private WebElement item_Image;

    @FindBy(xpath = EDIT_UNIT)
    private WebElement edit_Unit;

    @FindBy(xpath = DELETE_UNIT)
    private WebElement delete_Unit;

    @FindBy(xpath = UPDATE_UNIT)
    private WebElement update_Unit;

    @FindBy(xpath = CATEGORY_LIST)
    private List<WebElement> category_List;

    @FindBy(xpath = CONTAINERS_WAREHOUSELIST)
    private List<WebElement> container;

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

    @FindBy(xpath = WHOLESALE_PRICE_WAREHOUSE)
    private WebElement warehouse_Wholesale_Price;

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

    @FindBy(xpath = PURCAHSE_PRICE_TEXT)
    private WebElement purchase_Price_Text;

    @FindBy(xpath = PRODUCT_IMAGE)
    private WebElement product_Image;


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
                clickUsingJavaScript(contryCode);
                populateField(phoneNumber, prop.getProperty("User"));
                clickElement(btnLogin);
                populateField(password, prop.getProperty("Password"));
                setWait(wait).until(ExpectedConditions.visibilityOf(btnLogin));
                clickElement(btnLogin);
                Thread.sleep(DELAY_IN_MILLI_SECS);
                Dictionary.storeInGlobalDictionary("CreatedBy", role);
                Hooks.captureT(scenario);
                break;

        }
    }

    public void companySelect(String company) throws Exception {
        if (companyName.isDisplayed() && companyName.isEnabled()) {
            switch (company) {
                case "Wakanda Books":
                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    Hooks.captureT(scenario);
                    setWait(wait).until(ExpectedConditions.visibilityOf(companyName));
                    clickElement(companyName);
                    setWait(wait).until(ExpectedConditions.visibilityOf(btnConfrim));
                    clickElement(btnConfrim);
                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    Hooks.captureT(scenario);
                    break;


            }
        } else {
            System.out.println("We have only one company");
        }

    }


    public void selectModuleAndSub(String module, String sub) throws Exception {

        switch (module) {
            case "Items":
                setWait(wait).until(ExpectedConditions.visibilityOf(items));
                clickElement(items);
                if (sub.equalsIgnoreCase("Items List")) {
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
        String unitList = "//span[text()='"+unit+"']";
        String categoryList = "//button[text()='" + categoryField + "']";
        switch (dep) {
            case "Product":
                setWait(wait).until(ExpectedConditions.visibilityOf(Product_Name));
                populateField(Product_Name, name);
                Dictionary.storeInGlobalDictionary("Product", name);
                Dictionary.storeInGlobalDictionary("Unit", unit);
                Dictionary.storeInGlobalDictionary("Category", categoryField);
                setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                clickElement(Unit);
                List<WebElement> unitListText = getDriver().findElements(By.xpath("//label[text()='Unit']/following::button/span[3]"));
                boolean categoryFoun = false,unitFound = false;
                for (WebElement unitListElement : unitListText) {
                    if (unitListElement.getText().equalsIgnoreCase(unit)) {
                        clickUsingJavaScript(unitListElement);
                        unitFound = true;
                        break;
                    }

                }
                if (!unitFound) {
                    setWait(wait).until(ExpectedConditions.visibilityOf(btn_New_Unit));
                    clickElement(btn_New_Unit);
                    populateField(unit_Name, unit);
                    populateField(symbol, "TU");
                    clickElement(btn_Add_Unit);
                    setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                    clickElement(Unit);
                        getDriver().findElement(By.xpath(unitList)).click();
                }
                setWait(wait).until(ExpectedConditions.visibilityOf(category));
                clickElement(category);
                //List<WebElement> categoryLists = getDriver().findElements(By.xpath("//button[@class='p-2 cursor-pointer hover:bg-gray-100 w-full text-start border-b']"));

                for (WebElement category : category_List) {
                    if (category.getText().equalsIgnoreCase(categoryField)) {
                        clickElement(category);
                        categoryFoun = true;
                        break;
                    }
                }

                if (!categoryFoun) {
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

    public void fillAdditionalInfo() throws Exception {

                populateField(purchase_Price, "100");
                String purchasePriceActual = getAttribute(purchase_Price, "value");
                Dictionary.storeInGlobalDictionary("purchasePriceActual",purchasePriceActual);
                // populateField(selling_Price, "2000");
                //     Thread.sleep(3000);
//                getDriver().findElement(By.xpath("//input[@id='react-select-6-input']")).click();
//                List<WebElement> elements1 = getDriver().findElements(By.xpath("//div[@id='react-select-6-listbox']/child:div[@role='option']"));
//
//                boolean vendorFound = false;
//                for (WebElement option : elements1) {
//                    if (option.getText().contains(vendor)) {
//                        option.click();
//                        vendorFound = true;
//                        break;
//                    }
//                }
//                if (!vendorFound) {
//                    throw new RuntimeException("Vendor not found in dropdown");
//                }
//
//
//              // clickElement(knownVendor);
////                knownVendor.sendKeys(vendor, Keys.ENTER);
//                break;

//        driver.findElement(By.id("react-select-6-input")).click();
//       // populateField(product_Image,"C:\\Users\\futur\\OneDrive\\Pictures\\Screenshots pic 1");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        List<WebElement> options = wait.until(
//                ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                        By.xpath("//div[@role='option']")
//                )
//        );
//        for (WebElement option : options) {
//            System.out.println(option.getText());
//        }
        setWait(wait).until(ExpectedConditions.visibilityOf(item_Image));
        clickElement(item_Image);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        populateField(product_Image,"C:\\Users\\futur\\OneDrive\\Pictures\\Screenshots pic 1");




    }

    public void fillWarehouseInfo(String warehouseField) throws Exception {
        if (warehouse.isEnabled()) {
            setWait(wait).until(ExpectedConditions.visibilityOf(warehouse));
            clickElement(warehouse);

            String[] warehouseList = warehouseField.split(",");
            for (String warehouse : warehouseList) {
                String WarehouseName = "//span[text()='" + warehouse.trim() + "']";
                setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(WarehouseName))));
                clickElement(getDriver().findElement(By.xpath(WarehouseName)));
            }
            Thread.sleep(DELAY_IN_MILLI_SECS);
            Hooks.captureT(scenario);
            warehouse.click();
            List<String> featureWarehouses = Arrays.stream(warehouseField.split(","))
                    .map(String::trim).collect(Collectors.toList());
            Map<String, WarehouseDate> warehousePriceMap = new HashMap<>();
            int avialbeQuantity = 0;
            double sumPPxQty = 0;  // sum of (purchase price * quantity) for weighted average
            for (int i = 0; i < container.size(); i++) {

                String warehouseName = container.get(i)
                        .findElement(By.xpath(".//p[contains(normalize-space(), 'Warehouse Information')]"))
                        .getText()
                        .replace("Warehouse Information", "")
                        .replace("(", "")
                        .replace(")", "")
                        .trim();

                WebElement openingStock = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Opening Stock...']"));
                populateField(openingStock, "200");
                double openingStockValue = Double.parseDouble(getAttribute(openingStock, "value"));
                System.out.println( "openingStockValue : " + openingStockValue);
                avialbeQuantity += openingStockValue;

                Thread.sleep(DELAY_IN_MILLI_SECS);
                WebElement openingPurchasePrice = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Opening Purchase Price...']"));
                if (openingPurchasePrice.getAttribute("value") == null || openingPurchasePrice.getAttribute("value").isEmpty()) {
                    populateField(openingPurchasePrice, "200");
                }

                Thread.sleep(DELAY_IN_MILLI_SECS);
                double pprice = Double.parseDouble(openingPurchasePrice.getAttribute("value"));
                sumPPxQty += (pprice * openingStockValue);
                WebElement warehouse_Wholesale_Price = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Wholesale Price here']"));
                populateField(warehouse_Wholesale_Price, "300");
                double warehouseWholesalePriceValue = Double.parseDouble(getAttribute(warehouse_Wholesale_Price, "value"));
                System.out.println( "warehouseWholesalePriceValue : " + warehouseWholesalePriceValue);

                Thread.sleep(DELAY_IN_MILLI_SECS);
                WebElement warehouse_Selling_Price = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Retail Price here...']"));
                populateField(warehouse_Selling_Price, "250");
                double warehouseSellingPriceValue = Double.parseDouble(getAttribute(warehouse_Selling_Price, "value"));
                System.out.println( "warehouseSellingPriceValue : " + warehouseSellingPriceValue);

                Thread.sleep(DELAY_IN_MILLI_SECS);
                WebElement min_Quantity = container.get(i).findElement(By.xpath(".//input[@placeholder='Write the Minimum Quantity here to get notified']"));
                populateField(min_Quantity, "10");
                warehousePriceMap.put(
                        warehouseName,
                        new WarehouseDate(openingStockValue,warehouseWholesalePriceValue,warehouseSellingPriceValue));
                Thread.sleep(DELAY_IN_MILLI_SECS);
                Hooks.captureT(scenario);
            }
            Dictionary.storeInGlobalDictionary("avialableQuantity", String.valueOf(avialbeQuantity));
            Dictionary.storeInGlobalDictionary("WAREHOUSE_PRICE_MAP", warehousePriceMap);
            // Average Purchase Price = sum of (PP * quantity) / sum of quantity
            if (avialbeQuantity > 0) {
                double avgPurchasePrice = sumPPxQty / avialbeQuantity;
                Dictionary.storeInGlobalDictionary("AveragePurchasePrice", String.valueOf(Math.round(avgPurchasePrice)));
            }

        } else {
            populateField(opening_Stock_Value, "200");
            LocalDate today = LocalDate.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String asOfDate = today.format(dateTimeFormatter);
            populateField(opening_stock_Date, asOfDate);
            populateField(opening_Purchase_Price, "200");
            Dictionary.storeInGlobalDictionary("AveragePurchasePrice", "200");
            populateField(selling_Price_Warehouse, "300");
            populateField(min_Quantity, "10");
            Thread.sleep(DELAY_IN_MILLI_SECS);
            Hooks.captureT(scenario);
        }



    }


    public void warehouseInfo(String warehouseName) {
        if (warehouse.isEnabled()) {
            setWait(wait).until(ExpectedConditions.visibilityOf(warehouse));
            clickElement(warehouse);

            String[] warehouseList = warehouseName.split(",");
            for (String warehouse : warehouseList) {
                String WarehouseName = "//span[text()='" + warehouse.trim() + "']";
                setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(WarehouseName))));
                clickElement(getDriver().findElement(By.xpath(WarehouseName)));
            }
            warehouse.click();

            List<String> featureWarehouses = Arrays.stream(warehouseName.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());

            LocalDate today = LocalDate.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String asOfDate = today.format(dateTimeFormatter);
            switch (warehouseName) {
                case "VIP Warehouse":
                    populateField(opening_Stock_Value, 100);

                    populateField(opening_stock_Date, asOfDate);
                    populateField(opening_Purchase_Price, 200);
                    populateField(warehouse_Wholesale_Price, 250);
                    populateField(selling_Price_Warehouse, 300);
                    populateField(min_Quantity, 10);
                    break;

                case "GKS Warehouse":
                    populateField(opening_Stock_Value, 100);
                    // LocalDate today = LocalDate.now();
                    //  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    // String asOfDate = today.format(dateTimeFormatter);
                    populateField(opening_stock_Date, asOfDate);
                    populateField(opening_Purchase_Price, 200);
                    populateField(warehouse_Wholesale_Price, 250);
                    populateField(selling_Price_Warehouse, 300);
                    populateField(min_Quantity, 10);
                    break;
            }

        }
    }

    public void storeThePrdoct(String btn) throws Exception {
        switch (btn) {
            case "Save":
                setWait(wait).until(ExpectedConditions.visibilityOf(btnSave));
                clickElement(btnSave);
                Thread.sleep(DELAY_IN_MILLI_SECS);
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

        // List product Validation
        String expectedtext = getText(item_Name);
        String name = Dictionary.getFromGlobalDictionary("Product");
        Assert.assertEquals(name, expectedtext, "Verify the Item is Shown");

        //Purchase Price Validation
        Assert.assertEquals(Dictionary.getFromGlobalDictionary("purchasePriceActual"),
                getText(purchase_Price_Expect).substring(1), "Verify the Item is Shown");

        // Available Quantity Validation
        Assert.assertEquals(Dictionary.getFromGlobalDictionary("avialableQuantity"),
                getText(available_Quantity_Expect).split(" ")[0], "Verify the Item is Shown");

        // Warehouse field Validation
        Map<String, WarehouseDate> expectedMap = (Map<String, WarehouseDate>)
                Dictionary.getFromGlobalDictionary("WAREHOUSE_PRICE_MAP");

        List<WebElement> wholesalePriceTableRow = getDriver().findElements(By.xpath("//table//tbody/tr"));

        for (WebElement wholesalePrice : wholesalePriceTableRow) {

            String uIWarehouseName = wholesalePrice.findElement(By.xpath("./td[1]")).getText().trim();

            // Wholesale Price
            Double uiWholesale = Double.parseDouble( wholesalePrice.findElement(By.xpath(".//td[count(//th[normalize-space()='Wholesale Price']/preceding-sibling::th)+1]"))
                            .getText().replace("₹", "").trim());
            System.out.println("uiWholesale : "+uiWholesale );
           // Selling Price
            Double uiSelling =  Double.parseDouble(wholesalePrice.findElement(By.xpath(".//td[count(//th[normalize-space()='Selling Price']/preceding-sibling::th)+1]"))
                            .getText().replace("₹", "").trim());
            System.out.println("uiSelling : "+uiSelling );
            Double qtyText =Double.parseDouble( wholesalePrice.findElement(By.xpath("./td[4]")).getText().trim());
            System.out.println("qtyText : "+qtyText );

            WarehouseDate warehouseDate = expectedMap.get(uIWarehouseName);

            Assert.assertNotNull(
                    warehouseDate,
                    "No expected data found for warehouse: " + uIWarehouseName
            );

            Assert.assertEquals(
                    uiWholesale,
                   warehouseDate.getWholesalePrice(),
                    "Wholesale Price mismatch for " + uIWarehouseName
            );

            Assert.assertEquals(
                    uiSelling,
                    warehouseDate.getSellingPrice(),
                    "Selling Price mismatch for " + warehouseDate
            );

            Assert.assertEquals(
                    qtyText,
                    warehouseDate.getOpeningstock(),
                    "Quantity Price mismatch for " + uIWarehouseName
            );

                    }
// Created by and Updated by Validation




    }

    /**
     * Validates that the string is a valid date-time (date and time both present).
     * Tries common formats: dd/MM/yyyy HH:mm, dd-MM-yyyy HH:mm, yyyy-MM-dd HH:mm:ss, dd MMM yyyy HH:mm, etc.
     */
    private boolean isValidDateTime(String value) {
        if (value == null || value.trim().isEmpty()) return false;
        String v = value.trim();
        DateTimeFormatter[] formats = {
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"),
                DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"),
                DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a", Locale.ENGLISH),
                DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a", Locale.ENGLISH)
        };
        for (DateTimeFormatter fmt : formats) {
            try {
                LocalDateTime.parse(v, fmt);
                return true;
            } catch (DateTimeParseException ignored) {
            }
        }
        return false;
    }

    /**
     * Get first row cell text from Items List table by column header name.
     * Uses table with thead; matches header by contains (case-insensitive).
     */
    private String getListCellTextByHeader(String headerName) {
        try {
            List<WebElement> headers = getDriver().findElements(By.xpath("//table[.//thead]//th"));
            for (int i = 0; i < headers.size(); i++) {
                if (headers.get(i).getText().trim().toLowerCase().contains(headerName.trim().toLowerCase())) {
                    int colIndex = i + 1;
                    String cellXpath = "(//table[.//thead]//tbody/tr)[1]/td[" + colIndex + "]";
                    WebElement cell = getDriver().findElement(By.xpath(cellXpath));
                    return cell.getText().trim();
                }
            }
        } catch (Exception e) {
            log4jBaseClass.error("getListCellTextByHeader failed for header: " + headerName + " - " + e.getMessage());
        }
        return "";
    }

    /** Full validation on List page: Product, Unit, Category, Purchase Price, Average Purchase Price, Available Quantity, Created By, Created At, Updated By, Updated At */
    public void validateItemInFullValidation() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        setWait(wait).until(ExpectedConditions.visibilityOf(item_Name));

        // Product name
        String expectedProduct = Dictionary.getFromGlobalDictionary("Product");
        String actualProduct = getListCellTextByHeader("Product");
        if (actualProduct.isEmpty()) {
            actualProduct = getText(item_Name);
        }
        Assert.assertEquals(expectedProduct, actualProduct, "Product name mismatch on list page");

        // Unit
        String expectedUnit = Dictionary.getFromGlobalDictionary("Unit");
        if (expectedUnit != null) {
            String actualUnit = getListCellTextByHeader("Unit");
            Assert.assertEquals(expectedUnit, actualUnit, "Unit mismatch on list page");
        }

        // Category name
        String expectedCategory = Dictionary.getFromGlobalDictionary("Category");
        if (expectedCategory != null) {
            String actualCategory = getListCellTextByHeader("Category");
            if (actualCategory.isEmpty()) {
                actualCategory = getListCellTextByHeader("Category Name");
            }
            Assert.assertEquals(expectedCategory, actualCategory, "Category name mismatch on list page");
        }

        // Purchase Price (list page)
        String expectedPurchasePrice = Dictionary.getFromGlobalDictionary("purchasePriceActual");
        String actualPurchasePrice = getListCellTextByHeader("Purchase Price");
        if (actualPurchasePrice.isEmpty()) {
            actualPurchasePrice = getText(purchase_Price_Expect).replace("₹", "").trim();
        } else {
            actualPurchasePrice = actualPurchasePrice.replace("₹", "").trim();
        }
        Assert.assertEquals(expectedPurchasePrice, actualPurchasePrice, "Purchase price mismatch on list page");

        // Average Purchase Price: expected = average of warehouse opening purchase prices (stored in fillWarehouseInfo)
        String expectedAvgPurchasePrice = Dictionary.getFromGlobalDictionary("AveragePurchasePrice");
        if (expectedAvgPurchasePrice != null) {
            String actualAvgPurchasePrice = getListCellTextByHeader("Average Purchase Price");
            if (!actualAvgPurchasePrice.isEmpty()) {
                actualAvgPurchasePrice = actualAvgPurchasePrice.replace("₹", "").replace(",", "").trim();
                Assert.assertEquals(expectedAvgPurchasePrice, actualAvgPurchasePrice, "Average Purchase Price mismatch on list page");
            }
        }

        // Available Quantity
        String expectedQty = Dictionary.getFromGlobalDictionary("avialableQuantity");
        String actualQty = getListCellTextByHeader("Available Quantity");
        if (actualQty.isEmpty()) {
            actualQty = getText(available_Quantity_Expect).split(" ")[0].trim();
        } else {
            actualQty = actualQty.split(" ")[0].trim();
        }
        Assert.assertEquals(expectedQty, actualQty, "Available quantity mismatch on list page");

        // Created By
        String expectedCreatedBy = Dictionary.getFromGlobalDictionary("CreatedBy");
        if (expectedCreatedBy != null) {
            String actualCreatedBy = getListCellTextByHeader("Created By");
            Assert.assertEquals(expectedCreatedBy, actualCreatedBy, "Created By mismatch on list page");
        }

        // Created At (date and time) - validate not empty and valid date-time format
        String createdAt = getListCellTextByHeader("Created At");
        Assert.assertFalse(createdAt.isEmpty(), "Created At should not be empty on list page");
        Assert.assertTrue(isValidDateTime(createdAt), "Created At should be valid date and time format, got: " + createdAt);

        // Updated By
        String expectedUpdatedBy = Dictionary.getFromGlobalDictionary("CreatedBy");
        if (expectedUpdatedBy != null) {
            String actualUpdatedBy = getListCellTextByHeader("Updated By");
            Assert.assertEquals(expectedUpdatedBy, actualUpdatedBy, "Updated By mismatch on list page");
        }

        // Updated At (date and time) - validate not empty and valid date-time format
        String updatedAt = getListCellTextByHeader("Updated At");
        Assert.assertFalse(updatedAt.isEmpty(), "Updated At should not be empty on list page");
        Assert.assertTrue(isValidDateTime(updatedAt), "Updated At should be valid date and time format, got: " + updatedAt);
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
                clickUsingJavaScript(edit);
                // clickElement(edit);
                break;
            case "Delete":
                String id = getText(id_Item).substring(1);
                Dictionary.storeInGlobalDictionary("ID", id);
                setWait(wait).until(ExpectedConditions.visibilityOf(delete));
                clickUsingJavaScript(delete);
                break;
        }

    }

    public void updateFiled() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        if (purchase_Price.isDisplayed() && purchase_Price.isEnabled()) {
            purchase_Price.sendKeys(Keys.CONTROL + "a");
            purchase_Price.sendKeys(Keys.DELETE);
            //  populateField(wholesale_Price, "700");
        Thread.sleep(DELAY_IN_MILLI_SECS);
            populateField(purchase_Price, "110");
            String PPriceText = purchase_Price.getAttribute("value");
            Dictionary.storeInGlobalDictionary("PPrice", PPriceText);
//        }
//        else if (selling_Price.isEnabled() && selling_Price.isEnabled()) {
//            selling_Price.clear();
//            populateField(selling_Price, "800");
//
//        }
//        else if (category_Name.isEnabled() && category_Name.isDisplayed()) {
//            category_Name.clear();
//            populateField(category_Name, "Garments");
      }

    }

    public void validateUpdate() throws Exception {
        // Hooks.captureT(scenario);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement toastMessage = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toastify-container div.text-sm")));
        System.out.println(toastMessage.getText());
        if ("Item updated successfully!".equalsIgnoreCase(toastMessage.getText())) {
            Assert.assertEquals(Dictionary.getFromGlobalDictionary("PPrice"),
                    getText(purchase_Price_Expect).substring(1), "Verify the Item is Shown");
            Assert.assertEquals("Item updated successfully!", toastMessage.getText());
        } else if ("Category updated".equalsIgnoreCase(toastMessage.getText())) {
            Assert.assertEquals("Category updated", toastMessage.getText());
        } else if ("Unit deleted successfully.".equalsIgnoreCase(toastMessage.getText())) {
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
        Thread.sleep(DELAY_IN_MILLI_SECS);
        getDriver().findElement(By.xpath("//button[text()='Okay']")).click();
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
        clickUsingJavaScript(deleted_List);
        Dictionary.storeInGlobalDictionary("Delete_Item_Name", delete_Item_Name.getText());
    }

    public void validate_Delete_List() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        if (item_Code.isDisplayed()) {
            String actualText = Dictionary.getFromGlobalDictionary("ID");
            String expectedText = item_Code.getText();
            Dictionary.storeInGlobalDictionary("Item Code", expectedText);
            Assert.assertEquals(actualText, expectedText);
        }

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
        clickUsingJavaScript(chk_Box_Delete_Item);
        setWait(wait).until(ExpectedConditions.visibilityOf(restore));
        clickUsingJavaScript(restore);

    }

    public void validateRestoreItem() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        setWait(wait).until(ExpectedConditions.visibilityOf(list));
        clickUsingJavaScript(list);
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
        Text_Content.setUnitName(unit_Name);
        Dictionary.storeInGlobalDictionary("UnitName", unit_Name);
        txt_Unit_Symbol.sendKeys(Keys.CONTROL + "a");
        txt_Unit_Symbol.sendKeys(Keys.DELETE);
        populateField(txt_Unit_Symbol, symbol);

    }

    public boolean valid_Text() {


        String unitName =
                Dictionary.getFromGlobalDictionary("UnitName");
        System.out.println(unitName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By spanLocator =
                By.xpath("//span[normalize-space()='" + Text_Content.getUnitName() + "']");
        By pLocator =
                By.xpath("//p[text()='" + Text_Content.getUnitName() + "']");

        String actualText = null;
        try {
            // 🔹 First try SPAN
            actualText = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(spanLocator))
                    .getText()
                    .trim();
            System.out.println("Found text in SPAN");

        } catch (TimeoutException e) {
            // 🔹 If SPAN not found, try P
            actualText = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(pLocator))
                    .getText()
                    .trim();
            System.out.println("Found text in P tag");
        }

        // 🔹 ASSERTION
        Assert.assertEquals(actualText, unitName, "Unit not found in list");

        return true;
    }

    public void edit_Unit() {
        setWait(wait).until(ExpectedConditions.visibilityOf(edit_Unit));
        clickElement(edit_Unit);
    }

    public void delete_Unit() {
        setWait(wait).until(ExpectedConditions.visibilityOf(delete_Unit));
        clickElement(delete_Unit);
    }

    public void valide_Delete_Unit() {
        String unitName =
                Dictionary.getFromGlobalDictionary("UnitName");

        By unitLocator =
                By.xpath("//span[normalize-space()='" + unitName + "']");
    }

}


