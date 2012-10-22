/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.indemnity;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

@Deprecated
public class GlobalProperties {
    private static GlobalProperties instance = null;

    private String buildtime;
    private String major;
    private String minor;
    private String build;
    private String rcver;
    private String version;
    private static String homeDir = System.getProperty("user.home");
    private static PropertiesConfiguration config;
    private static String sessionID;
    private static String specialID;

    protected GlobalProperties() {
    }

    public static boolean firstStartup() {
        File dir = new File(homeDir + "/.indemnify");
        if (dir.isDirectory()) {
            return false;
        } else {

            return true;
        }
    }

    public String getBuildtime() {
        return buildtime;
    }

    public String getMajor() {
        return major;
    }

    public String getMinor() {
        return minor;
    }

    public String getBuild() {
        return build;
    }

    public String getRcver() {
        return rcver;
    }

    public String getVersion() {
        return version;
    }

    public static GlobalProperties getInstance() {
        if (instance == null) {
            Random r = new Random();
            SimpleDateFormat df = new SimpleDateFormat("HmsS");
            Date date = new Date();

            instance = new GlobalProperties();
            instance.readProperties();
            instance.readSettings();
            sessionID = df.format(date) + "-" + r.nextInt(1000);

            if (firstStartup()) {
                specialID = UUID.randomUUID().toString().replaceAll("-", "");
                getSettings().setProperty("sid", specialID);
            } else {
                specialID = getSettings().getString("sid");
            }
        }

        return instance;
    }

    private void readSettings() {
        try {
            config = new PropertiesConfiguration(homeDir + "/.indemnify/main.properties");
            config.setAutoSave(true);
            config.save();
        } catch (ConfigurationException e) {
            File nd = new File(homeDir + "/.indemnify");
            nd.mkdir();
            File n = new File(homeDir + "/.indemnify/main.properties");
            try {
                n.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            readSettings();
            e.printStackTrace();
        }
    }

    public static Configuration getSettings() {
        return config;
    }

    public void readProperties() {
        try {
            InputStream is = GlobalProperties.class.getResourceAsStream("/assets/project.properties");
            Properties p = new Properties();
            p.load(is);
            this.buildtime = p.getProperty("buildtime");
            this.major = p.getProperty("major");
            this.minor = p.getProperty("minor");
            this.build = p.getProperty("build");
            this.rcver = p.getProperty("rcver");
            this.version = major + "." + minor + "." + build;
            is.close();
        } catch (Exception e) {
            System.out.println("Failed to read properties");
        }
    }

    public static String getSpecialID() {
        return specialID;
    }

    public static String getSessionID() {
        return sessionID;
    }
}
