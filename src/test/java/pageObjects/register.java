package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class register extends basePage{

	public register(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

//These are the locators that show encapsulation	
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPass;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtrepass;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement checkNewslett;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirm;
	
	
	public void setFirstName(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtlastname.sendKeys(lname);
	}

	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}

	public void setPhone(String phone)
	{
		txttelephone.sendKeys(phone);
	}
	public void setPassword(String pass)
	{
		txtPass.sendKeys(pass);
	}

	public void setrepass(String repass)
	{
		txtrepass.sendKeys(repass);
		
	}
	public void CheckBoxnews()
	{
		checkNewslett.click();
	}
	
	public void checkboxAgree()
	{
		checkAgree.click();
	}
	
	public void ClickContinue()
	{
		btnContinue.click();
	}

	
	public String confirmMessage()
	{
		try 
		{
			String statusmsg=confirm.getText();
			return statusmsg;
		}catch(Exception e)
		{
			return e.getMessage();
		}
	}


}

