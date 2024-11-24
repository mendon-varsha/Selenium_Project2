package demowebshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
@FindBy(linkText="Log in")
private WebElement getLoginLink;

@FindBy(id="Email")
private WebElement getEmailTF;

@FindBy(id="Password")
private WebElement getPasswordTF;

@FindBy(xpath="//input[@value='Log in']")
private WebElement getLoginButton;

public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getGetLoginLink() {
	return getLoginLink;
}

public WebElement getGetEmailTF() {
	return getEmailTF;
}

public WebElement getGetPasswordTF() {
	return getPasswordTF;
}

public WebElement getGetLoginButton() {
	return getLoginButton;
}

}
