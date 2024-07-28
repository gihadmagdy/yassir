package pages;

import com.beust.ah.A;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    public WebDriver driver;
    WebDriverWait wait;
    private static final long WAIT = 10;

    String homepagetitle="Products";
    String fromhightolow="price high to low";
    String lowtohigh="price low to high";
    public String firstItem;

    @FindBy(xpath = "//*[@class='title']")
    public WebElement homePageeTitle;

    @FindBy(xpath = "//*[@class='product_sort_container']")
    public WebElement sortDropDown;

    @FindBy(xpath = "(//*[@class='btn btn_primary btn_small btn_inventory '])[1]")
    public WebElement addtoCart;

    @FindBy(xpath = "(//*[@class='btn btn_primary btn_small btn_inventory '])[2]")
    public WebElement addtoCart1;

    @FindBy(xpath = "(//*[@class='btn btn_secondary btn_small btn_inventory '])[2]")
    public WebElement remove1;

    @FindBy(xpath = "//*[@class='shopping_cart_badge']")
    public WebElement cartitemNO;

    @FindBy(xpath = "//*[@class=\'shopping_cart_link\']")
    public WebElement carticon;

    @FindBy(xpath = "(//*[@class='inventory_item_name '])[1]")
    public WebElement firstitem;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));

    }

    public void validateHomePAge(){
        wait.until(ExpectedConditions.visibilityOf(homePageeTitle));
        Assert.assertEquals(homePageeTitle.getText(),homepagetitle);
    }
    public void selectFromDropDown(String sort) {

        Select se = new Select(sortDropDown);
        if (sort.equals(fromhightolow)){
            se.selectByValue("hilo");
            validateSortionfromhightoLow();

        } else if (sort.equals(lowtohigh)) {
            se.selectByVisibleText("Price (low to high)");
            validateSortionfromhightoLow();
        }

    }
    public void validateSortionfromhightoLow(){
        List <WebElement> list=(List<WebElement>) driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
        List <String> prices= new ArrayList<String>();
        StringBuffer sb;
        for (int i=0; i<list.size();i++)
        {
            sb=new StringBuffer(list.get(i).getText());
            sb.delete(0,1);
            prices.add(sb.toString());
        }

        Assert.assertTrue(Float.parseFloat(prices.get(0))>Float.parseFloat(prices.get(1)));
    }
    public void clickaddtocart() throws IOException {
        addtoCart.click();
        addtoCart1.click();
        Assert.assertEquals(cartitemNO.getText(),"2");
        remove1.click();
        Assert.assertEquals(cartitemNO.getText(),"1");
        getFirstItemName();
    }
    public void clickcarticon() throws IOException {
        carticon.click();

    }
    public void getFirstItemName() throws IOException {

        firstItem=firstitem.getText();
        System.out.println(firstItem);
        File file= new File("C://Users//Gihad.Magdy//IdeaProjects//Yassir_Automation_task//src//test//resources//validationss//validation.txt");
        FileWriter fw=new FileWriter(file);
        BufferedWriter writer=new BufferedWriter(fw);
        writer.write(firstItem);
        System.out.println(firstitem.getText());
        writer.close();


    }

}
