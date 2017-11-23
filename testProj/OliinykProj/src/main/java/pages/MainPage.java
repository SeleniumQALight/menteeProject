package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends ParentPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement dictionaryButton;

    @FindBy(xpath = ".//*[@id='spares']/a")
    private WebElement spareButton;

    private String title = "Главная";

    public void clickDictionaryButton() {
        actionsWithElements.clickOnElement(dictionaryButton);
    }

    public void clickSpareButton() {
        actionsWithElements.clickOnElement(new WebDriverWait(webDriver,5)
                .until(ExpectedConditions.elementToBeClickable(spareButton)));
    }

    public void checkTitle() {
        super.checkTitle(title);
    }
}
