package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.listeners.TestAllureListener;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic-102:Account page test cases")
@Story("US 103: Account page features")
@Feature("F50: Feature Account page")
@Owner("Aman Srivastava")
@Listeners(TestAllureListener.class)
public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Description("Account page title validation")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
	}

	@Description("Validating the URL of account page")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void accPageURLTest() {
		Assert.assertTrue(accPage.getAccPageURL().contains(AppConstants.ACC_PAGE_URL_FRACTION));
	}

	@Description("Validating the URL of account page")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogutLinkExist());
	}

	@Description("Validating the search field exist on account page")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void isSearchFieldExistTest() {
		Assert.assertTrue(accPage.isSearchFieldExist());
	}

	@Description("Validating the count of header")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void accPageHeadersCountTest() {
		List<String> actAccPageHeadersList = accPage.getAccountsHeaders();
		System.out.println(actAccPageHeadersList);
		Assert.assertEquals(actAccPageHeadersList.size(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	}
	
	@Description("Validating the page headers")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void accPageHeadersTest() {
		List<String> actAccPageHeadersList = accPage.getAccountsHeaders();
		System.out.println(actAccPageHeadersList);
		//sort the actual list
		//sort the expected list
		//compare
		Assert.assertEquals(actAccPageHeadersList, AppConstants.ACCOUNTS_PAGE_HEADERS_LIST);		
	}
	
	@Description("Search the product")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void searchTest() {
		searchResultsPage = accPage.doSearch("MacBook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		String actProductHeader = productInfoPage.getProductHeaderName();
		Assert.assertEquals(actProductHeader, "MacBook Pro");
	}

}
