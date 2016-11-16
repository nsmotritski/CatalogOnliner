package onliner.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

public class TVDetailPage extends BaseForm {
    private Label tvReleaseYear = new Label(By.xpath(".//td[contains(.,'Дата')] /following-sibling::td/span"),"tvReleaseYear");
    private Label tvDiagonal = new Label(By.xpath(".//td[contains(.,'Диагональ')] /following-sibling::td/span"),"tvDiagonal");

    public TVDetailPage() {
        super(By.xpath("//div[@id='fast-search']/form/input[@data-project='catalog_public']"), "Catalog Onliner.by");
    }

}
