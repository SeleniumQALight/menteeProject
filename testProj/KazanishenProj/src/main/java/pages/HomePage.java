package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PerentPage {
    @FindBy(xpath = ".//span[text()='StudentNew']")
    WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(xpath = ".//a[@href='/dictionary/spares']")
    private WebElement subMenuSpare;

    @FindBy(className = "sidebar-toggle")
    private WebElement sidebarToggleButton;

    @FindBy(className = "img-circle")
    private WebElement avatarOnLeftSide;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(avatar);
    }

    public boolean isSubMenuSparePresent() {
        return actionsWithOurElements.isElementPresent(subMenuSpare);
    }

    public boolean isAvatarOnLeftSidePresent(){return actionsWithOurElements.isElementPresent(avatarOnLeftSide);}

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpare(){
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }

    public void clickOnSidebarToggleButton(){actionsWithOurElements.clickOnElement(sidebarToggleButton);}




}
