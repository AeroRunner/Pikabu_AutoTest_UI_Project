package tests;

import data.FakeData;
import data.MainPageData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PikabuMainPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Проверки сайта Pikabu на главной странице")
public class PikabuMainPageTests extends BaseTest {
    PikabuMainPage mainPage = new PikabuMainPage();
    MainPageData mainData = new MainPageData();
    FakeData fake = new FakeData();

    @Test
    @Tag("MainPage")
    @Tag("AllTestRemote")
    @Tag("AllTestLocal")
    @DisplayName("Проверка наличия кнопок в меню сайта")
    void checkButtonsInHeaderMenu() {

        step("Проверяем наличие кнопок  'Лучшее', 'Свежее', 'Блоги', 'Подписки', 'Горячее', 'Сообщества'",
                () -> {
                    mainPage.openPage()
                            .checkButtonsInHeaderMenu(mainData.buttonBest)
                            .checkButtonsInHeaderMenu(mainData.buttonFresh)
                            .checkButtonsInHeaderMenu(mainData.buttonBlogs)
                            .checkButtonsInHeaderMenu(mainData.buttonSubscribe)
                            .checkButtonsInHeaderMenu(mainData.buttonHot)
                            .checkButtonsInHeaderMenu(mainData.buttonComm);
                });
    }

    @Test
    @Tag("AllTestLocal")
    @Tag("MainPageOnlyLocal")
    @DisplayName("Проверка сообщение о неудачной авторизации на сайте")
    void negativeloginLocalTest() {

        step("Проверяем, что после некорректных логина и пароля появится сообщение об ошибке", () -> {
            mainPage.openPage();
            mainPage.tryNegativeLogin(fake.login, fake.password)
                    .checkErrorLoginMessage(mainData.errorMessage);
        });
    }

    @Test
    @Tag("AllTestRemote")
    @Tag("MainPageOnlyRemote")
    @DisplayName("Проверка вылезающей проверки капчей при неудачной авторизации")
    void negativeloginRemoteTest() {

        step("Проверяем, что после некорректных логина и пароля появилась задача с капчей", () -> {
            mainPage.openPage();
            mainPage.tryNegativeLogin(fake.login, fake.password)
                    .checkKapchaTask();
        });
    }
}
