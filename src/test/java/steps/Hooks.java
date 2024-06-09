package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Browser;

public class Hooks {

    @Before
    public static void setup() {
        Browser.setup();
    }

    @After
    public static void tearDown() {
        Browser.tearDown();
    }
}
