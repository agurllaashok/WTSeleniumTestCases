package wanasa;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utils.*;

public  class HomePage extends BrowserFunctions{
	
	//select region
	By location      		= By.className("liLocation");
	By region        		= By.className("region");
	
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
	
	//logout	
	
	
	
	//confirmation.aspx
	By txtPaymentMobile 	= By.id("txtPaymentMobile");
	By txtPaymentEmail 		= By.id("txtPaymentEmail");
	By ticketconfirmtext    = By.xpath("//*[@id='successMsg']//h4");
	By tktcanceltext        = By.xpath("//*[@id='failedMsg']//h4");
	
	
	//signup
	By username				= By.id("RegisterUser");
	By email				= By.id("RegisterEmail");
	By mobilenumber 		= By.id("re-phone");
	By password 			= By.id("re-password");
	By repassword 			= By.id("re-password");
	By signupclick 			= By.id("userSignUp");
	
	//forgot password
	By forgotclick			= By.id("lnkForgot");
	By enteremail 			= By.id("txtForgotEmail");
	By click				= By.id("btnForgot");
	By forgotpwdsuccessmsg  = By.xpath("//*[contains(@class,'toast-message') and contains(text(),'We have sent a mail to you.Please check your mail.')]");
	
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
	
 	//E-Voucher
  	By evoucheraplybtn      = By.id("btnCouponApply");
 	By errorvoucher         = By.xpath("//[*contains(@class,'toast-message') and contains(text(),'Enter a E-Voucher Code')]");
 	By errorinvalidevoucher = By.xpath("//[*contains(@class,'toast-message') and contains(text(),'Invalid E-Voucher')]");
 
 	
 	By fblogin				= By.id("loginBtn1"); 
 	By successMsg 			= By.xpath("//*[@id='successMsg']//h4[1]");
 	
 	//movies
 	By moviestab 			= By.id("tabMovies");
 	By eventstab			= By.id("tabEvents");
 	By weelymovie			= By.xpath("//*[@href='MovieInfo.aspx?MovieId=14']");
 	By weelymoviesbookbutton= By.id("bookTickets");
 	By weelymoviedateselection = By.xpath("//*[@showdate='06/13/2019']");
 	By weelyshowtimeselection = By.xpath("//*[@showid='4306']");
 	By alertmovieok 				= By.id("btnAccept");
 	By numberofseatselection 		= By.linkText("2");
 	By seatselectionOkclick = By.id("btnOk");
 	By seatlayoutselect 	= By.xpath("//*[@title='Row-A Seat-02']");
 	By proceedpaymovie		= By.id("btnPay");
 	By voucher 				= By.id("eVoucher");
 	By moviespayproceed		= By.id("btnPaymentProceed");
 	
	 

 	public void  countrySelection() throws InterruptedException
 	{
 		//CommonMethods.clickMethod(location);
 		driver.findElement(location).click(); 	
		List<WebElement> listcountry=driver.findElements(region);
		listcountry.get(0).click();	
		Thread.sleep(3000);
				
 	} 	
 	
 	
 	public void clickSignInButton() throws InterruptedException{
 		driver.findElement(signinclick).click(); 	
 		Thread.sleep(3000);
 		
 	}
 	
 	
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
		driver.findElement(dateselection).click();
		Thread.sleep(3000);	
		driver.findElement(next).click();
		Thread.sleep(3000);	
		driver.findElement(selectcategoryfree).click();
		Thread.sleep(3000);	
		driver.findElement(btnproceedfinal).click();
		Thread.sleep(3000);
		//driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
	//	driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(btnforpay).click();
		Thread.sleep(5000);						
	   }
		catch (Exception e) {		   
	   }		
		return driver.findElement(ticketconfirmtext).getText();
	}
	
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
	
	
	public String  BookTicketeventsVoucher()
	{
		try
		{				
		//driver.findElement(eventstab).click();	
		//Thread.sleep(3000);	
		driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
		Thread.sleep(3000);	
		driver.findElement(eventbookingclick).click();
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
		driver.findElement(btnforpay).click();
		Thread.sleep(5000);						
	   }
		catch (Exception e) {		   
	   }		
		return driver.findElement(ticketconfirmtext).getText();
	}
	
	
	
	 
	
}
