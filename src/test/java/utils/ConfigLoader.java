package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLoader {

	private Properties property;
	public static ConfigLoader instance;

	public ConfigLoader() {
		try {
			FileInputStream fs = new FileInputStream("src\\test\\resources\\config.properties");
			property = new Properties();
			property.load(fs);
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public static ConfigLoader getInstance()
	{
		if(instance == null)
		instance=new ConfigLoader();
		
			return instance;
	}
	
	public String getProperty(String key)
	{
		
		return property.getProperty(key);
		
	}
	}
	

