package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverfactry {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> ltdriver=new ThreadLocal();
	
	public WebDriver init_driver(String browser)
{
	if(browser.equals("chrome"))
	{
		System.setProperty("webdriver.chromedriver.driver","C:/Users/Viru/Desktop/JavaPrograms/CucumberFrameWorkHrm/src/test/resources/Driver/chromedriver.exe" );
		ltdriver.set(new ChromeDriver());
	}
	else if(browser.equals("safari"))
	{
		System.setProperty("webdriver.safaridriver.driver","C:/Users/Viru/Desktop/JavaPrograms/CucumberFrameWorkHrm/src/test/resources/Driver/chromedriver.exe" );
		ltdriver.set(new SafariDriver());
	}
	else if(browser.equals("firefox"))
	{
		System.setProperty("webdriver.firefoxdriver.driver","C:/Users/Viru/Desktop/JavaPrograms/CucumberFrameWorkHrm/src/test/resources/Driver/chromedriver.exe" );
		ltdriver.set(new FirefoxDriver());
	}
	getdriver().manage().deleteAllCookies();
	getdriver().manage().window().maximize();
	return getdriver();
}
	public static synchronized WebDriver getdriver()
	{
		return ltdriver.get();
	}
}
