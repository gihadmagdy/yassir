package Utils;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Properties;

public class BrowserDriver {
    public static WebDriver driver;
    static LoggerManager utl=new LoggerManager();

    public  void openurl() throws IOException {


         Properties props = new PropertyManager().getProps();
        String browser = props.getProperty("Webdriver");

        if(browser.equals("chrome")) {
            driver=new ChromeDriver();
        }
        else if (browser.equals("firefox")){
            driver=new FirefoxDriver();
        }
        else if(browser.equals("edge")){
            driver=new EdgeDriver();
        }
        else {
            utl.log().info("worng driver entered");
        }

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }
    public void  closeBrowser(){
        driver.quit();
    }



}
