package tests;

import org.testng.annotations.Test;
import pages.AddItemToCart;

public class AddItemToCartTest extends BaseTest{

    @Test
    public void addItemToCartTest() {
        new AddItemToCart(driver).addItem().verifyItemInCart();

    }

}
