package twitterPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FactoryTwitterLoginPage;
import pages.FactoryTwitterSignUpPage;

import java.util.concurrent.TimeUnit;

public class TwitterNegativeTest {
    private WebDriver driver;
    public static final String BASE_URL = "https://twitter.com/?lang=en-gb";
    public static final String EMPTY_CREDENTIALS_MESSAGE_TEXT = "The username and password that you entered did not match our records. Please double-check and try again.";
    public static final String INVALID_CREDENTIALS_MESSAGE_TEXT = "The username and password do not match.";
    public static final String AUTH_ERROR_URL = "twitter.com/login/error";
    public static final String SIGN_UP_URL = "https://twitter.com/signup";


    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void invalidCredentialsAuthenticationTest() {
        FactoryTwitterLoginPage page = PageFactory.initElements(driver, FactoryTwitterLoginPage.class);
        page.login("111", "123", true);
        Assert.assertTrue(page.invalidCredentialsErrorMessage.isDisplayed(), "no message is displayed");
        Assert.assertTrue(page.invalidCredentialsErrorMessage.getText().contains(INVALID_CREDENTIALS_MESSAGE_TEXT), "message text is not as expected");
        Assert.assertTrue(driver.getCurrentUrl().contains(AUTH_ERROR_URL), "url is not as expected");
    }

    @Test
    public void emptyCredentialsAuthenticationTest() {
        FactoryTwitterLoginPage page = PageFactory.initElements(driver, FactoryTwitterLoginPage.class);
        page.login("", "", true);
        Assert.assertTrue(page.emptyCredentialsErrorMessage.isDisplayed(), "no message is displayed");
        Assert.assertTrue(page.emptyCredentialsErrorMessage.getText().contains(EMPTY_CREDENTIALS_MESSAGE_TEXT), "message text is not as expected");
        Assert.assertTrue(driver.getCurrentUrl().contains(AUTH_ERROR_URL), "url is not as expected");
    }

    @Test
    public void signUpErrorMsgShownTest() {
        FactoryTwitterLoginPage loginPage = PageFactory.initElements(driver, FactoryTwitterLoginPage.class);
        FactoryTwitterSignUpPage signUpPage = PageFactory.initElements(driver, FactoryTwitterSignUpPage.class);
        loginPage.signUp("111", "123", "aBCd");
        Assert.assertEquals(driver.getCurrentUrl(), SIGN_UP_URL, "url is not as expected");
        Assert.assertEquals(signUpPage.singUpFullNameField.getAttribute("value"), "111");
        Assert.assertEquals(signUpPage.singUpEmailField.getAttribute("value"), "123");
        Assert.assertTrue(signUpPage.signUpErrorMsg.isDisplayed(), "no message is displayed");
    }
}
