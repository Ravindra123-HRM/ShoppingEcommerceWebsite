package com.shopping.base;

import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;

public class Logs {
	
	static Logger logger=Logger.getLogger(Log.class.getName());
	
	public static void info(String msg)
	{
		
		logger.info(msg);
	}
	
	public static void debug(String msg)
	{
		
		logger.debug(msg);
	}
	
	public static void error(String msg)
	{
	logger.error(msg);	
	}
	
	public static void fatal(String msg)
	{
		
	logger.fatal(msg);
	}

	public static void info(boolean displayed) {
		// TODO Auto-generated method stub
		logger.info(displayed);
	}
	}
	


