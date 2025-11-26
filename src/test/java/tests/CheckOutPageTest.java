package tests;
import org.testng.annotations.Test;
import pages.CheckOutPage;

public class CheckOutPageTest extends BaseTest{
    String fname = "Mohamed";
    String lname = "Away Toumi";
    String pcode = "3076";

    @Test
    public void checkoutTest(){
        new CheckOutPage(driver).checkOut(fname, lname, pcode);
    }
}
