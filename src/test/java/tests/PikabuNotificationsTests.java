package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.PikabuMainPage;
import pages.PikabuNotificationPage;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("NotifTest"), @Tag("AllTestRemote"), @Tag("AllTestLocal")})
@DisplayName("Проверки сайта Pikabu на странице уведомлений")
public class PikabuNotificationsTests extends BaseTest {

    PikabuMainPage mainPage = new PikabuMainPage();
    PikabuNotificationPage notifPage = new PikabuNotificationPage();
    private String RegistrationFieldTitle = "Создать аккаунт",

    firstNotification = "\n" + "      Приветствуем на Пикабу!\n" + "      ";

    @Test
    @DisplayName("Проверка первого уведомления на сайте")
    void checkFirstNotification() {
        step("Кликаем на главной странице на значёк уведомлений", () -> {
            mainPage.clickNotificationButtton();
        });

        step("Проверяем наличие первого уведомления при входе на сайт", () -> {
            notifPage.checkFirstMessage(firstNotification);
        });
    }

    @Test
    @DisplayName("Проверка появления формы регистрации из первого уведомления на сайте")
    void checkRegistrationFieldAfterClickButtonInNotification() {
        step("Кликаем на главной странице на значёк уведомлений", () -> {
            mainPage.clickNotificationButtton();
        });
        step("Кликаем на гиперссылку 'Зарегистрироваться' в уведомлении и проверяем форму регистрации справа",
                () -> {
                    notifPage.clickToRegistrtrationInNotif()
                            .checkOpenRegistrationField(RegistrationFieldTitle);
                });
    }
}
