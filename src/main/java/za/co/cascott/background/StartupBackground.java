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

import za.co.cascott.API;

/**
 * User: steven
 * Date: 8/20/12
 * Time: 2:59 PM
 */
public class StartupBackground extends Task {
    @Override
    public void run() {
        //Its ok this can fail.
        API.doRequest(API.STARTUP);
        System.out.println("ID: " + getTaskID() + " Task No:" + getTaskName());
    }

    public StartupBackground() {
        super();
    }
}
