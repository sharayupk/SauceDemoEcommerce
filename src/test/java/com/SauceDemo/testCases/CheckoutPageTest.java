package com.SauceDemo.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SauceDemo.pageObjects.AddToCartPage;
import com.SauceDemo.pageObjects.CheckoutPage;
import com.SauceDemo.pageObjects.HomePage;
import com.SauceDemo.pageObjects.OrderCompletePage;
import com.SauceDemo.pageObjects.ProductsPage;

public class CheckoutPageTest extends BaseClass{

	HomePage homePage;
	ProductsPage productsPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	OrderCompletePage orderCompletePage;

	public CheckoutPageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateCheckoutPageURLTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		addToCartPage=productsPage.addProducts();

		checkoutPage=addToCartPage.validateProductsInCart();
		String actCheckoutPageURL=checkoutPage.validateCheckoutPageURL();

		Assert.assertEquals(actCheckoutPageURL, "https://www.saucedemo.com/checkout-step-one.html");

		logger.info("Validated Checkout Page URL");
	}

	@Test(priority=2)
	public void addCheckoutDetailsTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		addToCartPage=productsPage.addProducts();

		checkoutPage=addToCartPage.validateProductsInCart();
		checkoutPage.addCheckoutDetails(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("zipcode"));

		logger.info("Added Checkout Details on Checkout Page");
	}

	@Test(priority=3)
	public void validateCheckoutDetailsTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		addToCartPage=productsPage.addProducts();

		checkoutPage=addToCartPage.validateProductsInCart();
		checkoutPage.addCheckoutDetails(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("zipcode"));
		orderCompletePage=checkoutPage.validateCheckoutDetails();

		logger.info("Validated Checkout Details on Checkout Page");
	}

}
