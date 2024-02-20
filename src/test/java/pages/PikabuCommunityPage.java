package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.CommunityData;
import org.checkerframework.checker.units.qual.A;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PikabuCommunityPage {
    CommunityData commData = new CommunityData();
    private SelenideElement
            KakEtoSdelanoGroup = $("[href='/community/kaketosdelano']"),
            SubscribeButton = $(".button-group"),
            AuthPopup = $(".popup__container"),
            AddTagButton = $(".form-group__button"),
            AddTagField = $("[placeholder='введите тег']"),
             TagList = $(".dropdown-item"),
             ResponceList = $(".communities-feed__container"),
             CHoiceTagFun = $("[href='/tag/%D0%AE%D0%BC%D0%BE%D1%80/hot']"),
             StoriesFeed = $(".stories-feed");

    public PikabuCommunityPage choiceTargetCommunityPage() {
        KakEtoSdelanoGroup.click();
        return this;
    }

    public PikabuCommunityPage clickSubscribe() {
        SubscribeButton.$(byText("Подписаться")).click();
        return this;
    }

    public PikabuCommunityPage checkLoginPopup(String text) {
        AuthPopup.shouldHave(text(text));
        return this;
    }
    public PikabuCommunityPage addTag(){
        AddTagButton.$(byText(commData.addTagRuText)).click();
        return this;
    }
    public PikabuCommunityPage setTag (String tag){
        AddTagField.setValue(tag);
        return this;
    }
    public PikabuCommunityPage choiceTag (){
        TagList.$(byText(commData.tagQA)).click();
        return this;
    }
    public PikabuCommunityPage checkResponce(){
        ResponceList.should(exist);
        return this;
    }
    public PikabuCommunityPage choiceTargetTagFun(){
        CHoiceTagFun.click();
        return this;
    }
    public PikabuCommunityPage checkFeed(){
        StoriesFeed.should(exist);
        return this;
    }


}
