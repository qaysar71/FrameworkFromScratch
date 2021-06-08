package academy;





import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base
{
    public WebDriver driver;
    public Properties prop;

    public WebDriver InitializeDrive() throws IOException
    {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")+"/src/main/resources/data.properties");
        prop.load(fis);

        // mvn test -Dbrowser =chrome
        String browserName =  System.getProperty("browser");
        //String browserName = prop.getProperty("browser");



        if (browserName.contains("chrome"))
        {
           ChromeOptions options = new ChromeOptions();

          if(browserName.contains("chromeheadless"))
          {
              options.addArguments("headless");
          }
            driver = new ChromeDriver(options);
        } else if (browserName.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if(browserName.equals("IE"))
        {

        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;

    }
    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";

        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

}
