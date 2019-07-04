  package wanasa;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.BrowserFunctions;
import utils.CommonMethods;

public  class HomePage extends BrowserFunctions{
	
	//select region
	By location      		= By.className("liLocation");
	By region        		= By.className("region");
	
 	public void  countrySelection() throws InterruptedException
 	{
 		//CommonMethods.clickMethod(location);
 		driver.findElement(location).click(); 	
		List<WebElement> listcountry=driver.findElements(region);
		listcountry.get(0).click();	
		Thread.sleep(3000);
				
 	} 	
 	
	
	
	//signin
	By signinclick   		= By.id("loginclick");
	By signinemail          = By.id("email");
	By signinpassword       = By.id("password");
	By loginclick           = By.id("LoginSubmit");
	By logout               = By.id("Logout");
	By errormsgemptypwd 	= By.className("toast-message");
	By erremtypwd		    = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Enter a password')]");
	By erridpwdwrong 		= By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Invalid credentials')]");
	By afterloginverify 	= By.className("user-profile-name-container");
	
	public String singInWithEmptyPassword() throws InterruptedException
	{
		driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
		Thread.sleep(3000);
 		driver.findElement(signinpassword).sendKeys(""); 		
 		driver.findElement(loginclick).click();
 		Thread.sleep(3000);
 		return driver.findElement(erremtypwd).getText();	
 	}
	
	
	public String singInWithincorrectcredentials() throws InterruptedException
	{
		driver.findElement(signinemail).clear();
 		driver.findElement(signinemail).sendKeys("test0000@gmail.com");
 		Thread.sleep(3000);
 		driver.findElement(signinpassword).sendKeys("874283748");
 		Thread.sleep(3000);
 		driver.findElement(loginclick).click();
 		Thread.sleep(3000);
 		return  driver.findElement(erridpwdwrong).getText();	
 	}
 	
	
 	public String signinWanasaTimeCredentials()
 	{
 		try
 		{
 		/*driver.findElement(signinclick).click(); 		
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 			
 		Thread.sleep(5000);*/
		driver.findElement(signinemail).clear(); 
 		driver.findElement(signinpassword).clear();
 		driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
 		Thread.sleep(3000);
		driver.findElement(signinpassword).sendKeys(CommonMethods.passingData("Password"));	
		Thread.sleep(3000);
		driver.findElement(loginclick).click();
		//BrowserFunctions.homePageUrl = CommonMethods.passingData("homepageurl");
		//BrowserFunctions.downloadFilepath = CommonMethods.passingData("downloadFilepath");
		
		Thread.sleep(5000);		
		
		
 		}
 		catch(Exception ex) {
 			
 		} 
 		String url=driver.getCurrentUrl();
 		return url;
  	}
 	
 	
    public String successMsg()
     {
 		return driver.findElement(successMsg).getText();
     }
    
	
	//footerlinks
	By aboutus 				= By.linkText("About");
	By AdvertiseWithUs		= By.linkText("Advertise With Us");
	By FAQ					= By.linkText("FAQs");
	By TC					= By.linkText("Terms & Conditions"); 
	By privacy					= By.linkText("Privacy Policy"); 
	By contactus					= By.linkText("Contact us"); 
	By planspricing					= By.linkText("Plans & Pricing"); 
		
	
	public void footerlinksaboutus()
	{
		
		try {
			driver.navigate().to("http://staging.wanasatime.com/");
			driver.findElement(aboutus).click();			
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void footerlinksAdvertiseWithUs()
	{
		
		try {
			//driver.navigate().to("http://staging.wanasatime.com/");
			driver.findElement(AdvertiseWithUs).click();			
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void footerlinksfaq()
	{
		try {
			//driver.navigate().to("http://staging.wanasatime.com/");
			driver.findElement(FAQ).click();			
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void footerlinkstc()
	{
		try {
			//driver.navigate().to("http://staging.wanasatime.com/");
			driver.findElement(TC).click();			
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void footerlinkprivacy()
	{
		try {
			//driver.navigate().to("http://staging.wanasatime.com/");
			driver.findElement(privacy).click();			
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void footerlinkcontactus()
	{
		try {
			//driver.navigate().to("http://staging.wanasatime.com/");
			driver.findElement(contactus).click();			
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void footerlinkplanspricing()
	{
		try {
			//driver.navigate().to("http://staging.wanasatime.com/");
			driver.findElement(planspricing).click();			
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	//confirmation.aspx
	By txtPaymentMobile 	= By.id("txtPaymentMobile");
	By txtPaymentEmail 		= By.id("txtPaymentEmail");
	By ticketconfirmtext    = By.xpath("//*[@id='successMsg']//h4");
	By tktcanceltext        = By.xpath("//*[@id='failedMsg']//h4");
	
	
	
	//signup
	By sinupclick			= By.id("lnkSignUp");
	By username				= By.id("RegisterUser");
	By email				= By.id("RegisterEmail");
	//By prefix				= By.className("btn selected-country-code-btn");
	By cprefix 				= By.id("countrydropup");
	By prefix				= By.xpath("//*[@id='Phone']//*[@data-toggle='dropdown']");	
	By mobilenumber 		= By.id("re-phone");
	By password 			= By.id("re-password");
	By repassword 			= By.id("confirmPassword");
	By signupclick 			= By.id("userSignUp");
	By signupsuccess 		= By.xpath("//*[contains(@class,'toast-message') and contains(text(),'You have successfully registered. We have sent a verification email to you.')]");
	
	
	
	
	public String signup() throws InterruptedException
	{
		try
		{
		clickSignInButton();
		driver.findElement(sinupclick).click();
		CommonMethods cm = new CommonMethods();
		driver.findElement(username).sendKeys(cm.getSaltString1());	
		Thread.sleep(2000);
		driver.findElement(email).sendKeys(cm.getSaltString1()+"@gmail.com");
		Thread.sleep(2000);
		driver.findElement(prefix).click();		
		Actions ACT = new Actions(driver);
		ACT.moveToElement(driver.findElement(By.xpath("//*[@id='countrydropup']//*[@style='padding: 5px 20px;']"))).perform();
		driver.findElement(By.xpath("//*[@id='countrydropup']//*[@style='padding: 5px 20px;']")).click();
		driver.findElement(By.id("customCountryPrefix")).sendKeys("91");
		Thread.sleep(2000);
		driver.findElement(mobilenumber).sendKeys("9848"+cm.getSaltString());
		Thread.sleep(2000);
		driver.findElement(password).sendKeys("pallavi22");	
		driver.findElement(repassword).sendKeys("pallavi22");		
		driver.findElement(signupclick).click();
		Thread.sleep(3000);
		}
		catch(Exception ex)
		{
			
		}
		return driver.findElement(signupsuccess).getText();
		
	}
	
	
	//forgot password
	By forgotclick			= By.id("lnkForgot");
	By enteremail 			= By.id("txtForgotEmail");
	By click				= By.id("btnForgot");
	By forgotpwdsuccessmsg  = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'We have sent a mail to you.Please check your mail.')]");
	
	public String forgotpassword() throws InterruptedException
	{
		driver.findElement(signinclick).click();
		Thread.sleep(3000);
		driver.findElement(forgotclick).click();
		Thread.sleep(2000);
		driver.findElement(enteremail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(click).click();
		Thread.sleep(2000);	
		return driver.findElement(forgotpwdsuccessmsg).getText();
	}
	
	
	
	
	//bhd musicband  href="night-life/bahrain-music-band" 
	By eventbookBHDMusic    = By.xpath("//*[@href='night-life/bahrain-music-band']");
	By Eventbookclickimg    = By.xpath("//*[@src='http://staging.wanasatime.com/EventPosters/bmb_0905201910540917879.jpg']");
 	By eventbookingclick    = By.id("bookBtnForOtherevents");
 	By next            		= By.id("BookingNext");
 	By dateselection        = By.xpath("//*[@recurringid='1766']");
 	By btnproceed 			= By.id("btnProceed"); 
 	By selectcategoryfree   = By.xpath("//*[@categoryid='5395']");	
 	By ticketcount       	= By.id("294"); 
 	By sucatplatchild       = By.id("340"); 
 	By btnproceedfinal		= By.id("btnProceed");
	By btnforpay			= By.id("btnProceed");
	By okButtonOnOverlay 	= By.id("btnAccept");
	
 	//E-Voucher
  	By evoucheraplybtn      = By.id("btnCouponApply");
 	By errorvoucher         = By.xpath("//[*contains(@class,'toast-message') and contains(text(),'Enter a E-Voucher Code')]");
 	By errorinvalidevoucher = By.xpath("//[*contains(@class,'toast-message') and contains(text(),'Invalid E-Voucher')]");
 
 	public String  BookTicketevents()
	{
		try
		{				
		//driver.findElement(eventstab).click();	
		//Thread.sleep(3000);	
		driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
		Thread.sleep(3000);	
		driver.findElement(eventbookingclick).click();
		Thread.sleep(3000);	
		driver.findElement(okButtonOnOverlay).click();
		Thread.sleep(3000);
		driver.findElement(dateselection).click();
		Thread.sleep(3000);	
		driver.findElement(next).click();
		Thread.sleep(3000);	
		driver.findElement(selectcategoryfree).click();
		Thread.sleep(3000);	
		driver.findElement(btnproceedfinal).click();
		Thread.sleep(3000);
		//driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		//driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(btnforpay).click();
		Thread.sleep(5000);						
	   }
		catch (Exception e) {		   
	   }		
		return driver.findElement(ticketconfirmtext).getText();
	}
	
	
	
	
	public String BookTicketeventsVoucher()
	{		
		try
		{				
		//driver.findElement(eventstab).click();	
		//Thread.sleep(3000);	
		driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
		Thread.sleep(3000);	
		driver.findElement(eventbookingclick).click();
		Thread.sleep(3000);	
		driver.findElement(okButtonOnOverlay).click();
		Thread.sleep(3000);
		driver.findElement(dateselection).click();
		Thread.sleep(3000);	
		driver.findElement(next).click();
		Thread.sleep(3000);	
		driver.findElement(sucatplatchild).click();
		Thread.sleep(3000);		
		driver.findElement(btnproceedfinal).click();
		Thread.sleep(3000);
		driver.findElement(voucher).sendKeys(CommonMethods.passingData("evoucher"));
		
		driver.findElement(evoucheraplybtn).click();
		
		Thread.sleep(3000);
		//driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		//driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(btnforpay).click();
		Thread.sleep(3000);
		// result = driver.findElement(ticketconfirmtext).getText();
		Thread.sleep(3000);
	   }
		catch (Exception e) {		   
	   }
		return driver.findElement(ticketconfirmtext).getText();
	}
	
	
	
	
 	By fblogin				= By.id("loginBtn1"); 
 	By successMsg 			= By.xpath("//*[@id='successMsg']//h4[1]");
 	
 	//movies  
 	 	By moviestab 			= By.id("tabMovies");
 	 	By eventstab			= By.id("tabEvents");
 	 	By vijaymovie			= By.xpath("//*[@href='MovieInfo.aspx?MovieId=17']");
 	 	//By vijaymovie			= By.linkText("Book");
 	 	By moviesbookbutton     = By.id("bookTickets");
 	 	By moviedateselection   = By.xpath("//*[@showdate='07/13/2019']");
 	 	By showtimeselection    = By.xpath("//*[@showid='6063']");
 	 	By alertmovieok 		= By.id("btnAccept");
 	 	By numberofseatselection= By.linkText("2");
 	 	By seatselectionOkclick = By.id("btnOk");
 	 	By seatlayoutselect 	= By.xpath("//*[@title='Row-G Seat-08']");
 	 	By seatlayoutselect1 	= By.xpath("//*[@title='Row-B Seat-04']");
 	 	By proceedpaymovie		= By.id("btnPay");
 	 	By voucher 				= By.id("eVoucher");
 	 	By moviespayproceed		= By.id("btnPaymentProceed");
 	 	By ticketsuccess		= By.xpath("//*[@id='onSuccess']/h4");
 	 	
 	 
	public String movieticketbooking() throws InterruptedException
	{
		
		try
		{
			//driver.navigate().to("http://staging.wanasatime.com/");
			driver.findElement(moviestab).click();
			//driver.navigate().to("http://staging.wanasatime.com/Movies.aspx");
			Thread.sleep(6000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.findElement(vijaymovie).click();
			Thread.sleep(2000); 
			driver.findElement(moviesbookbutton).click();
			driver.findElement(moviedateselection).click();
			driver.findElement(showtimeselection).click();
			Thread.sleep(2000);
			driver.findElement(alertmovieok).click();
			Thread.sleep(3000);
			//driver.findElement(alertmovieok).click();
			driver.findElement(seatselectionOkclick).click();
			Thread.sleep(3000);
			driver.findElement(seatlayoutselect).click();
			Thread.sleep(2000);
			driver.findElement(proceedpaymovie).click();
			Thread.sleep(2000);	
			
			//driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
			//driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
			
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.findElement(debitcardbtn).click();	
			Thread.sleep(2000);
			driver.findElement(moviespayproceed).click();
			Thread.sleep(2000);
			driver.findElement(cardnumber).sendKeys(CommonMethods.passingData("CardNumber"));
			  Thread.sleep(4000);
			  Select oSelect = new Select(driver.findElement(expiryMonth));
			  oSelect.selectByIndex(11); 		 
				Thread.sleep(2000);		
				  driver.findElement(expiryYear).click();
				Thread.sleep(2000);
				Select oSelect1 = new Select(driver.findElement(expiryYear));
				  oSelect1.selectByIndex(10);
				Thread.sleep(2000);
				
				 driver.findElement(cardname).sendKeys(CommonMethods.passingData("CardName"));
				  Thread.sleep(4000);
			 
			  driver.findElement(pinNumber).click();
			  Thread.sleep(3000);
			  driver.findElement(pin1).click();
			  driver.findElement(pin2).click();
			  driver.findElement(pin3).click();
			  driver.findElement(pin4).click();
			 driver.findElement(pinEnter).click();
			  Thread.sleep(2000);
			 driver.findElement(submit).click();
			 Thread.sleep(2000);
			 driver.findElement(conform).click();
			 Thread.sleep(8000);
		}
		catch (Exception ex)
		{
			
		}
		
		 return driver.findElement(ticketsuccess).getText();
				
	}
 		
 	
 	public void clickSignInButton() throws InterruptedException{
 		driver.findElement(signinclick).click(); 	
 		Thread.sleep(3000);
 		
 	}
 	
 	


    
	
	
	// debitcard locators
	
	By debitcardbtn                    = By.xpath("//*[@id='btnDebitCard']");
  	By cardnumber                      = By.id("Ecom_Payment_Card_Number_id");
 	By cardname						   = By.id("Ecom_Payment_Card_Name_id"); 	
 	By pinNumber					   = By.name("Ecom_Payment_Pin");
 	By expiryMonth 					   = By.name("Ecom_Payment_Card_ExpDate_Month");
 	By expiryYear				       = By.name("Ecom_Payment_Card_ExpDate_Year");
 	By pin1							   = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='1']");
 	By pin2							   = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='2']");
 	By pin3							   = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='3']");
 	By pin4							   = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='4']");
 	By pinEnter						   = By.name("Enter");
 	By submit						   = By.name("EntrySubmitAction");
 	By conform						   = By.name("ConfirmAction");

 	
 	// Ticket Booking with Debit card Method
	  
 	  public String eventticketBookingWithDebitCard()
 	   {
 		   try
 		   {			   
 				driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
 				Thread.sleep(3000);	
 				driver.findElement(eventbookingclick).click();
 				Thread.sleep(3000);	
 				driver.findElement(okButtonOnOverlay).click();
 				Thread.sleep(3000);
 				driver.findElement(dateselection).click();
 				Thread.sleep(3000);	
 				driver.findElement(next).click();
 				Thread.sleep(3000);	 		 
 			driver.findElement(sucatplatchild).click();
 			Thread.sleep(3000);		
 			driver.findElement(btnproceedfinal).click();
 			Thread.sleep(3000);
 			
 			//scrolling the window to bottom
 			debitpay();	 
 		   }
 		   catch(Exception e)
 		   {
 				
 		   }
 		   return driver.findElement(ticketconfirmtext).getText();
 	   }
 	  

 	// Google Sign in Locators
 	    By googleLogin					   = By.id("connectGoogle");
 		By googleEmail					   = By.id("identifierId");
 		By gNext						   = By.xpath("//*[contains(@class,'RveJvd snByac') and contains(text(),'Next')]");
 		By googlePswd					   = By.name("password");
 		By gpNext						   = By.xpath("//*[contains(@class,'RveJvd snByac') and contains(text(),'Next')]");
 		By allow						   = By.xpath("//*[contains(@class,'RveJvd snByac') and contains(text(),'Allow')]");
 		
 		 //Google Login method
 	   
 	   public String googleLogin()
 	   {		     
 			 try
 			 {
 			driver.findElement(googleLogin).click();
 			 Set<String> AllwindowHandles=driver.getWindowHandles();
 			 String w1=(String) AllwindowHandles.toArray()[0];
 			 String w2=(String) AllwindowHandles.toArray()[1];
 			 driver.switchTo().window(w2);
 			 Thread.sleep(2000);
 			 
 				 driver.findElement(googleEmail).sendKeys(CommonMethods.passingData("googEmail"));
 				 Thread.sleep(2000);
 				driver.findElement(gNext).click();
 				 Thread.sleep(2000);
 				 driver.findElement(googlePswd).sendKeys(CommonMethods.passingData("googPswd"));
 				 Thread.sleep(2000);
 				driver.findElement(gpNext).click();
 				 Thread.sleep(2000);
 				driver.findElement(allow).click();
 				 Thread.sleep(2000);
 			    driver.switchTo().window(w1);
 			    Thread.sleep(4000);
 			    
 			 }
 			
 			 catch(Exception ex)
 			 {
 				 
 			 }
 			 
 			 String url=driver.getCurrentUrl();
 			   return url;
 	   }
 	   
 	   
 	 //quick booking
 	   By qucickbookclick       = By.xpath("//*[contains(@class,'nav-link') and contains(text(),'Quick Booking')]");
 	   By movieslist			= By.id("MoviesList");
 	   By selectmall	        = By.id("CinemaList");
 	   By selectdate            = By.id("ShowDates");
 	   By selecttime            = By.id("ShowTimes");
 	   By booknow               = By.id("BookNow");
 	   
 	   public String quickbooking()
 	   {
 		   try
 		   {
 			   driver.findElement(qucickbookclick).click();
 			   Thread.sleep(2000);
 			   Select movies = new Select(driver.findElement(movieslist));
 			  Thread.sleep(2000);
 			   movies.selectByVisibleText("21 ST NOOTTAANDU");
 			   Select malls = new Select(driver.findElement(selectmall));
 			  Thread.sleep(2000);
 			   malls.selectByVisibleText("Seef Mall");
 			   Select date = new Select(driver.findElement(selectdate));
 			  Thread.sleep(2000);
 			   date.selectByVisibleText("Friday, 12 Jul");
 			   Select time = new Select(driver.findElement(selecttime));
 			  Thread.sleep(2000);
 			   time.selectByVisibleText("8:00PM-Cinema 10");
 			   driver.findElement(booknow).click(); 			
 			  Thread.sleep(5000);
 				driver.findElement(alertmovieok).click();
 				Thread.sleep(2000);
 				driver.findElement(seatselectionOkclick).click();
 				Thread.sleep(2000);
 				driver.findElement(seatlayoutselect1).click();
 				Thread.sleep(2000);
 				driver.findElement(proceedpaymovie).click();
 				Thread.sleep(2000);		
 				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				driver.findElement(debitcardbtn).click();	
				driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
				driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
				driver.findElement(moviespayproceed).click();	
			  Thread.sleep(10000);				
			  driver.findElement(cardnumber).sendKeys(CommonMethods.passingData("CardNumber"));
			  Thread.sleep(4000);
			  driver.findElement(expiryMonth).click();
			  Thread.sleep(2000);
			  Select oSelect = new Select(driver.findElement(expiryMonth));
			  oSelect.selectByIndex(11); 		 
				Thread.sleep(2000);		
				  driver.findElement(expiryYear).click();
				Thread.sleep(2000);
				Select oSelect1 = new Select(driver.findElement(expiryYear));
				  oSelect1.selectByIndex(10);
				Thread.sleep(2000);
				
				 driver.findElement(cardname).sendKeys(CommonMethods.passingData("CardName"));
				  Thread.sleep(4000);
			 
			  driver.findElement(pinNumber).click();
			  Thread.sleep(3000);
			  driver.findElement(pin1).click();
			  driver.findElement(pin2).click();
			  driver.findElement(pin3).click();
			  driver.findElement(pin4).click();
			 driver.findElement(pinEnter).click();
			  Thread.sleep(2000);
			 driver.findElement(submit).click();
			 Thread.sleep(2000);
			 driver.findElement(conform).click();
			 Thread.sleep(8000);
 			   
 		   }
 		   catch(Exception ex)
 		   {
 			   
 		   }
 		  return driver.findElement(ticketsuccess).getText();
 	   }
 	   
 	   
 	   //debit card pay
 	   
		public void debitpay() throws InterruptedException
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				driver.findElement(debitcardbtn).click();		
			   try 
			   {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			  driver.findElement(btnforpay).click();		
			  Thread.sleep(10000);
				
			  driver.findElement(cardnumber).sendKeys(CommonMethods.passingData("CardNumber"));
			  Thread.sleep(4000);
			  driver.findElement(expiryMonth).click();
			  Thread.sleep(2000);
			  Select oSelect = new Select(driver.findElement(expiryMonth));
			  oSelect.selectByIndex(11); 		 
				Thread.sleep(2000);		
				  driver.findElement(expiryYear).click();
				Thread.sleep(2000);
				Select oSelect1 = new Select(driver.findElement(expiryYear));
				  oSelect1.selectByIndex(10);
				Thread.sleep(2000);
				
				 driver.findElement(cardname).sendKeys(CommonMethods.passingData("CardName"));
				  Thread.sleep(4000);
			 
			  driver.findElement(pinNumber).click();
			  Thread.sleep(3000);
			  driver.findElement(pin1).click();
			  driver.findElement(pin2).click();
			  driver.findElement(pin3).click();
			  driver.findElement(pin4).click();
			 driver.findElement(pinEnter).click();
			  Thread.sleep(2000);
			 driver.findElement(submit).click();
			 driver.findElement(conform).click(); 	
		}
 	   
 		

}
