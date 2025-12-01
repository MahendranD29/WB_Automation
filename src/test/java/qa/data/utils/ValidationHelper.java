package qa.data.utils;

import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
import org.junit.Assert;
import page.LoginLogOffPage;

import java.util.List;
import java.util.stream.Collectors;

public class ValidationHelper extends WebPageOperations {

    public WebDriver driver;

    @Steps
    LoginLogOffPage loginLogOffPage;


    public ValidationHelper(WebDriver driver) {
        this.driver = getDriver();
    }



    public void verifyIsElementDisplayed(WebElement element) {
        try {
            Thread.sleep(DELAY_IN_MILLI_SECS);
            setWait(wait).until(ExpectedConditions.visibilityOf(element));
            boolean objVisibleValue = isDisplayed(element);
            Assert.assertTrue("'" + element+ "'is visible" , objVisibleValue);
            Report.pass("'" + element.getText() + "' is Present");

        } catch (Error | InterruptedException e) {
            Assert.fail("'" + element.getText()  + "' is not Present");
        }
    }

    public void verifyIsElementNotDisplayed(WebElement element) {
        try {
            // setWait(wait).until(ExpectedConditions.visibilityOf(element));
            boolean objVisibleValue = isDisplayed(element);
            Assert.assertFalse("'" + element+ "'is not visible" , objVisibleValue);
            Report.pass("'" + element + "' is not Present");

        } catch (Error e) {
            Assert.fail("'" + element  + "' is Present");
        }
    }

    public void verifyAllElementLinksDisplayed(List<String> actualElementsAndLinks,List<String> expectedElementAndLink) {
        try {
            Assert.assertEquals(actualElementsAndLinks, expectedElementAndLink);
            Report.pass("'" + actualElementsAndLinks + "' is same as "+expectedElementAndLink);
            Report.pass("'" + actualElementsAndLinks.size() + "' is same as "+expectedElementAndLink.size());

        } catch (Error e) {

            List<String> listOfMissingItemsFromActualList = expectedElementAndLink.stream()
                    .filter(item -> !actualElementsAndLinks.contains(item)).collect(Collectors.toList());
            Report.fail("List Of missing Items on Actual List : "+listOfMissingItemsFromActualList);
            List<String> listOfMissingItemsFromExpectedList = actualElementsAndLinks.stream()
                    .filter(item -> !expectedElementAndLink.contains(item)).collect(Collectors.toList());

            Report.fail("List Of missing Items on Expected List : "+listOfMissingItemsFromExpectedList);
            Assert.assertEquals("List Elements Mismatch",expectedElementAndLink,actualElementsAndLinks);
            Assert.fail("'" + actualElementsAndLinks + "' is not same as "+expectedElementAndLink);

        }
    }

    public void verifyAllElementTitleDisplayed(List<String> actualElementsTitleList,List<String> expectedElementTitles) {
        try {
            Assert.assertEquals(actualElementsTitleList, expectedElementTitles);
            Report.pass("'" + actualElementsTitleList + "' is same as "+expectedElementTitles);
            Report.pass("'" + actualElementsTitleList.size() + "' is same as "+expectedElementTitles.size());

        } catch (Error e) {

            List<String> listOfMissingItemsFromActualList = expectedElementTitles.stream()
                    .filter(item -> !actualElementsTitleList.contains(item)).collect(Collectors.toList());
            Report.fail("List Of missing Items on Actual List : "+listOfMissingItemsFromActualList);
            List<String> listOfMissingItemsFromExpectedList = actualElementsTitleList.stream()
                    .filter(item -> !expectedElementTitles.contains(item)).collect(Collectors.toList());
            Report.fail("List Of missing Items on Expected List : "+listOfMissingItemsFromExpectedList);
            Assert.assertEquals("List Elements Mismatch",expectedElementTitles,actualElementsTitleList);
            Assert.fail("'" + actualElementsTitleList + "' is not same as "+expectedElementTitles);

        }
    }

    public void verifyAllElementTitlesDisplayed(List<String> actualElementsAndLinks,List<String> expectedElementAndLink) {
        try {
            Assert.assertEquals(actualElementsAndLinks, expectedElementAndLink);
            Report.pass("'" + actualElementsAndLinks + "' is same as "+expectedElementAndLink);
            Report.pass("'" + actualElementsAndLinks.size() + "' is same as "+expectedElementAndLink.size());

        } catch (Error e) {

            List<String> listOfMissingItemsFromActualList = expectedElementAndLink.stream()
                    .filter(item -> !actualElementsAndLinks.contains(item)).collect(Collectors.toList());
            Report.fail("List Of missing Items on Actual List : "+listOfMissingItemsFromActualList);
            List<String> listOfMissingItemsFromExpectedList = actualElementsAndLinks.stream()
                    .filter(item -> !expectedElementAndLink.contains(item)).collect(Collectors.toList());

            Report.fail("List Of missing Items on Expected List : "+listOfMissingItemsFromExpectedList);
            // Assert.fail("actualElements :" + actualElementsAndLinks.size() + "' differs from expected Elements : "+expectedElementAndLink.size());
            //Assert.assertEquals("size of the actual and expected array list",actualElementsAndLinks.size(),expectedElementAndLink.size());
            Assert.assertEquals("List Elements Mismatch",expectedElementAndLink,actualElementsAndLinks);
            Assert.fail("'" + actualElementsAndLinks + "' is not same as "+expectedElementAndLink);

        }
    }



