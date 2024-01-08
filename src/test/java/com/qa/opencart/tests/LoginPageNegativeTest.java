package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageNegativeTest extends BaseTest{
	
	@DataProvider
	public Object[][] getData(){
		
		return new Object[][] {
			{"aman4@opencart.com","12345"},
			{"rahul@opencart.com","12345"},
			{"naveen@opencart.com","12345"}
		};
		
	}
	
	
	@Test(dataProvider = "getData")
	public void doLoginPageNegativeTest(String userName, String pwd) {
		
		Assert.assertTrue(loginPage.getLoginPageWarningMessage(userName, pwd).contains(AppConstants.LOGIN_PAGE_WARNING_MESSAGE));
		
	}

}
