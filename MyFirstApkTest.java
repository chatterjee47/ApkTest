package AndroidTest.ApkTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class MyFirstApkTest {
	
	private  RemoteWebDriver driver;

	public  void main(String[] args) throws MalformedURLException {

		File appDir = new File(System.getProperty("user.dir")+"/app/");
		File app = new File(appDir ,"selendroid-test-app-0.17.0.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"AndroidTest");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"4.4.2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.selendroid.testapp");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.selendroid.testapp.HomeScreenActivity");
	
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	    

	}

}
