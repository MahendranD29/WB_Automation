package qa.data.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

import static qa.data.utils.TestBaseClass.getDriver;
import static qa.data.utils.WebPageOperations.*;

public class Dictionary {
    private static Map<String, String> dictionary = new HashMap<String, String>();
    private static Map<String, String> globalDictionary = new HashMap<String, String>();

    public static void storeInDictionary(String key,String value)
    {
        dictionary.put(key,value);
    }
    public static void storeInGlobalDictionary(String key,String value)
    {
        globalDictionary.put(key,value);
    }
    public static String getFromDictionary(String key)
    {
        return dictionary.get(key);
    }
    public static String getFromGlobalDictionary(String key)
    {
        return globalDictionary.get(key);
    }

    public static void saveGridPartyUserName(String gridID)
    {
        //stores the gridid title to a disctionary
        String gridIDTitle;
        WebElement gridIDTitle_Text = getDriver().findElement(By.xpath("//div[@title='"+gridID+"']/following-sibling::div[1]"));
        gridIDTitle = getAttribute(gridIDTitle_Text,"title");
        storeInDictionary("gridIDTitle",gridIDTitle);
    }

    public static void clearDictionary()
    {
        dictionary.clear();
    }

}
