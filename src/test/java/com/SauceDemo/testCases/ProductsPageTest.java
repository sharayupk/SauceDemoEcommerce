package com.SauceDemo.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.pageObjects.AddToCartPage;
import com.SauceDemo.pageObjects.HomePage;
import com.SauceDemo.pageObjects.ProductsPage;

public class ProductsPageTest extends BaseClass{

	HomePage homePage;
	ProductsPage productsPage;
	AddToCartPage addToCartPage;

	public ProductsPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateProductsPageURLTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		String actProductsPageURL=productsPage.validateProductsPageURL();

		Assert.assertEquals(actProductsPageURL, "https://www.saucedemo.com/inventory.html");

		logger.info("Validated Products Page URL");
	}

	@Test(priority=2)
	public void addProductsTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		addToCartPage=productsPage.addProducts();

		logger.info("Added Products To Cart");
	}

}
