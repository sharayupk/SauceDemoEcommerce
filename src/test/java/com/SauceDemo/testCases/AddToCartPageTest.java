package com.SauceDemo.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.pageObjects.AddToCartPage;
import com.SauceDemo.pageObjects.CheckoutPage;
import com.SauceDemo.pageObjects.HomePage;
import com.SauceDemo.pageObjects.ProductsPage;

public class AddToCartPageTest extends BaseClass{

	HomePage homePage;
	ProductsPage productsPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;

	public AddToCartPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateAddToCartPageURLTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		addToCartPage=productsPage.addProducts();
		String actAddToCartPageURL=addToCartPage.validateAddToCartPageURL();

		Assert.assertEquals(actAddToCartPageURL, "https://www.saucedemo.com/cart.html");

		logger.info("Validated Add To Cart Page URL");
	}

	@Test(priority=2)
	public void validateAddToCartTextTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		addToCartPage=productsPage.addProducts();
		boolean actAddToCartPageText=addToCartPage.validateAddToCartText();

		Assert.assertTrue(actAddToCartPageText);

		logger.info("Validated Add To Cart Text");
	}

	@Test(priority=3)
	public void validateProductsInCartTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		addToCartPage=productsPage.addProducts();

		checkoutPage=addToCartPage.validateProductsInCart();

		logger.info("Validated Products In Cart");
	}

}
