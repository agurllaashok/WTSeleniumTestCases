package wanasa;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utils.BrowserFunctions;

public class Emcsuite  extends BrowserFunctions{
	
	Emc es=new Emc();
	
		
   @Test(priority=0)
	  
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
	logger_ss.log(Status.INFO, "Successfully verified login functionality.");
	
}
}
