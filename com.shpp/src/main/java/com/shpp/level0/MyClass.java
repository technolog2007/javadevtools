package com.shpp.level0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.shpp.logging.MyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyClass {
    // File name *.properties
    private static final String PROPERTIES_FILE_NAME = "app.properties";
    private static final String PROPERTY_KEY = "userName";
    // Getting a logger
    private static final Logger logger = LoggerFactory.getLogger("logback");

    public static void main(String[] args) throws IOException {

        //Load app.properties
        Properties properties = new Properties();
        try {
            logger.info("Пробую запустить внутренний properties !!!");
            InputStream rootPath = MyClass.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
            properties.load(rootPath);
        } catch (Exception e) {
            logger.debug("Запускаю внешний properties !!!");
            // F:\Programming\Experiments\com.shpp\target\classes
            File pathJar = new File(MyClass.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            // F:\Programming\Experiments\com.shpp\target
            String propertyPath = pathJar.getParentFile().getAbsolutePath();
            properties.load(new FileInputStream(propertyPath + File.separator + PROPERTIES_FILE_NAME));
        }

        // Create a message object and pass the PROPERTY_KEY parameter to it

        if (properties.getProperty(PROPERTY_KEY) == null) {
            properties.setProperty(PROPERTY_KEY, "Andrii Illiashenko");
        }
        MyMessage myMessage = new MyMessage(properties.getProperty(PROPERTY_KEY));

        //Get system property -Dflag=xml or -Dflag=json
        String flag = System.getProperty("flag");

        if (flag != null) {
            // generating json file from java objects

            if (flag.equals("json")) {
                ObjectMapper objectMapper = new ObjectMapper();
                logger.debug(" Формирую файл *.json !!!");
                objectMapper.writeValue(new File("message.json"), myMessage);
                logger.info(objectMapper.writeValueAsString(myMessage));
            } else if (flag.equals("xml")) {
                logger.debug(" Формирую файл *.xml !!!");
                XmlMapper xmlMapper = new XmlMapper();
                xmlMapper.writeValue(new File("message.xml"), myMessage);
                logger.info(xmlMapper.writeValueAsString(myMessage));
            }
        } else {
            logger.error(" Please input -Dmessage=json or -Dmessage=xml !!!");
        }
    }
}
