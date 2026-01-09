package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import dataproviders.TitleDataProvider;
import pages.HomePage;
import setup.TestSetup;

public class HomePageTest extends TestSetup {

    @Test(
        dataProvider = "titleData",
        dataProviderClass = TitleDataProvider.class,
        groups = { "smoke", "regression" }
    )
    public void openHomePage(String url, String expectedTitle) {

        // Create page object
        HomePage homePage = new HomePage(getDriver());

        // Step 1: Open URL
        homePage.open(url);

        // Step 2: Verify page title
        Assert.assertEquals(
                homePage.getTitle(),
                expectedTitle,
                "Home page title mismatch"
        );

        // Step 3: Verify heading text (UI validation)
        Assert.assertEquals(
                homePage.getHeadingText(),
                "Example Domain",
                "Page heading text mismatch"
        );

        // Step 4: Verify More Info link is displayed
        Assert.assertTrue(
                homePage.isMoreInfoLinkDisplayed(),
                "More information link is not displayed"
        );
    }
}
