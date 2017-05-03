package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class SignIn_qbo_Page {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "ius-userid")
	private WebElement userid;

	@FindBy(id = "ius-password")
	private WebElement password;

	@FindBy(id = "ius-sign-in-submit-btn")
	private WebElement buttonSignIn;

	@FindBy(xpath = "//div[@class = 'ius-error-header' and contains(text(), 'Hmm. That didn')]")
	private WebElement errorHeader;

	public SignIn_qbo_Page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndFillInField_Username with user name - [{0}]")
	public WebElement findAndFillInField_Username(String st) {
		wait.until(ExpectedConditions.visibilityOf(userid)).clear();
		userid.sendKeys(st);
		return userid;
	}

	@Step("findAndFillInField_Password with password - [{0}]")
	public WebElement findAndFillInField_Password(String st) {
		wait.until(ExpectedConditions.visibilityOf(password)).clear();
		password.sendKeys(st);
		return password;
	}

	@Step("findAndClickButton_buttonSignIn")
	public WebElement findAndClickButton_buttonSignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonSignIn)).click();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return buttonSignIn;
	}

	@Step("findButton_buttonSignIn_isEnabled")
	public boolean findButton_buttonSignIn_isEnabled() {
		return wait.until(ExpectedConditions.visibilityOf(buttonSignIn)).isEnabled();
	}

	@Step("findAndClickButton_errorHeader")
	public String findAndClickButton_errorHeader() {
		return wait.until(ExpectedConditions.visibilityOf(errorHeader)).getText();
	}
}