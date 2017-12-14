package logInTest;

import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest1.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class LogInTestWithParamsFromExcel extends ParentTest{
   String login, pass;
    public LogInTestWithParamsFromExcel(String browser, String login, String pass){
        super(browser);
        this.login = login;
        this.pass = pass;
    }

//    @Parameterized.Parameters
//    public static Collection testDData(){
//        return Arrays.asList(new Object[][]{
//                {"chrome","Student","909090"},
//                {"iedriver","Student","909090"}
//        });
//    }
@Parameterized.Parameters
public static Collection testData() throws IOException {
    InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
    return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();      //2й параметр - указываем название листа в екселе
}

    @Test
    public void validLogin(){

        for (int i = 0; i <1000; i++) {

            System.out.println(i);
        }

        loginPage.openLoginPage();
        loginPage.enterLoginToInputLogin(login);
        loginPage.enterPassToInputPass(pass);
        loginPage.clickButtonLogIn();

        checkAcceptanceCriteria(" Avatar is not present",homePage.isAvatarPresent(), true);
        checkAcceptanceCriteria(" Title is not matched ", homePage.getTitle(), "Учет запчастей");
    }


}
