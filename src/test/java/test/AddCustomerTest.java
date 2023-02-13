package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;

	// In Excel projects, the "test pages" have all of the excel test data.
	// Also DashboardPage has a 'new method' to navigate to ListCustomers page.
	// Also AddCustomerPage has global declaration of insertedName.
	// Also AddCustomerPage has a 'new method' at the end to verify insertedName.

	//@Test
	@Parameters({ "userName", "password", "fullName", "company", "email","phoneNum","address", "city", "state", "zip",
			"country" })
	public void validUserShouldBeAbleToAddCustomer(String userName, String password, String fullName, String company,
			String email,String phoneNum, String address, String city, String state, String zip, String country) throws Exception {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inserUserName(userName);
		loginPage.inserPassword(password);
		loginPage.clickSignIn();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();

		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickAddCustomerMenuButton();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropdown(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phoneNum);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountryDropdown(country);
		addCustomerPage.clickSaveButton();

		dashboardPage.clickListCustomerMenuButton();

		addCustomerPage.verifyInsertedName();

		addCustomerPage.clickDeleteConfirmButton();
		// BrowserFactory.tearDown();

	}
	
	@Test
	@Parameters({ "userName", "password", "fullName", "company", "email","phoneNum","address", "city", "state", "zip",
			"country" })
	public void validUserShouldBeAbleToAddCustomerFromListCustomer(String userName, String password, String fullName, String company,
			String email,String phoneNum, String address, String city, String state, String zip, String country) throws Exception {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inserUserName(userName);
		loginPage.inserPassword(password);
		loginPage.clickSignIn();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerMenuButton();
		dashboardPage.clickListCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickAddCustomerOnListCustomerPage();
		addCustomerPage.insertFullName(fullName);		
		addCustomerPage.selectCompanyDropdown(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phoneNum);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountryDropdown(country);
		addCustomerPage.clickSaveButton();

		dashboardPage.clickListCustomerMenuButton();
		
		addCustomerPage.insertSearchElement();
		addCustomerPage.verifySearchedNameAndProfile();

		//addCustomerPage.verifyInsertedName();

		//addCustomerPage.clickDeleteConfirmButton();
		// BrowserFactory.tearDown();

	}
}
