package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {
    WebDriver wb;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupsHelper groupsHelper;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "");
        wb = new FirefoxDriver();
        wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wb.get("http://localhost/addressbook/group.php");
        groupsHelper = new GroupsHelper(wb);
        navigationHelper = new NavigationHelper(wb);
        sessionHelper = new SessionHelper(wb);
        sessionHelper.login("admin", "secret");//вызов метода
    }



    public void stop() {
        wb.quit();
    }

    public boolean isElementPresent(By by) {
        try {
            groupsHelper.wb.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            groupsHelper.wb.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void returnToGroupPage() {
        groupsHelper.returnToGoPage();
    }

    public GroupsHelper getGroupsHelper() {
        return groupsHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
