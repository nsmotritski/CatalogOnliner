package onliner.forms;

import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Label;
import webdriver.elements.Link;

public class CatalogOnlinerPage extends BaseForm {
    private Link menuItemLink = new Link(By.xpath("//ul/li/span /descendant::a[.='Телевизоры']"));

    public CatalogOnlinerPage() {
        super(By.xpath("//title"), "Каталог Onliner.by");
    }

    public void assertLinkPresent(){
        menuItemLink.waitForIsElementPresent();
        Assert.assertTrue(menuItemLink.isPresent());
    }

    public void navigateMenuItem () {
        menuItemLink.click();
    }

}
