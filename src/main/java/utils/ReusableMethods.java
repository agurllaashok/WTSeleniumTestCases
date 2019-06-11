package utils;

import utils.JsonData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserFunctions;

public class ReusableMethods extends BrowserFunctions{
	
	
	public static void clickMethod(By loactor){
		driver.findElement(loactor).click();
	}
	
	public void getTextMethod(By loactor){
		driver.findElement(loactor).getText();
	}
	
	public static boolean isDisplayedMethod(By loactor){
		explicitWaitForElementVisibility(loactor);
		return driver.findElement(loactor).isDisplayed();
	}
	
	public static void sendKeysMethod(By loactor,String text){
		driver.findElement(loactor).sendKeys(JsonData.passingData(text));
	}
	
	public static void handleAlert()throws InterruptedException{
        if(isAlertPresent()){
            Alert alert = driver.switchTo().alert();
            Thread.sleep(1000);
            alert.accept();
            Thread.sleep(2000);
           // System.out.println("successfully closed the alert");
            driver.navigate().to(homePageUrl);
          }
    }
	
    public static boolean isAlertPresent()  throws InterruptedException{
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
           // System.out.println("Alert is not present");
        }
        return foundAlert;
    }
	
	public static void explicitWaitForElementVisibility(By locator){
		By element = locator;
		WebDriverWait wait= new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public static void explicitWaitForClickableElement(WebDriver driver,WebElement ele){
		WebElement element = ele;
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void explicitWaitForAlert(WebDriver driver){
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
