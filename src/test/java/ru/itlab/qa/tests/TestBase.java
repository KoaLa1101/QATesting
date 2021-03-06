package ru.itlab.qa.tests;


import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;
import org.junit.Assert;
import ru.itlab.qa.helpers.AppManager;
import ru.itlab.qa.helpers.JsonUtil;
import ru.itlab.qa.models.AccountData;
import ru.itlab.qa.models.Mail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestBase {
    private static AppManager manager;
    private static JsonUtil<AccountData> dataJsonUtil = new JsonUtil<>();
    private static JsonUtil<Mail> mailJsonUtil = new JsonUtil<>();
    private static TypeReference<List<AccountData>> accTypeReference = new TypeReference<>() {
    };
    private static TypeReference<List<Mail>> mailTypeReference = new TypeReference<>() {
    };

    static {
        manager = new AppManager();
    }

    public static void tearDown() {
        manager.stop();
    }

    public void login(int index) {
        manager.getLoginHelper().login(getAcc(index));
    }

    @SneakyThrows
    public void createNewDraft() {
        List<Mail> list = mailJsonUtil.readValues("mail.json", mailTypeReference);
//        List<Mail> mailList = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            mailList.add(Mail.builder().receiver(mailJsonUtil.generateString(5) + "@" + mailJsonUtil.generateString(4)).theme(mailJsonUtil.generateString(5)).text(mailJsonUtil.generateString(20)).build());
//        }
//        mailList.addAll(list);
//        mailJsonUtil.writeValues(mailList, "mail.json");
        for (int i = 0; i < 3; i++) {
            Assert.assertFalse(checkIsExistDraft(list.get(i)));
            manager.getDraftHelper().createNewMail(list.get(i));
            Thread.sleep(5000);
        }
    }

    @SneakyThrows
    public void deleteDraft() {
        manager.getDeleteHelper().deleteDraft();
    }

    public boolean checkIsExistDraft(Mail mail) {
        return manager.getDraftHelper().isExistDraft(mail);
    }


    @SneakyThrows
    private static AccountData getAcc(int index){
        return dataJsonUtil.readValues("accountData.json", accTypeReference).get(index);
    }

    public boolean isAuthed(int index){
        return manager.getLoginHelper().isAuthed(getAcc(index));
    }


}
