package bike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BajajTest {
	@Test
	public void launch()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bikewale.com/bajaj-bikes/cng-freedom-125/");
	}
}
