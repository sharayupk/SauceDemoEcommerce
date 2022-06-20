package com.SauceDemo.testCases;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.SauceDemo.pageObjects.AddToCartPage;
import com.SauceDemo.pageObjects.CheckoutPage;
import com.SauceDemo.pageObjects.HomePage;
import com.SauceDemo.pageObjects.OrderCompletePage;
import com.SauceDemo.pageObjects.ProductsPage;

public class OrderCompletePageTest extends BaseClass{

	HomePage homePage;
	ProductsPage productsPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	OrderCompletePage orderCompletePage;

	public OrderCompletePageTest()
	{
		super();
	}

	@Test(priority=1)
	public void validateOrderCompletePageURLTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		addToCartPage=productsPage.addProducts();

		checkoutPage=addToCartPage.validateProductsInCart();
		checkoutPage.addCheckoutDetails(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("zipcode"));
		orderCompletePage=checkoutPage.validateCheckoutDetails();

		String actOrderCompletePageURL=orderCompletePage.validateOrderCompletePageURL();
		Assert.assertEquals(actOrderCompletePageURL, "https://www.saucedemo.com/checkout-complete.html");

		logger.info("Validated Order Complete Page URL");
	}

	@Test(priority=2)
	public void validateOrderCompletePageTextTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		addToCartPage=productsPage.addProducts();

		checkoutPage=addToCartPage.validateProductsInCart();
		checkoutPage.addCheckoutDetails(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("zipcode"));
		orderCompletePage=checkoutPage.validateCheckoutDetails();

		String actOrderCompletePageText=orderCompletePage.validateOrderCompletePageText();
		Assert.assertEquals(actOrderCompletePageText, "CHECKOUT: COMPLETE!");

		logger.info("Validated Order Complete Page Text");
	}

	@Test(priority=3)
	public void clickOnBackHomeBtnTest()
	{
		homePage=new HomePage();
		productsPage=homePage.login(prop.getProperty("username"), prop.getProperty("password"));

		addToCartPage=productsPage.addProducts();

		checkoutPage=addToCartPage.validateProductsInCart();
		checkoutPage.addCheckoutDetails(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("zipcode"));

		orderCompletePage=checkoutPage.validateCheckoutDetails();

		orderCompletePage.clickOnBackHomeBtn();

		logger.info("Clicked On Back Home Btn on Order Complete Page");
	}

}
