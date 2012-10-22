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

import za.co.cascott.indemnity.DataCollection;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WizardShortRiskLoadingPanel extends WizardPanelDescriptor {

    ShortRiskLoadingPanel p;
    DataCollection col = null;
    double minimal = 3;
    double partial = 2;
    double full = 0;

    double light = 1;
    double medium = 2;
    double heavy = 3;
    double max = 297;

    public WizardShortRiskLoadingPanel() {
        this.nextBtnText = "Complete";
        JPanel newPanel = new ShortRiskLoadingPanel();
        setPanel(newPanel);
    }

    private void setUpActionListener(final JRadioButton c) {
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //This is silly.
                if (p.getRdbtnMinimal_1().isSelected()) {
                    col.setOb7("Minimal");
                    col.setOb7v(minimal);
                } else if (p.getRdbtnPartial_1().isSelected()) {
                    col.setOb7("Partial");
                    col.setOb7v(partial);
                } else if (p.getRdbtnFull_1().isSelected()) {
                    col.setOb7("Full");
                    col.setOb7v(full);
                }
                if (p.getRdbtnLight_1().isSelected()) {
                    col.setOb10("Light");
                    col.setOb10v(light);
                } else if (p.getRdbtnMedium_1().isSelected()) {
                    col.setOb10("Medium");
                    col.setOb10v(medium);
                } else if (p.getRdbtnHeavy_1().isSelected()) {
                    col.setOb10("Heavy");
                    col.setOb10v(heavy);
                }
                double a = (col.getOb7v() * col.getOb10v() * 3) / max;
                col.setTb3(a);
                p.getLblNewLabel().setText(col.getPformatter().format(a));

                ////////////////////////////////////////////////////////// 2
                if (p.getRdbtnMinimal_2().isSelected()) {
                    col.setOb8("Minimal");
                    col.setOb8v(minimal);
                } else if (p.getRdbtnPartial_2().isSelected()) {
                    col.setOb8("Partial");
                    col.setOb8v(partial);
                    //vSpecialLoading = 2.333; What's this for?
                } else if (p.getRdbtnFull_2().isSelected()) {
                    col.setOb8("Full");
                    col.setOb8v(full);
                }
                if (p.getRdbtnLight_2().isSelected()) {
                    col.setOb11("Light");
                    col.setOb11v(light);
                } else if (p.getRdbtnMedium_2().isSelected()) {
                    col.setOb11("Medium");
                    col.setOb11v(medium);
                } else if (p.getRdbtnHeavy_2().isSelected()) {
                    col.setOb11("Heavy");
                    col.setOb11v(heavy);
                }
                /*Special loading added 16012012
                    If ob8 = "Minimal" And ob11 = "Light" Then 1
                            vSpecialLoading1 = 2.333333
                        ElseIf ob8 = "Minimal" And ob11 = "Medium" Then 2
                            vSpecialLoading1 = 1.5
                        ElseIf ob8 = "Minimal" And ob11 = "Heavy" Then  3
                            vSpecialLoading1 = 1.222222
                        ElseIf ob8 = "Partial" And ob11 = "Light" Then 4
                            vSpecialLoading1 = 2.333333
                        ElseIf ob8 = "Partial" And ob11 = "Medium" Then 5
                            vSpecialLoading1 = 1.5
                        ElseIf ob8 = "Partial" And ob11 = "Heavy" Then 6
                            vSpecialLoading1 = 1.222222
                    End If
                    tb4 = (ob8v * ob11v * 3) / vMax * vSpecialLoading1
                    TextBox4.Value = Format(tb4, "0.00%")*/
                double vSpecialLoading1 = 0;
                if (col.getOb8().equals("Minimal") && col.getOb11().equals("Light"))
                    vSpecialLoading1 = 2.333333;
                else if (col.getOb8().equals("Minimal") && col.getOb11().equals("Medium"))
                    vSpecialLoading1 = 1.5;
                else if (col.getOb8().equals("Minimal") && col.getOb11().equals("Heavy"))
                    vSpecialLoading1 = 1.222222;
                else if (col.getOb8().equals("Partial") && col.getOb11().equals("Light"))
                    vSpecialLoading1 = 2.333333;
                else if (col.getOb8().equals("Partial") && col.getOb11().equals("Medium"))
                    vSpecialLoading1 = 1.5;
                else if (col.getOb8().equals("Partial") && col.getOb11().equals("Heavy"))
                    vSpecialLoading1 = 1.222222;

                a = (col.getOb8v() * col.getOb11v() * 3) / max * vSpecialLoading1;
                col.setTb4(a);
                p.getLabel().setText(col.getPformatter().format(a));

                ////////////////////////////////////////////////////////// 3
                if (p.getRdbtnMinimal_3().isSelected()) {
                    col.setOb9("Minimal");
                    col.setOb9v(minimal);
                } else if (p.getRdbtnPartial_3().isSelected()) {
                    col.setOb9("Partial");
                    col.setOb9v(partial);
                } else if (p.getRdbtnFull_3().isSelected()) {
                    col.setOb9("Full");
                    col.setOb9v(full);
                }
                if (p.getRdbtnLight_3().isSelected()) {
                    col.setOb12("Light");
                    col.setOb12v(light);
                } else if (p.getRdbtnMedium_3().isSelected()) {
                    col.setOb12("Medium");
                    col.setOb12v(medium);
                } else if (p.getRdbtnHeavy_3().isSelected()) {
                    col.setOb12("Heavy");
                    col.setOb12v(heavy);
                }
                a = (col.getOb9v() * col.getOb12v() * 2) / max;
                col.setTb5(a);
                p.getLabel_1().setText(col.getPformatter().format(a));

                ////////////////////////////////////////////////////////// 4
                if (p.getRdbtnMinimal_4().isSelected()) {
                    col.setOb13("Minimal");
                    col.setOb13v(minimal);
                } else if (p.getRdbtnPartial_4().isSelected()) {
                    col.setOb13("Partial");
                    col.setOb13v(partial);
                } else if (p.getRdbtnFull_4().isSelected()) {
                    col.setOb13("Full");
                    col.setOb13v(full);
                }
                if (p.getRdbtnLight_4().isSelected()) {
                    col.setOb16("Light");
                    col.setOb16v(light);
                } else if (p.getRdbtnMedium_4().isSelected()) {
                    col.setOb16("Medium");
                    col.setOb16v(medium);
                } else if (p.getRdbtnHeavy_4().isSelected()) {
                    col.setOb16("Heavy");
                    col.setOb16v(heavy);
                }
                a = (col.getOb13v() * col.getOb16v() * 2) / max;
                col.setTb6(a);
                p.getLabel_2().setText(col.getPformatter().format(a));

                ////////////////////////////////////////////////////////// 5
                if (p.getRdbtnMinimal_5().isSelected()) {
                    col.setOb14("Minimal");
                    col.setOb14v(minimal);
                } else if (p.getRdbtnPartial_5().isSelected()) {
                    col.setOb14("Partial");
                    col.setOb14v(partial);
                } else if (p.getRdbtnFull_5().isSelected()) {
                    col.setOb14("Full");
                    col.setOb14v(full);
                }
                if (p.getRdbtnLight_5().isSelected()) {
                    col.setOb17("Light");
                    col.setOb17v(light);
                } else if (p.getRdbtnMedium_5().isSelected()) {
                    col.setOb17("Medium");
                    col.setOb17v(medium);
                } else if (p.getRdbtnHeavy_5().isSelected()) {
                    col.setOb17("Heavy");
                    col.setOb17v(heavy);
                }
                a = (col.getOb14v() * col.getOb17v() * 6) / max;
                col.setTb7(a);
                p.getLabel_7().setText(col.getPformatter().format(a));

                ////////////////////////////////////////////////////////// 6
                if (p.getRdbtnMinimal_6().isSelected()) {
                    col.setOb15("Minimal");
                    col.setOb15v(minimal);
                } else if (p.getRdbtnPartial_6().isSelected()) {
                    col.setOb15("Partial");
                    col.setOb15v(partial);
                } else if (p.getRdbtnFull_6().isSelected()) {
                    col.setOb15("Full");
                    col.setOb15v(full);
                }
                if (p.getRdbtnLight_6().isSelected()) {
                    col.setOb18("Light");
                    col.setOb18v(light);
                } else if (p.getRdbtnMedium_6().isSelected()) {
                    col.setOb18("Medium");
                    col.setOb18v(medium);
                } else if (p.getRdbtnHeavy_6().isSelected()) {
                    col.setOb18("Heavy");
                    col.setOb18v(heavy);
                }
                a = (col.getOb15v() * col.getOb18v() * 3) / max;
                col.setTb8(a);
                p.getLabel_9().setText(col.getPformatter().format(a));

                ////////////////////////////////////////////////////////// 7
                if (p.getRdbtnMinimal_7().isSelected()) {
                    col.setOb19("Minimal");
                    col.setOb19v(minimal);
                } else if (p.getRdbtnPartial_7().isSelected()) {
                    col.setOb19("Partial");
                    col.setOb19v(partial);
                } else if (p.getRdbtnFull_7().isSelected()) {
                    col.setOb19("Full");
                    col.setOb19v(full);
                }
                if (p.getRdbtnLight_7().isSelected()) {
                    col.setOb22("Light");
                    col.setOb22v(light);
                } else if (p.getRdbtnMedium_7().isSelected()) {
                    col.setOb22("Medium");
                    col.setOb22v(medium);
                } else if (p.getRdbtnHeavy_7().isSelected()) {
                    col.setOb22("Heavy");
                    col.setOb22v(heavy);
                }

                double vSpecialLoading2 = 0;
                if (col.getOb8().equals("Minimal") && col.getOb11().equals("Light"))
                    vSpecialLoading2 = 2.5;
                else if (col.getOb8().equals("Minimal") && col.getOb11().equals("Medium"))
                    vSpecialLoading2 = 1.375;
                else if (col.getOb8().equals("Minimal") && col.getOb11().equals("Heavy"))
                    vSpecialLoading2 = 1;
                else if (col.getOb8().equals("Partial") && col.getOb11().equals("Light"))
                    vSpecialLoading2 = 2.5;
                else if (col.getOb8().equals("Partial") && col.getOb11().equals("Medium"))
                    vSpecialLoading2 = 1.375;
                else if (col.getOb8().equals("Partial") && col.getOb11().equals("Heavy"))
                    vSpecialLoading2 = 1;

                a = (col.getOb19v() * col.getOb22v() * 4) / max * vSpecialLoading2;
                col.setTb9(a);
                p.getLabel_10().setText(col.getPformatter().format(a));

                ////////////////////////////////////////////////////////// 8
                if (p.getRdbtnMinimal_8().isSelected()) {
                    col.setOb20("Minimal");
                    col.setOb20v(minimal);
                } else if (p.getRdbtnPartial_8().isSelected()) {
                    col.setOb20("Partial");
                    col.setOb20v(partial);
                } else if (p.getRdbtnFull_8().isSelected()) {
                    col.setOb20("Full");
                    col.setOb20v(full);
                }
                if (p.getRdbtnLight_8().isSelected()) {
                    col.setOb23("Light");
                    col.setOb23v(light);
                } else if (p.getRdbtnMedium_8().isSelected()) {
                    col.setOb23("Medium");
                    col.setOb23v(medium);
                } else if (p.getRdbtnHeavy_8().isSelected()) {
                    col.setOb23("Heavy");
                    col.setOb23v(heavy);
                }
                double vSpecialLoading3 = 0;
                if (col.getOb8().equals("Minimal") && col.getOb11().equals("Light"))
                    vSpecialLoading3 = 3;
                else if (col.getOb8().equals("Minimal") && col.getOb11().equals("Medium"))
                    vSpecialLoading3 = 1.75;
                else if (col.getOb8().equals("Minimal") && col.getOb11().equals("Heavy"))
                    vSpecialLoading3 = 1.333333;
                else if (col.getOb8().equals("Partial") && col.getOb11().equals("Light"))
                    vSpecialLoading3 = 3;
                else if (col.getOb8().equals("Partial") && col.getOb11().equals("Medium"))
                    vSpecialLoading3 = 1.75;
                else if (col.getOb8().equals("Partial") && col.getOb11().equals("Heavy"))
                    vSpecialLoading3 = 1.333333;

                a = (col.getOb20v() * col.getOb23v() * 4) / max * vSpecialLoading3;
                col.setTb10(a);
                p.getLabel_8().setText(col.getPformatter().format(a));

                ////////////////////////////////////////////////////////// 9
                if (p.getRdbtnMinimal_9().isSelected()) {
                    col.setOb21("Minimal");
                    col.setOb21v(minimal);
                } else if (p.getRdbtnPartial_9().isSelected()) {
                    col.setOb21("Partial");
                    col.setOb21v(partial);
                } else if (p.getRdbtnFull_9().isSelected()) {
                    col.setOb21("Full");
                    col.setOb21v(full);
                }
                if (p.getRdbtnLight_9().isSelected()) {
                    col.setOb24("Light");
                    col.setOb24v(light);
                } else if (p.getRdbtnMedium_9().isSelected()) {
                    col.setOb24("Medium");
                    col.setOb24v(medium);
                } else if (p.getRdbtnHeavy_9().isSelected()) {
                    col.setOb24("Heavy");
                    col.setOb24v(heavy);
                }
                a = (col.getOb21v() * col.getOb24v() * 6) / max;
                col.setTb11(a);
                p.getLabel_3().setText(col.getPformatter().format(a));
                double last = col.getTb3() + col.getTb4() + col.getTb5() + col.getTb6() + col.getTb7() + col.getTb8() + col.getTb9() + col.getTb10() + col.getTb11();
                p.getTextField().setText(col.getPformatter().format(last));

                /* try {
                        setDataCollectionValues(((ShortRiskLoadingPanel)p).getRdbtnMinimal_1(), "getOb7", "getOb7v", "setOb7", "setOb7v");
                        setDataCollectionValues(((ShortRiskLoadingPanel)p).getRdbtnPartial_1(), "getOb7", "getOb7v", "setOb7", "setOb7v");
                        setDataCollectionValues(((ShortRiskLoadingPanel)p).getRdbtnFull_1(), "getOb7", "getOb7v", "setOb7", "setOb7v");

                    } catch (IllegalAccessException | IllegalArgumentException
                            | InvocationTargetException | NoSuchMethodException
                            | SecurityException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } */
            }
        });
    }

    private void setDataCollectionValues(JRadioButton c1, String getOb, String getObv, String setOb, String setObv) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class[] argTypes = new Class[]{double.class};
        Method msetObv = DataCollection.class.getDeclaredMethod(getObv, argTypes);
        Method msetOb = DataCollection.class.getDeclaredMethod(getObv, argTypes);
        Method mgetObv = DataCollection.class.getDeclaredMethod(getObv, null);
        Method mgetOb = DataCollection.class.getDeclaredMethod(getOb, null);

        double f = minimal;
        double e = col.getOb10v();

        col.setOb7("Minimal");
        col.setOb7v(minimal);
        double a = (col.getOb7v() * col.getOb10v() * 3) / max;
        col.setTb3(a);
        p.getLblNewLabel().setText(col.getPformatter().format(a));
    }

    public void complete() {
        size = new Dimension(748, 652);
        this.getWizard().getWizardDialog().getTopLabel().setText("<html><center><font size=5>Short-form Assessment of compliance with the guidelines issued by the Financial Services Board in Circular PF130</font><br><font size=3>&copy; 2012 CA Scott Consulting Actuary &ndash; All rights reserved</font></center></html>");
        p = ((ShortRiskLoadingPanel) this.getPanel());

        this.getWizard().getWizardDialog().getBtnAddSampleData().setEnabled(false);

        JPanel panel = this.getWizard().getWizardDialog().getHeaderPanel();
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(panel_1, "cell 0 2 6 1,growx,aligny top");
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        {
            JLabel lblPleaseCompleteAll = new JLabel("<html><center>Select the degree to which you consider the Fund to comply with the guidelines below and allocate<br> a risk-weighting to each item.</center></html>");
            lblPleaseCompleteAll.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 11));
            lblPleaseCompleteAll.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel_1.add(lblPleaseCompleteAll);
        }

        col = this.wiz.getDataCollection();

        //Not needed.
        minimal = col.COMPLIANCE_MINIMAL;
        partial = col.COMPLIANCE_PARTIAL;
        full = col.COMPLIANCE_FULL;

        light = col.WEIGHTING_LIGHT;
        medium = col.WEIGHTING_MEDIUM;
        heavy = col.WEIGHTING_HEAVY;
        max = col.WEIGHTING_MAX;

        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_1());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_2());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_3());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_4());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_5());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_6());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_7());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_8());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_9());

        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_1());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_2());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_3());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_4());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_5());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_6());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_7());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_8());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_9());

        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_1());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_2());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_3());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_4());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_5());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_6());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_7());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_8());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_9());

        //////////////////////////////////////////////////////////////////////////////////////
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_1());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_2());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_3());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_4());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_5());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_6());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_7());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_8());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_9());

        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_1());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_2());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_3());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_4());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_5());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_6());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_7());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_8());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_9());

        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_1());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_2());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_3());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_4());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_5());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_6());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_7());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_8());
        setUpActionListener(((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_9());


        if (this.wiz.getDataCollection().dc == "minimal") {
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_1().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_2().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_3().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_4().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_5().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_6().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_7().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_8().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMinimal_9().setSelected(true);
        } else if (this.wiz.getDataCollection().dc == "partial") {
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_1().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_2().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_3().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_4().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_5().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_6().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_7().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_8().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnPartial_9().setSelected(true);
        } else if (this.wiz.getDataCollection().dc == "full") {
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_1().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_2().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_3().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_4().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_5().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_6().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_7().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_8().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnFull_9().setSelected(true);
        }

        //RW ~~~~~~~~~~~~~~~~~~~~~
        if (this.wiz.getDataCollection().rw == "light") {
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_1().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_2().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_3().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_4().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_5().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_6().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_7().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_8().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_9().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnLight_1().doClick();
        } else if (this.wiz.getDataCollection().rw == "medium") {
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_1().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_2().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_3().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_4().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_5().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_6().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_7().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_8().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_9().setSelected(true);

            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnMedium_1().doClick();
        } else if (this.wiz.getDataCollection().rw == "heavy") {
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_1().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_2().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_3().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_4().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_5().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_6().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_7().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_8().setSelected(true);
            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_9().setSelected(true);

            ((ShortRiskLoadingPanel) this.getPanel()).getRdbtnHeavy_1().doClick();
        }
    }

    private void setDefSelection(JComboBox c, int t, String value) {
        if (t == 1) {

        } else if (t == 2) {

        }
    }

    /*
      * Return next panel.
      */
    public WizardPanelDescriptor getNextDescriptor() {
        return (new WizardSavePanel(0));
    }

    /*
      * Return prev panel
      */
    public WizardPanelDescriptor getPrevDescriptor() {
        return null;
    }

    /* The Buttons */
    public void nextbtnAction(ActionEvent event) {

    }
}
