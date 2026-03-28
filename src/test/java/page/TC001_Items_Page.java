package page;

import cukeTests.web.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import qa.data.testdata.WarehouseDate;
import qa.data.utils.AppSpecificUtility;
import qa.data.utils.Dictionary;
import qa.data.utils.TestBaseClass;
import qa.data.utils.log4jBaseClass;
import org.openqa.selenium.support.PageFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static cukeTests.web.Hooks.scenario;
//import static sun.security.krb5.internal.ktab.KeyTab.normalize;

public class TC001_Items_Page extends AppSpecificUtility {
    private static final String COUTRYCODE = "//span[text()='+91']";
    private static final String COUTRYCODE_BUTTON = "//input[@id='react-select-2-input']";
    private static final String USERPHONENUMBER = "//input[@name='phoneNumber']";
    private static final String LOGINBUTTON = "//span[text()='Login']";
    private static final String PASSWORD = "//input[@id='password']";
    private static final String COMPANYNAME = "//h3[text()='Titan Deploy']";
    private static final String CONFRIMBUTTON = "//button[text()='Confirm']";
    private static final String ITEM_MODULE = "//span[text()='Items']";
    private static final String ITEM_LIST_MODULE = "//span[text()='Items Management']";
    private static final String WAREHOUSE_MODULE = "//span[text()='Warehouses']";
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
    private static final String CONFIRM_DELETE = "//button[text()='Okay']";
    private static final String TXT_DELETE = "//p[text()='Deleted successfully.']";
    private static final String DELETED_LIST = "//button[text()='Deleted']";
    private static final String LIST = "//button[text()='List']";
    private static final String ID = "(//span[@class='text-text-secondary'])[1]";
    private static final String ITEM_CODE = "//span[text()='ID']/ancestor::thead/following::tbody//td[2]";
    private static final String RESTORE_NANE = "(//td[contains(@class,'p-[6px] text-[14px] text-text-secondary')])[3]";
    private static final String SELECT_DELETE_ITEM = "//tbody/tr[td]//input[@type='checkbox']";
    private static final String RESTORE_ITEM = "//button[text()='Restore Items']";
    private static final String ITEM_NAME = "(//td[@class=\"p-[6px] text-[14px] text-text-secondary font-normal px-6 border border-border-inactive text-center align-middle\"])[4]";
    private static final String CATEGORY_LIST = "//button[@class='p-2 cursor-pointer hover:bg-gray-100 w-full text-start border-b']";
    private static final String PURCAHSE_PRICE_TEXT = "//div[normalize-space()='Purchase Price']/following-sibling::div//span";
    private static final String PRODUCT_IMAGE = "//input[@type='file']";
    private static final String CONTAINERS_WAREHOUSELIST = "//div[@class='bg-bg-white p-5 rounded-md mt-[40px]']";
    private static final String ITEM_IMAGE = "//div[text()='Item Image']/ancestor::button";
    private static final String PPURICE_EXPECT = "//div[text()='Purchase Price']/parent::div/child::div[2]";
    private static final String SELLING_EXPECT = "//div[text()='Selling Price']/parent::div/child::div[2]";
    private static final String AVAILABLE_QUANTITY = "//div[normalize-space()='Available Quantity']/following-sibling::div/span";
    private static final String AVERAGE_PURCHASE_PRICE = "//div[normalize-space()='Avg Purchase Price']/following-sibling::div/span";
    private static final String CREATED_BY = "//div[normalize-space()='Created By']/following-sibling::div/span";
    private static final String UPDATED_BY = "//div[normalize-space()='Updated By']/following-sibling::div/span";
    private static final String CREATED_AT = "//div[normalize-space()='Created At']/following-sibling::div/span";
    private static final String UPDATED_AT = "//div[normalize-space()='Updated At']/following-sibling::div/span";
    private static final String UNIT_EXPECTED = "//div[text()='Unit']/following-sibling::div";
    private static final String PROFILE_NAME = "//span[@class='ml-2 truncate max-w-[150px] font-medium text-[16px] text-text-dark']";
    private static final String AITERNATIVE_UNIT = "//span[text()='Add/Select Alternative Unit']";
    private static final String SELECT_UNIT = "//input[@id='react-select-13-input']";
    private static final String CONVERSION_RATE_TXT = "//label[text()='Conversion Rate']/parent::div//child::input";
    private static final String VIEW_ALTERNATIVE_UNIT = "//span[text()='View/Select Alternative Unit']";
    private static final String TXT_ALTERNATIVE_UNIT_SYMBOL = "//div[@class='flex border rounded-md overflow-hidden']/child::div[2]";
    private static final String ADDED_CONVERTION_RATE = "//label[text()='Added Conversion Rate']/following-sibling::div//child::span[3]";
    private static final String ADD_VENDOR = "//span[text()='+ Add Vendor']";
    private static final String VENDOR_FULL_NAME = "//input[@id='fullname']";
    private static final String BTN_ADD_VENDOR = "//button[text()='Add Vendor']";
    private static final String VENDOR_PHONE = "//input[@name='phone']";
    private static final String PRODUCT_SEARCH = "//input[@placeholder='Search here']";
    private static final String CATEGORY_FILTER_SEARCH = "//input[@placeholder='Search']";
    private static final String CATEGORY_FILTER = "(//span[contains(text(),'Category')])[1]/ancestor::button";
    private static final String LIST_CATEGORY = "//span[@class='text-[12px] text-text-dark break-words min-w-[50px]']";
    private static final String EXPECTED_PRODUCT_NAME = "//span[@class='break-words whitespace-normal']";
    private static final String EXPECTED_CATEGORY_NAME = "//div[@class='text-text-primary text-start text-[10px] font-[400] mt-1']";
    private static final String REF_ID = "//span[@class='text-text-secondary']";
    private static final String EMPTY_MESSAGE = "//p[text()='No results found for your search.']";
    private static final String TRANSACTION_TAB = "//button[text()='Transactions']";
    private static final String TRANSACTION_TABLE = "//table//tbody/tr";
    private static final String EMPTY_MESSAGE_TABLE = "//*[contains(text(),'No Transactions')]";


    // Services Section
    private static final String SERVICE_BUTTON = "//button[text()='Service']";
    private static final String PRODUCT_BUTTON = "//button[text()='Product']";
    private static final String ADD_SERVICE_BUTTON = "(//span[text()='Add Service'])[1]";
    private static final String SERVICE_NAME = "//input[@placeholder='Service Name']";
    private static final String SERVICE_UNIT_LIST = "//div[@class='max-h-60 overflow-y-auto z-40']//button";
    private static final String ELECTRONIC = "//button[text()='Electronics Service']";
    private static final String SERVICE_CATEGORY_LIST = "//button[text()='Mobile Repairing']";
    private static final String DESCRIPTION_BOX = "//textarea[@name='description']";
    private static final String ADD_CATEGORY = "//span[text()='Add Category']/parent::button";
    private static final String ADD_UNIT = "//span[text()='Add Unit']";
    private static final String UNIT_NAME = "//label[text()='Unit Name']/following-sibling::div//child::input[@id='name']";
    private static final String UNIT_SYMBOL = "//input[@placeholder='Enter Primary Unit Symbol']";
    private static final String UNIT_BUTTON = "//button[text()='Add Unit']";
    private static final String TYPE_PRODUCT = "//span[text()='Product']/parent::label";
    private static final String TYPE_SERVICE = "//span[text()='Service']/parent::label";
    private static final String CATEGORY_NAME = "//label[text()='Category']/following-sibling::div/child::input[@id='name']";
    private static final String CATEGORY_DESCRIPTION = "//input[@id='description']";
    private static final String SAVE_CATEGORY = "//button[text()='Save Category']";
    private static final String UPDATE_CATEGORY = "//button[text()='Update Category']";
    private static final String VIEW_CATEGORY = "(//label[text()='Category']/following::input)[1]";
    private static final String VIEW_UNIT = "//label[text()='Unit']/following-sibling::div//child::input";

    private static final String VIEW = "//span[text()='View']/ancestor::button";
    private static final String NEW_UNIT_BTN = "//span[text()='Add Unit']/parent::button";
    private static final String CATEGORY_SECTION = "//button[text()='Category']";
    private static final String ADD_CATEGORY_BTN = "//span[text()='Add Category']//ancestor::button";
    private static final String CATEGORY_LIST_NAME = "//span[text()='Name']/parent::div/following::div[1]/child::button//child::p[1]";
    private static final String SERVICE_LIST_NAME = "//span[text()='Service']/parent::div/following::div[1]/child::button//child::span[@class='break-words whitespace-normal']";
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


