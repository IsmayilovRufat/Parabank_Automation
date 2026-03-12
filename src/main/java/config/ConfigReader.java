package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {

        try {

            properties = new Properties();

            InputStream input =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream("config.properties");

            properties.load(input);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties");
        }

    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}