package com.SauceDemo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SauceDemo.testCases.BaseClass;

public class OrderCompletePage extends BaseClass{

	public OrderCompletePage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".title")
	WebElement orderCompleteText;
	@FindBy(id="back-to-products")
	WebElement backHomeBtn;

	public String validateOrderCompletePageURL()
	{
		return driver.getCurrentUrl();
	}

	public String validateOrderCompletePageText()
	{
		return orderCompleteText.getText();
	}

	public void clickOnBackHomeBtn()
	{
		backHomeBtn.click();
	}

}
