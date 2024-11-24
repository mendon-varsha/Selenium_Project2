package extentreport;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ToAttachScreenShot {
@Test
public void addScreenshot()
{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://www.flipkart.com/");
	
	String timeStamp = LocalDateTime.now().toString().replace(":","-");
	TakesScreenshot ts=(TakesScreenshot) driver;
	String photo = ts.getScreenshotAs(OutputType.BASE64);
	
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/"+timeStamp+".html");
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("Extent Report");
	ExtentReports extreport=new ExtentReports();
	extreport.attachReporter(spark);
	
	ExtentTest test = extreport.createTest("addScreenshot");
	test.log(Status.PASS, "adding screenshot to the report");
	test.addScreenCaptureFromBase64String(photo);
	extreport.flush();
	
	
}
}
