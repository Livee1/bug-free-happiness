package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.fail;

public class GroupCreationTests {
  private WebDriver wb;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    wb = new FirefoxDriver();
    wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    wb.get("http://localhost/addressbook/group.php");
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys("admin");
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys("secret");
    wb.findElement(By.xpath("//input[@value='Login']")).click();

  }

  @Test
  public void testGroupCreation() throws Exception {

    wb.findElement(By.name("new")).click();
    wb.findElement(By.name("group_name")).click();
    wb.findElement(By.name("group_name")).clear();
    wb.findElement(By.name("group_name")).sendKeys("test1");
    wb.findElement(By.name("group_header")).clear();
    wb.findElement(By.name("group_header")).sendKeys("test1");
    wb.findElement(By.name("group_footer")).clear();
    wb.findElement(By.name("group_footer")).sendKeys("test1");
    wb.findElement(By.name("submit")).click();
    wb.findElement(By.linkText("group page")).click();
    wb.findElement(By.id("top")).click();
    wb.findElement(By.linkText("Logout")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wb.quit();

  }

  private boolean isElementPresent(By by) {
    try {
      wb.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wb.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
