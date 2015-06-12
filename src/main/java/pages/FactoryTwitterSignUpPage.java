package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FactoryTwitterSignUpPage {
    //SignUp page
    @FindBy(css = "h1")
    public WebElement signUpHeader;
    @FindBy(id = "full-name")
    public WebElement singUpFullNameField;
    @FindBy(id = "email")
    public WebElement singUpEmailField;
    @FindBy(id = "password")
    public WebElement singUpPasswordField;
    @FindBy(id = "username")
    public WebElement singUpUsernameField;
    @FindBy(css = ".invalid.active")
    public WebElement signUpErrorMsg;
}