    // Warehouse List
    private static final String ADD_WAREHOUSE = "//span[text()='Add Warehouse']//ancestor::button";
    private static final String WAREHOUSE_NAME = "//input[@id='name']";
    private static final String WAREHOUSE_LOCATION = "//input[@id='address']";
    private static final String WAREHOUSE_SAVE_BTN = "//button[text()='Add Warehouse']";
    private static final String EXPECTED_WAREHOUSE_NAME = "(//div[text()='Warehouse Name']/ancestor::thead/following::tbody//child::td)[2]";
    private static final String EXPECTED_WAREHOUSE_LOCATION = "(//div[text()='Warehouse Name']/ancestor::thead/following::tbody//child::td)[3]";

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

    @FindBy(xpath = UNIT_SECTION)
    private WebElement unit_Section;

    @FindBy(xpath = VIEW_CATEGORY)
    private WebElement view_Category;

    @FindBy(xpath = VIEW_UNIT)
    private WebElement view_Unit;

    @FindBy(xpath = VIEW_ALTERNATIVE_UNIT)
    private WebElement view_Alternative_Unit;

    @FindBy(xpath = TXT_ALTERNATIVE_UNIT_SYMBOL)
    private WebElement txt_Alternative_Unit;

    @FindBy(xpath = ADDED_CONVERTION_RATE)
    private WebElement added_Converion_Rate;

    @FindBy(xpath = ADD_VENDOR)
    private WebElement add_vendor;

    @FindBy(xpath = VENDOR_FULL_NAME)
    private WebElement vendor_Full_Name;

    @FindBy(xpath = BTN_ADD_VENDOR)
    private WebElement btn_Add_vendor;

    @FindBy(xpath = VENDOR_PHONE)
    private WebElement vendor_Phone;


    @FindBy(xpath = PRODUCT_SEARCH)
    private WebElement product_Search;

    @FindBy(xpath = CATEGORY_FILTER_SEARCH)
    private WebElement category_Filter_Search;

    @FindBy(xpath = CATEGORY_FILTER)
    private WebElement category_Filter;

    @FindBy(xpath = LIST_CATEGORY)
    private List<WebElement> list_Category;

    @FindBy(xpath = EXPECTED_PRODUCT_NAME)
    private List<WebElement> expected_Product_Name;

    @FindBy(xpath = REF_ID)
    private WebElement ref_Id;

    @FindBy(xpath = EMPTY_MESSAGE)
    private WebElement empty_Message;

    @FindBy(xpath = TRANSACTION_TAB)
    private WebElement transaction_Tab;

    @FindBy(xpath = TRANSACTION_TABLE)
    private List<WebElement> transaction_Table;

    @FindBy(xpath = EMPTY_MESSAGE_TABLE)
    private List<WebElement> empty_Message_Table;

    @FindBy(xpath = EXPECTED_CATEGORY_NAME)
    private List<WebElement> expected_Category_Name;

    @FindBy(xpath = AITERNATIVE_UNIT)
    private WebElement alternative_Unit;

    @FindBy(xpath = SELECT_UNIT)
    private WebElement select_Unit;

    @FindBy(xpath = CONVERSION_RATE_TXT)
    private WebElement conversion_rate_txt;


    @FindBy(xpath = PROFILE_NAME)
    private WebElement profile_Name;

    @FindBy(xpath = UNIT_EXPECTED)
    private WebElement expected_Unit;

    @FindBy(xpath = AVERAGE_PURCHASE_PRICE)
    private WebElement average_Purchase_Price;

    @FindBy(xpath = CREATED_BY)
    private WebElement creared_By;

    @FindBy(xpath = UPDATED_BY)
    private WebElement updated_By;

    @FindBy(xpath = CREATED_AT)
    private WebElement created_At;

    @FindBy(xpath = UPDATED_AT)
    private WebElement updated_At;

    @FindBy(xpath = PPURICE_EXPECT)
    private WebElement purchase_Price_Expect;

    @FindBy(xpath = SELLING_EXPECT)
    private WebElement selling_Price_Expect;

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

    @FindBy(xpath = WAREHOUSE_MODULE)
    private WebElement warehouses_Module;

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
    private List<WebElement> chk_Box_Delete_Item;

    @FindBy(xpath = RESTORE_ITEM)
    private WebElement restore;


    @FindBy(xpath = SERVICE_BUTTON)
    private WebElement serive_Section;

    @FindBy(xpath = PRODUCT_BUTTON)
    private WebElement product_Section;

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

    @FindBy(xpath = CONFIRM_DELETE)
    private WebElement cofirm_Delete;

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

    @FindBy(xpath = ADD_WAREHOUSE)
    private WebElement add_Warehouse;

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

    @FindBy(xpath = CATEGORY_LIST_NAME)
    private List<WebElement> category_list_Name;

    @FindBy(xpath = SERVICE_LIST_NAME)
    private List<WebElement> service_list_Name;

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


