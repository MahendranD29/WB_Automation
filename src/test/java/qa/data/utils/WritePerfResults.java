package qa.data.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


import static qa.data.utils.TestBaseClass.prop;

public class WritePerfResults {
    public static Date date = new Date();
    public static String FileName = null;

    public WritePerfResults() {
    }

    public static void createFile() throws Exception {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String currDate = format.format(date);
            System.out.println(currDate);
            if (prop.getProperty("Browser").equalsIgnoreCase("LocalChrome")){
                FileName =  "./target/site/serenity/PerfSingleUserRT_" + currDate + ".csv";
            }else{
                //FileName = System.getProperty("user.dir") + "/target/site/serenity/PerfSingleUserRT_" + currDate + ".csv"
                FileName =  "PerfSingleUserRT_" + currDate + ".csv";
            }
            File file = new File(FileName);
            if (!file.exists()) {
                file.createNewFile();
                FileOutputStream stream = new FileOutputStream(FileName);
                String bytes = "Scenario_Transaction, Environment , Start Time, End Time, Transaction Response Time - Sec, Transaction Status";
                stream.write(bytes.getBytes());
                stream.flush();
                stream.close();
            }
        } catch (Exception var5) {
            log4jBaseClass.error("Error occured while creating single user performance report. Stack trace:" + var5.getMessage());
        }

    }

    public static void writeResults(String transName, String Environment, Date sDate, Date eDate, double resTime, boolean status) {
        try {
            FileOutputStream stream = new FileOutputStream(FileName, true);
            String bytes = "\n" + transName + ", " + Environment + ", " + sDate + ", " + eDate + ", " + resTime + ", " + status;
            stream.write(bytes.getBytes());
            stream.flush();
            stream.close();
        } catch (Exception var9) {
            var9.printStackTrace();
            log4jBaseClass.error("Error occured while writing results to single user performance report '" + FileName + "'. Stack trace:" + Arrays.toString(var9.getStackTrace()));
        }

    }
}
