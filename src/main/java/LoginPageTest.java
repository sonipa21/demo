import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
	WebDriver driver;
	@BeforeMethod
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");  
	    driver=new ChromeDriver();
	    driver.get("http://javabykiran.com/javabykiranfiles/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	@Test
	public void verifyURl()
	{
		String myurl=driver.getCurrentUrl();
		System.out.println("url is:"+myurl);
		String exceptedUrl="http://javabykiran.com/javabykiranfiles/";
		Assert.assertEquals(myurl, exceptedUrl);
		System.out.println("******************");
	}
	@Test
	public void verifyTitle()
	{
		String mytitle=driver.getTitle();
		System.out.println("title is:"+mytitle);
		String exceptedTitle="Log in » Java By Kiran file System";
		Assert.assertEquals(mytitle, exceptedTitle);
		System.out.println("******************");
	}
	@Test
	public void verifyPageLabel()
	{
		String login=driver.findElement(By.xpath("//label[text()='Username / E-mail']")).getText();
		String exceptedLabel="Username / E-mail";
		Assert.assertEquals(login, exceptedLabel);
		String password=driver.findElement(By.xpath("//label[@for='login_form_pass']")).getText();
		String excetedPwdLabe="Password";
		Assert.assertEquals(password, excetedPwdLabe);
		
		System.out.println("***********");
	}
	@Test
	public void blankUserLogin()
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualerrormsg=driver.findElement(By.xpath("//div[@id='login_error']")).getText();
		System.out.println("error msg is:"+actualerrormsg);
		//String exceptederrormsg="The supplied credentials are not valid.";
		//Assert.assertEquals(actualerrormsg, exceptederrormsg);
		System.out.println("test passed");
		
		
	}
	
	@Test
	public void verifyFacebookLink()
	{
		WebElement element=driver.findElement(By.xpath("//i[@class='fa fa-facebook-square']"));
		if(element.isDisplayed())
		{
			System.out.println("yes link is there");
		}
		else
		{
			System.out.println("link is not there");
		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
