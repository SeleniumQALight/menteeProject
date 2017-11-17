package logInTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest1.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class LogInTestWithParams extends ParentTest{
   String login, pass;
    public LogInTestWithParams(String login, String pass){
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testDData(){
        return Arrays.asList(new Object[][]{
                {"Student","909090"},
                {"tudent","909090"}
        });
    }


    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.enterLoginToInputLogin(login);
        loginPage.enterPassToInputPass(pass);
        loginPage.clickButtonLogIn();

        checkAcceptanceCriteria(" Avatar is not present",homePage.isAvatarPresent(), true);
        checkAcceptanceCriteria(" Title is not matched ", homePage.getTitle(), "Учет запчастей");
    }


}
