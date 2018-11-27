package myprojects.automation.assignment4;


import java.util.concurrent.TimeUnit;
import myprojects.automation.assignment4.model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {

  private WebDriver driver;
  private WebDriverWait wait;
  private Actions actions;

  public GeneralActions(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 30);
    actions = new Actions(driver);
  }

  /**
   * Logs in to Admin Panel.
   */
  public void login(String login, String password) {
    driver.manage().window().maximize();
    driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
    driver.findElement(By.id("email")).sendKeys(login);
    driver.findElement(By.id("passwd")).sendKeys(password);
    driver.findElement(By.name("submitLogin")).click();
  }

  public void createProduct(ProductData newProduct) {
    // TODO implement product creation scenario
    throw new UnsupportedOperationException();
  }

  public void waitForContentLoadElement(String elementToWait) {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementToWait)));
  }

  /**
   * Waits until page loader disappears from the page
   */
  public void waitForContentLoad() {
    // TODO implement generic method to wait until page content is loaded

//     wait.until(ExpectedConditions.);
    // ...
  }

  public void gotTo(String goTo) {

    WebElement element = driver.findElement(By.id(goTo));
    actions.moveToElement(element).perform();

  }

  public void waitForElementVisible(String s) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(s)));
  }

  public void gotToAndClick(String s) {
    WebElement element = driver.findElement(By.id(s));
    actions.moveToElement(element).click().build().perform();
  }

  public void waitForContentLoaded() {
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
  }

  public void fillProductFields() {
//product name
    ProductData data = ProductData.generate();
    driver.findElement(By.id("form_step1_name_1")).sendKeys(data.getName());
//quantity
    WebElement qty = driver.findElement(By.id("form_step1_qty_0_shortcut"));
    qty.clear();
    qty.sendKeys(data.getQty().toString());
//price
    WebElement price = driver.findElement(By.id("form_step1_price_shortcut"));
    price.clear();
    price.sendKeys(data.getPrice());
//activate
//    WebElement activate = driver.findElement(By.id("form_step1_active"));
    WebElement activate = driver.findElement(By.xpath("//*[@id=\"form_step1_active\"]"));
    System.out.println(activate.getTagName());
    activate.click();

//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("growl-message")));

  }
}
