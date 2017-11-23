package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import libs.DataProvider;

public class SparePage extends  ParentPage {

    public SparePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@ data-original-title=\"Add\"]")
    private WebElement addButton;

    private String title = "Запчасти Список";

    public void clickAddButton() {
        actionsWithElements.clickOnElement(addButton);
    }

    public ArrayList<String> getListOfExistingSpareNames() {
        ArrayList<WebElement> spareList = new ArrayList<WebElement>(
                webDriver.findElements(By.xpath(".//*[@id='device_list']/tbody/tr/td[1]")));
        ArrayList <String> spareNameList=new ArrayList<String>();
        for (WebElement w:spareList) {
            spareNameList.add(w.getText());
        }
        return spareNameList;
    }

    public boolean isSpareInList(String name)
    {
        return new DataProvider().isStringInList(getListOfExistingSpareNames(), name);
    }

    public void checkTitle() {
        super.checkTitle(title);
    }

}
