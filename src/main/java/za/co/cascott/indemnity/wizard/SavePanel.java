/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.indemnity.wizard;

import javax.swing.*;

public class SavePanel extends JPanel {

    /**
     * Create the panel.
     */
    public SavePanel() {
        setLayout(null);

        JButton btnNewButton = new JButton("Save Report");
        btnNewButton.setBounds(10, 11, 104, 23);
        add(btnNewButton);

        JButton btnSaveLoading = new JButton("Save Loading");
        btnSaveLoading.setBounds(124, 11, 104, 23);
        add(btnSaveLoading);

    }
}
