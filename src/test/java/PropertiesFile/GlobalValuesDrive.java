package PropertiesFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValuesDrive {

	public static void main(String[] args) throws IOException {
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\globaldata.properties");
		p.load(fis);
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("url"));
		p.setProperty("browser", "firefox");
		System.out.println(p.get("browser"));
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\globaldata.properties");
		p.store(fos, null);

	}

}
