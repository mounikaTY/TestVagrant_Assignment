package com.Fork.Assessment;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Assignment.Utility.BaseClass;
import com.Assignment.Utility.IpathConstants;

public class Validate_Assessment extends BaseClass{
	
	@Test
	public void assessmentTest() {
		String moviename=excelUtility.getExcelData(1, 0,IpathConstants.sheet);
		String countryName = imdb.getCountryName(moviename, driver);
		Reporter.log(countryName,true);
		String releaseDate = imdb.getReleaseDate();
		Reporter.log(releaseDate,true);
		String wiki_countryname= wiki.getCountry(webdriverUtility, url1, driver);
		Reporter.log(wiki_countryname,true);
		String Wiki_release = wiki.getReleaseDate();
		Reporter.log(Wiki_release,true);
		SoftAssert assertion=new SoftAssert();
		Assert.assertEquals(countryName, wiki_countryname);
		assertion.assertAll();
		Reporter.log("The country Name in both Wikipedia and Imdb is same",true);
		if(Wiki_release.contains("December 17 2021") || releaseDate.contains("17 December 2021"))
		{
			Reporter.log("The Release Date present in both Wiki and imdb is same",true);
		}
		else
		{
			Reporter.log("The Release date present in both Wiki and imdb is not same",true);
		}
		
	}

}
