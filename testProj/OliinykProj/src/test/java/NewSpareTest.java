import ParentTest.ParentTest;
import libs.DataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class NewSpareTest extends ParentTest{

    String login, pass, spareName, spareType;
    public NewSpareTest(String login, String pass, String spareType){
        this.login = login;
        this.pass = pass;
        this.spareType = spareType;
    }

    @Parameterized.Parameters
    public static Collection testDData(){
        return Arrays.asList(new Object[][]{
                {"Student","909090", "Механика"}
        });
    }

    @Test
    public void addNewSpareTest()
    {
        spareName = new DataProvider().generateNewUniqueSpareName(sparePage.getListOfExistingSpareNames());

        loginPage.openPage();
        loginPage.logIn(login, pass);
        mainPage.checkTitle();
        mainPage.clickDictionaryButton();
        mainPage.clickSpareButton();
        sparePage.checkTitle();
        sparePage.clickAddButton();
        editSparePage.checkTitle();
        editSparePage.enterNewSpare(spareName);
        editSparePage.chooseSpareTypeInDropDown(spareType);
        editSparePage.clickAddSpareButton();
        sparePage.checkTitle();
        checkAcceptanceCriteria("New Spare was not added", sparePage.isSpareInList(spareName),true);
    }

    @Override
    public void tearDown() {
        try {
            webDriver.findElement(By.xpath(".//*[text()='" + spareName + "']")).click();
            editSparePage.clickDeleteSpare();
        }catch(Exception e){
            sparePage.logger.error("can not delete element");
            Assert.fail("can not delete element");
        }
        finally {
            super.tearDown();
        }
    }
}
