package AndroidTest.ApkTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.ExcelDataConfig;


public class MethodWiseTesting {

    private  RemoteWebDriver driver;
    
    	@Test(dataProvider = "getData")
 	    public void Login(String UserName , String Password , String VINNumber , String Mileage) throws InterruptedException, MalformedURLException{
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
        
        
        WebElement EnteredUserName = driver.findElement(By.id("com.nowcom.dcmobile:id/et_username"));
        EnteredUserName.sendKeys(UserName);
        System.out.println("UserName entered successfully");
        
        WebElement EnteredPassword = driver.findElement(By.id("com.nowcom.dcmobile:id/et_password"));
        EnteredPassword.sendKeys(Password);
        System.out.println("Password entered successfully");
        
        WebElement Loginbutton = driver.findElement(By.id("com.nowcom.dcmobile:id/btn_login"));
        Loginbutton.click();
        System.out.println("Login button clicked");
      


        Thread.sleep(10000);
        Thread.sleep(10000);
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
        EnterVIN.sendKeys(VINNumber);
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
             	driver.findElement(By.id("com.nowcom.dcmobile:id/et_etxtdone")).sendKeys(Mileage);
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
        	Thread.sleep(10000);
        try {
        	driver.findElementById("com.nowcom.dcmobile:id/bt_selTrimNext");
        	driver.findElementById("com.nowcom.dcmobile:id/bt_selTrimNext").click();
        }catch (Exception e) {
        	System.out.println("Next Button Not Present");
        	Thread.sleep(10000);
        	try {
        	 if(driver.findElement(By.id("com.nowcom.dcmobile:id/et_etxtdone")).isEnabled())
             {
             	System.out.println("Mileage textbox Present");
             	driver.findElement(By.id("com.nowcom.dcmobile:id/et_etxtdone")).sendKeys(Mileage);
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
             	Thread.sleep(10000); 
               
             }}catch (Exception e2) {
             	System.out.println("Done button Not Present");
             }
             break;
        } 
            }
        }
    	
    	  @AfterTest
          public void teardown() throws InterruptedException{
   	       //close the app
   	        driver.close();
   	     Thread.sleep(10000); 
         Thread.sleep(10000);
         Thread.sleep(10000);
         Thread.sleep(10000);
         Thread.sleep(10000);
   	     
   }
    	  
    	  
          public void ExplicitWait(WebElement element)
          {
          (new WebDriverWait(driver ,10)).until(ExpectedConditions.elementToBeClickable(element));
          }

          
   
        
           @DataProvider(name = "getData")
 	       public Object[][] passData(){
 		     
 		   ExcelDataConfig config = new ExcelDataConfig("E:\\MobileAutomation\\NowComAdroidApplication\\ApkTest\\Datafile\\TestData.xlsx");
 		   int rows = config.getRowCount(0);
 		   Object[][] data = new Object[rows][4];

 		   for(int i =0;i<rows;i++)
 		   {
 			   data[i][0]=config.getData(0,i,0);
 			   data[i][1]=config.getData(0,i,1);
 			   data[i][2]=config.getData(0,i,2);
 			   data[i][3]=config.getData(0,i,3);
 		   }		   
 		return data;		   
 	   }
 }
