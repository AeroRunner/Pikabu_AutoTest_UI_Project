package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PikabuCommunityPage {

    private SelenideElement
            kakEtoSdelanoGroup = $("[href='/community/kaketosdelano']"),
            subscribeButton = $(".button-group"),
            authPopup = $(".popup__container"),
            addTagButton = $(".form-group__button"),
            addTagField = $("[placeholder='введите тег']"),
            tagList = $(".dropdown-item"),
            responceList = $(".communities-feed__container"),
            choiceTagFun = $("[href='/tag/%D0%AE%D0%BC%D0%BE%D1%80/hot']"),
            storiesFeed = $(".stories-feed");

    public PikabuCommunityPage choiceTargetCommunityPage() {
        kakEtoSdelanoGroup.click();
        return this;
    }

    public PikabuCommunityPage clickSubscribeButton() {
        subscribeButton.$(byText("Подписаться")).click();
        return this;
    }

    public PikabuCommunityPage checkLoginPopup(String text) {
        authPopup.shouldHave(text(text));
        return this;
    }

    public PikabuCommunityPage addTag(String tag) {
        addTagButton.$(byText(tag)).click();
        return this;
    }

    public PikabuCommunityPage setTag(String tag) {
        addTagField.setValue(tag);
        return this;
    }

    public PikabuCommunityPage choiceTag(String tag) {
        tagList.$(byText(tag)).click();
        return this;
    }

    public PikabuCommunityPage checkResponse() {
        responceList.should(exist);
        return this;
    }

    public PikabuCommunityPage choiceTargetTagFun() {
        choiceTagFun.click();
        return this;
    }

    public PikabuCommunityPage checkFeed() {
        storiesFeed.should(exist);
        return this;
    }


}
