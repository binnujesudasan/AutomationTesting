package com.tecnotree.clm;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
@FixMethodOrder(MethodSorters.JVM)
public class CLM_Login {
	WebDriver driver = null;
	Logger logger = Logger.getLogger("BINNU");
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//logger.log(Logger.INFO, msg, thrown);
		driver.get("http://tecnotree.com");
	}
	@Test
	public void testLaunch() throws InterruptedException{
		driver.findElement(By.id("Search_header")).clear();
		driver.findElement(By.id("Search_header")).sendKeys("CLM");
		driver.findElement(By.name("SearchButton")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains("Search for \"CLM\" returned 5 matches"));
		Thread.sleep(3000);
		List<WebElement> links = driver.findElements(By.xpath("//p[@class='url']/a"));
		int randomNumber = 0;
		if(links.size() > 0){
			randomNumber = (int) (Math.random() * links.size());
		}
		links.get(randomNumber+1).click();
	}
}