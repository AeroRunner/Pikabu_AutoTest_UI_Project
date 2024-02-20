package configs;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/${host}.properties"})
public interface BrowserDriverConfig extends Config {


    @Config.Key("browser")
    @Config.DefaultValue("CHROME")
    String getBrowser();

    @Config.Key("browserSize")
    @Config.DefaultValue("1920x1080")
    String getBrowserSize();

    @Config.Key("version")
    @Config.DefaultValue("100")
    String getBtowserVersion();

    @Config.Key("remoteURL")
    @Config.DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
    String getRemoteURL();

    @Config.Key("isRemote")
    @Config.DefaultValue("false")
    Boolean isRemote();

}
