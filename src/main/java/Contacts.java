import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Contacts {
	WebDriver driver;
	@BeforeMethod
	public void init()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");  
	    driver=new ChromeDriver();
	    driver.get("file:///C:/Selenium%20Software/Selenium%20Automation%20PROJECT%20for%20offline%20Website/java-classes-contact-pune.html");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	@Test
	public void verifyContactUs()
	{
		Xls_Reader reader=new Xls_Reader("C:\\JBK Eclipse Configured 32-bit\\JBKSite\\JBKcontacts.xlsx");
		   String name= reader.getCellData("Sheet1", "name", 2);
		   System.out.println(name);
		   String email= reader.getCellData("Sheet1", "email", 2);
		   System.out.println(email);
		   String mobileno= reader.getCellData("Sheet1", "mobileno", 2);
		   System.out.println(mobileno);
		   String regarding= reader.getCellData("Sheet1", "regarding", 2);
		   System.out.println(regarding);
		   String message= reader.getCellData("Sheet1", "message", 2);
		   System.out.println(message);
		   driver.findElement(By.id("name")).sendKeys(name);
		   driver.findElement(By.name("email")).sendKeys(email);
		   driver.findElement(By.name("mob")).sendKeys("8484061096");
		   Select select=new Select(driver.findElement(By.xpath("//select[@name='regarding']")));
		   select.selectByVisibleText(regarding);
		   driver.findElement(By.id("message")).sendKeys(message);
		   driver.findElement(By.xpath("//button[@type='submit']")).click();
		   System.out.println("submitted");
			   
	}
	
	@Test
	public void check_Button_color() {
		
			WebElement signbtn = driver.findElement(By.xpath("//button[@type='submit']"));
			System.out.println("befor mouse over button color is "+ signbtn.getCssValue("background-color"));
			Actions act = new Actions(driver);
			act.moveToElement(signbtn).build().perform();
			System.out.println("after mouse over button color "+ signbtn.getCssValue("color"));
			System.out.println("*******************");
		}
	@Test
	public void verifyBlankContacts() throws InterruptedException
	{
		driver.findElement(By.id("name")).sendKeys(" ");
		   driver.findElement(By.name("email")).sendKeys(" ");
		   driver.findElement(By.name("mob")).sendKeys("");
		   Select select=new Select(driver.findElement(By.xpath("//select[@name='regarding']")));
		   select.selectByVisibleText("Other");
		   driver.findElement(By.id("message")).sendKeys(" ");
		  WebElement element= driver.findElement(By.xpath("//button[@type='submit']"));
		  element.click();	  
		   
	}
	@Test
	public void veriyLogo()
	{
		
		String actualtext=driver.findElement(By.cssSelector("#bannerleft > h1")).getText();
		String exceptedtext="Contact Us";
		Assert.assertEquals(actualtext, exceptedtext);
		System.out.println("***********");
		
	}
	@Test
	public void verifyImagePresent()
	{
		WebElement element=driver.findElement(By.xpath("//img[@itemprop='thumbnail']"));
		 Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
	        if (!ImagePresent)
	        {
	             System.out.println("Image not displayed.");
	        }
	        else
	        {
	            System.out.println("Image displayed.");
	        }
	}
	
	
	

}
