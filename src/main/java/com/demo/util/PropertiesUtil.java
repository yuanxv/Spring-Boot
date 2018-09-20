package com.demo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class PropertiesUtil {

	private static Properties prop = new Properties();
	private final static String file = "/application.properties";
	static {
		try {
			prop.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

	public static void setProperty(String key, String value) {
		/**
		 * 将文件加载到内存中，在内存中修改key对应的value值，再将文件保存
		 */
		try {
			prop.setProperty(key, value);
			FileOutputStream fos = new FileOutputStream(file);
			prop.store(fos, value);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
