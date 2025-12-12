package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.register;
import testBases.baseClass;

public class TC001_Account_Registartion extends baseClass {
	
	
@Test(priority=1)	
public void Registation()
{
	
	try {
	
	logger.info("<----Starting Test TC001_Account_Registartion ----->");
	homePage hp=new homePage(driver);  //To access home page object class
	
	hp.clickMyAccount();	
	
	logger.info("<----Clicked on My Account Link----->");
	hp.clickRegister();
	
	logger.info("<----Clicked on My Register Link----->");
	
	register rp=new register(driver);   // To access register page
	
	logger.info("<----Providing customer info----->");
	rp.setFirstName(RandomString().toUpperCase());
	rp.setLastName(RandomString().toUpperCase());
	rp.setEmail(RandomString()+"@gmail.com");
	String password=alphanum();
	rp.setPhone(RandomNumber());
	rp.setPassword(password);
	rp.setrepass(password);
	rp.CheckBoxnews();
	rp.checkboxAgree();
	
	rp.ClickContinue();
	
	String confirmmessage=rp.confirmMessage();

	logger.info("<----Validating expected message----->");
	Assert.assertEquals(confirmmessage, "Your Account Has Been Created!");
	
	
	logger.info("<----Testing is Finished------>");
	
	}catch(Exception e)
	{
		logger.error("Test Failed");
		logger.debug("Debug Log");
		Assert.fail();
	}
}








	
	

}
