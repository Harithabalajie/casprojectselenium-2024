package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    //Constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//WebElements
	
	//Userdetails
    @FindBy(xpath="//div[@class='ohcfXYh6LUBy5DS5kNUjRQ==']")
	WebElement ele1;
	@FindBy(id="mectrl_currentAccount_primary")
	WebElement UN;
	@FindBy(id="mectrl_currentAccount_secondary")
	WebElement UM; 

	//NewsList
	@FindBy(xpath="//*[@id=\"vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf\"]//*[@id=\"news_text_title\"]")
	public List<WebElement> news;
		 
	//Action Methods	
    public void userclick() throws InterruptedException 
    {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		Actions a=new Actions(driver);
		a.doubleClick(ele1).perform();    	
	}
	public String getUserName()
	{
		String UserName=UN.getText();
		return UserName;
		
	}

	public String getUserMail()
	{
		
		String UserMail=UM.getText();
		return UserMail;
		
	}
	
}


