package com.epam.igor_shumskyi.mentoring;


import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_tr {
	private final String USER_AGENT = "Mozilla/5.0";
	WebDriver driver;
	String trName = "TR_06";
	boolean flag = false;
	
	@Before
	public void setUpSystem() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://10.28.9.143:8080/secure/TestManagementAction.jspa");
		
		WebElement username = driver.findElement(By.id("login-form-username"));
		WebElement password = driver.findElement(By.id("login-form-password"));
		WebElement login = driver.findElement(By.id("login-form-submit"));
		
		username.sendKeys("admin");
		password.sendKeys("admin");
		login.click();
		
	}
	@Test
	public void createTR () throws Exception {
		WebElement createTRbutton = driver.findElement(By.id("tm-create-test-run"));
		createTRbutton.click();
		WebElement enterRTname = driver.findElement(By.id("summary"));
		WebElement createSubmit = driver.findElement(By.id("create-tr-submit"));
		
		enterRTname.sendKeys(trName);
		createSubmit.click();
		flag = driver.findElement(By.xpath("//div[@class='tm-organizer']//span[text()='"+trName+"']")).isDisplayed();
		Assert.assertTrue(flag);
		
	}
	@After
	public void shotDown () throws Exception {
		
		this.sendPost(flag);
		driver.quit();
	}
	
	
	private void sendPost(boolean flag) throws Exception {
		 

	}
}


