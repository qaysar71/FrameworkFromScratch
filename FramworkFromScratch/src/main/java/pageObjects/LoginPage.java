package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    public WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id="user_email")
    WebElement emailId;

    @FindBy(id="user_password")
    WebElement password;

    @FindBy(name="commit")
    WebElement logIn;

    @FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
    WebElement forgotPassword;


    public WebElement getEmail()
    {
        return emailId;
    }

    public WebElement getPassword()
    {
        return password;
    }

    public WebElement clickLogIn()
    {
        return logIn;
    }
    public ForgotPassword forgotPassword()
    {

        return new ForgotPassword(driver);

    }
}
