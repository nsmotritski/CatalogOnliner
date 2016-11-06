package onliner;

import onliner.forms.CatalogOnlinerPage;
import onliner.forms.CatalogOnlinerTVs;
import onliner.forms.OnlinerHomePage;
import webdriver.BaseTest;

public class FindUsingFiltersTest extends BaseTest {
    public void runTest() {

        logger.step(1);
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
    }
}
