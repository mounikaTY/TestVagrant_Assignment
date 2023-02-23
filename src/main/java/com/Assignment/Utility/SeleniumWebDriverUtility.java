package com.Assignment.Utility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebDriverUtility {
	
	
	private WebDriver driver;
	private Actions act;
	private	WebElement element;


	/**
	 * This method is used to setup the driver instance
	 * @param browser
	 * @return 
	 */
	@Parameters("browser")
	public WebDriver setUpDriver(String browser) {

		if(browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("InternetExplorer"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("you are not connected to any browser");
		}
		return driver;

	}
	/**
	 * This method is used to maximize the browser
	 */

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait the page by using implicit wait
	 * @param longTimeout
	 */

	public void implicitlyWait(long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}
	/**
	 * This method is used to navigate the application
	 * @param url
	 */

	public void openApplication(String url) {
		driver.get(url);
	}
	/**
	 * This method is used to initialize the Actions class
	 */

	public void intializeActions() {
		act=new Actions(driver);
	}

	/**
	 * This method is used to Mouse hover on Element
	 * @param element
	 */

	public void mouseHoverOnElement(WebElement element) {
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to perform right click action on current mouse location
	 */

	public void rightClickAction() {
		act.contextClick().perform();
	}
	/**
	 * This method is used to perform right click action on WebElement
	 * @param element
	 */

	public void rightClickAction(WebElement element) {
		act.contextClick(element).perform();
	}



	/**
	 * This method is used to switch Frame based on index
	 * @param indexNumber
	 */

	public void switchFrameByIndex(int indexNumber) {
		driver.switchTo().frame(indexNumber);
	}
	/**
	 * This method is used to switch Frame based on WebElement
	 * @param nameOrId
	 */
	public void switchFrameByWebElement(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method is used 
	 * @param strategy
	 */

	public void switchBackFromFrame(String strategy) {
		
		switch(strategy.toLowerCase().trim()) {
		case "default" :
			driver.switchTo().defaultContent();
			break;
		case "parent":
			driver.switchTo().parentFrame();
			break;
		default:
			System.out.println("please Enter valid strategy either <default or parent>");
		}
	}

	/**
	 * This method is used to handle <select> tag dropdown by using Visible Text
	 * @param dopDownElement
	 * @param visibleText
	 */

	public void handleSelectDropDown(WebElement dopDownElement, String visibleText) {
		Select select=new Select(dopDownElement);
		select.selectByVisibleText(visibleText);
	}


	/**
	 * This method is used to handle <select> tag Dropdown by using Attribute Value of <options> Tag
	 * @param value
	 * @param dopDownElement
	 */
	public void handleSelectDropDown(String value,WebElement dropDownElement) {
		Select select=new Select(dropDownElement);
		select.selectByValue(value);
	}

	/**
	 * This method is used to handle <select> tag Dropdown by using Index Number
	 * @param dopDownElement
	 * @param indexNumber
	 */
	public void handleSelectDropDown(WebElement dropDownElement,int indexNumber) {
		Select select=new Select(dropDownElement);
		select.selectByIndex(indexNumber);
	}

	/**
	 * This method is used to close particular browser
	 */
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * This method is used to close particular tab
	 */

	public void closeTab() {
		driver.close();

	}

	public void customWaitToClick(WebElement element, int pollingtime, long timeDuration ) {

		int time=0;
		while(time<timeDuration) {
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				try {
					Thread.sleep(pollingtime);
				}
				catch(InterruptedException e1) {
					e1.printStackTrace();
				}
				time++;
			}
		}
	}
	
	/**
	 * This method is used to for webelement Using custom Explicit
	 * @param element
	 * @param Value
	 * @param pollingtime
	 * @param timeDuration
	 */
	public void customWaitToSendKeys(WebElement element, String Value, int pollingtime, int timeDuration) {

		int time=0;
		while(time<timeDuration) {
			try {
				element.sendKeys(Value);
				break;
			}
			catch(Exception e) {
				try {
					Thread.sleep(pollingtime);
				}
				catch(InterruptedException e1) {
					e1.printStackTrace();
				}
				time++;
			}
		}
	}
	
	
	/**
	 * This Method is used to handle alert  Pop-up
	 */

	public void alertPopUp() {
		driver.switchTo().alert().accept();
	}
	
	
	
	/**
	 * This method is used to switch from one window to another window.
	 */
	
	public void switchWindow() {
		Set<String> windowId = driver.getWindowHandles();
		for(String id:windowId) {
			driver.switchTo().window(id);
		}
		System.out.println(windowId);
		System.out.println(driver.getWindowHandle());
	}



}
