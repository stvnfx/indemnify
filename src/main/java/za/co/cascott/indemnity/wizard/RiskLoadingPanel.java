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
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RiskLoadingPanel extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
    private JTextField textField_18;
    private JTextField textField_19;
    private JTextField textField_20;
    private JTextField textField_21;
    private JTextField textField_22;
    private JTextField textField_23;
    private JTextField textField_24;
    private JTextField textField_26;
    private JTextField textField_27;
    private JTextField textField_28;
    private JTextField textField_29;
    public JComboBox comboBox_4;
    public JComboBox comboBox_10;
    public JComboBox comboBox_14;
    public JComboBox comboBox_5;
    public JComboBox comboBox_8;
    public JComboBox comboBox_15;
    public JComboBox comboBox_13;
    public JComboBox comboBox_3;
    public JComboBox comboBox;
    public JComboBox comboBox_12;
    public JComboBox comboBox_2;
    public JComboBox comboBox_6;
    public JComboBox comboBox_11;
    public JComboBox comboBox_9;
    public JComboBox comboBox_1;
    public JComboBox comboBox_7;
    public JComboBox comboBox_23;
    public JComboBox comboBox_25;
    public JComboBox comboBox_17;
    public JComboBox comboBox_24;
    public JComboBox comboBox_20;
    public JComboBox comboBox_29;
    public JComboBox comboBox_27;
    public JComboBox comboBox_31;
    public JComboBox comboBox_19;
    public JComboBox comboBox_16;
    public JComboBox comboBox_22;
    public JComboBox comboBox_30;
    public JComboBox comboBox_28;
    public JComboBox comboBox_18;
    public JComboBox comboBox_21;
    public JComboBox comboBox_26;
    public JComboBox comboBox_41;
    public JComboBox comboBox_43;
    public JComboBox comboBox_39;
    public JComboBox comboBox_38;
    public JComboBox comboBox_44;
    public JComboBox comboBox_40;
    public JComboBox comboBox_34;
    public JComboBox comboBox_42;
    public JComboBox comboBox_35;
    public JComboBox comboBox_36;
    public JComboBox comboBox_32;
    public JComboBox comboBox_33;
    public JComboBox comboBox_45;
    public JComboBox comboBox_37;
    public JComboBox comboBox_46;
    public JComboBox comboBox_52;
    public JComboBox comboBox_54;
    public JComboBox comboBox_53;
    public JComboBox comboBox_48;
    public JComboBox comboBox_55;
    public JComboBox comboBox_59;
    public JComboBox comboBox_49;
    public JComboBox comboBox_56;
    public JComboBox comboBox_57;
    public JComboBox comboBox_47;
    public JComboBox comboBox_58;

    public JComboBox comboBox_60;
    public JComboBox comboBox_61;
    public JComboBox comboBox_62;
    public JComboBox comboBox_63;

    public JComboBox comboBox_50;
    public JComboBox comboBox_51;

    public JComboBox comboBox_65;
    public JComboBox comboBox_64;

    String[] compStrings = {"Minimal", "Partial", "Full"};
    String[] weigStrings = {"Light", "Medium", "Heavy"};
    private JTextField textField_30;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
    private JButton button_16;
    private JButton button_17;
    private JButton button_18;
    private JButton button_19;
    private JButton button_20;
    private JButton button_21;
    private JButton button_22;
    private JButton button_23;
    private JButton button_24;
    private JButton button_26;
    private JButton button_27;
    private JButton button_28;
    private JButton button_29;
    private JLabel label_32;
    private JLabel label_33;
    private JLabel label_34;
    private JLabel label_35;
    private JLabel label_8;
    private JLabel label_9;
    private JLabel label_10;
    private JLabel label_19;
    private JLabel label_20;
    private JLabel label_21;
    private JLabel label_29;
    private JLabel label_30;
    private JLabel label_31;
    private JLabel label_36;
    private JLabel label_37;
    private JLabel label_38;
    private JTextField textField_31;
    private JButton button_31;
    private JTextField textField_32;
    private JButton button_25;
    private JButton button_32;
    private JTextField textField_25;
    private JTextField textField_33;
    private JLabel lblmembersAndBeneficiaries;
    private JLabel lblrelationshipBetweenThe;
    private JLabel lblpolicyInPlace_1;
    private JLabel lblrequirementsOfRequlatory;
    JComboBox comboBox_66;
    JComboBox comboBox_67;

    /**
     * Create the panel.
     */
    public RiskLoadingPanel() {
        setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 780, 448);
        add(tabbedPane);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        tabbedPane.addTab("Page 1", null, panel, null);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Board Governance Structure", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setLayout(null);
        panel_1.setBounds(10, 27, 755, 108);
        panel.add(panel_1);

        JLabel lblcodeOfConduct = new JLabel("<html><a href=\"\">Code of conduct</a> for the board documented and adhered to:");
        lblcodeOfConduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReaderSystem.getReaderSystemObject().showWindow();
                ReaderSystem.getReaderSystemObject().setInternalPage("/assets/docs/pf130/annA1to3.xhtml");
            }
        });
        lblcodeOfConduct.setBounds(10, 22, 365, 14);
        panel_1.add(lblcodeOfConduct);

        JLabel lblacceptanceOfDuties = new JLabel("<html><a href=\"\">Acceptance of duties and obligations</a> form signed by each board member:");
        lblacceptanceOfDuties.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReaderSystem.getReaderSystemObject().showWindow();
                ReaderSystem.getReaderSystemObject().setInternalPage("/assets/docs/pf130/annA4to5.xhtml");
            }
        });
        lblacceptanceOfDuties.setBounds(10, 47, 365, 14);
        panel_1.add(lblacceptanceOfDuties);

        JLabel lblconflictsOfInterest = new JLabel("<html>Conflicts of interest - <a href=\"\">Declaration of financial and other interests</a> completed<br> annually by board:</html>");
        lblconflictsOfInterest.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReaderSystem.getReaderSystemObject().showWindow();
                ReaderSystem.getReaderSystemObject().setInternalPage("/assets/docs/pf130/annA7to8.xhtml");
            }
        });
        lblconflictsOfInterest.setBounds(10, 72, 365, 25);
        panel_1.add(lblconflictsOfInterest);

        comboBox = new JComboBox();
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox.setModel(new DefaultComboBoxModel(compStrings));
        comboBox.setBounds(452, 19, 75, 20);
        panel_1.add(comboBox);

        comboBox_1 = new JComboBox(weigStrings);
        comboBox_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_1.setBounds(556, 19, 75, 20);
        panel_1.add(comboBox_1);

        textField = new JTextField();
        textField.setEnabled(false);
        textField.setEditable(false);
        textField.setColumns(10);
        textField.setBounds(657, 19, 75, 20);
        panel_1.add(textField);

        comboBox_2 = new JComboBox(compStrings);
        comboBox_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_2.setBounds(452, 44, 75, 20);
        panel_1.add(comboBox_2);

        comboBox_3 = new JComboBox(weigStrings);
        comboBox_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_3.setBounds(556, 44, 75, 20);
        panel_1.add(comboBox_3);

        textField_1 = new JTextField();
        textField_1.setEnabled(false);
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setBounds(657, 44, 75, 20);
        panel_1.add(textField_1);

        comboBox_4 = new JComboBox(compStrings);
        comboBox_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_4.setBounds(452, 77, 75, 20);
        panel_1.add(comboBox_4);

        comboBox_5 = new JComboBox(weigStrings);
        comboBox_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_5.setBounds(556, 77, 75, 20);
        panel_1.add(comboBox_5);

        textField_2 = new JTextField();
        textField_2.setEnabled(false);
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        textField_2.setBounds(657, 77, 75, 20);
        panel_1.add(textField_2);

        JButton button = new JButton("");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle1para22one.pdf");
            }
        });
        button.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button.setBounds(409, 18, 33, 23);
        panel_1.add(button);

        button_1 = new JButton("");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle1para22second.pdf");
            }
        });
        button_1.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_1.setBounds(409, 43, 33, 23);
        panel_1.add(button_1);

        button_2 = new JButton("");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle1para19.pdf");
            }
        });
        button_2.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_2.setBounds(409, 76, 33, 23);
        panel_1.add(button_2);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Board Composition & Competency", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setLayout(null);
        panel_2.setBounds(10, 146, 755, 121);
        panel.add(panel_2);

        JLabel label_3 = new JLabel("Recommended percentage of independent board members appointed:");
        label_3.setBounds(10, 22, 365, 14);
        panel_2.add(label_3);

        JLabel label_4 = new JLabel("<html>Credentials of independent board members verified with regulatory\r\n<br>authorities:</html>");
        label_4.setBounds(10, 47, 365, 24);
        panel_2.add(label_4);

        JLabel label_5 = new JLabel("Sub-committees appointed to advise board on risks and controls:");
        label_5.setBounds(10, 82, 365, 25);
        panel_2.add(label_5);

        comboBox_6 = new JComboBox(compStrings);
        comboBox_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_6.setBounds(451, 19, 75, 20);
        panel_2.add(comboBox_6);

        comboBox_7 = new JComboBox(weigStrings);
        comboBox_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_7.setBounds(556, 19, 75, 20);
        panel_2.add(comboBox_7);

        textField_3 = new JTextField();
        textField_3.setEnabled(false);
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        textField_3.setBounds(656, 19, 75, 20);
        panel_2.add(textField_3);

        comboBox_8 = new JComboBox(compStrings);
        comboBox_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_8.setBounds(451, 47, 75, 20);
        panel_2.add(comboBox_8);

        comboBox_9 = new JComboBox(weigStrings);
        comboBox_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_9.setBounds(556, 47, 75, 20);
        panel_2.add(comboBox_9);

        textField_4 = new JTextField();
        textField_4.setEnabled(false);
        textField_4.setEditable(false);
        textField_4.setColumns(10);
        textField_4.setBounds(656, 47, 75, 20);
        panel_2.add(textField_4);

        comboBox_10 = new JComboBox(compStrings);
        comboBox_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_10.setBounds(451, 84, 75, 20);
        panel_2.add(comboBox_10);

        comboBox_11 = new JComboBox(weigStrings);
        comboBox_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_11.setBounds(556, 84, 75, 20);
        panel_2.add(comboBox_11);

        textField_5 = new JTextField();
        textField_5.setEnabled(false);
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBounds(656, 84, 75, 20);
        panel_2.add(textField_5);

        button_3 = new JButton("");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle2para24to25.pdf");
            }
        });
        button_3.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_3.setBounds(408, 18, 33, 23);
        panel_2.add(button_3);

        button_4 = new JButton("");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle2para23.pdf");
            }
        });
        button_4.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_4.setBounds(408, 48, 33, 23);
        panel_2.add(button_4);

        button_5 = new JButton("");
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle2para26to29.pdf");
            }
        });
        button_5.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_5.setBounds(408, 83, 33, 23);
        panel_2.add(button_5);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Board Orientation & Education", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_3.setLayout(null);
        panel_3.setBounds(10, 278, 755, 81);
        panel.add(panel_3);

        JLabel label_6 = new JLabel("Formal induction training programme in place for new board members:");
        label_6.setBounds(10, 22, 365, 14);
        panel_3.add(label_6);

        JLabel label_7 = new JLabel("Formal ongoing education programme in place for board members:");
        label_7.setBounds(10, 47, 365, 24);
        panel_3.add(label_7);

        comboBox_12 = new JComboBox(compStrings);
        comboBox_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_12.setBounds(452, 19, 75, 20);
        panel_3.add(comboBox_12);

        comboBox_13 = new JComboBox(weigStrings);
        comboBox_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_13.setBounds(555, 19, 75, 20);
        panel_3.add(comboBox_13);

        textField_6 = new JTextField();
        textField_6.setEnabled(false);
        textField_6.setEditable(false);
        textField_6.setColumns(10);
        textField_6.setBounds(657, 19, 75, 20);
        panel_3.add(textField_6);

        comboBox_14 = new JComboBox(compStrings);
        comboBox_14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_14.setBounds(452, 49, 75, 20);
        panel_3.add(comboBox_14);

        comboBox_15 = new JComboBox(weigStrings);
        comboBox_15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_15.setBounds(555, 49, 75, 20);
        panel_3.add(comboBox_15);

        textField_7 = new JTextField();
        textField_7.setEnabled(false);
        textField_7.setEditable(false);
        textField_7.setColumns(10);
        textField_7.setBounds(657, 49, 75, 20);
        panel_3.add(textField_7);

        button_6 = new JButton("");
        button_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle3para30.pdf");
            }
        });
        button_6.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_6.setBounds(409, 16, 33, 23);
        panel_3.add(button_6);

        button_7 = new JButton("");
        button_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle3para31to32.pdf");
            }
        });
        button_7.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_7.setBounds(409, 48, 33, 23);
        panel_3.add(button_7);

        label_32 = new JLabel("Please complete pages 1 to 4");
        label_32.setForeground(new Color(210, 105, 30));
        label_32.setBounds(10, 2, 150, 14);
        panel.add(label_32);

        label_8 = new JLabel("Compliance");
        label_8.setForeground(SystemColor.activeCaptionText);
        label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_8.setBounds(461, 11, 65, 14);
        panel.add(label_8);

        label_9 = new JLabel("Weighting");
        label_9.setForeground(SystemColor.activeCaptionText);
        label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_9.setBounds(571, 11, 57, 14);
        panel.add(label_9);

        label_10 = new JLabel("Loading");
        label_10.setForeground(SystemColor.activeCaptionText);
        label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_10.setBounds(679, 11, 44, 14);
        panel.add(label_10);

        JPanel panel_7 = new JPanel();
        panel_7.setLayout(null);
        tabbedPane.addTab("Page 2", null, panel_7, null);

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Board Assessment & Breach of Code of Conduct", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_8.setLayout(null);
        panel_8.setBounds(10, 27, 755, 83);
        panel_7.add(panel_8);

        JLabel lblformalAnnualperformance = new JLabel("<html>Formal annual <a href=\"\">performance appraisal process</a> in place for the board, the<br> principal officer and sub-committees:</html>\r\n");
        lblformalAnnualperformance.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/pf130/annC.pdf");
            }
        });
        lblformalAnnualperformance.setBounds(10, 22, 365, 29);
        panel_8.add(lblformalAnnualperformance);

        JLabel label_12 = new JLabel("Breach of Code of Conduct policy in place:");
        label_12.setBounds(10, 53, 365, 14);
        panel_8.add(label_12);

        comboBox_16 = new JComboBox(compStrings);
        comboBox_16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_16.setBounds(450, 19, 75, 20);
        panel_8.add(comboBox_16);

        comboBox_17 = new JComboBox(weigStrings);
        comboBox_17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_17.setBounds(552, 19, 75, 20);
        panel_8.add(comboBox_17);

        textField_8 = new JTextField();
        textField_8.setEnabled(false);
        textField_8.setEditable(false);
        textField_8.setColumns(10);
        textField_8.setBounds(656, 19, 75, 20);
        panel_8.add(textField_8);

        comboBox_18 = new JComboBox(compStrings);
        comboBox_18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_18.setBounds(450, 50, 75, 20);
        panel_8.add(comboBox_18);

        comboBox_19 = new JComboBox(weigStrings);
        comboBox_19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_19.setBounds(552, 50, 75, 20);
        panel_8.add(comboBox_19);

        textField_9 = new JTextField();
        textField_9.setEnabled(false);
        textField_9.setEditable(false);
        textField_9.setColumns(10);
        textField_9.setBounds(656, 50, 75, 20);
        panel_8.add(textField_9);

        JButton button_8 = new JButton("");
        button_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle4para33to34.pdf");
            }
        });
        button_8.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_8.setBounds(407, 18, 33, 23);
        panel_8.add(button_8);

        JButton button_9 = new JButton("");
        button_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle4para34.pdf");
            }
        });
        button_9.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_9.setBounds(407, 49, 33, 23);
        panel_8.add(button_9);

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Internal Controls & Governance Mechanisms", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_9.setLayout(null);
        panel_9.setBounds(10, 121, 755, 200);
        panel_7.add(panel_9);

        JLabel label_13 = new JLabel("Internal controls and procedures clearly documented and adhered to:");
        label_13.setBounds(10, 22, 365, 14);
        panel_9.add(label_13);

        JLabel label_14 = new JLabel("Third party service provider service level agreements signed and monitored:");
        label_14.setBounds(10, 47, 365, 14);
        panel_9.add(label_14);

        JLabel label_15 = new JLabel("Regular reviews of services, fees and operational costs of the Fund:");
        label_15.setBounds(10, 72, 365, 25);
        panel_9.add(label_15);

        comboBox_20 = new JComboBox(compStrings);
        comboBox_20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_20.setBounds(450, 19, 75, 20);
        panel_9.add(comboBox_20);

        comboBox_21 = new JComboBox(weigStrings);
        comboBox_21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_21.setBounds(552, 19, 75, 20);
        panel_9.add(comboBox_21);

        textField_10 = new JTextField();
        textField_10.setEnabled(false);
        textField_10.setEditable(false);
        textField_10.setColumns(10);
        textField_10.setBounds(655, 19, 75, 20);
        panel_9.add(textField_10);

        comboBox_22 = new JComboBox(compStrings);
        comboBox_22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_22.setBounds(450, 44, 75, 20);
        panel_9.add(comboBox_22);

        comboBox_23 = new JComboBox(weigStrings);
        comboBox_23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_23.setBounds(552, 44, 75, 20);
        panel_9.add(comboBox_23);

        textField_11 = new JTextField();
        textField_11.setEnabled(false);
        textField_11.setEditable(false);
        textField_11.setColumns(10);
        textField_11.setBounds(655, 44, 75, 20);
        panel_9.add(textField_11);

        comboBox_24 = new JComboBox(compStrings);
        comboBox_24.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_24.setBounds(450, 74, 75, 20);
        panel_9.add(comboBox_24);

        comboBox_25 = new JComboBox(weigStrings);
        comboBox_25.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_25.setBounds(552, 74, 75, 20);
        panel_9.add(comboBox_25);

        textField_12 = new JTextField();
        textField_12.setEnabled(false);
        textField_12.setEditable(false);
        textField_12.setColumns(10);
        textField_12.setBounds(655, 74, 75, 20);
        panel_9.add(textField_12);

        JLabel label_16 = new JLabel("Information systems and security policies monitored and reviewed:");
        label_16.setBounds(10, 107, 365, 14);
        panel_9.add(label_16);

        comboBox_26 = new JComboBox(compStrings);
        comboBox_26.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_26.setBounds(450, 104, 75, 20);
        panel_9.add(comboBox_26);

        comboBox_27 = new JComboBox(weigStrings);
        comboBox_27.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_27.setBounds(552, 104, 75, 20);
        panel_9.add(comboBox_27);

        textField_13 = new JTextField();
        textField_13.setEnabled(false);
        textField_13.setEditable(false);
        textField_13.setColumns(10);
        textField_13.setBounds(655, 104, 75, 20);
        panel_9.add(textField_13);

        JLabel label_17 = new JLabel("Actual, potential or perceived conflicts of interest monitored:");
        label_17.setBounds(10, 135, 365, 14);
        panel_9.add(label_17);

        comboBox_28 = new JComboBox(compStrings);
        comboBox_28.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_28.setBounds(450, 132, 75, 20);
        panel_9.add(comboBox_28);

        comboBox_29 = new JComboBox(weigStrings);
        comboBox_29.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_29.setBounds(552, 132, 75, 20);
        panel_9.add(comboBox_29);

        textField_14 = new JTextField();
        textField_14.setEnabled(false);
        textField_14.setEditable(false);
        textField_14.setColumns(10);
        textField_14.setBounds(655, 132, 75, 20);
        panel_9.add(textField_14);

        JLabel label_18 = new JLabel("Regular reviews of compliance with regulatory and statutory requirements:");
        label_18.setBounds(10, 163, 365, 14);
        panel_9.add(label_18);

        comboBox_30 = new JComboBox(compStrings);
        comboBox_30.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_30.setBounds(450, 160, 75, 20);
        panel_9.add(comboBox_30);

        comboBox_31 = new JComboBox(weigStrings);
        comboBox_31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_31.setBounds(552, 160, 75, 20);
        panel_9.add(comboBox_31);

        textField_15 = new JTextField();
        textField_15.setEnabled(false);
        textField_15.setEditable(false);
        textField_15.setColumns(10);
        textField_15.setBounds(655, 163, 75, 20);
        panel_9.add(textField_15);

        JButton button_10 = new JButton("");
        button_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle5para35to37.pdf");
            }
        });
        button_10.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_10.setBounds(407, 18, 33, 23);
        panel_9.add(button_10);

        JButton button_11 = new JButton("");
        button_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle5para38.1.pdf");
            }
        });
        button_11.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_11.setBounds(407, 43, 33, 23);
        panel_9.add(button_11);

        JButton button_12 = new JButton("");
        button_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle5para38.2.pdf");
            }
        });
        button_12.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_12.setBounds(407, 73, 33, 23);
        panel_9.add(button_12);

        JButton button_13 = new JButton("");
        button_13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle5para38.3to38.5.pdf");
            }
        });
        button_13.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_13.setBounds(407, 103, 33, 23);
        panel_9.add(button_13);

        JButton button_14 = new JButton("");
        button_14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle5para38.4.pdf");
            }
        });
        button_14.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_14.setBounds(407, 131, 33, 23);
        panel_9.add(button_14);

        JButton button_15 = new JButton("");
        button_15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle5para38.6.pdf");
            }
        });
        button_15.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_15.setBounds(407, 159, 33, 23);
        panel_9.add(button_15);

        label_33 = new JLabel("Please complete pages 1 to 4");
        label_33.setForeground(new Color(210, 105, 30));
        label_33.setBounds(10, 2, 150, 14);
        panel_7.add(label_33);

        label_19 = new JLabel("Loading");
        label_19.setForeground(Color.BLACK);
        label_19.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_19.setBounds(678, 11, 44, 14);
        panel_7.add(label_19);

        label_20 = new JLabel("Weighting");
        label_20.setForeground(Color.BLACK);
        label_20.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_20.setBounds(570, 11, 57, 14);
        panel_7.add(label_20);

        label_21 = new JLabel("Compliance");
        label_21.setForeground(Color.BLACK);
        label_21.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_21.setBounds(460, 11, 65, 14);
        panel_7.add(label_21);

        JPanel panel_13 = new JPanel();
        panel_13.setLayout(null);
        tabbedPane.addTab("Page 3", null, panel_13, null);

        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Expert Advisors", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_14.setLayout(null);
        panel_14.setBounds(10, 27, 755, 108);
        panel_13.add(panel_14);

        JLabel label_22 = new JLabel("Professional advisors suitably accredited:");
        label_22.setBounds(10, 22, 365, 14);
        panel_14.add(label_22);

        JLabel label_23 = new JLabel("Mechanisms in place to ensure expert advice is independently given:");
        label_23.setBounds(10, 47, 365, 14);
        panel_14.add(label_23);

        JLabel label_24 = new JLabel("Expert advisors appointed directly by the board:");
        label_24.setBounds(10, 72, 365, 25);
        panel_14.add(label_24);

        comboBox_32 = new JComboBox(compStrings);
        comboBox_32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_32.setBounds(453, 19, 75, 20);
        panel_14.add(comboBox_32);

        comboBox_33 = new JComboBox(weigStrings);
        comboBox_33.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_33.setBounds(553, 19, 75, 20);
        panel_14.add(comboBox_33);

        textField_16 = new JTextField();
        textField_16.setEnabled(false);
        textField_16.setEditable(false);
        textField_16.setColumns(10);
        textField_16.setBounds(657, 19, 75, 20);
        panel_14.add(textField_16);

        comboBox_34 = new JComboBox(compStrings);
        comboBox_34.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_34.setBounds(453, 47, 75, 20);
        panel_14.add(comboBox_34);

        comboBox_35 = new JComboBox(weigStrings);
        comboBox_35.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_35.setBounds(553, 47, 75, 20);
        panel_14.add(comboBox_35);

        textField_17 = new JTextField();
        textField_17.setEnabled(false);
        textField_17.setEditable(false);
        textField_17.setColumns(10);
        textField_17.setBounds(657, 47, 75, 20);
        panel_14.add(textField_17);

        comboBox_36 = new JComboBox(compStrings);
        comboBox_36.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_36.setBounds(453, 77, 75, 20);
        panel_14.add(comboBox_36);

        comboBox_37 = new JComboBox(weigStrings);
        comboBox_37.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_37.setBounds(553, 77, 75, 20);
        panel_14.add(comboBox_37);

        textField_18 = new JTextField();
        textField_18.setEnabled(false);
        textField_18.setEditable(false);
        textField_18.setColumns(10);
        textField_18.setBounds(657, 77, 75, 20);
        panel_14.add(textField_18);

        button_16 = new JButton("");
        button_16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle6para39to41.pdf");
            }
        });
        button_16.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_16.setBounds(410, 18, 33, 23);
        panel_14.add(button_16);

        button_17 = new JButton("");
        button_17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle6para42.pdf");
            }
        });
        button_17.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_17.setBounds(410, 46, 33, 23);
        panel_14.add(button_17);

        button_18 = new JButton("");
        button_18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle6para43.pdf");
            }
        });
        button_18.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_18.setBounds(410, 74, 33, 23);
        panel_14.add(button_18);

        JPanel panel_15 = new JPanel();
        panel_15.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Risk Management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_15.setLayout(null);
        panel_15.setBounds(10, 146, 755, 145);
        panel_13.add(panel_15);

        JLabel label_25 = new JLabel("Risk management policy documented and reviewed annually:");
        label_25.setBounds(10, 22, 365, 14);
        panel_15.add(label_25);

        JLabel label_26 = new JLabel("Fidelity cover in place to indemnify fund:");
        label_26.setBounds(10, 47, 365, 14);
        panel_15.add(label_26);

        JLabel label_27 = new JLabel("Personal Indemnity cover in place to indemnify board members:");
        label_27.setBounds(10, 72, 365, 25);
        panel_15.add(label_27);

        comboBox_38 = new JComboBox(compStrings);
        comboBox_38.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_38.setBounds(452, 19, 75, 20);
        panel_15.add(comboBox_38);

        comboBox_39 = new JComboBox(weigStrings);
        comboBox_39.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_39.setBounds(552, 19, 75, 20);
        panel_15.add(comboBox_39);

        textField_19 = new JTextField();
        textField_19.setEnabled(false);
        textField_19.setEditable(false);
        textField_19.setColumns(10);
        textField_19.setBounds(658, 19, 75, 20);
        panel_15.add(textField_19);

        comboBox_40 = new JComboBox(compStrings);
        comboBox_40.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_40.setBounds(452, 47, 75, 20);
        panel_15.add(comboBox_40);

        comboBox_41 = new JComboBox(weigStrings);
        comboBox_41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_41.setBounds(552, 47, 75, 20);
        panel_15.add(comboBox_41);

        textField_20 = new JTextField();
        textField_20.setEnabled(false);
        textField_20.setEditable(false);
        textField_20.setColumns(10);
        textField_20.setBounds(658, 47, 75, 20);
        panel_15.add(textField_20);

        comboBox_42 = new JComboBox(compStrings);
        comboBox_42.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_42.setBounds(452, 77, 75, 20);
        panel_15.add(comboBox_42);

        comboBox_43 = new JComboBox(weigStrings);
        comboBox_43.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_43.setBounds(552, 77, 75, 20);
        panel_15.add(comboBox_43);

        textField_21 = new JTextField();
        textField_21.setEnabled(false);
        textField_21.setEditable(false);
        textField_21.setColumns(10);
        textField_21.setBounds(658, 74, 75, 20);
        panel_15.add(textField_21);

        JLabel label_28 = new JLabel("<html>Third party service providers have professional indemnity &  fidelity<br>guarantee insurance cover :</html>");
        label_28.setBounds(10, 108, 365, 25);
        panel_15.add(label_28);

        comboBox_44 = new JComboBox(compStrings);
        comboBox_44.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_44.setBounds(452, 113, 75, 20);
        panel_15.add(comboBox_44);

        comboBox_45 = new JComboBox(weigStrings);
        comboBox_45.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_45.setBounds(552, 113, 75, 20);
        panel_15.add(comboBox_45);

        textField_22 = new JTextField();
        textField_22.setEnabled(false);
        textField_22.setEditable(false);
        textField_22.setColumns(10);
        textField_22.setBounds(658, 113, 75, 20);
        panel_15.add(textField_22);

        button_19 = new JButton("");
        button_19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle7para44to47.pdf");
            }
        });
        button_19.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_19.setBounds(409, 16, 33, 23);
        panel_15.add(button_19);

        button_20 = new JButton("");
        button_20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle7para48.pdf");
            }
        });
        button_20.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_20.setBounds(409, 46, 33, 23);
        panel_15.add(button_20);

        button_21 = new JButton("");
        button_21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle7para48.pdf");
            }
        });
        button_21.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_21.setBounds(409, 74, 33, 23);
        panel_15.add(button_21);

        button_22 = new JButton("");
        button_22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle7para48.pdf");
            }
        });
        button_22.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_22.setBounds(409, 110, 33, 23);
        panel_15.add(button_22);

        label_34 = new JLabel("Please complete pages 1 to 4");
        label_34.setForeground(new Color(210, 105, 30));
        label_34.setBounds(10, 2, 150, 14);
        panel_13.add(label_34);

        label_29 = new JLabel("Loading");
        label_29.setForeground(Color.BLACK);
        label_29.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_29.setBounds(680, 11, 44, 14);
        panel_13.add(label_29);

        label_30 = new JLabel("Weighting");
        label_30.setForeground(Color.BLACK);
        label_30.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_30.setBounds(572, 11, 57, 14);
        panel_13.add(label_30);

        label_31 = new JLabel("Compliance");
        label_31.setForeground(Color.BLACK);
        label_31.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_31.setBounds(462, 11, 65, 14);
        panel_13.add(label_31);

        JPanel panel_19 = new JPanel();
        panel_19.setLayout(null);
        tabbedPane.addTab("Page 4", null, panel_19, null);

        JPanel panel_20 = new JPanel();
        panel_20.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Investment Performance of the Fund Assets", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_20.setLayout(null);
        panel_20.setBounds(10, 27, 755, 164);
        panel_19.add(panel_20);

        JLabel lblClearlyDefinedMandates = new JLabel("<html>\r\nClearly defined mandates agreed between the<br>board and investment managers:\r\n</html>\r\n");
        lblClearlyDefinedMandates.setBounds(10, 22, 365, 25);
        panel_20.add(lblClearlyDefinedMandates);

        JLabel lblinvestmentPolicyStatement = new JLabel("<html><a href=\"\">Investment Policy Statement</a> documented, communicated to <br>\r\nstakeholders and reviewed annually</html>");
        lblinvestmentPolicyStatement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PDFReader.getInstance().openInternalDocument("/assets/docs/pf130/annB.pdf");
            }
        });
        lblinvestmentPolicyStatement.setBounds(10, 50, 365, 28);
        panel_20.add(lblinvestmentPolicyStatement);

        comboBox_46 = new JComboBox(compStrings);
        comboBox_46.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_46.setBounds(452, 22, 75, 20);
        panel_20.add(comboBox_46);

        comboBox_47 = new JComboBox(weigStrings);
        comboBox_47.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_47.setBounds(554, 22, 75, 20);
        panel_20.add(comboBox_47);

        textField_23 = new JTextField();
        textField_23.setEnabled(false);
        textField_23.setEditable(false);
        textField_23.setColumns(10);
        textField_23.setBounds(656, 22, 75, 20);
        panel_20.add(textField_23);

        comboBox_48 = new JComboBox(compStrings);
        comboBox_48.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_48.setBounds(452, 58, 75, 20);
        panel_20.add(comboBox_48);

        comboBox_49 = new JComboBox(weigStrings);
        comboBox_49.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_49.setBounds(554, 58, 75, 20);
        panel_20.add(comboBox_49);

        textField_24 = new JTextField();
        textField_24.setEnabled(false);
        textField_24.setEditable(false);
        textField_24.setColumns(10);
        textField_24.setBounds(656, 58, 75, 20);
        panel_20.add(textField_24);

        JLabel lblInvestmentPortfoliosRegularly = new JLabel("<html>Investment portfolios regularly reviewed by board to ensure they are <br>appropriate for the membership profile:</html>");
        lblInvestmentPortfoliosRegularly.setBounds(10, 89, 365, 25);
        panel_20.add(lblInvestmentPortfoliosRegularly);

        comboBox_52 = new JComboBox(compStrings);
        comboBox_52.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_52.setBounds(452, 89, 75, 20);
        panel_20.add(comboBox_52);

        comboBox_53 = new JComboBox(weigStrings);
        comboBox_53.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_53.setBounds(554, 89, 75, 20);
        panel_20.add(comboBox_53);

        textField_26 = new JTextField();
        textField_26.setEnabled(false);
        textField_26.setEditable(false);
        textField_26.setColumns(10);
        textField_26.setBounds(656, 89, 75, 20);
        panel_20.add(textField_26);

        JLabel lblProceduresDocumented = new JLabel("<html>Procedures documented & followed ensuring rights of members are <br>protected when assets are transferred:</html>");
        lblProceduresDocumented.setBounds(10, 125, 365, 25);
        panel_20.add(lblProceduresDocumented);

        comboBox_54 = new JComboBox(compStrings);
        comboBox_54.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_54.setBounds(452, 125, 75, 20);
        panel_20.add(comboBox_54);

        comboBox_55 = new JComboBox(weigStrings);
        comboBox_55.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_55.setBounds(554, 125, 75, 20);
        panel_20.add(comboBox_55);

        textField_27 = new JTextField();
        textField_27.setEnabled(false);
        textField_27.setEditable(false);
        textField_27.setColumns(10);
        textField_27.setBounds(656, 125, 75, 20);
        panel_20.add(textField_27);

        button_23 = new JButton("");
        button_23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle8para50.pdf");
            }
        });
        button_23.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_23.setBounds(410, 22, 33, 23);
        panel_20.add(button_23);

        button_24 = new JButton("");
        button_24.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle8para51.pdf");
            }
        });
        button_24.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_24.setBounds(410, 58, 33, 23);
        panel_20.add(button_24);

        button_26 = new JButton("");
        button_26.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle8para52.pdf");
            }
        });
        button_26.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_26.setBounds(410, 89, 33, 23);
        panel_20.add(button_26);

        button_27 = new JButton("");
        button_27.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle9para56to58.pdf");
            }
        });
        button_27.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_27.setBounds(410, 125, 33, 23);
        panel_20.add(button_27);

        JPanel panel_24 = new JPanel();
        panel_24.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Stakeholder Relationships, Communication and Access to Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_24.setLayout(null);
        panel_24.setBounds(10, 202, 755, 218);
        panel_19.add(panel_24);

        JLabel lblpolicyInPlace = new JLabel("<html>Policy in place to ensure confidentiality and ownership of information:</html>\r\n");
        lblpolicyInPlace.setBounds(10, 22, 365, 14);
        panel_24.add(lblpolicyInPlace);

        JLabel lblcommunicationPolicyIn = new JLabel("<html>Communication policy in place to ensure members and beneficiaries have access to appropriate information:</html>");
        lblcommunicationPolicyIn.setBounds(10, 47, 365, 29);
        panel_24.add(lblcommunicationPolicyIn);

        comboBox_56 = new JComboBox(compStrings);
        comboBox_56.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_56.setBounds(451, 16, 75, 20);
        panel_24.add(comboBox_56);

        comboBox_57 = new JComboBox(weigStrings);
        comboBox_57.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_57.setBounds(553, 16, 75, 20);
        panel_24.add(comboBox_57);

        textField_28 = new JTextField();
        textField_28.setEnabled(false);
        textField_28.setEditable(false);
        textField_28.setColumns(10);
        textField_28.setBounds(655, 16, 75, 20);
        panel_24.add(textField_28);

        comboBox_58 = new JComboBox(compStrings);
        comboBox_58.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_58.setBounds(451, 47, 75, 20);
        panel_24.add(comboBox_58);

        comboBox_59 = new JComboBox(weigStrings);
        comboBox_59.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        comboBox_59.setBounds(553, 47, 75, 20);
        panel_24.add(comboBox_59);

        textField_29 = new JTextField();
        textField_29.setEnabled(false);
        textField_29.setEditable(false);
        textField_29.setColumns(10);
        textField_29.setBounds(655, 47, 75, 20);
        panel_24.add(textField_29);

        button_28 = new JButton("");
        button_28.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle9para56to58.pdf");
            }
        });
        button_28.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_28.setBounds(408, 15, 33, 23);
        panel_24.add(button_28);

        button_29 = new JButton("");
        button_29.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle9para59to60.pdf");
            }
        });
        button_29.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_29.setBounds(408, 47, 33, 23);
        panel_24.add(button_29);

        JButton button_30 = new JButton("");
        button_30.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle10para61to65.pdf");
            }
        });
        button_30.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_30.setBounds(408, 81, 33, 23);
        panel_24.add(button_30);

        comboBox_67 = new JComboBox(new Object[]{});
        comboBox_67.setModel(new DefaultComboBoxModel(new String[]{"Minimal", "Partial", "Full"}));
        comboBox_67.setBounds(451, 78, 75, 20);
        panel_24.add(comboBox_67);

        comboBox_66 = new JComboBox(new Object[]{});
        comboBox_66.setModel(new DefaultComboBoxModel(new String[]{"Light", "Medium", "Heavy"}));
        comboBox_66.setBounds(553, 78, 75, 20);
        panel_24.add(comboBox_66);

        textField_31 = new JTextField();
        textField_31.setEnabled(false);
        textField_31.setEditable(false);
        textField_31.setColumns(10);
        textField_31.setBounds(655, 78, 75, 20);
        panel_24.add(textField_31);

        button_31 = new JButton("");
        button_31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle11para66to69.pdf");
            }
        });
        button_31.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_31.setBounds(408, 109, 33, 23);
        panel_24.add(button_31);

        comboBox_62 = new JComboBox(new Object[]{});
        comboBox_62.setModel(new DefaultComboBoxModel(new String[]{"Minimal", "Partial", "Full"}));
        comboBox_62.setBounds(451, 112, 75, 20);
        panel_24.add(comboBox_62);

        comboBox_63 = new JComboBox(new Object[]{});
        comboBox_63.setModel(new DefaultComboBoxModel(new String[]{"Light", "Medium", "Heavy"}));
        comboBox_63.setBounds(553, 112, 75, 20);
        panel_24.add(comboBox_63);

        textField_32 = new JTextField();
        textField_32.setEnabled(false);
        textField_32.setEditable(false);
        textField_32.setColumns(10);
        textField_32.setBounds(655, 112, 75, 20);
        panel_24.add(textField_32);

        button_25 = new JButton("");
        button_25.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle13para76.pdf");
            }
        });
        button_25.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_25.setBounds(408, 180, 33, 23);
        panel_24.add(button_25);

        button_32 = new JButton("");
        button_32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                PDFReader.getInstance().openInternalDocument("/assets/docs/long/principle12para70to75.pdf");
            }
        });
        button_32.setIcon(new ImageIcon(RiskLoadingPanel.class.getResource("/assets/icons/lifebuoy_16.png")));
        button_32.setBounds(408, 146, 33, 23);
        panel_24.add(button_32);

        comboBox_50 = new JComboBox(new Object[]{});
        comboBox_50.setModel(new DefaultComboBoxModel(new String[]{"Minimal", "Partial", "Full"}));
        comboBox_50.setBounds(451, 146, 75, 20);
        panel_24.add(comboBox_50);

        comboBox_51 = new JComboBox(new Object[]{});
        comboBox_51.setModel(new DefaultComboBoxModel(new String[]{"Light", "Medium", "Heavy"}));
        comboBox_51.setBounds(553, 146, 75, 20);
        panel_24.add(comboBox_51);

        textField_25 = new JTextField();
        textField_25.setEnabled(false);
        textField_25.setEditable(false);
        textField_25.setColumns(10);
        textField_25.setBounds(655, 146, 75, 20);
        panel_24.add(textField_25);

        textField_33 = new JTextField();
        textField_33.setEnabled(false);
        textField_33.setEditable(false);
        textField_33.setColumns(10);
        textField_33.setBounds(655, 180, 75, 20);
        panel_24.add(textField_33);

        comboBox_64 = new JComboBox(new Object[]{});
        comboBox_64.setModel(new DefaultComboBoxModel(new String[]{"Light", "Medium", "Heavy"}));
        comboBox_64.setBounds(553, 180, 75, 20);
        panel_24.add(comboBox_64);

        comboBox_65 = new JComboBox(new Object[]{});
        comboBox_65.setModel(new DefaultComboBoxModel(new String[]{"Minimal", "Partial", "Full"}));
        comboBox_65.setBounds(451, 180, 75, 20);
        panel_24.add(comboBox_65);

        lblmembersAndBeneficiaries = new JLabel("<html>Members and beneficiaries effectively communicated to and have thier rights protected</html>");
        lblmembersAndBeneficiaries.setBounds(10, 78, 365, 29);
        panel_24.add(lblmembersAndBeneficiaries);

        lblrelationshipBetweenThe = new JLabel("<html>Relationship between the board and the employer and sponsor is independent</html>");
        lblrelationshipBetweenThe.setBounds(10, 112, 365, 29);
        panel_24.add(lblrelationshipBetweenThe);

        lblpolicyInPlace_1 = new JLabel("<html>Policy in place for appointment, communication and monitoring of service providers</html>");
        lblpolicyInPlace_1.setBounds(10, 149, 388, 29);
        panel_24.add(lblpolicyInPlace_1);

        lblrequirementsOfRequlatory = new JLabel("<html>Requirements of requlatory authority complied with and queries dealt with expeditiously</html>");
        lblrequirementsOfRequlatory.setBounds(10, 180, 365, 29);
        panel_24.add(lblrequirementsOfRequlatory);

        label_35 = new JLabel("Please complete pages 1 to 4");
        label_35.setForeground(new Color(210, 105, 30));
        label_35.setBounds(10, 2, 150, 14);
        panel_19.add(label_35);

        label_36 = new JLabel("Loading");
        label_36.setForeground(Color.BLACK);
        label_36.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_36.setBounds(681, 11, 44, 14);
        panel_19.add(label_36);

        label_37 = new JLabel("Weighting");
        label_37.setForeground(Color.BLACK);
        label_37.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_37.setBounds(573, 11, 57, 14);
        panel_19.add(label_37);

        label_38 = new JLabel("Compliance");
        label_38.setForeground(Color.BLACK);
        label_38.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_38.setBounds(463, 11, 65, 14);
        panel_19.add(label_38);

        textField_30 = new JTextField();
        textField_30.setEditable(false);
        textField_30.setBounds(684, 459, 86, 20);
        add(textField_30);
        textField_30.setColumns(10);

        JLabel lblNewLabel = new JLabel("Calculated loading to be applied to basic recommended indemnity sum assured:");
        lblNewLabel.setBounds(295, 462, 378, 14);
        add(lblNewLabel);

    }

    public JTextField getTextField_5() {
        return textField_5;
    }

    public JComboBox getComboBox_4() {
        return comboBox_4;
    }

    public JTextField getTextField_1() {
        return textField_1;
    }

    public JComboBox getComboBox_10() {
        return comboBox_10;
    }

    public JComboBox getComboBox_14() {
        return comboBox_14;
    }

    public JComboBox getComboBox_5() {
        return comboBox_5;
    }

    public JComboBox getComboBox_8() {
        return comboBox_8;
    }

    public JComboBox getComboBox_15() {
        return comboBox_15;
    }

    public JComboBox getComboBox_13() {
        return comboBox_13;
    }

    public JComboBox getComboBox_3() {
        return comboBox_3;
    }

    public JTextField getTextField_2() {
        return textField_2;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JComboBox getComboBox_12() {
        return comboBox_12;
    }

    public JTextField getTextField_6() {
        return textField_6;
    }

    public JTextField getTextField_3() {
        return textField_3;
    }

    public JComboBox getComboBox_2() {
        return comboBox_2;
    }

    public JComboBox getComboBox_6() {
        return comboBox_6;
    }

    public JComboBox getComboBox_11() {
        return comboBox_11;
    }

    public JTextField getTextField_4() {
        return textField_4;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JComboBox getComboBox_9() {
        return comboBox_9;
    }

    public JComboBox getComboBox_1() {
        return comboBox_1;
    }

    public JTextField getTextField_7() {
        return textField_7;
    }

    public JComboBox getComboBox_7() {
        return comboBox_7;
    }

    public JTextField getTextField_9() {
        return textField_9;
    }

    public JTextField getTextField_12() {
        return textField_12;
    }

    public JComboBox getComboBox_23() {
        return comboBox_23;
    }

    public JComboBox getComboBox_25() {
        return comboBox_25;
    }

    public JComboBox getComboBox_17() {
        return comboBox_17;
    }

    public JComboBox getComboBox_24() {
        return comboBox_24;
    }

    public JTextField getTextField_8() {
        return textField_8;
    }

    public JComboBox getComboBox_20() {
        return comboBox_20;
    }

    public JComboBox getComboBox_29() {
        return comboBox_29;
    }

    public JTextField getTextField_14() {
        return textField_14;
    }

    public JComboBox getComboBox_27() {
        return comboBox_27;
    }

    public JComboBox getComboBox_31() {
        return comboBox_31;
    }

    public JTextField getTextField_15() {
        return textField_15;
    }

    public JComboBox getComboBox_19() {
        return comboBox_19;
    }

    public JTextField getTextField_11() {
        return textField_11;
    }

    public JComboBox getComboBox_16() {
        return comboBox_16;
    }

    public JComboBox getComboBox_22() {
        return comboBox_22;
    }

    public JTextField getTextField_10() {
        return textField_10;
    }

    public JComboBox getComboBox_30() {
        return comboBox_30;
    }

    public JComboBox getComboBox_28() {
        return comboBox_28;
    }

    public JComboBox getComboBox_18() {
        return comboBox_18;
    }

    public JComboBox getComboBox_21() {
        return comboBox_21;
    }

    public JTextField getTextField_13() {
        return textField_13;
    }

    public JComboBox getComboBox_26() {
        return comboBox_26;
    }

    public JComboBox getComboBox_41() {
        return comboBox_41;
    }

    public JComboBox getComboBox_43() {
        return comboBox_43;
    }

    public JComboBox getComboBox_39() {
        return comboBox_39;
    }

    public JComboBox getComboBox_38() {
        return comboBox_38;
    }

    public JTextField getTextField_19() {
        return textField_19;
    }

    public JComboBox getComboBox_44() {
        return comboBox_44;
    }

    public JComboBox getComboBox_40() {
        return comboBox_40;
    }

    public JTextField getTextField_21() {
        return textField_21;
    }

    public JComboBox getComboBox_34() {
        return comboBox_34;
    }

    public JComboBox getComboBox_42() {
        return comboBox_42;
    }

    public JComboBox getComboBox_35() {
        return comboBox_35;
    }

    public JTextField getTextField_18() {
        return textField_18;
    }

    public JComboBox getComboBox_36() {
        return comboBox_36;
    }

    public JTextField getTextField_16() {
        return textField_16;
    }

    public JTextField getTextField_22() {
        return textField_22;
    }

    public JComboBox getComboBox_32() {
        return comboBox_32;
    }

    public JComboBox getComboBox_33() {
        return comboBox_33;
    }

    public JTextField getTextField_17() {
        return textField_17;
    }

    public JComboBox getComboBox_45() {
        return comboBox_45;
    }

    public JComboBox getComboBox_37() {
        return comboBox_37;
    }

    public JTextField getTextField_20() {
        return textField_20;
    }

    public JComboBox getComboBox_46() {
        return comboBox_46;
    }

    public JComboBox getComboBox_52() {
        return comboBox_52;
    }

    public JTextField getTextField_29() {
        return textField_29;
    }

    public JTextField getTextField_28() {
        return textField_28;
    }

    public JTextField getTextField_23() {
        return textField_23;
    }

    public JComboBox getComboBox_54() {
        return comboBox_54;
    }

    public JTextField getTextField_27() {
        return textField_27;
    }

    public JComboBox getComboBox_53() {
        return comboBox_53;
    }

    public JComboBox getComboBox_48() {
        return comboBox_48;
    }

    public JTextField getTextField_26() {
        return textField_26;
    }

    public JTextField getTextField_24() {
        return textField_24;
    }

    public JComboBox getComboBox_55() {
        return comboBox_55;
    }

    public JComboBox getComboBox_59() {
        return comboBox_59;
    }

    public JComboBox getComboBox_49() {
        return comboBox_49;
    }

    public JComboBox getComboBox_51() {
        return comboBox_51;
    }

    public JComboBox getComboBox_56() {
        return comboBox_56;
    }

    public JComboBox getComboBox_50() {
        return comboBox_50;
    }

    public JComboBox getComboBox_57() {
        return comboBox_57;
    }

    public JTextField getTextField_25() {
        return textField_25;
    }

    public JComboBox getComboBox_47() {
        return comboBox_47;
    }

    public JComboBox getComboBox_58() {
        return comboBox_58;
    }

    public JTextField getTextField_30() {
        return textField_30;
    }

    public JComboBox getComboBox_63() {
        return comboBox_63;
    }

    public JComboBox getComboBox_66() {
        return comboBox_66;
    }

    public JComboBox getComboBox_65() {
        return comboBox_65;
    }

    public JComboBox getComboBox_62() {
        return comboBox_62;
    }

    public JComboBox getComboBox_67() {
        return comboBox_67;
    }

    public JComboBox getComboBox_64() {
        return comboBox_64;
    }

    public JTextField getTextField_32() {
        return textField_32;
    }

    public JTextField getTextField_33() {
        return textField_33;
    }

    public JTextField getTextField_31() {
        return textField_31;
    }
}
