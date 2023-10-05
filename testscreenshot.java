package testNGFramework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class screnshotMultiple {
		public static WebDriver driver;

		@Test
		public void pageLoad() throws InterruptedException, IOException {
			System.setProperty("webdriver.chrome.driver", "/home/rahul/Desktop/Selenium/chromedriver_linux64/chromedriver");
		    driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.name("password")).sendKeys("secret_sauce");
			driver.findElement(By.xpath("//input[@id='login-button']")).click();
			Thread.sleep(5000);
			getscreenshot();
		}
		
		private static void getscreenshot() throws IOException {
			
			File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile, new File("/home/rahul/Desktop/Selenium/screenshot demo/saucedemo"+System.currentTimeMillis()+".png"));
		}

		

	}