    public TC001_Items_Page(WebDriver driver) {
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
                Thread.sleep(DELAY_IN_MILLI_SECS);
                setWait(wait).until(ExpectedConditions.visibilityOf(btn_ContryCode));
                populateField(btn_ContryCode, "+91" + Keys.ENTER);
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

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void companySelect(String company) throws Exception {
        By companyLocator = By.xpath("//h3[text()='" + company + "']");

        if (isElementPresent(companyLocator)) {
            getDriver().findElement(companyLocator).click();// reusable method
            setWait(wait).until(ExpectedConditions.visibilityOf(btnConfrim));
            clickElement(btnConfrim);
            Thread.sleep(DELAY_IN_MILLI_SECS);
            Hooks.captureT(scenario);
        } else {
            System.out.println("Skip company selection");
        }

    }


    public void selectModuleAndSub(String module, String sub) throws Exception {

        switch (module) {
            case "Items":
                setWait(wait).until(ExpectedConditions.visibilityOf(items));
                clickElement(items);
                if (sub.equalsIgnoreCase("Items Management")) {
                    setWait(wait).until(ExpectedConditions.visibilityOf(itemsList));
                    clickElement(itemsList);
                    Thread.sleep(DELAY_IN_MILLI_SECS);
                } else if (sub.equalsIgnoreCase("Warehouses")) {
                    setWait(wait).until(ExpectedConditions.visibilityOf(warehouses_Module));
                    clickUsingJavaScript(warehouses_Module);
                    Thread.sleep(DELAY_IN_MILLI_SECS);
                }
                break;
        }
    }

    List<WebElement> elements;
    String text = "";
    String trim = "";

    public void clickOnButton(String button) {
        switch (button) {
            case "Product":
                setWait(wait).until(ExpectedConditions.visibilityOf(product_Section));
                clickElement(product_Section);

                // Product Name
                text = getDriver().findElement(By.xpath("//div[@class='text-text-primary text-[20px] font-[700]']")).getText();
                trim = text.substring(0, text.indexOf("(")).trim();
                Dictionary.storeInGlobalDictionary("Product Name", trim);
                // Category Nmae
                Dictionary.storeInGlobalDictionary("Category Name", getDriver().findElement(By.xpath("(//div[@class='text-text-primary text-start text-[10px] font-[400] mt-1'])[1]")).getText());
                // Unit name
                Dictionary.storeInGlobalDictionary("Unit Name", getText(expected_Unit).split(" ")[0]);
                // Purchase Price
                Dictionary.storeInGlobalDictionary("Purchase Price", getText(purchase_Price_Expect).substring(1));

                // Warehouse Info

                List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));

                for (WebElement row : rows) {

                    String warehouse = normalize(row.findElement(By.xpath("./td[1]")).getText());
                    String wholesale = row.findElement(By.xpath("./td[2]")).getText().replace("₹", "").trim();
                    String selling = row.findElement(By.xpath("./td[3]")).getText().replace("₹", "").trim();
                    String quantity = row.findElement(By.xpath("./td[4]")).getText().trim();

                    Map<String, String> values = new HashMap<>();
                    values.put("wholesale", wholesale);
                    values.put("selling", selling);
                    values.put("quantity", quantity);

                    listData.put(warehouse, values);
                }

                break;
            case "Service":
                setWait(wait).until(ExpectedConditions.visibilityOf(serive_Section));
                clickOperation(serive_Section);
                elements = getDriver().findElements(By.xpath("//button[contains(@class,'border-b w-full')]"));

                // Product Name
                text = getDriver().findElement(By.xpath("//div[@class='text-text-primary text-[20px] font-[700]']")).getText();
                trim = text.substring(0, text.indexOf("(")).trim();
                Dictionary.storeInGlobalDictionary("Product Name", trim);
                // Category Nmae
                Dictionary.storeInGlobalDictionary("Category Name", getDriver().findElement(By.xpath("(//div[@class='text-text-primary text-start text-[10px] font-[400] mt-1'])[1]")).getText());
                // Unit name
                Dictionary.storeInGlobalDictionary("Unit Name", getText(expected_Unit).split(" ")[0]);
                // Purchase Price
                Dictionary.storeInGlobalDictionary("Selling Price", getText(selling_Price_Expect).substring(1));

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
                break;
        }

    }

    public boolean isCategoryExists(String name) {

        if (category_list_Name.size() > 0) {

            for (WebElement category : category_list_Name) {

                if (category.getText().trim().equalsIgnoreCase(name.trim())) {
                    System.out.println("Category already exists: " + name);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isServiceExists(String name) {

        if (service_list_Name.size() > 0) {

            for (WebElement category : service_list_Name) {

                if (category.getText().trim().equalsIgnoreCase(name.trim())) {
                    System.out.println("Service already exists: " + name);
                    return true;
                }
            }
        }

        return false;
    }

    public void validate_List_Before_Creation_Service_List(String name) {
        if (isServiceExists(name)) {

            System.out.println("Category already exists → skipping scenario");

            throw new SkipException("Category already exists: " + name);
        }
    }

    public void validate_List_Before_Creation(String name) {

        if (isCategoryExists(name)) {

            System.out.println("Category already exists → skipping scenario");

            throw new SkipException("Category already exists: " + name);
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
            case "Add Warehouse":

                setWait(wait).until(ExpectedConditions.visibilityOf(add_Warehouse));
                clickElement(add_Warehouse);
                break;

        }

    }


    public void entersDetils(String dep, String name, String unitSymbol, String unit, String categoryField) throws Exception {
        String unitList = "//span[text()='" + unit + "']";
//        String unitSymbolList = "//span[text()='" + unitSymbol + "']";
        String categoryList = "//button[text()='" + categoryField + "']";
        boolean categoryFoun = false, unitFound = false;
        switch (dep) {
            case "Product":
                setWait(wait).until(ExpectedConditions.visibilityOf(Product_Name));
                populateField(Product_Name, name);
                Dictionary.storeInGlobalDictionary("Product", name);
                Dictionary.storeInGlobalDictionary("Unit", unit);
                Dictionary.storeInGlobalDictionary("Category", categoryField);
                setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                clickElement(Unit);
                List<WebElement> unitListText = getDriver().findElements(By.xpath("//button[@class='p-2 cursor-pointer hover:bg-gray-100 w-full text-start border-b']"));
                for (WebElement unitListElement : unitListText) {
                    String unitSymbol1 = unitListElement.findElement(By.xpath(".//span[1]")).getText();
                    String unitName = unitListElement.findElement(By.xpath(".//span[last()]")).getText();
                    if (unitSymbol1.equalsIgnoreCase(unitSymbol) && unitName.equalsIgnoreCase(unit)) {
                        clickUsingJavaScript(unitListElement);
                        unitFound = true;
                        break;
                    }
                }
                if (!unitFound) {
                    setWait(wait).until(ExpectedConditions.visibilityOf(btn_New_Unit));
                    clickElement(btn_New_Unit);
                    populateField(unit_Name, unit);
                    populateField(symbol, unitSymbol);
                    clickElement(btn_Add_Unit);
                    setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                    clickElement(Unit);
                    getDriver().findElement(By.xpath(unitList)).click();
                }

                setWait(wait).until(ExpectedConditions.visibilityOf(category));
                clickElement(category);
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
                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    setWait(wait).until(ExpectedConditions.visibilityOf(category));
                    clickElement(category);
                    getDriver().findElement(By.xpath(categoryList)).click();
                }
                break;

            case "Service":
                setWait(wait).until(ExpectedConditions.visibilityOf(Product_Name));
                populateField(Product_Name, name);
                Dictionary.storeInGlobalDictionary("Product", name);
                Dictionary.storeInGlobalDictionary("Unit", unit);
                Dictionary.storeInGlobalDictionary("Category", categoryField);
                setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                clickElement(Unit);
                List<WebElement> unitListText1 = getDriver().findElements(By.xpath("//button[@class='p-2 cursor-pointer hover:bg-gray-100 w-full text-start border-b']"));
                for (WebElement unitListElement : unitListText1) {
                    String unitSymbol1 = unitListElement.findElement(By.xpath(".//span[1]")).getText();
                    String unitName = unitListElement.findElement(By.xpath(".//span[last()]")).getText();
                    if (unitSymbol1.equalsIgnoreCase(unitSymbol) && unitName.equalsIgnoreCase(unit)) {
                        clickUsingJavaScript(unitListElement);
                        unitFound = true;
                        break;
                    }
                }
                if (!unitFound) {
                    setWait(wait).until(ExpectedConditions.visibilityOf(btn_New_Unit));
                    clickElement(btn_New_Unit);
                    populateField(unit_Name, unit);
                    populateField(symbol, unitSymbol);
                    clickElement(btn_Add_Unit);
                    setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
                    clickElement(Unit);
                    getDriver().findElement(By.xpath(unitList)).click();
                }


                setWait(wait).until(ExpectedConditions.visibilityOf(category));
                clickElement(category);
                //List<WebElement> categoryLists = getDriver().findElements(By.xpath("//button[@class='p-2 cursor-pointer hover:bg-gray-100 w-full text-start border-b']"));
                if (category_List.size() > 0) {
                    for (WebElement category : category_List) {
                        if (category.getText().equalsIgnoreCase(categoryField)) {
                            clickElement(category);
                            categoryFoun = true;
                            break;
                        }
                    }
                }
                if (!categoryFoun) {
                    setWait(wait).until(ExpectedConditions.visibilityOf(add_Category));
                    clickElement(add_Category);
                    setWait(wait).until(ExpectedConditions.visibilityOf(type_Service));
                    clickElement(type_Service);
                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    populateField(category_Name, categoryField);
                    populateField(category_Description, "Good");
                    setWait(wait).until(ExpectedConditions.visibilityOf(save_Category));
                    clickElement(save_Category);
                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    setWait(wait).until(ExpectedConditions.visibilityOf(category));
                    clickElement(category);
                    getDriver().findElement(By.xpath(categoryList)).click();
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

    public void alternative_details(String name, String unitSymbol, String unit, String al_Unit, String categoryField) throws Exception {
        String unitList = "//span[text()='" + unit + "']";
        String unitSymbolList = "//span[text()='" + unitSymbol + "']";
        String categoryList = "//button[text()='" + categoryField + "']";
        setWait(wait).until(ExpectedConditions.visibilityOf(Product_Name));
        populateField(Product_Name, name);
        Dictionary.storeInGlobalDictionary("Product", name);
        Dictionary.storeInGlobalDictionary("Unit", unit);
        Dictionary.storeInGlobalDictionary("Category", categoryField);
        setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
        clickElement(Unit);
        List<WebElement> unitListText = getDriver().findElements(By.xpath("//button[@class='p-2 cursor-pointer hover:bg-gray-100 w-full text-start border-b']"));
        boolean categoryFoun = false, unitFound = false;
        for (WebElement unitListElement : unitListText) {
            String unitSymbol1 = unitListElement.findElement(By.xpath(".//span[1]")).getText();
            String unitName = unitListElement.findElement(By.xpath(".//span[last()]")).getText();
            if (unitSymbol1.equalsIgnoreCase(unitSymbol) && unitName.equalsIgnoreCase(unit)) {
                clickUsingJavaScript(unitListElement);
                unitFound = true;
                break;
            }
        }
        if (!unitFound) {
            setWait(wait).until(ExpectedConditions.visibilityOf(btn_New_Unit));
            clickElement(btn_New_Unit);
            populateField(unit_Name, unit);
            populateField(symbol, unitSymbol);
            clickElement(btn_Add_Unit);
            setWait(wait).until(ExpectedConditions.visibilityOf(Unit));
            clickElement(Unit);
            getDriver().findElement(By.xpath(unitList)).click();
        }

        clickElement(alternative_Unit);
        populateField(select_Unit, al_Unit + Keys.ENTER);
        setWait(wait).until(ExpectedConditions.visibilityOf(conversion_rate_txt));
        populateField(conversion_rate_txt, "5");
        String conversion_Rate = conversion_rate_txt.getAttribute("value");
        Dictionary.storeInGlobalDictionary("actual_ConversionRate", conversion_Rate);
        clickElement(btnSave);


        setWait(wait).until(ExpectedConditions.visibilityOf(category));
        clickElement(category);
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
            Thread.sleep(DELAY_IN_MILLI_SECS);
            setWait(wait).until(ExpectedConditions.visibilityOf(category));
            clickElement(category);
            getDriver().findElement(By.xpath(categoryList)).click();


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
        populateField(length, lenth);
        populateField(depth, depth1);
        populateField(size, sizes);
        setWait(wait).until(ExpectedConditions.visibilityOf(price_Date));
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dynamicDate = today.format(dateTimeFormatter);
        populateField(price_Date, dynamicDate);
        populateField(matrialQuality, matrialQualitys);
    }

    public void additionalInfo(String parchase, String sell, String vendorName) throws InterruptedException {
        populateField(purchase_Price, parchase);
        populateField(selling_Price, sell);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        clickElement(knownVendor);
        knownVendor.sendKeys(vendorName, Keys.ENTER);

    }

    public void fillAdditionalInfo(String vendor) throws Exception {

        populateField(purchase_Price, "100");
        String purchasePriceActual = getAttribute(purchase_Price, "value");
        Dictionary.storeInGlobalDictionary("purchasePriceActual", purchasePriceActual);
        Dictionary.storeInGlobalDictionary("AveragePurchasePrice", purchasePriceActual);

//        getDriver().findElement(By.xpath("//input[@placeholder='Search vendor here...']")).click();
//        List<WebElement> vendorList = getDriver().findElements(By.xpath("//button[@class='p-3 cursor-pointer hover:bg-gray-100 w-full text-start border-b last:border-b-0']//child::span[1]"));
//        boolean vendorFound = false;
//        if (vendorList.size() > 0) {
//            for (WebElement vendorOption : vendorList) {
//                if (vendorOption.getText().equalsIgnoreCase(vendor)) {
//                    clickElement(vendorOption);
//                    vendorFound = true;
//                    break;
//                }
//            }
//        }
//        if (!vendorFound) {
//            clickElement(add_vendor);
//            setWait(wait).until(ExpectedConditions.visibilityOf(vendor_Full_Name));
//            populateField(vendor_Full_Name, vendor);
//            populateField(vendor_Phone, "987654321");
//            clickElement(btn_Add_vendor);
//            Thread.sleep(DELAY_IN_MILLI_SECS);
//            getDriver().findElement(By.xpath("//input[@placeholder='Search vendor here...']")).click();
//            getDriver().findElement(By.xpath("//span[text()='" + vendor + "']")).click();
//
//        }
//
//        setWait(wait).until(ExpectedConditions.visibilityOf(item_Image));
//        clickElement(item_Image);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement upload = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
//        upload.sendKeys("C:\\Users\\futur\\OneDrive\\Pictures\\bag.jpg");
    }

    public void fillWarehouseInfo(String warehouseField) throws Exception {
        int avialbeQuantity = 0;
        Map<String, WarehouseDate> warehousePriceMap = new HashMap<>();
        List<WebElement> elements1 = getDriver().findElements(By.xpath("//p[contains(text(),'Warehouse Information')]"));
        if (elements1.size() > 0) {

            populateField(opening_Stock_Value, "200");
            avialbeQuantity = avialbeQuantity + Integer.parseInt(opening_Stock_Value.getAttribute("value"));
            LocalDate today = LocalDate.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String asOfDate = today.format(dateTimeFormatter);
//            populateField(opening_stock_Date, asOfDate);
            populateField(selling_Price_Warehouse, "300");
            populateField(warehouse_Wholesale_Price, "200");
            populateField(min_Quantity, "10");
            String warehouseName = "main warehouse";

            warehousePriceMap.put(warehouseName, new WarehouseDate
                    (
                            Double.parseDouble(opening_Stock_Value.getAttribute("value")),
                            Double.parseDouble(warehouse_Wholesale_Price.getAttribute("value")),
                            Double.parseDouble(selling_Price_Warehouse.getAttribute("value"))
                    )
            );

            Thread.sleep(DELAY_IN_MILLI_SECS);
            Hooks.captureT(scenario);

        } else {
            Dictionary.storeInGlobalDictionary("Warehouse Name", warehouseField);
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
                    Dictionary.storeInGlobalDictionary("OpeningStock", openingStock.getAttribute("value"));
                    double openingStockValue = Double.parseDouble(getAttribute(openingStock, "value"));
                    System.out.println("openingStockValue : " + openingStockValue);
                    avialbeQuantity += openingStockValue;

                    Thread.sleep(DELAY_IN_MILLI_SECS);

                    WebElement warehouse_Wholesale_Price = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Wholesale Price here']"));
                    populateField(warehouse_Wholesale_Price, "300");
                    double warehouseWholesalePriceValue = Double.parseDouble(getAttribute(warehouse_Wholesale_Price, "value"));
                    System.out.println("warehouseWholesalePriceValue : " + warehouseWholesalePriceValue);

                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    WebElement warehouse_Selling_Price = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Retail Price here...']"));
                    populateField(warehouse_Selling_Price, "250");
                    double warehouseSellingPriceValue = Double.parseDouble(getAttribute(warehouse_Selling_Price, "value"));
                    System.out.println("warehouseSellingPriceValue : " + warehouseSellingPriceValue);

                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    WebElement min_Quantity = container.get(i).findElement(By.xpath(".//input[@placeholder='Write the Minimum Quantity here to get notified']"));
                    populateField(min_Quantity, "10");
                    warehousePriceMap.put(
                            warehouseName.trim().toLowerCase(),
                            new WarehouseDate(openingStockValue, warehouseWholesalePriceValue, warehouseSellingPriceValue));
                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    Hooks.captureT(scenario);
                }

                if (avialbeQuantity > 0) {
                    double avgPurchasePrice = avialbeQuantity * Double.parseDouble(Dictionary.getFromGlobalDictionary("purchasePriceActual")) / avialbeQuantity;
                    Dictionary.storeInGlobalDictionary("AveragePurchasePrice", String.valueOf(Math.round(avgPurchasePrice)));
                }

            }
        }
        Dictionary.storeInGlobalDictionary("avialableQuantity", String.valueOf(avialbeQuantity));
        Dictionary.storeInGlobalDictionary("WAREHOUSE_PRICE_MAP", warehousePriceMap);


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
                LocalDateTime beforeUtc = ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();
                Dictionary.storeInGlobalDictionary("BeforeCreation", beforeUtc);
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

            case "Add Warehouse":
                setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//button[text()='" + btn + "']"))));
                clickElement(getDriver().findElement(By.xpath("//button[text()='" + btn + "']")));
                Hooks.captureT(scenario);
                break;

            case "Update Warehouse":
                setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//button[text()='" + btn + "']"))));
                clickElement(getDriver().findElement(By.xpath("//button[text()='" + btn + "']")));
                Hooks.captureT(scenario);
                break;
        }

    }

    public void validate_the_Product_In_Warehouse(String Warehoue) throws InterruptedException {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("(//span[contains(text(),'Warehouses')]/parent::a)[1]"))));
        clickUsingJavaScript(getDriver().findElement(By.xpath("(//span[contains(text(),'Warehouses')]/parent::a)[1]")));

        if (getDriver().findElement(By.xpath("//p[text()='" + warehouse + "']")).getText().equalsIgnoreCase(Warehoue)) {
            getDriver().findElement(By.xpath("//p[text()='" + warehouse + "']")).click();
            Thread.sleep(DELAY_IN_MILLI_SECS);
// Product Name
            setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[text()='Item Name']/ancestor::thead/following::tbody//child::td[3]"))));
            String productName = getDriver().findElement(By.xpath("(//span[text()='Item Name']/ancestor::thead/following::tbody//child::td)[3]")).getText();
            System.out.println("productName : " + productName);
            Assert.assertEquals(productName, Dictionary.getFromGlobalDictionary("Product"), "Verify the Product in warehouse");

            //Quantity
            setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("(//span[text()='Item Name']/ancestor::thead/following::tbody//child::td)[4]/child::span"))));
            String quantity = getDriver().findElement(By.xpath("(//span[text()='Item Name']/ancestor::thead/following::tbody//child::td)[4]/child::span")).getText().substring(0, 3);
            Assert.assertEquals(quantity, Dictionary.getFromGlobalDictionary("OpeningStock"), "Verify the Product in warehouse");
            // Ave PP
            setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("(//span[text()='Item Name']/ancestor::thead/following::tbody//child::td)[7]/child::span"))));
            String average_PP = getDriver().findElement(By.xpath("(//span[text()='Item Name']/ancestor::thead/following::tbody//child::td)[7]/child::span")).getText().substring(1);
            Assert.assertEquals(average_PP, Dictionary.getFromGlobalDictionary("AveragePurchasePrice_UI"), "Verify the Product in warehouse");

