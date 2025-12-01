package qa.data.utils;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipExtentReports {

    public static void zipExtentReport() throws Exception {
        Path projectDir = Paths.get(System.getProperty("user.dir"));

        //Source Folder
        File fileS = new File("test-output/ExtentReports");
        String fileSourcePath = fileS.getAbsolutePath();
        Path sourceFolder = Paths.get(fileSourcePath);

        //Destination Folder
        File fileD = new File("test-output/ArchivedReports");
        String fileDestinationPath = fileD.getAbsolutePath();
        Path destinationFolder = Paths.get(fileDestinationPath);

        // Create destination folder if missing
        if (!Files.exists(destinationFolder)) {
            Files.createDirectories(destinationFolder);
        }

        String ts = (new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")).format(new Date());
        // String zipFileName = "ExtentReport_" + ts + ".zip";
        String zipFileName = "TNR_Regression_Execution.zip";
        Path zipFilePath = destinationFolder.resolve(zipFileName);

        zipFolder(sourceFolder, zipFilePath);

        System.out.println("Extent report zipped successfully.");
        System.out.println("Saved at: " + projectDir.relativize(zipFilePath));
    }

    private static void zipFolder(Path sourceFolderPath, Path zipPath) throws Exception {
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipPath))) {
            Files.walk(sourceFolderPath)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(sourceFolderPath.relativize(path).toString());
                        try {
                            zos.putNextEntry(zipEntry);
                            Files.copy(path, zos);
                            zos.closeEntry();
                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });
        }
    }


}
