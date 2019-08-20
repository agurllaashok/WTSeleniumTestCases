package wanasa;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.BrowserFunctions;
import utils.CommonMethods;

public class User extends BrowserFunctions  {
	//WebDriver driver;
	
	//menu s
	By menu = By.id("mobileMenu");
	By menu1 = By.id("userMenu");
	By profileclick = By.id("myProfile");
	By BookingHistory = By.id("bookingHistory");
	By Evouchers = By.id("eVouchers"); 
	By AdvertiseWithUs = By.linkText("Advertise With Us");
	
	
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
	By userdob       = By.id("buyerDOB");
	
	
	
	public void edituser() throws Exception
	{		
		try{
		driver.findElement(menu1).click();
		driver.findElement(profileclick).click();		
		Thread.sleep(3000);
		Thread.sleep(2000);
		driver.findElement(profilepic).click();
		StringSelection ss= new StringSelection("C:\\Users\\Smsc_Tech\\Desktop\\sara.jpg");
		
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
	     
	driver.findElement(buyerLName).clear();
		Thread.sleep(3000);
		driver.findElement(buyerLName).sendKeys("domreddy");
		Thread.sleep(3000);
		WebElement testDropDown = driver.findElement(By.id("buyerGender"));  
		Select gender = new Select(testDropDown);  
		gender.selectByValue("Female");		
		driver.findElement(userdob).clear();
		
		driver.findElement(buyerState).clear();
		Thread.sleep(3000);
		driver.findElement(buyerState).sendKeys("hyd");
		driver.findElement(buyerCity).clear();
		Thread.sleep(3000);
		driver.findElement(buyerCity).sendKeys("hyd");
		driver.findElement(updateBuyerProfile).click();	
		Thread.sleep(6000);
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
	//evoucher screen 		
	By searchDates = By.id("searchDates");
	
	//logout
	By logout = By.id("Logout");
	
	


	

    
  

}

