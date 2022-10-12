package javadev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class MyTest {

    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);

//    public static void main(String[] args) throws InterruptedException {
//        Properties properties = new Properties();
//        properties.setProperty("one", "1");
//        System.out.println("one");
//
////        for(int i = 0; i < 2000; i++) {
////            logger.info("Hello word");
////            Thread.sleep(10);
////        }
//    }

//    /**
//     * Метод принимает значения из 2-х файлов пропертиз (app.properties, prop) и выводит соответствующие значения
//     * из пары (ключ-значение) в консоль.
//     *
//     * @param args
//     * @throws IOException
//     */
//    public static void main(String[] args) throws IOException {
//        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        String appConfigPath = rootPath + "app.properties";
//        String catalogConfigPath = rootPath + "prop";
//
//        Properties appProps = new Properties();
//        appProps.load(new FileInputStream(appConfigPath));
//
//        Properties catalogProps = new Properties();
//        catalogProps.load(new FileInputStream(catalogConfigPath));
//
//        String appVersion = appProps.getProperty("version");
//        System.out.println(catalogProps.getProperty("c1"));
//    }

    /**
     * Get Properties
     *
     * We can use getProperty(String key) and getProperty(String key, String defaultValue) to get value by its key.
     * f the key-value pair exists, the two methods will both return the corresponding value. But if there is no
     * such key-value pair, the former will return null, and the latter will return defaultValue instead.
     *
     * @param args
     */
//    public static void main(String[] args) throws IOException {
//        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        String appConfigPath = rootPath + "app.properties";
//
//        Properties appProps = new Properties();
//        appProps.load(new FileInputStream(appConfigPath));
//
//        String appVersion = appProps.getProperty("version");
//        System.out.println(appVersion);
//        String appName = appProps.getProperty("name", "defaultName");
//        System.out.println(appName);
//        String appGroup = appProps.getProperty("group", "baeldung");
//        System.out.println(appGroup);
//        // if there is no corresponding key in the properties file - it returns null
//        String appDownloadAddr = appProps.getProperty("downloadAddr");
//        System.out.println(appDownloadAddr);
//        /*
//         * Note that although Properties class inherits get() method from Hashtable class,
//         * I wouldn't recommend you use it to get value. Because its get() method will return
//         * an Object value which can only be cast to String and the getProperty() method already
//         * handles the raw Object value properly for you.
//         *
//         * The code below will throw an Exception:
//         */
//        float appVerFloat = (float) appProps.get("version");
//        System.out.println(appVerFloat);
//    }

    /**
     * Set Properties
     *
     */
//    public static void main(String[] args) throws IOException {
//        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        String appConfigPath = rootPath + "app.properties";
//
//        Properties appProps = new Properties();
//        appProps.load(new FileInputStream(appConfigPath));
//
//        appProps.setProperty("name", "NewAppName"); // update an old value
//        appProps.setProperty("downloadAddr", "www.baeldung.com/downloads"); // add new key-value pair
//
//        String newAppName = appProps.getProperty("name");
//        System.out.println(newAppName);
//
//        String newAppDownloadAddr = appProps.getProperty("downloadAddr");
//        System.out.println(newAppDownloadAddr);
//
//        /*
//         * Note that although Properties class inherits put() method and putAll() method from Hashtable class,
//         * I wouldn't recommend you use them for the same reason as for get() method: only String values can
//         * be used in Properties.
//         *
//         * The code below will not work as you wish, when you use getProperty() to get its value, it will return null:
//         */
//
//         appProps.put("version2", 2);
//
//    }

    /**
     * Remove Properties
     *
     * If you want to remove a key-value pair, you can use remove() method.     *
     */
//    public static void main(String[] args) throws IOException {
//        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        String appConfigPath = rootPath + "app.properties";
//
//        Properties appProps = new Properties();
//        appProps.load(new FileInputStream(appConfigPath));
//
//
//        String versionBeforeRemoval = appProps.getProperty("version");
//        System.out.println("version = " + versionBeforeRemoval);
//
//        appProps.remove("version");
//        String versionAfterRemoval = appProps.getProperty("version");
//        System.out.println("version = " + versionAfterRemoval);
//    }

    /**
     * Store
     *
     * Store to Properties Files
     * Properties class provides a store() method to output key-value pairs.
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Properties appProps = new Properties();

        String newAppConfigPropertiesFile = rootPath + "newApp.properties";
        // The second parameter is for comment. If you don't want to write any comment, simply use null for it.
        appProps.store(new FileWriter(newAppConfigPropertiesFile), "store to properties file");
    }

}