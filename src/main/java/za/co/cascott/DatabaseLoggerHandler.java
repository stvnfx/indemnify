/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott;

import java.util.Date;
import java.util.SortedMap;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * User: steven
 * Date: 8/8/12
 * Time: 1:58 PM
 */
public class DatabaseLoggerHandler extends Handler {
    SortedMap<String, String> map;

    @Override
    public void publish(LogRecord record) {
        if (map == null)
            map = Utils.Database.getMap("log");

        Date currentDate = new Date();
        currentDate.toString();

        System.out.println(record.getLoggerName() + "::" + record.getLevel().toString() + "::" + currentDate.toString());
        map.put(record.getLoggerName() + "::" + record.getLevel().toString() + "::" + currentDate.toString(), record.getMessage());
        Utils.Database.save("log");
    }

    @Override
    public void flush() {
        Utils.Database.save("log");
    }

    @Override
    public void close() throws SecurityException {
        Utils.Database.close("log");
    }
}
