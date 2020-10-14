package com.jzh.tank.manage;

import java.io.IOException;
import java.util.Properties;

public class ConfigMgr {
    private static final Properties prop = new Properties();

    private ConfigMgr() {}

    static {
        try {
            prop.load(ConfigMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        return prop.get(key);
    }
}
