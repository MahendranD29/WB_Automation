package qa.data.utils;

public class Report extends ValidationHelper {
    public Report() {
        super(getDriver());
    }

    public static void pass(String message){

        System.out.println("PASS: "+message);

    }

    public static void fail(String message){

        System.out.println("FAIL: "+message);

    }

    public static void warn(String message){

        System.out.println("Warn: "+message);

    }


    public static void info(String message){

        System.out.println("Info: "+message);

    }

}
