package onliner.forms;

import onliner.SearchItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webdriver.BaseForm;
import webdriver.elements.BaseElement;
import webdriver.elements.Checkbox;
import webdriver.elements.Dropdown;
import webdriver.elements.TextBox;

import java.util.ArrayList;
import java.util.List;

public class CatalogOnlinerTVs extends BaseForm {
    private Checkbox manufacturerFilter = new Checkbox(By.xpath("//span[@class='schema-filter__checkbox-text' and .='Samsung']"),"Manufacturer");
    private TextBox maxPriceFilter = new TextBox(By.xpath(".//*[@id='schema-filter']//input[@placeholder='до']"),"MaxPrice");
    private TextBox releasedAfterYearFilter = new TextBox(By.xpath(".//*[@id='schema-filter']//input[@placeholder='2011']"),"Released after year");
    private Dropdown diagonalFromFilter = new Dropdown(By.xpath("//span[.='Диагональ']/../following-sibling::div/div/div/select[contains(@data-bind,'from')]"),"Diagonal min");
    private Dropdown diagonalToFilter = new Dropdown(By.xpath("//span[.='Диагональ']/../following-sibling::div/div/div/select[contains(@data-bind,\"to\")]"),"Diagonal max");
    private List<WebElement> searchResults;

    public CatalogOnlinerTVs() {
        super(By.xpath("//div[@id='fast-search']/form/input[@data-project='catalog_public']"), "Catalog Onliner.by");
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
        diagonalFromFilter.setValue(s);

    }

    public void setDiagonalToFilter(String s) {
        diagonalToFilter.setValue(s);
    }

    public void applyFilters (Integer price, Integer releaseYear, String diagonalFrom, String diagonalTo) {
        setManufacturerFilter();
        maxPriceFilter(price);
        setReleasedAfterYearFilter(releaseYear);
        browser.pageScrollDown();
        setDiagonalFromFilter(diagonalFrom);
        setDiagonalToFilter(diagonalTo);
    }

    public boolean checkResults (WebDriver driver) {
        List<BaseElement> searchItemList = new ArrayList<BaseElement>();
        //searchItemList = browser.(By.xpath(".//div[@id='schema-products']/div"));
        return true;
    }


}
