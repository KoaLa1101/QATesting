package ru.itlab.qa.helpers;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DeleteHelper extends HelperBase{
    private AppManager manager;
    private Actions actions;

    public DeleteHelper(AppManager manager) {
        this.manager = manager;
        driver = manager.driver;
        actions = new Actions(driver);
    }

    @SneakyThrows
    public void deleteDraft() {
        driver.get("https://e.mail.ru/inbox");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id=\'sideBarContent\']/div/nav/a[6]/div/div[2]")).click();
        Thread.sleep(2000);
        {
            WebElement element = driver.findElement(By.xpath("//div[@id='app-canvas']/div/div/div/div/div[2]/span/div[2]/div/div/div/div/div/div/div/div/div/div/div/a/div[2]/span"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/div/div/a[1]/div[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".button2_delete .button2__txt")).click();
    }
}
