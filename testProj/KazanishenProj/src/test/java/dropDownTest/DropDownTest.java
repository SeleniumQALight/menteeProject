package dropDownTest;

import libs.ActionsWithOurElements;
import libs.Utils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PerentPage;
import parentTest1.ParentTest;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DropDownTest extends ParentTest {
    @Test
    public void validLogin(){
        String spareName = new Date(System.currentTimeMillis()).toString();
        String spareType = "Механика";

        loginPage.openLoginPage();
        loginPage.enterLoginToInputLogin("Student");
        loginPage.enterPassToInputPass("909090");
        loginPage.clickButtonLogIn();

        homePage.clickOnMenuDictionary();

        homePage.clickOnSubMenuSpare();


        sparePage.clickOnAddNewSpareButton();

        addNewSparePage.enterSpareNameToInputSpareName(spareName);
        addNewSparePage.clickOnSpareDropDownElementByText(spareType);
        addNewSparePage.clickOnCreateNewSpareButton();

        checkAcceptanceCriteria(" Record was not added",sparePage.isElementInSpareList(spareName, spareType), true);
    }
}


