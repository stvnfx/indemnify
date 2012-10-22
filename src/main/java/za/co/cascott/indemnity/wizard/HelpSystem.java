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

import za.co.cascott.indemnity.TempSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * This class is set for removal! Don't use it anymore.
 */
@Deprecated
public class HelpSystem {
    private static HelpSystem helpSystemObject = null;
    private static HelpWindow hw = null;

    public HelpSystem() {
    }

    public static HelpSystem getHelpSystemObject() {
        if (helpSystemObject == null || hw == null) {
            hw = new HelpWindow();
            hw.getHelpPanel().setBackground(Color.WHITE);
            hw.getProgressBar().setVisible(false);
            helpSystemObject = new HelpSystem();
            hw.getCloseButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hw.setVisible(false);
                }
            });
            hw.getBtnContact().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    helpSystemObject.setInternalPage("/assets/about.html");
                }
            });
        }
        return helpSystemObject;
    }

    //Call to set new xhtml data but uses a file from jar.
    public void setInternalPage(String injarname) {
        InputStream injario = this.getClass().getResourceAsStream(injarname);
        try {
            @SuppressWarnings("deprecation")
            final URL ref = new File(TempSystem.getInstance().getInternalFile(injarname, "xhtml")).toURL(); //Deprecated? Looks like since Java 6
            //For thread.
            SwingWorker worker = new SwingWorker() {
                @Override
                public Void doInBackground() {
                    hw.getHelpPanel().setDocument(ref.toExternalForm());
                    return null;
                }

                @Override
                public void done() {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            hw.getProgressBar().setVisible(false);
                            hw.getLblTitle().setText(hw.getHelpPanel().getDocumentTitle());
                        }
                    });
                }
            };
            worker.execute();
            hw.getProgressBar().setVisible(true);
            hw.getLblTitle().setText("Loading...");
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Error. Could not load internal xhtml object.");
            e.printStackTrace();
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error. Could not load internal xhtml object.");
            e.printStackTrace();
        }
    }

    //Call to set new xhtml data.
    public void setPage(String fileuri) throws MalformedURLException {
        final URL ref = new File(fileuri).toURL();
        hw.getHelpPanel().setDocument(ref.toExternalForm());
    }

    //Shows the main help window.
    public void showWindow() {
        hw.setVisible(true);
    }

}
