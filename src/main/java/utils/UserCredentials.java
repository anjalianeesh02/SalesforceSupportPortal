package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserCredentials {
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";

    private static Properties properties;

    static {
        try {
            FileInputStream input = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception
        }
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getAppURL() {
        return properties.getProperty("appURL");
    }
}
