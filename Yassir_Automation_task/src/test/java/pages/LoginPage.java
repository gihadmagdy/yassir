package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage  {

   public WebDriver driver;
    WebDriverWait wait;
    private static final long WAIT = 10;


    @FindBy(xpath = "//*[@class='login_logo']")
    @CacheLookup
    private WebElement logo;

    @FindBy(id = "user-name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passwordfield;

    @FindBy(id="login-button")
    public WebElement loginBo;

    String loginlogo ="Swag Labs";


    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
         wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
    }


    public void validateLoginPage(){
        wait.until(ExpectedConditions.visibilityOf(logo));
        Assert.assertEquals(logo.getText(),loginlogo);
    }
    public void enterUserName(String username)
    {
        userName.sendKeys(username);
    }
    public void enterPassword(String password)
    {
        passwordfield.sendKeys(password);
    }
    public void clickLogin()
    {
        loginBo.click();
    }
}
