package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account Link");
		
		hp.clickRegister();
		logger.info("Clicked on register Link");
	
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		
		logger.info("Providing user details");
		
		arp.setFirstName(randomeString().toUpperCase());
		arp.setLastName("Rodrigo");
		arp.setEmail( randomeString()+"@gmail.com");
		arp.setTelephone(randomeNumber());
		
		String password =randomeAlphanumeric();
		
		arp.setPassword(password);
		arp.setConfirmPassword(password);
		
		arp.setPrivacyPolicy();
		arp.clickContinue();
		
		//validation
		logger.info("Validating expected message..");
		 String confmsg = arp.getConfirmationMessage();
		 
		 if (confmsg.equals("Your Account Has Been Created!"))
		 {
			 Assert.assertTrue(true);
		 }
		 
		 else
		 {
			 logger.error("Test failed...");
			 logger.debug("Debug logs");
			 Assert.fail("Expected: 'Your Account Has Been Created!' but found: '" + confmsg + "'");	
		
			 
		 }
		 
		 //Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		
		logger.info("**** Finished TC001_AccountRegistrationTest ****");
	
	}

	
	
	
}
