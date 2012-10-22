/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.indemnity.ui;

import za.co.cascott.ui.StartPage;

import javax.swing.*;
import java.awt.*;

/**
 * User: steven
 * Date: 8/8/12
 * Time: 10:16 AM
 */
public class Start extends JFrame {
    private final StartPage contentPanel = new StartPage();

    public Start() {
        setSize(new Dimension(400,200));
        add(contentPanel);
        setLocation(null);
    }
}
