package config;

import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/configs/test.properties")
public interface TestConfig extends Config {
    @Key("updateScreenshots")
    @DefaultValue("false")
    boolean isScreenshotsNeedToUpdate();

    @Key("deviceHost")
    String deviceHost();
}
