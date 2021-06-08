package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ValidateNavigationBar extends Base
{
    public WebDriver driver;

    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void setUp() throws IOException
    {
        driver = InitializeDrive();
        driver.get( prop.getProperty("url"));
    }

    @Test
    public void basePageNavigation() throws IOException
    {
        LandingPage l = new LandingPage(driver);
        //driver.findElement((By) l.navBar);

        Assert.assertTrue(l.getNavigationBar().isDisplayed());
        log.info("Successfully navigate");
    }

    @AfterTest
    public void TearDown()
    {
        driver.close();
    }
}
