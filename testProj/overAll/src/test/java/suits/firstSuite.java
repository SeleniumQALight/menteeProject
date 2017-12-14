package suits;

import logInTest.LogInTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import spareTests.addNewSpareTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LogInTest.class,
          addNewSpareTest.class}
)

public class firstSuite {
}
