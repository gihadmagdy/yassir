package StepDefinition;

import Utils.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import pages.CartPage;

import java.io.IOException;

public class CartStepDef extends BrowserDriver {

    public CartPage cartPage=new CartPage(driver);

    @Then("validate that item added successfully")
    public void itemAddedSucessfullt() throws IOException {
        cartPage.validateitemadded();
    }
    @And("user enters his data")
    public void userEnterData() throws IOException, ParseException {
        cartPage.addDate();
    }
    @And("user click checkout")
    public void userClickCheckout(){
        cartPage.clickcheckout();
    }
    @And("user click continue")
    public void userClickContinue(){
        cartPage.clickContinue();
    }
    @Then("validate total price")
    public void validateTotalprice(){
        cartPage.validatetax();
    }

}
