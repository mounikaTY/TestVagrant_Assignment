package com.Assignment.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Assignment.Utility.SeleniumWebDriverUtility;

public class WikiPediaPom {
	
	@FindBy(xpath="//div[text()='Release date' ]/parent::th/following-sibling::td//li")
	private WebElement scrollElement;
	
	@FindBy(xpath="//div[text()='Release date' ]/parent::th/following-sibling::td//li")
	private WebElement releaseDate;
	
	@FindBy(xpath="//th[text()='Country']/following-sibling::td[@class='infobox-data']")
	private WebElement countryName;
	
	public WikiPediaPom(WebDriver driver) {
		PageFactory.initElements(driver, this);   
	}
	/**
	 * This method is used to get the details of Country Name 
	 * @param webUtility
	 * @param url1
	 * @param driver
	 * @return
	 */
	public String getCountry(SeleniumWebDriverUtility webdriverUtility , String url1, WebDriver driver) {
		//SeleniumWebDriverUtility webdriverUtility = new SeleniumWebDriverUtility();
		webdriverUtility.openApplication(url1);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrollElement);
		return countryName.getText();
	}
	/**
	 * This method is used to get the Release date
	 * @return
	 */
	public String getReleaseDate() {
		return releaseDate.getText();
	}

}
