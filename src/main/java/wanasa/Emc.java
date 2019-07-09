package wanasa;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.BrowserFunctions;
import utils.CommonMethods;

public class Emc extends CommonMethods {
	
			
	//EMC SignUp
	
		By signUpLnk					=	By.id("lnkSignUp");
		By userName						=	By.id("txtName");
		By emailId						=	By.id("txtEmail");
		
		By prefix						=	By.className("flag-container");
		By dailcode						=   By.xpath("//*[@class='country-list']//*[@data-dial-code='973']");
		By mobileNumber					=	By.id("txtPhoneNumber");
		By password						=	By.id("emcPassword");
		By cnfPassword					=	By.id("emcConfirmPassword");
		By signUpBtn					=	By.id("btnSignUp");
		By sucess						=	By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Your account has been created successfully')]");
		
		 public String signUp() throws InterruptedException
		{
			try
			{
			
			driver.findElement(signUpLnk).click();
			CommonMethods cm = new CommonMethods();
			driver.findElement(userName).sendKeys(cm.getSaltString1());	
			Thread.sleep(2000);
			driver.findElement(emailId).sendKeys(cm.getSaltString1()+"@gmail.com");
			Thread.sleep(2000);
			driver.findElement(prefix).click();
			Thread.sleep(2000);
			driver.findElement(dailcode).click();
		
			driver.findElement(mobileNumber).sendKeys("33"+cm.getSaltString());
			Thread.sleep(2000);
			driver.findElement(password).sendKeys("manjusha1");	
			Thread.sleep(2000);
			driver.findElement(cnfPassword).sendKeys("manjusha1");		
			driver.findElement(signUpBtn).click();
			Thread.sleep(4000);
			}
			catch(Exception ex)
			{
				
			}
			return driver.findElement(sucess).getText();
			
		}
		
		
		// Forgot Password
		
			By forgotlnk			=	By.id("lnkForgot");
			By forgotEmail			=	By.id("userEmailForgotEmail");
			By forgotBtn			=	By.id("btnForgotPassword");
			By forgotsuccess		=	By.xpath("//*[contains(@class,'toast-message') and contains(text(),'We have sent a mail to you.Please check your mail.')]");
			By loginbtnInForgot		=	By.id("haveAcc");
	
 public String forgotPassword()
	{
		try
		{
			driver.findElement(forgotlnk).click();
			Thread.sleep(2000);
			driver.findElement(forgotEmail).sendKeys(CommonMethods.passingData("EnterMail"));
			Thread.sleep(2000);
			driver.findElement(forgotBtn).click();
			Thread.sleep(6000);
		}
		catch(Exception ex)
		{
			
		}
		return driver.findElement(forgotsuccess).getText();
		
	}
		
		//Login 
	
			By usermail        				= 	By.id("userEmail");
			By pwd							=	By.id("password");
			By logingBtn					=	By.id("validateLogin");
			By emtyEmailErr					=	By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Please enter Email')]");
			By emptyPaswdErr				=	By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Please enter Password')]");
			By incorrEmail				    =	By.xpath("//*[contains(@class,'toast-message') and contains(text(),'EmailId not Registered')]");
			By incorrpaswd					=	By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Password Incorrect')]");
		
		
		public String signInEmptyEmail() 
		{
			try
			{   
				driver.findElement(usermail).sendKeys("");
				driver.findElement(pwd).sendKeys(CommonMethods.passingData("EmcPassword"));
				Thread.sleep(2000);
				driver.findElement(logingBtn).click();
				Thread.sleep(4000);
			}
			catch(Exception ex)
			{
				
			}
			return driver.findElement(emtyEmailErr).getText();
		}
		
		public String signInEmptyPassword() 
		{
			try
			{
				driver.findElement(usermail).sendKeys(CommonMethods.passingData("EnterMail"));
				driver.findElement(pwd).clear();
				driver.findElement(pwd).sendKeys("");
				Thread.sleep(2000);
				driver.findElement(logingBtn).click();
				Thread.sleep(4000);
			}
			catch(Exception ex)
			{
				
			}
			return driver.findElement(emptyPaswdErr).getText();
						
		}
		
		public String signInInvalidCredentials()
		{
			try
			{
				driver.findElement(usermail).clear();
				Thread.sleep(2000);
				driver.findElement(usermail).sendKeys("nagamanjusha@gmail.com");
				Thread.sleep(2000);
				driver.findElement(pwd).sendKeys(CommonMethods.passingData("EmcPassword"));
				Thread.sleep(2000);
				driver.findElement(logingBtn).click();
				Thread.sleep(4000);
			}
			catch(Exception ex)
			{
				
			}
			return driver.findElement(incorrEmail).getText();
						
		}
		
		public String signInValidCredentials()
		{
				try
				{
					driver.findElement(usermail).clear();
					driver.findElement(usermail).sendKeys(CommonMethods.passingData("EnterMail"));
					Thread.sleep(2000);
					driver.findElement(pwd).clear();
					driver.findElement(pwd).sendKeys(CommonMethods.passingData("EmcPassword"));
					Thread.sleep(2000);
					driver.findElement(logingBtn).click();
					Thread.sleep(3000);
				}
				catch(Exception ex)
				{
					
				}
				String url=driver.getCurrentUrl();
				return url;
		}
	}
