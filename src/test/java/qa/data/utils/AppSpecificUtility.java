package qa.data.utils;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class AppSpecificUtility extends ValidationHelper {


    public AppSpecificUtility() {
        super(getDriver());
    }

    public static String getLocalDate() {
        LocalDate currentDate  = LocalDate.now();
        LocalDate date = currentDate.plusDays(1);
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = date.format(formatter);
        return formattedDate;
    }

    public String getDayMonthYear(String fmt, String text)
    {

        // Get an instance of LocalTime
        // from date
        Date date = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat (fmt);
        String Date= ft.format(date);
        LocalDate currentDate
                = LocalDate.parse(Date);
        int day;

if(text.equalsIgnoreCase("monitors")) {
    // Get day from date
     day = currentDate.getDayOfMonth();
}
else {
    day = currentDate.getDayOfMonth();
}

        DecimalFormat formatter = new DecimalFormat("00");
        String aFormatted = formatter.format(day);
        // Get month from date
        Month month = currentDate.getMonth();
        String currentMonth = month.toString();
        String cMonth = currentMonth.substring(0,3).toLowerCase();


        // Get year from date
        int year = currentDate.getYear();


        String returnDate = aFormatted+" "+cMonth+" "+year;

        return returnDate;
    }

    public String getDate(String fmt)
    {
        Date date = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat (fmt);
        String currentDate= ft.format(date);
        return currentDate;
        //2023.09.05 11:29:09 PM
    }


    public String getRandomGenerator() {
        Random random = new Random();
        int x = random.nextInt(9999);
        return String.valueOf(x);
    }
    public int getRandomIndex(int num) {
        Random random = new Random();
        return random.nextInt(num);
    }

    public String getRandomString(int noOfChars) {
        Random r = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < noOfChars; i++) {
            char c = alphabet.charAt(r.nextInt(alphabet.length()));
            sb.append(c);
        }
        return sb.toString();
    }
    public String getFormattedDateTime(String fmt){
        LocalDateTime curretDateTime=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern(fmt);
        String formattedDateTime=curretDateTime.format(formatter);

        return formattedDateTime;
    }

    public void createPDFWithData(String filePath, String Data) throws IOException {
        String defaultPath = "resources";
        filePath = defaultPath + File.separator + filePath;

        PDDocument doc = new PDDocument();
        try {
            PDPage page = new PDPage();
            doc.addPage(page);

            PDPageContentStream contents = new PDPageContentStream(doc, page);
            contents.beginText();
            contents.setFont(PDType1Font.HELVETICA_BOLD, 30);
            contents.newLineAtOffset(50, 700);
            contents.showText(Data);
            contents.endText();
            contents.close();

            doc.save(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            doc.close();
        }
    }

    //This function gets the date by subtracting from current date
    public String getPreferedDate(int daysToMinus, String fmt) {
        LocalDate yesterday = LocalDate.now().minusDays(daysToMinus);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fmt);
        return yesterday.format(formatter);
    }
    public String getPreferedMonth(int daysToMinus, String fmt) {
        LocalDate month = LocalDate.now().minusMonths(daysToMinus);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fmt);
        return month.format(formatter);
    }
    public String getPreferedYear(int daysToMinus, String fmt) {
        LocalDate year = LocalDate.now().minusYears(daysToMinus);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fmt);
        return year.format(formatter);
    }
    public String getSystemDate(String fmt) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(fmt);
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }
    public void checkDatesInRange(int days, List<WebElement> elements) {
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate=LocalDate.now().minusDays(days);
        Report.info(endDate + " End Date ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        for (WebElement element : elements) {
             //hoverOnElement(element);
            String dateText = element.getText();
            LocalDate date = LocalDate.parse(dateText, formatter);
            try{
                if (date.isAfter(endDate) && date.isBefore(currentDate) || date.equals(endDate) || date.equals(currentDate)) {
                    Report.pass(date + " Document Date is within the range.");
                }
            }catch (Exception e){
                Assert.fail("'" + date  + "' Document Date is out of the range.");

            }

        }

    }

}
