import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");  
	    driver=new ChromeDriver();
	    driver.get("file:///C:/Selenium%20Software/Selenium%20Automation%20PROJECT%20for%20offline%20Website/index.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	@Test
	public void verifyPageURL()
	{
		//actual url
		String myurl=driver.getCurrentUrl();
		System.out.println("url is"+myurl);
		//excepted url
		String exceptedUrl="file:///C:/Selenium%20Software/Selenium%20Automation%20PROJECT%20for%20offline%20Website/index.html";
		Assert.assertEquals(myurl, exceptedUrl);
		System.out.println("****************");
		
	}
	
	@Test
	public void verifyPageTitle()
	{
		String mytitle=driver.getTitle();
		System.out.println("title is:"+mytitle);
		String exceptedTitle="Best Industrial Java Classes | Selenium Training in Pune";
		Assert.assertEquals(mytitle, exceptedTitle);
		System.out.println("******************");
		
	}
	@Test
	public void verifyLogoTest()
	{
		boolean flag =driver.findElement(By.xpath("//h1[text()='Java By Kiran']")).isDisplayed();
		System.out.println("is logo displayed?"+flag);
		System.out.println("****************");
	}
	@Test
	public void verifyText()
	{
		boolean flag=driver.findElement(By.xpath("//strong[text()='Java & Selenium Training Institute']")).isDisplayed();
		System.out.println("is text is displayed?"+flag);
		System.out.println("***********");
	}
	@Test
	public void clickOnVideosTest()
	{
		boolean flag=driver.findElement(By.xpath("//input[@type='button']")).isEnabled();
		System.out.println("is button enabled?"+flag);
	}
	@Test
	public void verifyEnquiryText()
	{
		boolean flag=driver.findElement(By.xpath(".//*[@id='mainright']/h4[1]")).isDisplayed();
		System.out.println("is text displaed?"+flag);
		System.out.println("**************");
	}
	@Test
	public void verifyPhoneImage()
	{
		boolean flag=driver.findElement(By.xpath("//i[@class='icon-old-phone']")).isDisplayed();
		System.out.println("is phone icon displayed?"+flag);
		System.out.println("******************");
	}
	@Test
	public void verifyMobileNumberTest()
	{
		boolean flag=driver.findElement(By.xpath("//a[@href='tel:+91-7066885937']")).isDisplayed();
		System.out.println("is mobile number displayed?"+flag);
	}
	@Test
	public void verifyStudentFeedbackLink() 
	{
		
		boolean flag=driver.findElement(By.cssSelector("#news > h2 > a")).isEnabled();
		System.out.println("feedback link is enabled:"+flag);
		System.out.println("*********");
	}
	@Test
	public void verifySeleniumSyllabusLink()
	{
		boolean flag=driver.findElement(By.cssSelector("#news > h2 > a")).isEnabled();
		System.out.println("selenium syllabus link is clickable"+flag);
		System.out.println("***********");
	}
	
	@Test
	public void clickOnAbout()
	{
		boolean flag=driver.findElement(By.cssSelector("#cssmenu > ul > li:nth-child(2) > a")).isEnabled();
		System.out.println("is about us enabled?"+flag);
	}
	
	@Test
	public void check_Button_color() {
		
			WebElement signbtn = driver.findElement(By.cssSelector("#news > h2 > a"));
			System.out.println("befor mouse over button color is "+ signbtn.getCssValue("background-color"));
			Actions act = new Actions(driver);
			act.moveToElement(signbtn).build().perform();
			System.out.println("after mouse over button color "+ signbtn.getCssValue("color"));
			System.out.println("*******************");
		}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