    public void verifyElementTextOrTitleOrUrlOrAttributeValue(String expectedTxtOrTitleOrURl, String actualTxtOrTitleOrURL) throws Exception
    {
        try {
            Assert.assertEquals(expectedTxtOrTitleOrURl, actualTxtOrTitleOrURL);
            Report.pass("The text/title/URL '"+expectedTxtOrTitleOrURl+"' is verified");
        }
        catch (Error e)
        {

            Assert.fail("'"+actualTxtOrTitleOrURL+"'Actual text/title/URL is not as expected text/title/URL :"+ expectedTxtOrTitleOrURl);

        }
    }


    public void verifySearchResultsDisplayed(List<WebElement> elements) {
        try {
            waitForJQueryToBeActive();
            Thread.sleep(15000);
            Thread.sleep(DELAY_IN_MILLI_SECS);
            boolean searchResultValue = !elements.isEmpty();
            Assert.assertTrue("Search Result size: " + elements.size() + "records found " , searchResultValue);
            Report.pass("Search Result size: "+ elements.size() + "records found ");

        } catch (Error e) {
            Assert.fail("Search Result size: "+ elements.size() + "records found ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //comment

    public void verifyDefaultTabIsDisplayed(WebElement defaultTab,String expectedAttributeText, String attributeType) {
        try {
            setWait(wait).until(ExpectedConditions.visibilityOf(defaultTab));
            verifyElementTextOrTitleOrUrlOrAttributeValue(expectedAttributeText, defaultTab.getAttribute(attributeType));
            Report.info("The default Tab displays  :" + defaultTab.getAttribute(attributeType));

        } catch (Error | Exception e) {
            Report.info("The default Tab does not display and is not default tab :" + defaultTab.getAttribute(attributeType));
        }
    }

    public void verifyElementedSelected(String element) {
        try {
            setWait(wait).until(ExpectedConditions.visibilityOf( getDriver().findElement(By.xpath(element))));
            getDriver().findElement(By.xpath(element)).isSelected();
            Report.info("The element is selected");

        } catch (Error | Exception e) {
            Report.info("The element is not selected");
        }
    }




    public void verifySearchResultsExactMatchDisplayed(List<WebElement> elements){
        try {
            waitForJQueryToBeActive();
            boolean searchResultMatchValue = elements.size() == 1;
            Assert.assertTrue("Search Result ExactMatch size: " + elements.size() + "record found ", searchResultMatchValue);
            Report.pass("Search Result ExactMatch size: " + elements.size() + "record found ");
        }catch (Error e) {

            Assert.fail("Search Result ExactMatch size: " + elements.size() + "record found ");
        }

    }
    public void verifyElementsAreDisplayed(List<WebElement>elements) throws InterruptedException {
        try {
            boolean objVisibleGridIds = verifyAllElementsDisplayed(elements);
            Assert.assertTrue("Tree of Grid id's are present and size: : " + elements.size() + "records found ", objVisibleGridIds);
            Report.pass("Hierarchy Tree of Grid id's are present and size: " + elements.size() + "records found ");
        }catch(Error e){
            Assert.fail("Hierarchy Tree of Grid id's are not present and size:"+elements.size()+ "records found");
        }

    }
    public void verifyElementIsDisabled(WebElement element) {
        try {
            // setWait(wait).until(ExpectedConditions.visibilityOf(element));
            boolean objVisibleValue = isEnabled(element);
            Assert.assertFalse("'" + element+ "'is Disabled" , objVisibleValue);
            Report.pass("'" + element+ "' is Disabled");

        } catch (Error e) {
            Assert.fail("'" + element+ "' is Enabled");
        }
    }
    public void verifyElementNotDisplayed(WebElement element) {
        try {
            boolean objVisibleValue = isDisplayed(element);
            System.out.println("Assert:"+objVisibleValue);
            Assert.assertFalse("'" + element+ "'is not visible" , objVisibleValue);
            Report.pass("'" + element + "' is not Present");

        } catch (Error e) {
            Assert.fail("'" + element + "' is Present");
        }
    }
    public void verifyElementIsReadOnly(WebElement element) {
        try {
            // setWait(wait).until(ExpectedConditions.visibilityOf(element));
            boolean objVisibleValue = isEnabled(element);
            Assert.assertTrue("'" + element+ "'is read-only" , objVisibleValue);
            Report.pass("'" + element.getText()+ "' is read-only");

        } catch (Error e) {
            Assert.fail("'" + element.getText()+ "' not read-only");
        }
    }



}



