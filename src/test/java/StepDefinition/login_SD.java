package StepDefinition;
import org.junit.Assert;

import DriverFactory.*;
import Pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login_SD {
	private Login l=new Login(driverfactry.getdriver());
	@Given("Launch App")
	public void launch_app() {
		driverfactry.getdriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");	
	}

	@When("Give username and password {string},{string}")
	public void give_username_and_password(String string, String string2) {
		l.loginIn(string,string2);
	}

	@Then("I validate the outcomes {string}")
	public void i_validate_the_outcomes(String string) {
		 String currentTitle=l.VerifyLogin();
		 System.out.println(currentTitle);
		 Assert.assertTrue(currentTitle.contains(string));
	}




}
