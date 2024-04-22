package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObjects.HomePage;
import pageObjects.NewsDisplayPage;

public class BaseClass {
	
	static public WebDriver driver;
	public Properties p;
	public static TakesScreenshot ts;
	public Logger logger;
	public HomePage hp;
	public NewsDisplayPage np;
	
	 @BeforeClass
	 @Parameters({"browser"})
	  public void setUp(String br) throws InterruptedException, IOException {
		 
		 //Loading log4j2 file

			logger=LogManager.getLogger(this.getClass());
			
		 //Loading properties file
			FileReader file = new FileReader("C:\\Users\\2318420\\Downloads\\CAS_Project - Quantum QEA\\Featured news\\FeaturedNews\\website.properties");
			p = new Properties();
			p.load(file);
			
         //Launching browser based on condition
			if(br.equalsIgnoreCase("chrome")) {
			  driver = new ChromeDriver();
			 
			 }
			 else if(br.equalsIgnoreCase("edge")){
				  driver = new EdgeDriver();
				
			 }
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.get(p.getProperty("baseURL"));
     
}
	 //ScreenShot
	 public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

	 }

    @AfterClass
    public void tearDown()
    {
    	driver.quit();
    }


    

    
}
