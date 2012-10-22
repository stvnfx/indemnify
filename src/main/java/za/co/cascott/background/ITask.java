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
 * User: steven
 * Date: 8/17/12
 * Time: 12:48 PM
 */
public interface ITask {

    public String getTaskName();

    public void setTaskName(String newTaskName);

    public String getTaskID();
}
