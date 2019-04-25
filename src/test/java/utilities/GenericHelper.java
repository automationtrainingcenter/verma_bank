package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class GenericHelper {
	public void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

	public static String getDate() {
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("dd_MMM_YY-HH_mm_ss");
		return df.format(dt);
	}

	public String readProperty(String propName) {
		try {
			FileInputStream fis = new FileInputStream(getFilePath("", "config.properties"));
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(propName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
