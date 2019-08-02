package com.selllabs;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FirstWebDriver {
	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		SoftAssert soft=new SoftAssert();
		driver.manage().window().maximize();
		driver.get("https://mail.google.com/");
		//WebElement but=driver.findElement(By.id("identifierId"));
		driver.findElement(By.id("identifierId")).sendKeys("pragati.palwe");
		driver.findElement(By.id("identifierNext")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		driver.findElement(By.name("password")).sendKeys("Beauty@17");
		//driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("abc");
		driver.findElement(By.id("passwordNext")).click();
		/*driver.findElement(By.xpath("//span[@class='gb_ya gbii']")).click();
		driver.findElement(By.linkText("Sign Out")).click();*/
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//String exp="Inbox (20) - pragati.palwe@gmail.com";
		String act=driver.getTitle();
			//soft.assertEquals(act, exp);
			try {
				soft.assertTrue(act.contains("pragati.palwe@gmail.com - gmail"),"Title doesnt matched");
				System.out.println("Matched");
			} catch (AssertionError e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			
			soft.assertAll();
	}
}
		
		


