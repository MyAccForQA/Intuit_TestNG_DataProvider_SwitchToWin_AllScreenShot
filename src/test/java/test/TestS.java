package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom_pf.HomePage;
import pom_pf.SignIn_All_Page;
import pom_pf.SignIn_payments_Page;
import pom_pf.SignIn_payroll_Page;
import pom_pf.SignIn_qbo_Page;
import pom_pf.SignIn_turbotax_Page;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

@Title("TestS_Start")
@Description("Description")
public class TestS extends Test_BeforeAndAfter {

	// #1
	@Title("test_HomePage")
	@Test(groups = { "ff", "ok" })
	public void test_HomePage() {

		// ????????????????????????
		String exp = "Intuit - Small Business, Personal Finance and Tax Software";
		// ????????????????????????
		try {
			String act = driver.getTitle();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePage - " + exp);
		}
	}

	// #2
	@Title("test_HomePageToGoSignIn_all")
	@Test(groups = { "ff", "ok" })
	public void test_HomePageToGoSignIn_all() {

		String exp = "Choose a product to sign in";
		try {
			new HomePage(driver, wait).findAndClickLink_SignIn();
			// new HomePage(driver, wait).findAndMoveLink_SignIn();

			SignIn_All_Page signIn_All_Page = new SignIn_All_Page(driver, wait);

			String act = signIn_All_Page.findAndClickButton_productToSignIn_getText();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoSignIn_all " + exp);
		}
	}

	// #3
	@Title("test_HomePageToGoSignIn_qbo")
	@Test(groups = { "ff", "ok" })
	public void test_HomePageToGoSignIn_qbo() {

		boolean exp = true;
		try {
			// new HomePage(driver, wait).findAndClickLink_SignIn();
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndMoveLink_SignIn();
			homePage.findAndClickLink_SignIn_qbo();

			SignIn_qbo_Page signIn_qbo_Page = new SignIn_qbo_Page(driver, wait);

			boolean act = signIn_qbo_Page.findButton_buttonSignIn_isEnabled();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoSignIn_qbo " + exp);
		}
	}

	// 4
	@Title("test_HomePageToGoSignIn_payroll")
	@Test(groups = { "ff", "ok" })
	public void test_HomePageToGoSignIn_payroll() {

		boolean exp = true;
		try {
			// new HomePage(driver, wait).findAndClickLink_SignIn();
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndMoveLink_SignIn();
			homePage.findAndClickLink_SignIn_payroll();

			SignIn_payroll_Page signIn_payroll_Page = new SignIn_payroll_Page(driver, wait);

			boolean act = signIn_payroll_Page.findButton_buttonSignIn_isEnabled();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoSignIn_payroll " + exp);
		}
	}

	// 5
	@Title("test_HomePageToGoSignIn_payments")
	@Test(groups = { "ff", "ok" })
	public void test_HomePageToGoSignIn_payments() {

		boolean exp = true;
		try {
			// new HomePage(driver, wait).findAndClickLink_SignIn();
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndMoveLink_SignIn();
			homePage.findAndClickLink_SignIn_payments();

			SignIn_payments_Page signIn_payments_Page = new SignIn_payments_Page(driver, wait);

			boolean act = signIn_payments_Page.findButton_buttonSignIn_isEnabled();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoSignIn_payments " + exp);
		}
	}

	// 5
	@Title("test_HomePageToGoSignIn_turbotax")
	@Test(groups = { "ff", "ok" })
	public void test_HomePageToGoSignIn_turbotax() {

		boolean exp = true;
		try {
			// new HomePage(driver, wait).findAndClickLink_SignIn();
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndMoveLink_SignIn();
			homePage.findAndClickLink_SignIn_turbotax();

			SignIn_turbotax_Page signIn_turbotax_Page = new SignIn_turbotax_Page(driver, wait);

			boolean act = signIn_turbotax_Page.findButton_buttonSignIn_isEnabled();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoSignIn_turbotax " + exp);
		}
	}

