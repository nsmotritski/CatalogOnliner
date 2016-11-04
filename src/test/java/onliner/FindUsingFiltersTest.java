package onliner;

import demo.test.forms.TutSearchForm;
import onliner.forms.OnlinerHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import webdriver.BaseTest;

/**
 * Created by Николай on 04.11.2016.
 */
public class FindUsingFiltersTest {
    public void runTest() {

        //logger.step(1);
        System.out.println("Test if Catalog menu item is present");;
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage();
        onlinerHomePage.assertString();
        //tsf.assertLogo();

        /*logger.step(2);
        tsf.searchFor("A1QA");

        logger.step(3);
        tsf.assertA1QAString();*/
    }
}
