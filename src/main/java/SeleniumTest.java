import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	WebDriver driver;
	@BeforeMethod
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");  
	    driver=new ChromeDriver();
	    driver.get("file:///C:/Selenium%20Software/Selenium%20Automation%20PROJECT%20for%20offline%20Website/selenium-testing-in-pune.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	 }
	@Test
	public void verifyPageUrl()
	{
		String myurl=driver.getCurrentUrl();
		System.out.println("current url is:"+myurl);
		String exceptedUrl="file:///C:/Selenium%20Software/Selenium%20Automation%20PROJECT%20for%20offline%20Website/selenium-testing-in-pune.html";
		Assert.assertEquals(myurl, exceptedUrl);
		System.out.println("**************8");
	}
	@Test
	public void verifyPageTitle()
	{
		String myTitle=driver.getTitle();
		System.out.println("title is:"+myTitle);
		String exceptedTitle="Selenium Webdriver Classes Pune | Java By Kiran";
		Assert.assertEquals(myTitle, exceptedTitle);
		System.out.println("*****************");
	}
	
	@Test
	public void verifyLogo()
	{
		boolean flag=driver.findElement(By.xpath("//h1[text()='Selenium Testing']")).isDisplayed();
		System.out.println("is logo displayed?"+flag);
	}
	
	@Test
	public void verifyDownloading()
	{
		driver.findElement(By.cssSelector("#bannerleft > span > a")).click();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		
	}

}
