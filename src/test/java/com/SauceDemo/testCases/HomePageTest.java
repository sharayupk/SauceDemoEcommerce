package com.SauceDemo.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.pageObjects.HomePage;
import com.SauceDemo.pageObjects.ProductsPage;

public class HomePageTest extends BaseClass{

	HomePage homePage;
	ProductsPage productsPage;

	public HomePageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateHomePageURLTest()
	{
		homePage=new HomePage();
		String actHomePageURL=homePage.validateHomePageURL();

		Assert.assertEquals(actHomePageURL, prop.getProperty("url"));

		logger.info("Validated Home Page URL");
	}

	@Test(priority=2)
	public void validateHomePageTitleTest()
	{
		homePage=new HomePage();
		String actHomePageTitle=homePage.validateHomePageTitle();

		Assert.assertEquals(actHomePageTitle, "Swag Labs");

		logger.info("Validated Home Page Title");
	}

	@Test(priority=3)
	public void validateHomePageLogoTest()
	{
		homePage=new HomePage();
		boolean actHomePageLogo=homePage.validateHomePageLogo();

		Assert.assertTrue(actHomePageLogo);

		logger.info("Validated Home Page Logo");
	}

	@Test(priority=4)
	public void loginTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		logger.info("Login Done Successfully");

	}

}
