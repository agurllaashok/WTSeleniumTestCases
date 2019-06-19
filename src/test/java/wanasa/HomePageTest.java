	package wanasa;
	import utils.BrowserFunctions;
import utils.CommonMethods;

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
		
		HomePage ss= new HomePage();
		User us= new User();
			
		@Test(priority=0)
		public void verifylogin() throws InterruptedException  
		{			
			ss.clickSignInButton();
			String emptypwd = ss.singInWithEmptyPassword();
			Assert.assertEquals(emptypwd,"Enter a password");
			String invalidinput= ss.singInWithincorrectcredentials();
			Assert.assertEquals(invalidinput,"Invalid credentials" );
			String afterlogin = ss.signinWanasaTimeCredentials();
			Assert.assertEquals(afterlogin, "http://staging.wanasatime.com/");						
		}
		
		@Test(priority=1)
		public void verifybookticketevents() throws InterruptedException 
		{
			ss.countrySelection();	
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL,"http://staging.wanasatime.com/Home.aspx?country=Bahrain" );
			//Thread.sleep(4000);
			String success =ss.BookTicketevents();
			Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");				
			//Thread.sleep(3000);
		}
	    
	}

