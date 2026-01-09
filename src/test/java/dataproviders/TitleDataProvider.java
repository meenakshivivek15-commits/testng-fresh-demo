package dataproviders;

import org.testng.annotations.DataProvider;

public class TitleDataProvider {

    @DataProvider(name = "titleData")
    public Object[][] getTitleData() {
        return new Object[][]{
                {"https://example.com", "Example Domain"},
                {"https://example.com", "Example Domain"}
        };
    }
}

