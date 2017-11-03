package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PerentPage{

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(name = "_password")
    private WebElement inputPass;

    @FindBy(tagName = "button")
    private WebElement buttonLogIn;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void openLoginPage(){
        try{
            webDriver.get("http://v3.test.itpmgroup.com/login");
            logger.info("LoginPage was opened");
        }catch (Exception e){
            logger.error("Page was not opened");
            Assert.fail("Page was not opened");
        }
    }

    public void enterLoginToInputLogin(String login) {
//        try{
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login + " was inputed into input");
//        }catch (Exception e){
//            logger.error("can not work with element");
//            Assert.fail("can not work with element");
//        }
        actionsWithOurElements.enterTextInToInput(inputLogin,login);
    }

    public void enterPassToInputPass(String pass){
        actionsWithOurElements.enterTextInToInput(inputPass,pass);
    }

    public void clickButtonLogIn(){
        actionsWithOurElements.clickOnElement(buttonLogIn);
    }

}
