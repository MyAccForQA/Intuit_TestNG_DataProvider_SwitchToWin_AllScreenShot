package pom_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class SignIn_All_Page {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//span[@class = 'h1' and contains(text(), 'Choose a product to sign in')]")
	private WebElement productToSignIn;

	public SignIn_All_Page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("findAndClickButton_productToSignIn_getText")
	public String findAndClickButton_productToSignIn_getText() {
		return wait.until(ExpectedConditions.visibilityOf(productToSignIn)).getText();
	}
}