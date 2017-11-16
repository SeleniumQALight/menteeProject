package dropDownTest;

import org.junit.Test;
import parentTest1.ParentTest;

public class DropDownTest extends ParentTest {
    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInputLogin("Student");
        loginPage.enterPassToInputPass("909090");
        loginPage.clickButtonLogIn();

        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();

        sparePage.clickOnAddNewSpareButton();

        sparePage.enterSpareNameToInoutSpareName("MySpare");
        sparePage.clickOnSpareDropDown();
        sparePage.clickOnSpareTypeDropDownByText("Механика");
        sparePage.clickOnCreateNewSpareButton();

        checkAcceptanceCriteria(" Avatar is not present",homePage.isAvatarPresent(), true);
    }
}


