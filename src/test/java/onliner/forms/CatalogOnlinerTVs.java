package onliner.forms;

import onliner.SearchItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webdriver.BaseForm;
import webdriver.elements.Checkbox;
import webdriver.elements.Dropdown;
import webdriver.elements.TextBox;
import java.util.List;

public class CatalogOnlinerTVs extends BaseForm {
    private Checkbox manufacturerFilter = new Checkbox(By.xpath("//span[@class='schema-filter__checkbox-text' and .='Samsung']"));
    private TextBox maxPriceFilter = new TextBox(By.xpath(".//*[@id='schema-filter']//input[@placeholder='до']"));
    private TextBox releasedAfterYearFilter = new TextBox(By.xpath(".//*[@id='schema-filter']//input[@placeholder='2011']"));
    private Dropdown diagonalFromFilter = new Dropdown(By.xpath("//span[.='Диагональ']/../following-sibling::div/div/div/select[contains(@data-bind,\"from\")]"));
    private Dropdown diagonalToFilter = new Dropdown(By.xpath("//span[.='Диагональ']/../following-sibling::div/div/div/select[contains(@data-bind,\"to\")]"));
    private List<WebElement> searchResults;

    public CatalogOnlinerTVs() {
        super(By.xpath("//title"), "Купить телевизор в Минске");
    }

    public void setManufacturerFilter () {
        manufacturerFilter.click();
    }

    public void maxPriceFilter (Integer i) {
        maxPriceFilter.setText(i.toString());
    }

    public void setReleasedAfterYearFilter(Integer i) {
        this.releasedAfterYearFilter.setText(i.toString());
    }

    public void setDiagonalFromFilter(String s) {
        this.diagonalFromFilter.setText(s);
    }

    public void setDiagonalToFilter(String s) {
        this.diagonalToFilter.setText(s);
    }

    public void getSearchResults (WebDriver driver) {
        searchResults = driver.findElements(By.xpath(""));
    }

    public boolean checkResults (WebDriver driver) {
        SearchItem searchItem = new SearchItem();
        searchItem.searchItemTitle = driver.findElement(By.xpath(".//")).getText();
        return true;
    }

    /*В части «Подбор по параметрам» указать:
    Производитель = Samsung
            Цена = до 1000 руб
    Дата выхода на рынок = не ранее 2013
    Диагональ от 39" до 42"*/
}
