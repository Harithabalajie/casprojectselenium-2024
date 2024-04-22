package testCases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.NewsDisplayPage;
import testBase.BaseClass;

public class TC_NewsTooltipValidation extends BaseClass{

	@Test
	public void Tooltip() throws InterruptedException 
	{
		try {
		logger.info("***Test case NewsTooltipValidation is started***");
		// Instantiate NewsDisplayPage
        NewsDisplayPage newsDisplayPage = new NewsDisplayPage(driver);
        Thread.sleep(5000);
        // Get news headers and tooltips
        Map<String, String> newsData = newsDisplayPage.getNewsHeadersAndTooltips();
        logger.info("Validating news header and tooltip");
        // Assert the news headers and tooltips
        for (Map.Entry<String, String> entry : newsData.entrySet()) {
            Assert.assertEquals(entry.getKey(), entry.getValue(), "Mismatch between news header and tooltip.");
        }
        System.out.println("Displayed newsheader and tooltip are valid");
		}catch( Exception e) {
			logger.error("***Test case NewsTooltipValidation failed: Exception occurred***", e);
			e.printStackTrace();
			Assert.fail("Test case failed");
		}
	}
}
