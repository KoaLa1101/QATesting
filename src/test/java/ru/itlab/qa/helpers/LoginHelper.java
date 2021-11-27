package ru.itlab.qa.helpers;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.util.Assert;
import ru.itlab.qa.models.AccountData;

@Slf4j
public class LoginHelper extends HelperBase {
    private AccountData accountData;

    public LoginHelper(AppManager manager, AccountData accountData) {
        this.accountData = accountData;
        driver = manager.driver;
    }

    @SneakyThrows
    public void login() {
        driver.get("https://account.mail.ru/login?page=https%3A%2F%2Faccount.mail.ru%2F%3F&");
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        Thread.sleep(3000);
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys(accountData.getUsername());
        driver.findElement(By.cssSelector(".innerTextWrapper-0-2-90:nth-child(1)")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(accountData.getPassword());

        {
            WebElement element = driver.findElement(By.name("password"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.cssSelector(".innerTextWrapper-0-2-90:nth-child(1)")).click();
        Thread.sleep(2000);
        Assert.isTrue(isAuthed());
        Thread.sleep(2000);
    }

    @SneakyThrows
    private boolean isAuthed(){
        Thread.sleep(3000);
        By username = By.xpath("/html/body/div[3]/div[1]/div/div[2]/div[2]/span[2]");
        log.info("USERNAME : " + driver.findElement(username).getText());
        return driver.findElement(username).getText().equals(accountData.getUsername());

    }

}