// Selling Price
            setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("(//span[text()='Item Name']/ancestor::thead/following::tbody//child::td)[8]//child::span"))));
            String sellPeice = getDriver().findElement(By.xpath("(//span[text()='Item Name']/ancestor::thead/following::tbody//child::td)[8]//child::span")).getText().substring(1);
            double actual = Double.parseDouble(sellPeice);
            System.out.println(actual);
            Object uiSellingPrice = Dictionary.getFromGlobalDictionary("UISellingPrice");
            System.out.println(uiSellingPrice);
            Assert.assertEquals(actual, uiSellingPrice, "Verify the Product in warehouse");
// Wholesale Price
            setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("(//span[text()='Item Name']/ancestor::thead/following::tbody//child::td)[9]//child::span"))));
            String wholesaleprice = getDriver().findElement(By.xpath("(//span[text()='Item Name']/ancestor::thead/following::tbody//child::td)[9]//child::span")).getText().substring(1);
            Object uiWholesalePrice = Dictionary.getFromGlobalDictionary("UIWholesalePrice");
            Assert.assertEquals(Double.parseDouble(wholesaleprice), uiWholesalePrice, "Verify the Product in warehouse");
        }

    }

    public void validate_Service_List() {

        // List product Validation
        String expectedtext = getText(item_Name).trim();
        String name = Dictionary.getFromGlobalDictionary("Product");
        Assert.assertEquals(name, expectedtext, "Verify the Item is Shown");

        // Unit
        Assert.assertEquals(Dictionary.getFromGlobalDictionary("Unit"),
                getText(expected_Unit).split(" ")[0], "Verify the Item is Shown");
        // Selling Price

        Assert.assertEquals(Dictionary.getFromGlobalDictionary("SellPrice"),
                getText(selling_Price_Expect).substring(1), "Verify the Item is Shown");
    }

    public void validateItem() throws Exception {

        Thread.sleep(DELAY_IN_MILLI_SECS);
        setWait(wait).until(ExpectedConditions.visibilityOf(item_Name));
        String id = getText(id_Item).substring(1);
        Dictionary.storeInGlobalDictionary("ID", id);

        // List product Validation
        String expectedtext = getText(item_Name).trim();
        String name = Dictionary.getFromGlobalDictionary("Product");
        Assert.assertEquals(name, expectedtext, "Verify the Item is Shown");

//        //Purchase Price Validation
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

            String uIWarehouseName = wholesalePrice.findElement(By.xpath("./td[1]")).getText().trim().toLowerCase();

            // Wholesale Price
            Double uiWholesale = Double.parseDouble(wholesalePrice.findElement(By.xpath(".//td[count(//th[normalize-space()='Wholesale Price']/preceding-sibling::th)+1]"))
                    .getText().replace("₹", "").trim());
            Dictionary.storeInGlobalDictionary("UIWholesalePrice", uiWholesale);

            // Selling Price
            Double uiSelling = Double.parseDouble(wholesalePrice.findElement(By.xpath(".//td[count(//th[normalize-space()='Selling Price']/preceding-sibling::th)+1]"))
                    .getText().replace("₹", "").trim());
            Dictionary.storeInGlobalDictionary("UISellingPrice", uiSelling);
            Double qtyText = Double.parseDouble(wholesalePrice.findElement(By.xpath("./td[4]")).getText().trim());


            WarehouseDate warehouseDate = expectedMap.get(uIWarehouseName);

            Assert.assertNotNull(warehouseDate, "No expected data found for warehouse: " + uIWarehouseName);

            Assert.assertEquals(uiWholesale, warehouseDate.getWholesalePrice(), "Wholesale Price mismatch for " + uIWarehouseName);

            Assert.assertEquals(uiSelling, warehouseDate.getSellingPrice(), "Selling Price mismatch for " + warehouseDate);

            Assert.assertEquals(qtyText, warehouseDate.getOpeningstock(), "Quantity Price mismatch for " + uIWarehouseName);

        }

    }

    private LocalDateTime parseDateTime(String value) {
        if (value == null || value.trim().isEmpty())
            throw new IllegalArgumentException("Date value is empty");

        String v = value.trim();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a", Locale.ENGLISH);

        return LocalDateTime.parse(v, formatter);
    }

    private String getListCellTextByHeader(String headerName) {
        try {
            List<WebElement> headers = getDriver().findElements(By.xpath("//div[@class='font-[500] text-[14px] text-text-primary']"));
            for (int i = 0; i < headers.size(); i++) {
                if (headers.get(i).getText().trim().toLowerCase().contains(headerName.trim().toLowerCase())) {
                    int colIndex = i + 1;
                    String cellXpath = "//div[@class='font-[500] text-[14px] text-text-primary']/following-sibling::div";
                    WebElement cell = getDriver().findElement(By.xpath(cellXpath));
                    return cell.getText().trim();
                }
            }
        } catch (Exception e) {
            log4jBaseClass.error("getListCellTextByHeader failed for header: " + headerName + " - " + e.getMessage());
        }
        return "";
    }

    /**
     * Full validation on List page: Product, Unit, Category, Purchase Price, Average Purchase Price, Available Quantity, Created By, Created At, Updated By, Updated At
     */
    public void validateItemInFullValidation() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        setWait(wait).until(ExpectedConditions.visibilityOf(item_Name));


        Assert.assertEquals(Dictionary.getFromGlobalDictionary("Unit"),
                getText(expected_Unit).split(" ")[0], "Verify the Item is Shown");


        Assert.assertEquals(Dictionary.getFromGlobalDictionary("avialableQuantity"),
                getText(available_Quantity_Expect).split(" ")[0], "Verify the Item is Shown");

        //Purchase Price Validation
        Assert.assertEquals(Dictionary.getFromGlobalDictionary("purchasePriceActual"),
                getText(purchase_Price_Expect).substring(1), "Verify the Item is Shown");

        Assert.assertEquals(Dictionary.getFromGlobalDictionary("AveragePurchasePrice"),
                getText(average_Purchase_Price).substring(1), "Verify the Item is Shown");
        Dictionary.storeInGlobalDictionary("AveragePurchasePrice_UI", getText(average_Purchase_Price).substring(1));

