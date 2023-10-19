package sergey.goit.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Flyway {

    private static final String PROPERTIES_FILE = "database.properties";

    static Properties properties = new Properties();

    private static void loadProperties() {
        try (FileInputStream fls = new FileInputStream(PROPERTIES_FILE)) {
            properties.load(fls);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void flywayMigration() {
        loadProperties();
        org.flywaydb.core.Flyway.configure()
                .dataSource(properties.getProperty("db.url"),
                        properties.getProperty("db.userName"),
                        properties.getProperty("db.password"))
                .locations("classpath:flywaymigration")
                .baselineOnMigrate(true)
                .load()
                .migrate();
    }
}
