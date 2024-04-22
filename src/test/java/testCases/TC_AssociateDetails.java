package testCases;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NewsDisplayPage;
import testBase.BaseClass;

public class TC_AssociateDetails extends BaseClass {
     @Test
    	 public void Details() throws InterruptedException  
    	 {   
    	     logger.info("***Test case AssociateDetails is started***");
    	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	     Thread.sleep(8000);
    	     np=new NewsDisplayPage(driver);
    		 boolean flag = false;
    		 List<WebElement>NewsList=np.news;
    			
    		 for(int i=0;i<NewsList.size()-1;i++)
    		 {
    		    logger.info("***Hovering to associate details***");
    		    NewsList.get(i).click();
          		np.asso();
    			try {
    				logger.info("***Validating the associate details***");
    				np.userdetails.isDisplayed();
    				flag=true;
    			    driver.navigate().back();
    			 }
    			 catch  (Exception e) {
    				logger.error("***Test case AssociateDetails failed***");
    				flag=false;
    				System.out.println("User details is not displayed in popup when hovered");
    			 }
    	     }
    		 Assert.assertEquals(flag,true);
    		 System.out.println("User details is displayed in popup when hovered");
    		 System.out.println("=============================================================================================================================================");				

      }
 }
	

		
 