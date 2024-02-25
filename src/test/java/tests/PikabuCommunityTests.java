package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PikabuCommunityPage;
import pages.PikabuMainPage;


import static io.qameta.allure.Allure.step;
@Tag("AllTestRemote") @Tag("AllTestLocal") @Tag("Community")
@DisplayName("Проверки сайта Pikabu на странице 'Сообщества'")
public class PikabuCommunityTests extends BaseTest {
    PikabuMainPage mainPage = new PikabuMainPage();
    PikabuCommunityPage commPage = new PikabuCommunityPage();
    private String
            registerPopup = "Необходимо войти или зарегистрироваться",
            addTagRuText = "Только с тегом",
            tagQA = "QA";

    @Test
    @DisplayName("Проверяем появление popup-a при попытке подписаться не залогиненым пользователем")
    void checkAuthPopupAfterClickSubscribe() {

        step("Открываем главную страницу и переходим во вкладку 'Сообщества'", () -> {
            mainPage.choiceCommunityPage();
        });
        step("Выбираем сообщество и нажимаем кнопку 'подписаться'", () -> {
            commPage.choiceTargetCommunityPage()
                    .clickSubscribeButton()
                    .checkLoginPopup(registerPopup);
        });
    }

    @Test
    @DisplayName("Проверка поиска сообществ по тегу 'QA'")
    void searchCommunityWithTag() {

        step("Открываем главную страницу и переходим во вкладку 'Сообщества'", () -> {
            mainPage.choiceCommunityPage();
        });
        step("В поле поиска добавляем тег 'QA' и смотрим на полученный результат поиска", () -> {
            commPage.addTag(addTagRuText)
                    .setTag(tagQA)
                    .choiceTag(tagQA)
                    .checkResponse();
        });
    }

    @Test
    @DisplayName("Проверка поиска постов сообществ по тегу из главной страницы")
    void searchOnTagTest() {
        step("Открываем главную страницу и выбираем тег для подбора похожих постов", () -> {
            commPage.choiceTargetTagFun();
        });
        step("Проверяем, что по данному тегу в ленте есть посты", () -> {
            commPage.checkFeed();
        });
    }
}
