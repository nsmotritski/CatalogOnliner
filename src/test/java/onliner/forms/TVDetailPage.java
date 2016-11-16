package onliner.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.Link;

/**
 * Created by Николай on 16.11.2016.
 */
public class TVDetailPage extends BaseForm {

        private Link menuItemLink = new Link(By.xpath("//div[@class='catalog-bar']/ul/li/a[.='Телевизоры']"),"MenuItemLink");
        //div[@class='catalog-bar']/ul/li/a[.='Телевизоры']
        //ul/li/span /descendant::a[.='Телевизоры']
        private Label lbLogo = new Label(By.xpath(".//img[@alt='Onliner']"),"catalog onliner logo");

        public TVDetailPage() {
            super(By.xpath("//div[@id='fast-search']/form/input[@data-project='catalog_public']"), "Catalog Onliner.by");
        }

        public void assertLogo(){assert(lbLogo.isPresent());}

        public void navigateMenuItem () {
            menuItemLink.click();
        }

}
