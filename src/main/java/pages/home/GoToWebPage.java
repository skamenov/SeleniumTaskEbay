package pages.home;

import pages.base.BasePage;

public class GoToWebPage extends BasePage {

    public static void goToWebPage(String url) {
        driver.get(url);
    }
}
