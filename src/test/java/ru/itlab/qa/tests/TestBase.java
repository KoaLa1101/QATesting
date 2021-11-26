package ru.itlab.qa.tests;


import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.itlab.qa.helpers.AppManager;

public class TestBase {
    private static AppManager manager;
    static {
        manager = new AppManager();
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

    public void deleteDraft(){
        manager.getDeleteHelper().deleteDraft();
    }

    public boolean checkIsExistDraft(){
        return manager.getDraftHelper().isExistDraft();
    }


}
