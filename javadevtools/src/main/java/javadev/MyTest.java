package javadev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTest {

    private static final Logger logger = LoggerFactory.getLogger(MyTest.class);

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 2000; i++) {
            logger.info("Hello word");
            Thread.sleep(10);
        }
    }
}