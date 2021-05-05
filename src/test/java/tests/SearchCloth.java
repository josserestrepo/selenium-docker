package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchCloth extends BaseTest {

    @Test(dataProvider = "prendas")
    public void searchCloth(String prendas){
        this.driver.get("http://automationpractice.com/index.php");
        HomePage homePage = new HomePage(driver);
        homePage.search(prendas);
    }

    @DataProvider(name = "prendas")
    public Object[][] prendas(){
        return new Object[][]{
                {"shirt"},
                {"pants"},
                {"shoes"},
                {"shirt"},
                {"pants"},
                {"shoes"},
                {"shirt"},
                {"pants"},
                {"shoes"}
        };
    }

}
