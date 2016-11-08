package onliner;

import onliner.forms.CatalogOnlinerPage;
import onliner.forms.CatalogOnlinerTVs;
import onliner.forms.OnlinerHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.BaseTest;
import webdriver.Browser;

import java.util.ArrayList;
import java.util.List;

public class FindUsingFiltersTest extends BaseTest {
    public void runTest() {

        logger.step(1);
        Browser.getInstance();
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        onlinerHomePage.assertLinkPresent();

        logger.step(2);
        onlinerHomePage.clickMenuItem();

        logger.step(3);
        CatalogOnlinerPage catalogOnlinerPage = new CatalogOnlinerPage();
        catalogOnlinerPage.navigateMenuItem();

        logger.step(4);
        CatalogOnlinerTVs catalogOnlinerTVs = new CatalogOnlinerTVs();
        catalogOnlinerTVs.setManufacturerFilter();
        catalogOnlinerTVs.maxPriceFilter(1000);
        catalogOnlinerTVs.setReleasedAfterYearFilter(2013);
        catalogOnlinerTVs.setDiagonalFromFilter("39");
        catalogOnlinerTVs.setDiagonalToFilter("42");

        logger.step(4);
        List<WebElement> searchItemList = new ArrayList<WebElement>();
        searchItemList = browser.getDriver().findElements(By.xpath(".//div[@id='schema-products']"));
    }
}
