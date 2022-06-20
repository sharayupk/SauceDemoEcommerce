package com.SauceDemo.pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SauceDemo.testCases.BaseClass;

public class AddToCartPage  extends BaseClass{

	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[text()='Your Cart']")
	WebElement addToCartText;
	@FindBy(id="checkout")
	WebElement checkoutBtn;

	public String validateAddToCartPageURL()
	{
		return driver.getCurrentUrl();
	}

	public boolean validateAddToCartText()
	{
		return addToCartText.isDisplayed();
	}

	public CheckoutPage validateProductsInCart()
	{
		String[] itemsNeeded= {"Sauce Labs Fleece Jacket","Sauce Labs Backpack"};

		List<WebElement>productList=driver.findElements(By.cssSelector(".inventory_item_name"));

		for(int i=0;i<productList.size();i++)
		{
			String formattedName=productList.get(i).getText();

			//Convert Array to Arraylist
			List itemsNeededList = Arrays.asList(itemsNeeded);

			if(itemsNeededList.contains(formattedName))
			{
				System.out.println("Test Case Passed");
			}
			else 
			{
				System.out.println("Test Case Failed");
			}
		}

		checkoutBtn.click();

		return new CheckoutPage();

	}
}


