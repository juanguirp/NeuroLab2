package co.edu.udea.iw.exception;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class NeuroLabDaoException extends Exception{

	static Logger LOGGER = Logger.getLogger(NeuroLabDaoException.class);
	
	public NeuroLabDaoException(String message, Throwable cause) {
		
		BasicConfigurator.configure();
		LOGGER.error("*** Mensaje de error: " + message);
		LOGGER.error("*** Causa: " + cause);
	}

	public NeuroLabDaoException(String message) {
		
		BasicConfigurator.configure();
		LOGGER.error("*** Mensaje de error: " + message);
		
	}

	public NeuroLabDaoException(Throwable cause) {
		
		BasicConfigurator.configure();
		LOGGER.error("*** Mensaje de error: " + cause);
		
	}
	
	

}
