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

import za.co.cascott.indemnity.pdfreader.PDFReader;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShortRiskLoadingPanel extends JPanel {
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();
    private final ButtonGroup buttonGroup_2 = new ButtonGroup();
    private final ButtonGroup buttonGroup_3 = new ButtonGroup();
    private final ButtonGroup buttonGroup_4 = new ButtonGroup();
    private final ButtonGroup buttonGroup_5 = new ButtonGroup();
    private final ButtonGroup buttonGroup_6 = new ButtonGroup();
    private final ButtonGroup buttonGroup_7 = new ButtonGroup();
    private final ButtonGroup buttonGroup_8 = new ButtonGroup();
    private final ButtonGroup buttonGroup_9 = new ButtonGroup();
    private final ButtonGroup buttonGroup_10 = new ButtonGroup();
    private final ButtonGroup buttonGroup_11 = new ButtonGroup();
    private final ButtonGroup buttonGroup_12 = new ButtonGroup();
    private final ButtonGroup buttonGroup_13 = new ButtonGroup();
    private final ButtonGroup buttonGroup_14 = new ButtonGroup();
    private final ButtonGroup buttonGroup_15 = new ButtonGroup();
    private final ButtonGroup buttonGroup_16 = new ButtonGroup();
    private final ButtonGroup buttonGroup_17 = new ButtonGroup();
    private JRadioButton rdbtnMinimal;
    private JRadioButton rdbtnHeavy;
    private JRadioButton rdbtnPartial;
    private JRadioButton rdbtnHeavy_2;
    private JRadioButton rdbtnPartial_3;
    private JRadioButton rdbtnMedium;
    private JRadioButton rdbtnHeavy_4;
    private JRadioButton rdbtnHeavy_3;
    private JRadioButton rdbtnPartial_2;
    private JRadioButton rdbtnFull;
    private JRadioButton rdbtnLight;
    private JRadioButton rdbtnMedium_3;
    private JRadioButton rdbtnHeavy_6;
    private JRadioButton rdbtnHeavy_1;
    private JRadioButton rdbtnFull_2;
    private JRadioButton rdbtnPartial_5;
    private JRadioButton rdbtnFull_1;
    private JRadioButton rdbtnMinimal_3;
    private JRadioButton rdbtnMedium_5;
    private JRadioButton rdbtnFull_6;
    private JRadioButton rdbtnFull_4;
    private JRadioButton rdbtnPartial_6;
    private JRadioButton rdbtnPartial_7;
    private JRadioButton rdbtnHeavy_5;
    private JRadioButton rdbtnMinimal_5;
    private JRadioButton rdbtnLight_7;
    private JRadioButton rdbtnMedium_2;
    private JRadioButton rdbtnPartial_4;
    private JRadioButton rdbtnLight_1;
    private JRadioButton rdbtnMinimal_7;
    private JRadioButton rdbtnLight_6;
    private JRadioButton rdbtnMedium_6;
    private JRadioButton rdbtnLight_2;
    private JRadioButton rdbtnFull_7;
    private JRadioButton rdbtnMedium_7;
    private JRadioButton rdbtnMinimal_1;
    private JRadioButton rdbtnLight_5;
    private JRadioButton rdbtnMinimal_6;
    private JRadioButton rdbtnPartial_8;
    private JRadioButton rdbtnMedium_1;
    private JRadioButton rdbtnFull_3;
    private JRadioButton rdbtnMinimal_8;
    private JRadioButton rdbtnMedium_8;
    private JRadioButton rdbtnMedium_4;
    private JRadioButton rdbtnPartial_1;
    private JRadioButton rdbtnMinimal_2;
    private JRadioButton rdbtnLight_4;
    private JRadioButton rdbtnFull_8;
    private JRadioButton rdbtnHeavy_7;
    private JRadioButton rdbtnFull_5;
    private JRadioButton rdbtnMinimal_4;
    private JRadioButton rdbtnLight_3;
    private JRadioButton rdbtnHeavy_8;
    private JRadioButton rdbtnLight_8;
    private JLabel label_7;
    private JLabel label_8;
    private JLabel label_9;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_10;
    private JTextField textField;
    private JLabel lblCalculatedLoadingTo;
    private JButton button;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
    private JButton button_8;

    /**
     * Create the panel.
     */
    public ShortRiskLoadingPanel() {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(0, 0, 724, 185);
        add(panel);
        panel.setLayout(null);

        JLabel lblGovernanceStructureDuties = new JLabel("Governance Structure, Duties & Obligations");
        lblGovernanceStructureDuties.setBounds(10, 30, 221, 33);
        panel.add(lblGovernanceStructureDuties);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_1.setBounds(280, 30, 192, 33);
        panel.add(panel_1);

        rdbtnMinimal_1 = new JRadioButton("Minimal");
        buttonGroup.add(rdbtnMinimal_1);
        panel_1.add(rdbtnMinimal_1);

        rdbtnPartial_1 = new JRadioButton("Partial");
        buttonGroup.add(rdbtnPartial_1);
        panel_1.add(rdbtnPartial_1);

        rdbtnFull_1 = new JRadioButton("Full");
        buttonGroup.add(rdbtnFull_1);
        panel_1.add(rdbtnFull_1);

        JLabel lblDegreeOfCompliance = new JLabel("Degree of Compliance");
        lblDegreeOfCompliance.setBounds(280, 11, 192, 14);
        panel.add(lblDegreeOfCompliance);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_2.setBounds(482, 30, 192, 33);
        panel.add(panel_2);

        rdbtnLight_1 = new JRadioButton("Light");
        buttonGroup_9.add(rdbtnLight_1);
        panel_2.add(rdbtnLight_1);

        rdbtnMedium_1 = new JRadioButton("Medium");
        buttonGroup_9.add(rdbtnMedium_1);
        panel_2.add(rdbtnMedium_1);

        rdbtnHeavy_1 = new JRadioButton("Heavy");
        buttonGroup_9.add(rdbtnHeavy_1);
        panel_2.add(rdbtnHeavy_1);

        JLabel lblRiskWeighting = new JLabel("Risk Weighting");
        lblRiskWeighting.setBounds(482, 11, 192, 14);
        panel.add(lblRiskWeighting);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_3.setBounds(482, 67, 192, 33);
        panel.add(panel_3);

        rdbtnLight_2 = new JRadioButton("Light");
        buttonGroup_10.add(rdbtnLight_2);
        panel_3.add(rdbtnLight_2);

        rdbtnMedium_2 = new JRadioButton("Medium");
        buttonGroup_10.add(rdbtnMedium_2);
        panel_3.add(rdbtnMedium_2);

        rdbtnHeavy = new JRadioButton("Heavy");
        buttonGroup_10.add(rdbtnHeavy);
        panel_3.add(rdbtnHeavy);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_4.setBounds(280, 67, 192, 33);
        panel.add(panel_4);

        rdbtnMinimal_2 = new JRadioButton("Minimal");
        buttonGroup_1.add(rdbtnMinimal_2);
        panel_4.add(rdbtnMinimal_2);

        rdbtnPartial_2 = new JRadioButton("Partial");
        buttonGroup_1.add(rdbtnPartial_2);
        panel_4.add(rdbtnPartial_2);

        rdbtnFull = new JRadioButton("Full");
        buttonGroup_1.add(rdbtnFull);
        panel_4.add(rdbtnFull);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_5.setBounds(482, 104, 192, 33);
        panel.add(panel_5);

        rdbtnLight_3 = new JRadioButton("Light");
        buttonGroup_11.add(rdbtnLight_3);
        panel_5.add(rdbtnLight_3);

        rdbtnMedium = new JRadioButton("Medium");
        buttonGroup_11.add(rdbtnMedium);
        panel_5.add(rdbtnMedium);

        rdbtnHeavy_3 = new JRadioButton("Heavy");
        buttonGroup_11.add(rdbtnHeavy_3);
        panel_5.add(rdbtnHeavy_3);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_6.setBounds(280, 104, 192, 33);
        panel.add(panel_6);

        rdbtnMinimal_3 = new JRadioButton("Minimal");
        buttonGroup_2.add(rdbtnMinimal_3);
        panel_6.add(rdbtnMinimal_3);

        rdbtnPartial_3 = new JRadioButton("Partial");
        buttonGroup_2.add(rdbtnPartial_3);
        panel_6.add(rdbtnPartial_3);

        rdbtnFull_3 = new JRadioButton("Full");
        buttonGroup_2.add(rdbtnFull_3);
        panel_6.add(rdbtnFull_3);

        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_7.setBounds(482, 141, 192, 33);
        panel.add(panel_7);

        rdbtnLight_4 = new JRadioButton("Light");
        buttonGroup_12.add(rdbtnLight_4);
        panel_7.add(rdbtnLight_4);

        rdbtnMedium_4 = new JRadioButton("Medium");
        buttonGroup_12.add(rdbtnMedium_4);
        panel_7.add(rdbtnMedium_4);

        rdbtnHeavy_2 = new JRadioButton("Heavy");
        buttonGroup_12.add(rdbtnHeavy_2);
        panel_7.add(rdbtnHeavy_2);

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_8.setBounds(280, 141, 192, 33);
        panel.add(panel_8);

        rdbtnMinimal_4 = new JRadioButton("Minimal");
        buttonGroup_3.add(rdbtnMinimal_4);
        panel_8.add(rdbtnMinimal_4);

        rdbtnPartial_4 = new JRadioButton("Partial");
        buttonGroup_3.add(rdbtnPartial_4);
        panel_8.add(rdbtnPartial_4);

        rdbtnFull_4 = new JRadioButton("Full");
        buttonGroup_3.add(rdbtnFull_4);
        panel_8.add(rdbtnFull_4);

        JLabel lblCompositionCompetency = new JLabel("Composition & Competency");
        lblCompositionCompetency.setBounds(10, 67, 221, 33);
        panel.add(lblCompositionCompetency);

        JLabel lblOrientaionEducation = new JLabel("Orientaion & Education");
        lblOrientaionEducation.setBounds(10, 104, 221, 33);
        panel.add(lblOrientaionEducation);

        lblNewLabel = new JLabel("0%");
        lblNewLabel.setBounds(676, 30, 38, 33);
        panel.add(lblNewLabel);

        label = new JLabel("0%");
        label.setBounds(676, 67, 38, 33);
        panel.add(label);

        label_1 = new JLabel("0%");
        label_1.setBounds(676, 104, 38, 33);
        panel.add(label_1);

        label_2 = new JLabel("0%");
        label_2.setBounds(676, 141, 38, 33);
        panel.add(label_2);

        button = new JButton("");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/short/principle1.pdf");
            }
        });
        button.setIcon(new ImageIcon(ShortRiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button.setBounds(237, 30, 33, 23);
        panel.add(button);

        button_1 = new JButton("");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/short/principle2.pdf");
            }
        });
        button_1.setIcon(new ImageIcon(ShortRiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_1.setBounds(237, 67, 33, 23);
        panel.add(button_1);

        button_2 = new JButton("");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/short/principle3.pdf");
            }
        });
        button_2.setIcon(new ImageIcon(ShortRiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_2.setBounds(237, 104, 33, 23);
        panel.add(button_2);

        button_3 = new JButton("");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/short/principle4.pdf");
            }
        });
        button_3.setIcon(new ImageIcon(ShortRiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_3.setBounds(237, 141, 33, 23);
        panel.add(button_3);

        JLabel lblNewLabel_1 = new JLabel("<html><a href=\"\">Assessment</a>");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/pf130/annC.pdf");
            }
        });
        lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_1.setBounds(10, 141, 57, 33);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("&");
        lblNewLabel_2.setBounds(69, 141, 16, 33);
        panel.add(lblNewLabel_2);

        JLabel lblcodeOfConduct = new JLabel("<html><a href=\"\">Code of Conduct</a>");
        lblcodeOfConduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/pf130/annA.pdf");
            }
        });
        lblcodeOfConduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblcodeOfConduct.setBounds(82, 141, 86, 33);
        panel.add(lblcodeOfConduct);

        JLabel lblReview = new JLabel("Review");
        lblReview.setBounds(168, 141, 46, 33);
        panel.add(lblReview);

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(null);
        panel_9.setLayout(null);
        panel_9.setBounds(0, 184, 724, 223);
        add(panel_9);

        JLabel lblInternalControls = new JLabel("Internal Controls & Governance Mechanisms");
        lblInternalControls.setBounds(10, 30, 221, 33);
        panel_9.add(lblInternalControls);

        JPanel panel_10 = new JPanel();
        panel_10.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_10.setBounds(277, 30, 192, 33);
        panel_9.add(panel_10);

        rdbtnMinimal = new JRadioButton("Minimal");
        buttonGroup_4.add(rdbtnMinimal);
        panel_10.add(rdbtnMinimal);

        rdbtnPartial = new JRadioButton("Partial");
        buttonGroup_4.add(rdbtnPartial);
        panel_10.add(rdbtnPartial);

        rdbtnFull_5 = new JRadioButton("Full");
        buttonGroup_4.add(rdbtnFull_5);
        panel_10.add(rdbtnFull_5);

        JLabel label_4 = new JLabel("Degree of Compliance");
        label_4.setBounds(277, 11, 192, 14);
        panel_9.add(label_4);

        JPanel panel_11 = new JPanel();
        panel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_11.setBounds(479, 30, 192, 33);
        panel_9.add(panel_11);

        rdbtnLight_5 = new JRadioButton("Light");
        buttonGroup_13.add(rdbtnLight_5);
        panel_11.add(rdbtnLight_5);

        rdbtnMedium_5 = new JRadioButton("Medium");
        buttonGroup_13.add(rdbtnMedium_5);
        panel_11.add(rdbtnMedium_5);

        rdbtnHeavy_5 = new JRadioButton("Heavy");
        buttonGroup_13.add(rdbtnHeavy_5);
        panel_11.add(rdbtnHeavy_5);

        JLabel label_5 = new JLabel("Risk Weighting");
        label_5.setBounds(479, 11, 192, 14);
        panel_9.add(label_5);

        JPanel panel_12 = new JPanel();
        panel_12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_12.setBounds(479, 68, 192, 33);
        panel_9.add(panel_12);

        rdbtnLight_6 = new JRadioButton("Light");
        buttonGroup_14.add(rdbtnLight_6);
        panel_12.add(rdbtnLight_6);

        rdbtnMedium_3 = new JRadioButton("Medium");
        buttonGroup_14.add(rdbtnMedium_3);
        panel_12.add(rdbtnMedium_3);

        rdbtnHeavy_6 = new JRadioButton("Heavy");
        buttonGroup_14.add(rdbtnHeavy_6);
        panel_12.add(rdbtnHeavy_6);

        JPanel panel_13 = new JPanel();
        panel_13.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_13.setBounds(277, 68, 192, 33);
        panel_9.add(panel_13);

        rdbtnMinimal_6 = new JRadioButton("Minimal");
        buttonGroup_5.add(rdbtnMinimal_6);
        panel_13.add(rdbtnMinimal_6);

        rdbtnPartial_6 = new JRadioButton("Partial");
        buttonGroup_5.add(rdbtnPartial_6);
        panel_13.add(rdbtnPartial_6);

        rdbtnFull_2 = new JRadioButton("Full");
        buttonGroup_5.add(rdbtnFull_2);
        panel_13.add(rdbtnFull_2);

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_14.setBounds(479, 105, 192, 33);
        panel_9.add(panel_14);

        rdbtnLight_7 = new JRadioButton("Light");
        buttonGroup_15.add(rdbtnLight_7);
        panel_14.add(rdbtnLight_7);

        rdbtnMedium_6 = new JRadioButton("Medium");
        buttonGroup_15.add(rdbtnMedium_6);
        panel_14.add(rdbtnMedium_6);

        rdbtnHeavy_4 = new JRadioButton("Heavy");
        buttonGroup_15.add(rdbtnHeavy_4);
        panel_14.add(rdbtnHeavy_4);

        JPanel panel_15 = new JPanel();
        panel_15.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_15.setBounds(277, 105, 192, 33);
        panel_9.add(panel_15);

        rdbtnMinimal_7 = new JRadioButton("Minimal");
        buttonGroup_6.add(rdbtnMinimal_7);
        panel_15.add(rdbtnMinimal_7);

        rdbtnPartial_5 = new JRadioButton("Partial");
        buttonGroup_6.add(rdbtnPartial_5);
        panel_15.add(rdbtnPartial_5);

        rdbtnFull_6 = new JRadioButton("Full");
        buttonGroup_6.add(rdbtnFull_6);
        panel_15.add(rdbtnFull_6);

        JPanel panel_16 = new JPanel();
        panel_16.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_16.setBounds(479, 142, 192, 33);
        panel_9.add(panel_16);

        rdbtnLight = new JRadioButton("Light");
        buttonGroup_16.add(rdbtnLight);
        panel_16.add(rdbtnLight);

        rdbtnMedium_7 = new JRadioButton("Medium");
        buttonGroup_16.add(rdbtnMedium_7);
        panel_16.add(rdbtnMedium_7);

        rdbtnHeavy_7 = new JRadioButton("Heavy");
        buttonGroup_16.add(rdbtnHeavy_7);
        panel_16.add(rdbtnHeavy_7);

        JPanel panel_17 = new JPanel();
        panel_17.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_17.setBounds(277, 142, 192, 33);
        panel_9.add(panel_17);

        rdbtnMinimal_5 = new JRadioButton("Minimal");
        buttonGroup_7.add(rdbtnMinimal_5);
        panel_17.add(rdbtnMinimal_5);

        rdbtnPartial_8 = new JRadioButton("Partial");
        buttonGroup_7.add(rdbtnPartial_8);
        panel_17.add(rdbtnPartial_8);

        rdbtnFull_7 = new JRadioButton("Full");
        buttonGroup_7.add(rdbtnFull_7);
        panel_17.add(rdbtnFull_7);

        JLabel lblExpertAdvisorsAccredited = new JLabel("Expert Advisors Accredited and Independent");
        lblExpertAdvisorsAccredited.setBounds(10, 68, 221, 33);
        panel_9.add(lblExpertAdvisorsAccredited);

        JLabel lblRiskManagementPolicies = new JLabel("Risk Management Policies & Procedures");
        lblRiskManagementPolicies.setBounds(10, 105, 221, 33);
        panel_9.add(lblRiskManagementPolicies);

        JLabel lblInvestmentPolicies = new JLabel("<html><a href=\"\">Investment Policies</a> & Procedures");
        lblInvestmentPolicies.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/pf130/annB.pdf");
            }
        });
        lblInvestmentPolicies.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblInvestmentPolicies.setBounds(10, 142, 221, 33);
        panel_9.add(lblInvestmentPolicies);

        label_7 = new JLabel("0%");
        label_7.setBounds(674, 30, 40, 33);
        panel_9.add(label_7);

        label_9 = new JLabel("0%");
        label_9.setBounds(674, 68, 40, 33);
        panel_9.add(label_9);

        label_10 = new JLabel("0%");
        label_10.setBounds(674, 105, 40, 33);
        panel_9.add(label_10);

        label_8 = new JLabel("0%");
        label_8.setBounds(674, 142, 40, 33);
        panel_9.add(label_8);

        label_3 = new JLabel("0%");
        label_3.setBounds(674, 178, 40, 33);
        panel_9.add(label_3);

        JPanel panel_18 = new JPanel();
        panel_18.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_18.setBounds(479, 178, 192, 33);
        panel_9.add(panel_18);

        rdbtnLight_8 = new JRadioButton("Light");
        buttonGroup_17.add(rdbtnLight_8);
        panel_18.add(rdbtnLight_8);

        rdbtnMedium_8 = new JRadioButton("Medium");
        buttonGroup_17.add(rdbtnMedium_8);
        panel_18.add(rdbtnMedium_8);

        rdbtnHeavy_8 = new JRadioButton("Heavy");
        buttonGroup_17.add(rdbtnHeavy_8);
        panel_18.add(rdbtnHeavy_8);

        JPanel panel_19 = new JPanel();
        panel_19.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_19.setBounds(277, 178, 192, 33);
        panel_9.add(panel_19);

        rdbtnMinimal_8 = new JRadioButton("Minimal");
        buttonGroup_8.add(rdbtnMinimal_8);
        panel_19.add(rdbtnMinimal_8);

        rdbtnPartial_7 = new JRadioButton("Partial");
        buttonGroup_8.add(rdbtnPartial_7);
        panel_19.add(rdbtnPartial_7);

        rdbtnFull_8 = new JRadioButton("Full");
        buttonGroup_8.add(rdbtnFull_8);
        panel_19.add(rdbtnFull_8);

        JLabel lblMemberCommunication = new JLabel("<html>Stakeholder Relationships, Communication<br> & Access to Info");
        lblMemberCommunication.setBounds(10, 178, 221, 33);
        panel_9.add(lblMemberCommunication);

        button_4 = new JButton("");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/short/principle5.pdf");
            }
        });
        button_4.setIcon(new ImageIcon(ShortRiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_4.setBounds(237, 30, 33, 23);
        panel_9.add(button_4);

        button_5 = new JButton("");
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/short/principle6.pdf");
            }
        });
        button_5.setIcon(new ImageIcon(ShortRiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_5.setBounds(237, 68, 33, 23);
        panel_9.add(button_5);

        button_6 = new JButton("");
        button_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/short/principle7.pdf");
            }
        });
        button_6.setIcon(new ImageIcon(ShortRiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_6.setBounds(237, 105, 33, 23);
        panel_9.add(button_6);

        button_7 = new JButton("");
        button_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/short/principle8.pdf");
            }
        });
        button_7.setIcon(new ImageIcon(ShortRiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_7.setBounds(237, 142, 33, 23);
        panel_9.add(button_7);

        button_8 = new JButton("");
        button_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/short/principle9to13.pdf");
            }
        });
        button_8.setIcon(new ImageIcon(ShortRiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_8.setBounds(237, 178, 33, 23);
        panel_9.add(button_8);

        textField = new JTextField();
        textField.setBounds(608, 411, 86, 20);
        add(textField);
        textField.setColumns(10);

        lblCalculatedLoadingTo = new JLabel("Calculated loading to be applied to basic recommended indemnity sum assured:");
        lblCalculatedLoadingTo.setBounds(218, 411, 378, 14);
        add(lblCalculatedLoadingTo);

    }

    public JRadioButton getRdbtnMinimal_5() {
        return rdbtnMinimal;
    }

    public JRadioButton getRdbtnHeavy_2() {
        return rdbtnHeavy;
    }

    public JRadioButton getRdbtnPartial_5() {
        return rdbtnPartial;
    }

    public JRadioButton getRdbtnHeavy_4() {
        return rdbtnHeavy_2;
    }

    public JRadioButton getRdbtnPartial_3() {
        return rdbtnPartial_3;
    }

    public JRadioButton getRdbtnMedium_3() {
        return rdbtnMedium;
    }

    public JRadioButton getRdbtnHeavy_7() {
        return rdbtnHeavy_4;
    }

    public JRadioButton getRdbtnHeavy_3() {
        return rdbtnHeavy_3;
    }

    public JRadioButton getRdbtnPartial_2() {
        return rdbtnPartial_2;
    }

    public JRadioButton getRdbtnFull_2() {
        return rdbtnFull;
    }

    public JRadioButton getRdbtnLight_8() {
        return rdbtnLight;
    }

    public JRadioButton getRdbtnMedium_6() {
        return rdbtnMedium_3;
    }

    public JRadioButton getRdbtnHeavy_6() {
        return rdbtnHeavy_6;
    }

    public JRadioButton getRdbtnHeavy_1() {
        return rdbtnHeavy_1;
    }

    public JRadioButton getRdbtnFull_6() {
        return rdbtnFull_2;
    }

    public JRadioButton getRdbtnPartial_7() {
        return rdbtnPartial_5;
    }

    public JRadioButton getRdbtnFull_1() {
        return rdbtnFull_1;
    }

    public JRadioButton getRdbtnMinimal_3() {
        return rdbtnMinimal_3;
    }

    public JRadioButton getRdbtnMedium_5() {
        return rdbtnMedium_5;
    }

    public JRadioButton getRdbtnFull_7() {
        return rdbtnFull_6;
    }

    public JRadioButton getRdbtnFull_4() {
        return rdbtnFull_4;
    }

    public JRadioButton getRdbtnPartial_6() {
        return rdbtnPartial_6;
    }

    public JRadioButton getRdbtnPartial_9() {
        return rdbtnPartial_7;
    }

    public JRadioButton getRdbtnHeavy_5() {
        return rdbtnHeavy_5;
    }

    public JRadioButton getRdbtnMinimal_8() {
        return rdbtnMinimal_5;
    }

    public JRadioButton getRdbtnLight_7() {
        return rdbtnLight_7;
    }

    public JRadioButton getRdbtnMedium_2() {
        return rdbtnMedium_2;
    }

    public JRadioButton getRdbtnPartial_4() {
        return rdbtnPartial_4;
    }

    public JRadioButton getRdbtnLight_1() {
        return rdbtnLight_1;
    }

    public JRadioButton getRdbtnMinimal_7() {
        return rdbtnMinimal_7;
    }

    public JRadioButton getRdbtnLight_6() {
        return rdbtnLight_6;
    }

    public JRadioButton getRdbtnMedium_7() {
        return rdbtnMedium_6;
    }

    public JRadioButton getRdbtnLight_2() {
        return rdbtnLight_2;
    }

    public JRadioButton getRdbtnFull_8() {
        return rdbtnFull_7;
    }

    public JRadioButton getRdbtnMedium_8() {
        return rdbtnMedium_7;
    }

    public JRadioButton getRdbtnMinimal_1() {
        return rdbtnMinimal_1;
    }

    public JRadioButton getRdbtnLight_5() {
        return rdbtnLight_5;
    }

    public JRadioButton getRdbtnMinimal_6() {
        return rdbtnMinimal_6;
    }

    public JRadioButton getRdbtnPartial_8() {
        return rdbtnPartial_8;
    }

    public JRadioButton getRdbtnMedium_1() {
        return rdbtnMedium_1;
    }

    public JRadioButton getRdbtnFull_3() {
        return rdbtnFull_3;
    }

    public JRadioButton getRdbtnMinimal_9() {
        return rdbtnMinimal_8;
    }

    public JRadioButton getRdbtnMedium_9() {
        return rdbtnMedium_8;
    }

    public JRadioButton getRdbtnMedium_4() {
        return rdbtnMedium_4;
    }

    public JRadioButton getRdbtnPartial_1() {
        return rdbtnPartial_1;
    }

    public JRadioButton getRdbtnMinimal_2() {
        return rdbtnMinimal_2;
    }

    public JRadioButton getRdbtnLight_4() {
        return rdbtnLight_4;
    }

    public JRadioButton getRdbtnFull_9() {
        return rdbtnFull_8;
    }

    public JRadioButton getRdbtnHeavy_8() {
        return rdbtnHeavy_7;
    }

    public JRadioButton getRdbtnFull_5() {
        return rdbtnFull_5;
    }

    public JRadioButton getRdbtnMinimal_4() {
        return rdbtnMinimal_4;
    }

    public JRadioButton getRdbtnLight_3() {
        return rdbtnLight_3;
    }

    public JRadioButton getRdbtnHeavy_9() {
        return rdbtnHeavy_8;
    }

    public JRadioButton getRdbtnLight_9() {
        return rdbtnLight_8;
    }

    public JLabel getLabel_9() {
        return label_9;
    }

    public JLabel getLabel_10() {
        return label_10;
    }

    public JLabel getLblNewLabel() {
        return lblNewLabel;
    }

    public JLabel getLabel() {
        return label;
    }

    public JLabel getLabel_1() {
        return label_1;
    }

    public JLabel getLabel_2() {
        return label_2;
    }

    public JLabel getLabel_7() {
        return label_7;
    }

    public JLabel getLabel_3() {
        return label_3;
    }

    public JLabel getLabel_8() {
        return label_8;
    }

    public JTextField getTextField() {
        return textField;
    }
}