//        Assert.assertEquals(getText(profile_Name).split(" ")[0],
//                getText(creared_By), "Verify the Item is Shown");
//        if (isDisplayed(updated_By) && isDisplayed(updated_At)) {
//            Assert.assertEquals(getText(profile_Name).split(" ")[0],
//                    getText(updated_By), "Verify the Item is Shown");
//            Assert.assertFalse(getText(updated_At).isEmpty(), "Updated At should not be empty");
//            // Assert.assertTrue(parseDateTime(getText(updated_At)), "Updated At should be valid date and time format, got: " + getText(updated_At));
//        }
//        LocalDateTime uiTime = parseDateTime(created_At.getText());
//        LocalDateTime afterCreation = LocalDateTime.now();
//        // Get current UTC time
//        LocalDateTime nowUtc =
//                ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();
//
//        System.out.println("Current UTC Time: " + nowUtc);
//
//        // Calculate difference in minutes
//        long diffMinutes = ChronoUnit.MINUTES.between(uiTime, nowUtc);
//
//        System.out.println("Difference in Minutes: " + diffMinutes);
//        Assert.assertTrue(
//                !uiTime.isBefore(Dictionary.getFromGlobalDictionary("BeforeCreation")) &&
//                        !uiTime.isAfter(nowUtc),
//                "Created time is not within expected range"
//        );
//        // Product name
        String expectedProduct = Dictionary.getFromGlobalDictionary("Unit");
        String actualProduct = getListCellTextByHeader("Unit");
        if (actualProduct.isEmpty()) {
            actualProduct = getText(item_Name);
        }
        Assert.assertEquals(expectedProduct, actualProduct, "Product name mismatch on list page");
//
//        // Unit
        String expectedUnit = Dictionary.getFromGlobalDictionary("Available Quantity");
        if (expectedUnit != null) {
            String actualUnit = getListCellTextByHeader("Available Quantity");
            Assert.assertEquals(expectedUnit, actualUnit, "Unit mismatch on list page");
        }

//        // Category name
        String expectedCategory = Dictionary.getFromGlobalDictionary("Purchase Price");
        if (expectedCategory != null) {
            String actualCategory = getListCellTextByHeader("\n" +
                    "Purchase Price");
            if (actualCategory.isEmpty()) {
                actualCategory = getListCellTextByHeader("Category Name");
            }
            Assert.assertEquals(expectedCategory, actualCategory, "Category name mismatch on list page");
        }

//        // Purchase Price (list page)
//        String expectedPurchasePrice = Dictionary.getFromGlobalDictionary("purchasePriceActual");
//        String actualPurchasePrice = getListCellTextByHeader("Purchase Price");
//        if (actualPurchasePrice.isEmpty()) {
//            actualPurchasePrice = getText(purchase_Price_Expect).replace("₹", "").trim();
//        } else {
//            actualPurchasePrice = actualPurchasePrice.replace("₹", "").trim();
//        }
//        Assert.assertEquals(expectedPurchasePrice, actualPurchasePrice, "Purchase price mismatch on list page");
//
//        // Average Purchase Price: expected = average of warehouse opening purchase prices (stored in fillWarehouseInfo)
//        String expectedAvgPurchasePrice = Dictionary.getFromGlobalDictionary("AveragePurchasePrice");
//        if (expectedAvgPurchasePrice != null) {
//            String actualAvgPurchasePrice = getListCellTextByHeader("Average Purchase Price");
//            if (!actualAvgPurchasePrice.isEmpty()) {
//                actualAvgPurchasePrice = actualAvgPurchasePrice.replace("₹", "").replace(",", "").trim();
//                Assert.assertEquals(expectedAvgPurchasePrice, actualAvgPurchasePrice, "Average Purchase Price mismatch on list page");
//            }
//        }
//
//        // Available Quantity
//        String expectedQty = Dictionary.getFromGlobalDictionary("avialableQuantity");
//        String actualQty = getListCellTextByHeader("Available Quantity");
//        if (actualQty.isEmpty()) {
//            actualQty = getText(available_Quantity_Expect).split(" ")[0].trim();
//        } else {
//            actualQty = actualQty.split(" ")[0].trim();
//        }
//        Assert.assertEquals(expectedQty, actualQty, "Available quantity mismatch on list page");

