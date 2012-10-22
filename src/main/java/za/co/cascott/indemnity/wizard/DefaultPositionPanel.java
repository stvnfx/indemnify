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
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultPositionPanel extends JPanel {
    private JPanel panel_1;
    public JRadioButton dcPar;
    public JRadioButton dcMin;
    public JRadioButton dcFull;
    public JRadioButton rdbtnMedium;
    public JRadioButton rdbtnHeavy;
    public JRadioButton rdbtnLight;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();

    public String dc;
    public String rw;

    /**
     * Create the panel.
     */
    public DefaultPositionPanel() {
        setLayout(null);

        JLabel label = new JLabel("<html>\r\n<b>The overall default selection can\r\n be fine-tuned on the next form.</b>\r\n</html>\r\n");
        label.setBounds(12, 73, 356, 33);
        add(label);

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(256, 31, 245, 33);
        add(panel);

        rdbtnLight = new JRadioButton("Light");
        rdbtnLight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                rw = "light";
            }
        });
        buttonGroup_1.add(rdbtnLight);
        panel.add(rdbtnLight);

        rdbtnMedium = new JRadioButton("Medium");
        rdbtnMedium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                rw = "medium";
            }
        });
        buttonGroup_1.add(rdbtnMedium);
        rdbtnMedium.setSelected(true);
        panel.add(rdbtnMedium);

        rdbtnHeavy = new JRadioButton("Heavy");
        rdbtnHeavy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                rw = "heavy";
            }
        });
        buttonGroup_1.add(rdbtnHeavy);
        panel.add(rdbtnHeavy);

        panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_1.setBounds(12, 31, 232, 33);
        add(panel_1);

        dcMin = new JRadioButton("Minimal");
        dcMin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dc = "minimal";
            }
        });
        buttonGroup.add(dcMin);
        panel_1.add(dcMin);

        dcPar = new JRadioButton("Partial");
        dcPar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dc = "partial";
            }
        });
        buttonGroup.add(dcPar);
        dcPar.setSelected(true);
        panel_1.add(dcPar);

        dcFull = new JRadioButton("Full");
        dcFull.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dc = "full";
            }
        });
        buttonGroup.add(dcFull);
        panel_1.add(dcFull);

        JLabel label_1 = new JLabel("Degree of Compliance");
        label_1.setBounds(12, 12, 181, 14);
        add(label_1);

        JLabel lblRiskWeighting = new JLabel("Risk Weighting");
        lblRiskWeighting.setBounds(256, 12, 181, 14);
        add(lblRiskWeighting);

    }

    public JPanel getPanel_1() {
        return panel_1;
    }

    public JRadioButton getDcPar() {
        return dcPar;
    }

    public JRadioButton getDcMin() {
        return dcMin;
    }

    public JRadioButton getDcFull() {
        return dcFull;
    }

    public JRadioButton getRdbtnMedium() {
        return rdbtnMedium;
    }

    public JRadioButton getRdbtnHeavy() {
        return rdbtnHeavy;
    }

    public JRadioButton getRdbtnLight() {
        return rdbtnLight;
    }
}
