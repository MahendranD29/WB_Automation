package qa.data.utils;

import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

import static qa.data.utils.ExportFileAndValidate.*;
import static qa.data.utils.TestBaseClass.folder;
import static qa.data.utils.TestBaseClass.getDriver;
import static qa.data.utils.WebPageOperations.*;
import static qa.data.utils.Dictionary.getFromDictionary;
import static qa.data.utils.Dictionary.*;

public class DownloadFile {
    static List<String> pdfList;


    @SuppressWarnings("unchecked")
    public static ArrayList<Object> get_downloaded_files(RemoteWebDriver remoteDriver) {
        ArrayList<Object> filesFound = new ArrayList<Object>();
        try {
            if (!remoteDriver.getCurrentUrl().startsWith("chrome://downloads")) {
                remoteDriver.get("chrome://downloads/");
                Thread.sleep(DELAY_IN_MILLI_SECS * 12L);
            }
            filesFound = (ArrayList<Object>) remoteDriver.executeScript(
                    "return  document.querySelector('downloads-manager')  " +
                            " .shadowRoot.querySelector('#downloadsList')         " +
                            //" .items.filter(e => e.state === 'COMPLETE')          "+
                            "  .items.filter(e => e.state == '2')            " +
                            " .map(e => e.filePath || e.file_path || e.fileUrl || e.file_url); ", "");
            //filesFound.add(remoteDriver.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector(\"#downloadsList > downloads-item\").shadowRoot.querySelector(\"#content > #details > #title-area > a\").text"));
        } catch (Exception e) {
            System.out.println("no file found");
            System.err.println(e);

        }

        return filesFound;

    }

    public static ArrayList<Object> get_downloaded_files_via_newTab(RemoteWebDriver remoteDriver) {
        //This function navigates the Chrome downloads to new tab and returns the downloaded files.
        ArrayList<Object> filesFound = new ArrayList<>();
        try {
            if (!getDriver().getCurrentUrl().startsWith("chrome://downloads")) {
                ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
                boolean downloadsTabsExists = false;
                for (int i = 0; i < tabs.size(); i++) {
                    getDriver().switchTo().window(tabs.get(i));
                    if (getDriver().getTitle().contains("Download")) {
                        downloadsTabsExists = true;
                        break;
                    }
                }
                if (!downloadsTabsExists) {
                    getDriver().switchTo().newWindow(WindowType.TAB);
                    getDriver().get("chrome://downloads/");
                    Thread.sleep(DELAY_IN_MILLI_SECS * 12L);
                }
            }
            filesFound = (ArrayList<Object>) remoteDriver.executeScript(
                    "return  document.querySelector('downloads-manager')  " +
                            " .shadowRoot.querySelector('#downloadsList')         " +
//                            " .items.filter(e => e.state === 'COMPLETE')          "+
                            "  .items.filter(e => e.state == '2')            " +
                            " .map(e => e.filePath || e.file_path || e.fileUrl || e.file_url); ", "");
            //filesFound.add(remoteDriver.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector(\"#downloadsList > downloads-item\").shadowRoot.querySelector(\"#content > #details > #title-area > a\").text"));
        } catch (Exception e) {
            System.out.println("no file found");
            System.err.println(e);

        }

        return filesFound;

    }

