package ru.itlab.qa.helpers;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.itlab.qa.models.Mail;

public class DraftHelper extends HelperBase {
    private AppManager manager;
    private Mail mail;

    public DraftHelper(AppManager manager, Mail mail, WebDriverWait webDriverWait) {
        this.manager = manager;
        this.mail = mail;
        driver = manager.driver;
        this.webDriverWait = webDriverWait;
    }

    @SneakyThrows
    public void createNewMail(Mail mail) {
        driver.get("https://e.mail.ru/inbox");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".compose-button__txt")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".container--ItIg4 > .inputContainer--nsqFu > .container--H9L5q")).sendKeys(mail.receiver);
        Thread.sleep(1000);
        driver.findElement(By.name("Subject")).sendKeys(mail.theme);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[5]/div/div/div[2]/div/div")).click();
        /*driver.findElement(By.cssSelector(".editable-l1hi > div:nth-child(2)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".editable-r3nk > div:nth-child(2)"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }*/
        {
            WebElement element = driver.findElement(By.xpath("//div[5]/div/div/div[2]/div"));
            manager.js.executeScript("arguments[0].innerText = '" + mail.text + "'", element);
//            manager.js.executeAsyncScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<div><br></div><div>GGGGGGGGG</div><div>G2131231</div><div>sdfdsfsdfs</div><div>dfdf</div><div><br></div><div tabindex=\"-1\" contenteditable=\"false\" data-cke-widget-wrapper=\"1\" data-cke-filter=\"off\" class=\"cke_widget_wrapper cke_widget_block cke_widget_signature\" data-cke-display-name=\"div\" data-cke-widget-id=\"0\" role=\"region\" aria-label=\"div виджет\"><div data-signature-id=\"current\" data-signature-widget=\"container\" data-cke-widget-data=\"%7B%22content%22%3A%22%3Cdiv%3E--%3Cbr%3E%D0%A0%D0%B8%D0%BD%D0%B0%D1%82%20%D0%90%D1%85%D0%BC%D0%B5%D1%82%D1%85%D0%B0%D0%BD%D0%BE%D0%B2%3C%2Fdiv%3E%22%2C%22contentEmpty%22%3A%22%3Cdiv%3E%3Cbr%3E%3C%2Fdiv%3E%22%2C%22control%22%3A%22%D0%9F%D0%BE%D0%B4%D0%BF%D0%B8%D1%81%D1%8C%22%2C%22controlEmpty%22%3A%22%D0%91%D0%B5%D0%B7%20%D0%BF%D0%BE%D0%B4%D0%BF%D0%B8%D1%81%D0%B8%22%2C%22classes%22%3Anull%7D\" data-cke-widget-upcasted=\"1\" data-cke-widget-keep-attr=\"0\" data-widget=\"signature\" class=\"cke_widget_element\"><div data-signature-widget=\"control\"><div class=\"control--3cIHW\"><button type=\"button\" tabindex=\"-1\" title=\"Вставка подписи\" class=\"container--2lPGK type_grey--1wJTi color_grey--BOELh\"><span>Подпись</span><div class=\"container--1HmQy\"><svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" xmlns=\"http://www.w3.org/2000/svg\" class=\"base-0-2-1\" ie-style=\"\"><path fill-rule=\"evenodd\" clip-rule=\"evenodd\" d=\"M12.9657 8.23431c.3124.31242.3124.81896 0 1.13138l-2.4 2.40001c-.3125.3124-.81898.3124-1.1314 0l-2.4-2.40001c-.31242-.31242-.31242-.81896 0-1.13138.31242-.31242.81895-.31242 1.13137 0l1.83431 1.83429 1.83432-1.83429c.3124-.31241.8189-.31241 1.1314 0z\"></path></svg></div></button></div></div><div data-signature-widget=\"content\" contenteditable=\"true\" data-cke-widget-editable=\"content\" data-cke-enter-mode=\"3\" class=\"cke_widget_editable\"><div>--<br>Ринат Ахметханов</div></div></div></div>'}", element);
        }
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".button2:nth-child(2) .button2__txt")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".button2:nth-child(3) .button2__txt")).click();
    }

    public boolean isExistDraft(Mail mail) {
        driver.get("https://e.mail.ru/drafts/");
        int i = 1;
        while (i < 5) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/div/div/a["+i+"]/div[4]")));
            String str = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[1]/div/div/div[1]/div/div/div/a["+i+"]/div[4]")).getText();
            i++;
            if(str.contains(mail.getReceiver()) && str.contains(mail.getTheme()) && str.contains(mail.getText())) return true;
        }
        return false;
    }
}
