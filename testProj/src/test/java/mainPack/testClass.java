package mainPack;

import org.apache.log4j.Logger;
import org.junit.Test;



public class testClass {
    @Test
    public void test(){
        Logger logger = Logger.getLogger(getClass());
        logger.info("test");
        logger.error("error");
        logger.debug("debug");
    }
}
