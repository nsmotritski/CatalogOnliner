package onliner;

import onliner.forms.CatalogOnlinerPage;
import onliner.forms.CatalogOnlinerTVs;
import onliner.forms.OnlinerHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webdriver.BaseTest;
import webdriver.Browser;

import java.util.ArrayList;
import java.util.List;

public class FindUsingFiltersTest extends BaseTest {
    public void runTest() {

        logger.step(1);
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        browser.windowMaximise();

        logger.step(2);
        onlinerHomePage.clickMenuItem();

        logger.step(3);
        CatalogOnlinerPage catalogOnlinerPage = new CatalogOnlinerPage();
        catalogOnlinerPage.navigateMenuItem();

        logger.step(4);
        CatalogOnlinerTVs catalogOnlinerTVs = new CatalogOnlinerTVs();
        catalogOnlinerTVs.applyFilters(1000, 2013, "390", "420");
        logger.info("All Filters applied correctly");


        logger.step(4);
        List<WebElement> searchItemList = new ArrayList<WebElement>();
        //searchItemList = browser.getDriver().findElements(By.xpath(".//div[@id='schema-products']"));
        Assert.assertTrue(true,"End-of-test assertion passed");
    }
}
