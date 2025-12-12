package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class accountPage extends basePage{

	public accountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement textloginconfirm;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement btnlogout;
	
	
	
	public boolean ismyaccountexist()
	{
		try
		{
		return(textloginconfirm.isDisplayed());
		}
		catch(Exception e)
		{
		   return false;
		}
	}
	
	public void clicklogout()
	{
		btnlogout.click();
		
	}
	
}
