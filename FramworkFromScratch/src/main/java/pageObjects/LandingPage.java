package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage
{
    public WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

 // By signIn = By.cssSelector("a[href*='sign_in']");
    /*By signIn = By.xpath("//span[normalize-space()='Login']");


    public WebElement getLogin()
    {
        return driver.findElement(signIn);
    }*/
 private @FindBy(xpath = "//span[normalize-space()='Login']")
    WebElement login;

  private @FindBy(xpath="//h2[normalize-space()='Featured Courses']")
    WebElement title;

 private @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/li/a")
   WebElement navBar;

    public LoginPage getLogin()
    {
        LoginPage lp = new LoginPage(driver);
        login.click();
        return  lp;
    }

    public WebElement getTitle()
    {
        return title;
    }
    public WebElement getNavigationBar()
    {
        return navBar;
    }

}
