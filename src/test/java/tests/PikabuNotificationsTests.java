package tests;

import data.NotificationsData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PikabuMainPage;
import pages.PikabuNotificationPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Проверки сайта Pikabu на странице уведомлений")
public class PikabuNotificationsTests extends BaseTest {

    PikabuMainPage mainPage = new PikabuMainPage();
    PikabuNotificationPage notifPage = new PikabuNotificationPage();
    NotificationsData notifData = new NotificationsData();

    @Test
    @Tag("NotifTest")
    @Tag("AllTestRemote")
    @Tag("AllTestLocal")
    @DisplayName("Проверка первого уведомления на сайте")
    void checkFirstNotification() {
        step("Кликаем на главной странице на значёк уведомлений", () -> {
            mainPage.openPage()
                    .clickNotificationButtton();
        });

        step("Проверяем наличие первого уведомления при входе на сайт", () -> {
            notifPage.checkFirstMessage(notifData.firstNotification);
        });
    }

    @Test
    @Tag("NotifTest")
    @Tag("AllTestRemote")
    @Tag("AllTestLocal")
    @DisplayName("Проверка появления формы регистрации из первого уведомления на сайте")
    void checkRegistrationFieldAfterClickButtonInNotification() {
        step("Кликаем на главной странице на значёк уведомлений", () -> {
            mainPage.openPage()
                    .clickNotificationButtton();
        });
        step("Кликаем на гиперссылку 'Зарегистрироваться' в уведомлении и проверяем форму регистрации справа",
                () -> {
                    notifPage.clickToRegistrtrationInNotif()
                            .checkOpenRegistrationField(notifData.RegistrationFieldTitle);
                });
    }
}
