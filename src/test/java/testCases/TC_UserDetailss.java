package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_UserDetailss extends BaseClass {

	@Test
	public void userDetails() throws InterruptedException {
		hp=new HomePage(driver);
       try { 
    	logger.info("*****Starting TC_UserDetailsTest*****");
		Thread.sleep(5000);
		logger.info("***Test case 1 is started***");
		hp.userclick();
		logger.info("***user icon is clicked***");
		Thread.sleep(5000);
		logger.info("***getting user name***");
		hp.getUserName();
		System.out.println("UserName: "+hp.getUserName());

		Thread.sleep(5000);
		logger.info("***getting user mail***");
		hp.getUserMail();
		System.out.println("UserMail: "+hp.getUserMail());
		
       }
       catch(Exception e) 
       
       {
		logger.error("***test case 1 got failed***");
		Assert.fail();
	} 
  }
}


