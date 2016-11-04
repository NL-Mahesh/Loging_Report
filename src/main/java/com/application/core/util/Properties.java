package com.application.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Properties {
	
	private static java.util.Properties props;
	private static InputStream in=null;
	
	static{
		File fileName=new File("src/test/resources/applicaiton.properties");
		try{
			props=new java.util.Properties();
			in=new FileInputStream(fileName);
			props.load(in);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}		
	}
	
	public static String getProperties(String key){
		return props.getProperty(key);
	}

}
