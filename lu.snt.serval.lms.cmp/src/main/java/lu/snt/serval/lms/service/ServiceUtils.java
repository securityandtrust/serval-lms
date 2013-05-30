package lu.snt.serval.lms.service;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class ServiceUtils {

    public static Logger log = Logger.getRootLogger();


    static {
        // init log
        PropertyConfigurator.configure("logger.prop");
    }
}
