package testCases;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.NewsDisplayPage;
import testBase.BaseClass;

public class TC_News_Data extends BaseClass{
	

	@Test
	public void newsValid() throws InterruptedException
	{
	try
	{
		logger.info("***Test case NewsData is started***");
		np=new NewsDisplayPage(driver);
		Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    List<WebElement>newsInfo=np.newsList;
	
	 for(int i=0;i<newsInfo.size()-1;i++)
	 { 
		
	   logger.info("***getting news list***");
	   newsInfo.get(i).click();
	   System.out.println("TITLE:"+newsInfo.get(i).getText()+"\n");
	   np.newsData();
	   System.out.println(np.newsData()+"\n");
	   driver.navigate().back();
	 }
	}
	catch(Exception e)
		{
		logger.error("***Test case NewsData gets failed***");
		System.out.println(e);
		}
	

}}
