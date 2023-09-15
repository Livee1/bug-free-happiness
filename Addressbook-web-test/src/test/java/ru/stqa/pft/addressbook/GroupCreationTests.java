package ru.stqa.pft.addressbook;

import org.testng.annotations.*;



public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {

        goToGroupPage();//перейти на стр со списком групп
        initGroupCreation();//инициировать создание новой группы
        fillGroupForm(new GroupData("test1", "test1", "test1"));//заполнить форму
        submitGroupCreation();//подтвердить создание группы
        returnToGoPage();//вернуться на стр со списком групп

    }

}
