package com.SauceDemo.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.SauceDemo.utilities.Utils;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;

	public BaseClass()
	{
		try {
			FileInputStream fis=new FileInputStream("./Configuration\\config.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void initialization()
	{
		logger=Logger.getLogger("SauceDemoEcommerce");
		PropertyConfigurator.configure("log4j.properties");

		String browserName=prop.getProperty("browser");

		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			driver=new ChromeDriver();

			logger.info("Chrome Browser Launched");
		}

		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxPath"));
			driver=new FirefoxDriver();

			logger.info("Firefox Browser Launched");
		}

		driver.get(prop.getProperty("url"));
		logger.info("URL Launched");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("Browser Closed");
	}

}
