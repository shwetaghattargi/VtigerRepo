package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDatafromPropertiesFile(String key) throws IOException
	{
		//FileInputStream fis = new FileInputStream("./configApp/commanddt.properties");
		FileInputStream fis = new FileInputStream("./configappData/commanddt.properties");

		//C:\seleniumB15\SeleniumCRMGUIFrameWork\configappData
		Properties ps= new Properties();
		ps.load(fis);
		String data = ps.getProperty(key);
		return data;
	}

}
