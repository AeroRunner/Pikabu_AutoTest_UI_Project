package tests;

import data.CommunityData;
import data.RegisterPopupData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PikabuCommunityPage;
import pages.PikabuMainPage;

import static io.qameta.allure.Allure.step;
@DisplayName("Проверки сайта Pikabu на странице 'Сообщества'")
public class PikabuCommunityTests extends BaseTest {
    PikabuMainPage mainPage = new PikabuMainPage();
    PikabuCommunityPage commPage = new PikabuCommunityPage();
    RegisterPopupData popupData = new RegisterPopupData();
    CommunityData commData = new CommunityData();


    @Test
    @Tag("AllTestRemote")
    @Tag("AllTestLocal")
    @Tag("Community")
    @DisplayName("Проверяем появление popup-a при попытке подписаться не залогиненым пользователем")
    void checkAuthPopupAfterClickSubscribe() {

        step("Открываем главную страницу и переходим во вкладку 'Сообщества'", () -> {
            mainPage.openPage()
                    .choiceCommunityPage();
        });
        step("Выбираем сообщество и нажимаем кнопку 'подписаться'", () -> {
            commPage.choiceTargetCommunityPage()
                    .clickSubscribe()
                    .checkLoginPopup(popupData.registerPopup);
        });
    }

    @Test
    @Tag("AllTestRemote")
    @Tag("AllTestLocal")
    @Tag("Community")
    @DisplayName("Проверка поиска сообществ по тегу 'QA'")
    void searchCommunityWithTag() {

        step("Открываем главную страницу и переходим во вкладку 'Сообщества'", () -> {
            mainPage.openPage()
                    .choiceCommunityPage();
        });
        step("В поле поиска добавляем тег 'QA' и смотрим на полученный результат поиска", () -> {
            commPage.addTag()
                    .setTag(commData.tagQA)
                    .choiceTag()
                    .checkResponce();
        });
    }
    @Test
    @Tag("AllTestRemote")
    @Tag("AllTestLocal")
    @Tag("Community")
    @DisplayName("Проверка поиска постов сообществ по тегу из главной страницы")
    void searchOnTagTest(){
        step("Открываем главную страницу и выбираем тег для подбора похожих постов", () -> {
            mainPage.openPage();
        });
        step("Проверяем, что по данному тегу в ленте есть посты", () -> {
            commPage.choiceTargetTagFun()
                    .checkFeed();
        });
    }
}
