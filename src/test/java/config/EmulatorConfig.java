package config;

import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/configs/emulator.properties")
public interface EmulatorConfig extends Config {
    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("automationName")
    String automationName();

    @Key("app")
    String app();

    @Key("remoteUrl")
    String remoteUrl();
}
