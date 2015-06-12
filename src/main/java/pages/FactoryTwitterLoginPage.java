package pages;

import helpers.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FactoryTwitterLoginPage {
    //SignIn form
    @FindBy(css = "#front-container form.signin")
    public WebElement signInForm;
    @FindBy(id = "signin-email")
    public WebElement userNameField;
    @FindBy(id = "signin-password")
    public WebElement passwordField;
    @FindBy(css = "#front-container button.submit")
    public WebElement loginButton;
    @FindBy(css = "#front-container input[type='checkbox']")
    public WebElement checkboxRememberMe;
    @FindBy(css = ".u-tableCell>p")
    public WebElement invalidCredentialsErrorMessage;
    @FindBy(id = "message-drawer")
    public WebElement emptyCredentialsErrorMessage;

    //SignUp form
    @FindBy(id = "#frontpage-signup-form")
    public WebElement singUpForm;
    @FindBy(css = "input[name='user[name]']")
    public WebElement fullNameForm;
    @FindBy(css = "input[name='user[email]']")
    public WebElement emailForm;
    @FindBy(css = "input[name='user[user_password]']")
    public WebElement passwordForm;
    @FindBy(css = "button.signup-btn")
    public WebElement signUpButton;


    public void login(String email, String pass, boolean rememberMe) {
        userNameField.sendKeys(email);
        passwordField.sendKeys(pass);
        Helper.setCheckboxTo(checkboxRememberMe, rememberMe);
        loginButton.click();
    }

    public void signUp(String fullName, String email, String pass) {
        fullNameForm.sendKeys(fullName);
        emailForm.sendKeys(email);
        passwordForm.sendKeys(pass);
        signUpButton.click();
    }
}
