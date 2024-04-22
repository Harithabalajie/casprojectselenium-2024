package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NewsDisplayPage extends BasePage{

	//Constructor
	public NewsDisplayPage (WebDriver driver)
	{
		super(driver);
	}
	
	//WebElements
	//list of news
	@FindBy(xpath="//*[@id=\"vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf\"]//*[@id=\"news_text_title\"]")
	public List<WebElement> newsList;
	//print newsdata
	@FindBy(xpath="//*[@id=\"fa45f946-463e-428f-a84b-0bbbde09c3ba\"]/div/div/div") 
     public WebElement para;
	//associate details
	@FindBy(xpath="//*[@id=\"vpc_WebPart.NewsWebPart.internal.4f7e87d5-f184-4501-8008-0ee4b0a38fcf\"]//*[@id=\"news_text_title\"]")
	public List<WebElement> news;
	@FindBy(xpath="//div[@data-automation-id='personaDetails']")
	
	public WebElement userdetails;
    @FindBy(xpath="//*[@id=\\\"vpc_WebPart.PageTitle.internal.cbe7b0a9-3504-44dd-a3a3-0e5cacd07788\\\"]/div/div[1]/div/div/div[2]/div/div/div/div[1]/div/div/img")
    public WebElement useraction;
    //shareoptions
   // @FindBy(xpath="//*[@id=\"spCommandBar\"]/div/div/div/div/div/div[2]/div[1]/button/span/i[2]") 
    @FindBy(xpath="//*[@id=\"share\"]") 
    public WebElement share;
	@FindBy(xpath="//*[contains(@class,\"ms-ContextualMenu-itemText label\")]") 
	public List<WebElement>opt;
   //likes and Views
	@FindBy(xpath="//*[@data-automation-id=\"contentScrollRegion\"]") 
	public WebElement scroll;
    @FindBy(xpath="//span[contains(text(),'people liked this')]") 
    public WebElement likes;
    @FindBy(xpath="//span[contains(text(),'Views')]") 
    public WebElement views;
    //hyperlinks
    @FindBy(xpath="//*[@id='spPageCanvasContent']/div/div/div/div/div/div/div/div[1]//p//a")
    public List<WebElement>link;

//Action Methods
public void asso() throws InterruptedException
{
	Actions act = new Actions(driver);
	Thread.sleep(5000);
	WebElement user = userdetails;
	Thread.sleep(5000);
	act.moveToElement(user).build().perform();
}
// Method to retrieve news list
public List<WebElement> getNewsList() {
	List<WebElement> listOfNews = new ArrayList<>();
	listOfNews=newsList;
	return listOfNews;
}

// Method to retrieve tooltip list
public List<WebElement> getNewsTooltipList() {
	List<WebElement> listOfToolTip = new ArrayList<>();
	listOfToolTip=newsList;
	return listOfToolTip;
    
}

// Action method to get news headers and tooltips
public Map<String, String> getNewsHeadersAndTooltips() {
    Map<String, String> newsData = new HashMap<>();
    try {
        List<WebElement> newsList = getNewsList();
        List<WebElement> tooltipList = getNewsTooltipList();
        for (int i = 0; i < Math.min(newsList.size(), tooltipList.size()); i++) {
            newsData.put(newsList.get(i).getText(), tooltipList.get(i).getAttribute("title"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return newsData;
}

//Action method to validate the display of news items
public boolean validateNewsDisplay() {
    // Get the list of news items
    List<WebElement> newsList = getNewsList();

    // Validate each news item
    for (WebElement newsDisplay : newsList) {
        // If any news item is not displayed, return false
        if (!newsDisplay.isDisplayed()) {
            return false;
        }
    }

    // If all news items are displayed, return true
    return true;
}

public String getLikes()
{
	String l1=likes.getText();
	return l1;
}
public String getViews()
{

	String v1=views.getText();
	return v1;
}
public String newsData()
{
	String p1=para.getText();
	return p1;
}
}
    
