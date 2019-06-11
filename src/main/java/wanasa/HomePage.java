package wanasa;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.BrowserFunctions;
import utils.JsonData;
import utils.ReusableMethods;

public  class HomePage extends BrowserFunctions{
	
	
	By location      		= By.className("liLocation");
	By region        		= By.className("region");	
	By signinclick   		= By.id("loginclick");
	By signinemail          = By.id("email");
	By signinpassword       = By.id("password");
	By loginclick           = By.id("LoginSubmit");
	By eventbook	        = By.xpath("//*[@href='/science-and-technology/glimpses-traditional-architechure-live-bahrain']");
 	By eventbookingclick    = By.id("bookBtnForOtherevents");
 	By nextclick            = By.id("BookingNext");
 	By dateselection        = By.xpath("//*[@recurringid='1415']");
 	By ticketcount       	= By.id("294");
 	By btnproceed 			= By.id("btnProceed");
 	By btnproceedfinal		= By.id("btnProceed");
 	By fblogin				= By.id("loginBtn1");
 	By successMsg 			= By.xpath("//*[@id='successMsg']//h4[1]");
	 

 	public void  CountrySelection()
 	{
 		ReusableMethods.clickMethod(location);
		List<WebElement> listcountry=driver.findElements(region);
		listcountry.get(0).click();		
 		
 	} 	
 	
 	
 	public void SigninWanasaTimeCredentials()
 	{
 		try
 		{
 		driver.findElement(signinclick).click(); 		
 		Thread.sleep(2000);
 		driver.findElement(signinemail).sendKeys(JsonData.passingData("EnterMail"));
		driver.findElement(signinpassword).sendKeys(JsonData.passingData("Password"));	
		driver.findElement(loginclick).click();
 		}
 		catch(Exception ex) {
 			
 		} 		
 	}
 	
 	public String successMsg() {
 		return driver.findElement(successMsg).getText();
 	}
 	
 	
	public void BookTicket()
	{
		try{		
			
		driver.findElement(eventbook).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
	    ReusableMethods.clickMethod(eventbookingclick);
	    Thread.sleep(3000);
	    ReusableMethods.clickMethod(dateselection);
	    Thread.sleep(3000);
	    ReusableMethods.clickMethod(nextclick);
	    Thread.sleep(3000);
	    ReusableMethods.clickMethod(ticketcount);
	    Thread.sleep(3000);
	    ReusableMethods.clickMethod(btnproceed);
	    Thread.sleep(3000);
	    ReusableMethods.clickMethod(btnproceedfinal);
	   Thread.sleep(15000);
	   }
		catch (Exception e) {
		   
	   }
		
	}
	
	public void PositiveBookTicket()
	{
		try
		{	
			ReusableMethods.clickMethod(location);
			List<WebElement> listcountry=driver.findElements(region);
			listcountry.get(0).click();				
			driver.findElement(signinclick).click();
			driver.findElement(signinemail).sendKeys(JsonData.passingData("EnterMail"));
			driver.findElement(signinpassword).sendKeys(JsonData.passingData("Password"));	
			driver.findElement(loginclick).click();
		    driver.findElement(eventbook).click();
	  	   //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Thread.sleep(3000);
	        ReusableMethods.clickMethod(eventbookingclick);
		    Thread.sleep(3000);
		    ReusableMethods.clickMethod(dateselection);
		    Thread.sleep(3000);
		    ReusableMethods.clickMethod(nextclick);
		    Thread.sleep(3000);
		    ReusableMethods.clickMethod(ticketcount);
		    Thread.sleep(3000);
		    ReusableMethods.clickMethod(btnproceed);
		    Thread.sleep(3000);
		    ReusableMethods.clickMethod(btnproceedfinal);
		   Thread.sleep(5000);
	   }
		catch (Exception e)
		{
			
		}
		
	}
	

}
