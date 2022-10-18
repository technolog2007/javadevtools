package com.shpp.level1;

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

public class MyProperties {
    // File name *.properties
    private static final String PROPERTIES_FILE_NAME = "app.properties";
    // Getting a logger
    private static final Logger logger = LoggerFactory.getLogger("logback");

    public static void main(String[] args) throws IOException {

        //Load app.properties
        Properties properties = new Properties();
        try {
            logger.info("Пробую запустить внутренний properties !!!");
            InputStream rootPath = MyProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
            properties.load(rootPath);
        } catch (Exception e) {
            logger.debug("Запускаю внешний properties !!!");
            File pathJar = new File(MyProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String propertyPath = pathJar.getParentFile().getAbsolutePath();
            properties.load(new FileInputStream(propertyPath + File.separator + PROPERTIES_FILE_NAME));
        }

        // Create a message object and pass the "userName" parameter to it
        MyMessage myMessage = new MyMessage(properties.getProperty("userName"));
        ObjectMapper objectMapper = new ObjectMapper();
        //Get system property -Dflag=xml or -Dflag=json
        String flag = System.getProperty("flag");

        logger.debug(" Формирую файл !!!");
        // generating json file from java objects
        if (flag.equals("json")) {
            objectMapper.writeValue(new File("message.json"), myMessage);
        } else if (flag.equals("xml")) {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File("message.xml"), myMessage);
        } else {
            logger.error("Please input -Dmessage=json or -Dmessage=xml !!!");
        }
    }
}
