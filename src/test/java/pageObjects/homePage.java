package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage {
	
	public homePage(WebDriver driver)
	{
		super(driver);
		
	}

	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myacc;
	
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	
	public void clickMyAccount()
	{
		myacc.click();
		
	}
	
	public void clickRegister()
	{
		
		register.click();
	}
	
	public void Clicklogin()
	{
		login.click();
	}
}
