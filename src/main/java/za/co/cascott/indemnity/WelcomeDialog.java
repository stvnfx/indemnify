/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.indemnity;

import net.miginfocom.swing.MigLayout;
import za.co.cascott.indemnity.wizard.ImagePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeDialog extends JDialog {

    private final ImagePanel contentPanel = new ImagePanel("/assets/cal1.png");
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtEmail;
    private JCheckBox chckbxIWouldLike;
    private JCheckBox chckbxMonthlyNewsLetter;

    /**
     * Create the dialog.
     */
    public WelcomeDialog() {
        setResizable(false);
        setTitle("Welcome to Indemnify");
        setIconImage(Toolkit.getDefaultToolkit().getImage(WelcomeDialog.class.getResource("/assets/icons/32.png")));
        setModal(true);
        setBounds(100, 100, 472, 420);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
        {
            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setIcon(new ImageIcon(WelcomeDialog.class.getResource("/assets/icons/48.png")));
            contentPanel.add(lblNewLabel, "cell 0 0");
        }
        {
            JLabel lblWelcomeToThe = new JLabel("<html><h2>Indemnify</h2>");
            contentPanel.add(lblWelcomeToThe, "cell 1 0");
        }
        {
            JLabel lblWelcomeToCa = new JLabel("<html>Welcome to CA Scott's Indemnify the<br>\nIndemnity Insurance Application.\n<br><br>\nPlease contribute back by letting us know a little about you (This is optional. You can skip it if you like.)");
            contentPanel.add(lblWelcomeToCa, "cell 1 1");
        }
        {
            JLabel lblFirstName = new JLabel("First Name");
            contentPanel.add(lblFirstName, "cell 0 3,alignx trailing");
        }
        {
            txtFname = new JTextField();
            contentPanel.add(txtFname, "cell 1 3,growx");
            txtFname.setColumns(10);
        }
        {
            JLabel lblLastName = new JLabel("Last Name");
            contentPanel.add(lblLastName, "cell 0 4,alignx trailing");
        }
        {
            txtLname = new JTextField();
            contentPanel.add(txtLname, "cell 1 4,growx");
            txtLname.setColumns(10);
        }
        {
            JLabel lblEmail = new JLabel("Email");
            contentPanel.add(lblEmail, "cell 0 5,alignx trailing");
        }
        {
            txtEmail = new JTextField();
            contentPanel.add(txtEmail, "cell 1 5,growx");
            txtEmail.setColumns(10);
        }
        {
            chckbxIWouldLike = new JCheckBox("<html>Yes, I want to subscribe to the<br> CA Scott newsletter.");
            chckbxIWouldLike.setSelected(true);
            contentPanel.add(chckbxIWouldLike, "cell 1 7");
        }
        {
            chckbxMonthlyNewsLetter = new JCheckBox("<html>I want to be notified of any updates.");
            chckbxMonthlyNewsLetter.setSelected(true);
            contentPanel.add(chckbxMonthlyNewsLetter, "cell 1 8");
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        DataServices.getInstance().firstTimeRun(txtFname.getText(), txtLname.getText(), txtEmail.getText(), chckbxMonthlyNewsLetter.isSelected(), chckbxIWouldLike.isSelected());
                        setVisible(false);
                    }
                });
                okButton.setIcon(new ImageIcon(WelcomeDialog.class.getResource("/assets/icons/tick_bw.png")));
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("No thanks");
                cancelButton.setIcon(new ImageIcon(WelcomeDialog.class.getResource("/assets/icons/cross_bw.png")));
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        setVisible(false);
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }

        setLocationRelativeTo(null); //Center Screen
    }

}
