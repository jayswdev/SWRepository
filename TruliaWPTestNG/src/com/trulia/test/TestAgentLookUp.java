package com.trulia.test;

import java.util.concurrent.TimeUnit;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trulia.main.TruliaAgentLookUp;
import com.trulia.utilities.TruliaDataProWithSQl;
import com.trulia.utilities.TruliaDataProvider;

public class TestAgentLookUp {
	WebDriver driver;
	
	String baseURL = "http://www.trulia.com/";
	
	@BeforeMethod
	public void openBrowser(){
		//driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	
	@Test(dataProviderClass = TruliaDataProWithSQl.class , dataProvider = "myJdbc" )
	public void test1(String location, String expResult){
		TruliaAgentLookUp alp = new TruliaAgentLookUp(driver);
		String actualRes = alp.findAgentinFremont(location);
		
		Assert.assertTrue(actualRes.contains(expResult));
		
	}
	
	
	@AfterMethod
	public void closeBrowser(){
		if(driver!=null)
			driver.close();
		
	}
	


}
