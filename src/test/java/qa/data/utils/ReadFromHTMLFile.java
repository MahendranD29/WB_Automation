package qa.data.utils;

import java.io.*;

public class ReadFromHTMLFile {


    public String defaultPath = "src/test/java/qa/gpp/testdata";

    public ReadFromHTMLFile() {
    }

    public String readHtml(String filename) throws FileNotFoundException {

        // List<String> fileText = new ArrayList<>();
            /* Constructing String Builder to
        append the string into the html */
        StringBuilder html = new StringBuilder();
        String attachFile = defaultPath + File.separator + filename;
        //  File file = new File(attachFile);

        // Reading html file on local directory
        FileReader fr = new FileReader(attachFile);

        // Try block to check exceptions
        String result;
        try {

            // Initialization of the buffered Reader to get
            // the String append to the String Builder
            BufferedReader br = new BufferedReader(fr);

            String val;

            // Reading the String till we get the null
            // string and appending to the string
            while ((val = br.readLine()) != null) {

                html.append(val).append("\n");
            }

            // AtLast converting into the string
            result = html.toString();
            // System.out.println(result);
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }}
