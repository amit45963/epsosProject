package com.epsos.authtoken;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthorizationToken{

	@Test(groups= {"Smoke"})
	@Parameters ({"token"})
	public void Token(String token) throws InterruptedException {


		WebDriverManager.chromedriver().clearDriverCache().setup();

		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");

		ChromeDriver driver1 = new ChromeDriver(options);
		driver1.manage().window().maximize();
		System.out.println("Browser driver instantiated");


		driver1.get("https://login.eposnowhq.com/");
		WebElement username = driver1.findElement(By.id("username"));
		WebElement password = driver1.findElement(By.id("password"));

		username.sendKeys("RestaurantOneSolution Ltd");
		password.sendKeys("P@ssw0rd@123");
		Thread.sleep(2000);

		WebElement submit = driver1.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		////Thread.sleep(8000);


		driver1.navigate().to("https://www.eposnowhq.com/Pages/BackOffice/Integrations/REST/RESTManagement.aspx");
		//Thread.sleep(15000);



		//div//div//div
		/*
		 * WebElement element = driver1.findElement(By.xpath(
		 * "//button[@data-qa-id='lwcAppStoreDesignClassic-single-myApps-267-Button']"))
		 * ; JavascriptExecutor js = (JavascriptExecutor) driver1;
		 * js.executeScript("arguments[0].click();", element); Thread.sleep(4000);
		 */


		try {

			WebElement element11 = driver1.findElement(By.xpath("//button[@data-testid='close-button']"));
			element11.click();

		} catch (org.openqa.selenium.NoSuchElementException e) {

			System.out.println("Element not found. Moving forward...");
		}

		try {
			WebElement eeee = driver1.findElement(By.xpath("//ul[@id='subnavHeader']//li//div//img"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver1;
			js1.executeScript("arguments[0].click();", eeee);
			//Thread.sleep(4000);
			//ee10.click();
		}
		catch(org.openqa.selenium.NoSuchElementException e) {

			System.out.println("Element not found. Moving forward...");
		}
		
		//Print all the devices name
		
		List<WebElement> cells11= driver1.findElements(By.xpath("//td//span[starts-with(@id,'MainContentNoUpdate_DeviceGridView_lblName_')]"));
  	  for (WebElement cell2 : cells11) {

          System.out.println("Devices Name :" +cell2.getText());
}


		//String str = "TEST";
  	  String str = token;


		List<WebElement> cells1 = driver1.findElements(By.xpath("//td//span[starts-with(@id,'MainContentNoUpdate_DeviceGridView_lblName_')]"));
		for (WebElement cell : cells1) {

			System.out.println(cell.getText());

			if(str.equals(cell.getText())) {
				//input[@value='Access Credentials']
				WebElement ee1 = driver1.findElement(By.xpath("//input[@value='Access Credentials']"));
				Thread.sleep(4000);
				JavascriptExecutor js111 = (JavascriptExecutor) driver1;
				js111.executeScript("arguments[0].click();", ee1);
				break;

			}
		}

		WebElement ee1ee = driver1.findElement(By.xpath("//span[@id='MainContent_dvDevice_lblAuthToken']"));
		String Token = ee1ee.getText();
		System.out.println(str +" - "+Token);

		driver1.quit();


	}


}
