package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupsHelper {

     WebDriver wb;

   public GroupsHelper(WebDriver wb) {
        this.wb = wb;
    }

    public void returnToGoPage() {
        wb.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        wb.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        wb.findElement(By.name("group_name")).click();
        wb.findElement(By.name("group_name")).clear();
        wb.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wb.findElement(By.name("group_header")).clear();
        wb.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wb.findElement(By.name("group_footer")).clear();
        wb.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {
        wb.findElement(By.name("new")).click();
    }

    public void deleteSelectedGroups() {
      wb.findElement(By.name("delete")).click();
    }

    public void selectGroup() {//доступно из классов наследников и из основного класса
      wb.findElement(By.name("selected[]")).click();
    }
}
