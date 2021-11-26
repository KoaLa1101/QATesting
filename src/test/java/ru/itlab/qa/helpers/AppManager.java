package ru.itlab.qa.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.itlab.qa.helpers.DraftHelper;
import ru.itlab.qa.helpers.HelperBase;
import ru.itlab.qa.helpers.LoginHelper;
import ru.itlab.qa.helpers.NavigationHelper;
import ru.itlab.qa.models.AccountData;
import ru.itlab.qa.models.Mail;

public class AppManager{
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public JavascriptExecutor js;
    private AccountData accountData;
    private Mail mail;

    private LoginHelper loginHelper;
    private DraftHelper draftHelper;
    private NavigationHelper navigationHelper;
    private DeleteHelper deleteHelper;

//    private static ThreadLocal<AppManager> app = new ThreadLocal<AppManager>();

//    public static AppManager GetInstance(){
//        if(app.get() == null){
//            AppManager newInstance = new AppManager();
//            newInstance.navigationHelper.goToLoginPage();
//            app.set(newInstance);
//        }
//        return app.get();
//    }

    public AppManager() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        webDriverWait = new WebDriverWait(driver, 20);
        //set acc
        accountData = new AccountData();
        accountData.setUsername("akhmethanov@internet.ru");
        accountData.setPassword("Sne)I(ok1101");
        //set mail
        mail = new Mail();
        mail.setReceiver("rproba@list.ru");
        mail.setTheme("test fail msg");
        mail.setText("Hello world! by @koala1101");
        //set helpers
        loginHelper = new LoginHelper(this, accountData);
        draftHelper = new DraftHelper(this, mail, webDriverWait);
        navigationHelper = new NavigationHelper(this);
        deleteHelper = new DeleteHelper(this);
    }



    public void stop(){
        driver.quit();
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public DraftHelper getDraftHelper() {
        return draftHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public DeleteHelper getDeleteHelper() {
        return deleteHelper;
    }
}
