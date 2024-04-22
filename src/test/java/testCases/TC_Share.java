package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.NewsDisplayPage;
import testBase.BaseClass;

public class TC_Share extends BaseClass{

@Test
	public void shareButton() throws InterruptedException
	{
	logger.info("***Test case Share is started***");
	NewsDisplayPage np=new NewsDisplayPage(driver);
	List<WebElement>NewsList=np.newsList;
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Thread.sleep(5000);
	for(int i=0;i<NewsList.size()-1;i++) {
	    NewsList.get(i).click();
        Thread.sleep(5000);;
        np.share.click();
    	Thread.sleep(6000);
    	logger.info("***Validating the share options***");
		System.out.println("Share Options : ");
		for(int j=0;j<np.opt.size();j++)
		{
			String option= np.opt.get(j).getText();
			System.out.println(option);
				
		}
	    driver.navigate().back();
	    System.out.println("=============================================================================================================================================");				

	    }
    }
}
	
	

