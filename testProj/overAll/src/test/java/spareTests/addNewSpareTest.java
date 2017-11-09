package spareTests;

import org.junit.Test;
import parentTest1.ParentTest;

public class addNewSpareTest extends ParentTest{
    @Test
    public void addNewSpare(){
        loginPage.loginInApp("Student", "909090");
        homePage.checkTitle("Учет запчастей");
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkZagolovok("Запчасти Список");
    }
}
