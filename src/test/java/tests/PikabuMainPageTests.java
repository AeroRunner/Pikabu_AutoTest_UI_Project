package tests;

import data.FakeData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.PikabuMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Проверки сайта Pikabu на главной странице")
public class PikabuMainPageTests extends BaseTest {
    PikabuMainPage mainPage = new PikabuMainPage();

    FakeData fake = new FakeData();
    public String buttonBest = "Лучшее",
            buttonHot = "Горячее",
            buttonFresh = "Свежее",
            buttonSubscribe = "Подписки",
            buttonComm = "Сообщества",
            buttonBlogs = "Блоги",
            errorMessage = "Ошибка. Вы ввели неверные данные авторизации";

    @Test
    @Tags({@Tag("MainPage"), @Tag("AllTestRemote"), @Tag("AllTestLocal")})
    @DisplayName("Проверка наличия кнопок в меню сайта")
    void checkButtonsInHeaderMenu() {

        step("Проверяем наличие кнопок  'Лучшее', 'Свежее', 'Блоги', 'Подписки', 'Горячее', 'Сообщества'",
                () -> {
                    mainPage
                            .checkButtonsInHeaderMenu(buttonBest)
                            .checkButtonsInHeaderMenu(buttonFresh)
                            .checkButtonsInHeaderMenu(buttonBlogs)
                            .checkButtonsInHeaderMenu(buttonSubscribe)
                            .checkButtonsInHeaderMenu(buttonHot)
                            .checkButtonsInHeaderMenu(buttonComm);
                });
    }

    @Test
    @Tags({@Tag("AllTestLocal"), @Tag("MainPageOnlyLocal")})
    @DisplayName("Проверка сообщение о неудачной авторизации на сайте")
    void negativeloginLocalTest() {

        step("Проверяем, что после некорректных логина и пароля появится сообщение об ошибке", () -> {

            mainPage.tryNegativeLogin(fake.login, fake.password)
                    .checkErrorLoginMessage(errorMessage);
        });
    }

    @Test
    @Tags({@Tag("AllTestRemote"), @Tag("MainPageOnlyRemote")})
    @DisplayName("Проверка вылезающей проверки капчей при неудачной авторизации")
    void negativeloginRemoteTest() {

        step("Проверяем, что после некорректных логина и пароля появилась задача с капчей", () -> {
            mainPage.tryNegativeLogin(fake.login, fake.password)
                    .checkKapchaTask();
        });
    }
}
