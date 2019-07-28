package cucumber.productAddingTests;

import com.codecool.lpt.pageObjects.ShoppingCartPage;
import cucumber.BaseCucumberTest;

import static org.junit.Assert.assertEquals;

public class AddMultipleProductToCart extends BaseCucumberTest {
    private ShoppingCartPage shoppingCartPage;

    @Given("^User on the main page$")
    public void today_is() {
       mainPage.navigate();
    }

    @When("^User click on add first product button$")
    public void i_ask_whether_it_s_Friday_yet() {
        mainPage.clickOnFirstProductAddButton();
    }

    @When("^User click on shopping cart button$")
    public void i_ask_whether_it_s_Friday_yet() {
        mainPage.clickOnShoppingCart();
    }

    @Then("^Product quantity should be one$")
    public void i_should_be_told(String expectedAnswer) {
        shoppingCartPage = new ShoppingCartPage(driver);
        int actualQuantity = shoppingCartPage.getProductQuantityOfFirstProduct();
        assertEquals(1, actualQuantity);
    }
}
