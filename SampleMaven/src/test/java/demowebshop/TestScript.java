package demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestScript {
@Test
public void demo()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
	Assert.assertEquals(driver.getTitle(),"Demo Web Shop","Welcome page not displayed");
	Reporter.log("Welcome page displayed",true);
	
	driver.findElement(By.linkText("Log in")).click();
	Assert.assertEquals(driver.getCurrentUrl(),"https://demowebshop.tricentis.com/login","Login page not displayed");
	Reporter.log("Login page displayed",true);
	
	driver.findElement(By.id("Email")).sendKeys("mendonvarsha11@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("123456");
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
	
	Assert.assertEquals(driver.getTitle(),"Demo Web Shop","Home page not displayed");
	Reporter.log("Home page displayed",true);
	
	TakesScreenshot ts=(TakesScreenshot) driver;
	String photo = ts.getScreenshotAs(OutputType.BASE64);
	
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/demo.html");
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("Demo Web Shop");
	ExtentReports extreport=new ExtentReports();
	extreport.attachReporter(spark);
	 ExtentTest test = extreport.createTest("demo");
	 test.log(Status.PASS, "Log message added to report");
	 test.addScreenCaptureFromBase64String(photo);
	 extreport.flush();
}
}
