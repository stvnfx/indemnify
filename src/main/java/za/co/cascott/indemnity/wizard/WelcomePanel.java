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
import java.awt.*;

public class WelcomePanel extends JPanel {

    /**
     * Create the panel.
     */
    public WelcomePanel() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(WelcomePanel.class.getResource("/assets/icons/document-text.png")));
        panel.add(label);

        JLabel lblWelcomeToCa = new JLabel("<html>Welcome to <b>CA Scott</b> Indemnity Insurance Application");
        panel.add(lblWelcomeToCa);

        JPanel panel_2 = new JPanel();
        add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new CardLayout(0, 0));

        JTextPane txtpnThisIsSome = new JTextPane();
        txtpnThisIsSome.setText("This is some information about the application and the PF130");
        panel_2.add(txtpnThisIsSome, "name_64429858205127");

    }

}
