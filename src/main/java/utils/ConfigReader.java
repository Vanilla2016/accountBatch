package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;


public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        // getting absolute path of file from relative path
        String relativeConfigFilePath = "src/main/resources/config.properties";
        String filePath = Paths.get(relativeConfigFilePath).toAbsolutePath().toString();
        try {
            FileInputStream file = new FileInputStream(filePath);
            properties.load(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);        // returns null if property key not exists
    }
}
