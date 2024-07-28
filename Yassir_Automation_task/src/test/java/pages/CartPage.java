package pages;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;

public class CartPage {
    public WebDriver driver;
    WebDriverWait wait;
    private static final long WAIT = 10;
    String priceTag;
    String TAX;
    String TOTALl;
    float totaladded;

    @FindBy(xpath = "(//*[@class='inventory_item_name'])[1]")
    public WebElement firstitem;

    @FindBy(id ="checkout")
    public WebElement checkoutButton;

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    public WebElement pricetag;

    @FindBy(id = "first-name")
    public WebElement firstname;

    @FindBy(id = "last-name")
    public WebElement lastname;

    @FindBy(id = "postal-code")
    public WebElement pstalcode;

    @FindBy(id ="continue")
    public WebElement continuebo;

    @FindBy(xpath = "//*[@class='summary_tax_label']")
    public WebElement tax;

    @FindBy(xpath = "//*[@class='summary_total_label']")
    public WebElement total;




    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
    }

    public void validateitemadded() throws IOException {
        File file= new File("C://Users//Gihad.Magdy//IdeaProjects//Yassir_Automation_task//src//test//resources//validationss//validation.txt");
        FileReader fr=new FileReader(file);
        BufferedReader reader=new BufferedReader(fr);
        Assert.assertEquals(firstitem.getText(),reader.readLine());
    }
    public void clickcheckout(){
        checkoutButton.click();
    }
    public void getprice(){
        StringBuffer sb=new StringBuffer(pricetag.getText());
        sb.delete(0,1);
        priceTag=sb.toString();
    }

    public void addDate() throws IOException, ParseException {


        JSONParser j = new JSONParser();
        FileReader f = new FileReader("C://Users//Gihad.Magdy//IdeaProjects//Yassir_Automation_task//src//test//resources//TestData.json");
        Object o = j.parse(f);
        JSONObject detail = (JSONObject)o;

        wait.until(ExpectedConditions.visibilityOf(firstname));
         firstname.sendKeys((String)detail.get("firstname"));
        lastname.sendKeys((String)detail.get("lastname"));
        pstalcode.sendKeys((String)detail.get("postal code"));
    }

    public void clickContinue(){
        continuebo.click();
    }
    public void gettax(){
        StringBuffer sb=new StringBuffer(tax.getText());
        for (int i=0 ; i<6;i++) {
            sb.delete(0, 1);
        }
        TAX=sb.toString();
    }
    public void gettotal(){
        StringBuffer sb=new StringBuffer(total.getText());
        for (int i=0 ; i<8;i++) {
            sb.delete(0, 1);
        }
        TOTALl=sb.toString();
    }
    public void validatetax(){
        getprice();
        gettax();
        gettotal();
        System.out.println(TOTALl+TAX+priceTag);
        totaladded=Float.parseFloat(TAX)+Float.parseFloat(priceTag);

        Assert.assertEquals(TOTALl,String.valueOf(totaladded));
    }

}
