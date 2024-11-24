package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MavenParameterTest {
@Test
public void launch()
{
	String url = System.getProperty("url");
	String email = System.getProperty("email");
	String password = System.getProperty("password");
	
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.findElement(By.linkText("Log in")).click();
	driver.findElement(By.id("Email")).sendKeys(email);
	driver.findElement(By.id("Password")).sendKeys(password);
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
	if(driver.getCurrentUrl().equals("https://demowebshop.tricentis.com/"))
	{
		Reporter.log("Login successful",true);
	}
	
}
}
