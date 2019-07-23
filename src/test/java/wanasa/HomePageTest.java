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
		public void verifysignup() throws InterruptedException
		{
			logger_ss = extent.createTest("verifysignup");
			String sucessmsg = ss.signup();
			Assert.assertEquals(sucessmsg, "You have successfully registered. We have sent a verification email to you.");
			driver.navigate().to("http://staging.wanasatime.com/");
			logger_ss.log(Status.INFO, "signup done successfully.");
		}
		
		@Test(priority=1)
		public void verifyforgotpassword() throws InterruptedException
		{
			logger_ss = extent.createTest("verifyforgotpassword");
			String checksuccessmsg= ss.forgotpassword();
			Assert.assertEquals(checksuccessmsg, "We have sent a mail to you.Please check your mail.");
			logger_ss.log(Status.INFO, "Successfully verified forgot password.");
			
		}
		 
		@Test(priority=2)  
		public void verifylogin() throws InterruptedException  
		{	
			logger_ss = extent.createTest("verifylogin");
			//driver.navigate().to("http://staging.wanasatime.com/");
			ss.clickSignInButton();
			/*String emptypwd = ss.singInWithEmptyPassword();
			Assert.assertEquals(emptypwd,"Enter a password");
			String invalidinput= ss.singInWithincorrectcredentials();
			Assert.assertEquals(invalidinput,"Invalid credentials" );*/
			String afterlogin = ss.signinWanasaTimeCredentials();
			Assert.assertEquals(afterlogin, "http://staging.wanasatime.com/");	
			logger_ss.log(Status.INFO, "Successfully verified login functionality.");
			
		}
		
		
		// single day event
	//	@Test(priority=3)
		public void verifyeventbookvisa() throws InterruptedException 
		{
			logger_ss = extent.createTest("verifyeventbookvisa");
			ss.countrySelectionqar();				
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			String success =ss.eventbookvisa();
			Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");
			logger_ss.log(Status.INFO, "Successfully verified bookticketevents(visa qatar).");
		}
		
		//multiple day event
	//	@Test(priority=4)
		public void verifyeventbookmaster() throws InterruptedException 
		{
			logger_ss = extent.createTest("verifyeventbookmaster");
			ss.countrySelectionqar();				
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			String success =ss.eventbookmaster();
			Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");
			logger_ss.log(Status.INFO, "Successfully verified bookticketevents(master qatar).");
		}
		
		//free ticket booking
	//	@Test(priority=5)
		public void verifybookticketevents() throws InterruptedException 
		{
			logger_ss = extent.createTest("verifybookticketevents");
			ss.countrySelection();	
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL,"http://staging.wanasatime.com/Home.aspx?country=Bahrain" );
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			String success =ss.BookTicketevents();
			Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");
			logger_ss.log(Status.INFO, "Successfully verified bookticketevents(free ticket).");
		}
		
		
		//multi days sub cat
		@Test(priority=6)
		public void verifyeventticketBookingWithDebitCard() throws InterruptedException
			{
			logger_ss = extent.createTest("verifyeventticketBookingWithDebitCard");
			//driver.navigate().to("http://staging.wanasatime.com");
			//ss.clickSignInButton();
			//ss.signinWanasaTimeCredentials();
			ss.countrySelection();
			String success =ss.eventticketBookingWithDebitCard();
			Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");	
			logger_ss.log(Status.INFO, "Successfully verified bookticketevents(with debitcard).");
			//ss.downloadTicket();	
			//logout
			/*driver.navigate().to("http://staging.wanasatime.com");
			driver.findElement(us.menu1).click();
			driver.findElement(us.logout).click();
			String URL1 = driver.getCurrentUrl();
			Assert.assertEquals(URL1,"http://staging.wanasatime.com/Home.aspx");
									*/
			}
		
		
		//voucher booking
		//@Test(priority=7) 
		public void verifybookticketseventsevoucher() throws InterruptedException
		{
			logger_ss = extent.createTest("verifybookticketseventsevoucher");
			driver.navigate().to("http://staging.wanasatime.com");
			ss.countrySelection();		
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL,"http://staging.wanasatime.com/Home.aspx?country=Bahrain" );	
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			String success =ss.BookTicketeventsVoucher();
			Assert.assertEquals(success, "Congratulations! Your Tickets was confirmed.");	
			
		}
		
		
		//partial booking
		//@Test(priority=8) 
		public void verifypartialbookticketsevent() throws InterruptedException
			{
			logger_ss = extent.createTest("verifypartialbookticketsevent");
			driver.navigate().to("http://staging.wanasatime.com");
			ss.countrySelection();		
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL,"http://staging.wanasatime.com/Home.aspx?country=Bahrain" );	
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			String success =ss.BookTicketeventspartial();
			Assert.assertEquals(success, "Congratulations! Your Tickets was confirmed.");
			//logout
			driver.navigate().to("http://staging.wanasatime.com");
			driver.findElement(us.menu1).click();
			driver.findElement(us.logout).click();
			String URL1 = driver.getCurrentUrl();
			Assert.assertEquals(URL1,"http://staging.wanasatime.com/Home.aspx");
		
		}
			
		  @Test(priority=9)
		   
		  public void verifymovieticketbooking() throws InterruptedException
			{
			logger_ss = extent.createTest("verifymovieticketbooking");
			driver.navigate().to("http://staging.wanasatime.com");
			ss.countrySelection();						
			String success =ss.movieticketbooking();
			Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");
			logger_ss.log(Status.INFO, "Successfully verified movieticketbooking(with debitcard).");
			//ss.downloadTicket();	
						
			}
				
		

		
		
		@Test(priority=10)
		public void verifyquickbooking() throws InterruptedException
		{
			logger_ss = extent.createTest("verifyquickbooking");
			driver.navigate().to("http://staging.wanasatime.com");
			ss.countrySelection();			
			String msg = ss.quickbooking();
			Assert.assertEquals(msg,"Congratulations! Your Tickets was confirmed.");
			logger_ss.log(Status.INFO, "Successfully verified quickbooking(with debitcard)."); 
			
		}	
		
				
	//	@Test(priority=11) 
		public void verifygoogLogin() throws InterruptedException
			{
			    logger_ss = extent.createTest("googLogin");
			    driver.navigate().to("http://staging.wanasatime.com");
				ss.clickSignInButton();	
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				String afterlogin=ss.googleLogin();
				Assert.assertEquals(afterlogin,"http://staging.wanasatime.com/");				
				driver.navigate().to("http://staging.wanasatime.com");
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				//Thread.sleep(3000);
				driver.findElement(ss.menug).click();
				driver.findElement(ss.logoutg).click();
				String URL1 = driver.getCurrentUrl();
				Assert.assertEquals(URL1,"http://staging.wanasatime.com/Home.aspx");
				logger_ss.log(Status.INFO, "Successfully verified googLogin.");
				//String URL = driver.getCurrentUrl();
				//Assert.assertEquals(URL,"http://staging.wanasatime.com/");	
				driver.navigate().to("http://staging.wanasatime.com");
				driver.findElement(us.menu1).click();
				driver.findElement(us.logout).click();
				String URL2 = driver.getCurrentUrl();
				Assert.assertEquals(URL2,"http://staging.wanasatime.com/Home.aspx");			
				logger_ss.log(Status.INFO, "Successfully verified logout."); 
			}
		
				
	//	@Test(priority=12)
		public void verifyfooterlinks() throws InterruptedException
	    {
			     logger_ss = extent.createTest("verifyfooterlinks");
		    	 ss.footerlinksaboutus();
		    	 String URL = driver.getCurrentUrl();
		    	 Assert.assertEquals(URL,"http://staging.wanasatime.com/AboutUs.aspx" );
		    	 ss.footerlinksAdvertiseWithUs();
		    	 String Advt = driver.getCurrentUrl();
		    	 Assert.assertEquals(Advt,"http://staging.wanasatime.com/AdvertiseWithUs.aspx" );
		    	 ss.footerlinksfaq();
		    	 String FAQ =  driver.getCurrentUrl();
		    	 Assert.assertEquals(FAQ,"http://staging.wanasatime.com/FAQs.aspx" );
		    	 ss.footerlinkstc();
		    	 String TC =  driver.getCurrentUrl();
		    	 Assert.assertEquals(TC,"http://staging.wanasatime.com/Terms.aspx" );
		    	 ss.footerlinkprivacy();
		    	 String privacy= driver.getCurrentUrl();
		    	 Assert.assertEquals(privacy,"http://staging.wanasatime.com/Privacy.aspx" );
		    	 ss.footerlinkcontactus();
		    	 String contactus = driver.getCurrentUrl();
		    	 Assert.assertEquals(contactus,"http://staging.wanasatime.com/ContactUs.aspx" );
		    	 ss.footerlinkplanspricing();
		    	 String pricing = driver.getCurrentUrl();
		    	 Assert.assertEquals(pricing,"http://staging.wanasatime.com/PlansPricing.aspx" );	
		    	 logger_ss.log(Status.INFO, "Successfully verified footerlinks.");
		}
		
	//	@Test(priority=13)
		public void verifycontactus() throws InterruptedException
		{
			logger_ss = extent.createTest("verifycontactus");
			ss.countrySelection();
			String msg =ss.contactus();
			Assert.assertEquals(msg,"Thanks for providing your information we will get back to you soon" );		
			logger_ss.log(Status.INFO, "Successfully verified contactus.");
		}
		
		    
	}

