package logInTest;

import libs.ConfigData;
import libs.ExcelDriver;
import org.junit.Assert;
import parentTest1.ParentTest;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class LogInTest extends ParentTest{

    public LogInTest() {
        super("chrome");
    }

    @Test
    public void validLogin() throws IOException {
        Map<String,String> dataForTest = excelDriver.getData(ConfigData.getCfgValue("DATA_FILE"),"validLogOn");
        loginPage.openLoginPage();
        loginPage.enterLoginToInputLogin(dataForTest.get("login"));
        loginPage.enterPassToInputPass(dataForTest.get("pass"));
        loginPage.clickButtonLogIn();
//        Assert.fail();
        checkAcceptanceCriteria(" Avatar is not present",homePage.isAvatarPresent(), true);
//        checkAcceptanceCriteria(" Title is not matched ", homePage.getTitle(), "Главная ");
    }


}
