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
 * See HelpSystem class
 */
@Deprecated
public class HelpWindow extends JDialog {
    private XHTMLPanel panel;

    public XHTMLPanel getPanel() {
        return panel;
    }

    private JButton closeButton;
    private JButton btnContact;
    private JProgressBar progressBar;
    private JLabel lblTitle;

    /**
     * Create the dialog.
     */
    public HelpWindow() {
        setTitle("Help");
        setIconImage(Toolkit.getDefaultToolkit().getImage(HelpWindow.class.getResource("/assets/icons/lifebuoy.png")));
        setBounds(100, 100, 375, 490);
        getContentPane().setLayout(new BorderLayout());

        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.NORTH);

        lblTitle = new JLabel("Loading...");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel_1.add(lblTitle);
        panel = new XHTMLPanel();
        panel.setPreferredSize(new Dimension(375, 500));
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(375, 500));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);

            progressBar = new JProgressBar();
            progressBar.setIndeterminate(true);
            buttonPane.add(progressBar);

            btnContact = new JButton("Contact");
            btnContact.setVisible(false);
            btnContact.setEnabled(false);
            btnContact.setIcon(new ImageIcon(HelpWindow.class.getResource("/assets/icons/address-book.png")));
            buttonPane.add(btnContact);
            {
                closeButton = new JButton("Close");
                closeButton.setIcon(new ImageIcon(HelpWindow.class.getResource("/assets/icons/cross.png")));
                closeButton.setActionCommand("Cancel");
                buttonPane.add(closeButton);
            }
        }
    }

    public XHTMLPanel getHelpPanel() {
        return panel;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public JButton getBtnContact() {
        return btnContact;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }
}
