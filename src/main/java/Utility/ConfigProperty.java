package Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigProperty {
	private Properties pro;
	public Properties init_prop() {
		String path=System.getProperty("user.dir")+"/src/test/resources/Config/Config.properties";
		pro=new Properties();
		FileInputStream fio=null;
		try {
			fio=new FileInputStream(path);
			pro.load(fio);
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pro;
	}

}
