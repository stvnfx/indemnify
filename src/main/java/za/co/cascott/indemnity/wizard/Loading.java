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
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Loading extends JDialog {
    java.util.Timer timer = null;
    int dots = 0;
    JLabel label;
    long startTime = 0;

    /**
     * Create the dialog.
     */
    public Loading(JFrame p) {
        super(p);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setUndecorated(true);
        setResizable(false);
        setTitle("Loading. Please Wait.");
        setBounds(100, 100, 448, 49);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEADING);
        getContentPane().add(panel);

        this.label = new JLabel();
        label.setIcon(new ImageIcon(Loading.class.getResource("/assets/icons/clock_big.png"))); //Should I animate this clock?

        panel.add(label);
        timer = new java.util.Timer(true);
    }

    @Override
    public void dispose() {
        super.dispose();
        timer.cancel();
    }

    @Override
    public void setVisible(boolean b) {
        if (b == true) {
            startTime = System.currentTimeMillis();
            timer.scheduleAtFixedRate(new java.util.TimerTask() {

                @Override
                public void run() {
                    dotdottick();
                    slowCheck();
                }

            }, 0, 500);
        }
        super.setVisible(b);
    }

    //If a task takes a long time tell the user we are still busy after 15 Seconds.
    public void slowCheck() {
        long estimatedTime = System.currentTimeMillis() - startTime;
        if (estimatedTime > 15000)
            this.label.setText("Still busy, Your System is very slow. " + this.label.getText());
    }

    //Adds a dot or removes a dot.
    public void dotdottick() {
        if (dots > 3) {
            this.label.setText("Please Wait");
            dots = 0;
        } else {
            String newdots = "";
            for (int i = 0; i < dots; i++) {
                newdots = newdots + " .";
            }
            this.label.setText("Please Wait" + newdots);
            dots++;
        }
    }

}
