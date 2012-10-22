/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.ui;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * User: steven
 * Date: 8/8/12
 * Time: 11:44 AM
 */
public class LoggerHandler extends Handler {


    @Override
    public void publish(LogRecord record) {
        Logger.getInstance().add(record.getLevel(), record.getMessage());
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }
}
