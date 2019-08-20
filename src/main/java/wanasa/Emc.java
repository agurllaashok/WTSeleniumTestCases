package wanasa;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.BrowserFunctions;
import utils.CommonMethods;

public class Emc extends BrowserFunctions {
	
			
	//EMC SignUp
	
		By signUpLnk					=	By.id("lnkSignUp");
		By userName						=	By.id("txtName");
		By emailId						=	By.id("txtEmail");
		By userNameClick				=	By.id("loginDp");
		By lagout						=	By.id("logOut");
				
		
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
		//	Thread.sleep(2000);
			driver.findElement(emailId).sendKeys(cm.getSaltString1()+"@gmail.com");
		//	Thread.sleep(2000);
			driver.findElement(prefix).click();
		//	Thread.sleep(2000);
			driver.findElement(dailcode).click();
		
			driver.findElement(mobileNumber).sendKeys("33"+cm.getSaltString());
			//Thread.sleep(2000);
			driver.findElement(password).sendKeys("manjusha1");	
			//Thread.sleep(2000);
			driver.findElement(cnfPassword).sendKeys("manjusha1");		
			driver.findElement(signUpBtn).click();
			//Thread.sleep(4000);
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
			//Thread.sleep(2000);
			driver.findElement(forgotEmail).sendKeys(CommonMethods.passingData("EnterMail"));
			//Thread.sleep(2000);
			driver.findElement(forgotBtn).click();
			//Thread.sleep(6000);
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
		
			
			//logout 
			
			By profiledropdown = By.id("loginDp");
			By logout 		   = By.xpath("//a[@id='logOut']");
		
		public String signInEmptyEmail() 
		{
			try
			{   
				driver.findElement(usermail).sendKeys("");
				driver.findElement(pwd).sendKeys(CommonMethods.passingData("EmcPassword"));
				//Thread.sleep(2000);
				driver.findElement(logingBtn).click();
				//Thread.sleep(2000);
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
				//Thread.sleep(2000);
				driver.findElement(logingBtn).click();
				//Thread.sleep(4000);
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
				//Thread.sleep(2000);
				driver.findElement(usermail).sendKeys("nagamanjusha@gmail.com");
				//Thread.sleep(2000);
				driver.findElement(pwd).sendKeys(CommonMethods.passingData("EmcPassword"));
				//Thread.sleep(2000);
				driver.findElement(logingBtn).click();
				//Thread.sleep(4000);
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
					driver.findElement(usermail).sendKeys(CommonMethods.passingData("emcmail"));
					//Thread.sleep(2000);
					driver.findElement(pwd).clear();
					driver.findElement(pwd).sendKeys(CommonMethods.passingData("EmcPassword"));
					//Thread.sleep(2000);
					driver.findElement(logingBtn).click();
					//Thread.sleep(3000);
				}
				catch(Exception ex)
				{
					
				}
				String url=driver.getCurrentUrl();
				return url;
		}
		
		//event creation 
		
		By eventsclick	= By.id("events");
		By createEvent	= By.id("createEventM");
		By eventName	= By.id("txtEventName");
		By venue		= By.id("txtVenue");
		By location		= By.id("txtLocation");
		By selectloc	= By.xpath("//*[@class='pac-container pac-logo']//span[contains(text(),'rain International Airport')]");
		By startDate	= By.id("txtStDate");
		By dateselections = By.xpath("//*[@class='ui-state-default']");
		By endDate		= By.id("txtEdDate");
		By startTime	= By.id("txtStTime");
		By endTime		= By.id("txtEdTime");
		
		//timeslot1
		By addslot		= By.xpath("//*[@id='btnAddMultipleSlots']/i");
		By starttime1   = By.id("txtStTime1");
		By endtime1		= By.id("txtEdTime1");
		
		
		// repeate event 	
		By toggleyes 	= By.xpath("//*[@id='uniform-repeat']//span[2]	");	
		
		
		// repeate event 
		By ddlrpt		= By.id("ddlRepeat");	
		By save			= By.id("btnSaveSchedule");
		
	
		
