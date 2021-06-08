package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword
{
    public WebDriver driver;

    public ForgotPassword(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="user_email")
    WebElement emailId;

    @FindBy(xpath="//input[@name='commit']")
    WebElement sendMeInstruction;

    public WebElement getEmail()
    {
        return emailId;
    }

    public WebElement sendMeInstructions()
    {
        return sendMeInstruction;
    }
}
