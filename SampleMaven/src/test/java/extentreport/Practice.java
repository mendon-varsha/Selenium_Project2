package extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Practice {
public void report()
{
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/report.html");
	ExtentReports report=new ExtentReports();
	report.attachReporter(spark);
	ExtentTest test = report.createTest("report");
	test.log(Status.PASS,"log message displayed");
	report.flush();
}
}
