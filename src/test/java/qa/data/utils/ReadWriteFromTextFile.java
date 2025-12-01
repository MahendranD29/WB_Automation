package qa.data.utils;

import java.io.*;
import java.util.Scanner;

public class ReadWriteFromTextFile {
    private final String textFile;

    String fileName = "sample.txt";
    public String defaultPath = "src/test/java/qa/gpp/testdata";

    public ReadWriteFromTextFile(String fileName) {
        this.textFile = this.defaultPath + "/" + fileName;
    }

//    public ReadWriteFromTextFile(String otherPath, String fileName) {
//
//        this.textFile = otherPath + "/" + fileName;
//    }

    public String readValue() throws FileNotFoundException {

       // List<String> fileText = new ArrayList<>();
        String upDatedValue = null;
        File file = new File(this.textFile);
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
          upDatedValue =  sc.nextLine();
        }
        return upDatedValue;


    }

    public void WriteValue(String value) throws IOException {

        File file = new File(this.textFile);
        Scanner sc = new Scanner(file);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(value);
        //fw.write(value);
        bw.close();
        fw.close();
        //readValue();


    }


}
