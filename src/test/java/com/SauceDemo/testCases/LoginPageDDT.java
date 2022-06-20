package com.SauceDemo.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SauceDemo.pageObjects.HomePage;
import com.SauceDemo.pageObjects.ProductsPage;
import com.SauceDemo.utilities.XLUtils;

public class LoginPageDDT extends BaseClass{

	HomePage homePage;
	ProductsPage productsPage;

	@Test(dataProvider="loginData")
	public void loginTest(String userid,String pwd) throws InterruptedException
	{
		homePage=new HomePage();
		productsPage=homePage.login(userid,pwd);

		logger.info("Login Done Successfully");

		Thread.sleep(2000);

		if(isTextPresent()==true)
		{
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}

		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
		}

	}

	public boolean isTextPresent()
	{
		try {
			driver.findElement(By.cssSelector(".error-message-container.error h3")).isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@DataProvider
	public Object[][] loginData() throws IOException
	{
		String excelPath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\SauceDemo\\testData\\testData.xlsx";

		int rowCount=XLUtils.getRowCount(excelPath, "Sheet1");
		int cellCount=XLUtils.getCellCount(excelPath, "Sheet1", 0);

		String loginData[][]=new String[rowCount][cellCount];

		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(excelPath, "Sheet1", i, j);
			}
		}

		return loginData;
	}

}
