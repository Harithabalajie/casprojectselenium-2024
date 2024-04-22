package testCases;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.NewsDisplayPage;
import testBase.BaseClass;

public class TC_likeAndViews extends BaseClass{
  @Test
	
	public void likesandviews() throws InterruptedException  
	{    
	    logger.info("***Test case likeAndViews is started***");
	    NewsDisplayPage np=new NewsDisplayPage(driver);
		List<WebElement>NewsList=np.newsList;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		for(int i=0;i<NewsList.size()-1;i++) {
		NewsList.get(i).click();
	    Thread.sleep(6000);
	    logger.info("***Scroll***");
		WebElement scrollElement = np.scroll;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[1];",scrollElement, 4000);
		Thread.sleep(8000);
		logger.info("***Printing Number of likes***");
		np.getLikes();
		System.out.println("Total Likes:"+np.getLikes());
		Thread.sleep(5000);
		logger.info("***Printing Number of views***");
		np.getViews();
		System.out.println("Total Views:"+np.getViews());
		driver.navigate().back();
		
		}
	}
}