package extentreport;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReport {
@Test
public void report()
{
	String timeStamp = LocalDateTime.now().toString().replace(":","-");
	//create instance of ExtentSparkReporter
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/"+timeStamp+".html");
	
	//create instance of ExtentReports
	ExtentReports extentReport=new ExtentReports();
	
	//attach instance of ExtentSparkReporter to ExtentReports
	extentReport.attachReporter(spark);
	
	//create instance of ExtentTest
	ExtentTest test=extentReport.createTest("report");
	
	//call log() to provide status and message
	test.log(Status.PASS, "log message added to report");
	
	//call flush() to write messages to destination
	extentReport.flush();
}
}
