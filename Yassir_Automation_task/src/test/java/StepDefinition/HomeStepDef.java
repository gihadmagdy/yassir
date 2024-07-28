package StepDefinition;

import Utils.BrowserDriver;
import io.cucumber.java.en.And;
import pages.HomePage;

import java.io.IOException;

public class HomeStepDef extends BrowserDriver {

    private HomePage homePage=new HomePage(driver);


   @And("validate that home page displayed")
    public void validateHomePAge(){
       homePage.validateHomePAge();
   }
   @And("user select sortion {string}")
    public void userSelectortion(String sort){
        homePage.selectFromDropDown(sort);
   }
   @And("user click add to cart")
    public void userClickOnAddToCart() throws IOException {
       homePage.clickaddtocart();
   }
   @And("user click cart icon")
    public void userClickOnCartIcon() throws IOException {
       homePage.clickcarticon();
   }

}
