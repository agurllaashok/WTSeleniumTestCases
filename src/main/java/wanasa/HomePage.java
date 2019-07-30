package wanasa;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import utils.BrowserFunctions;
import utils.CommonMethods;



public class HomePage extends BrowserFunctions {
	
	// select region
	By location = By.className("liLocation");
	By region = By.className("region");

	//Bahrain
	
	public void countrySelection() throws InterruptedException {
		// CommonMethods.clickMethod(location);
		driver.findElement(location).click();
		List<WebElement> listcountry = driver.findElements(region);
		listcountry.get(0).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

	}
	
	//Qatar
	
	public void countrySelectionqar() throws InterruptedException {
		// CommonMethods.clickMethod(location);
		driver.findElement(location).click();
		List<WebElement> listcountry = driver.findElements(region);
		listcountry.get(1).click();

	}
	

	// Signin
	
	By signinclick = By.id("loginclick");
	By signinemail = By.id("email");
	By signinpassword = By.id("password");
	By loginclick = By.id("LoginSubmit");
	By logout = By.id("Logout");
	By errormsgemptypwd = By.className("toast-message");
	By erremtypwd = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Enter a password')]");
	By erridpwdwrong = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Invalid credentials')]");
	By afterloginverify = By.className("user-profile-name-container");

