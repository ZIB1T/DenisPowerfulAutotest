package test_cases;

import devices.DeviceCapability;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import java.net.MalformedURLException;
import java.net.URL;

public class CreatePrivateChatTest  {

    private AndroidDriver<MobileElement> driver;

    private void initResource() {
        DeviceCapability capability = new DeviceCapability();

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:" + "4723" + "/wd/hub"), capability.getCapabilitySettings());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void createPrivateChat() {

        initResource();

        // открываем список чатов
        driver.findElementById("fab").click();

        // останавливаем тест на 2 секунды, что бы видеть результат
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // нажимаем на первый попавшийся аватар
        driver.findElementById("contact_photo_image").click();

        // останавливаем тест на 2 секунды, что бы видеть результат
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // нажимаю на строку ввода текста, паралельно проверяя, открыт ли приватный чат
        try {
            driver.findElementById("embedded_text_editor").isDisplayed();
            sendMessage();
        } catch (NoSuchElementException e) {
        System.out.println("Приватный чат не создан");
     }
    }

    private void sendMessage() {
        driver.findElementById("embedded_text_editor").click();

        // останавливаю тест на 1 секунду, что бы успела выдвинуться клавиатура
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ввожу текст в поле ввода
        driver.findElementById("embedded_text_editor").sendKeys("Обычное сообщение");

        // останавливаем тест на 2 секунды, что бы видеть результат
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // нажимаю на кнопку отправки
        driver.findElementById("send_button").click();

        // останавливаем тест на 2 секунды, что бы видеть результат
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            driver.findElementById("delivered_indicator").isDisplayed();
            System.out.println("Сообщение было отправлено");
        } catch (NoSuchElementException e) {
            System.out.println("Сообщение не было отправлено");
        }

        // останавливаем тест на 2 секунды, что бы видеть результат
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
