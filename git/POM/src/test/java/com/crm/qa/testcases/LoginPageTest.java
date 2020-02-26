package com.crm.qa.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest  {
	WebDriver driver;
	TestBase basePage;
	Properties prop;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp(){
		basePage = new TestBase();
		prop = basePage.inti_properties();
		String browserName = prop.getProperty("browser");
		driver=basePage.inti_driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		
		}
	
	@Test(priority=1)
	public void verifyPageTitle() throws InterruptedException{
		Thread.sleep(5000);
		String pageTitle = loginPage.getPageTitle();
		System.out.println("Pae title is : " + pageTitle);
		Assert.assertEquals(pageTitle, "HubSpot Login");
	}
	@Test(priority=2)
	public void verifySignUpLinkTest(){
		Assert.assertTrue(loginPage.checkSignUpLink());
		
	}
	@Test(priority=3)
	public void loginTest(){
		loginPage.dologin(prop.getProperty("username"), "password");
		
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
