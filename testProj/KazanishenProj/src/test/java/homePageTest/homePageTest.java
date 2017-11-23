package homePageTest;

import libs.Utils;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import parentTest1.ParentTest;

import java.util.Date;

public class homePageTest extends ParentTest {
    @Test
    public void validLogin(){

        loginPage.loginInApp("Student", "909090");

        homePage.clickOnSidebarToggleButton();

        checkAcceptanceCriteria(" Record was not added",homePage.isAvatarOnLeftSidePresent(), false);
    }
}


