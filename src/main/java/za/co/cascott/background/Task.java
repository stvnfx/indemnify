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

import java.util.UUID;

/**
 * User: steven
 * Date: 8/17/12
 * Time: 1:30 PM
 */
public class Task implements Runnable, ITask {

    private String id;
    private String name;

    @Override
    public String getTaskName() {
        if (name == null)
            name = getTaskID();
        return name;
    }

    @Override
    public void setTaskName(String newTaskName) {
        name = newTaskName;
    }

    @Override
    public String getTaskID() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }

    @Override
    public void run() {
    }

}
