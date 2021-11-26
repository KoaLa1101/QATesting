package ru.itlab.qa.tests;


import com.fasterxml.jackson.core.type.TypeReference;
import ru.itlab.qa.helpers.AppManager;
import ru.itlab.qa.helpers.JsonUtil;
import ru.itlab.qa.models.AccountData;
import ru.itlab.qa.models.Mail;

import java.io.IOException;
import java.util.List;

public class TestBase {
    private static AppManager manager;
    private static JsonUtil<AccountData> dataJsonUtil = new JsonUtil<>();
    private static JsonUtil<Mail> mailJsonUtil = new JsonUtil<>();
    private static TypeReference<List<AccountData>> accTypeReference = new TypeReference<>() {};
    private static TypeReference<List<Mail>> mailTypeReference = new TypeReference<>() {};

    static {
        for (int i = 1; i < 2; i++) {
            try {
                manager = new AppManager(dataJsonUtil.readValues("accountData.json", accTypeReference).get(0), mailJsonUtil.readValues("mail.json", mailTypeReference).get(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void tearDown() {
        manager.stop();
    }

    public void login() {
        manager.getLoginHelper().login();
    }

    public void createNewDraft() {
        manager.getDraftHelper().createNewMail();
    }

    public void deleteDraft() {
        manager.getDeleteHelper().deleteDraft();
    }

    public boolean checkIsExistDraft() {
        return manager.getDraftHelper().isExistDraft();
    }


}
