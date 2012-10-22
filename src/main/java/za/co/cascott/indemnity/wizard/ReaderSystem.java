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
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * This class is set for removal. Dont use it anymore.
 */
public class ReaderSystem {
    private static ReaderSystem readerSystemObject = null;
    private static Reader rw = null;
    private JButton btn = null;
    private String oldinjarname;

    public static ReaderSystem getReaderSystemObject() {
        if (readerSystemObject == null || rw == null) {
            rw = new Reader();
            rw.getReader().setBackground(Color.WHITE);
            readerSystemObject = new ReaderSystem();
            rw.getLoaderPanel().setVisible(false);
        }
        return readerSystemObject;
    }

    //Call to set new xhtml data but uses a file from jar.
    public void setInternalPage(String injarname) {
        if (oldinjarname != injarname) {
            oldinjarname = injarname;
            InputStream injario = this.getClass().getResourceAsStream(injarname);
            try {
                rw.getLoaderPanel().setVisible(true);
                @SuppressWarnings("deprecation")
                final URL ref = new File(TempSystem.getInstance().getInternalFile(injarname, "xhtml")).toURL(); //Deprecated? Looks like since Java 6.
                //For thread.
                SwingWorker worker = new SwingWorker() {
                    @Override
                    public Void doInBackground() {
                        rw.getReader().setDocument(ref.toExternalForm());
                        return null;
                    }

                    @Override
                    public void done() {
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                rw.getLoaderPanel().setVisible(false);
                            }
                        });
                    }
                };
                worker.execute();
            } catch (MalformedURLException e) {
            } catch (java.lang.NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Error. Could not load internal xhtml object.");
                e.printStackTrace();
            }
        }
    }

    //Call to set new xhtml data.
    public void setPage(String fileuri) throws MalformedURLException {
        final URL ref = new File(fileuri).toURL();
        rw.getReader().setDocument(ref.toExternalForm());
    }

    //Shows the main help window.
    public void showWindow() {
//		SwingWorker worker = new SwingWorker() {
//
//			public String doInBackground() throws Exception {
//				Thread.sleep(5000);
//				return null;
//			}
//
//			public void done() {
//				SwingUtilities.invokeLater(new Runnable() {
//					public void run() {
//						rw.setVisible(false);
//						rw.dispose();
//					}
//				});
//			}
//
//		};
//		worker.execute();
        if (!rw.isVisible())
            rw.setVisible(true);
    }

}
