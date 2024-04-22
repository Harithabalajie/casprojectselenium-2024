package testCases;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NewsDisplayPage;
import testBase.BaseClass;

public class TC_NewsValidation extends BaseClass{
	
  
    List<WebElement>newsList;
    @Test
	public void newsValid() throws InterruptedException 
	{
    	try 
    	{
    		logger.info("***Test case NewsValidation is started***");
    		 
    		// Instantiate the news display page
    		NewsDisplayPage newsDisplayPage = new NewsDisplayPage(driver);
    		Thread.sleep(5000);
    		logger.info("Validating news are displayed or not...");
    		// Validate news display
    	    boolean isNewsDisplayed = newsDisplayPage.validateNewsDisplay();
    		 
    		// Assertion to verify that news items are displayed
    		Assert.assertTrue(isNewsDisplayed, "Not all news items are displayed on the news display page");
    		logger.info("All news items are displayed on the news display page");
    		 System.out.println("News displayed are valid");
    		 } catch (Exception e) {
    		 logger.error("***Test case NewsValidation failed: Exception occurred***", e);
    		 Assert.fail("Test case NewsValidation failed: Exception occurred : " + e.getMessage());
    		 }
    }
    	
}


