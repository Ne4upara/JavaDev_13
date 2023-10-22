package sergey.goit.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Flyway {

    private static Properties properties = new Properties();

    private static void loadProperties() {
        try (InputStream fls = Flyway.class.getClassLoader().getResourceAsStream("hibernate.properties")) {
            properties.load(fls);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void flywayMigration() {
        loadProperties();
        org.flywaydb.core.Flyway.configure()
                .dataSource(properties.getProperty("hibernate.connection.url"),
                        properties.getProperty("hibernate.connection.username"),
                properties.getProperty("hibernate.connection.password"))
                .locations("classpath:flywaymigration")
                .load()
                .migrate();
    }
}
