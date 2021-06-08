package academy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ValidateTitle extends Base
{
    public WebDriver driver;

   public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void setUp() throws IOException
    {
        driver = InitializeDrive();
        log.info("driver is initialize");
        driver.get( prop.getProperty("url"));
        log.info("navigate to HomePage");
    }

    @Test
    public void basePageNavigation() throws IOException
    {


        LandingPage l = new LandingPage(driver);
        //compare the text from the browser with actual text
        Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES123");
        log.info("Successfully validated text massage");
    }
    @AfterTest
    public void Teardown()
    {
        driver.close();
    }
}
