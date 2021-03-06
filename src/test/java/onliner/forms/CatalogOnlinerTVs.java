package onliner.forms;

import onliner.SearchItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.Browser;
import webdriver.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatalogOnlinerTVs extends BaseForm {
    private Checkbox manufacturerFilter = new Checkbox(By.xpath("//span[@class='schema-filter__checkbox-text' and .='Samsung']"),"Manufacturer");
    private TextBox maxPriceFilter = new TextBox(By.xpath(".//*[@id='schema-filter']//input[@placeholder='до']"),"MaxPrice");
    private TextBox releasedAfterYearFilter = new TextBox(By.xpath(".//*[@id='schema-filter']//input[@placeholder='2010']"),"Released after year");
    private Dropdown diagonalFromFilter = new Dropdown(By.xpath("//span[.='Диагональ']/../following-sibling::div/div/div/select[contains(@data-bind,'from')]"),"Diagonal min");
    private Dropdown diagonalToFilter = new Dropdown(By.xpath("//span[.='Диагональ']/../following-sibling::div/div/div/select[contains(@data-bind,\"to\")]"),"Diagonal max");
    public Container searchResultsDiv = new Container(By.xpath(".//div[@id='schema-products']"));
    private List<Link> searchResults;

    public void getSearchRetults () {
        searchResults = searchResultsDiv.getElements(By.xpath(".//div[@id='schema-products']//div[contains(@class,'title')]"));
    }

   /* public void getSearchResults (By by) {
        searchResults = getElements(by);
    }*/


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

    private static Integer getTVDiagonal (String text) {
        Pattern pattern = Pattern.compile("[0-9][0-9]\"");
        Matcher matcher = pattern.matcher(text);
        String s = "";
        while (matcher.find()) {
            s = matcher.group(1);
        }
        return Integer.parseInt(s);
    }



    public boolean checkResults (List<WebElement> elements, String manufacturerFilterValue, String maxPriceFilterValue, String releasedAfterYearFilterValue, String diagonalFromFilterValue, String diagonalToFilterValue) {
        for (WebElement element:elements) {
            logger.info("Checking element:" + element.getText());
            Assert.assertTrue(element.getText().contains(manufacturerFilterValue));
            Assert.assertTrue(element.getText().contains(maxPriceFilterValue));
            Assert.assertTrue((Integer.parseInt(diagonalFromFilterValue)<=getTVDiagonal(element.getText())) && (getTVDiagonal(element.getText())<=Integer.parseInt(diagonalToFilterValue)));
/*            if (element.getText().contains(releasedAfterYearFilterValue)) {
                logger.info("Release Year OK for element " + element.getText());
            }
            else {result = false;}*/

        }
        return true;
    }


}
