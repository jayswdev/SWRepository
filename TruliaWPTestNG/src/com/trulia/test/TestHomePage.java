package com.trulia.test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.trulia.main.TruliaHomepage;

public class TestHomePage {
	
	WebDriver driver;
	String baseURL = "http://www.trulia.com/";
	
	
	@BeforeMethod
	public void openBrowser(){
	driver = new FirefoxDriver();
	driver.get(baseURL);
	Reporter.log("Browser started");
	
	}
	
	
	@Test
	public void test1(){
		Reporter.log("testing Page Title");
		TruliaHomepage hp = new TruliaHomepage(driver);
		String actual = hp.getPageTitle();
		Assert.assertTrue(actual.contains("Trulia"));
		
			
		}
		
	@Test
	public void test2(){
		Reporter.log("Testing images on homepage");
		TruliaHomepage hp = new TruliaHomepage(driver);
		int actual = hp.getAllImg();
		Assert.assertTrue(actual>5);
	}
	
	@Test(groups="Links")
	public void test3(){
		Reporter.log("Testing Real Estate Links");
		TruliaHomepage hp = new TruliaHomepage(driver);
		List<WebElement> allReLinks = hp.getLinks();
		
		System.out.println(allReLinks);
		
		Assert.assertTrue(allReLinks.size()==33);
		
		
	}
	
	@Test(groups="Links")
	public void test4(){
		Reporter.log("TEsting local links");
		TruliaHomepage hp = new TruliaHomepage(driver);
		List<WebElement> allLocalLinks = hp.getLocalLinks();
		System.out.println("Actual links :"+ allLocalLinks.size());
		Assert.assertTrue(allLocalLinks.size()==30);
	}
	
	
	
	@AfterMethod
	public void closebrowser(){
		if(driver!=null) driver.close();
		
	}

}
