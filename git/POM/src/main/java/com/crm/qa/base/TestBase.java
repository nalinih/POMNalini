package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public WebDriver inti_driver(String browserName){
		System.out.println("Browser name is : " +browserName );
			if (browserName.equals("chrome")){
				//WebDriverManager.chromedriver().setup();
				WebDriverManager.chromedriver().version("80.0").setup();
				driver = new ChromeDriver();
				}
			else if (browserName.equals("FireFox")){
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else{
				System.out.println(browserName + "is not supporterd please give correct browser name");
				}
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().fullscreen();
			//driver.get("url");
			return driver;
			
			
				
			}public Properties inti_properties(){
				prop = new Properties();
				String path =".\\src\\main\\java\\com\\crm\\qa\\config\\config.properties";
				try {
					FileInputStream ip = new FileInputStream(path);
					prop.load(ip);
				} catch (FileNotFoundException e) {
					
					System.out.println("some issues with config properties...");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		return prop;
	}
		
	}


