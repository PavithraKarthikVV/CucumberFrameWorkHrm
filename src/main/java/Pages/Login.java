package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	private WebDriver driver;
	//public String Url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ";
	@FindBy(name ="username") private WebElement username;
	@FindBy(name ="assword")private WebElement password;
	@FindBy(xpath ="//button[@type='submit']")private WebElement LoginBtn;
	
	public Login(WebDriver d)
	{
		this.driver=d;
	}
	

	public void loginIn(String usename,String pasword) 
	{	
		
		PageFactory.initElements(driver,this);
		new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfAllElements(username,password));
		username.sendKeys(usename);
		password.sendKeys(pasword);
		LoginBtn.click();
		
	} 

	public String VerifyLogin() {
		
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//String ExpectingUrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String curenttitle=driver.getCurrentUrl();
		return(curenttitle);
		
		
				}

}
