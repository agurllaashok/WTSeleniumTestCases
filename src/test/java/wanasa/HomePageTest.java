	package wanasa;
	import utils.BrowserFunctions;

	import java.util.HashMap;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.remote.CapabilityType;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Ignore;
	import org.testng.annotations.Test;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	public class HomePageTest extends BrowserFunctions{
		public static WebDriver driver;		
		
	    @Test
		public void ticketbooking()
		{
	    	HomePage ss= new HomePage();
	    	ss.CountrySelection();
	    	ss.SigninWanasaTimeCredentials();
			ss.BookTicket();
			Assert.assertEquals(ss.successMsg(), "Congratulations! Your Tickets was confirmed.");
			System.out.println("ticketbooked");
		} 		  
	}

