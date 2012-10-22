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

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RegisterDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            RegisterDialog dialog = new RegisterDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public RegisterDialog() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][]"));
        {
            JLabel lblNewLabel = new JLabel("New label");
            contentPanel.add(lblNewLabel, "cell 0 0");
        }
        {
            JLabel lblNewLabel_1 = new JLabel("New label");
            contentPanel.add(lblNewLabel_1, "cell 1 0");
        }
        {
            JLabel lblUsername = new JLabel("Username");
            contentPanel.add(lblUsername, "cell 0 2,alignx trailing");
        }
        {
            textField = new JTextField();
            contentPanel.add(textField, "cell 1 2,growx");
            textField.setColumns(10);
        }
        {
            JLabel lblKey = new JLabel("Key");
            contentPanel.add(lblKey, "cell 0 3,alignx trailing");
        }
        {
            textField_1 = new JTextField();
            contentPanel.add(textField_1, "cell 1 3,growx");
            textField_1.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}
