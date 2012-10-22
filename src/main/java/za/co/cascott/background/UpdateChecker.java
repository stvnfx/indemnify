/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.background;

/**
 * This task should be run on startup and run every 15 min.
 * User: steven
 * Date: 8/14/12
 * Time: 2:53 PM
 */
public class UpdateChecker extends Task {

    @Override
    public void run() {
        //Check for updates.
//        if (updateAvaliable()) {
//            getLogger().log(Level.INFO, "");
//        } else {
//            getLogger().log(Level.INFO, "No Updates available.");
//        }
        System.out.println("ID: " + getTaskID() + " Task No:" + getTaskName());
//        API a = new API();
//        a.doRequest(API.REGISTER);

    }

    public UpdateChecker() {
        super();
    }
}
