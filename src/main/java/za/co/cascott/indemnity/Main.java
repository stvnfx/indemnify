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

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import org.jetlang.channels.Channel;
import org.jetlang.channels.MemoryChannel;
import org.jetlang.core.Callback;
import org.jetlang.fibers.Fiber;
import org.jetlang.fibers.ThreadFiber;
import za.co.cascott.API;
import za.co.cascott.DatabaseLoggerHandler;
import za.co.cascott.Utils;
import za.co.cascott.background.BackgroundTasks;
import za.co.cascott.background.StartupBackground;
import za.co.cascott.background.UpdateChecker;
import za.co.cascott.fop.FOP;
import za.co.cascott.indemnity.wizard.WizardFundDataPanel;
import za.co.cascott.indemnity.wizard.WizardManager;
import za.co.cascott.splashscreen.SplashScreen;
import za.co.cascott.template.engine.MustacheEngine;
import za.co.cascott.ui.LoggerHandler;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    private static SplashScreen splashdialog;
    private static Fiber fiber;
    private static Channel<String> channel;

    private static String cascott =
                    "   ________     ____         __  __  \n" +
                    "  / ___/ _ |   / __/______  / /_/ /_ \n" +
                    " / /__/ __ |  _\\ \\/ __/ _ \\/ __/ __/ \n" +
                    " \\___/_/ |_| /___/\\__/\\___/\\__/\\__/  \n" +
                    "                                     \n" +
                    "=============[Indemnify]==============\n";

    public static void main(String[] args) {
        setupLogger();

        System.out.println(cascott);

        //Before Anything is this java version ok?
        if (isNotCompatibleJava()) return;

        Callback<String> onMsg = new Callback<String>() {
            public void onMessage(String message) {
                if (message == "shutdown") {
                    shutdown();
                }
            }
        };

        //For Startup Timing.
        long startTime = System.currentTimeMillis();

        setLookAndFeel();

        //Splash Screen.
        splashdialog = new SplashScreen();
        splashdialog.setLocationRelativeTo(null);
        splashdialog.setVersion(GlobalProperties.getInstance().getVersion());
        splashdialog.setVisible(true);

        //Start Fiber Object.
        splashdialog.setProgressBarText("Starting Background Objects");
        channel = new MemoryChannel<String>();
        fiber = new ThreadFiber();
        fiber.start();

        //add subscription for message on receiver thread
        channel.subscribe(fiber, onMsg);

        splashdialog.setProgressBarText("Initial startup.");
        if (Utils.Database.getMap("database").get("SpecialID") == null) {
            logger.log(Level.WARNING, "No previous sid.");
            /* API a = new API(); */
            /* a.doRequest(API.REGISTER); */
        }

        splashdialog.setProgressBarValue(10);
        splashdialog.setProgressBarText("Starting Background Objects.");
        //Start all background object stuff
        startBackgroundObjects();
        splashdialog.setProgressBarValue(20);

        //Wizard Manager starts here.
        splashdialog.setProgressBarText("Starting Wizard.");
        final WizardManager wmng = new WizardManager();
        splashdialog.setProgressBarValue(50);

        //If this is the first startup.
        firstStartup(splashdialog);

        logger.log(Level.INFO, "Version: " + GlobalProperties.getInstance().getVersion());
        logger.log(Level.INFO, "App data loation: " + System.getProperty("user.home"));

        if (Utils.Database.getMap("database").get("SpecialID") == null) {
            firstStartup();
        }

        logger.log(Level.INFO, "S(peacil)ID: " + Utils.Database.getMap("database").get("SpecialID"));
        logger.log(Level.INFO, "S(ession)ID: " + GlobalProperties.getSessionID());
        splashdialog.setProgressBarValue(80);

        splashdialog.setProgressBarText("Registering First Wizard Pane.");
        wmng.registerFirstWizardDescriptor(new WizardFundDataPanel());
        splashdialog.setProgressBarValue(100);
        logger.log(Level.INFO, "Startup Time: " + ((System.currentTimeMillis() - startTime) / 1000.0) + " seconds.");

        String runtimesStr = Utils.Database.getMap("database").get("Run Times");
        if (runtimesStr != null) {
            int runtimes = Integer.parseInt(runtimesStr);
            runtimes++;
            Utils.Database.getMap("database").put("Run Times", new Integer(runtimes).toString());
            Utils.Database.save("database");
            logger.log(Level.INFO, "Run Times: " + runtimes);
        }

        splashdialog.hideSplashScreen();
        try {
            Utils.Database.getMap("database").put("Last SessionID", GlobalProperties.getSessionID());
            Utils.Database.save("database");
            wmng.startWizard();
        } catch (za.co.cascott.indemnity.wizard.NoDescriptorSetException e) {
            logger.log(Level.SEVERE, "No Descriptor Set, Cannot Continue.");
            e.printStackTrace();
            channel.publish("shutdown");
        }

    }

    public static void shutdown() {
        logger.log(Level.INFO, "Going Down. Bye.");
        Utils.Database.close("database");
        fiber.dispose();
        System.exit(0);
    }

    private static void startBackgroundObjects() {
        BackgroundTasks tasks = BackgroundTasks.getInstance();
        //Initialize Background Objects
        StartupBackground st = new StartupBackground();
        st.setTaskName("Startup Caller");
        tasks.addTask(st);
    }

    private static void setupLogger() {
        //Set Global Logger
        Logger.getLogger("").addHandler(new LoggerHandler());
        Logger.getLogger("").addHandler(new DatabaseLoggerHandler());
        Logger.getLogger("").setLevel(Level.INFO);
    }

    private static boolean isNotCompatibleJava() {
        String javaVersion = System.getProperty("java.version");
        if (javaVersion.compareTo("1.6") < 0) {
            logger.log(Level.SEVERE, "Indemnify " + GlobalProperties.getInstance().getVersion() +
                    "Indemnfiy, requires Java version 1.6 or greater. Quiting.");

            JOptionPane.showMessageDialog(null, "Indemnfiy, requires Java version 1.6 or greater.");
            return true;
        }
        return false;
    }

    private static void setLookAndFeel() {
        logger.log(Level.FINE, "Changing Look and Feel.");
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    logger.log(Level.INFO, "Windows L&F set.");
                    break;
                } else if ("GTK+".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    logger.log(Level.INFO, "GTK+ L&F set.");
                    break;
                } else {
                    logger.log(Level.FINE, "Not changing L&F.");
                }
            }
        } catch (UnsupportedLookAndFeelException e2) {
        } catch (ClassNotFoundException e2) {
        } catch (InstantiationException e2) {
        } catch (IllegalAccessException e2) {
        }
    }

    private static void firstStartup(SplashScreen splashdialog) {
        if (GlobalProperties.getInstance().firstStartup()) {
            splashdialog.setProgressBarText("Done.");
            splashdialog.setIndeterminate(false);
            splashdialog.setProgressBarValue(100);
            WelcomeDialog dialog = new WelcomeDialog();
            dialog.setVisible(true);
        }
    }

    private static void firstStartup() {
        logger.log(Level.FINEST, "First Startup");
        Utils.Database.getMap("database").put("SpecialID", UUID.randomUUID().toString().replaceAll("-", ""));
        Utils.Database.getMap("database").put("First SessionID", GlobalProperties.getSessionID());
        Utils.Database.getMap("database").put("Firs Run", new Date().toString());
        Utils.Database.getMap("database").put("Run Times", "0");
        Utils.Database.save("database");
    }

    public static Channel getChannel() {
        return channel;
    }

}
