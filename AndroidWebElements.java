package PageWiseLoacators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidWebElements {
	 
	public AndroidWebElements(RemoteWebDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
 
	@AndroidFindBy(id = "com.nowcom.dcmobile:id/et_username")
	public WebElement UserName;
 
	@AndroidFindBy(id = "com.nowcom.dcmobile:id/et_password")
	public WebElement Password;
 
	@AndroidFindBy(id = "com.nowcom.dcmobile:id/btn_login")
	public WebElement LoginButton;
 
	public void Password(String num2) {
		
		Password.sendKeys(num2);
	}
 
	public boolean VerifyResult(String result) {
		if (LoginButton.getText().equals(result))
			return true;
		else
			return false;
	}

	public void UserName(String num1) {
		UserName.sendKeys(num1);
		
	}

	public void LoginButton() {
		// TODO Auto-generated method stub
		
	}
 
}