package myprojects.automation.assignment4.tests;

import myprojects.automation.assignment4.BaseTest;
import myprojects.automation.assignment4.model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateProductTest extends BaseTest {

  @Test(dataProvider = "getCredentials")
  public void createNewProduct(String login, String password) {
    actions.login(login, password);
    actions.gotTo("subtab-AdminCatalog");
    actions.gotToAndClick("subtab-AdminProducts");
    actions.waitForContentLoaded();
    actions.gotToAndClick("page-header-desc-configuration-add");
    actions.waitForContentLoaded();
    actions.fillProductFields();

  }

  @DataProvider
  private Object[][] getCredentials() {
    return new Object[][]{
        {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}
    };
  }

  // TODO implement logic to check product visibility on website
}
