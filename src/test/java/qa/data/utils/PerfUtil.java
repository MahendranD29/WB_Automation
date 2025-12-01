package qa.data.utils;


import java.util.Date;

import static qa.data.utils.TestBaseClass.mavenProperty;
import static qa.data.utils.TestBaseClass.prop;
import static qa.data.utils.TestBaseClass.Environment;

public class PerfUtil {
    public static Date startTime;
    public static Date endTime;


    public PerfUtil() {
    }

    public static Date startTransaction(String TransactionName) {
        startTime = new Date();
        System.out.println(TransactionName + " Started at : " + startTime);
        return startTime;
    }

    public static Date endTransaction(String TransactionName) {
        endTime = new Date();
        System.out.println(TransactionName + " End at : " + endTime);
        double transResponseTime = (double)(endTime.getTime() - startTime.getTime());
        double diffInSeconds = transResponseTime / 1000.0D;
        System.out.println("Execution Time for :" + TransactionName + " is : " + diffInSeconds + "\n");
        if(mavenProperty){
            Environment  = System.getProperty("Environment");
        }else
        {
            Environment = prop.getProperty("Environment");
        }
        WritePerfResults.writeResults(TransactionName, Environment, startTime, endTime, diffInSeconds, true);
        return endTime;
    }
}
