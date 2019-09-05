import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Servicestest {
	WebDriver driver;
	@BeforeMethod
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");  
	    driver=new ChromeDriver();
	    driver.get("file:///C:/Selenium%20Software/Selenium%20Automation%20PROJECT%20for%20offline%20Website/services.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	 }
	@Test
	public void verifyUrl()
	{
		String myUrl=driver.getCurrentUrl();
		System.out.println("myurl is"+myUrl);
		String expected="file:///C:/Selenium%20Software/Selenium%20Automation%20PROJECT%20for%20offline%20Website/services.html";
		Assert.assertEquals(myUrl, expected);
		System.out.println("************");
	}
	@Test
   public void verifyTitle()
   {
		String myTitle=driver.getTitle();
		System.out.println("my title is:"+myTitle);
		String exceptedTitle="Services | Java By Kiran";
		Assert.assertEquals(myTitle, exceptedTitle);
		System.out.println("****************");
   }
	@Test
	public void verifyLogo()
	{
		boolean flag=driver.findElement(By.xpath("//h1[text()='Services']")).isDisplayed();
		System.out.println("is logo displayed?"+flag);
	}
	@Test
	public void check_Links() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		System.out.println("............");
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());

		}
	}
	@Test
	public void verifyFacebookLink()
	{
		
		WebElement element=driver.findElement(By.xpath("//a[@href='https://www.facebook.com/javabykiran']"));
		element.click();
		System.out.println("is link enabled?"+element.isEnabled());
		
		
	}
	@Test
	public void verifyTwitter()
	{
		driver.findElement(By.xpath("//a[@href='https://www.twitter.com/javabykiran']")).click();
	}
	@Test
	public void verifyGoogle()
	{
		driver.findElement(By.xpath("//a[@href='https://plus.google.com/+JavabyKiran']")).click();
	}
	
	@Test
	public void verifyTouTube()
	{
		driver.findElement(By.xpath("//a[@href='https://www.youtube.com/channel/UCZoq1kylnMYP_c5WG9FV9XA']")).click();
	}
	@Test
	public void verifyFacebookIcon()
	{
		boolean flag=driver.findElement(By.xpath("//i[@class='icon-social-facebook']")).isDisplayed();
		System.out.println("is icon is displayed?"+flag);
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
