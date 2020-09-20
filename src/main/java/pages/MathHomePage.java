package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.codoid.products.exception.FilloException;

import lib.Global;
import lib.TestData;
import lib.Utility;

public class MathHomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="(//a[text()='My Account'])[1]")
	public WebElement lnkHMyAccount;
	
	@FindBy(xpath="(//a[text()='Email Sign-up'])[1]")
	public WebElement lnkHMEmailSignup;
	
	public MathHomePage() {
		driver = Utility.returnDriver();
		PageFactory.initElements(driver, this);
	}
	
	//Business components
	public void home() throws FilloException {
		
		Global.gstrObjDataMap =TestData.readTestdata(Global.gstrID, Global.gstrClassName, Global.gstrMethodName);
		
		driver.get(Global.gstrAppURL);
		
		Utility.clickElement(lnkHMyAccount, "My Account", "HMyAccountClick");
		Utility.clickElement(lnkHMEmailSignup, "Sign up", "HMEmailSignupClick");
		
		System.out.println("home function");
	}
	
	
	
}