		By eventDescr	= By.xpath("//*[@id='event_panel']/div[2]/div[6]/div/div/div");		
		By thumbImage	= By.id("thumbUpload");
		By saveChanges1	= By.linkText("Save changes");
		By next1		= By.id("btnCreateEventNext");
		
		//section2
		//subcatfree
		By freecat				= 		By.id("btnFreeTicket");
		By freecatName			= 		By.id("txtFTicketName_1");
		By maxTickets			=		By.id("freeTicketsMax_1");
		By maxTicketsfree		= 		By.id("freeTicketsMax_1");
		By subcatfreeclick 	    = 		By.id("fsub_1");
		By subcatfree1      	= 		By.id("fname_1");
		By subcatfree2      	= 		By.id("fname_2");
		By additionalfields	    = 		By.id("showFree_1");
		By savechangesfree      = 		By.id("saveFTicket_1");
		
		//subcat paid1 
		By paidcat		= By.id("btnPaidTicket");
		By paidName		= By.id("paidTicketName_1");
		By paidtktstotal= By.id("paidTicketsQuantity_1");
		By paidsubcatadd  = By.id("pSub_1");
		By paidsubcat1  = By.id("pName_1");
		By paidsubcat1cost1 =By.id("pPrice_1");
		By paidsubcat2  = By.id("pName_2");
		By paidsubcat1cost2 =By.id("pPrice_2");
		By paidadditional = By.id("showPaid_1");		
		By savepaid1	= By.id("savePTicket_1");
		
		//subcat paid1 
		
		By paidName2		= By.id("paidTicketName_2");
		By paidtktstotal2= By.id("paidTicketsQuantity_2");
		By paidsubcatadd2  = By.id("pSub_2");
		By paidsubcat3  = By.id("pName_3");
		By paidsubcat1cost3 =By.id("pPrice_3");
		By paidsubcat4  = By.id("pName_4");
		By paidsubcat1cost4 =By.id("pPrice_4");
		By paidadditional2 = By.id("showPaid_2"); //maxPTickets_2
		By savepaid2	= By.id("savePTicket_2");	
		By next2		= By.id("btnCreateTicketsSectionNext");
		
		By paidPrice	= By.id("ticketPrice_1");
		By maxticketsPaid	= By.id("paidTicketsQuantity_1");
		By saveChangesP	= By.id("savePTicket_1");
		
		//By next3	= By.id("btnCreateTicketsSectionNext");
		By orgName		= By.id("txtOrgName");
		By orgEmail		= By.id("txtOrgEmail");
		By orgMobile	= By.id("txtOrgMobile");
		By orgCompany	= By.id("txtOrgCompany");
		By orgDescri	= By.id("txtOrgAbout");
		By next3		= By.id("btnCreateOrgSectionNext");
		By termsAndCon	= By.xpath("//div[@class='form-group margin-bottom-30']//div[@class='redactor_form-control redactor_editor']");
		By eventType	= By.id("ddlEventType");
		By eventCategory	= By.id("ddlEventTopic");
		By pageName		= By.id("friendlyUrl");
		By langues		=	By.xpath("//div[@class='col-md-6']//button[@class='multiselect dropdown-toggle btn btn-default']");
		By checkBox		=	By.xpath("//div[@class='btn-group open']//ul[@class='multiselect-container dropdown-menu']");
		By checkarabic  = By.xpath("//*[@class='checkbox']//*[@value='1']");
		By checkenglish = By.xpath("//*[@class='checkbox']//*[@value='2']");
		By additionalaNote	= By.id("addtionalNote");
		By publi		=	By.id("public");
		By saveEventBtn	= By.id("btnSaveEvent");
		By ok						=	By.id("btnOk");
		By eventsuccess	=	By.xpath("//*[@id='eventSuccessMsg']");
		
