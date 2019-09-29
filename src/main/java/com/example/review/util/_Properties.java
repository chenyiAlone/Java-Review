package com.example.review.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * ClassName: _Properties.java
 * Author: chenyiAlone
 * Create Time: 2019/9/17 13:00
 * Description:
 */
public class _Properties {

    private static void loadPropertiesFile() {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry entry : properties.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        loadPropertiesFile();
    }


}
