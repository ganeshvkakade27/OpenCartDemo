package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login extends basePage
{

	public login(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//locators
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemailad;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassward;

	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	
	
	
	public void setEmail(String email)
	{
		txtemailad.sendKeys(email);
	}
	
	public void setpassword(String pass)
	{
		txtpassward.sendKeys(pass);
	}

	public void clicklogin()
	{
		btnlogin.click();
	}
		
	
	
	
	//action methods
}
