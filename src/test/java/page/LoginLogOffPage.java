package page;


import qa.data.utils.AppSpecificUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.data.utils.log4jBaseClass;
import java.util.*;


public class LoginLogOffPage extends AppSpecificUtility {

	private static final String SWITCHBUTTON = ".switchButton";
	private static final String SERVERUNAVAIBLETEXT="//div[contains(text(),'Vantage is unavailable')]";


	@FindBy(xpath = SERVERUNAVAIBLETEXT)
	private WebElement unavailableText;

	@FindBy(css = SWITCHBUTTON)
	private List<WebElement> switchButton;



	public LoginLogOffPage() {
	}

	public LoginLogOffPage(WebDriver driver) {
		try {
			initElems(driver);
			log4jBaseClass.debug("Driver initialized for Login Page");

		} catch (Exception ex) {
			log4jBaseClass.error("Error while initialising Web Driver for Login Page");
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


}




