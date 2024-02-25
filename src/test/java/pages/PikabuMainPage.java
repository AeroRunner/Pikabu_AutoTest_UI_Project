package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PikabuMainPage {

    public SelenideElement
            headerMenu = $(".header-menu"),
            communityButton = $("[href='/communities']"),
            setPassword = $("[name='password']"),
            setUserName = $("[name='username']"),
            loginButton = $(".button_success"),
            errorMessage = $("#signin-form"),
            kapchaModale = $(".grecaptcha-error"),
            alarmsButton = $("[href='/information/welcome']");
    private String loginButtonText = "Войти";


    public PikabuMainPage checkButtonsInHeaderMenu(String button) {
        headerMenu.shouldHave(Condition.text(button));
        return this;
    }

    public PikabuMainPage tryNegativeLogin(String fakePass, String fakeLog) {
        setPassword.setValue(fakePass);
        setUserName.setValue(fakeLog);
        loginButton.$(byText(loginButtonText)).click();
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
        alarmsButton.click();
        return this;
    }

    public PikabuMainPage choiceCommunityPage() {
        communityButton.click();
        return this;
    }

}
