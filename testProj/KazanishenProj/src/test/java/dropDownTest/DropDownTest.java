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
        addNewSparePage.enterSpareNameToInputSpareName("MySpare");
        addNewSparePage.clickOnSpareDropDownElementByText("Механика");
        addNewSparePage.clickOnCreateNewSpareButton();

        checkAcceptanceCriteria(" Avatar is not present",homePage.isAvatarPresent(), true);
    }
}


