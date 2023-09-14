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
        login("admin", "secret");//вызов метода

    }

    private void login(String username, String password) {
        wb.findElement(By.name("user")).click();
        wb.findElement(By.name("user")).clear();
        wb.findElement(By.name("user")).sendKeys(username);
        wb.findElement(By.name("pass")).clear();
        wb.findElement(By.name("pass")).sendKeys(password);
        wb.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testGroupCreation() throws Exception {

        goToGroupPage();//перейти на стр со списком групп
        initGroupCreation();//инициировать создание новой группы
        fillGroupForm(new GroupData("test1", "test1", "test1"));//заполнить форму
        submitGroupCreation();//подтвердить создание группы
        returnToGoPage();//вернуться на стр со списком групп

    }

    private void returnToGoPage() {
        wb.findElement(By.linkText("group page")).click();
    }

    private void goToGroupPage() {
        wb.findElement(By.linkText("groups")).click();
    }

    private void submitGroupCreation() {
        wb.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        wb.findElement(By.name("group_name")).click();
        wb.findElement(By.name("group_name")).clear();
        wb.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wb.findElement(By.name("group_header")).clear();
        wb.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wb.findElement(By.name("group_footer")).clear();
        wb.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    private void initGroupCreation() {
        wb.findElement(By.name("new")).click();
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