		// Single Day Event Creation
		public String createEvent()
		{
			try
			{
				
				driver.findElement(eventsclick).click();
				//Thread.sleep(2000);
				driver.findElement(createEvent).click();
				driver.findElement(eventName).sendKeys("Rain Rain Go Away Come.......");
				driver.findElement(venue).sendKeys("Bahrain Festivals Area, Manama, Bahrain");
				//Thread.sleep(2000);
			/*
			 * Select oSelect1 = new Select(driver.findElement(location));
			 * oSelect1.selectByVisibleText("Bahrain Festivals Area, Manama, Bahrain");
			 * Thread.sleep(2000);
			 */
				driver.findElement(location).sendKeys("Bahrain Fe");
				driver.findElement(selectloc).click();
				//Thread.sleep(2000);
				driver.findElement(startDate).clear();
				//Thread.sleep(2000);
				driver.findElement(startDate).click();
				
				List<WebElement> startDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
				
				for(WebElement ele:startDate)
				{
					
					String date=ele.getText();
					
					if(date.equalsIgnoreCase("31"))
					{
						ele.click();
						break;
					}  
					}
				driver.findElement(endDate).clear();
			//	Thread.sleep(2000);
				driver.findElement(endDate).click();
				
               List<WebElement> endDate=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
				
				for(WebElement ele:endDate)
				{
					
					String date=ele.getText();
					
					if(date.equalsIgnoreCase("31"))
					{
						ele.click();
						break;
					}
					}
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			//	Thread.sleep(2000);
				driver.findElement(eventDescr).click();
			driver.findElement(eventDescr).sendKeys("Rain Rain Go Away come Again Another Day...");
			//Thread.sleep(2000);
		
			driver.findElement(thumbImage).click();
			 StringSelection ss= new StringSelection("C:\\Users\\smsc\\Desktop\\RAiny season.jpg");
			// Thread.sleep(8000);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
			 Robot robot = new Robot();
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 robot.keyRelease(KeyEvent.VK_V);
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.keyRelease(KeyEvent.VK_ENTER);
		// Thread.sleep(14000);
			 driver.findElement(saveChanges1).click();
			// Thread.sleep(7000);
			 driver.findElement(next1).click();
			// Thread.sleep(2000);
			 driver.findElement(freecat).click();
			// Thread.sleep(2000);
			 driver.findElement(freecatName).sendKeys("Free");
			// Thread.sleep(2000);
			 driver.findElement(maxTickets).sendKeys("100");
			// Thread.sleep(2000);
			 driver.findElement(savechangesfree).click();
			// Thread.sleep(2000);
			 driver.findElement(paidcat).click();
			// Thread.sleep(2000);
			 driver.findElement(paidName).sendKeys("Platinum");
			// Thread.sleep(2000);
			 driver.findElement(paidPrice).sendKeys("10");
			// Thread.sleep(2000);
			 driver.findElement(maxticketsPaid).sendKeys("100");
			// Thread.sleep(2000);
			 driver.findElement(saveChangesP).click();
			// Thread.sleep(2000);
			 driver.findElement(next2).click();
			// Thread.sleep(2000);
			 driver.findElement(orgName).sendKeys("Manjusha");
			// Thread.sleep(2000);
			 driver.findElement(orgEmail).sendKeys(CommonMethods.passingData("EnterMail"));
			// Thread.sleep(2000);
			 driver.findElement(orgMobile).sendKeys("9866585555");
			// Thread.sleep(2000);
			 driver.findElement(orgCompany).sendKeys("Event Easy");
			// Thread.sleep(2000);
			 driver.findElement(orgDescri).sendKeys("Make your Event Easy");
			// Thread.sleep(2000);
			 driver.findElement(next3).click();
			// Thread.sleep(2000);
			 driver.findElement(termsAndCon).sendKeys("Must Carry Your Id card");
			// Thread.sleep(2000);
			 driver.findElement(eventType).click();
			 Select oSelect = new Select(driver.findElement(eventType));
				oSelect.selectByIndex(7);
			//	Thread.sleep(2000);
			 driver.findElement(eventCategory).click();
			 Select oSelect2 = new Select(driver.findElement(eventCategory));
				oSelect2.selectByIndex(2);
				//Thread.sleep(2000);
				driver.findElement(pageName).sendKeys("rain-rain");
				driver.findElement(langues).click();
				WebElement elementToClick = driver.findElement(checkBox);
				elementToClick.click();
			      //driver.findElement(checkBox).click();
			     // Thread.sleep(2000);
			      driver.findElement(additionalaNote).sendKeys("Masti Masti");
			    //  Thread.sleep(2000);
			      WebElement elementToClick1 = driver.findElement(publi);
					elementToClick1.click();
			// Thread.sleep(2000);
			 driver.findElement(saveEventBtn).click();
			// Thread.sleep(5000);
			 
			 driver.findElement(ok).click();
			// Thread.sleep(3000);
			 	 
			}
			catch(Exception e)
			{
				
			}
			String url=driver.getCurrentUrl();
			return url;
		}
		
		
	        // Event Creation Multiple subcategories and multiple Time Slots
		
