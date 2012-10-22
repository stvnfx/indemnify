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

import org.xhtmlrenderer.simple.XHTMLPanel;

import javax.swing.*;
import java.awt.*;

/*
 * See ReaderSystem Class
 */
public class Reader extends JDialog {
    private XHTMLPanel panel;
    private JPanel panel_1;

    /**
     * Create the dialog.
     */
    public Reader() {
        setTitle("Reader");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Reader.class.getResource("/assets/icons/document-text 16x16.png")));
        setBounds(100, 100, 744, 531);
        getContentPane().setLayout(new BorderLayout());
        {
            JScrollPane scrollPane = new JScrollPane();
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            {
                panel = new XHTMLPanel();
                panel.setDoubleBuffered(false);
                scrollPane.setViewportView(panel);
            }
        }

        panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblLoadingPleaseWait = new JLabel("Loading...");
        lblLoadingPleaseWait.setIcon(new ImageIcon(Reader.class.getResource("/assets/icons/clock.png")));
        panel_1.add(lblLoadingPleaseWait);
    }

    public XHTMLPanel getReader() {
        return panel;
    }

    public JPanel getLoaderPanel() {
        return panel_1;
    }
}
