import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VideosTest {
	WebDriver driver;
	@BeforeMethod
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");  
	    driver=new ChromeDriver();
	    driver.get("file:///C:/Selenium%20Software/Selenium%20Automation%20PROJECT%20for%20offline%20Website/java-by-kiran-videos.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	 }
	@Test
	public void check_Button_color() {
		
			WebElement signbtn = driver.findElement(By.xpath("//input[@type='button']"));
			System.out.println("befor mouse over button color is "+ signbtn.getCssValue("background-color"));
			Actions act = new Actions(driver);
			act.moveToElement(signbtn).build().perform();
			System.out.println("after mouse over button color "+ signbtn.getCssValue("color"));
			System.out.println("*******************");
		}
	@Test
	public void verifyTitle()
	{
		String mytitle=driver.getTitle();
		System.out.println("title is:"+mytitle);
		String exceptedTitle="Java-J2EE Videos | Java By Kiran";
		Assert.assertEquals(mytitle, exceptedTitle);
		System.out.println("****************");
	}
	@Test
	public void verifyLogoTest()
	{
		boolean flag=driver.findElement(By.xpath("//h1[text()='Java-J2EE Videos']")).isDisplayed();
		System.out.println("is logo displayed?"+flag);
	}
	@Test
	public void searchTest() throws InterruptedException
	{
		WebElement search=driver.findElement(By.xpath("//input[@id='youmax-search-box']"));
		search.sendKeys("constructor",Keys.ENTER);
		WebElement element=driver.findElement(By.xpath("//select[@id='youmax-select']"));
		Select s=new Select(element);
		Thread.sleep(2000);
		s.selectByVisibleText("Videos");
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}

}
