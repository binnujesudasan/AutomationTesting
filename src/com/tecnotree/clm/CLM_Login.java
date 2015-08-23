package com.tecnotree.clm;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CLM_Login {
	@Test
	public void testLaunch(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://tecnotree.com");
		driver.findElement(By.id("Search_header")).clear();
		driver.findElement(By.id("Search_header")).sendKeys("CLM");
		driver.findElement(By.name("SearchButton")).click();
	}
}
