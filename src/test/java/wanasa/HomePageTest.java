 	package wanasa;
	import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utils.BrowserFunctions;
import utils.CommonMethods;
	
	public class HomePageTest extends BrowserFunctions{
		HomePage ss= new HomePage();	
		User us= new User();
	
	//@Test(priority=0) 
		public void verifysignup() throws InterruptedException
		{
			//ss.alertadvt();
			logger_ss = extent.createTest("verifysignup");
			String sucessmsg = ss.signup();
			Assert.assertEquals(sucessmsg, "You have successfully registered. We have sent a verification email to you.");
			driver.navigate().to("http://staging.wanasatime.com/");
			//ss.alertadvt();
			logger_ss.log(Status.INFO, "signup done successfully.");
		}
		
/*		@AfterMethod
		public void screenshot(ITestResult result){
			
			 testcasename = result.getName();
			System.out.println("Test case name:" +testcasename);
			
			if(ITestResult.FAILURE==result.getStatus())
			{
				System.out.println("::::++++++");
				CommonMethods.getScreenshot();
			}
		}*/
		
		//@Test(priority=1)
		public void verifyforgotpassword() throws InterruptedException
		{
			logger_ss = extent.createTest("verifyforgotpassword");
			String checksuccessmsg= ss.forgotpassword();
			Assert.assertEquals(checksuccessmsg, "We have sent a mail to you.Please check your mail.");
			logger_ss.log(Status.INFO, "Successfully verified forgot password.");
			
		}
		 

		//@Test(priority=2)  

		public void verifylogin() throws InterruptedException  
		{	
			logger_ss = extent.createTest("verifylogin");
			driver.navigate().to("http://staging.wanasatime.com/");
			////ss.alertadvt();
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
			//ss.alertadvt();
			logger_ss = extent.createTest("verifyeventbookvisa");			
			//ss.clickSignInButton();
			//ss.login();
			ss.countrySelectionqar();		
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			String success =ss.eventbookvisa();
			Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");
			logger_ss.log(Status.INFO, "Successfully verified bookticketevents(visa qatar).");
		}
		
		//multiple day event
		// @Test(priority=4)
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
		 // @Test(priority=5)
		public void verifybookticketevents() throws InterruptedException 
		{
			logger_ss = extent.createTest("verifybookticketevents");
			ss.countrySelection();	
			//ss.alertadvt();
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL,"http://staging.wanasatime.com/Home.aspx?country=Bahrain" );
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			String success =ss.BookTicketevents();
			Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");
			logger_ss.log(Status.INFO, "Successfully verified bookticketevents(free ticket).");
		}
		
		
		//multi days sub cat
		// @Test(priority=6)
		public void verifyeventticketBookingWithDebitCard() throws InterruptedException
			{
			logger_ss = extent.createTest("verifyeventticketBookingWithDebitCard");
			//driver.navigate().to("http://staging.wanasatime.com");
			//ss.clickSignInButton();
			//ss.signinWanasaTimeCredentials();			
			String success =ss.eventticketBookingWithDebitCard();
			Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");	
			logger_ss.log(Status.INFO, "Successfully verified bookticketevents(with debitcard).");
			//logout
			
			}
		
		
		//voucher booking
		 //@Test(priority=7) 
		public void verifybookticketseventsevoucher() throws InterruptedException
		{
			logger_ss = extent.createTest("verifybookticketseventsevoucher");
			driver.navigate().to("http://staging.wanasatime.com");
			//ss.alertadvt();
			ss.countrySelection();	
			//ss.alertadvt();
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
			//ss.alertadvt();
			ss.countrySelection();
			//ss.alertadvt();
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL,"http://staging.wanasatime.com/Home.aspx?country=Bahrain" );
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			String success =ss.BookTicketeventspartial();
			Assert.assertEquals(success, "Congratulations! Your Tickets was confirmed.");
		
		
		}
			
		//@Test(priority=9)
		   
		  public void verifymovieticketbooking() throws InterruptedException
			{
			logger_ss = extent.createTest("verifymovieticketbooking");
			driver.navigate().to("http://staging.wanasatime.com");
			//ss.alertadvt();
			ss.countrySelection();	
			//ss.alertadvt();
			String success =ss.movieticketbooking();
			Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");
			logger_ss.log(Status.INFO, "Successfully verified movieticketbooking(with debitcard).");
			//ss.downloadTicket();	
						
			}							
		
		//@Test(priority=10)
		public void verifyquickbooking() throws InterruptedException
		{
			logger_ss = extent.createTest("verifyquickbooking");
			driver.navigate().to("http://staging.wanasatime.com");
			//ss.alertadvt();
			ss.countrySelection();	
			//ss.alertadvt();
			String msg = ss.quickbooking();
			Assert.assertEquals(msg,"Congratulations! Your Tickets was confirmed.");
			logger_ss.log(Status.INFO, "Successfully verified quickbooking(with debitcard)."); 
			driver.navigate().to("http://staging.wanasatime.com");
			//ss.alertadvt();
			driver.findElement(ss.menu).click();
			driver.findElement(ss.logout).click();
			//ss.alertadvt();
			String URL1 = driver.getCurrentUrl();
			Assert.assertEquals(URL1,"http://staging.wanasatime.com/Home.aspx");
			
		}	
		
				
	//@Test(priority=11) 
		public void verifygoogLogin() throws InterruptedException
			{
			    logger_ss = extent.createTest("googLogin");
			    driver.navigate().to("http://staging.wanasatime.com");
			    //ss.alertadvt();
				ss.clickSignInButton();	
				CommonMethods.explicitWaitForElementVisibility(ss.googleLogin);
				String afterlogin=ss.googleLogin();
				Assert.assertEquals(afterlogin,"http://staging.wanasatime.com/");				
				driver.navigate().to("http://staging.wanasatime.com");
				//ss.alertadvt();
				//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				CommonMethods.explicitWaitForElementVisibility(ss.menu);
				driver.findElement(ss.menu).click();
				//CommonMethods.explicitWaitForElementVisibility(ss.logout);
				driver.findElement(ss.logout).click();
				//ss.alertadvt();
				String URL1 = driver.getCurrentUrl();
				Assert.assertEquals(URL1,"http://staging.wanasatime.com/Home.aspx");
				logger_ss.log(Status.INFO, "Successfully verified googLogin.");
			}
						
		//@Test(priority=12)
		public void verifyfooterlinks() throws InterruptedException
	    {
			     logger_ss = extent.createTest("verifyfooterlinks");
			     ss.countrySelection();
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
		
		//@Test(priority=13)
		public void verifycontactus() throws InterruptedException
		{
			logger_ss = extent.createTest("verifycontactus");
			driver.navigate().to("http://staging.wanasatime.com");			
			ss.countrySelection();
			//ss.alertadvt();
			String msg =ss.contactus();
			Assert.assertEquals(msg,"Thanks for providing your information we will get back to you soon" );		
			logger_ss.log(Status.INFO, "Successfully verified contactus.");
		}

		@Test(priority=14)
		public void verifySMiconclick() throws InterruptedException
		{
			logger_ss = extent.createTest("verifySMiconclick");	
			driver.navigate().to("http://staging.wanasatime.com");
			//ss.alertadvt();	
			ss.countrySelection();
			int cocunt = ss.SMiconclick();
			Assert.assertEquals(cocunt,5);
			logger_ss.log(Status.INFO, "Successfully verified SMiconclick.");
		}
		
		//@Test(priority=15)
		public void verifyplaystoreclick() throws InterruptedException
		{
			logger_ss = extent.createTest("verifyplaystoreclick");
			driver.navigate().to("http://staging.wanasatime.com");
			//ss.alertadvt();	
			//ss.countrySelection();
			String s=ss.playstoreclick();	
			Assert.assertEquals(s, "https://play.google.com/store/apps/details?id=com.mobile.android.wanasatime&hl=en_US");		
			logger_ss.log(Status.INFO, "Successfully verified playstoreclick");
		}
		

		//@Test(priority=16)
		public void verifyappstoreclick() throws InterruptedException
		{
			logger_ss = extent.createTest("verifyappstoreclick");
			driver.navigate().to("http://staging.wanasatime.com");
			//ss.alertadvt();			
			String s=ss.appstoreclick();	
			Assert.assertEquals(s, "https://apps.apple.com/us/app/wanasatime/id1187788688");		
			logger_ss.log(Status.INFO, "Successfully verified appstoreclick");
		}
		
	//@Test(priority=17)
		public void verifyadvertisingneeds() throws InterruptedException
		{
			logger_ss = extent.createTest("verifyadvertisingneeds");
			driver.navigate().to("http://staging.wanasatime.com");
			//ss.alertadvt();
			ss.countrySelection();
			String s=ss.advertisingneeds();	
			Assert.assertEquals(s, "Thanks for providing your information we will get back to you soon.");		
			logger_ss.log(Status.INFO, "Successfully verified advertisingneeds");
		}
		
		 // Advertise With Us Query...
	//	@Test(priority=18)
		 public void queryAdvertiseWithUs() throws InterruptedException
		 {
			 logger_ss = extent.createTest("verifyAdvertiseWithUs");
			 driver.navigate().to("http://staging.wanasatime.com");
			 //ss.alertadvt();
			 ss.countrySelection();
			 //ss.alertadvt();
			 String adver=ss.queryAdvertise();
			 Assert.assertEquals(adver, "http://staging.wanasatime.com/AdvertiseWithUs.aspx?");
			 logger_ss.log(Status.INFO, "Successfully Submitted Details in AdvertiseWithUs");
			 	
		 }
		  
		  
	//	  @Test(priority=19)
		  public void plansandpricingAnyQuery() throws InterruptedException
		  {
			  logger_ss = extent.createTest("verifyPlansAndPricing");
	          ss.countrySelection();
	          //ss.alertadvt();
	          String plans=ss.plansAndPricingQuery();
	          Assert.assertEquals(plans, "http://staging.wanasatime.com/PlansPricing.aspx");
	          logger_ss.log(Status.INFO, "Successfully Submitted Details in Plans and Pricing");
			 	
		  }


		
		//user

	//	@Test(priority=20)
		public void verifyuseroperations() throws Exception
		{
			logger_ss = extent.createTest("verifyuseroperations");
			 driver.navigate().to("http://staging.wanasatime.com");
			ss.clickSignInButton();
			String afterlogin = ss.signinWanasaTimeCredentials();
			//ss.alertadvt();
			Assert.assertEquals(afterlogin, "http://staging.wanasatime.com/");
			ss.edituser();
			logger_ss.log(Status.INFO, "Successfully verified verifyuseroperations");
		}
		
	//	@Test(priority=21)
		public void verifypasswordchange() throws InterruptedException
		{
			logger_ss = extent.createTest("verifypasswordchange");		
			driver.navigate().to("http://staging.wanasatime.com/my-profile");
			String s= ss.passwordchange();
			Assert.assertEquals(s, "Password Changed Successfully");
			logger_ss.log(Status.INFO, "Successfully verified verifypasswordchange");
		}
		
	//	@Test(priority=22)
		public void verifypwdcahngeclose() throws InterruptedException
		{
			logger_ss = extent.createTest("verifypwdcahngeclose");
			//ss.clickSignInButton();
			//ss.signin();
			driver.navigate().to("http://staging.wanasatime.com/my-profile");
			ss.pwdcahngeclose();  
			String url = driver.getCurrentUrl();
			Assert.assertEquals(url, "http://staging.wanasatime.com/my-profile");
			logger_ss.log(Status.INFO, "Successfully verified verifypwdcahngeclose");
		}
		
	//	@Test(priority=23)
 		public void verifypreferences() throws InterruptedException
		{
			logger_ss = extent.createTest("verifypreferences");
			//ss.clickSignInButton();
			//ss.signin();
			driver.navigate().to("http://staging.wanasatime.com/my-profile");
			String s= ss.preferences();
			Assert.assertEquals(s, "Preferences Saved Successfully");
			logger_ss.log(Status.INFO, "Successfully verified verifypreferences");
		}
		
	//	@Test(priority=24)
		public void verifynotifications() throws InterruptedException
		{
			logger_ss = extent.createTest("verifynotifications");
			driver.navigate().to("http://staging.wanasatime.com/my-profile");
			//ss.clickSignInButton();
			//ss.signin();
			String s= ss.notifications();
			Assert.assertEquals(s, "Notifications saved successfully");
			logger_ss.log(Status.INFO, "Successfully verified verifynotifications");
		}
		
      //@Test(priority=25)
		public void verifysearchbookingistory() throws InterruptedException
		{
			logger_ss = extent.createTest("searchbookingistory");
			//driver.findElement(ss.signinclick).click();
			//driver.navigate().to("http://staging.wanasatime.com/my-profile");
			ss.searchbookingistory();
			logger_ss.log(Status.INFO, "Successfully verified searchbookingistory");
			driver.findElement(ss.menu1).click();
			driver.findElement(ss.logout).click();
			//ss.alertadvt();
		}
	

		// Negative Cases
		
		@Test(priority=25)
		
		public void backBtnSingleDayEvent() throws InterruptedException
		{
			driver.navigate().to("http://staging.wanasatime.com");
			//ss.alertadvt();
			logger_ss=extent.createTest("verifybackBtnSingleDayEvent");
			ss.countrySelection();
			//ss.alertadvt();
			boolean bl=ss.singleDayBackBtnBahrain();
			Assert.assertEquals(bl, true);
			logger_ss.log(Status.INFO, "Successfully verified backBtnSingleDayEvent");
		}
		
		
	  @Test(priority=26) 
	  public void cancelBtnSingleDayEvent() throws InterruptedException
	  	{
		    driver.navigate().to("http://staging.wanasatime.com");
		    //ss.alertadvt();
		    logger_ss=extent.createTest("verifycancelBtnSingleDayEvent");
			ss.countrySelection(); 
			//ss.alertadvt();
			boolean bln=ss.singleDayCancelBtnBahrain();
			Assert.assertEquals(bln, true);
			logger_ss.log(Status.INFO, "Successfully verified cancelBtnSingleDayEvent");
	  	}
	  
	  
	  @Test(priority=27) 
	    
	  public void cancelBtnCreditCard() throws InterruptedException
	  {
		  driver.navigate().to("http://staging.wanasatime.com");
		  //ss.alertadvt();
		    logger_ss=extent.createTest("verifyCancelBtnCreditCard");
		    driver.findElement(ss.signinclick).click();
		    driver.findElement(ss.signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(ss.signinpassword).sendKeys(CommonMethods.passingData("Password"));
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(ss.loginclick).click();
			//ss.alertadvt();
		    //ss.signinWanasaTimeCredentials();
			ss.countrySelection(); 
			//ss.alertadvt();
			String crbtn=ss.cancelBtnInCreditCard();
			Assert.assertEquals(crbtn, "Your transaction was failed or you may cancelled the purchase.");
			logger_ss.log(Status.INFO, "Successfully verified cancelBtnCreditCard");
	  }
	  
	  @Test(priority=28) 
	  
	  public void backBtnInSeatLayoutNaal() throws InterruptedException
	  {
		  driver.navigate().to("http://staging.wanasatime.com");
		  //ss.alertadvt();
		  logger_ss=extent.createTest("verifyBackBtnInSeatLayout");
		  ss.countrySelectionqar();
		  boolean val=ss.backinSeatLayoutPage();
		  Assert.assertEquals(val, true);
		  logger_ss.log(Status.INFO, "Successfully verified backBtnInSeatLayoutNaal");
	  }
	  
	  @Test(priority=29)
	  public void withOutSelectingSeatInSeatLayoutForNaal() throws InterruptedException
	  {
		  driver.navigate().to("http://staging.wanasatime.com");
		  //ss.alertadvt();
		  logger_ss=extent.createTest("verifywithOutSelectingSeat");
		  ss.countrySelectionqar();
		  String str=ss.proceedInSeatLayoutWithOutSelectingSeat();
		  Assert.assertEquals(str,"Please select your tickets");
		  logger_ss.log(Status.INFO, "Successfully verified withOutSelectingSeatInSeatLayoutForNaal");
	  }
	  @Test(priority=30) 
	  public void cancelBtnInCBQPayment() throws InterruptedException
	  {
		  driver.navigate().to("http://staging.wanasatime.com");
		  //ss.alertadvt();
		    logger_ss=extent.createTest("verifyCancelBtnInPaymentPage");
		  /* driver.findElement(ss.signinclick).click();
		    driver.findElement(ss.signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(ss.signinpassword).sendKeys(CommonMethods.passingData("Password"));
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(ss.loginclick).click();*/
			ss.countrySelectionqar();
			String canCbq=ss.cancelBtnInPaymentPage();
			Assert.assertEquals(canCbq,"Your transaction was failed or you may cancelled the purchase.");
			logger_ss.log(Status.INFO, "Successfully verified cancelBtnInCBQPayment");  
	  }
	  

      @Test 	  
	  public void withOutSelectingSeat() throws InterruptedException
	  {
		  driver.navigate().to("http://staging.wanasatime.com");
		  //ss.alertadvt();
		  logger_ss=extent.createTest("verifywithOutSelectingSeat");
		  ss.countrySelectionqar();
		  String str=ss.withoutSubCategories();
		  Assert.assertEquals(str,"Select No.Of Tickets you want to book");
		  logger_ss.log(Status.INFO, "Successfully verified withOutSelectingSeat"); 
		  driver.navigate().to("http://staging.wanasatime.com");
		  //ss.alertadvt();
			driver.findElement(ss.menu1).click();
			driver.findElement(ss.logout).click();
			//ss.alertadvt();
	  }

	  @Test
	  public void verifyfacebookiconclick() throws InterruptedException
	  {
	  logger_ss = extent.createTest("verifyfacebookiconclick");
	  ss.facebookiconclick();	
	  //Assert.assertEquals(s1, true);	
	  logger_ss.log(Status.INFO, "Successfully facebookiconclick.");
	  }
	  
	  //Movies Filter based on Mall Selection
	 @Test
	 public void filterMoviesLocations() throws InterruptedException
	 {
		 //driver.navigate().to("http://staging.wanasatime.com");
		 logger_ss = extent.createTest("verifyMovieLoactons");
         ss.countrySelection();		 
         boolean bool=ss.moviesFilter();
         Assert.assertEquals(bool,true);
         logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Mall");
	 }
	 
	 // Movies Filter based on Genre Selection
	 
	 @Test
	 public void filterMoviesGenre() throws InterruptedException
	 {
		 logger_ss = extent.createTest("verifyMovieLoactons");
         ss.countrySelection();		 
         boolean bool=ss.moviesGenre();
         Assert.assertEquals(bool,true);
         logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Genre");
         //System.out.println("Count of the Movies"+);
	 }
	 
	 // Movies Filter Based on Language
	 
	 @Test
	 public void filterMoviesLang() throws InterruptedException
	 {
		 logger_ss = extent.createTest("verifyMovieLanguage");
         ss.countrySelection();		 
         boolean bool=ss.moviesLanguage();
         Assert.assertEquals(bool,true);
         logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Language");
	 }
	 
	 // Movies Filter Based on Mall,Genre and Languages
	 
	 @Test
	 public void moviesAllFilters() throws InterruptedException
	 {
		 logger_ss = extent.createTest("verifyMovieLanguage");
         ss.countrySelection();	
         //ss.moviesFilter();
        // ss.moviesGenre();
         boolean bool=ss.movieAllFilters();
         Assert.assertEquals(bool,true);
         logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Mall,Genre and Language");
	
	 }
	 
	 //Movies Filter Based on Timings
	 @Test
	 public void movieTimeingsFilter() throws InterruptedException
	 {
		 logger_ss = extent.createTest("verifyMovieTime");
         ss.countrySelection();	
         //ss.moviesFilter();
        // ss.moviesGenre();
         boolean bool=ss.movieFilterTime();
         Assert.assertEquals(bool,true);
         logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Timing");
	 
	 }
	 
	 //Events Filter Based on Event Types
	 @Test
	 public void eventTypeFilter() throws InterruptedException
	 {
		 logger_ss = extent.createTest("verifyEventType");
         ss.countrySelection();	
         boolean bol=ss.eventFilterType();
         Assert.assertEquals(bol,true);
         
         logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Event Type");
	 
	 }
	 
	 //Events Filter Based on Event Category
	 @Test
	 public void eventCatFilter() throws InterruptedException
	 {
		 logger_ss = extent.createTest("verifyEventCategory");
         ss.countrySelection();	
         boolean bol=ss.eventFilterCategory();
         Assert.assertEquals(bol,true);
         
         logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Event Category");
	  
	 }
	 //Evouchers Fileter based on Date
	 @Test
	 public void evouchersFileter() throws Exception
	 {
		 logger_ss = extent.createTest("verifyEvouchersFilter");
		 ss.clickSignInButton();
		 ss.login();
		boolean bol=ss.evouchersFilters();
		Assert.assertEquals(bol,true);
		logger_ss.log(Status.INFO, "Filter Applied Successfully Based on Evouchers");
		 
		 	 }
	}
	
	

