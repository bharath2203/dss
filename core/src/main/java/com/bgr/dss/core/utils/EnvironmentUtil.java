package com.bgr.dss.core.utils;

public class EnvironmentUtil {

    public static String getProperty(String key) {
        return System.getenv(key);
    }
}
