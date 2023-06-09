package index.demo.com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import index.demo.com.tutorialsninja.customlisteners.CustomListeners;
import index.demo.com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

/**
 * Created by Jay Vaghani
 */
public class MyAccountPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;
   @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;
  @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    public String getAccountLogoutText() {
        CustomListeners.test.log(Status.PASS,"getAccountLogoutText " + accountLogoutText);
        Reporter.log("getAccountLogoutText " + accountLogoutText.toString());
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText() {
        CustomListeners.test.log(Status.PASS,"getYourAccountHasBeenCreatedText " + accountCreatedText);
        Reporter.log("getYourAccountHasBeenCreatedText " + accountCreatedText.toString());
        return getTextFromElement(accountCreatedText);
    }
    public void clickOnContinueButton() {
        CustomListeners.test.log(Status.PASS,"clickOnContinueButton " + continueBtn);
        Reporter.log("clickOnContinueButton " + continueBtn.toString());
        clickOnElement(continueBtn);
    }
}
