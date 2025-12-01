package qa.data.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static qa.data.utils.TestBaseClass.getDriver;

//import static qa.gpp.TestBase.TestBaseClass.driver

/**
 * This class contains functions to read details from CSV
 */
public class WriteToCSV {

    private final char DEFAULT_SEPARATOR = ',';
    private final char DEFAULT_QUOTE = '"';
    /**
     * Path to test data folder within project which contains the CSV file.
     */
    public String defaultPath = "src/test/java/qa/gpp/testdata/CaseId.csv";
    //public String defaultPath = "src/test/java/qa/gpp/testdata";


    public WriteToCSV( String filePath, List<String[]> dataLines) {

        String FilePath = "";

        FilePath = defaultPath +"/"+filePath;

        try (PrintWriter pw = new PrintWriter(FilePath)) {
            System.out.println("the Path is "+FilePath);

            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
            System.out.println("the value to be added is "+FilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public WriteToCSV( String filePath, List<String[]> dataLines, boolean append) {

        String csvFile = this.defaultPath + "/" + filePath;

        //String checkpath = this.defaultPath +"/"+filePath;

        filePath = defaultPath +"/"+filePath;

        //System.out.println("the file path along with filename to be updated is"+filePath);

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(filePath),append))) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }




    /**
     * In order to use the below class, do the below
     * Create object for the class
     * WriteToCsv objWriter = new WriteToCsv("c:\\users\testing","testdata.csv")
     * List<String[]> dataLines = new ArrayList<>();
     * dataLines.add(new String[]
     *   { "John", "Doe", "38", "Comment Data\nAnother line of comment data" });
     * dataLines.add(new String[]
     *   { "Jane", "Doe, Jr.", "19", "She said \"I'm being quoted\"" });
     *   objWriter.convertToCSV(datalines);
     */

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }
    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
    public static String GetInstructionReceivedDate(int NumberOfDays)
    {

        SimpleDateFormat dateformate = new SimpleDateFormat("dd/MM/yyyy");
        //SimpleDateFormat dateformate = new SimpleDateFormat("MM/dd/yyyy");
        //get current date time with Date()
        Calendar InstrRxDate = Calendar.getInstance();
        //Number of Days to add
        InstrRxDate.add(Calendar.DAY_OF_MONTH,NumberOfDays) ;
        String InstructionRxDate = dateformate.format(InstrRxDate.getTime());
        System.out.println("The date  to be field is" + InstructionRxDate);

        return InstructionRxDate;
    }
    public static String getAmount() {
        Random rand = new Random();
        int AmountValue = rand.nextInt(9000000) + 1000000;
        //System.out.println("The amount value is step 1 :::" + AmountValue);
        return String.valueOf(AmountValue);
    }


     /*
     * To get Iframe Names
     * */

    public static String[] GetiFrameName()
    {
        String[] iframeName;

        final List<WebElement> iframes = getDriver().findElements(By.tagName("frame"));
        iframeName = new String[iframes.size()];
        int counter = 0;
        for (WebElement iframe : iframes) {
            //if (iframe.getAttribute("id").contains("PegaGadget")) {

                iframeName[counter] = iframe.getAttribute("id");

                System.out.println("The Frame name is " + iframeName[counter]);
                 counter++;

            //}
        }
        System.out.println("The Frame Length is " + iframeName.length);
        return iframeName;

    }


}
