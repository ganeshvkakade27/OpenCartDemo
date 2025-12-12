package testCases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.accountPage;
import pageObjects.homePage;
import pageObjects.login;
import testBases.baseClass;
import utilities.DataProviderc;

public class TC003_LoginDDT extends baseClass
{

	

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviderc.class)
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException
	{
		  
     		logger.info("===== Test Started====>");
		
		//Thread.sleep(5000);
		
		try
		{
		//click homepage
		homePage hp=new homePage(driver);
		
	
		hp.clickMyAccount();
		hp.Clicklogin();
		
		//login page
		login lp=new login(driver);
		
		lp.setEmail(email);
		lp.setpassword(pwd);
		lp.clicklogin();
		
		
		//my account
		accountPage ap=new accountPage(driver);
		boolean status=ap.ismyaccountexist();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(status==true)
			{
				
				hp.clickMyAccount();
				ap.clicklogout();
				
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}			
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(status==true)
			{
				ap.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
	
	
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("===== Test Finished====>");
		
		}
		
		
}
