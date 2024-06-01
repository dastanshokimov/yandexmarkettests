package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {
    public static final EmulatorConfig emulatorConfig = ConfigFactory.create(EmulatorConfig.class);
    public static final TestConfig testConfig = ConfigFactory.create(TestConfig.class);
}
