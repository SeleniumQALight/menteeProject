package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement usernameInput;

    @FindBy(name = "_password")
    private WebElement passwordinput;

    @FindBy(tagName = "button")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Page was opened");
        }catch (Exception e){
            logger.error("Page was not opened");
            Assert.fail("Page was not opened");
        }
    }

    public void enterUsername(String username) {
        actionsWithElements.enterTextInToInput(usernameInput, username);
    }

    public  void enterPassword(String password) {
        actionsWithElements.enterTextInToInput(passwordinput, password);
    }

    public void clickSubmitButton()  {
        actionsWithElements.clickOnElement(submitButton);
    }

    public void logIn(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmitButton();
    }
}
