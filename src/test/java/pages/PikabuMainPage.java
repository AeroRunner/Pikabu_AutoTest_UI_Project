package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import data.FakeData;
import data.MainPageData;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PikabuMainPage {
    MainPageData mainData = new MainPageData();
    public SelenideElement
            headerMenu = $(".header-menu"),
            hotPage = $("[href='/']"),
            bestPage = $("[href=/best']"),
            CommunityButton = $("[href='/communities']"),
            setPassword = $("[name='password']"),
            setUserName = $("[name='username']"),
            loginButton = $(".button_success"),
            errorMessage = $("#signin-form"),
            kapchaModale = $(".grecaptcha-error"),
            AlarmsButton = $("[href='/information/welcome']"),
            JobButton = $("[href='https://vacancies.pikabu.ru/?utm_source=sidebar2_dv']");


    private String baseURL = "https://pikabu.ru/";

    public PikabuMainPage openPage() {
        open(baseURL);
        return this;
    }

    public PikabuMainPage checkButtonsInHeaderMenu(String button) {
        headerMenu.shouldHave(Condition.text(button));
        return this;
    }

    public PikabuMainPage tryNegativeLogin(String fakePass, String fakeLog) {
        setPassword.setValue(fakePass);
        setUserName.setValue(fakeLog);
        loginButton.$(byText(mainData.loginButton)).click();
        return this;
    }

    public PikabuMainPage checkErrorLoginMessage(String negativeMessage) {
        errorMessage.shouldHave(Condition.text(negativeMessage));
        return this;
    }

    public PikabuMainPage checkKapchaTask() {
        kapchaModale.should(Condition.exist);
        return this;
    }

    public PikabuMainPage clickNotificationButtton() {
        AlarmsButton.click();
        return this;
    }

    public PikabuMainPage choiceCommunityPage() {
        CommunityButton.click();
        return this;
    }

    public PikabuMainPage openJobPage() {
        JobButton.click();
        return this;
    }


}
