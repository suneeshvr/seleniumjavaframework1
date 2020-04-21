package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);

	public static void main(String[] args) {
		System.out.println("Hello world");
		logger.info("this is informational message");
		logger.error("This is error message");
		logger.warn("this is warnign");
		logger.fatal("this is fatal");
		logger.trace("trace message");
	}
}
