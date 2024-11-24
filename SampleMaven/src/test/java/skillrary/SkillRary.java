package skillrary;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SkillRary {
@Test
public void skillrary()
{
	
	String url = System.getProperty("url");
	String email = System.getProperty("email");
	String password = System.getProperty("password");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(url);
	driver.findElement(By.linkText("LOGIN")).click();
	driver.findElement(By.id("email")).sendKeys(email);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("last")).click();
}
}
