package com.utils.common;


import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

public class ConfigurationUtils {


    public static void main(String[] args) {
        try {
            PropertiesConfiguration configuration  = new PropertiesConfiguration("config.properties");
            configuration.setReloadingStrategy(new FileChangedReloadingStrategy());

            while (true) {
                Thread.sleep(2000);
                System.out.println(configuration.getString("duyot"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
