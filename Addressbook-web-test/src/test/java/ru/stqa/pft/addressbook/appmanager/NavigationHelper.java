package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

    private WebDriver wb;

    public NavigationHelper(WebDriver wb) {
        this.wb = wb;
    }

    public void goToGroupPage() {
        wb.findElement(By.linkText("groups")).click();
    }
}
