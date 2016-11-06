package onliner.forms;

import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.Link;

    /**
     * Created by Николай on 04.11.2016.
     */
    public class OnlinerHomePage extends BaseForm {
        private Link topMenuItem = new Link(By.xpath("//span[.='Каталог']/parent::a"));
        private Label lbLogo = new Label(By.xpath("//img[@id='pageLogo']"),"tut.by logo");

        public OnlinerHomePage() {
            super(By.xpath("//title"), "Onliner.by");
        }

        public void assertLinkPresent(){
            topMenuItem.waitForIsElementPresent();
            Assert.assertTrue(topMenuItem.isPresent());
        }

        public void clickMenuItem () {
            topMenuItem.click();
        }

    }
