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
	By logout = By.id("Logout");
	
	//confirmation.aspx
	By txtPaymentMobile = By.id("txtPaymentMobile");
	By txtPaymentEmail = By.id("txtPaymentEmail");
	
	
	//bhd musicband  href="night-life/bahrain-music-band"
	By eventbookBHDMusic    = By.xpath("//*[@href='night-life/bahrain-music-band']");
	By Eventbookclickimg    = By.xpath("//*[@src='http://staging.wanasatime.com/EventPosters/bmb_0905201910540917879.jpg']");
 	By eventbookingclick    = By.id("bookBtnForOtherevents");
 	By next            = By.id("BookingNext");
 	By dateselection        = By.xpath("//*[@recurringid='1766']");
 	By btnproceed 			= By.id("btnProceed"); 
 	By selectcategoryfree   = By.xpath("//*[@categoryid='5395']");	
 	By ticketcount       	= By.id("294"); 	
 	By btnproceedfinal		= By.id("btnProceed");
 	By btnforpay			= By.id("btnProceed");
 	
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
		Thread.sleep(4000);
 		
 	} 	
 	
 	
 	public void signinWanasaTimeCredentials()
 	{
 		try
 		{
 		driver.findElement(signinclick).click(); 		
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		
 		driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
 		driver.findElement(signinpassword).sendKeys("");
 		driver.findElement(loginclick).click();
 		Thread.sleep(5000);
 		
 		driver.findElement(signinemail).clear();
 		driver.findElement(signinemail).sendKeys("test0000@gmail.com");
 		driver.findElement(signinpassword).sendKeys("874283748");
 		driver.findElement(loginclick).click();
 		Thread.sleep(5000);
 		
 		
 		driver.findElement(signinemail).clear(); 
 		driver.findElement(signinpassword).clear();
 		driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(signinpassword).sendKeys(CommonMethods.passingData("Password"));	
		driver.findElement(loginclick).click();
	//	driver.findElement(logout).click();
		Thread.sleep(5000);
		
				
 		}
 		catch(Exception ex) {
 			
 		} 		
 	}
 	
 public String successMsg() {
 		return driver.findElement(successMsg).getText();
 	}
 	
 	
	public void BookTicketevents()
	{
		try{				
		driver.findElement(eventstab).click();	
		Thread.sleep(3000);	
		//Actions action= new Actions(driver);
		//WebElement ele = driver.findElement(Eventbookclickimg);
		//action.moveToElement(ele).perform();
		//driver.findElement(Eventbookclickimg).click();
		driver.navigate().to("http://staging.wanasatime.com/night-life/bahrain-music-band");
		Thread.sleep(3000);	
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); next
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
		driver.findElement(txtPaymentMobile).sendKeys(CommonMethods.passingData("mobile"));
		driver.findElement(txtPaymentEmail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(btnforpay).click();
		Thread.sleep(5000);	
						
	   }
		catch (Exception e) {
		   
	   }
		
	}
	

}