//        // Created By
//        String expectedCreatedBy = Dictionary.getFromGlobalDictionary("CreatedBy");
//        if (expectedCreatedBy != null) {
//            String actualCreatedBy = getListCellTextByHeader("Created By");
//            Assert.assertEquals(expectedCreatedBy, actualCreatedBy, "Created By mismatch on list page");
//        }
//
//        // Created At (date and time) - validate not empty and valid date-time format
//        String createdAt = getListCellTextByHeader("Created At");
//        Assert.assertFalse(createdAt.isEmpty(), "Created At should not be empty on list page");
//        Assert.assertTrue(isValidDateTime(createdAt), "Created At should be valid date and time format, got: " + createdAt);

//        // Updated By
//        String expectedUpdatedBy = Dictionary.getFromGlobalDictionary("CreatedBy");
//        if (expectedUpdatedBy != null) {
//            String actualUpdatedBy = getListCellTextByHeader("Updated By");
//            Assert.assertEquals(expectedUpdatedBy, actualUpdatedBy, "Updated By mismatch on list page");
//        }

//        // Updated At (date and time) - validate not empty and valid date-time format
//        String updatedAt = getListCellTextByHeader("Updated At");
//        Assert.assertFalse(updatedAt.isEmpty(), "Updated At should not be empty on list page");
//        Assert.assertTrue(isValidDateTime(updatedAt), "Updated At should be valid date and time format, got: " + updatedAt);
    }

    public void validate_ErrorMassge(String errorMessage) throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        String error = "//div[text()='" + errorMessage + "']";
        String expectedText = getDriver().findElement(By.xpath(error)).getText();
        Assert.assertEquals(errorMessage, expectedText);

    }

    private String normalize(String text) {
        return text.trim().replaceAll("\\s+", " ").toLowerCase();
    }

    static Map<String, Map<String, String>> listData = new HashMap<>();


    public void actions(String action) throws Exception {

        switch (action) {
            case "View":
                System.out.println("Stored Data: " + listData);
                setWait(wait).until(ExpectedConditions.visibilityOf(view));
                clickElement(view);
                break;
            case "Edit":
                setWait(wait).until(ExpectedConditions.visibilityOf(edit));
                clickUsingJavaScript(edit);
                break;
            case "Delete":
                String id = getText(id_Item);
                Dictionary.storeInGlobalDictionary("ID", id);
                setWait(wait).until(ExpectedConditions.visibilityOf(delete));
                clickUsingJavaScript(delete);
                break;
        }

    }

    public void clickOnWarehouseList(String action) throws Exception {
        switch (action) {
            case "Delete":
                setWait(wait).until(ExpectedConditions.visibilityOf(delete));
                clickUsingJavaScript(delete);
                break;
            case "View":
                setWait(wait).until(ExpectedConditions.visibilityOf(view));
                clickUsingJavaScript(view);
                break;


        }
    }

    public void update_Service_Details() throws Exception {
        selling_Price.sendKeys(Keys.CONTROL + "a");
        selling_Price.sendKeys(Keys.DELETE);
        populateField(selling_Price, "800");
        String sellPriceText = selling_Price.getAttribute("value");
        Dictionary.storeInGlobalDictionary("SellPrice", sellPriceText);
        Hooks.captureT(scenario);
    }


    public void updateFiled_Product() throws Exception {
        Thread.sleep(DELAY_IN_MILLI_SECS);

        purchase_Price.sendKeys(Keys.CONTROL + "a");
        purchase_Price.sendKeys(Keys.DELETE);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        populateField(purchase_Price, "110");
        String PPriceText = purchase_Price.getAttribute("value");
        Dictionary.storeInGlobalDictionary("PPrice", PPriceText);
        getDriver().findElement(By.xpath("//button[@title='Delete']")).click();
    }

    public void validate_Service_Details() throws Exception {
        Hooks.captureT(scenario);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement toastMessage = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toastify-container div.text-sm")));
        System.out.println(toastMessage.getText());
        if ("Item updated successfully!".equalsIgnoreCase(toastMessage.getText())) {
            Assert.assertEquals("Item updated successfully!", toastMessage.getText());
            Assert.assertEquals(Dictionary.getFromGlobalDictionary("SellPrice"),
                    getText(selling_Price_Expect).substring(1), "Verify the Item is Shown");
        }
    }

    public void validateUpdate() throws Exception {
        Hooks.captureT(scenario);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement toastMessage = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toastify-container div.text-sm")));
        System.out.println(toastMessage.getText());
        if ("Item updated successfully!".equalsIgnoreCase(toastMessage.getText())) {
            if (purchase_Price_Expect.isEnabled()) {
                Assert.assertEquals(Dictionary.getFromGlobalDictionary("PPrice"),
                        getText(purchase_Price_Expect).substring(1), "Verify the Item is Shown");
                Assert.assertEquals("Item updated successfully!", toastMessage.getText());
            }
        }
    }

    public void clickDelete() throws Exception {
        setWait(wait).until(ExpectedConditions.visibilityOf(btn_Delete));
        clickElement(btn_Delete);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);

    }

    public void validateDelete() throws InterruptedException {
        String expectedText = getText(txt_Delete);
        System.out.println(expectedText);
        Assert.assertEquals("Deleted successfully.", expectedText);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        clickUsingJavaScript(cofirm_Delete);
    }

    public void addtionalInfo() {
        populateField(selling_Price, "1000");
        Dictionary.storeInGlobalDictionary("Selling Price", selling_Price.getAttribute("value"));
    }

    public void validateView() throws Exception {

        // Product Name
        String productExpectedText = Product_Name.getAttribute("value");
        String productActualText = Dictionary.getFromGlobalDictionary("Product Name");
        Assert.assertEquals(productActualText, productExpectedText);

        // Category Name
        String categoryExpectedText = view_Category.getAttribute("placeholder");
        System.out.println(categoryExpectedText);
        String categoryActualText = Dictionary.getFromGlobalDictionary("Category Name");
        System.out.println(categoryActualText);
        Assert.assertEquals(categoryActualText, categoryExpectedText);

        // Unit Name
        String unitExpectedText = view_Unit.getAttribute("placeholder").split("\\|")[1].trim();
        String unitActualText = Dictionary.getFromGlobalDictionary("Unit Name");
        Assert.assertEquals(unitActualText, unitExpectedText);

        // Warehouse Info
        List<WebElement> sections = driver.findElements(By.xpath("//p[contains(text(),'Warehouse Information')]"));

        for (int i = 0; i < sections.size(); i++) {

            WebElement section = sections.get(i);

            String sectionText = section.getText();

            String warehouseName = normalize(sectionText.replaceAll(".*\\((.*)\\)", "$1"));

            System.out.println("View Warehouse: " + warehouseName);
            System.out.println("Available Keys: " + listData.keySet());


            if (!listData.containsKey(warehouseName)) {
                throw new RuntimeException("Mismatch → warehouse: " + warehouseName + " Available: " + listData.keySet());
            }

            String viewWholesale = driver.findElement(By.id("warehouseItem[" + i + "].wholesale_price")).getAttribute("value");

            String viewRetail = driver.findElement(By.id("warehouseItem[" + i + "].selling_price")).getAttribute("value");

            String viewStock = driver.findElement(By.id("warehouseItem[" + i + "].opening_stock")).getAttribute("value");

            Map<String, String> listValues = listData.get(warehouseName);

            // Assertions
            Assert.assertEquals(Double.parseDouble(listValues.get("wholesale")), Double.parseDouble(viewWholesale));

            Assert.assertEquals(Double.parseDouble(listValues.get("selling")), Double.parseDouble(viewRetail));

            Assert.assertEquals(listValues.get("quantity"), viewStock);
        }

        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
    }

    public void validate_ServiceView() throws Exception {
        Hooks.captureT(scenario);
// Product Name
        String productExpectedText = Product_Name.getAttribute("value");
        String productActualText = Dictionary.getFromGlobalDictionary("Product Name");
        Assert.assertEquals(productActualText, productExpectedText);

        // Category Name
        String categoryExpectedText = view_Category.getAttribute("placeholder");
        System.out.println(categoryExpectedText);
        String categoryActualText = Dictionary.getFromGlobalDictionary("Category Name");
        System.out.println(categoryActualText);
        Assert.assertEquals(categoryActualText, categoryExpectedText);
        // Unit Name
        String unitExpectedText = view_Unit.getAttribute("placeholder").split("\\|")[1].trim();
        String unitActualText = Dictionary.getFromGlobalDictionary("Unit Name");
        Assert.assertEquals(unitActualText, unitExpectedText);

        // Selling Price
        String sellingExpectedText = selling_Price.getAttribute("value");
        String sellingActualText = Dictionary.getFromGlobalDictionary("Selling Price");
        Assert.assertEquals(sellingActualText, sellingExpectedText);
    }

    public static boolean isRestorePerformed = false;

    public void list_Deleted() throws Exception {
        setWait(wait).until(ExpectedConditions.visibilityOf(deleted_List));
        clickUsingJavaScript(deleted_List);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
    }

    public void validate_Delete_List() throws Exception {
        boolean hasData = getDriver().findElements(
                By.xpath("//tbody/tr/td[1][normalize-space()!='']")).size() > 0;

        if (!hasData) {
            System.out.println("No deleted items → skip");
            isRestorePerformed = false;
            return;
        }
        isRestorePerformed = true;
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        String expectedText = item_Code.getText();
        Dictionary.storeInGlobalDictionary("Item Code", expectedText);
        if (item_Code.getText().equals(expectedText)) {

            // Ref ID
            String actualText = Dictionary.getFromGlobalDictionary("ID");
            Dictionary.storeInGlobalDictionary("Item Code", expectedText);
            Assert.assertEquals(actualText, expectedText);

            // Product Name
            Assert.assertEquals(getDriver().findElement(By.xpath("//td[text()='" + Dictionary.getFromGlobalDictionary("Product Name") + "']")).getText(),
                    Dictionary.getFromGlobalDictionary("Product Name"));

            // Category Name
            Assert.assertEquals(getDriver().findElement(By.xpath("//td[text()='" + Dictionary.getFromGlobalDictionary("Category Name") + "']")).getText(),
                    Dictionary.getFromGlobalDictionary("Category Name"));

            // Unit Name
            Assert.assertEquals(getDriver().findElement(By.xpath("//td[text()='" + Dictionary.getFromGlobalDictionary("Unit Name") + "']")).getText(),
                    Dictionary.getFromGlobalDictionary("Unit Name"));

            // Purchase Price
            Assert.assertEquals(getDriver().findElement(By.xpath("//span[text()='Unit']/ancestor::thead/following::tbody//child::td[7]")).getText(),
                    Dictionary.getFromGlobalDictionary("Purchase Price"));
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

        boolean hasData = getDriver().findElements(
                By.xpath("//tbody/tr/td[2][normalize-space()!='']")
        ).size() > 0;

        if (!hasData) {
            System.out.println("No deleted items → skip restore");
            return;
        }
        isRestorePerformed = true;
        String expectedText = item_Code.getText();
        Dictionary.storeInGlobalDictionary("Item Code", expectedText);
        setWait(wait).until(ExpectedConditions.elementToBeClickable(chk_Box_Delete_Item.get(0)));
        clickUsingJavaScript(chk_Box_Delete_Item.get(0));
        setWait(wait).until(ExpectedConditions.visibilityOf(restore));
        clickUsingJavaScript(restore);


    }

    public void validateRestoreItem() throws Exception {
        if (!isRestorePerformed) {
            System.out.println("Restore not performed → validation skipped");
            return;
        }
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        setWait(wait).until(ExpectedConditions.visibilityOf(list));
        clickUsingJavaScript(list);
        String actualText = Dictionary.getFromGlobalDictionary("ID");
        String expectedText = Dictionary.getFromGlobalDictionary("Item Code");
        Assert.assertEquals(getText(id_Item), expectedText);

    }

    public void validateRestoreItem_Category() throws Exception {
        boolean hasData = getDriver().findElements(
                By.xpath("//tbody/tr/td[2][normalize-space()!='']")
        ).size() > 0;

        if (!hasData) {
            System.out.println("No deleted items → skip restore");
            return;
        }
        isRestorePerformed = true;
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
        setWait(wait).until(ExpectedConditions.visibilityOf(list));
        clickElement(list);
        String actualText = Dictionary.getFromGlobalDictionary("Deleted List Category Name");
        String expectedText = Dictionary.getFromGlobalDictionary("Category Name");
        Assert.assertEquals(actualText, expectedText);


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


        String unitName = Dictionary.getFromGlobalDictionary("UnitName");
        System.out.println(unitName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By spanLocator = By.xpath("//span[normalize-space()='" + Text_Content.getUnitName() + "']");
        By pLocator = By.xpath("//p[text()='" + Text_Content.getUnitName() + "']");

        String actualText = null;
        try {
            // First try SPAN
            actualText = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(spanLocator))
                    .getText()
                    .trim();
            System.out.println("Found text in SPAN");

        } catch (TimeoutException e) {
            //  If SPAN not found, try P
            actualText = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(pLocator))
                    .getText()
                    .trim();
            System.out.println("Found text in P tag");
        }

        //  ASSERTION
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


    public void searchProduct(String name) throws Exception {
        setWait(wait).until(ExpectedConditions.visibilityOf(product_Search));
        populateField(product_Search, name + Keys.ENTER);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Hooks.captureT(scenario);
//        expected_Product_Name.
//        Dictionary.storeInGlobalDictionary("Search Product Name",  getText(expected_Product_Name));
    }

    public void validateSearchedProduct(String name) {
        if (expected_Product_Name.size() > 0) {
            for (int i = 0; i < expected_Product_Name.size(); i++) {
                String actualName = expected_Product_Name.get(i).getText().trim();
                if (actualName.equalsIgnoreCase(name.trim())) {
                    Dictionary.storeInGlobalDictionary("Search Product Name", actualName);
                    break;
                }
            }
        }
        Assert.assertEquals(Dictionary.getFromGlobalDictionary("Search Product Name"), name, "Verify the Item is Shown");
        Dictionary.storeInGlobalDictionary("RefID", getText(ref_Id));
    }

    public void searchProductRefId() throws InterruptedException {
        setWait(wait).until(ExpectedConditions.visibilityOf(product_Search));
        product_Search.sendKeys(Keys.CONTROL + "a");
        product_Search.sendKeys(Keys.DELETE);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        String refID = Dictionary.getFromGlobalDictionary("RefID").toString();
        populateField(product_Search, refID + Keys.ENTER);
        Thread.sleep(DELAY_IN_MILLI_SECS);
        Dictionary.storeInGlobalDictionary("SearchRefID", product_Search.getAttribute("value"));
    }

    public void validateSearchedProductRefId() {
        Assert.assertEquals(getText(ref_Id), Dictionary.getFromGlobalDictionary("SearchRefID"), "Verify the Item is Shown");
    }


    public void validateNoProductAndMessage(String message) {
        Assert.assertEquals(getText(empty_Message), message, "Verify the Item is Shown");
    }

    public void clickCategoryFilter() throws Exception {
        setWait(wait).until(ExpectedConditions.visibilityOf(category_Filter));
        clickElement(category_Filter);
        Thread.sleep(DELAY_IN_MILLI_SECS);
    }

    public void searchCategoryInFilter(String Category) throws InterruptedException {
        setWait(wait).until(ExpectedConditions.visibilityOf(category_Filter_Search));
        populateField(category_Filter_Search, Category + Keys.ENTER);
        Thread.sleep(DELAY_IN_MILLI_SECS);
    }

    public void selectCategory(String category) throws Exception {
        if (list_Category.size() > 0) {
            for (WebElement element : list_Category) {
                if (element.getText().trim().equalsIgnoreCase(category.trim())) {
                    setWait(wait).until(ExpectedConditions.visibilityOf(element));
                    clickElement(element);
                    break;
                }
            }
            Thread.sleep(DELAY_IN_MILLI_SECS);
            Hooks.captureT(scenario);
        }
    }

    public void validateProductsFromCategory(String category) throws InterruptedException {
        Thread.sleep(DELAY_IN_MILLI_SECS);
        if (expected_Category_Name.size() > 0) {
            for (int i = 0; i < expected_Category_Name.size(); i++) {
                String actualCategory = expected_Category_Name.get(i).getText().trim();
                if (actualCategory.equalsIgnoreCase(category.trim())) {
                    Assert.assertEquals(actualCategory, category, "Verify the Item is Shown");
                }
                break;
            }
        }
    }


    public void validateProductUnderTheCategory(String product, String category) {
        boolean productFound = false;
        if (expected_Product_Name.size() > 0) {
            for (int i = 0; i < expected_Product_Name.size(); i++) {
                String actualProduct = expected_Product_Name.get(i).getText().trim();
                String actualCategory = expected_Category_Name.get(i).getText().trim();
                if (actualProduct.equalsIgnoreCase(product.trim()) && actualCategory.equalsIgnoreCase(category.trim())) {
                    Assert.assertEquals(actualProduct, product, "Verify the Item is Shown");
                    Assert.assertEquals(actualCategory, category, "Verify the Item is Shown");
                    productFound = true;
                    break;
                }
            }
        }
        Assert.assertTrue(productFound, "Product '" + product + "' not found under category '" + category + "'");
    }

    public void fillWarehouseInformation(String warehouseFiled) throws Exception {

        int avialbeQuantity = 0;
        Map<String, WarehouseDate> warehousePriceMap = new HashMap<>();
        List<WebElement> elements1 = getDriver().findElements(By.xpath("//p[contains(text(),'Warehouse Information')]"));
        if (elements1.size() > 0) {

            populateField(opening_Stock_Value, "200");
            avialbeQuantity = avialbeQuantity + Integer.parseInt(opening_Stock_Value.getAttribute("value"));
            populateField(selling_Price_Warehouse, "50");
            populateField(warehouse_Wholesale_Price, "70");
            populateField(min_Quantity, "10");
            String warehouseName = "main warehouse";

            warehousePriceMap.put(
                    warehouseName,
                    new WarehouseDate(
                            Double.parseDouble(opening_Stock_Value.getAttribute("value")),
                            Double.parseDouble(warehouse_Wholesale_Price.getAttribute("value")),
                            Double.parseDouble(selling_Price_Warehouse.getAttribute("value"))
                    )
            );

            Thread.sleep(DELAY_IN_MILLI_SECS);
            Hooks.captureT(scenario);

        } else {
            Dictionary.storeInGlobalDictionary("Warehouse Name", warehouseFiled);
            if (warehouse.isEnabled()) {
                setWait(wait).until(ExpectedConditions.visibilityOf(warehouse));
                clickElement(warehouse);

                String[] warehouseList = warehouseFiled.split(",");
                for (String warehouse : warehouseList) {
                    String WarehouseName = "//span[text()='" + warehouse.trim() + "']";
                    setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(WarehouseName))));
                    clickElement(getDriver().findElement(By.xpath(WarehouseName)));
                }
                Thread.sleep(DELAY_IN_MILLI_SECS);
                Hooks.captureT(scenario);
                warehouse.click();
                List<String> featureWarehouses = Arrays.stream(warehouseFiled.split(","))
                        .map(String::trim).collect(Collectors.toList());

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
                    Dictionary.storeInGlobalDictionary("OpeningStock", openingStock.getAttribute("value"));
                    double openingStockValue = Double.parseDouble(getAttribute(openingStock, "value"));
                    System.out.println("openingStockValue : " + openingStockValue);
                    avialbeQuantity += openingStockValue;

                    Thread.sleep(DELAY_IN_MILLI_SECS);

                    WebElement warehouse_Wholesale_Price = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Wholesale Price here']"));
                    populateField(warehouse_Wholesale_Price, "50");
                    double warehouseWholesalePriceValue = Double.parseDouble(getAttribute(warehouse_Wholesale_Price, "value"));
                    System.out.println("warehouseWholesalePriceValue : " + warehouseWholesalePriceValue);

                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    WebElement warehouse_Selling_Price = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Retail Price here...']"));
                    populateField(warehouse_Selling_Price, "70");
                    double warehouseSellingPriceValue = Double.parseDouble(getAttribute(warehouse_Selling_Price, "value"));
                    System.out.println("warehouseSellingPriceValue : " + warehouseSellingPriceValue);

                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    WebElement min_Quantity = container.get(i).findElement(By.xpath(".//input[@placeholder='Write the Minimum Quantity here to get notified']"));
                    populateField(min_Quantity, "10");
                    warehousePriceMap.put(
                            warehouseName.trim().toLowerCase(),
                            new WarehouseDate(openingStockValue, warehouseWholesalePriceValue, warehouseSellingPriceValue));
                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    Hooks.captureT(scenario);
                }

                if (avialbeQuantity > 0) {
                    double avgPurchasePrice = avialbeQuantity * Double.parseDouble(Dictionary.getFromGlobalDictionary("purchasePriceActual")) / avialbeQuantity;
                    Dictionary.storeInGlobalDictionary("AveragePurchasePrice", String.valueOf(Math.round(avgPurchasePrice)));
                }

            }
        }
        Dictionary.storeInGlobalDictionary("avialableQuantity", String.valueOf(avialbeQuantity));
        Dictionary.storeInGlobalDictionary("WAREHOUSE_PRICE_MAP", warehousePriceMap);


    }

    public void WarehouseInformation(String warehouseFiled) throws Exception {
        List<WebElement> elements1 = getDriver().findElements(By.xpath("//p[contains(text(),'Warehouse Information')]"));
        if (elements1.size() > 0) {
            populateField(selling_Price_Warehouse, "50");
        } else {
            if (warehouse.isEnabled()) {
                setWait(wait).until(ExpectedConditions.visibilityOf(warehouse));
                clickElement(warehouse);

                String[] warehouseList = warehouseFiled.split(",");
                for (String warehouse : warehouseList) {
                    String WarehouseName = "//span[text()='" + warehouse.trim() + "']";
                    setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(WarehouseName))));
                    clickElement(getDriver().findElement(By.xpath(WarehouseName)));
                }
