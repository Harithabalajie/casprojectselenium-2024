package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NewsDisplayPage;
import testBase.BaseClass;
@Test
public class TC_HyperLinks extends BaseClass
{

	public void Links () throws InterruptedException
	{   
	  boolean check=false;
	  int count=0;
	  logger.info("***Test case HyperLinks is started***");
	  NewsDisplayPage np=new NewsDisplayPage(driver);
		List<WebElement>NewsList=np.newsList;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		for(int i=0;i<NewsList.size()-1;i++) {
		NewsList.get(i).click();
	    Thread.sleep(6000);
	    logger.info("***getting hyperlinks***");
		List<WebElement> links =np.link;
		if(links.size()==0) {
			driver.navigate().back();
		}
		else {
		for (WebElement link : links) {
			logger.info("***Validating the share options***");
			    Assert.assertTrue(link.isEnabled());
			    check=true;
			    if(check) {
			    count++;
			    }
			    else {
			    	count=0;
			    }   
			}	
		driver.navigate().back();
		}
		}
		if(count==0) {
			System.out.println("Not Valid");
		}
		else {
			System.out.println("All links are Valid");
		}
}	
}
