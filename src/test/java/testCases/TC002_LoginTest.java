package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.accountPage;
import pageObjects.homePage;
import pageObjects.login;
import testBases.baseClass;

public class TC002_LoginTest extends baseClass
{

	@Test
	public void Verifylogin()
	{
		
		logger.info("====> TC002_LoginTest execution started =====> ");
		homePage hp=new homePage(driver);
		
		hp.clickMyAccount();
		hp.Clicklogin();
		
		login lp=new login(driver);
		
		
		logger.info("===Entering details for login====");
		lp.setEmail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clicklogin();
		
		accountPage ap=new accountPage(driver);
		
		boolean status=ap.ismyaccountexist();
		Assert.assertTrue(status);
		
		logger.info("===TC002_LoginTest Completed====");
		
	}
	
	

}