			public String evntcreationmultisubcattimeslot() throws InterruptedException, AWTException
			{
				driver.navigate().to("http://staging.emc.wanasatime.com/Dashboard.aspx");
				driver.findElement(eventsclick).click();
				driver.findElement(createEvent).click();
				driver.findElement(eventName).sendKeys("standup comedy");
				driver.findElement(venue).sendKeys("Bahrain");
				//Bahrain International Airport, Road 2404, Muharraq, Bahrain
				driver.findElement(location).sendKeys("Bah");
				driver.findElement(selectloc).click();
				driver.findElement(startDate).click();
				//Thread.sleep(2000);

				//startdate 				
				List<WebElement> sd = driver.findElements(dateselections);
				System.out.println("total days :"+sd.size());
				for(WebElement date1 : sd)
				{
					String sdate = date1.getText();
					if(sdate.equalsIgnoreCase("15"))
					{
						//Thread.sleep(2000);
						date1.click();
						//Thread.sleep(2000);
						break;
					
					}
				}
				
				//enddate
				driver.findElement(endDate).click();
				List<WebElement> ed = driver.findElements(dateselections);
				System.out.println("total days :"+ed.size());
				for(WebElement date1 : ed)
				{
					String edate = date1.getText();
					if(edate.equalsIgnoreCase("30"))
					{
						//Thread.sleep(2000);
						date1.click();
						//Thread.sleep(2000);
						break;					
					}
				}
								
				//time slots
				//slot1	
				driver.findElement(startTime).clear();
				driver.findElement(startTime).sendKeys("11:00 AM");
				driver.findElement(endTime).clear();
				driver.findElement(endTime).sendKeys("12:30 PM");
				//Thread.sleep(2000);
				
				
				 driver.findElement(addslot).click();
				// Thread.sleep(2000);
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("window.scrollBy(0,600)");
				// Thread.sleep(2000);
				//slot2
				driver.findElement(starttime1).clear();
				driver.findElement(starttime1).sendKeys("05:00 PM");
				driver.findElement(endtime1).clear();
				driver.findElement(endtime1).sendKeys("06:30 PM");
				//Thread.sleep(2000);
						
				// Repeat event
				
				driver.findElement(toggleyes).click();
				//Thread.sleep(2000);
			    Select ddlrept = new Select(driver.findElement(ddlrpt));
			    ddlrept.selectByValue("Daily");
			   // Thread.sleep(2000);
			    driver.findElement(save).click();
			   // Thread.sleep(5000);		
			    
			    driver.findElement(eventDescr).click();
			    driver.findElement(eventDescr).sendKeys("hello");
			    

				 driver.findElement(thumbImage).click();		
				// Thread.sleep(3000);
				 StringSelection ss= new StringSelection("C:\\Users\\Smsc_Tech\\Desktop\\mus6.jpg");
				 //Thread.sleep(8000);
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
				 Robot robot = new Robot();
				 robot.keyPress(KeyEvent.VK_CONTROL);
				 robot.keyPress(KeyEvent.VK_V);
				 robot.keyRelease(KeyEvent.VK_V);
				 robot.keyRelease(KeyEvent.VK_CONTROL);
				 robot.keyPress(KeyEvent.VK_ENTER);
				 robot.keyRelease(KeyEvent.VK_ENTER);
				// Thread.sleep(14000);
				 driver.findElement(saveChanges1).click();
				 //Thread.sleep(4000);
				 driver.findElement(next1).click();
				// Thread.sleep(10000);
				 
				 ///////section2 
				 ////add sub cat(free)
				 
				 driver.findElement(freecat).click();
				 driver.findElement(freecatName).sendKeys("Free");
				// Thread.sleep(2000);
				 driver.findElement(maxTicketsfree).sendKeys("100");
				 //Thread.sleep(2000);
				 //subcat1
				 driver.findElement(subcatfreeclick).click();
				 driver.findElement(subcatfree1).click();
				 driver.findElement(subcatfree1).sendKeys("Audlt");
				 //Thread.sleep(2000);
				 //subcat2 additional fields
				 driver.findElement(subcatfreeclick).click();
				 driver.findElement(subcatfree2).click();
				 driver.findElement(subcatfree2).sendKeys("senior citizen");
				 //Thread.sleep(2000);
				 driver.findElement(additionalfields).click();
				 //Thread.sleep(2000);
				 Select maxtkt= new Select(driver.findElement(By.id("freeTicketsMaxAllowed_1")));
				 maxtkt.selectByValue("4");
				 driver.findElement(savechangesfree).click();
				 //Thread.sleep(3000);
				 
				 ////paid cat/sub cat(gold)	
				// js.executeScript("arguments[0].scrollIntoView();", paidcat);
				 driver.findElement(paidcat).click();
				// js.executeScript("arguments[0].scrollIntoView();", paidName);
				 driver.findElement(paidName).sendKeys("Gold");
				// Thread.sleep(2000);
			      driver.findElement(paidtktstotal).sendKeys("200");
				
				 
				 //paid subcat1(gold)
				 driver.findElement(paidsubcatadd).click();
				 //Thread.sleep(2000);				
				 driver.findElement(paidsubcat1).click();
				 driver.findElement(paidsubcat1).sendKeys("Audlt");
				 driver.findElement(paidsubcat1cost1).sendKeys("5");
				// Thread.sleep(2000);
				 
				 //paid subcat2 paid tkts total(gold)
				 driver.findElement(paidsubcatadd).click();
				// Thread.sleep(2000);				
				 driver.findElement(paidsubcat2).click();
				 driver.findElement(paidsubcat2).sendKeys("Senior citizen");
				 driver.findElement(paidsubcat1cost2).sendKeys("8");
				// Thread.sleep(2000);
				 js.executeScript("window.scrollBy(0,400)");
				// Thread.sleep(2000);
				 driver.findElement(paidadditional).click();				
				// Thread.sleep(2000);	
				 js.executeScript("window.scrollBy(0,1000)");
				 Select maxtkts= new Select(driver.findElement(By.id("maxPTickets_1")));
				 maxtkts.selectByValue("3");
				// Thread.sleep(2000);
				 //js.executeScript("window.scrollBy(0,600)");
				 driver.findElement(savepaid1).click();
				//Thread.sleep(2000);
				 driver.findElement(next2).click();
				 //Thread.sleep(4000);
				 
                 /*				 
				 //paid subcat1(silver)  
				 driver.findElement(paid cat).click();
				 driver.findElement(paidName2).sendKeys("Silver");
				 Thread.sleep(2000);
				 driver.findElement(paidtktstotal2).sendKeys("200");
				 
				 //paid subcat1(silver)
				 driver.findElement(paidsubcatadd2).click();
				 Thread.sleep(2000);				
				 driver.findElement(paidsubcat3).click();
				 driver.findElement(paidsubcat3).sendKeys("Audlt");
				 driver.findElement(paidsubcat1cost3).sendKeys("10");
				 Thread.sleep(2000);
				 
				 //paid subcat2 paid tkts total(silver)
				 driver.findElement(paidsubcatadd2).click();
				 Thread.sleep(2000);				
				 driver.findElement(paidsubcat4).click();
				 driver.findElement(paidsubcat4).sendKeys("Senior citizen");
				 driver.findElement(paidsubcat1cost4).sendKeys("8");
				 Thread.sleep(2000);
				 driver.findElement(paidadditional2).click();
				 Thread.sleep(2000);
				 Select maxtkts1= new Select(driver.findElement(By.id("maxPTickets_2")));
				 maxtkt.selectByValue("4");
				 driver.findElement(savepaid2).click();
				 */
				 
				 
				 //section3
				 driver.findElement(orgName).sendKeys("Manjusha");
				 //Thread.sleep(2000);
				 driver.findElement(orgEmail).sendKeys(CommonMethods.passingData("EnterMail"));
				// Thread.sleep(2000);
				 driver.findElement(orgMobile).sendKeys("9866585555");
				 //Thread.sleep(2000);
				 driver.findElement(orgCompany).sendKeys("Event Easy");
				 //Thread.sleep(2000);
				 driver.findElement(orgDescri).sendKeys("Make your Event Easy");
				 //Thread.sleep(2000);
				 driver.findElement(next3).click();
				// Thread.sleep(4000);
				 
				 
				 //section4
				 js.executeScript("window.scrollBy(0,600)");
				 driver.findElement(termsAndCon).sendKeys("Must Carry Your Id card");
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				 driver.findElement(eventType).click();
				 Select oSelect = new Select(driver.findElement(eventType));
					oSelect.selectByIndex(7);
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				 driver.findElement(eventCategory).click();
				 Select oSelect2 = new Select(driver.findElement(eventCategory));
					oSelect2.selectByIndex(2);
					Thread.sleep(2000);
					driver.findElement(pageName).sendKeys("Stand_stand");
					driver.findElement(langues).click();
					//WebElement elementToClick = driver.findElement(checkBox);
				//	elementToClick.click();				
				      driver.findElement(checkarabic).click();
				      driver.findElement(checkenglish).click();
				      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				      driver.findElement(additionalaNote).sendKeys("Masti Masti");
				      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				      WebElement elementToClick1 = driver.findElement(publi);
						elementToClick1.click();
						driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				 //driver.findElement(saveEventBtn).click();
				// Thread.sleep(5000);
				 
				// driver.findElement(ok).click();
				// Thread.sleep(3000);		
				String url=driver.getCurrentUrl();
				return url;
				
			}
			public String lagout() throws InterruptedException
			{
			driver.findElement(userNameClick).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(lagout).click();
					 		
		String url=driver.getCurrentUrl();
		return url;
	}
	
