package qa.data.utils;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromCSV {
    private final char DEFAULT_SEPARATOR = ',';
    private final char DEFAULT_QUOTE = '"';
    private final String csvFile;
    public String defaultPath = "src/test/java/qa/gpp/testdata";
    //public String defaultPath = "src/test/java/commonUtility/testdata";

    public ReadFromCSV(String fileName) {
        this.csvFile = this.defaultPath + "/" + fileName;
    }

    public ReadFromCSV(String otherPath, String fileName) {
        this.csvFile = otherPath + "/" + fileName;
    }

    public String readValue(String TestCaseName, String KeyName) {
        String value = "";

        try {
            Scanner scanner = new Scanner(new File(this.csvFile));

            while(scanner.hasNext()) {
                List<String> line = this.parseLine(scanner.nextLine());
                if (line.get(1).equals(TestCaseName) && line.get(2).equals(KeyName)) {
                    value = line.get(3);
                    break;
                }
            }

            scanner.close();
            return value;
        } catch (Exception var6) {
            log4jBaseClass.error("Error while extracting data from csv. StackTrace:" + var6.getMessage());
            return value;
        }
    }

    public TestCaseProperties getTestProperties(String TestCaseName) {
        TestCaseProperties testProps = null;

        try {
            Scanner scanner = new Scanner(new File(this.csvFile));

            List line;
            do {
                if (!scanner.hasNext()) {
                    scanner.close();
                    return testProps;
                }

                line = this.parseLine(scanner.nextLine());
            } while(!line.get(1).equals(TestCaseName));

            testProps = new TestCaseProperties();
            testProps.setSeverity(Integer.parseInt((String)line.get(2)));
            testProps.setPriority(Integer.parseInt((String)line.get(3)));
            return testProps;
        } catch (Exception var5) {
            log4jBaseClass.error("Error while extracting data from csv. StackTrace:" + var5.getMessage());
            return testProps;
        }
    }

    public String readValue(int rowNumber, int colNumber) {
        String value = "";

        try {
            Scanner scanner = new Scanner(new File(this.csvFile));

            for(int rowNum = 1; scanner.hasNext(); ++rowNum) {
                List<String> line = this.parseLine(scanner.nextLine());
                if (rowNum == rowNumber) {
                    value = line.get(colNumber - 1);
                    break;
                }
            }

            scanner.close();
            return value;
        } catch (Exception var7) {
            log4jBaseClass.error("Error while extracting data from csv. StackTrace:" + var7.getMessage());
            return value;
        }
    }

    private List<String> parseLine(String cvsLine) {
        return this.parseLine(cvsLine, ',', '"');
    }

    private List<String> parseLine(String cvsLine, char separators) {
        return this.parseLine(cvsLine, separators, '"');
    }

    private List<String> parseLine(String cvsLine, char separators, char customQuote) {
        List<String> result = new ArrayList<>();
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        } else {
            if (customQuote == ' ') {
                customQuote = '"';
            }

            if (separators == ' ') {
                separators = ',';
            }

            StringBuffer curVal = new StringBuffer();
            boolean inQuotes = false;
            boolean startCollectChar = false;
            boolean doubleQuotesInColumn = false;
            char[] chars = cvsLine.toCharArray();
            char[] var10 = chars;
            int var11 = chars.length;

            for(int var12 = 0; var12 < var11; ++var12) {
                char ch = var10[var12];
                if (inQuotes) {
                    startCollectChar = true;
                    if (ch == customQuote) {
                        inQuotes = false;
                        doubleQuotesInColumn = false;
                    } else if (ch == '"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }
                } else if (ch == customQuote) {
                    inQuotes = true;
                    if (chars[0] != '"' && customQuote == '"') {
                        curVal.append('"');
                    }

                    if (startCollectChar) {
                        curVal.append('"');
                    }
                } else if (ch == separators) {
                    result.add(curVal.toString());
                    curVal = new StringBuffer();
                    startCollectChar = false;
                } else if (ch != '\r') {
                    if (ch == '\n') {
                        break;
                    }

                    curVal.append(ch);
                }
            }

            result.add(curVal.toString());
            return result;
        }
    }
}

