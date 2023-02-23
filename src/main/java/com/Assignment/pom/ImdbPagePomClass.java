package com.Assignment.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;



public class ImdbPagePomClass {
	
	public ImdbPagePomClass(WebDriver driver) {
		PageFactory.initElements(driver, this);   
		
	}
	
	@FindBy(id="suggestion-search")
	private WebElement searchTextBox;
		
	@FindBy(xpath="//a[text()='Pushpa: The Rise - Part 1']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//span[text()='Details']")
	private WebElement detailsElement;

	@FindBy(xpath="//a[@href='/search/title/?country_of_origin=IN&ref_=tt_dt_cn']")
	private WebElement countryName;
	

	@FindBy(xpath="//div[@data-testid='title-details-section']/descendant::li[@class='ipc-inline-list__item' and a[@href='/title/tt9389998/releaseinfo?ref_=tt_dt_rdat']]")
	private WebElement ReleaseDate;
	/**
	 * This Method is to get Country Name	
	 * @param movieName
	 * @param driver
	 * @return
	 */
	public String getCountryName(String movieName,  WebDriver driver) {
		searchTextBox.sendKeys(movieName+Keys.ENTER);
		searchBtn.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", detailsElement);
	//	javaScript.scrollIntoView(detailsElement);
		return countryName.getText();
	}
   /**
    * This method is to get Release Date
    * @return
    */
	public String getReleaseDate() {
		String date = ReleaseDate.getText();
		return date;
				
	}
}
