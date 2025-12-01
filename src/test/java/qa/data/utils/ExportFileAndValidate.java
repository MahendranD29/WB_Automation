package qa.data.utils;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;


import static qa.data.utils.DownloadFile.*;
import static qa.data.utils.TestBaseClass.folder;
import static qa.data.utils.WebPageOperations.*;

public class ExportFileAndValidate {
    public static int departmentSize;

    public static void fileDownloadAndVerify(WebElement fileDwdIcon, String expectedFileName) throws Exception {

        Thread.sleep(DELAY_IN_MILLI_SECS * 2L);
        System.out.println("Need to Click Excel");
        clickOperation(fileDwdIcon);
        System.out.println("Clicked Excel");
        if (expectedFileName.contains("Documents(10000)")) {
            Thread.sleep(DELAY_IN_MILLI_SECS * 80);
        }else {
            Thread.sleep(DELAY_IN_MILLI_SECS * 8L);
        }
        String fileType = "xlsx";
        isFileDownloadedAndVerifyFileName(expectedFileName,fileType);

        //deleteFile();

    }

    public static String isFileDownloadedAndVerifyFileName(String expectedFileName, String fileType) throws Exception {
        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();
        Report.info("default directory  is:" + folder.getName());
        Report.info("default Path is:" + folder.getAbsolutePath());
        String folderPath = folder.getAbsolutePath();
        System.out.println("Folder Path is :" + folderPath);
        return test_download_file(getDriver(), expectedFileName, folderPath,fileType);
    }
    public static String isFileDownloadedAndVerifyFileNameCSV(String expectedFileName, String fileType) throws Exception {
        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();
        Report.info("default directory  is:" + folder.getName());
        Report.info("default Path is:" + folder.getAbsolutePath());
        String folderPath = folder.getAbsolutePath();
        System.out.println("Folder Path is :" + folderPath);
        return test_download_fileCSV(getDriver(), expectedFileName, folderPath,fileType);

    }
    public static void readingCSV(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            String line;
            int rowNum = 0;

            while ((line = br.readLine()) != null) {
                rowNum++;
                String[] values = line.split(",");

                System.out.print("Row " + rowNum + ": ");
                for (String v : values) {
                    System.out.print(v.trim() + " | ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read CSV: " + filepath);
        }
    }
    public static Set getDirectoryFiles(String path)
    {
        Set<String> fileSet = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path))) {
            for (Path fpath : stream) {
                if (!Files.isDirectory(fpath)) {
                    fileSet.add(fpath.getFileName().toString());

                }
            }
            return fileSet;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFile() throws IOException {
        System.out.println(" Entered into Delete Loop");
        System.out.println(" Folder:" + folder);
        //readingexcel(filePath);
           /* for (File file : folder.listFiles()) {
                file.delete();
            }*/

        FileUtils.cleanDirectory(folder);
        // Then, remove the folder
        FileUtils.deleteDirectory(folder);
        //folder.delete();
        System.out.println(" Folder after delete:" + folder);

    }




    /* private static boolean isSheetEmpty(Sheet sheet) {
        if (sheet == null || sheet.getLastRowNum() <= 0) {
            return true;
        }

        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null && cell.getCellType() != CellType.BLANK) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void  readingexcel(String filepath)
    {
        try (FileInputStream fis = new FileInputStream(new File(filepath))) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to check the first sheet

            boolean isEmpty = isSheetEmpty(sheet);

            if (isEmpty) {
                System.out.println("The Excel file is empty.");
            } else {
                System.out.println("The Excel file is not empty.");
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

//Modified the existing Read Excel Method
    private static boolean isSheetEmpty(XSSFSheet sheet) {
        if (sheet == null || sheet.getLastRowNum() <= 0) {
            return true;
        }

        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null && cell.getCellType() != CellType.BLANK) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
    private static boolean isxlsSheetEmpty(HSSFSheet sheet) {
        if(sheet != null && sheet.getLastRowNum() == 0)
        {
            Report.info("Header content found in the file");
            return false;
        }
        else if (sheet == null || sheet.getLastRowNum() <= 0) {
            return true;
        }

        for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null && cell.getCellType() != CellType.BLANK) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public static void  readingxlsfile(String filepath) {
        try (FileInputStream fis = new FileInputStream(new File(filepath))) {
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0); // Assuming you want to check the first sheet

            boolean isEmpty = isxlsSheetEmpty(sheet);
            String text;

            if (isEmpty) {

                text = "The Excel file is empty.";
            } else {
                text = "The Excel file is not empty.";
            }

            Assert.assertEquals("The Excel file is not empty.", text);
            fis.close();
            //deleteFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  readingexcel(String filepath)
    {
        try (FileInputStream fis = new FileInputStream(new File(filepath))) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0); // Assuming you want to check the first sheet

            boolean isEmpty = isSheetEmpty(sheet);
            String text;

            if (isEmpty) {

                text = "The Excel file is empty.";
            } else {
               text=  "The Excel file is not empty.";
            }

            Assert.assertEquals("The Excel file is not empty.",text);
            fis.close();
            //deleteFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String readingPdf(String outPutFile,String page) throws IOException {
        //outputFile is the path of the pdf and page is either to get content from "allPages" or a page
        StringBuilder stb = new StringBuilder();
        stb.append("file:///").append(outPutFile);
        System.out.println(stb);
        String newFile = String.valueOf(stb);

        System.out.println(newFile.replaceAll("\\\\", "/"));
        URL url =new URL(newFile.replaceAll("\\\\", "/"));
        InputStream is= url.openStream();
        BufferedInputStream bis=new BufferedInputStream(is);
        PDDocument doc=PDDocument.load(bis);
        PDFTextStripper stripper = new PDFTextStripper();
        if(page.equalsIgnoreCase("allPages"))
        {

        }
        else {
            stripper.setStartPage(Integer.parseInt(page));
            stripper.setEndPage(Integer.parseInt(page));
        }
        String pdfContent=stripper.getText(doc);
        Report.info("test pdf content"+ pdfContent);
        Assert.assertFalse(pdfContent.isEmpty());
        doc.close();
        return pdfContent;
       
    }
    public static void readingexcelCount(String filepath) { //Count for departmentName
        try (FileInputStream fis = new FileInputStream(new File(filepath))) {
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);// Assuming you want to check the first sheet
            List<String> CV = new ArrayList<>();
            for (Row row : sheet) {
                Cell cell = row.getCell(2);
                if (cell != null) {
                    CV.add(cell.toString());
                }
            }
            Set set = new HashSet();
            set.addAll(CV);
            set.remove("");
            Report.info("Department Name: "+set);
            departmentSize = set.size();
            Report.info("size: "+departmentSize);
            Report.info("Department Names: "+set);

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Get PhysicalNumber Of Rows
    public static int getPhysicalNoOfRows(String filepath) throws IOException, InvalidFormatException {
        long rowCount = 0;
        try(FileInputStream fileInputStream = new FileInputStream(new File(filepath));
            ReadableWorkbook workbook = new ReadableWorkbook(fileInputStream)) {
            org.dhatim.fastexcel.reader.Sheet sheet = workbook.getFirstSheet();
            try (Stream<org.dhatim.fastexcel.reader.Row> rows = sheet.openStream()) {
                rowCount = rows.count();
            }
            System.out.println("Total number of rows: " + rowCount);
        }catch (Exception e)
        {
            throw e;
        }
        return (int) rowCount;
    }
    //verify Excel columns
    public static List<String> verifyExcelColumns(String filepath, int rowIndex) throws IOException, InvalidFormatException {
        List<String> actualColumns = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(new File(filepath));
             ReadableWorkbook workbook = new ReadableWorkbook(fileInputStream)) {
            org.dhatim.fastexcel.reader.Sheet sheet = workbook.getFirstSheet();
            org.dhatim.fastexcel.reader.Row headerRow = sheet.read().get(rowIndex);
            for (org.dhatim.fastexcel.reader.Cell cell : headerRow) {
                actualColumns.add(cell.getText().trim());
            }
            return actualColumns;
        }catch (Exception e)
        {
            throw e;
        }
    }




//read excel New Method
   /* public static void excelCellDataRead() throws Exception {
        File src = new File("C:\\Users\\WQ60XQ\\Downloads\\Party_Search_Export.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet sheet = xsf.getSheetAt(0);
        String searchRow = sheet.getRow(1).getCell(1).getStringCellValue();
        System.out.println("Loaded file with :" + searchRow);
        deleteFile();


    }*/

    public static List<String> getColumnValues(String filepath, int columnIndex) throws IOException,InvalidFormatException {
        List<String> actualColumnValues = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(new File(filepath));
             ReadableWorkbook workbook = new ReadableWorkbook(fileInputStream)) {
            org.dhatim.fastexcel.reader.Sheet sheet = workbook.getFirstSheet();
            for (int i = 1; i <= 10; i++) {
                org.dhatim.fastexcel.reader.Cell cell = sheet.read().get(i).getCell(columnIndex);
                actualColumnValues.add(cell.getText().replaceAll("-", " ").trim());
            }
            return actualColumnValues;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

}
