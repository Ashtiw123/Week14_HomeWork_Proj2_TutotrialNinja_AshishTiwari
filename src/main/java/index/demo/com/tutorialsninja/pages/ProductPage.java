package index.demo.com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import index.demo.com.tutorialsninja.customlisteners.CustomListeners;
import index.demo.com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import java.util.List;

@Listeners(CustomListeners.class)
public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//h1")
    WebElement productText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement datePicker;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;

    @CacheLookup
    @FindBy(css = "#input-quantity")
    WebElement qtyField;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    public String getProductText() {
        CustomListeners.test.log(Status.PASS,"getProductText " + productText);
        Reporter.log("getProductText " + productText.toString());
        return getTextFromElement(productText);
    }

    public void selectDeliveryDate(String day, String month, String year) {
        clickOnElement(datePicker);
        while (true) {
            String monthAndYear = getTextFromElement(monthAndYearText);
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }
        }
        List<WebElement> allDates = getListOfElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(day)) {
                e.click();
                break;
            }
        }
    }

    public void enterQuantity(String qty) {
        CustomListeners.test.log(Status.PASS,"enterQuantity " + qtyField);
        Reporter.log("enterQuantity " + qtyField.toString());
        clearTextOnElement(By.cssSelector("#input-quantity"));
        sendTextToElement(qtyField, qty);
    }

    public void clickOnAddToCartButton() {
        CustomListeners.test.log(Status.PASS,"clickOnAddToCartButton " + addToCartButton);
        Reporter.log("clickOnAddToCartButton " + addToCartButton.toString());
        clickOnElement(addToCartButton);
    }

    public String getProductAddedSuccessMessage() {
        CustomListeners.test.log(Status.PASS,"getProductAddedSuccessMessage " + successMessage);
        Reporter.log("getProductAddedSuccessMessage " + successMessage.toString());
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkIntoMessage() {
        CustomListeners.test.log(Status.PASS,"clickOnShoppingCartLinkIntoMessage " + shoppingCartLink);
        Reporter.log("clickOnShoppingCartLinkIntoMessage " + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
    }

}