	////
	@DataProvider(name = "WrongEmail")
	public static String[][] wrongEmail() {
		String[][] str = { { "qwe", "qweasdzxc", "Hmm. That didn't work." },
				{ "qwe@", "qweasdzxc", "Hmm. That didn't work." }, { "qwe@asd", "qweasdzxc", "Hmm. That didn't work." },
				{ "qwe@asd.", "qweasdzxc", "Hmm. That didn't work." },
				{ "qwe@asd.c", "qweasdzxc", "Hmm. That didn't work." },
				{ "qwe@.com", "qweasdzxc", "Hmm. That didn't work." },
				{ "qwe@.", "qweasdzxc", "Hmm. That didn't work." } };
		return str;
	}

	// #6
	@Title("test_HomePageToGoSignIn_qbo_WrongEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "WrongEmail")
	public void test_HomePageToGoSignIn_qbo_WrongEmail_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			// new HomePage(driver, wait).findAndClickLink_SignIn();
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndMoveLink_SignIn();
			homePage.findAndClickLink_SignIn_qbo();

			SignIn_qbo_Page signIn_qbo_Page = new SignIn_qbo_Page(driver, wait);
			signIn_qbo_Page.findAndFillInField_Username(email);
			signIn_qbo_Page.findAndFillInField_Password(pass);
			signIn_qbo_Page.findAndClickButton_buttonSignIn();

			String act = signIn_qbo_Page.findAndClickButton_errorHeader();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HomePageToGoSignIn_qbo_WrongEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	// #7
	@Title("test_HomePageToGoSignIn_payroll_WrongEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "WrongEmail")
	public void test_HomePageToGoSignIn_payroll_WrongEmail_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			// new HomePage(driver, wait).findAndClickLink_SignIn();
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndMoveLink_SignIn();
			homePage.findAndClickLink_SignIn_payroll();

			SignIn_payroll_Page signIn_payroll_Page = new SignIn_payroll_Page(driver, wait);
			signIn_payroll_Page.findAndFillInField_Username(email);
			signIn_payroll_Page.findAndFillInField_Password(pass);
			signIn_payroll_Page.findAndClickButton_buttonSignIn();

			String act = signIn_payroll_Page.findAndClickButton_errorHeader();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot(
					"test_HomePageToGoSignIn_payroll_WrongEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	// #8
	@Title("test_HomePageToGoSignIn_payments_WrongEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "WrongEmail")
	public void test_HomePageToGoSignIn_payments_WrongEmail_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			// new HomePage(driver, wait).findAndClickLink_SignIn();
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndMoveLink_SignIn();
			homePage.findAndClickLink_SignIn_payments();

			SignIn_payments_Page signIn_payments_Page = new SignIn_payments_Page(driver, wait);
			signIn_payments_Page.findAndFillInField_Username(email);
			signIn_payments_Page.findAndFillInField_Password(pass);
			signIn_payments_Page.findAndClickButton_buttonSignIn();

			String act = signIn_payments_Page.findAndClickButton_errorHeader();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot(
					"test_HomePageToGoSignIn_payments_WrongEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}

	// #9
	@Title("test_HomePageToGoSignIn_turbotax_WrongEmail_ErrorValid")
	@Test(groups = { "ff", "ok" }, dataProvider = "WrongEmail")
	public void test_HomePageToGoSignIn_turbotax_WrongEmail_ErrorValid(String email, String pass, String must) {

		String exp = must;
		try {
			// new HomePage(driver, wait).findAndClickLink_SignIn();
			HomePage homePage = new HomePage(driver, wait);
			homePage.findAndMoveLink_SignIn();
			homePage.findAndClickLink_SignIn_turbotax();

			SignIn_turbotax_Page signIn_turbotax_Page = new SignIn_turbotax_Page(driver, wait);
			signIn_turbotax_Page.findAndFillInField_Username(email);
			signIn_turbotax_Page.findAndFillInField_Password(pass);
			signIn_turbotax_Page.findAndClickButton_buttonSignIn();

			String act = signIn_turbotax_Page.findAndClickButton_errorHeader();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot(
					"test_HomePageToGoSignIn_turbotax_WrongEmail_ErrorValid - " + email + ":" + pass + " = " + exp);
		}
	}
}