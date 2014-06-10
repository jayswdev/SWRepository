package com.trulia.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TruliaHomepage {
	WebDriver driver;
	
	public TruliaHomepage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getPageTitle(){
		String title = driver.getTitle();
		
		
		return title;
	}
	
	public int getAllImg(){
		
		List<WebElement> allImages = driver.findElements(By.tagName("img"));
		
		
		
		return allImages.size();
	}
	
	public List<WebElement> getLinks(){
		
		List<WebElement> allReLinks = driver.findElements(By.xpath("//dl[@class='real_estate']/dd/a"));
		
		return allReLinks;
	}
	
	public List<WebElement> getLocalLinks(){
		List<WebElement> allLocalLinks = driver.findElements(By.xpath("//dl[@class='local_links']//a"));
		return allLocalLinks;
		
		
	}

}
