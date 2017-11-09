import ParentTest.ParentTest;
import org.junit.Test;

public class SelectTest extends ParentTest{
    @Test
    public void selectVolvo(){
        mainPage.openPage();
        mainPage.selectInSelectElement("volvo");
        //checkAcceptanceCriteria(" Avatar is not present",homePage.isAvatarPresent(), true);
    }
}
