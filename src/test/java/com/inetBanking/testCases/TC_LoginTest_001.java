package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest()  {
		
		
		logger.info("url is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		logger.info("Enter user name");

		lp.setPassword(password);
		logger.info("Enter user Password");

		
		lp.clickSubmit();
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");

		}
		
		else {
			Assert.assertTrue(false);
			logger.info("Login test failed");

		}
	}

}