//                Thread.sleep(DELAY_IN_MILLI_SECS);
//                Hooks.captureT(scenario);
//                warehouse.click();

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


                    Thread.sleep(DELAY_IN_MILLI_SECS);

//                    WebElement warehouse_Wholesale_Price = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Wholesale Price here']"));
//                    populateField(warehouse_Wholesale_Price, "50");

                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    WebElement warehouse_Selling_Price = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Retail Price here...']"));
                    populateField(warehouse_Selling_Price, "70");


                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    WebElement min_Quantity = container.get(i).findElement(By.xpath(".//input[@placeholder='Write the Minimum Quantity here to get notified']"));
                    populateField(min_Quantity, "10");

                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    Hooks.captureT(scenario);
                }
            }
        }
    }

    public void validateErrorMessage(String errorMessage) {
        String message = getDriver().findElement(By.xpath("//div[text()='" + errorMessage + "']")).getText();
        Assert.assertEquals(errorMessage, message);
    }

    public void enterSellingPriceLessThanPurchasePrice(String warehouseFiled) throws Exception {
        List<WebElement> elements1 = getDriver().findElements(By.xpath("//p[contains(text(),'Warehouse Information')]"));
        if (elements1.size() > 0) {
            populateField(selling_Price_Warehouse, "50");
        } else {
            if (warehouse.isEnabled()) {
                setWait(wait).until(ExpectedConditions.visibilityOf(warehouse));
                clickElement(warehouse);

                String[] warehouseList = warehouseFiled.split(",");
                for (String warehouse : warehouseList) {
                    String WarehouseName = "//span[text()='" + warehouse.trim() + "']";
                    setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(WarehouseName))));
                    clickElement(getDriver().findElement(By.xpath(WarehouseName)));
                }

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

                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    WebElement warehouse_Selling_Price = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Retail Price here...']"));
                    populateField(warehouse_Selling_Price, "70");

                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    WebElement min_Quantity = container.get(i).findElement(By.xpath(".//input[@placeholder='Write the Minimum Quantity here to get notified']"));
                    populateField(min_Quantity, "10");

                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    Hooks.captureT(scenario);
                }
            }
        }
    }

    public void enterWholesalePriceLessThanPurchasePrice(String warehouseFiled) throws Exception {
        List<WebElement> elements1 = getDriver().findElements(By.xpath("//p[contains(text(),'Warehouse Information')]"));
        if (elements1.size() > 0) {
            populateField(warehouse_Wholesale_Price, "50");
        } else {
            if (warehouse.isEnabled()) {
                setWait(wait).until(ExpectedConditions.visibilityOf(warehouse));
                clickElement(warehouse);

                String[] warehouseList = warehouseFiled.split(",");
                for (String warehouse : warehouseList) {
                    String WarehouseName = "//span[text()='" + warehouse.trim() + "']";
                    setWait(wait).until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath(WarehouseName))));
                    clickElement(getDriver().findElement(By.xpath(WarehouseName)));
                }
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


                    Thread.sleep(DELAY_IN_MILLI_SECS);

                    WebElement warehouse_Wholesale_Price = container.get(i).findElement(By.xpath(".//input[@placeholder='Enter Wholesale Price here']"));
                    populateField(warehouse_Wholesale_Price, "50");


                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    WebElement min_Quantity = container.get(i).findElement(By.xpath(".//input[@placeholder='Write the Minimum Quantity here to get notified']"));
                    populateField(min_Quantity, "10");

                    Thread.sleep(DELAY_IN_MILLI_SECS);
                    Hooks.captureT(scenario);
                }
            }
        }
    }

    public void clickTransactionTab() {
        setWait(wait).until(ExpectedConditions.visibilityOf(transaction_Tab));
        clickElement(transaction_Tab);

    }

    public void validateTransactionList() {
if (empty_Message_Table.size() > 0) {
    System.out.println("Table is EMPTY (No Transactions)");
}else{
    for (WebElement transaction : transaction_Table) {
        String transactionText = transaction.getText().trim();
        Assert.assertTrue(transactionText.contains("Purchase") || transactionText.contains("Sale"), "Transaction type is incorrect: " + transactionText);
    }
}
    }


}

//write a selenium login test

