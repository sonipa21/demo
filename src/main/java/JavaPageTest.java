import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaPageTest {
	WebDriver driver;
	@BeforeMethod
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");  
	    driver=new ChromeDriver();
	    driver.get("file:///C:/Selenium%20Software/Selenium%20Automation%20PROJECT%20for%20offline%20Website/core-java-j2eee-syllabus.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	 }
	@Test
	public void ClickOnJavaSyallabus()
	{
		driver.findElement(By.cssSelector("#cssmenu > ul > li:nth-child(3) > a")).click();
		String myurl=driver.getCurrentUrl();
		System.out.println("url is:"+myurl);
		String exceptedurl="file:///C:/Selenium%20Software/Selenium%20Automation%20PROJECT%20for%20offline%20Website/core-java-j2eee-syllabus.html";
		Assert.assertEquals(myurl, exceptedurl);
		System.out.println("*********");
		
	}
	@Test
	public void verifyPageTitle()
	{
		String myurl=driver.getTitle();
		System.out.println("page title is :"+myurl);
		String exceptedTitle="Core Java J2EE Syllabus | Java By Kiran";
		Assert.assertEquals(myurl, exceptedTitle);
		System.out.println("*******");
	}
	@Test
	public void verifyShareLogo() throws InterruptedException
	{
		
		driver.findElement(By.xpath(".//*[@id='whatsapp']")).click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
	}
	@Test
	public void verifyLogo() throws InterruptedException
	{
		boolean flag=driver.findElement(By.xpath("//h1[text()='Java-J2EE Syllabus']")).isDisplayed();
		System.out.println("is logo displayed?"+flag);
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
