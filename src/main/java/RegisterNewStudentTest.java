import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterNewStudentTest {
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
	public void verifyResisterAccount()
	{
		driver.findElement(By.linkText("Register as a new student.")).click();
		Xls_Reader reader=new Xls_Reader("C:\\JBK Eclipse Configured 32-bit\\JBKSite\\JBKcontacts.xlsx");
		   String name= reader.getCellData("Sheet2", "name", 2);
		   System.out.println(name);
		   String username= reader.getCellData("Sheet2", "username", 2);
		   System.out.println(username);
		   String password= reader.getCellData("Sheet2", "password", 2);
		   System.out.println(password);
		   String email= reader.getCellData("Sheet2", "email", 2);
		   System.out.println(email);
		   String batchname= reader.getCellData("Sheet2", "batchname", 2);
		   System.out.println(batchname);
		   String Mobile= reader.getCellData("Sheet2", "Mobile", 2);
		   System.out.println(Mobile);
		   driver.findElement(By.id("add_client_form_name")).sendKeys(name);
		   driver.findElement(By.id("add_client_form_user")).sendKeys(username);
		   driver.findElement(By.id("add_client_form_pass")).sendKeys(password);
		   driver.findElement(By.id("add_client_form_email")).sendKeys(email);
		   driver.findElement(By.id("add_client_form_address")).sendKeys(batchname);
		   driver.findElement(By.id("add_client_form_phone")).sendKeys(Mobile);
		   driver.findElement(By.id("add_client_form_notify")).click();
		   driver.findElement(By.xpath("//button[@type='submit']")).click();   
	}
	
	@Test
	public void verifyPageURl()
	{
		driver.findElement(By.linkText("Register as a new student.")).click();
		String myurl=driver.getCurrentUrl();
		System.out.println("url is"+myurl);
		String exceptedurl="http://javabykiran.com/javabykiranfiles/register.php";
		Assert.assertEquals(myurl, exceptedurl);
		System.out.println("****************");
	}
	@Test
	public void verifyPageTitle()
	{
		driver.findElement(By.linkText("Register as a new student.")).click();
		String mytitle=driver.getTitle();
		System.out.println("title is:"+mytitle);
		String exceptedTitle="Register new account » Java By Kiran file System";
		Assert.assertEquals(mytitle, exceptedTitle);
		System.out.println("******************");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
