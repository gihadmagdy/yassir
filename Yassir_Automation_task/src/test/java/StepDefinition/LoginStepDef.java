package StepDefinition;

import Utils.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;

import java.io.IOException;

public class LoginStepDef extends  BrowserDriver {


    private LoginPage loginPage;
    private BrowserDriver browserDriver;


    @Given("user navigate to login page")
    public void user_navigate_to_login_page() throws IOException {
       browserDriver=new BrowserDriver();
        browserDriver.openurl();

       loginPage=new LoginPage(driver);
       loginPage.validateLoginPage();
    }
    @And("user enters his {string}")
    public void userEntersUsername(String username)
    {
        loginPage.enterUserName(username);
    }
    @And("user enters his right {string}")
    public void userEntersPassword(String password){
         loginPage.enterPassword(password);
    }
    @And("user click login button")
    public void userClickLofin(){
        loginPage.clickLogin();
    }

}
