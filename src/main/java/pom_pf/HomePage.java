package pom_pf;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//a[@data-wa-link = 'hdr-corporate-signin:all']")
	private List<WebElement> signIn;

	@FindBy(xpath = "//span[@class = 'sign-in-icon']")
	private WebElement signInIcon;
	
	// #1 - QuickBooks Online
	@FindBy(xpath = "//a[@data-wa-link = 'hdr-corporate-signin:qbo']")
	private WebElement signIn_qbo;
	
	// #2 - Intuit Online Payroll
	@FindBy(xpath = "//a[@data-wa-link = 'hdr-corporate-signin:payroll']")
	private WebElement signIn_payroll;
	
	// #3 - QuickBooks Payments
	@FindBy(xpath = "//a[@data-wa-link = 'hdr-corporate-signin:payments']")
	private WebElement signIn_payments;
	
	// #4 - TurboTax
	@FindBy(xpath = "//a[@data-wa-link = 'hdr-corporate-signin:turbotax']")
	private WebElement signIn_turbotax;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndClickLink_SignIn")
	public WebElement findAndClickLink_SignIn() {
		wait.until(ExpectedConditions.elementToBeClickable(signIn.get(0))).click();

		return signIn.get(0);
	}

	@Step("findAndMoveLink_SignIn")
	public WebElement findAndMoveLink_SignIn() {
		wait.until(ExpectedConditions.visibilityOf(signIn.get(0)));

		Actions moveMouse = new Actions(driver);
		moveMouse.moveToElement(signIn.get(0)).build().perform();

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return signIn.get(0);
	}
	
	@Step("findAndClickLink_signIn_qbo")
	public WebElement findAndClickLink_SignIn_qbo() {
		wait.until(ExpectedConditions.elementToBeClickable(signIn_qbo)).click();
		return signIn_qbo;
	}
	
	@Step("findAndClickLink_SignIn_payroll")
	public WebElement findAndClickLink_SignIn_payroll() {
		wait.until(ExpectedConditions.elementToBeClickable(signIn_payroll)).click();
		return signIn_payroll;
	}
	
	@Step("findAndClickLink_SignIn_payments")
	public WebElement findAndClickLink_SignIn_payments() {
		wait.until(ExpectedConditions.elementToBeClickable(signIn_payments)).click();
		return signIn_payments;
	}
	
	@Step("findAndClickLink_SignIn_turbotax")
	public WebElement findAndClickLink_SignIn_turbotax() {
		wait.until(ExpectedConditions.elementToBeClickable(signIn_turbotax)).click();
		return signIn_turbotax;
	}
	
	@Step("findAndClickLink_SignInIcon")
	public WebElement findAndClickLink_SignInIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(signInIcon)).click();
		return signInIcon;
	}

}