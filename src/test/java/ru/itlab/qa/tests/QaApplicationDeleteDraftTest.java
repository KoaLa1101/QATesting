package ru.itlab.qa.tests;

import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QaApplicationDeleteDraftTest extends TestBase{
    @SneakyThrows
    @Test
    public void testCreateMail() {
      //  login();
        deleteDraft();
    }
}
