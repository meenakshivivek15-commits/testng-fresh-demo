package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected WebDriver driver;

    // 🔹 LOCATORS (WHAT)
    @FindBy(tagName = "h1")
    private WebElement pageHeading;

    @FindBy(css = "p")
    private WebElement descriptionText;

    @FindBy(css = "a")
    private WebElement moreInfoLink;

    // 🔹 CONSTRUCTOR
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 🔹 ACTIONS (HOW)
    public void open(String url) {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getHeadingText() {
        return pageHeading.getText();
    }

    public boolean isMoreInfoLinkDisplayed() {
        return moreInfoLink.isDisplayed();
    }
}
