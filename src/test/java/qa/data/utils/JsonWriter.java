package qa.data.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonWriter {
    private static final String RELATIVE_PATH = "src/test/java/hermes/data/testdata/zephyr.json";

    public static synchronized void writeResult(String testCaseKey,String status, String comments) {
        JSONArray resultsArray;

        try {
            File file = new File(RELATIVE_PATH);
            String absolutePath = file.getAbsolutePath();
            Path path = Paths.get(absolutePath);

            JSONObject result = new JSONObject();
            result.put("projectKey", "PMX");
            result.put("testCaseKey", testCaseKey);
            result.put("status", status);
            result.put("comment", comments);

            result.toString();

            try (FileWriter writer = new FileWriter(absolutePath)) {
                writer.write(result.toString(4));
                System.out.println("JSON written to: " + absolutePath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void createTest(String testCaseKey) {
        JSONArray resultsArray;

        try {
            File file = new File(RELATIVE_PATH);
            String absolutePath = file.getAbsolutePath();
            Path path = Paths.get(absolutePath);

            JSONObject result = new JSONObject();
            result.put("projectKey", "PMX");
           // result.put("testCaseKey", "PMX-T3899");
            result.put("testCaseKey", testCaseKey);

            result.toString();

            try (FileWriter writer = new FileWriter(absolutePath)) {
                writer.write(result.toString(4));
                System.out.println("JSON written to: " + absolutePath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearJsonFile() {
        File filejson = new File(RELATIVE_PATH);
        String filePath = filejson.getAbsolutePath();
        try (FileWriter file = new FileWriter(filePath, false)) {
            file.write(""); //clears content
            file.flush();
            System.out.println("JSON file cleared successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
