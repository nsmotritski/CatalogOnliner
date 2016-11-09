package onliner.forms;

import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.Link;

public class CatalogOnlinerPage extends BaseForm {
    private Link menuItemLink = new Link(By.xpath("//div[@class='catalog-bar']/ul/li/a[.='Телевизоры']"));
    //div[@class='catalog-bar']/ul/li/a[.='Телевизоры']
    //ul/li/span /descendant::a[.='Телевизоры']
    private Label lbLogo = new Label(By.xpath(".//img[@alt='Onliner']"),"catalog onliner logo");

    public CatalogOnlinerPage() {
        super(By.xpath("//div[@id='fast-search']/form/input[@data-project='catalog_public']"), "Catalog Onliner.by");
    }

    public void assertLogo(){assert(lbLogo.isPresent());}

    public void navigateMenuItem () {
        menuItemLink.click();
    }

}
