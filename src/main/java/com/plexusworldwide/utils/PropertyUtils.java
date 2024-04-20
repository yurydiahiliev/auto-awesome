package com.plexusworldwide.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class PropertyUtils {

    private static Properties properties = new Properties();
    private static final Logger log = LoggerFactory.getLogger(PropertyUtils.class);

    private static String configFilePathName = "project.properties";

    static {
        try {
            InputStream configFileReader = PropertyUtils.class.getClassLoader().getResourceAsStream(configFilePathName);
            if (configFileReader == null) {
                throw new RuntimeException("Properties file not found!");
            }
            properties.load(configFileReader);
            configFileReader.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public static String getBaseUrl() {
        String baseUrl = properties.getProperty("base_url");
        if (baseUrl != null) {
            return baseUrl;
        } else {
            throw new RuntimeException("Property 'base_url' is not found in property file");
        }
    }

    public static int getBrowserTimeout() {
        String browserTimeout = properties.getProperty("browser_timeout");
        if (browserTimeout != null) {
            return parseInt(browserTimeout);
        } else {
            throw new RuntimeException("Property 'browser_timeout' is not found in property file");
        }
    }

    public static int getExplicitWaitTimeout() {
        String browserTimeout = properties.getProperty("explicit_wait_timeout");
        if (browserTimeout != null) {
            return parseInt(browserTimeout);
        } else {
            throw new RuntimeException("Property 'explicit_wait_timeout' is not found in property file");
        }
    }
}