    public static String test_download_file(WebDriver driver, String expectedFileName, String targetPath, String fileType) throws Exception {
        FileOutputStream fos = null;
        File download_url = null;

        switch (fileType) {
            case "pdf":
                Report.info("Expected File Name: " + expectedFileName);
                download_url = new File(expectedFileName + ".pdf");
                break;

            case "xlsx":
                Report.info("Expected File Name: " + expectedFileName);
                download_url = new File(expectedFileName + ".xlsx");
                break;
            case "xls":
                Report.info("Expected File Name: " + expectedFileName);
                download_url = new File(expectedFileName + ".xls");
                break;
            case "xlxs":
                Report.info("Expected File Name: " + expectedFileName);
                download_url = new File(expectedFileName + ".xlxs");
                break;

        }
        int count = 1;
        ArrayList<Object> files;
        do {

            if (expectedFileName.contains("Documents(10000)")) {
                files = get_downloaded_files_via_newTab((RemoteWebDriver) driver);
            } else {

                files = get_downloaded_files((RemoteWebDriver) driver);
            }
            //Report.info("Files: "+files.toString());
            if (files.toString().contains(expectedFileName)) { //Note: multiple file downloads on the same Vantage node of the same file name will increment the file name like 50MB(2).zip
                Report.info("FILE DOWNLOADED TO Vantage NODE");
                break;
            } else {
                Report.info("DOWNLOAD IN-PROGRESS");
                for (Object file : files) {
                    Report.info("File Names: " + file.toString());
                }
            }
            count++;
            Thread.sleep(10000);
        } while (count < 11);

        ArrayList<Object> downloaded_files_arraylist = get_downloaded_files((RemoteWebDriver) driver);
        System.out.println("Downloaded files in Array List: " + downloaded_files_arraylist.get(0));
        String content = get_file_content((RemoteWebDriver) driver, (String) downloaded_files_arraylist.get(0));// large files might need and increase in implicit setWait(wait).
        try {
            String home = System.getProperties().get("user.dir").toString();
            Report.info("******Home: " + home);

            String outPutFile = targetPath + File.separator + download_url.getName();
            storeInDictionary("outPutFilePath", outPutFile);
            Report.info("OutPut File: " + outPutFile);
            fos = new FileOutputStream(outPutFile);
            byte[] decoder = Base64.decodeBase64(content.substring(content.indexOf("base64,") + 7));
            fos.write(decoder);

            Report.info("File saved to local.");
            Report.info("OutPut File: " + outPutFile);
            if (outPutFile.contains("pdf")) {
                return readingPdf(outPutFile, "allPages");
            } else if (outPutFile.contains("Vantage_ExternalReconciliationMonitor")) {
                Report.info("File found");
            }

            if (expectedFileName.equalsIgnoreCase("organisationUploadTemplate")) {
                if (outPutFile.contains("xls")) {
                    System.out.println("Downloaded and verified OrganisationTemplate file");
                }
            }
            if (expectedFileName.equalsIgnoreCase("Vantage_ViewChanges")) {
                if (outPutFile.contains("xlsx")) {
                    readingexcel(outPutFile);
                }
            }
            if (expectedFileName.equalsIgnoreCase("User Export")) {
                if (outPutFile.contains("xls")) {
                    readingexcelCount(outPutFile);
                }
            } else if (expectedFileName.equalsIgnoreCase("organisationUploadTemplate") || expectedFileName.equalsIgnoreCase("staticDataUploadTemplate") || expectedFileName.equalsIgnoreCase("mlUploadTemplate") || expectedFileName.equalsIgnoreCase("ratingUploadTemplate") || expectedFileName.equalsIgnoreCase("resendUploadTemplate") || expectedFileName.equalsIgnoreCase("reconDecisionUploadTemplate")) {

                readingxlsfile(outPutFile);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            fos.close();
        }
        return "";
    }


    public static String get_file_content(RemoteWebDriver remoteDriver, String path) {
        String file_content = null;
        try {
            if (!remoteDriver.getCurrentUrl().startsWith("chrome://downloads")) {
                remoteDriver.get("chrome://downloads/");
            }

            WebElement elem = (WebElement) remoteDriver.executeScript(
                    "var input = window.document.createElement('INPUT'); " + "input.setAttribute('type', 'file'); "
                            + "input.hidden = true; " + "input.onchange = function (e) { e.stopPropagation() }; "
                            + "return window.document.documentElement.appendChild(input); ",
                    "");

            elem.sendKeys(path);

            file_content = (String) remoteDriver.executeAsyncScript(
                    "var input = arguments[0], callback = arguments[1]; " + "var reader = new FileReader(); "
                            + "reader.onload = function (ev) { callback(reader.result) }; "
                            + "reader.onerror = function (ex) { callback(ex.message) }; "
                            + "reader.readAsDataURL(input.files[0]); " + "input.remove(); ",
                    elem);

            if (!file_content.startsWith("data:")) {
                System.out.println("Failed to get file content");
            }

            System.out.println("File Content: " + file_content);

        } catch (Exception e) {
            System.err.println(e);
        }
        return file_content;

    }
    public static String test_download_fileCSV(WebDriver driver, String expectedFileName, String targetPath, String fileType) throws Exception {
        FileOutputStream fos = null;
        File download_url = null;

        switch (fileType) {

            case "csv":
                Report.info("Expected File Name: " + expectedFileName);
                download_url = new File(expectedFileName + ".pdf");
                break;

        }
        int count = 1;
        ArrayList<Object> files;
        do {

            if (expectedFileName.contains("Documents(10000)")) {
                files = get_downloaded_files_via_newTab((RemoteWebDriver) driver);
            } else {

                files = get_downloaded_files((RemoteWebDriver) driver);
            }
            //Report.info("Files: "+files.toString());
            if (files.toString().contains(expectedFileName)) {
                Report.info("FILE DOWNLOADED");
                break;
            } else {
                Report.info("DOWNLOAD IN-PROGRESS");
                for (Object file : files) {
                    Report.info("File Names: " + file.toString());
                }
            }
            count++;
            Thread.sleep(10000);
        } while (count < 11);

        ArrayList<Object> downloaded_files_arraylist = get_downloaded_files((RemoteWebDriver) driver);
        System.out.println("Downloaded files in Array List: " + downloaded_files_arraylist.get(0));
        String content = get_file_content((RemoteWebDriver) driver, (String) downloaded_files_arraylist.get(0));// large files might need and increase in implicit setWait(wait).
        try {
            String home = System.getProperties().get("user.dir").toString();
            Report.info("******Home: " + home);

            String mime = content.substring(content.indexOf("data:") + 5, content.indexOf(";"));
            String ext = mime.contains("csv") ? ".csv" : ".pdf";  // choose extension properly

            String outPutFile = targetPath + File.separator + expectedFileName + ext;
            storeInDictionary("outPutFilePath", outPutFile);
            Report.info("OutPut File: " + outPutFile);
            fos = new FileOutputStream(outPutFile);
            byte[] decoder = Base64.decodeBase64(content.substring(content.indexOf("base64,") + 7));
            fos.write(decoder);

            Report.info("File saved to local.");
            Report.info("OutPut File: " + outPutFile);
            if (outPutFile.contains("csv")) {
                readingCSV(outPutFile);
            } else {
                System.out.println("$$$$");
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            fos.close();
        }
        return "";
    }

    public static String getDownloadedFile(WebElement element, String fileName, boolean fileNameMatch) throws Exception {
        ArrayList<Object> fileSetBeforeDownload = new ArrayList<>();
        ArrayList<Object> fileSetAfterDownload = new ArrayList<>();
        FileOutputStream fos = null;
        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();
        String folderPath = folder.getAbsolutePath();

        System.out.println("Folder Path is :" + folderPath);


        String currentWindow = getDriver().getWindowHandle();
        //gets the number of files present in Downloads before downloading the expected doc
        fileSetBeforeDownload = get_downloaded_files_via_newTab((RemoteWebDriver) getDriver());
        getDriver().switchTo().window(currentWindow);
        Thread.sleep(DELAY_IN_MILLI_SECS * 2L);
        Report.info("File Set Before Download " + fileSetBeforeDownload.size());
        //Expected doc gets downloaded
        clickExpectedDownload(element, fileName);

        Thread.sleep(DELAY_IN_MILLI_SECS * 2L);
        Report.info("No of Files Before Download " + fileSetBeforeDownload.size());
        int trail = 0;
//gets the number of files present in Downloads after downloading the expected doc.
        do {
            fileSetAfterDownload = get_downloaded_files_via_newTab((RemoteWebDriver) getDriver());
            trail++;
            Thread.sleep(DELAY_IN_MILLI_SECS * 3L);
        }
        while (fileSetBeforeDownload.size() == fileSetAfterDownload.size() && trail < 20);

        String filePath = "";
        int trails = 0;

        Report.info("No of Files After Download " + fileSetAfterDownload.size());
        //gets the downloaded doc by removing the previously available docs before expected download.
        fileSetAfterDownload.removeAll(fileSetBeforeDownload);
        Report.info("No of Files After removing the previous files " + fileSetAfterDownload.size());
        String downloadedFile = "";
        String outPutFile = "";

        //Reads the content from downloaded file and puts in the projects randomly generated folder
        if (fileSetAfterDownload.size() == 1) {
            downloadedFile = fileSetAfterDownload.toString();
            downloadedFile = downloadedFile.substring(downloadedFile.indexOf("[") + 1, downloadedFile.length() - 1);
            //fileNameMatch is passed as true, then the file name will be validated
            if (fileNameMatch) {
                String downloadedFileName = downloadedFile.substring(nthIndexOf(downloadedFile, '\\', countChar(downloadedFile, '\\')) + 1);
                Assert.assertEquals(fileName, downloadedFileName);
            }
            String content = get_file_content((RemoteWebDriver) getDriver(), (String) downloadedFile);
            outPutFile = folderPath + File.separator + fileName;
            Report.info("OutPut File: " + outPutFile);
            fos = new FileOutputStream(outPutFile);
            byte[] decoder = Base64.decodeBase64(content.substring(content.indexOf("base64,") + 7));
            fos.write(decoder);
            int documentWaitTrail = 0;
            while (!new File(outPutFile).exists() && documentWaitTrail < 7) {
                Thread.sleep(DELAY_IN_MILLI_SECS * 4L);
                documentWaitTrail++;
            }
        } else {
            throw new Exception("expected " + fileName + " download not available in path " + folderPath);
        }
        getDriver().switchTo().window(currentWindow);
        switchFrame("portalContentPane_0");
        return outPutFile;
    }

    public static boolean retryDowload = true;

    public static String getDownloadedFile(WebElement element, String frame, String fileName, boolean fileNameMatch) throws Exception {
        ArrayList<Object> fileSetBeforeDownload = new ArrayList<>();
        ArrayList<Object> fileSetAfterDownload = new ArrayList<>();
        FileOutputStream fos = null;
        String folderPath = folder.getAbsolutePath();

        System.out.println("Folder Path is :" + folderPath);


        String currentWindow = getDriver().getWindowHandle();
        //gets the number of files present in Downloads before downloading the expected doc
        fileSetBeforeDownload = get_downloaded_files_via_newTab((RemoteWebDriver) getDriver());
        getDriver().switchTo().window(currentWindow);
        Thread.sleep(DELAY_IN_MILLI_SECS * 2L);
        Report.info("File Set Before Download " + fileSetBeforeDownload.size());
        //Expected doc gets downloaded
        clickExpectedDownload(element, frame, fileName);

        Thread.sleep(DELAY_IN_MILLI_SECS * 2L);
        Report.info("No of Files Before Download " + fileSetBeforeDownload.size());
        int trail = 0;
//gets the number of files present in Downloads after downloading the expected doc.
        do {
            fileSetAfterDownload = get_downloaded_files_via_newTab((RemoteWebDriver) getDriver());
            trail++;
            Thread.sleep(DELAY_IN_MILLI_SECS * 3L);
        }
        while (fileSetBeforeDownload.size() == fileSetAfterDownload.size() && trail < 20);

        String filePath = "";
        int trails = 0;

        Report.info("No of Files After Download " + fileSetAfterDownload.size());
        //gets the downloaded doc by removing the previously available docs before expected download.
        fileSetAfterDownload.removeAll(fileSetBeforeDownload);
        Report.info("No of Files After removing the previous files " + fileSetAfterDownload.size());
        String downloadedFile = "";
        String outPutFile = "";

        //Reads the content from downloaded file and puts in the projects randomly generated folder
        if (fileSetAfterDownload.size() == 1) {
            downloadedFile = fileSetAfterDownload.toString();
            downloadedFile = downloadedFile.substring(downloadedFile.indexOf("[") + 1, downloadedFile.length() - 1);
            //fileNameMatch is passed as true, then the file name will be validated
            if (fileNameMatch) {
                String downloadedFileName = downloadedFile.substring(nthIndexOf(downloadedFile, '\\', countChar(downloadedFile, '\\')) + 1);
                downloadedFileName = downloadedFileName.substring(0, downloadedFileName.indexOf("."));
                Report.info("Expected Downloaded File name: " + fileName + " Actual File Name: " + downloadedFileName);

                Assert.assertTrue(downloadedFileName.contains(fileName));

            }
            String content = get_file_content((RemoteWebDriver) getDriver(), (String) downloadedFile);
            outPutFile = folderPath + File.separator + fileName;
            Report.info("OutPut File: " + outPutFile);
            fos = new FileOutputStream(outPutFile);
            byte[] decoder = Base64.decodeBase64(content.substring(content.indexOf("base64,") + 7));
            fos.write(decoder);
            int documentWaitTrail = 0;
            while (!new File(outPutFile).exists() && documentWaitTrail < 7) {
                Thread.sleep(DELAY_IN_MILLI_SECS * 4L);
                documentWaitTrail++;
            }
        } else if (retryDowload) {
            retryDowload = false;
            switchToPreviousTab();
            getDownloadedFile(element, frame, fileName, fileNameMatch);
        } else {
            switchToPreviousTab();
            throw new Exception("expected " + fileName + " download not available in path " + folderPath);
        }
        getDriver().switchTo().window(currentWindow);
        //switchFrame(frame);
        return outPutFile;
    }

    private static void clickExpectedDownload(WebElement element, String filename) throws InterruptedException {

        if (filename.equalsIgnoreCase("combinedDoc.pdf")) {
            switchToDefaultContent();
            Report.info("Switched to Default Content Successfully");
            switchFrame("LIBRARY");
            Report.info("Entered into Main Frame Successfully");
            try {
                clickUsingJavaScript(element);
            } catch (StaleElementReferenceException S) {
                clickUsingJavaScript(getDriver().findElement(By.xpath("(//div[@id='uniqName_8_4']//a[contains(text(),'FATCA Pack_name_')])[1]"))); //Click on the element found by specified xpath using Javascript
            }
        } else {
            Thread.sleep(DELAY_IN_MILLI_SECS * 2L);
            switchToDefaultContent();
            switchFrame("LIBRARY");
            Thread.sleep(DELAY_IN_MILLI_SECS * 2L);
            boolean staleElement = false;
            int trail = 0;
            do {
                try {
                    clickOperation(element);
                    staleElement = false;
                } catch (StaleElementReferenceException S) {
                    staleElement = true;
                    Thread.sleep(DELAY_IN_MILLI_SECS * 3L);
                }
            } while (staleElement && trail++ < 5);
            if (trail == 5) {
                Report.info("max trails exceeded to click on download file");
            }
        }
        Report.info("clickExpectedDownload() ended here");
    }

    private static void clickExpectedDownload(WebElement element, String frame, String filename) throws InterruptedException {
        if (filename.equalsIgnoreCase("combinedDoc.pdf")) {
            switchFrame(frame);
            try {
                Thread.sleep(DELAY_IN_MILLI_SECS);
                clickOperation(element);
            } catch (StaleElementReferenceException S) {
                clickUsingJavaScript(getDriver().findElement(By.xpath("//a[@title='" + getFromDictionary("recentPublishedDocTitle") + "']")));
            }
        } else if (filename.contains("WP1M2_Sl_NO_01")) {

            try {

                Thread.sleep(DELAY_IN_MILLI_SECS * 3);
                clickUsingJavaScript(element);
                Thread.sleep(DELAY_IN_MILLI_SECS * 3);

            } catch (StaleElementReferenceException S) {
                clickUsingJavaScript(getDriver().findElement(By.xpath("//a[@title='" + getFromDictionary("recentPublishedDocTitle") + "']")));
            }

        } else if (filename.contains("WP1M2_Sl_NO_02")) {
            switchFrame(frame);
            try {

                Thread.sleep(DELAY_IN_MILLI_SECS * 3);
                clickUsingJavaScript(element);
                Thread.sleep(DELAY_IN_MILLI_SECS * 3);
            } catch (StaleElementReferenceException S) {
                clickUsingJavaScript(getDriver().findElement(By.xpath("//a[@title='" + getFromDictionary("recentPublishedDocTitle") + "']")));
            }


        } else {
            Thread.sleep(DELAY_IN_MILLI_SECS * 2L);
            switchFrame(frame);
            Thread.sleep(DELAY_IN_MILLI_SECS * 2L);
            boolean staleElement = false;
            int trail = 0;
            do {
                try {
                    clickOperation(element);
                    staleElement = false;
                } catch (StaleElementReferenceException S) {
                    staleElement = true;
                    Thread.sleep(DELAY_IN_MILLI_SECS * 3L);
                }
            } while (staleElement && trail++ < 5);
            if (trail == 5) {
                Report.info("max trails exceeded to click on download file");
            }
        }
    }
}
