package logInTest;

import parentTest1.ParentTest;
import org.junit.Test;

public class LogInTest extends ParentTest{
    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInputLogin("Student");
        loginPage.enterPassToInputPass("909090");
        loginPage.clickButtonLogIn();

        checkAcceptanceCriteria(" Avatar is not present",homePage.isAvatarPresent(), true);
        checkAcceptanceCriteria(" Title is not matched ", homePage.getTitle(), "Учет запчастей");
    }


}