	public String singInWithEmptyPassword() throws InterruptedException
	{
		driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));		
		driver.findElement(signinpassword).sendKeys("");
		driver.findElement(loginclick).click();
		return driver.findElement(erremtypwd).getText();
	}

	public String singInWithincorrectcredentials() throws InterruptedException 
	{
		driver.findElement(signinemail).clear();
		driver.findElement(signinemail).sendKeys("test0000@gmail.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(signinpassword).sendKeys("874283748");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(loginclick).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		return driver.findElement(erridpwdwrong).getText();
	}

	public String signinWanasaTimeCredentials() 
	{
		try {
			
			driver.findElement(signinemail).clear();
			driver.findElement(signinpassword).clear();
			driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(signinpassword).sendKeys(CommonMethods.passingData("Password"));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(loginclick).click();
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		} catch (Exception ex) {

		}
		String url = driver.getCurrentUrl();
		return url;
	}

	public String successMsg() {
		return driver.findElement(successMsg).getText();
	}

	// Footerlinks
	
	By aboutus = By.linkText("About");
	By AdvertiseWithUs = By.linkText("Advertise With Us");
	By FAQ = By.linkText("FAQs");
	By TC = By.linkText("Terms & Conditions");
	By privacy = By.linkText("Privacy Policy");
	By contactus = By.linkText("Contact us");
	By planspricing = By.linkText("Plans & Pricing");

	public void footerlinksaboutus() throws InterruptedException {

		driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(aboutus).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public void footerlinksAdvertiseWithUs() throws InterruptedException {

		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(AdvertiseWithUs).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public void footerlinksfaq() throws InterruptedException {
		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(FAQ).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public void footerlinkstc() throws InterruptedException {
		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(TC).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public void footerlinkprivacy() throws InterruptedException {
		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(privacy).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public void footerlinkcontactus() throws InterruptedException {
		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(contactus).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	public void footerlinkplanspricing() throws InterruptedException {
		// driver.navigate().to("http://staging.wanasatime.com/");
		driver.findElement(planspricing).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	// Confirmation.aspx
	
	By txtPaymentMobile = By.id("txtPaymentMobile");
	By txtPaymentEmail = By.id("txtPaymentEmail");
	By ticketconfirmtext = By.xpath("//*[@id='successMsg']//h4");
	By tktcanceltext = By.xpath("//*[@id='failedMsg']//h4");

	// Signup
	
	By sinupclick = By.id("lnkSignUp");
	By username = By.id("RegisterUser");
	By email = By.id("RegisterEmail");
	// By prefix = By.className("btn selected-country-code-btn");
	By cprefix = By.id("countrydropup");
	By prefix = By.xpath("//*[@id='Phone']//*[@data-toggle='dropdown']");
	By mobilenumber = By.id("re-phone");
	By password = By.id("re-password");
	By repassword = By.id("confirmPassword");
	By signupclick = By.id("userSignUp");
	By signupsuccess = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'You have successfully registered. We have sent a verification email to you.')]");

	public String signup() throws InterruptedException {

			clickSignInButton();
			Thread.sleep(2000);
			driver.findElement(sinupclick).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			CommonMethods cm = new CommonMethods();
			driver.findElement(username).sendKeys(cm.getSaltString1());
			driver.findElement(email).sendKeys(cm.getSaltString1() + "@gmail.com");
			driver.findElement(prefix).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			Actions ACT = new Actions(driver);
			ACT.moveToElement(driver.findElement(By.xpath("//*[@id='countrydropup']//*[@style='padding: 5px 20px;']"))).perform();					
			driver.findElement(By.xpath("//*[@id='countrydropup']//*[@style='padding: 5px 20px;']")).click();
			driver.findElement(By.id("customCountryPrefix")).sendKeys("91");
			driver.findElement(mobilenumber).sendKeys("9848" + cm.getSaltString());
			driver.findElement(password).sendKeys("pallavi22");
			driver.findElement(repassword).sendKeys("pallavi22");
			driver.findElement(signupclick).click();
		
		return driver.findElement(signupsuccess).getText();

	}

	// Forgot password
	
	By forgotclick = By.id("lnkForgot");
	By enteremail = By.id("txtForgotEmail");
	By click = By.id("btnForgot");
	By forgotpwdsuccessmsg = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'We have sent a mail to you.Please check your mail.')]");

	public String forgotpassword() throws InterruptedException 
	{
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.findElement(signinclick).click();
		Thread.sleep(2000);
        driver.findElement(forgotclick).click();
		driver.findElement(enteremail).sendKeys(CommonMethods.passingData("EnterMail"));
		/*WebElement ele2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enteremail")));
        (ele2).sendKeys(CommonMethods.passingData("EnterMail"));*/
		driver.findElement(click).click();
		return driver.findElement(forgotpwdsuccessmsg).getText();
	}
	
	

	// Bahrain musicband href="night-life/bahrain-music-band"
	
	By eventbookBHDMusic = By.xpath("//*[@href='night-life/bahrain-music-band']");
	By Eventbookclickimg = By.xpath("//*[@src='http://staging.wanasatime.com/EventPosters/bmb_0905201910540917879.jpg']");
	By okButtonOnOverlay = By.id("btnAccept");
	By eventbookingclick = By.id("bookBtnForOtherevents");	
	By dateselection     = By.xpath("//*[@recurringid='1924']");
	By next 			 = By.id("BookingNext");
	By selectcategoryfree = By.xpath("//*[@categoryid='5395']");
	By selectcategoryvip = By.xpath("//*[@categoryid='5394']");
	By ticketcountsubvipaudlut1 = By.xpath("//div[@id='Subcat']//div[1]//button[1]");
	By ticketcountsubvipchild2 = By.xpath("//div[@id='Subcat']//div[2]//button[1]");
	By btnproceed = By.id("btnProceed");
	By sucatplatchild = By.id("340");
	By btnproceedfinal = By.id("btnProceed");
	By btnforpay = By.id("btnProceed");
	
	By successMsg = By.xpath("//*[@id='successMsg']//h4[1]");

	// E-Voucher
	By evoucheraplybtn = By.id("btnCouponApply");
	By errorvoucher = By.xpath("//[*contains(@class,'toast-message') and contains(text(),'Enter a E-Voucher Code')]");
	By errorinvalidevoucher = By
			.xpath("//[*contains(@class,'toast-message') and contains(text(),'Invalid E-Voucher')]");
	
	
//Free ticket
	
	public String BookTicketevents() 
	{
		try {
			// driver.findElement(eventstab).click();
			// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(eventbookingclick).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(okButtonOnOverlay).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(dateselection).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(next).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(selectcategoryfree).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(btnproceedfinal).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			 //driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
			 //driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
			driver.findElement(btnforpay).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		} catch (Exception e) {
		}
		return driver.findElement(ticketconfirmtext).getText();
	}
	
	
	// Ticket Booking with Debit card Method multi subcat

		public String eventticketBookingWithDebitCard() {
			try {
				driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");				
				driver.findElement(eventbookingclick).click();				
				driver.findElement(okButtonOnOverlay).click();
				driver.findElement(dateselection).click();
				driver.findElement(next).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				driver.findElement(selectcategoryvip).click();
				driver.findElement(ticketcountsubvipaudlut1).click();
				driver.findElement(ticketcountsubvipchild2).click();
				driver.findElement(btnproceedfinal).click();
			    //driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
				//driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				debitpayevents();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			} catch (Exception e) {

			}
			return driver.findElement(ticketconfirmtext).getText();
		}
	

		public String BookTicketeventsVoucher() throws InterruptedException
		  {

				// driver.findElement(eventstab).click();
				// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
				driver.findElement(eventbookingclick).click();
				driver.findElement(okButtonOnOverlay).click();
				driver.findElement(dateselection).click();
				driver.findElement(next).click();
				driver.findElement(selectcategoryvip).click();
				driver.findElement(ticketcountsubvipaudlut1).click();			
				driver.findElement(btnproceedfinal).click();
				//driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
				driver.findElement(txtPaymentEmail).clear();
				driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("vemail"));
				driver.findElement(voucher).click();
				driver.findElement(voucher).sendKeys(CommonMethods.passingData("evoucher"));			
				driver.findElement(evoucheraplybtn).click();
				Thread.sleep(3000);
				driver.findElement(btnforpay).click();
				return driver.findElement(ticketconfirmtext).getText();
		}	
		public String BookTicketeventspartial() {
			try {
				driver.findElement(eventstab).click();
				driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
				driver.findElement(eventbookingclick).click();
				driver.findElement(okButtonOnOverlay).click();
				driver.findElement(dateselection).click();
				driver.findElement(next).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				driver.findElement(selectcategoryvip).click();
				driver.findElement(ticketcountsubvipaudlut1).click();	
				driver.findElement(btnproceedfinal).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				driver.findElement(txtPaymentEmail).clear();
				driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
				driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("vemail"));
				driver.findElement(voucher).sendKeys(CommonMethods.passingData("evoucherP"));
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				driver.findElement(evoucheraplybtn).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				debitpayevents();
			} catch (Exception e) {
			}
			return driver.findElement(ticketconfirmtext).getText();
		}
		
	
	// Event ticket book -Qatar 
		
	By littlesing	 	= By.xpath("//*[@href='events/littleSingers']");
	By silvercat 		= By.xpath("//div[@id='EventCatgeory']//button[2]");
	By custname 		= By.id("txtCustomerName");
	By visacard 		= By.id("card_type_001");
	By master			= By.id("card_type_002");
	By cardnum		    = By.id("card_number");
	By expmonth  		= By.id("card_expiry_month");
	By expyear 			= By.id("card_expiry_year");
	By cvv 				= By.id("card_cvn");
	By pay 				= By.xpath("//input[@name='commit']");
	
	//(Single day event book with CBQ-visa) - Qatar
	
	public String eventbookvisa() throws InterruptedException
	{
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		driver.findElement(littlesing).click();
		driver.findElement(eventbookingclick).click();
		driver.findElement(okButtonOnOverlay).click();		
		driver.findElement(silvercat).click();
		driver.findElement(btnproceedfinal).click();
		driver.findElement(custname).sendKeys("pallavi");
		//driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
        // driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(btnforpay).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 driver.findElement(visacard).click();
		 driver.findElement(cardnum).sendKeys(CommonMethods.passingData("visaCBQ"));
		 driver.findElement(expmonth).click();
		 Select month = new Select(driver.findElement(expmonth));
		 month.selectByValue("04");
		 driver.findElement(expyear).click();
		 Select year = new Select(driver.findElement(expyear));
		 year.selectByValue("2021");
		 driver.findElement(cvv).sendKeys("123");
		 driver.findElement(pay).click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	
		return driver.findElement(ticketconfirmtext).getText();
	}
	
	
	
	
	//(Multiple day event book with CBQ-Mastercard) - Qatar
	
	By parent	 		 = By.xpath("//*[@href='science-and-technology/ParentTrainig']");
	By bookingdate		 = By.xpath("//*[@recurringid='1969']");
	By bookingdateslot 	 = By.xpath("//*[@recurringid='1970']");
	By silvercate		 = By.xpath("//div[@class='Block2']//button[2]");
	
	
	
	
	public String eventbookmaster() throws InterruptedException
	{
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(parent).click();
		driver.findElement(eventbookingclick).click();			
		driver.findElement(okButtonOnOverlay).click();		
		driver.findElement(bookingdate).click();
		driver.findElement(bookingdateslot).click();
		driver.findElement(next).click();
		driver.findElement(silvercate).click();		
		driver.findElement(btnproceedfinal).click();
		driver.findElement(custname).sendKeys("pallavi");
		//driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		//driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(btnforpay).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		 driver.findElement(master).click();
		 driver.findElement(cardnum).sendKeys(CommonMethods.passingData("masterBQ"));
		 driver.findElement(expmonth).click();
		 Select month = new Select(driver.findElement(expmonth));
		 month.selectByValue("04");
		 driver.findElement(expyear).click();
		 Select year = new Select(driver.findElement(expyear));
		 year.selectByValue("2021");
		 driver.findElement(cvv).sendKeys("123");
		 driver.findElement(pay).click();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	
		return driver.findElement(ticketconfirmtext).getText();
	}
	

	// By Fb login = By.id("loginBtn1");


	public void clickSignInButton() throws InterruptedException
	{
		driver.findElement(signinclick).click();
		Thread.sleep(2000);

	}

	// Debitcard locators

	By debitcardbtn = By.xpath("//*[@id='btnDebitCard']");
	By cardnumber = By.id("Ecom_Payment_Card_Number_id");
	By cardname = By.id("Ecom_Payment_Card_Name_id");
	By pinNumber = By.name("Ecom_Payment_Pin");
	By expiryMonth = By.name("Ecom_Payment_Card_ExpDate_Month");
	By expiryYear = By.name("Ecom_Payment_Card_ExpDate_Year");
	By pin1 = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='1']");
	By pin2 = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='2']");
	By pin3 = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='3']");
	By pin4 = By.xpath("//*[@id='table2']/tbody/tr/td/input[@name='4']");
	By pinEnter = By.name("Enter");
	By submit = By.name("EntrySubmitAction");
	By conform = By.name("ConfirmAction");



	// Google Sign in Locators
	
	By menug = By.id("userMenu");
	By logoutg = By.id("Logout");
	By googleLogin = By.id("connectGoogle");
	By googleEmail = By.id("identifierId");
	By gNext = By.xpath("//*[contains(@class,'RveJvd snByac') and contains(text(),'Next')]");
	By googlePswd = By.name("password");
	By gpNext = By.xpath("//*[contains(@class,'RveJvd snByac') and contains(text(),'Next')]");
	By allow = By.xpath("//*[contains(@class,'RveJvd snByac') and contains(text(),'Allow')]");

	// Google Login method

	public String googleLogin() throws InterruptedException {
		
		driver.findElement(googleLogin).click();
		Thread.sleep(4000);
		Set<String> AllwindowHandles = driver.getWindowHandles();
		String w1 = (String) AllwindowHandles.toArray()[0];
		String w2 = (String) AllwindowHandles.toArray()[1];
		driver.switchTo().window(w2);
		Thread.sleep(2000);
		driver.findElement(googleEmail).sendKeys(CommonMethods.passingData("googEmail"));
		driver.findElement(gNext).click();
		driver.findElement(googlePswd).sendKeys(CommonMethods.passingData("googPswd"));
		Thread.sleep(4000);
		driver.findElement(gpNext).click();
		Thread.sleep(4000);
		driver.findElement(allow).click();
		driver.switchTo().window(w1);
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		return url;
	}

	// Movies
	
	By moviestab = By.id("tabMovies");
	By eventstab = By.id("tabEvents");
	By vijaymovie = By.xpath("//*[@href='MovieInfo.aspx?MovieId=17']");
	
	By movielist = By.xpath("//*[@src='http://staging.wanasatime.com/movie_images/VIJAY_SUPERUM_POURNAMIYUM210219062202_thumbnail.jpg']");
	By moviesbookbutton = By.id("bookTickets");
	By moviedateselection = By.xpath("//*[@showdate='08/02/2019']");
	By showtimeselection = By.xpath("//*[@showid='7544']");
	By alertmovieok = By.id("btnAccept");
	By numberofseatselection = By.linkText("2");
	By ticketcount2 = By.xpath("//*[@class='nav nav-pills members']/li");
	By seatselectionOkclick = By.id("btnOk");
	
	// By seatlayoutselect = By.xpath("//*[@title='Row-G Seat-08']");
	
	By seatlayoutselect = By.xpath("//*[@id='seatNumber']//td[contains(@class,'seat available')]");
	By error = By.xpath("*//[@id='seat_error']");
	By proceedbutton = By.id("btnPay");
	By proceedpaymovie = By.id("btnPay");
	By voucher = By.id("eVoucher");
	By moviespayproceed = By.id("btnPaymentProceed");
	By ticketsuccess = By.xpath("//*[@id='onSuccess']/h4");
	
	
	

	public String movieticketbooking() throws InterruptedException {

			driver.findElement(moviestab).click();
			// driver.navigate().to("http://staging.wanasatime.com/Movies.aspx");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(movielist).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(moviesbookbutton).click();
			driver.findElement(moviedateselection).click();
			driver.findElement(showtimeselection).click();
			driver.findElement(alertmovieok).click();	
			Thread.sleep(4000);
			List<WebElement> seatselection = driver.findElements(ticketcount2);			
			System.out.println("Max seat can book by you :"+seatselection.size());
			for(WebElement seat : seatselection)
			{
				String seatnumber = seat.getText();
				System.out.println(seatnumber);
				if(seatnumber.equalsIgnoreCase("1"))
				{
					seat.click();
					Thread.sleep(4000);
					driver.findElement(seatselectionOkclick).click();
				
				}
			}
			
			Thread.sleep(2000);
			List<WebElement> seatsselection =  driver.findElements(seatlayoutselect);
			System.out.println("Avalaible seats are :" +seatsselection.size());
			for(WebElement seat11 : seatsselection)
			{
				Actions a = new Actions(driver);
					a.moveToElement(seat11).build().perform();
					seat11.click();
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
					
					WebElement paybutton = driver.findElement(proceedbutton);
					boolean pp = paybutton.isDisplayed();
					if(pp==true)
					{
						paybutton.click();
						//driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
						//driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
						debitpaymovies();
						Thread.sleep(2000);
						System.out.println("done");
						break;
					}
					
					else
					{
						System.out.println("Notification is diplayed as: 'Please select a seat beside the selected seat(s)'");
						seat11.click();
					}
							
			}

		

		return driver.findElement(ticketsuccess).getText();

	}
	
	
	
	// Quick booking 
	
	//By qucickbookclick = By.xpath("//*[@class='quick-booking-input-docker']/h4");
	By movieslist = By.id("MoviesList");
	By selectmall = By.id("CinemaList");
	By selectdate = By.id("ShowDates");
	By selecttime = By.id("ShowTimes");
	By booknow = By.id("BookNow");

	public String quickbooking() throws InterruptedException
	
	{
		//driver.findElement(qucickbookclick).click();
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			Select movies = new Select(driver.findElement(movieslist));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			movies.selectByVisibleText("21 ST NOOTTAANDU");
			Select malls = new Select(driver.findElement(selectmall));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			malls.selectByVisibleText("Seef Mall");
			Select date = new Select(driver.findElement(selectdate));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			date.selectByVisibleText("Friday, 2 Aug");
			Select time = new Select(driver.findElement(selecttime));
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			time.selectByVisibleText("8:00PM-Cinema 10");
			driver.findElement(booknow).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			driver.findElement(alertmovieok).click();
			Thread.sleep(4000);
			List<WebElement> seatselection = driver.findElements(ticketcount2);			
			System.out.println("Max seat can book by you :"+seatselection.size());
			for(WebElement seat : seatselection)
			{
				String seatnumber = seat.getText();
				if(seatnumber.equalsIgnoreCase("1"))
				{
					seat.click();
					Thread.sleep(4000);
					driver.findElement(seatselectionOkclick).click();
				
				}
			}
			
			Thread.sleep(2000);
			List<WebElement> seatsselection =  driver.findElements(seatlayoutselect);
			System.out.println("Avalaible seats are :" +seatsselection.size());
			for(WebElement seat11 : seatsselection)
			{
				Actions a = new Actions(driver);
					a.moveToElement(seat11).build().perform();
					seat11.click();
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
					
					WebElement paybutton = driver.findElement(proceedbutton);
					boolean pp = paybutton.isDisplayed();
					if(pp==true)
					{
						paybutton.click();
						//driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
						//driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));

						debitpaymovies();
						Thread.sleep(4000);
						System.out.println("done");
						break;
					}
					
					else
					{
						System.out.println("Notification is diplayed as: 'Please select a seat beside the selected seat(s)'");
						seat11.click();
					}
							
					} 

		return driver.findElement(ticketsuccess).getText();
	}

	
	
	// Debit card pay

	public void debitpayevents() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		CommonMethods.explicitWaitForClickableElement(driver,driver.findElement(debitcardbtn));
		driver.findElement(debitcardbtn).click();
		//Thread.sleep(2000);
		driver.findElement(btnforpay).click();
		CommonMethods.explicitWaitForElementVisibility(cardnumber);
		driver.findElement(cardnumber).sendKeys(CommonMethods.passingData("CardNumber"));
		//Thread.sleep(2000);
		driver.findElement(expiryMonth).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Select oSelect = new Select(driver.findElement(expiryMonth));
		oSelect.selectByIndex(11);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(expiryYear).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Select oSelect1 = new Select(driver.findElement(expiryYear));
		oSelect1.selectByIndex(10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(cardname).sendKeys(CommonMethods.passingData("CardName"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(pinNumber).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(pin1).click();
		driver.findElement(pin2).click();
		driver.findElement(pin3).click();
		driver.findElement(pin4).click();
		driver.findElement(pinEnter).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(submit).click();
		driver.findElement(conform).click();
	}
	
	// Debit pay movies
	
	public void debitpaymovies() throws InterruptedException {
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		CommonMethods.explicitWaitForClickableElement(driver,driver.findElement(debitcardbtn));
		//driver.findElement(debitcardbtn).click();
		CommonMethods.explicitWaitForElementVisibility(moviespayproceed);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(moviespayproceed).click();
		CommonMethods.explicitWaitForElementVisibility(cardnumber);
		driver.findElement(cardnumber).sendKeys(CommonMethods.passingData("CardNumber"));
		driver.findElement(expiryMonth).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Select oSelect = new Select(driver.findElement(expiryMonth));
		oSelect.selectByIndex(11);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(expiryYear).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Select oSelect1 = new Select(driver.findElement(expiryYear));
		oSelect1.selectByIndex(10);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(cardname).sendKeys(CommonMethods.passingData("CardName"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(pinNumber).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(pin1).click();
		driver.findElement(pin2).click();
		driver.findElement(pin3).click();
		driver.findElement(pin4).click();
		driver.findElement(pinEnter).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(submit).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
		driver.findElement(conform).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}

	//Contact us (Bahrain)
	
	By fname = By.id("firstName");
	By lname = By.id("secondName");
	By Email = By.id("emailId");
	By cnum  = By.id("contactNumber");
	By cname = By.id("companyName");
	By cmts  = By.id("comments");
	By checkbox = By.xpath("//input[@id='isEventOrganizer']");
	By sendbutton = By.id("btnSendQuery");
	By sendsuccess = By.className("toast-message");
	
	//Thanks for providing your information we will get back to you soon  //toastr-message  //toast-close-button
	
	public String contactus()
	{
		driver.findElement(contactus).click();
		driver.findElement(fname).sendKeys("pallavi");
		driver.findElement(lname).sendKeys("domreddy");
		driver.findElement(Email).sendKeys("pallavidomreddy@gmail.com");
		driver.findElement(cnum).sendKeys("32368745");
		driver.findElement(cname).sendKeys("smscountry");
		driver.findElement(cmts).sendKeys("test test");
		driver.findElement(sendbutton).click();
		return driver.findElement(sendsuccess).getText();		
	}
	

	//icon clicks bhd
	By fbicon = By.id("faceboolink");
	By insta  = By.id("instalink");
	By youtube= By.id("youtublink");
	By fbid   = By.id("u_0_3");
	By smlinks = By.xpath("//*[@class='social text-center']/a");
	
	public int  SMiconclick() throws InterruptedException
	{
		Thread.sleep(2000);
		//driver.findElement(location).click();
		WebElement xx = driver.findElement(By.xpath("//span[@class='fa fa-map-marker']"));
		Actions a = new Actions(driver);
		a.moveToElement(xx).build().perform();
		Thread.sleep(2000);
		List<WebElement> s3 = driver.findElements(By.xpath("//li[@class='dropdown liLocation']/ul/li"));
		//System.out.println("List of locations" +s3.size());
		
		for(WebElement s4 : s3)
		{
			String s5 = s4.findElement(By.xpath("./a")).getText();
			//System.out.println("Country Name " +s5);	
			String s6 = CommonMethods.passingData("loc");
			//System.out.println("For Json:" +s6);	
			if(s6.equalsIgnoreCase(s5))
			{
				s4.click();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				List<WebElement> slinks = driver.findElements(smlinks);
				for(WebElement sl:slinks)
				{
					sl.click();
					Thread.sleep(4000);
				    ArrayList  iconclick  = new ArrayList (driver.getWindowHandles());
					System.out.println("Size of windows opened" +iconclick.size());
					driver.switchTo().window((String) iconclick.get(1)); 
					String s1 = driver.getCurrentUrl();

					System.out.println(s1);	
					//driver.close();
					driver.switchTo().window((String) iconclick.get(0)); 
					String s2 = driver.getCurrentUrl();
					System.out.println(s2);						
				}
				break;				
			}
			
		}
		ArrayList  fbclick  = new ArrayList (driver.getWindowHandles());
		int windowsopened = fbclick.size();
		return windowsopened;
				 			
	}
	
	// play/app store click
	
	By playstore= By.xpath("//*[@class='col-md-3 store']/a[1]");
	By appstore= By.xpath("//*[@class='col-md-3 store']/a[2]");
	
	public String playstoreclick()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(playstore).click();
		String s1=driver.getCurrentUrl();
		System.out.println(s1);
		return s1;
		
	}
	
	public String appstoreclick()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(appstore).click();
		String s1=driver.getCurrentUrl();
		System.out.println(s1);
		return s1;
		
	}
	
	
	//advertisingneeds
	By name1 		= By.id("txtFirstName");
	By name2 		= By.id("txtLastName");
	By advtemail 	= By.id("txtEmail");
	By advtmobile   = By.id("txtPhoneNum");
	By addescription   = By.id("txtDescription");
	By advtsubmit 	= By.id("btnSubmit");
	By advtsuccessmsg = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Thanks for providing your information we will get back to you soon.')]");

	
	
	
/*	public String advertisingneeds()
	{
		driver.findElement(AdvertiseWithUs).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(name1).sendKeys("pallavi");
		driver.findElement(name2).sendKeys("domreddy");
		driver.findElement(advtemail).sendKeys("pallavi.domreddy@smscountry.com");
		driver.findElement(advtmobile).sendKeys("7396206647");
		driver.findElement(addescription).sendKeys("test desc");
		driver.findElement(advtsubmit).click();		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		CommonMethods.explicitWaitForElementVisibility(errormsgemptypwd);
		return driver.findElement(errormsgemptypwd).getText();				
	}
	 */

	//user 
	//menu s
	By menu = By.id("mobileMenu");
	By menu1 = By.id("userMenu");
	By profileclick = By.id("myProfile");
	By BookingHistory = By.id("bookingHistory");
	By Evouchers = By.id("eVouchers"); 
	//By AdvertiseWithUs = By.linkText("Advertise With Us");
	//By logout = By.id("Logout");
	
	
	// profile edit 	
	By buyerFName = By.id("buyerFName"); 
	By buyerLName = By.id("buyerLName");
	
	// Profile Pic Locators

    By profilepic          =             By.id("picEditIcon");
    By profilesavebtn	   =             By.id("btnSaveImage");

		// genderdropdown 
	By gender= By.id("buyerGender");	
	By buyerState = By.id("buyerState");
	By buyerCity = By.id("buyerCity");
	By updateBuyerProfile = By.id("updateBuyerProfile");
	By changePasswordBtn = By.id("changePasswordBtn");
	
	
	
	public void edituser() throws Exception
	{		
		try{
		driver.findElement(menu1).click();
		driver.findElement(profileclick).click();		
		Thread.sleep(3000);
		Thread.sleep(2000);
		driver.findElement(profilepic).click();
		 StringSelection ss= new StringSelection("C:\\Users\\Smsc_Tech\\Downloads\\PicsArt_03-19-02.50.30.jpg");
		 Thread.sleep(8000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(14000);
		 driver.findElement(profilesavebtn).click();
	     Thread.sleep(5000);
		}
		catch(Exception ex)
		{
			
		}		
				
	}
	
	//change password
	By oldPassword = By.id("oldPassword");
	By newPassword = By.id("newPassword");
	By ConfirmPassword = By.id("Confirm Password");
	By BtnupdatePassword = By.id("updatePassword");
	
	public void passwordchange()
	{
		try
		{
			driver.findElement(changePasswordBtn).click();	
			Thread.sleep(2000);
			driver.findElement(oldPassword).sendKeys("Password");	
			driver.findElement(newPassword).sendKeys("Password");
			driver.findElement(ConfirmPassword).sendKeys("Password");
			Thread.sleep(2000);
			driver.findElement(BtnupdatePassword).click();
		}
		catch(Exception ex)
		{
			
		}	
	
	}
	
	//booking history

	By mvebookings = By.linkText("MOVIES");
	By Eventbookings = By.linkText("EVENTS");
	By Allbookings = By.linkText("ALL");;
	By Apply = By.id("btnApply");
	
	
	
    public void purchasehistory()
    {
    	try
    	{
    		driver.findElement(menu1).click();
    		driver.findElement(BookingHistory).click();
    		Thread.sleep(2000);
    		//todaybookings 
    		WebElement testDropDown = driver.findElement(By.id("filterSelection"));  
    		Select moviesstatus = new Select(testDropDown);  
    		moviesstatus.selectByValue("1");
    		driver.findElement(Apply).click();
    		Thread.sleep(8000); 
    		Actions action = new Actions(driver);
    		action.sendKeys(Keys.PAGE_DOWN).build().perform();
    		Thread.sleep(3000);    		
           //SCROLL UP menu
          //action.sendKeys(Keys.PAGE_UP).build().perform();
            driver.findElement(menu).click();
            driver.findElement(logout).click();
    		
    	}
    	catch(Exception ex)
    	{
    		
    	} 
    }
	
	
	
	// Negative Cases 		
	
	//events
	
	// Single day Event Cancel and Back Button
	
	By tabEvents					=	By.id("tabEvents");
	By eventYoga					= 	By.xpath("//*[@href='science-and-technology/Yoga']");
	By back							= 	By.id("btnBack");
	By cancel						=	By.xpath("//*[@class='text-center mt_30 mb_20']//button[1]");
	By catSelectionChild			=	By.id("403");
	By catSelectionParent			=	By.id("404");
	By btnCreditCard				=	By.id("btnCreditCard");
	By cancelBtnCreditCard			=	By.xpath("//*[@class='col-xs-12 text-right hidden-xs']//*[@class='cancelButton']");
	By ticketFailure				=	By.xpath("//*[@id='failedMsg']//h4");
	
	public boolean singleDayBackBtnBahrain()
	
	{
	
	driver.findElement(tabEvents).click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	CommonMethods.explicitWaitForElementVisibility(eventYoga);
	driver.findElement(eventYoga).click();
	driver.findElement(eventbookingclick).click();
	driver.findElement(okButtonOnOverlay).click();
	driver.findElement(next).click();
	driver.findElement(catSelectionChild).click();
	driver.findElement(catSelectionParent).click();
	driver.findElement(back).click();
	CommonMethods.explicitWaitForElementVisibility(next);
    return driver.findElement(next).isDisplayed(); 
	
	}
	
	public boolean singleDayCancelBtnBahrain()
	{
		driver.findElement(tabEvents).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		CommonMethods.explicitWaitForElementVisibility(eventYoga);
		driver.findElement(eventYoga).click();
		driver.findElement(eventbookingclick).click();
		driver.findElement(okButtonOnOverlay).click();
		driver.findElement(cancel).click();
		return driver.findElement(eventbookingclick).isDisplayed();
		
	}
	
	// Back in Debit Card
	
	public String cancelBtnInCreditCard()
	{
		driver.findElement(tabEvents).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		CommonMethods.explicitWaitForElementVisibility(eventYoga);
		driver.findElement(eventYoga).click();
		driver.findElement(eventbookingclick).click();
		driver.findElement(okButtonOnOverlay).click();
		driver.findElement(next).click();
		driver.findElement(catSelectionChild).click();
		driver.findElement(catSelectionParent).click();
		driver.findElement(btnproceed).click();
		driver.findElement(btnproceedfinal).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(cancelBtnCreditCard).click();
		return driver.findElement(ticketFailure).getText();
		
				
	}
	
	// Back button in Seat selection Page Naal Event Qatar
	
	   By naalEvent			=	By.xpath("//*[@href='arts-and-culture/naal-']");
	   By goBack			=	By.id("goBack");
	   
	 
	public boolean backinSeatLayoutPage()
	{
		CommonMethods.explicitWaitForElementVisibility(naalEvent);
		driver.findElement(naalEvent).click();
		driver.findElement(eventbookingclick).click();
		driver.findElement(next).click();
		driver.findElement(btnproceed).click();
		driver.findElement(goBack).click();
		return driver.findElement(eventbookingclick).isDisplayed();
	}

	//Cancel Button in Patment GateWay Page CBQ
	
	By festivalAround		=	By.xpath("//*[@href='arts-and-culture/festivals-around-theworld']");
	By cancelinPayment		=	By.xpath("//*[@id='payment_details']/input[1]");
	By yesbtnAfterCancel	=	By.xpath("//span[contains(@class,'ui-button-text')][contains(text(),'Yes')]");
	By subCatAdult			=	By.xpath("//button[@id='326'][1]");
	By subCatChild			=	By.xpath("//button[@id='327'][2]");
	By withOutSelectingSeat	=	By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Select No.Of Tickets you want to book')]");
	
	public String cancelBtnInPaymentPage()
	{
		CommonMethods.explicitWaitForElementVisibility(festivalAround);
		driver.findElement(festivalAround).click();
		driver.findElement(eventbookingclick).click();
		driver.findElement(okButtonOnOverlay).click();
		driver.findElement(next).click();
		driver.findElement(btnproceed).click();
		driver.findElement(subCatAdult).click();
		driver.findElement(subCatChild).click();
		driver.findElement(btnproceed).click();
		driver.findElement(btnproceedfinal).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(cancelinPayment).click();
		driver.findElement(yesbtnAfterCancel).click();
		return driver.findElement(ticketFailure).getText();
	}
// Proceed Btn without Selecting sub Categories
	
	public String withoutSubCategories()
	{
		CommonMethods.explicitWaitForElementVisibility(festivalAround);
		driver.findElement(festivalAround).click();
		driver.findElement(eventbookingclick).click();
		driver.findElement(okButtonOnOverlay).click();
		driver.findElement(next).click();
		//driver.findElement(btnproceed).click();
		driver.findElement(btnproceed).click();
		return driver.findElement(withOutSelectingSeat).getText();
	}
	
	


	
	
}
