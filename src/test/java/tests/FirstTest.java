package tests;

import dataproviders.TitleDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.TestSetup;

public class FirstTest extends TestSetup {

    @Test(
        groups = "smoke",
        dataProvider = "titleData",
        dataProviderClass = TitleDataProvider.class
    )
    public void openHomePage(String url, String expectedTitle) {
        getDriver().get(url);
        Assert.assertEquals(getDriver().getTitle(), expectedTitle);
    }

    @Test(groups = "regression")
    public void dummyRegressionTest() {
        Assert.assertTrue(true);
    }
}
