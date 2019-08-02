package com.selllabs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstTestng extends AnnotTest{
	
	WebDriver driver=new FirefoxDriver();

	@Test(description="Login")
	public void first() {
		
		
		driver.manage().window().maximize();
		driver.get("https://mail.google.com/");
		//WebElement but=driver.findElement(By.id("identifierId"));
		driver.findElement(By.id("identifierId")).sendKeys("pragati.palwe");
		driver.findElement(By.id("identifierNext")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		driver.findElement(By.name("password")).sendKeys("pwd");
		//driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("abc");
		driver.findElement(By.id("passwordNext")).click();
		/*driver.findElement(By.xpath("//span[@class='gb_ya gbii']")).click();
		driver.findElement(By.linkText("Sign Out")).click();*/
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Reporter.log("first()",true);
		}
	}
		
		@Test(description="VerifyTitle", dependsOnMethods="first")
		public void second() {
			SoftAssert soft=new SoftAssert();
		//String exp="Inbox (20) - pragati.palwe@gmail.com";
		  String act=driver.getTitle();
			//soft.assertEquals(act, exp);
			try {
				soft.assertTrue(act.contains("pragati.palwe@gmail.com - Gmail"),"Title doesnt matched with expected title");
				driver.quit();
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}			
			soft.assertAll();
	}
}
