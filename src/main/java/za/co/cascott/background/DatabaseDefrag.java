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

import za.co.cascott.Utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: steven
 * Date: 8/20/12
 * Time: 10:40 AM
 */
public class DatabaseDefrag extends Task {

    Logger logger = Logger.getLogger("Database Defrag Background Task");

    @Override
    public void run() {
        logger.log(Level.INFO, "Defraging Database.");
        Utils.Database.defragAll();
    }

    public DatabaseDefrag() {
        super();
    }
}
