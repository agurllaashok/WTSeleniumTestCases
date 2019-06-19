package wanasa;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.BrowserFunctions;

public class useroperations extends BrowserFunctions {
	HomePage ss= new HomePage();
	User us= new User();
	
	@Test
	public void useroperations() throws Exception
	{
		ss.clickSignInButton();
		String emptypwd = ss.singInWithEmptyPassword();
		Assert.assertEquals(emptypwd,"Enter a password");
		String afterlogin = ss.signinWanasaTimeCredentials();
		Assert.assertEquals(afterlogin, "http://staging.wanasatime.com/");
		//ss.signinWanasaTimeCredentials();
		us.edituser();
		us.purchasehistory();
	}

}
