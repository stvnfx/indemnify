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

import org.jetlang.fibers.Fiber;
import org.jetlang.fibers.PoolFiberFactory;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: steven
 * Date: 8/17/12
 * Time: 12:32 PM
 */
public class BackgroundTasks {
    private static BackgroundTasks instance = null;

    private Logger logger;
    private PoolFiberFactory factory;
    private HashMap<String, Fiber> tasks;

    protected BackgroundTasks() {
        logger = Logger.getLogger(BackgroundTasks.class.getName());
        logger.log(Level.INFO, "Starting Background Thread Pool with 4 threads");
        ExecutorService service = Executors.newFixedThreadPool(4);
        factory = new PoolFiberFactory(service);
        tasks = new HashMap<String, Fiber>();
    }

    public static BackgroundTasks getInstance() {
        if (instance == null) {
            instance = new BackgroundTasks();
        }
        return instance;
    }

    public void addTask(Runnable task) {
        Fiber fiber = factory.create();
        fiber.start();
        fiber.execute(task);
        logger.log(Level.INFO, "Added background runner");
    }

    public void addScheduledTask(Runnable task, long delay, TimeUnit unit) {
        Fiber fiber = factory.create();
        fiber.start();
        fiber.scheduleAtFixedRate(task, 0, delay, unit);
        logger.log(Level.INFO, "Added scheduled background runner");
    }

    //Task Based.
    public void addTask(Task task) {
        Fiber fiber = factory.create();
        fiber.start();
        fiber.execute(task);
        logger.log(Level.INFO, "Added " + task.getTaskName() + " background task");
        tasks.put(task.getTaskID(), fiber);
    }

    public void addScheduledTask(Task task, long delay, TimeUnit unit) {
        Fiber fiber = factory.create();
        fiber.start();
        fiber.scheduleAtFixedRate(task, 0, delay, unit);
        logger.log(Level.INFO, "Added scheduled " + task.getTaskName() + " background task");
        tasks.put(task.getTaskID(), fiber);
    }

    public void removeTask(String id) {
        logger.log(Level.INFO, "Removing Task.");
        Fiber fiber;
        if(tasks.containsKey(id)) {
            fiber = (Fiber)tasks.get(id);
            fiber.dispose();
        } else {
            logger.log(Level.INFO, "Task Does Not Exist!?");
        }
    }
}
