package wanasa;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BrowserFunctions;

public class testrun extends BrowserFunctions{
	
	HomePage ss= new HomePage();
	User us= new User();
		
	
	@Test(priority=0) 
	public void verifysignup() throws InterruptedException
	{
		String sucessmsg = ss.signup();
		Assert.assertEquals(sucessmsg, "You have successfully registered. We have sent a verification email to you.");
		driver.navigate().to("http://staging.wanasatime.com/");
	}
	@Test(priority=1)
	public void verifyforgotpassword() throws InterruptedException
	{
		String checksuccessmsg= ss.forgotpassword();
		Assert.assertEquals(checksuccessmsg, "We have sent a mail to you.Please check your mail.");
		
	}
	 
	@Test(priority=2)  
	public void verifylogin() throws InterruptedException  
	{	
		driver.navigate().to("http://staging.wanasatime.com/");
		ss.clickSignInButton();
		String emptypwd = ss.singInWithEmptyPassword();
		Assert.assertEquals(emptypwd,"Enter a password");
		String invalidinput= ss.singInWithincorrectcredentials();
		Assert.assertEquals(invalidinput,"Invalid credentials" );
		String afterlogin = ss.signinWanasaTimeCredentials();
		Assert.assertEquals(afterlogin, "http://staging.wanasatime.com/");				
		
	}
	
	@Test(priority=3)
	public void verifybookticketevents() throws InterruptedException 
	{
		ss.countrySelection();	
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL,"http://staging.wanasatime.com/Home.aspx?country=Bahrain" );
		//Thread.sleep(4000);
		String success =ss.BookTicketevents();
		Assert.assertEquals(success,"Congratulations! Your Tickets was confirmed.");				
		//Thread.sleep(3000);
	 	//driver.findElement(us.menu1).click();
		//driver.findElement(us.logout).click();
		//driver.navigate().to("http://staging.wanasatime.com/");
	}
			
/*	@Test(priority=4)
	
	public void verifybookticketseventsevoucher() throws InterruptedException
	{
	
	ss.countrySelection();		
	String URL = driver.getCurrentUrl();
	Assert.assertEquals(URL,"http://staging.wanasatime.com/Home.aspx?country=Bahrain" );
	ss.BookTicketeventsVoucher();
	Thread.sleep(2000);
	//Assert.assertEquals(str, "Congratulations! Your Tickets was confirmed.");
	driver.findElement(us.menu1).click();
	driver.findElement(us.logout).click();
	driver.navigate().to("http://staging.wanasatime.com/");
	}*/
	
	@Test
	public void verifymoviebooking() throws InterruptedException
	{
		ss.countrySelection();			
		ss.movieticketbooking();
	}

	
	@Test(priority=4)
	public void verifyfooterlinks ()
    {
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
	}	

}
