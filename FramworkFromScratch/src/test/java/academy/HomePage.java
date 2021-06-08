package academy;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;


public class HomePage extends Base
{
   public WebDriver driver;

    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void setUp() throws IOException
    {
        driver = InitializeDrive();

    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username, String Password,String text)
    {
        driver.get( prop.getProperty("url"));
        LandingPage l = new LandingPage(driver);
        LoginPage lp =l.getLogin();



        lp.getEmail().sendKeys(Username);
        lp.getPassword().sendKeys(Password);

        log.info(text);

        lp.clickLogIn().click();
        ForgotPassword fp = lp.forgotPassword();
        fp.getEmail().sendKeys("xxx@gamil.com");
        fp.sendMeInstructions().click();



    }

    @DataProvider
    public Object[][] getData()
    {
        // Row stands for how many different data types test should run
        //Coloumn stands for how many values per each test
        Object[][] data = new Object[2][3];
        // 0 Row
        data[0][0] = "nonrestirctedusers@gamil.com";
        data[0][1] = "123";
        data[0][2] = "Restricted Users";

        //1Row
        data[1][0] = "restirctedusers@gamil.com";
        data[1][1] = "456";
        data[1][2] = "Non Restricted Users";

        return data;


    }
    @AfterTest
    public void TearDown()
    {
        driver.close();
    }
}

