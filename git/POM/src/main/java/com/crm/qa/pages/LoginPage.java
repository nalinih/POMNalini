package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	WebDriver driver;
	
	By usernme = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		
	}
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public boolean checkSignUpLink(){
		return driver.findElement(signUpLink).isDisplayed();
	}
	
	public void dologin(String user_name, String pwd){
		driver.findElement(usernme).sendKeys(user_name);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}

}
