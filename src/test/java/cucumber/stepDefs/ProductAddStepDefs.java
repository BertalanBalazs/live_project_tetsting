package cucumber.stepDefs;

import com.codecool.lpt.pageObjects.MainPage;
import com.codecool.lpt.pageObjects.ShoppingCartPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class ProductAddStepDefs {
    WebDriver driver;
    MainPage mainPage;
    ShoppingCartPage shoppingCartPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getenv("webdriverPath"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.navigateToShoppingCartPage().clearShoppingCart();
    }

    @After
    public void tearDown() {
        shoppingCartPage.clearShoppingCart();
        driver.close();
    }

    @Given("^User on the main page$")
    public void navigate_To_Main_Page() {
        mainPage.navigate();
    }

    @When("^User click on add first product button$")
    public void click_On_First_Product_Add_Button() {
        mainPage.clickOnFirstProductAddButton();
    }

    @When("^User click on add third product button$")
    public void click_On_Third_Product_Add_Button() {
        mainPage.clickOnThirdProductAddButton();
    }

    @When("^User click twice on add first product button$")
    public void click_On_First_Product_Add_Button_Twice() {
        mainPage.clickOnFirstProductAddButton();
        mainPage.clickOnFirstProductAddButton();
    }

    @When("^User click twice on add third product button$")
    public void click_On_Third_Product_Add_Button_Twice() {
        mainPage.clickOnThirdProductAddButton();
        mainPage.clickOnThirdProductAddButton();
    }

    @When("^User click on customer service$")
    public void click_On_Customer_Service() {
        mainPage.clickOnCustomerService();
    }

    @And("^User type into input \"([^\"]*)\"$")
    public void send_Key_To_Customer_Service(String text) {
        mainPage.sendKeyToCustomerServiceInput(text);
    }

    @And("^User send the message with click")
    public void click_On_Message_Send() {
        mainPage.clickOnMessageSendButton();
    }

    @And("^Second product quantity should be two$")
    public void assert_Second_Product_Quantity_Two() {
        int actualQuantity = shoppingCartPage.getProductQuantityOfSecondProduct();
        assertEquals(2, actualQuantity);
    }

    @And("^User click on shopping cart button$")
    public void click_On_Shopping_Cart() {
        mainPage.clickOnShoppingCart();
    }


    @Then("^First product quantity should be one$")
    public void assert_First_Product_Quantity_One() {
        int actualQuantity = shoppingCartPage.getProductQuantityOfFirstProduct();
        assertEquals(1, actualQuantity);
    }

    @Then("^Second product quantity should be one$")
    public void assert_Second_Product_Quantity_One() {
        int actualQuantity = shoppingCartPage.getProductQuantityOfSecondProduct();
        assertEquals(1, actualQuantity);
    }

    @Then("^First product quantity should be two$")
    public void assert_First_Product_Quantity_Two() {
        int actualQuantity = shoppingCartPage.getProductQuantityOfFirstProduct();
        assertEquals(2, actualQuantity);
    }

    @Then("^Answerer name has to be \"([^\"]*)\"$")
    public void assert_Answerer_Name(String name) {
        String result = mainPage.getCustomerServiceAnswererName();
        assertEquals("Chuck_Norris", result);
    }
}
