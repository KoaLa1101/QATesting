package ru.itlab.qa.tests;

import lombok.SneakyThrows;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QaApplicationRunAllTests extends TestBase{

    @SneakyThrows
    @Test
    public void auth(){
        login();
    }

    @SneakyThrows
    @Test
    public void createDraft(){
        createNewDraft();
    }

    @SneakyThrows
    @Test
    public void removeDraft(){
        deleteDraft();
    }

    @AfterClass
    public static void stop(){
        tearDown();
    }

}
