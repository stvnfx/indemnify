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
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultPosition extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();
    public boolean cancel = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            DefaultPosition dialog = new DefaultPosition();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DefaultPosition(Dialog owner) {
        super(owner);
    }

    /**
     * Create the dialog.
     */
    public DefaultPosition() {
        setTitle("Default Position");
        setBounds(100, 100, 420, 219);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        {
            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Select an overall default position", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            contentPanel.add(panel);
            panel.setLayout(null);

            JPanel panel_1 = new JPanel();
            panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            panel_1.setBounds(10, 45, 181, 33);
            panel.add(panel_1);

            JRadioButton rdbtnNewRadioButton = new JRadioButton("Minimal");
            buttonGroup.add(rdbtnNewRadioButton);
            panel_1.add(rdbtnNewRadioButton);

            JRadioButton rdbtnPartial = new JRadioButton("Partial");
            buttonGroup.add(rdbtnPartial);
            panel_1.add(rdbtnPartial);

            JRadioButton rdbtnFull = new JRadioButton("Full");
            buttonGroup.add(rdbtnFull);
            panel_1.add(rdbtnFull);

            JLabel lblDegreeOfCompliance = new JLabel("Degree of Compliance");
            lblDegreeOfCompliance.setBounds(10, 26, 181, 14);
            panel.add(lblDegreeOfCompliance);

            JLabel label = new JLabel("Degree of Compliance");
            label.setBounds(201, 26, 181, 14);
            panel.add(label);

            JPanel panel_2 = new JPanel();
            panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            panel_2.setBounds(201, 45, 181, 33);
            panel.add(panel_2);

            JRadioButton radioButton = new JRadioButton("Minimal");
            buttonGroup_1.add(radioButton);
            panel_2.add(radioButton);

            JRadioButton radioButton_1 = new JRadioButton("Partial");
            buttonGroup_1.add(radioButton_1);
            panel_2.add(radioButton_1);

            JRadioButton radioButton_2 = new JRadioButton("Full");
            buttonGroup_1.add(radioButton_2);
            panel_2.add(radioButton_2);

            JLabel lblNewLabel = new JLabel("<html>\r\n<b>The overall default selection can\r\n be fine-tuned on the next form.</b>\r\n</html>\r\n");
            lblNewLabel.setBounds(10, 87, 356, 33);
            panel.add(lblNewLabel);
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
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        //default icon, custom title
                        int n = JOptionPane.showConfirmDialog(
                                null,
                                "This will revert you to the full form. Are you sure?",
                                "Are you sure?",
                                JOptionPane.YES_NO_OPTION);
                        cancel = true;
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
