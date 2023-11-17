package Apphooks;

import java.util.Properties;
import DriverFactory.*;
import Utility.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHook {
	private driverfactry driverfact;
	private ConfigProperty proper;
	private Properties brw;
	private WebDriver driver;
	@Before(order = 0)
	public void getproperty() 
	{
		proper=new ConfigProperty();
		brw=proper.init_prop();
		
	}
	@Before(order = 1)
	public void getBrowser() 
	{
		driverfact =new driverfactry();
		String browsername=brw.getProperty("browser");
		driver=driverfact.init_driver(browsername);
	}
	/* after oredr 1 will execute and last 0*/
	@After(order= 0)
	public void QuitBrowser()
	{
		driver.quit();
	}
	
	@After(order= 1)
	public void screenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenshotName=scenario.getName();
			byte[] sourcepath=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);
		}
	}
}
