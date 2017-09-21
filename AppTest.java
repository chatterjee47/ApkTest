package AndroidTest.ApkTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class AppTest {
WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException{
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformVersion", "4.4.2");
    capabilities.setCapability("platformName","Android");
    capabilities.setCapability("deviceName", "AndroidTest");
    capabilities.setCapability("apkPackage","com.nowcom.dcmobile");
    capabilities.setCapability("apkActivity","com.nowcom.dcmobile.screens.SplashActivity");
    
    driver = new RemoteWebDriver(new URL("http://127.0.0.1:8888/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(500);
    System.out.println("Application Opened Successfully");
    
         }

    @Test
    public void testCal() throws Exception {
    	WebElement EnteredUserName = driver.findElement(By.id("com.nowcom.dcmobile:id/et_username"));
        EnteredUserName.sendKeys("siva");
        System.out.println("UserName entered successfully");
        
        WebElement EnteredPassword = driver.findElement(By.id("com.nowcom.dcmobile:id/et_password"));
        EnteredPassword.sendKeys("123abc");
        System.out.println("Password entered successfully");
        
        WebElement Loginbutton = driver.findElement(By.id("com.nowcom.dcmobile:id/btn_login"));
        Loginbutton.click();
        System.out.println("Login button clicked");
        
        
        
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.nowcom.dcmobile:id/iv_plus")));
        
        
        try {
        if(driver.findElement(By.id("com.nowcom.dcmobile:id/iv_plus")).isDisplayed()) 
        {
        	System.out.println("Plusbutton button clicked");
        	driver.findElement(By.id("com.nowcom.dcmobile:id/iv_plus")).click();
        }else 
        {
        	System.out.println("Plusbutton button Not Present");
        }} catch (Exception e) 
        {
        	System.out.println("Plusbutton button Not Present");
        }
        
        WebElement EnterVIN = driver.findElement(By.id("com.nowcom.dcmobile:id/et_enterVIN"));
        EnterVIN.sendKeys("19XFB2F99CE343178");
        System.out.println("VIN entered successfully");
        
        
        WebElement ScanVIN = driver.findElement(By.id("com.nowcom.dcmobile:id/bn_buttonScan"));
        ScanVIN.click();
        System.out.println("ScanVIN button clicked");
        
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         try {
        if(driver.findElement(By.id("com.nowcom.dcmobile:id/tv_tick_sel_trim_list_item")).isDisplayed()) 
        {
        	System.out.println("Item List Present");
        	driver.findElement(By.id("com.nowcom.dcmobile:id/tv_tick_sel_trim_list_item")).click();
        }else 
        {
        	System.out.println("Item List Not Present");
        }
         } catch (Exception e1) {
        	 System.out.println("Next Button Not Present");
        	 if(driver.findElement(By.id("com.nowcom.dcmobile:id/et_etxtdone")).isEnabled())
             {
             	System.out.println("Mileage textbox Present");
             	driver.findElement(By.id("com.nowcom.dcmobile:id/et_etxtdone")).sendKeys("1000");
             }else 
             {
             	System.out.println("Mileage textbox Not Present");
             }
             Thread.sleep(500);      
             if(driver.findElement(By.id("com.nowcom.dcmobile:id/bt_addvehicleDone")).isDisplayed())
             {
             	System.out.println("Done button Present");
             	driver.findElement(By.id("com.nowcom.dcmobile:id/bt_addvehicleDone")).click();
             }else 
             {
             	System.out.println("Done button Not Present");
             }
         }
        for (int i =0 ; i <= 10; i++) 
            {
        	System.out.println("Value Of I:"+i);
        	Thread.sleep(1000);
        try {
        	driver.findElement(By.id("com.nowcom.dcmobile:id/bt_selTrimNext"));
        	driver.findElement(By.id("com.nowcom.dcmobile:id/bt_selTrimNext")).click();
        }catch (Exception e) {
        	System.out.println("Next Button Not Present");
        	Thread.sleep(1000);
        	try {
        	 if(driver.findElement(By.id("com.nowcom.dcmobile:id/et_etxtdone")).isEnabled())
             {
             	System.out.println("Mileage textbox Present");
             	driver.findElement(By.id("com.nowcom.dcmobile:id/et_etxtdone")).sendKeys("1000");
             }}catch (Exception e1) {
             	System.out.println("Mileage textbox Not Present");
             }
             Thread.sleep(1000); 
             
             try {
             if(driver.findElement(By.id("com.nowcom.dcmobile:id/bt_addvehicleDone")).isDisplayed())
             {
             	System.out.println("Done button Present");
             	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             	driver.findElement(By.id("com.nowcom.dcmobile:id/bt_addvehicleDone")).click();
             }}catch (Exception e2) {
             	System.out.println("Done button Not Present");
             }
             break;
             }
            }
    }
         
     public void ExplicitWait(WebElement element)
        {
        (new WebDriverWait(driver ,10)).until(ExpectedConditions.elementToBeClickable(element));

        }

        


     @AfterClass
     public void teardown(){
	     //close the app
	      driver.quit();
}
}
