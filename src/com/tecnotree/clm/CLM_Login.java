package com.tecnotree.clm;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CLM_Login {
	@SuppressWarnings("deprecation")
	@Test
	public void testLaunch() throws InterruptedException{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://tecnotree.com");
		driver.findElement(By.id("Search_header")).clear();
		driver.findElement(By.id("Search_header")).sendKeys("CLM");
		driver.findElement(By.name("SearchButton")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains("Search for \"CLM\" returned 5 matches"));
	}
}
