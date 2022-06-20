package com.SauceDemo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.SauceDemo.testCases.BaseClass;

public class HomePage extends BaseClass{

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".login_logo")
	WebElement swagLabsLogo;
	@FindBy(id="user-name")
	WebElement txtUsername;
	@FindBy(id="password")
	WebElement txtPassword;
	@FindBy(id="login-button")
	WebElement loginBtn;

	public String validateHomePageURL()
	{
		return driver.getCurrentUrl();
	}

	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}

	public boolean validateHomePageLogo()
	{
		return swagLabsLogo.isDisplayed();
	}

	public ProductsPage login(String uid,String pwd)
	{
		txtUsername.sendKeys(uid);
		txtPassword.sendKeys(pwd);
		loginBtn.click();

		return new ProductsPage();
	}


}
