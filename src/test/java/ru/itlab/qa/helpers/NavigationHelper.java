package ru.itlab.qa.helpers;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    private AppManager manager;

    public NavigationHelper(AppManager manager) {
        this.manager = manager;
        driver = manager.driver;
    }

    public void goToPageWithDrafts() {
        driver.findElement(By.cssSelector(".type_base--rkphf:nth-child(3) path")).click();
    }

    public void goToLoginPage(){
        driver.get("https://account.mail.ru/login?page=https%3A%2F%2Faccount.mail.ru%2F%3F&");
    }

    public void goToMainPage(){
        driver.get("https://e.mail.ru/inbox");
    }


}
