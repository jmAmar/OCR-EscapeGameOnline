package com.ocr.gameplay_studio;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GameLogging
{
	protected final static Logger logger = LogManager.getLogger(com.ocr.gameplay_studio.GameLogging.class.getName());

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
