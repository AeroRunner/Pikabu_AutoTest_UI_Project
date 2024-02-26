package configs;


import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;



@Sources({"classpath:properties/${host}.properties"})
public interface BrowserDriverConfig extends Config {


    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("version")
    @DefaultValue("100")
    String getBtowserVersion();

    @Key("remoteURL")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
    String getRemoteURL();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

}
