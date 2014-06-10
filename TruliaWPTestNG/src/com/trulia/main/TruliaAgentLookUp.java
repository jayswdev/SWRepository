package com.trulia.main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TruliaAgentLookUp {
	WebDriver driver;
	
	
	public TruliaAgentLookUp(WebDriver driver){
		this.driver = driver;
	}
	
	public String findAgentinFremont(String location){
		
		WebElement agentLink = driver.findElement(By.xpath("//span[text()='Find an Agent']"));
		agentLink.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@title='Locations']")));
		input.clear();
		//input.sendKeys("Fremont, CA");
		input.sendKeys(location);
		
		input.sendKeys(Keys.ENTER);
		
		WebElement span = driver.findElement(By.xpath("//span[@class='h3 headingDoubleInline typeDeemphasize mls txtM']"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return span.getText();
		
	}

}
