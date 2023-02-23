package com.Assignment.Utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Assignment.pom.ImdbPagePomClass;
import com.Assignment.pom.WikiPediaPom;





public class BaseClass {

	public PropertyFileUtility fileUtility;
	public ExcelUtility excelUtility;
	public JavaUtility javaUtility;
	public SeleniumWebDriverUtility webdriverUtility;
	public JavascriptExecutorUtility jsExecutorUtility;
	public int randomNumber ;
	public	String url;
	public	String browser;
	public	String timeouts ;
	public	long longTimeout;
	public WebDriver driver;
	public String url1 ;
	public  String moviename ;
	public ImdbPagePomClass imdb;
	public WikiPediaPom wiki;



	@BeforeClass
	public void suiteSetup()
	{
		fileUtility = new PropertyFileUtility();
		excelUtility = new ExcelUtility();
		javaUtility = new JavaUtility();
		webdriverUtility = new SeleniumWebDriverUtility();
		jsExecutorUtility = new JavascriptExecutorUtility();

		fileUtility.initializePropertyFile(IpathConstants.AssignmentPropertyFilePath);

		randomNumber = javaUtility.getRandomNumber();

		// Get the control for particular sheet in Excel File
		excelUtility.initializeExcelFile(IpathConstants.AssignmentExcelPath);

		// fetch the data from Property file
		url= fileUtility.getDataFromPropertyFile("url");
		browser = fileUtility.getDataFromPropertyFile("browser");
		timeouts = fileUtility.getDataFromPropertyFile("timeout");
		 url1 = fileUtility.getDataFromPropertyFile("url1");
		 moviename = fileUtility.getDataFromPropertyFile("movieName");


		driver = webdriverUtility.setUpDriver(browser);

		//pre-setting the browser
		webdriverUtility.maximizeBrowser();
		//convert String to Long
		longTimeout = javaUtility.convertStringToLong(timeouts);

		webdriverUtility.implicitlyWait(longTimeout);



		//initialize the Actions class
		webdriverUtility.intializeActions();
		
		 imdb=new ImdbPagePomClass(driver);
		 wiki=new WikiPediaPom(driver);

	}
	@BeforeMethod
	public void loginTest() {

		webdriverUtility.openApplication(url);


	}

	@AfterMethod
	public void LogoutTest() {


	}

	@AfterClass
	public void closeBrowser() {
		webdriverUtility.closeBrowser();
	}

}

