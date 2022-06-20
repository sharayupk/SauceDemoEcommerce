package com.SauceDemo.pageObjects;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.SauceDemo.testCases.BaseClass;

public class CheckoutPage extends BaseClass{

	public CheckoutPage()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="first-name")
	WebElement txtFirstname;
	@FindBy(id="last-name")
	WebElement txtLastname;
	@FindBy(id="postal-code")
	WebElement txtZipcode;
	@FindBy(id="continue")
	WebElement continueBtn;
	@FindBy(css=".summary_subtotal_label")
	WebElement itemTotal;
	@FindBy(css=".summary_tax_label")
	WebElement taxPrice;
	@FindBy(css=".summary_total_label")
	WebElement total;
	@FindBy(css=".summary_value_label")
	WebElement paymentInfo;
	@FindBy(id="finish")
	WebElement finishBtn;

	public String validateCheckoutPageURL()
	{
		return driver.getCurrentUrl();
	}

	public void addCheckoutDetails(String fn,String ln,String zipcode)
	{
		txtFirstname.sendKeys(fn);
		txtLastname.sendKeys(ln);
		txtZipcode.sendKeys(zipcode);
		continueBtn.click();
	}

	public OrderCompletePage validateCheckoutDetails()
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

		String actPaymentInfo=paymentInfo.getText();
		System.out.println("Actual Payment Info--->"+actPaymentInfo);

		Assert.assertEquals(actPaymentInfo, "SauceCard #31337");

		Double actItemTotal = Parse(itemTotal);
		System.out.println("Actual Item Price--->"+actItemTotal);
		Double actTax = Parse(taxPrice);
		System.out.println("Actual Tax Price--->"+actTax);

		Double expTotal= actItemTotal+actTax;
		System.out.println("Expected Total Price--->"+expTotal);

		Double actTotal = Parse(total);
		System.out.println("Actual Total Price--->"+actTotal);

		//Assert.assertEquals(actTotal, expTotal, "Total Price of products does not match");

		finishBtn.click();

		return new OrderCompletePage();

	}

	static Double Parse(WebElement element) {
		return Double.parseDouble(element.getText().split(":")[1].replace("$","").trim());
	}


}

