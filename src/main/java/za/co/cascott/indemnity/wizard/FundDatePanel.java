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

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class FundDatePanel extends JPanel {
    private JTextField annPremium;
    private JTextField indemnityLimit;
    private JTextField firstAmount;
    private JTextField highClaim;
    private JTextField aggClaim;
    private JTextField noPortfolios;
    private JTextField fundName;
    private JTextField noMembers;
    private JTextField annCons;
    private JTextField valInvest;
    private JTextField db1;
    private JTextField db2;
    private JTextField db3;
    private JTextField db4;
    private JTextField db5;
    private JTextField db10;
    private JTextField db9;
    private JTextField db7;
    private JTextField db6;
    private JTextField db8;
    private JTextField ms1;
    private JTextField ms2;
    private JTextField ms3;
    private JTextField ms4;
    private JTextField ms5;
    private JTextField ms10;
    private JTextField ms9;
    private JTextField ms7;
    private JTextField ms6;
    private JTextField ms8;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton preservationFundNo;
    private JRadioButton preservationFundYes;
    private JComboBox investmentChoice;
    private JComboBox claimsYN;
    private JComboBox noDeathBens;
    private JComboBox noMbrShares;
    private JDateChooser effectiveDate;
    private JDateChooser coverFrom;
    private JDateChooser coverTo;
    private JDateChooser retroDate;
    private JTextField partEmp;
    private JLabel db5_lbl;
    private JLabel db8_lbl;
    private JLabel db1_lbl;
    private JLabel db2_lbl;
    private JLabel db7_lbl;
    private JLabel db10_lbl;
    private JLabel db4_lbl;
    private JLabel db6_lbl;
    private JLabel db3_lbl;
    private JLabel db9_lbl;
    private JLabel ms4_lbl;
    private JLabel ms10_lbl;
    private JLabel ms5_lbl;
    private JLabel ms6_lbl;
    private JLabel ms1_lbl;
    private JLabel ms9_lbl;
    private JLabel ms8_lbl;
    private JLabel ms3_lbl;
    private JLabel ms2_lbl;
    private JLabel ms7_lbl;

    /**
     * @param effectiveDate the effectiveDate to set
     */
    public void setEffectiveDate(JDateChooser effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * @param coverFrom the coverFrom to set
     */
    public void setCoverFrom(JDateChooser coverFrom) {
        this.coverFrom = coverFrom;
    }

    /**
     * @param coverTo the coverTo to set
     */
    public void setCoverTo(JDateChooser coverTo) {
        this.coverTo = coverTo;
    }

    /**
     * @param retroDate the retroDate to set
     */
    public void setRetroDate(JDateChooser retroDate) {
        this.retroDate = retroDate;
    }

    /**
     * Create the panel.
     */
    public FundDatePanel() {
        this.effectiveDate = new JDateChooser(new Date());
        this.coverFrom = new JDateChooser(new Date());
        this.coverTo = new JDateChooser(new Date());
        this.retroDate = new JDateChooser(new Date());

        //Set date format
        String simpleDateString = "dd/MM/yyyy";
        this.retroDate.setDateFormatString(simpleDateString);
        this.coverTo.setDateFormatString(simpleDateString);
        this.coverFrom.setDateFormatString(simpleDateString);
        this.effectiveDate.setDateFormatString(simpleDateString);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setSize(new Dimension(668, 474));
        add(tabbedPane);

        JPanel panel = new JPanel();
        tabbedPane.addTab("Page 1", null, panel, null);
        panel.setLayout(null);

        JLabel label = new JLabel("Name of Fund:");
        label.setBounds(11, 14, 71, 14);
        panel.add(label);

        JLabel label_1 = new JLabel("Preservation Fund:");
        label_1.setBounds(436, 15, 92, 14);
        panel.add(label_1);

        JLabel lblEffectiveDateOf = new JLabel("Effective date of underlying data used to calculate basic sum assured");
        lblEffectiveDateOf.setBounds(11, 39, 342, 21);
        panel.add(lblEffectiveDateOf);

        JLabel label_3 = new JLabel("");
        label_3.setBounds(11, 71, 71, 0);
        panel.add(label_3);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Existing cover", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setLayout(null);
        panel_1.setBounds(10, 89, 619, 149);
        panel.add(panel_1);

        JLabel label_4 = new JLabel("Insurance cover from ");
        label_4.setBounds(10, 22, 106, 14);
        panel_1.add(label_4);

        JLabel label_5 = new JLabel("Annual premium ");
        label_5.setBounds(10, 47, 106, 14);
        panel_1.add(label_5);

        JLabel label_6 = new JLabel("Indemnity limit ");
        label_6.setBounds(10, 72, 106, 14);
        panel_1.add(label_6);

        JLabel label_7 = new JLabel("First amount payable ");
        label_7.setBounds(10, 97, 106, 14);
        panel_1.add(label_7);

        annPremium = new JTextField();
        annPremium.setHorizontalAlignment(SwingConstants.RIGHT);
        annPremium.setColumns(10);
        annPremium.setBounds(126, 44, 86, 20);
        panel_1.add(annPremium);

        indemnityLimit = new JTextField();
        indemnityLimit.setHorizontalAlignment(SwingConstants.RIGHT);
        indemnityLimit.setColumns(10);
        indemnityLimit.setBounds(126, 69, 86, 20);
        panel_1.add(indemnityLimit);

        firstAmount = new JTextField();
        firstAmount.setHorizontalAlignment(SwingConstants.RIGHT);
        firstAmount.setColumns(10);
        firstAmount.setBounds(126, 94, 86, 20);
        panel_1.add(firstAmount);

        JLabel label_8 = new JLabel("to");
        label_8.setBounds(241, 22, 21, 14);
        panel_1.add(label_8);

        JLabel label_9 = new JLabel("Retroactive date ");
        label_9.setBounds(388, 22, 86, 14);
        panel_1.add(label_9);

        JLabel label_10 = new JLabel("Have there been any claims in the last six years?");
        label_10.setBounds(240, 47, 234, 14);
        panel_1.add(label_10);

        JLabel label_11 = new JLabel("What was the highest claim, if any?");
        label_11.setBounds(240, 72, 234, 14);
        panel_1.add(label_11);

        JLabel label_12 = new JLabel("Aggregate of total claims in any one year, if any?");
        label_12.setBounds(240, 97, 237, 14);
        panel_1.add(label_12);

        claimsYN = new JComboBox();
        claimsYN.setBounds(505, 44, 86, 20);
        panel_1.add(claimsYN);

        highClaim = new JTextField();
        highClaim.setHorizontalAlignment(SwingConstants.RIGHT);
        highClaim.setColumns(10);
        highClaim.setBounds(505, 69, 86, 20);
        panel_1.add(highClaim);

        aggClaim = new JTextField();
        aggClaim.setHorizontalAlignment(SwingConstants.RIGHT);
        aggClaim.setColumns(10);
        aggClaim.setBounds(505, 94, 86, 20);
        panel_1.add(aggClaim);

        JLabel label_13 = new JLabel("R");
        label_13.setBounds(487, 97, 15, 14);
        panel_1.add(label_13);

        JLabel label_14 = new JLabel("R");
        label_14.setBounds(487, 72, 15, 14);
        panel_1.add(label_14);

        this.coverFrom.getCalendarButton().setIcon(new ImageIcon(FundDatePanel.class.getResource("/assets/icons/calendar-month.png")));
        this.coverFrom.setBounds(126, 20, 86, 20);
        panel_1.add(this.coverFrom);

        this.coverTo.getCalendarButton().setIcon(new ImageIcon(FundDatePanel.class.getResource("/assets/icons/calendar-month.png")));
        this.coverTo.setBounds(272, 22, 106, 20);
        panel_1.add(this.coverTo);

        this.retroDate.getCalendarButton().setIcon(new ImageIcon(FundDatePanel.class.getResource("/assets/icons/calendar-month.png")));
        this.retroDate.setBounds(505, 22, 86, 20);
        panel_1.add(this.retroDate);

        JLabel label_15 = new JLabel("No of participating employers ");
        label_15.setBounds(11, 70, 149, 14);
        panel.add(label_15);

        JLabel label_16 = new JLabel("Member investment choice ");
        label_16.setBounds(197, 70, 130, 14);
        panel.add(label_16);

        investmentChoice = new JComboBox();
        investmentChoice.setBounds(332, 64, 43, 20);
        panel.add(investmentChoice);

        JLabel label_17 = new JLabel("Number of investment portfolios");
        label_17.setBounds(385, 70, 168, 14);
        panel.add(label_17);

        noPortfolios = new JTextField();
        noPortfolios.setColumns(10);
        noPortfolios.setBounds(547, 67, 33, 20);
        panel.add(noPortfolios);

        fundName = new JTextField();
        fundName.setColumns(10);
        fundName.setBounds(93, 11, 333, 20);
        fundName.setInputVerifier(new NotEmptyVerifier(fundName));
        panel.add(fundName);

        JPanel panel_6 = new JPanel();
        panel_6.setBounds(535, 11, 94, 20);
        panel.add(panel_6);
        panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

        preservationFundNo = new JRadioButton("No");
        buttonGroup.add(preservationFundNo);
        panel_6.add(preservationFundNo);

        preservationFundYes = new JRadioButton("Yes");
        buttonGroup.add(preservationFundYes);
        panel_6.add(preservationFundYes);

        partEmp = new JTextField();
        partEmp.setBounds(154, 67, 33, 20);
        panel.add(partEmp);
        partEmp.setColumns(10);

        this.effectiveDate.getCalendarButton().setIcon(new ImageIcon(FundDatePanel.class.getResource("/assets/icons/calendar-month.png")));
        this.effectiveDate.setBounds(371, 40, 91, 20);
        panel.add(this.effectiveDate);

        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Page 2", null, panel_2, null);
        panel_2.setLayout(null);

        JLabel label_18 = new JLabel("Number of Members");
        label_18.setBounds(10, 14, 96, 14);
        panel_2.add(label_18);

        JLabel label_19 = new JLabel("Annual Contributions R");
        label_19.setBounds(174, 14, 110, 14);
        panel_2.add(label_19);

        JLabel label_20 = new JLabel("Value of Investments R");
        label_20.setBounds(370, 14, 112, 14);
        panel_2.add(label_20);

        noMembers = new JTextField();
        noMembers.setColumns(10);
        noMembers.setBounds(116, 11, 48, 20);
        panel_2.add(noMembers);

        annCons = new JTextField();
        annCons.setHorizontalAlignment(SwingConstants.RIGHT);
        annCons.setColumns(10);
        annCons.setBounds(294, 11, 66, 20);
        panel_2.add(annCons);

        valInvest = new JTextField();
        valInvest.setHorizontalAlignment(SwingConstants.RIGHT);
        valInvest.setColumns(10);
        valInvest.setBounds(492, 11, 86, 20);
        panel_2.add(valInvest);

        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBounds(10, 39, 619, 257);
        panel_2.add(panel_3);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Top 10 Death Benefit Sums Assured", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_4.setLayout(null);
        panel_4.setBounds(0, 0, 309, 215);
        panel_3.add(panel_4);

        JLabel label_21 = new JLabel("Number of Death Benefits to be entered");
        label_21.setBounds(10, 21, 193, 14);
        panel_4.add(label_21);

        noDeathBens = new JComboBox();
        noDeathBens.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(noDeathBens.getSelectedItem().toString());

                if (a > 1) {
                    db2.setVisible(true);
                    db2_lbl.setVisible(true);
                } else {
                    db2.setVisible(false);
                    db2_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 2) {
                    db3.setVisible(true);
                    db3_lbl.setVisible(true);
                } else {
                    db3.setVisible(false);
                    db3_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 3) {
                    db4.setVisible(true);
                    db4_lbl.setVisible(true);
                } else {
                    db4.setVisible(false);
                    db4_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 4) {
                    db5.setVisible(true);
                    db5_lbl.setVisible(true);
                } else {
                    db5.setVisible(false);
                    db5_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 5) {
                    db6.setVisible(true);
                    db6_lbl.setVisible(true);
                } else {
                    db6.setVisible(false);
                    db6_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 6) {
                    db7.setVisible(true);
                    db7_lbl.setVisible(true);
                } else {
                    db7.setVisible(false);
                    db7_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 7) {
                    db8.setVisible(true);
                    db8_lbl.setVisible(true);
                } else {
                    db8.setVisible(false);
                    db8_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 8) {
                    db9.setVisible(true);
                    db9_lbl.setVisible(true);
                } else {
                    db9.setVisible(false);
                    db9_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 9) {
                    db10.setVisible(true);
                    db10_lbl.setVisible(true);
                } else {
                    db10.setVisible(false);
                    db10_lbl.setVisible(false);
                }
            }
        });
        noDeathBens.setBounds(213, 18, 50, 20);
        panel_4.add(noDeathBens);

        db1_lbl = new JLabel("1st: R");
        db1_lbl.setBounds(10, 49, 34, 14);
        panel_4.add(db1_lbl);

        db1 = new JTextField();
        db1.setHorizontalAlignment(SwingConstants.RIGHT);
        db1.setColumns(10);
        db1.setBounds(54, 46, 61, 20);
        panel_4.add(db1);

        db2_lbl = new JLabel("2nd: R");
        db2_lbl.setBounds(10, 77, 34, 14);
        panel_4.add(db2_lbl);

        db2 = new JTextField();
        db2.setHorizontalAlignment(SwingConstants.RIGHT);
        db2.setColumns(10);
        db2.setBounds(54, 74, 61, 20);
        panel_4.add(db2);

        db3_lbl = new JLabel("3rd: R");
        db3_lbl.setBounds(10, 105, 34, 14);
        panel_4.add(db3_lbl);

        db3 = new JTextField();
        db3.setHorizontalAlignment(SwingConstants.RIGHT);
        db3.setColumns(10);
        db3.setBounds(54, 102, 61, 20);
        panel_4.add(db3);

        db4_lbl = new JLabel("4th: R");
        db4_lbl.setBounds(10, 133, 34, 14);
        panel_4.add(db4_lbl);

        db4 = new JTextField();
        db4.setHorizontalAlignment(SwingConstants.RIGHT);
        db4.setColumns(10);
        db4.setBounds(54, 130, 61, 20);
        panel_4.add(db4);

        db5_lbl = new JLabel("5th: R");
        db5_lbl.setBounds(10, 161, 34, 14);
        panel_4.add(db5_lbl);

        db5 = new JTextField();
        db5.setHorizontalAlignment(SwingConstants.RIGHT);
        db5.setColumns(10);
        db5.setBounds(54, 158, 61, 20);
        panel_4.add(db5);

        db10 = new JTextField();
        db10.setHorizontalAlignment(SwingConstants.RIGHT);
        db10.setColumns(10);
        db10.setBounds(169, 158, 61, 20);
        panel_4.add(db10);

        db9 = new JTextField();
        db9.setHorizontalAlignment(SwingConstants.RIGHT);
        db9.setColumns(10);
        db9.setBounds(169, 130, 61, 20);
        panel_4.add(db9);

        db7 = new JTextField();
        db7.setHorizontalAlignment(SwingConstants.RIGHT);
        db7.setColumns(10);
        db7.setBounds(169, 74, 61, 20);
        panel_4.add(db7);

        db6 = new JTextField();
        db6.setHorizontalAlignment(SwingConstants.RIGHT);
        db6.setColumns(10);
        db6.setBounds(169, 46, 61, 20);
        panel_4.add(db6);

        db8 = new JTextField();
        db8.setHorizontalAlignment(SwingConstants.RIGHT);
        db8.setColumns(10);
        db8.setBounds(169, 102, 61, 20);
        panel_4.add(db8);

        db8_lbl = new JLabel("8th: R");
        db8_lbl.setBounds(125, 105, 34, 14);
        panel_4.add(db8_lbl);

        db7_lbl = new JLabel("7th: R");
        db7_lbl.setBounds(125, 77, 34, 14);
        panel_4.add(db7_lbl);

        db6_lbl = new JLabel("6th: R");
        db6_lbl.setBounds(125, 49, 34, 14);
        panel_4.add(db6_lbl);

        db9_lbl = new JLabel("9th: R");
        db9_lbl.setBounds(125, 133, 34, 14);
        panel_4.add(db9_lbl);

        db10_lbl = new JLabel("10th: R");
        db10_lbl.setBounds(125, 161, 44, 14);
        panel_4.add(db10_lbl);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, null), "Top 10 Member Shares", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setLayout(null);
        panel_5.setBounds(309, 0, 309, 215);
        panel_3.add(panel_5);

        ms1_lbl = new JLabel("1st: R");
        ms1_lbl.setBounds(10, 51, 34, 14);
        panel_5.add(ms1_lbl);

        ms1 = new JTextField();
        ms1.setHorizontalAlignment(SwingConstants.RIGHT);
        ms1.setColumns(10);
        ms1.setBounds(54, 48, 61, 20);
        panel_5.add(ms1);

        ms2_lbl = new JLabel("2nd: R");
        ms2_lbl.setBounds(10, 79, 34, 14);
        panel_5.add(ms2_lbl);

        ms2 = new JTextField();
        ms2.setHorizontalAlignment(SwingConstants.RIGHT);
        ms2.setColumns(10);
        ms2.setBounds(54, 76, 61, 20);
        panel_5.add(ms2);

        ms3_lbl = new JLabel("3rd: R");
        ms3_lbl.setBounds(10, 107, 34, 14);
        panel_5.add(ms3_lbl);

        ms3 = new JTextField();
        ms3.setHorizontalAlignment(SwingConstants.RIGHT);
        ms3.setColumns(10);
        ms3.setBounds(54, 104, 61, 20);
        panel_5.add(ms3);

        ms4_lbl = new JLabel("4th: R");
        ms4_lbl.setBounds(10, 135, 34, 14);
        panel_5.add(ms4_lbl);

        ms4 = new JTextField();
        ms4.setHorizontalAlignment(SwingConstants.RIGHT);
        ms4.setColumns(10);
        ms4.setBounds(54, 132, 61, 20);
        panel_5.add(ms4);

        ms5_lbl = new JLabel("5th: R");
        ms5_lbl.setBounds(10, 163, 34, 14);
        panel_5.add(ms5_lbl);

        ms5 = new JTextField();
        ms5.setHorizontalAlignment(SwingConstants.RIGHT);
        ms5.setColumns(10);
        ms5.setBounds(54, 160, 61, 20);
        panel_5.add(ms5);

        ms10 = new JTextField();
        ms10.setHorizontalAlignment(SwingConstants.RIGHT);
        ms10.setColumns(10);
        ms10.setBounds(169, 160, 61, 20);
        panel_5.add(ms10);

        ms9 = new JTextField();
        ms9.setHorizontalAlignment(SwingConstants.RIGHT);
        ms9.setColumns(10);
        ms9.setBounds(169, 132, 61, 20);
        panel_5.add(ms9);

        ms7 = new JTextField();
        ms7.setHorizontalAlignment(SwingConstants.RIGHT);
        ms7.setColumns(10);
        ms7.setBounds(169, 76, 61, 20);
        panel_5.add(ms7);

        ms6 = new JTextField();
        ms6.setHorizontalAlignment(SwingConstants.RIGHT);
        ms6.setColumns(10);
        ms6.setBounds(169, 48, 61, 20);
        panel_5.add(ms6);

        ms8 = new JTextField();
        ms8.setHorizontalAlignment(SwingConstants.CENTER);
        ms8.setColumns(10);
        ms8.setBounds(169, 104, 61, 20);
        panel_5.add(ms8);

        ms8_lbl = new JLabel("8th: R");
        ms8_lbl.setBounds(125, 107, 34, 14);
        panel_5.add(ms8_lbl);

        ms7_lbl = new JLabel("7th: R");
        ms7_lbl.setBounds(125, 79, 34, 14);
        panel_5.add(ms7_lbl);

        ms6_lbl = new JLabel("6th: R");
        ms6_lbl.setBounds(125, 51, 34, 14);
        panel_5.add(ms6_lbl);

        ms9_lbl = new JLabel("9th: R");
        ms9_lbl.setBounds(125, 135, 34, 14);
        panel_5.add(ms9_lbl);

        ms10_lbl = new JLabel("10th: R");
        ms10_lbl.setBounds(125, 163, 44, 14);
        panel_5.add(ms10_lbl);

        JLabel label_42 = new JLabel("Number of Member Shares to be entered");
        label_42.setBounds(10, 25, 196, 14);
        panel_5.add(label_42);

        noMbrShares = new JComboBox();
        noMbrShares.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(noMbrShares.getSelectedItem().toString());

                if (a > 1) {
                    ms2.setVisible(true);
                    ms2_lbl.setVisible(true);
                } else {
                    ms2.setVisible(false);
                    ms2_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 2) {
                    ms3.setVisible(true);
                    ms3_lbl.setVisible(true);
                } else {
                    ms3.setVisible(false);
                    ms3_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 3) {
                    ms4.setVisible(true);
                    ms4_lbl.setVisible(true);
                } else {
                    ms4.setVisible(false);
                    ms4_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 4) {
                    ms5.setVisible(true);
                    ms5_lbl.setVisible(true);
                } else {
                    ms5.setVisible(false);
                    ms5_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 5) {
                    ms6.setVisible(true);
                    ms6_lbl.setVisible(true);
                } else {
                    ms6.setVisible(false);
                    ms6_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 6) {
                    ms7.setVisible(true);
                    ms7_lbl.setVisible(true);
                } else {
                    ms7.setVisible(false);
                    ms7_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 7) {
                    ms8.setVisible(true);
                    ms8_lbl.setVisible(true);
                } else {
                    ms8.setVisible(false);
                    ms8_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 8) {
                    ms9.setVisible(true);
                    ms9_lbl.setVisible(true);
                } else {
                    ms9.setVisible(false);
                    ms9_lbl.setVisible(false);
                }
                ///////////////////////////////
                if (a > 9) {
                    ms10.setVisible(true);
                    ms10_lbl.setVisible(true);
                } else {
                    ms10.setVisible(false);
                    ms10_lbl.setVisible(false);
                }
            }
        });
        noMbrShares.setBounds(213, 22, 50, 20);
        panel_5.add(noMbrShares);
    }

    public JTextField getFundName() {
        return fundName;
    }

    public JRadioButton getPreservationFundNo() {
        return preservationFundNo;
    }

    public JRadioButton getPreservationFundYes() {
        return preservationFundYes;
    }

    public JDateChooser getEffectiveDate() {
        return effectiveDate;
    }

    public JTextField getPartEmp() {
        return partEmp;
    }

    public JComboBox getInvestmentChoice() {
        return investmentChoice;
    }

    public JTextField getNoPortfolios() {
        return noPortfolios;
    }

    public JDateChooser getCoverFrom() {
        return coverFrom;
    }

    public JDateChooser getCoverTo() {
        return coverTo;
    }

    public JDateChooser getRetroDate() {
        return retroDate;
    }

    public JTextField getAnnPremium() {
        return annPremium;
    }

    public JComboBox getClaimsYN() {
        return claimsYN;
    }

    public JTextField getIndemnityLimit() {
        return indemnityLimit;
    }

    public JTextField getHighClaim() {
        return highClaim;
    }

    public JTextField getFirstAmount() {
        return firstAmount;
    }

    public JTextField getAggClaim() {
        return aggClaim;
    }

    public JTextField getNoMembers() {
        return noMembers;
    }

    public JTextField getAnnCons() {
        return annCons;
    }

    public JTextField getValInvest() {
        return valInvest;
    }

    public JComboBox getNoDeathBens() {
        return noDeathBens;
    }

    public JComboBox getNoMbrShares() {
        return noMbrShares;
    }

    public JTextField getDb1() {
        return db1;
    }

    public JTextField getDb6() {
        return db6;
    }

    public JTextField getDb2() {
        return db2;
    }

    public JTextField getDb7() {
        return db7;
    }

    public JTextField getDb3() {
        return db3;
    }

    public JTextField getDb8() {
        return db8;
    }

    public JTextField getDb4() {
        return db4;
    }

    public JTextField getDb9() {
        return db9;
    }

    public JTextField getDb5() {
        return db5;
    }

    public JTextField getDb10() {
        return db10;
    }

    public JTextField getMs1() {
        return ms1;
    }

    public JTextField getMs6() {
        return ms6;
    }

    public JTextField getMs2() {
        return ms2;
    }

    public JTextField getMs7() {
        return ms7;
    }

    public JTextField getMs3() {
        return ms3;
    }

    public JTextField getMs8() {
        return ms8;
    }

    public JTextField getMs4() {
        return ms4;
    }

    public JTextField getMs9() {
        return ms9;
    }

    public JTextField getMs5() {
        return ms5;
    }

    public JTextField getMs10() {
        return ms10;
    }

    public JLabel getDb5_lbl() {
        return db5_lbl;
    }

    public JLabel getDb8_lbl() {
        return db8_lbl;
    }

    public JLabel getDb1_lbl() {
        return db1_lbl;
    }

    public JLabel getDb2_lbl() {
        return db2_lbl;
    }

    public JLabel getDb7_lbl() {
        return db7_lbl;
    }

    public JLabel getDb10_lbl() {
        return db10_lbl;
    }

    public JLabel getDb4_lbl() {
        return db4_lbl;
    }

    public JLabel getDb6_lbl() {
        return db6_lbl;
    }

    public JLabel getDb3_lbl() {
        return db3_lbl;
    }

    public JLabel getDb9_lbl() {
        return db9_lbl;
    }

    public JLabel getMs4_lbl() {
        return ms4_lbl;
    }

    public JLabel getMs10_lbl() {
        return ms10_lbl;
    }

    public JLabel getMs5_lbl() {
        return ms5_lbl;
    }

    public JLabel getMs6_lbl() {
        return ms6_lbl;
    }

    public JLabel getMs1_lbl() {
        return ms1_lbl;
    }

    public JLabel getMs9_lbl() {
        return ms9_lbl;
    }

    public JLabel getMs8_lbl() {
        return ms8_lbl;
    }

    public JLabel getMs3_lbl() {
        return ms3_lbl;
    }

    public JLabel getMs2_lbl() {
        return ms2_lbl;
    }

    public JLabel getMs7_lbl() {
        return ms7_lbl;
    }
}
