package AndroidTest.ApkTest;

import lib.ExcelDataConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageExcel {
	
	   @Test(dataProvider = "getData")
	    public void Login(String UserName , String Password) throws InterruptedException{
		   
		   
		System.setProperty("webdriver.chrome.driver", "E:\\MobileAutomation\\NowComAdroidApplication\\ApkTest\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rummycircle.com/");
	    
	    driver.manage().window().maximize();
	    driver.findElement(By.id("login_username")).sendKeys(UserName);
	    driver.findElement(By.id("login_password")).sendKeys(Password);
	    driver.findElement(By.id("btn_login_desktop")).click();
	    Thread.sleep(1000);
	    driver.quit();
	    
	    
	}
	   
	   
	   @DataProvider(name = "getData")
	   public Object[][] passData(){
		   
		   ExcelDataConfig config = new ExcelDataConfig("E:\\MobileAutomation\\NowComAdroidApplication\\ApkTest\\Datafile\\TestData.xlsx");
		   
		   int rows = config.getRowCount(0);
		   Object[][] data = new Object[rows][2];

		   for(int i =0;i<rows;i++)
		   {
			   data[i][0]=config.getData(0,i,0);
			   data[i][1]=config.getData(0,i,1);
		   }
		   
		return data;
				   
				   
	   }

}
