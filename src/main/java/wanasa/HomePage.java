package wanasa;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	
	
	
	//bhd musicband  href="night-life/bahrain-music-band"
	By eventbookBHDMusic    = By.xpath("//*[@href='night-life/bahrain-music-band']");
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
 		CommonMethods.clickMethod(location);
		List<WebElement> listcountry=driver.findElements(region);
		listcountry.get(0).click();		
 		
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
 		Thread.sleep(8000);
 		
 		driver.findElement(signinemail).clear();
 		driver.findElement(signinemail).sendKeys("test0000@gmail.com");
 		driver.findElement(signinpassword).sendKeys("874283748");
 		driver.findElement(loginclick).click();
 		Thread.sleep(8000);
 		
 		
 		driver.findElement(signinemail).clear(); 
 		driver.findElement(signinpassword).clear();
 		driver.findElement(signinemail).sendKeys(CommonMethods.passingData("EnterMail"));
		driver.findElement(signinpassword).sendKeys(CommonMethods.passingData("Password"));	
		driver.findElement(loginclick).click();
		Thread.sleep(8000);
				
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
		driver.findElement(eventbookBHDMusic).click();
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
		driver.findElement(btnforpay).click();
		Thread.sleep(10000);	
						
	   }
		catch (Exception e) {
		   
	   }
		
	}
	
	
	
	public void bookticketmovies()
	{
		try
		{
			
			driver.navigate().to("http://staging.wanasatime.com/Movies.aspx");
			 
			CommonMethods.clickMethod(moviestab);
		
			CommonMethods.clickMethod(weelymovie);
			
			CommonMethods.clickMethod(weelymoviesbookbutton);
		
			CommonMethods.clickMethod(weelymoviedateselection);
			
			CommonMethods.clickMethod(weelyshowtimeselection);
			
			
			System.out.println("hai alert");
			//Thread.sleep(3000);	
			
		//	JavascriptExecutor js = (JavascriptExecutor) driver;  
			//js.executeScript(Script,Arguments);
			//js.executeScript("document.getElementById('btnAccept').click();");
			
			//String s=driver.findElement(By.id("age_restrict")).getText();
			//Assert.assertEquals(s, "Parental Guidance advised");
			//CommonMethods.explicitWaitForAlert(driver);
			//driver.findElement(By.id("btnAccept")).click();
	 	//	driver.switchTo().alert().accept();
			//CommonMethods.clickMethod(alertmovieok);
	 		
			//Thread.sleep(10000);
			/*CommonMethods.explicitWaitForAlert(driver);
	 		driver.switchTo().alert();
			CommonMethods.clickMethod(numberofseatselection);
		
			Thread.sleep(3000);	
			CommonMethods.clickMethod(seatselectionOkclick);
			Thread.sleep(3000);	
			CommonMethods.clickMethod(seatlayoutselect);
			Thread.sleep(3000);	
			CommonMethods.clickMethod(proceedpaymovie);*/
			//Thread.sleep(3000); driver.findElement(voucher).sendKeys("");
			//Thread.sleep(3000);	CommonMethods.clickMethod(moviespayproceed);		
		}
		catch  (Exception e)
		{
			
		}
		
						
		
	}
	
	

	

}