	public String superAdminLogin()
	{
		try
		{
			//driver.navigate().to("http://staging.emc.wanasatime.com");
			driver.findElement(usermail).sendKeys("superadmin@wanasatime.com");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.findElement(pwd).sendKeys("WanasaTime@1#");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.findElement(logingBtn).click();
		}
		
		catch(Exception e)
		{
			
		}
		
		String url=driver.getCurrentUrl();
		return url;
	}
	
	// Event Approval
	By superEventsClick			=	By.id("events");
	By manageEvents				=	By.id("manageEvents");
	By changeStatus				=	By.xpath("//*[@data-original-title='Approve the event']");
	By verifiedUserDetails		=	By.xpath("//*[@value='Verified all the details']");
	By step1tostep5				=	By.xpath("//*[@value='Event Details are completed From Step 1 to Step 5']");
	By saveBtn					=	By.id("btnSaveNote");
	By sucessApprove			=	By.xpath("//*[contains(@class,'toast-message') and contains(text(),'Approved Successfully)]");
	
	
	public String eventApprove()
	{
	  driver.findElement(superEventsClick).click();
	  driver.findElement(manageEvents).click();
	  driver.findElement(changeStatus).click();
	  driver.findElement(verifiedUserDetails).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  driver.findElement(step1tostep5).click();
	  driver.findElement(saveBtn).click();
	  
	  String url=driver.getCurrentUrl();
	  return url;
	 
	   
	  
	}
			
	}
