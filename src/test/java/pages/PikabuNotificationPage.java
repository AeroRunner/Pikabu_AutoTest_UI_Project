package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PikabuNotificationPage {
    private SelenideElement notificationBox = $(".page-notifications__container"),
    RegistrationButton = $("[href='#signup']"),
    RegistrationTitle = $(".sidebar-auth");
    public PikabuNotificationPage checkFirstMessage(String notificatiton){
     notificationBox.shouldHave(Condition.text(notificatiton));
        return this;
    }
    public PikabuNotificationPage clickToRegistrtrationInNotif(){
        RegistrationButton.click();
        return this;
    }
    public PikabuNotificationPage checkOpenRegistrationField(String title){
        RegistrationTitle.shouldHave(Condition.text(title));
        return this;
    }
}
