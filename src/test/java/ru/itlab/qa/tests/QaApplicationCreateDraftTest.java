package ru.itlab.qa.tests;

import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QaApplicationCreateDraftTest extends AuthBase {

    @SneakyThrows
    @Test
    public void testCreateMail() {
//        login();
        createNewDraft();
    }
}
