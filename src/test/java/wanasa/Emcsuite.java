package wanasa;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utils.BrowserFunctions;

public class Emcsuite  extends BrowserFunctions{
	
			Emc es=new Emc();
			
				
		 //  @Test(priority=0)
			  
			  public void userSignUp() throws InterruptedException
			  {
			  
			  String sucessmsg= es.signUp(); 
			  Assert.assertEquals(sucessmsg,"Your account has been created successfully");
			  driver.navigate().to("http://staging.emc.wanasatime.com/"); 
			  }
		

		   @Test(priority=1)
		     
		   public void forgotPswd()
		   {
			  String forEmail=es.forgotPassword();
			  Assert.assertEquals(forEmail,"We have sent a mail to you.Please check your mail.");
			  //driver.navigate().to("http://staging.emc.wanasatime.com/");
			  driver.findElement(es.loginbtnInForgot).click();
		  }
		   
			 
		 @Test(priority=2)		
		    public void verifylogin() throws InterruptedException  
			  {	
				String emptyEmail=es.signInEmptyEmail();
				Assert.assertEquals(emptyEmail, "Please enter Email");
				String emptypwd = es.signInEmptyPassword();
				Assert.assertEquals(emptypwd,"Please enter Password");
				String invalidinput= es.signInInvalidCredentials();
				Assert.assertEquals(invalidinput,"EmailId not Registered" );
				String afterlogin = es.signInValidCredentials();
				Assert.assertEquals(afterlogin, "http://staging.emc.wanasatime.com/Dashboard.aspx");	
			  }
		 @Test
		 public void verifysingledayEvent()
		 {
			 String event=es.createEvent();
			 Assert.assertEquals(event,"http://staging.emc.wanasatime.com/EventsDetailsList.aspx");
		 }
			 
		 @Test
		 public void verifyevent1() throws InterruptedException, AWTException
		 {
			String eventsub= es.evntcreationmultisubcattimeslot();
			Assert.assertEquals(eventsub,"http://staging.emc.wanasatime.com/EventsDetailsList.aspx");
			
		 }
		 
        @Test
        public void verifyLagout() throws InterruptedException
        {
        	String lag=es.lagout();
        	Assert.assertEquals(lag,"http://staging.emc.wanasatime.com/Index.aspx");
	
        }
        
        @Test
        public void approveEvent()
        {   
        	
        	 es.superAdminLogin();
		     //Assert.assertEquals(afterlogin1, "http://staging.emc.wanasatime.com/Dashboard.aspx");
        	String suc=es.eventApprove();
        	Assert.assertEquals(suc,"http://staging.emc.wanasatime.com/EventsDetailsList.aspx");
         }
 
 

}
