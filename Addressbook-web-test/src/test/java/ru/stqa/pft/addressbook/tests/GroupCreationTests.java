package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {

        app.getNavigationHelper().goToGroupPage();//перейти на стр со списком групп
        app.getGroupsHelper().initGroupCreation();//инициировать создание новой группы
        app.getGroupsHelper().fillGroupForm(new GroupData("test1", "test1", "test1"));//заполнить форму
        app.getGroupsHelper().submitGroupCreation();//подтвердить создание группы
        app.getGroupsHelper().returnToGoPage();//вернуться на стр со списком групп

    }

}
