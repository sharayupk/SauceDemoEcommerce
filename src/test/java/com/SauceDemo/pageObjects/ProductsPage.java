package com.SauceDemo.pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.SauceDemo.testCases.BaseClass;

public class ProductsPage extends BaseClass{

	public ProductsPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="shopping_cart_container")
	WebElement addToCartBtn;

	public String validateProductsPageURL()
	{
		return driver.getCurrentUrl();
	}

	public AddToCartPage addProducts()
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
				List<WebElement> addToCartBtn=driver.findElements(By.xpath("//div[@class='pricebar']/button"));
				addToCartBtn.get(i).click();
			}
		}

		//Click on Add To Cart Button
		addToCartBtn.click();

		return new AddToCartPage();
	}

}
