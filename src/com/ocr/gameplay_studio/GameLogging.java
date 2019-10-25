package com.ocr.gameplay_studio;

//import org.apache.log4j.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.apache.log4j.Logger;

public class GameLogging
{
	protected final static Logger logger = Logger.getLogger(GameLogging.class);

	protected static void logInfo(String info)
	{   logger.info(info);
	}

	protected static void logWarning(String warning)
	{   logger.warn(warning);
	}

	protected static void logError(String error)
	{   logger.error(error);
	}
}
/**/
