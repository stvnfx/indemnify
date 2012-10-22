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
import za.co.cascott.indemnity.DataCollection;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WizardRiskLoadingPanel extends WizardPanelDescriptor {

    RiskLoadingPanel p;
    DataCollection col = null;
    double minimal = 3;
    double partial = 2;
    double full = 0;

    double light = 1;
    double medium = 2;
    double heavy = 3;
    double max = 297;

    public WizardRiskLoadingPanel() {
        this.nextBtnText = "Complete";
        JPanel newPanel = new RiskLoadingPanel();
        setPanel(newPanel);
    }

    public void complete() {
        size = new Dimension(804, 688);
        //Note we remove this two times because number 4 becomes 3 after 3 gets removed.
        this.getWizard().getWizardDialog().getHeaderPanel().remove(3);
        this.getWizard().getWizardDialog().getHeaderPanel().remove(3);
        ((MigLayout) this.getWizard().getWizardDialog().getHeaderPanel().getLayout()).setRowConstraints("[fill]");
        this.getWizard().getWizardDialog().getTopLabel().setText("<html><center><font size=5>Assessment of compliance with the guidelines issued by the Financial Services Board in Circular PF130</font><br><font size=3>&copy; 2012 CA Scott Consulting Actuary &ndash; All rights reserved</font></center></html>");

        this.getWizard().getWizardDialog().getBtnAddSampleData().setEnabled(false);

        JPanel panel = this.getWizard().getWizardDialog().getHeaderPanel();
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(panel_1, "cell 0 2 6 1,growx,aligny top");
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        {
            JLabel lblPleaseCompleteAll = new JLabel("<html><center>Select the degree to which you consider the Fund to comply with the guidelines below and allocate a risk-weighting to each item.</center></html>");
            lblPleaseCompleteAll.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 11));
            lblPleaseCompleteAll.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel_1.add(lblPleaseCompleteAll);
        }

        p = ((RiskLoadingPanel) this.getPanel());
        col = this.wiz.getDataCollection();
        //Calculate the initial values.

        //Page 1
        setUpActionListener(p.comboBox);
        setUpActionListener(p.comboBox_1);

        setUpActionListener(p.comboBox_2);
        setUpActionListener(p.comboBox_3);

        setUpActionListener(p.comboBox_4);
        setUpActionListener(p.comboBox_5);

        setUpActionListener(p.comboBox_6);
        setUpActionListener(p.comboBox_7);

        setUpActionListener(p.comboBox_8);
        setUpActionListener(p.comboBox_9);

        setUpActionListener(p.comboBox_10);
        setUpActionListener(p.comboBox_11);

        setUpActionListener(p.comboBox_12);
        setUpActionListener(p.comboBox_13);

        setUpActionListener(p.comboBox_14);
        setUpActionListener(p.comboBox_15);

        //Page 2
        setUpActionListener(p.comboBox_16);
        setUpActionListener(p.comboBox_17);

        setUpActionListener(p.comboBox_18);
        setUpActionListener(p.comboBox_19);

        setUpActionListener(p.comboBox_20);
        setUpActionListener(p.comboBox_21);

        setUpActionListener(p.comboBox_22);
        setUpActionListener(p.comboBox_23);

        setUpActionListener(p.comboBox_24);
        setUpActionListener(p.comboBox_25);

        setUpActionListener(p.comboBox_26);
        setUpActionListener(p.comboBox_27);

        setUpActionListener(p.comboBox_28);
        setUpActionListener(p.comboBox_29);

        setUpActionListener(p.comboBox_30);
        setUpActionListener(p.comboBox_31);

        //Page 3
        setUpActionListener(p.comboBox_32);
        setUpActionListener(p.comboBox_33);

        setUpActionListener(p.comboBox_34);
        setUpActionListener(p.comboBox_35);

        setUpActionListener(p.comboBox_36);
        setUpActionListener(p.comboBox_37);

        setUpActionListener(p.comboBox_38);
        setUpActionListener(p.comboBox_39);

        setUpActionListener(p.comboBox_40);
        setUpActionListener(p.comboBox_41);

        setUpActionListener(p.comboBox_42);
        setUpActionListener(p.comboBox_43);

        setUpActionListener(p.comboBox_44);
        setUpActionListener(p.comboBox_45);

        //Page 4
        setUpActionListener(p.comboBox_46);
        setUpActionListener(p.comboBox_47);

        setUpActionListener(p.comboBox_48);
        setUpActionListener(p.comboBox_49);
        //setUpActionListener(p.comboBox_50);
        //setUpActionListener(p.comboBox_51);
        setUpActionListener(p.comboBox_52);
        setUpActionListener(p.comboBox_53);

        setUpActionListener(p.comboBox_54);
        setUpActionListener(p.comboBox_55);

        setUpActionListener(p.comboBox_56);
        setUpActionListener(p.comboBox_57);

        setUpActionListener(p.comboBox_58);
        setUpActionListener(p.comboBox_59);

        //setUpActionListener(p.comboBox_60);
        //setUpActionListener(p.comboBox_61);

        setUpActionListener(p.comboBox_62);
        setUpActionListener(p.comboBox_63);

        setUpActionListener(p.comboBox_50);
        setUpActionListener(p.comboBox_51);

        setUpActionListener(p.comboBox_65);
        setUpActionListener(p.comboBox_64);

        setUpActionListener(p.comboBox_67);
        setUpActionListener(p.comboBox_66);
        p.comboBox.setSelectedIndex(0);
    }

    private void setUpActionListener(JComboBox c) {
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
//				//Re push all the data.
//				
//				//1
//				/*System.out.println((String)p.comboBox.getSelectedItem());
//				if ((String)p.comboBox.getSelectedItem() == "Minimal") {
//					col.setCb1(minimal);
//				} else if ((String)p.comboBox.getSelectedItem() == "Partial") {
//					col.setCb1(partial);
//				} else if ((String)p.comboBox.getSelectedItem() == "Full") {
//					col.setCb1(full);
//				}
//				
//				if ((String)p.comboBox_1.getSelectedItem() == "Light") {
//					col.setCb2(light);
//				} else if ((String)p.comboBox_1.getSelectedItem() == "Medium") {
//					col.setCb2(medium);
//				} else if ((String)p.comboBox_1.getSelectedItem() == "Heavy") {
//					col.setCb2(heavy);
//				}
//				col.setTb1((col.getCb1() * col.getCb2()) / max);
//				p.getTextField().setText(String.valueOf(col.getPformatter().format(col.getTb1())));*/
//				
//				try {
//					setDataCollectionValuesCal(p.comboBox, p.comboBox_1, "setCb1", "setCb2", "setTb1");
//					setDataCollectionValuesCal(p.comboBox_2, p.comboBox_3, "setCb3", "setCb4", "setTb2");
//					setDataCollectionValuesCal(p.comboBox_4, p.comboBox_5, "setCb5", "setCb6", "setTb3");
//					setDataCollectionValuesCal(p.comboBox_6, p.comboBox_7, "setCb7", "setCb8", "setTb4");
//					setDataCollectionValuesCal(p.comboBox_8, p.comboBox_9, "setCb9", "setCb10", "setTb5");
//					setDataCollectionValuesCal(p.comboBox_10, p.comboBox_11, "setCb11", "setCb12", "setTb6");
//					setDataCollectionValuesCal(p.comboBox_12, p.comboBox_13, "setCb13", "setCb14", "setTb7");
//					setDataCollectionValuesCal(p.comboBox_14, p.comboBox_15, "setCb15", "setCb16", "setTb8");
//					setDataCollectionValuesCal(p.comboBox_16, p.comboBox_17, "setCb17", "setCb18", "setTb9");
//					setDataCollectionValuesCal(p.comboBox_18, p.comboBox_19, "setCb19", "setCb20", "setTb10");
//					setDataCollectionValuesCal(p.comboBox_20, p.comboBox_21, "setCb21", "setCb22", "setTb11");
//					setDataCollectionValuesCal(p.comboBox_22, p.comboBox_23, "setCb23", "setCb24", "setTb12");
//					setDataCollectionValuesCal(p.comboBox_24, p.comboBox_25, "setCb25", "setCb26", "setTb13");
//					setDataCollectionValuesCal(p.comboBox_26, p.comboBox_27, "setCb27", "setCb28", "setTb14");
//					setDataCollectionValuesCal(p.comboBox_28, p.comboBox_29, "setCb29", "setCb30", "setTb15");
//					setDataCollectionValuesCal(p.comboBox_30, p.comboBox_31, "setCb31", "setCb32", "setTb16");
//					setDataCollectionValuesCal(p.comboBox_32, p.comboBox_33, "setCb33", "setCb34", "setTb17");
//					setDataCollectionValuesCal(p.comboBox_34, p.comboBox_35, "setCb35", "setCb36", "setTb18");
//					setDataCollectionValuesCal(p.comboBox_36, p.comboBox_37, "setCb37", "setCb38", "setTb19");
//					setDataCollectionValuesCal(p.comboBox_38, p.comboBox_39, "setCb39", "setCb40", "setTb20");
//					setDataCollectionValuesCal(p.comboBox_40, p.comboBox_41, "setCb41", "setCb42", "setTb21");
//					setDataCollectionValuesCal(p.comboBox_42, p.comboBox_43, "setCb43", "setCb44", "setTb22");
//					setDataCollectionValuesCal(p.comboBox_44, p.comboBox_45, "setCb45", "setCb46", "setTb23");
//					setDataCollectionValuesCal(p.comboBox_46, p.comboBox_47, "setCb47", "setCb48", "setTb24");
//					setDataCollectionValuesCal(p.comboBox_48, p.comboBox_49, "setCb49", "setCb50", "setTb25");
//					//setDataCollectionValues(p.comboBox_50, p.comboBox_51, "setCb51", "setCb52", "setTb26");
//					setDataCollectionValuesCal(p.comboBox_52, p.comboBox_53, "setCb53", "setCb54", "setTb27");
//					setDataCollectionValuesCal(p.comboBox_54, p.comboBox_55, "setCb55", "setCb56", "setTb28");
//					setDataCollectionValuesCal(p.comboBox_56, p.comboBox_57, "setCb57", "setCb58", "setTb29");
//					setDataCollectionValuesCal(p.comboBox_58, p.comboBox_59, "setCb59", "setCb60", "setTb30");
//					
//				} catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IllegalArgumentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InvocationTargetException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (NoSuchMethodException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SecurityException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				col.calculate_full_loading();
//				p.getTextField().setText(col.getPformatter().format(col.getTb1()));
//				p.getTextField_1().setText(col.getPformatter().format(col.getTb2()));
//				p.getTextField_2().setText(col.getPformatter().format(col.getTb3()));
//				p.getTextField_3().setText(col.getPformatter().format(col.getTb4()));
//				p.getTextField_4().setText(col.getPformatter().format(col.getTb5()));
//				p.getTextField_5().setText(col.getPformatter().format(col.getTb6()));
//				p.getTextField_6().setText(col.getPformatter().format(col.getTb7()));
//				p.getTextField_7().setText(col.getPformatter().format(col.getTb8()));
//				p.getTextField_8().setText(col.getPformatter().format(col.getTb9()));
//				p.getTextField_9().setText(col.getPformatter().format(col.getTb10()));
//				p.getTextField_10().setText(col.getPformatter().format(col.getTb11()));
//				p.getTextField_11().setText(col.getPformatter().format(col.getTb12()));
//				p.getTextField_12().setText(col.getPformatter().format(col.getTb13()));
//				p.getTextField_13().setText(col.getPformatter().format(col.getTb14()));
//				p.getTextField_14().setText(col.getPformatter().format(col.getTb15()));
//				p.getTextField_15().setText(col.getPformatter().format(col.getTb16()));
//				p.getTextField_16().setText(col.getPformatter().format(col.getTb17()));
//				p.getTextField_17().setText(col.getPformatter().format(col.getTb18()));
//				p.getTextField_18().setText(col.getPformatter().format(col.getTb19()));
//				p.getTextField_19().setText(col.getPformatter().format(col.getTb20()));
//				p.getTextField_20().setText(col.getPformatter().format(col.getTb21()));
//				p.getTextField_21().setText(col.getPformatter().format(col.getTb22()));
//				p.getTextField_22().setText(col.getPformatter().format(col.getTb23()));
//				p.getTextField_23().setText(col.getPformatter().format(col.getTb24()));
//				p.getTextField_24().setText(col.getPformatter().format(col.getTb25()));
//				p.getTextField_25().setText(col.getPformatter().format(col.getTb26()));
//				p.getTextField_26().setText(col.getPformatter().format(col.getTb27()));
//				p.getTextField_27().setText(col.getPformatter().format(col.getTb28()));
//				p.getTextField_28().setText(col.getPformatter().format(col.getTb29()));
//				p.getTextField_29().setText(col.getPformatter().format(col.getTb30()));
//				//Loading
//				p.getTextField_30().setText(col.getPformatter().format(col.getTb31()));

                //Fresh Start...
                if ((String) p.getComboBox().getSelectedItem() == "Minimal") {
                    col.setCb1("Minimal");
                    col.setCb1v(minimal);
                } else if ((String) p.getComboBox().getSelectedItem() == "Partial") {
                    col.setCb1("Partial");
                    col.setCb1v(partial);
                } else if ((String) p.getComboBox().getSelectedItem() == "Full") {
                    col.setCb1("Full");
                    col.setCb1v(full);
                }

                if ((String) p.getComboBox_1().getSelectedItem() == "Light") {
                    col.setCb2("Light");
                    col.setCb2v(light);
                } else if ((String) p.getComboBox_1().getSelectedItem() == "Medium") {
                    col.setCb2("Medium");
                    col.setCb2v(medium);
                } else if ((String) p.getComboBox_1().getSelectedItem() == "Heavy") {
                    col.setCb2("Heavy");
                    col.setCb2v(heavy);
                }
                double a = (col.getCb1v() * col.getCb2v()) / max;
                col.setTb1(a);
                p.getTextField().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_2().getSelectedItem() == "Minimal") {
                    col.setCb3("Minimal");
                    col.setCb3v(minimal);
                } else if ((String) p.getComboBox_2().getSelectedItem() == "Partial") {
                    col.setCb3("Partial");
                    col.setCb3v(partial);
                } else if ((String) p.getComboBox_2().getSelectedItem() == "Full") {
                    col.setCb3("Full");
                    col.setCb3v(full);
                }

                if ((String) p.getComboBox_3().getSelectedItem() == "Light") {
                    col.setCb4("Light");
                    col.setCb4v(light);
                } else if ((String) p.getComboBox_3().getSelectedItem() == "Medium") {
                    col.setCb4("Medium");
                    col.setCb4v(medium);
                } else if ((String) p.getComboBox_3().getSelectedItem() == "Heavy") {
                    col.setCb4("Heavy");
                    col.setCb4v(heavy);
                }
                a = (col.getCb3v() * col.getCb4v()) / max;
                col.setTb2(a);
                p.getTextField_1().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_4().getSelectedItem() == "Minimal") {
                    col.setCb5("Minimal");
                    col.setCb5v(minimal);
                } else if ((String) p.getComboBox_4().getSelectedItem() == "Partial") {
                    col.setCb5("Partial");
                    col.setCb5v(partial);
                } else if ((String) p.getComboBox_4().getSelectedItem() == "Full") {
                    col.setCb5("Full");
                    col.setCb5v(full);
                }

                if ((String) p.getComboBox_5().getSelectedItem() == "Light") {
                    col.setCb6("Light");
                    col.setCb6v(light);
                } else if ((String) p.getComboBox_5().getSelectedItem() == "Medium") {
                    col.setCb6("Medium");
                    col.setCb6v(medium);
                } else if ((String) p.getComboBox_5().getSelectedItem() == "Heavy") {
                    col.setCb6("Heavy");
                    col.setCb6v(heavy);
                }
                a = (col.getCb5v() * col.getCb6v()) / max;
                col.setTb3(a);
                p.getTextField_2().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_6().getSelectedItem() == "Minimal") {
                    col.setCb7("Minimal");
                    col.setCb7v(minimal);
                } else if ((String) p.getComboBox_6().getSelectedItem() == "Partial") {
                    col.setCb7("Partial");
                    col.setCb7v(partial);
                } else if ((String) p.getComboBox_6().getSelectedItem() == "Full") {
                    col.setCb7("Full");
                    col.setCb7v(full);
                }

                if ((String) p.getComboBox_7().getSelectedItem() == "Light") {
                    col.setCb8("Light");
                    col.setCb8v(light);
                } else if ((String) p.getComboBox_7().getSelectedItem() == "Medium") {
                    col.setCb8("Medium");
                    col.setCb8v(medium);
                } else if ((String) p.getComboBox_7().getSelectedItem() == "Heavy") {
                    col.setCb8("Heavy");
                    col.setCb8v(heavy);
                }

                if (col.getCb7v() == minimal)
                    col.setTb4(15 / max);
                else if (col.getCb7v() == partial)
                    col.setTb4(10 / max);
                else
                    col.setTb4(0);
                p.getTextField_3().setText(col.getPformatter().format(col.getTb4()));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_8().getSelectedItem() == "Minimal") {
                    col.setCb9("Minimal");
                    col.setCb9v(minimal);
                } else if ((String) p.getComboBox_8().getSelectedItem() == "Partial") {
                    col.setCb9("Partial");
                    col.setCb9v(partial);
                } else if ((String) p.getComboBox_8().getSelectedItem() == "Full") {
                    col.setCb9("Full");
                    col.setCb9v(full);
                }

                if ((String) p.getComboBox_9().getSelectedItem() == "Light") {
                    col.setCb10("Light");
                    col.setCb10v(light);
                } else if ((String) p.getComboBox_9().getSelectedItem() == "Medium") {
                    col.setCb10("Medium");
                    col.setCb10v(medium);
                } else if ((String) p.getComboBox_9().getSelectedItem() == "Heavy") {
                    col.setCb10("Heavy");
                    col.setCb10v(heavy);
                }
                a = (col.getCb9v() * col.getCb10v()) / max;
                col.setTb5(a);
                p.getTextField_4().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_10().getSelectedItem() == "Minimal") {
                    col.setCb11("Minimal");
                    col.setCb11v(minimal);
                } else if ((String) p.getComboBox_10().getSelectedItem() == "Partial") {
                    col.setCb11("Partial");
                    col.setCb11v(partial);
                } else if ((String) p.getComboBox_10().getSelectedItem() == "Full") {
                    col.setCb11("Full");
                    col.setCb11v(full);
                }

                if ((String) p.getComboBox_11().getSelectedItem() == "Light") {
                    col.setCb12("Light");
                    col.setCb12v(light);
                } else if ((String) p.getComboBox_11().getSelectedItem() == "Medium") {
                    col.setCb12("Medium");
                    col.setCb12v(medium);
                } else if ((String) p.getComboBox_11().getSelectedItem() == "Heavy") {
                    col.setCb12("Heavy");
                    col.setCb12v(heavy);
                }
                a = (col.getCb11v() * col.getCb12v()) / max;
                col.setTb6(a);
                p.getTextField_5().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_12().getSelectedItem() == "Minimal") {
                    col.setCb13("Minimal");
                    col.setCb13v(minimal);
                } else if ((String) p.getComboBox_12().getSelectedItem() == "Partial") {
                    col.setCb13("Partial");
                    col.setCb13v(partial);
                } else if ((String) p.getComboBox_12().getSelectedItem() == "Full") {
                    col.setCb13("Full");
                    col.setCb13v(full);
                }

                if ((String) p.getComboBox_13().getSelectedItem() == "Light") {
                    col.setCb14("Light");
                    col.setCb14v(light);
                } else if ((String) p.getComboBox_13().getSelectedItem() == "Medium") {
                    col.setCb14("Medium");
                    col.setCb14v(medium);
                } else if ((String) p.getComboBox_13().getSelectedItem() == "Heavy") {
                    col.setCb14("Heavy");
                    col.setCb14v(heavy);
                }
                a = (col.getCb13v() * col.getCb14v()) / max;
                col.setTb7(a);
                p.getTextField_6().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_14().getSelectedItem() == "Minimal") {
                    col.setCb15("Minimal");
                    col.setCb15v(minimal);
                } else if ((String) p.getComboBox_14().getSelectedItem() == "Partial") {
                    col.setCb15("Partial");
                    col.setCb15v(partial);
                } else if ((String) p.getComboBox_14().getSelectedItem() == "Full") {
                    col.setCb15("Full");
                    col.setCb15v(full);
                }

                if ((String) p.getComboBox_15().getSelectedItem() == "Light") {
                    col.setCb16("Light");
                    col.setCb16v(light);
                } else if ((String) p.getComboBox_15().getSelectedItem() == "Medium") {
                    col.setCb16("Medium");
                    col.setCb16v(medium);
                } else if ((String) p.getComboBox_15().getSelectedItem() == "Heavy") {
                    col.setCb16("Heavy");
                    col.setCb16v(heavy);
                }
                a = (col.getCb15v() * col.getCb16v()) / max;
                col.setTb8(a);
                p.getTextField_7().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////
                /////////////////////////////////////////////////////////////////////////////////////////////
                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_16().getSelectedItem() == "Minimal") {
                    col.setCb17("Minimal");
                    col.setCb17v(minimal);
                } else if ((String) p.getComboBox_16().getSelectedItem() == "Partial") {
                    col.setCb17("Partial");
                    col.setCb17v(partial);
                } else if ((String) p.getComboBox_16().getSelectedItem() == "Full") {
                    col.setCb17("Full");
                    col.setCb17v(full);
                }

                if ((String) p.getComboBox_17().getSelectedItem() == "Light") {
                    col.setCb18("Light");
                    col.setCb18v(light);
                } else if ((String) p.getComboBox_17().getSelectedItem() == "Medium") {
                    col.setCb18("Medium");
                    col.setCb18v(medium);
                } else if ((String) p.getComboBox_17().getSelectedItem() == "Heavy") {
                    col.setCb18("Heavy");
                    col.setCb18v(heavy);
                }
                a = (col.getCb17v() * col.getCb18v()) / max;
                col.setTb9(a);
                p.getTextField_8().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_18().getSelectedItem() == "Minimal") {
                    col.setCb19("Minimal");
                    col.setCb19v(minimal);
                } else if ((String) p.getComboBox_18().getSelectedItem() == "Partial") {
                    col.setCb19("Partial");
                    col.setCb19v(partial);
                } else if ((String) p.getComboBox_18().getSelectedItem() == "Full") {
                    col.setCb19("Full");
                    col.setCb19v(full);
                }

                if ((String) p.getComboBox_19().getSelectedItem() == "Light") {
                    col.setCb20("Light");
                    col.setCb20v(light);
                } else if ((String) p.getComboBox_19().getSelectedItem() == "Medium") {
                    col.setCb20("Medium");
                    col.setCb20v(medium);
                } else if ((String) p.getComboBox_19().getSelectedItem() == "Heavy") {
                    col.setCb20("Heavy");
                    col.setCb20v(heavy);
                }
                a = (col.getCb19v() * col.getCb20v()) / max;
                col.setTb10(a);
                p.getTextField_9().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_20().getSelectedItem() == "Minimal") {
                    col.setCb21("Minimal");
                    col.setCb21v(minimal);
                } else if ((String) p.getComboBox_20().getSelectedItem() == "Partial") {
                    col.setCb21("Partial");
                    col.setCb21v(partial);
                } else if ((String) p.getComboBox_20().getSelectedItem() == "Full") {
                    col.setCb21("Full");
                    col.setCb21v(full);
                }

                if ((String) p.getComboBox_21().getSelectedItem() == "Light") {
                    col.setCb22("Light");
                    col.setCb22v(light);
                } else if ((String) p.getComboBox_21().getSelectedItem() == "Medium") {
                    col.setCb22("Medium");
                    col.setCb22v(medium);
                } else if ((String) p.getComboBox_21().getSelectedItem() == "Heavy") {
                    col.setCb22("Heavy");
                    col.setCb22v(heavy);
                }
                a = (col.getCb21v() * col.getCb22v()) / max;
                col.setTb11(a);
                p.getTextField_10().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_22().getSelectedItem() == "Minimal") {
                    col.setCb23("Minimal");
                    col.setCb23v(minimal);
                } else if ((String) p.getComboBox_22().getSelectedItem() == "Partial") {
                    col.setCb23("Partial");
                    col.setCb23v(partial);
                } else if ((String) p.getComboBox_22().getSelectedItem() == "Full") {
                    col.setCb23("Full");
                    col.setCb23v(full);
                }

                if ((String) p.getComboBox_23().getSelectedItem() == "Light") {
                    col.setCb24("Light");
                    col.setCb24v(light);
                } else if ((String) p.getComboBox_23().getSelectedItem() == "Medium") {
                    col.setCb24("Medium");
                    col.setCb24v(medium);
                } else if ((String) p.getComboBox_23().getSelectedItem() == "Heavy") {
                    col.setCb24("Heavy");
                    col.setCb24v(heavy);
                }
                a = (col.getCb23v() * col.getCb24v()) / max;
                col.setTb12(a);
                p.getTextField_11().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_24().getSelectedItem() == "Minimal") {
                    col.setCb25("Minimal");
                    col.setCb25v(minimal);
                } else if ((String) p.getComboBox_24().getSelectedItem() == "Partial") {
                    col.setCb25("Partial");
                    col.setCb25v(partial);
                } else if ((String) p.getComboBox_24().getSelectedItem() == "Full") {
                    col.setCb25("Full");
                    col.setCb25v(full);
                }

                if ((String) p.getComboBox_25().getSelectedItem() == "Light") {
                    col.setCb26("Light");
                    col.setCb26v(light);
                } else if ((String) p.getComboBox_25().getSelectedItem() == "Medium") {
                    col.setCb26("Medium");
                    col.setCb26v(medium);
                } else if ((String) p.getComboBox_25().getSelectedItem() == "Heavy") {
                    col.setCb26("Heavy");
                    col.setCb26v(heavy);
                }
                a = (col.getCb25v() * col.getCb26v()) / max;
                col.setTb13(a);
                p.getTextField_12().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_26().getSelectedItem() == "Minimal") {
                    col.setCb27("Minimal");
                    col.setCb27v(minimal);
                } else if ((String) p.getComboBox_26().getSelectedItem() == "Partial") {
                    col.setCb27("Partial");
                    col.setCb27v(partial);
                } else if ((String) p.getComboBox_26().getSelectedItem() == "Full") {
                    col.setCb27("Full");
                    col.setCb27v(full);
                }

                if ((String) p.getComboBox_27().getSelectedItem() == "Light") {
                    col.setCb28("Light");
                    col.setCb28v(light);
                } else if ((String) p.getComboBox_27().getSelectedItem() == "Medium") {
                    col.setCb28("Medium");
                    col.setCb28v(medium);
                } else if ((String) p.getComboBox_27().getSelectedItem() == "Heavy") {
                    col.setCb28("Heavy");
                    col.setCb28v(heavy);
                }
                a = (col.getCb27v() * col.getCb28v()) / max;
                col.setTb14(a);
                p.getTextField_13().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_28().getSelectedItem() == "Minimal") {
                    col.setCb29("Minimal");
                    col.setCb29v(minimal);
                } else if ((String) p.getComboBox_28().getSelectedItem() == "Partial") {
                    col.setCb29("Partial");
                    col.setCb29v(partial);
                } else if ((String) p.getComboBox_28().getSelectedItem() == "Full") {
                    col.setCb29("Full");
                    col.setCb29v(full);
                }

                if ((String) p.getComboBox_29().getSelectedItem() == "Light") {
                    col.setCb30("Light");
                    col.setCb30v(light);
                } else if ((String) p.getComboBox_29().getSelectedItem() == "Medium") {
                    col.setCb30("Medium");
                    col.setCb30v(medium);
                } else if ((String) p.getComboBox_29().getSelectedItem() == "Heavy") {
                    col.setCb30("Heavy");
                    col.setCb30v(heavy);
                }
                a = (col.getCb29v() * col.getCb30v()) / max;
                col.setTb15(a);
                p.getTextField_14().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_30().getSelectedItem() == "Minimal") {
                    col.setCb31("Minimal");
                    col.setCb31v(minimal);
                } else if ((String) p.getComboBox_30().getSelectedItem() == "Partial") {
                    col.setCb31("Partial");
                    col.setCb31v(partial);
                } else if ((String) p.getComboBox_30().getSelectedItem() == "Full") {
                    col.setCb31("Full");
                    col.setCb31v(full);
                }

                if ((String) p.getComboBox_31().getSelectedItem() == "Light") {
                    col.setCb32("Light");
                    col.setCb32v(light);
                } else if ((String) p.getComboBox_31().getSelectedItem() == "Medium") {
                    col.setCb32("Medium");
                    col.setCb32v(medium);
                } else if ((String) p.getComboBox_31().getSelectedItem() == "Heavy") {
                    col.setCb32("Heavy");
                    col.setCb32v(heavy);
                }
                a = (col.getCb31v() * col.getCb32v()) / max;
                col.setTb16(a);
                p.getTextField_15().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////
                /////////////////////////////////////////////////////////////////////////////////////////////
                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_32().getSelectedItem() == "Minimal") {
                    col.setCb33("Minimal");
                    col.setCb33v(minimal);
                } else if ((String) p.getComboBox_32().getSelectedItem() == "Partial") {
                    col.setCb33("Partial");
                    col.setCb33v(partial);
                } else if ((String) p.getComboBox_32().getSelectedItem() == "Full") {
                    col.setCb33("Full");
                    col.setCb33v(full);
                }

                if ((String) p.getComboBox_33().getSelectedItem() == "Light") {
                    col.setCb34("Light");
                    col.setCb34v(light);
                } else if ((String) p.getComboBox_33().getSelectedItem() == "Medium") {
                    col.setCb34("Medium");
                    col.setCb34v(medium);
                } else if ((String) p.getComboBox_33().getSelectedItem() == "Heavy") {
                    col.setCb34("Heavy");
                    col.setCb34v(heavy);
                }
                a = (col.getCb33v() * col.getCb34v()) / max;
                col.setTb17(a);
                p.getTextField_16().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_34().getSelectedItem() == "Minimal") {
                    col.setCb35("Minimal");
                    col.setCb35v(minimal);
                } else if ((String) p.getComboBox_34().getSelectedItem() == "Partial") {
                    col.setCb35("Partial");
                    col.setCb35v(partial);
                } else if ((String) p.getComboBox_34().getSelectedItem() == "Full") {
                    col.setCb35("Full");
                    col.setCb35v(full);
                }

                if ((String) p.getComboBox_35().getSelectedItem() == "Light") {
                    col.setCb36("Light");
                    col.setCb36v(light);
                } else if ((String) p.getComboBox_35().getSelectedItem() == "Medium") {
                    col.setCb36("Medium");
                    col.setCb36v(medium);
                } else if ((String) p.getComboBox_35().getSelectedItem() == "Heavy") {
                    col.setCb36("Heavy");
                    col.setCb36v(heavy);
                }
                a = (col.getCb35v() * col.getCb36v()) / max;
                col.setTb18(a);
                p.getTextField_17().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_36().getSelectedItem() == "Minimal") {
                    col.setCb37("Minimal");
                    col.setCb37v(minimal);
                } else if ((String) p.getComboBox_36().getSelectedItem() == "Partial") {
                    col.setCb37("Partial");
                    col.setCb37v(partial);
                } else if ((String) p.getComboBox_36().getSelectedItem() == "Full") {
                    col.setCb37("Full");
                    col.setCb37v(full);
                }

                if ((String) p.getComboBox_37().getSelectedItem() == "Light") {
                    col.setCb38("Light");
                    col.setCb38v(light);
                } else if ((String) p.getComboBox_37().getSelectedItem() == "Medium") {
                    col.setCb38("Medium");
                    col.setCb38v(medium);
                } else if ((String) p.getComboBox_37().getSelectedItem() == "Heavy") {
                    col.setCb38("Heavy");
                    col.setCb38v(heavy);
                }
                a = (col.getCb37v() * col.getCb38v()) / max;
                col.setTb19(a);
                p.getTextField_18().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_38().getSelectedItem() == "Minimal") {
                    col.setCb39("Minimal");
                    col.setCb39v(minimal);
                } else if ((String) p.getComboBox_38().getSelectedItem() == "Partial") {
                    col.setCb39("Partial");
                    col.setCb39v(partial);
                } else if ((String) p.getComboBox_38().getSelectedItem() == "Full") {
                    col.setCb39("Full");
                    col.setCb39v(full);
                }

                if ((String) p.getComboBox_39().getSelectedItem() == "Light") {
                    col.setCb40("Light");
                    col.setCb40v(light);
                } else if ((String) p.getComboBox_39().getSelectedItem() == "Medium") {
                    col.setCb40("Medium");
                    col.setCb40v(medium);
                } else if ((String) p.getComboBox_39().getSelectedItem() == "Heavy") {
                    col.setCb40("Heavy");
                    col.setCb40v(heavy);
                }
                a = (col.getCb39v() * col.getCb40v()) / max;
                col.setTb20(a);
                p.getTextField_19().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_40().getSelectedItem() == "Minimal") {
                    col.setCb41("Minimal");
                    col.setCb41v(minimal);
                } else if ((String) p.getComboBox_40().getSelectedItem() == "Partial") {
                    col.setCb41("Partial");
                    col.setCb41v(partial);
                } else if ((String) p.getComboBox_40().getSelectedItem() == "Full") {
                    col.setCb41("Full");
                    col.setCb41v(full);
                }

                if ((String) p.getComboBox_41().getSelectedItem() == "Light") {
                    col.setCb42("Light");
                    col.setCb42v(light);
                } else if ((String) p.getComboBox_41().getSelectedItem() == "Medium") {
                    col.setCb42("Medium");
                    col.setCb42v(medium);
                } else if ((String) p.getComboBox_41().getSelectedItem() == "Heavy") {
                    col.setCb42("Heavy");
                    col.setCb42v(heavy);
                }
                //a = (col.getCb39() * col.getCb40()) / max;
                col.setTb21(0);
                p.getTextField_20().setText(col.getPformatter().format(0));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_42().getSelectedItem() == "Minimal") {
                    col.setCb43("Minimal");
                    col.setCb43v(minimal);
                } else if ((String) p.getComboBox_42().getSelectedItem() == "Partial") {
                    col.setCb43("Partial");
                    col.setCb43v(partial);
                } else if ((String) p.getComboBox_42().getSelectedItem() == "Full") {
                    col.setCb43("Full");
                    col.setCb43v(full);
                }

                if ((String) p.getComboBox_43().getSelectedItem() == "Light") {
                    col.setCb44("Light");
                    col.setCb44v(light);
                } else if ((String) p.getComboBox_43().getSelectedItem() == "Medium") {
                    col.setCb44("Medium");
                    col.setCb44v(medium);
                } else if ((String) p.getComboBox_43().getSelectedItem() == "Heavy") {
                    col.setCb44("Heavy");
                    col.setCb44v(heavy);
                }

                if (col.getCb43v() == minimal)
                    col.setTb22(15 / max);
                else if (col.getCb43v() == partial)
                    col.setTb22(10 / max);
                else
                    col.setTb22(0);
                p.getTextField_21().setText(col.getPformatter().format(col.getTb22()));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_44().getSelectedItem() == "Minimal") {
                    col.setCb45("Minimal");
                    col.setCb45v(minimal);
                } else if ((String) p.getComboBox_44().getSelectedItem() == "Partial") {
                    col.setCb45("Partial");
                    col.setCb45v(partial);
                } else if ((String) p.getComboBox_44().getSelectedItem() == "Full") {
                    col.setCb45("Full");
                    col.setCb45v(full);
                }

                if ((String) p.getComboBox_45().getSelectedItem() == "Light") {
                    col.setCb46("Light");
                    col.setCb46v(light);
                } else if ((String) p.getComboBox_45().getSelectedItem() == "Medium") {
                    col.setCb46("Medium");
                    col.setCb46v(medium);
                } else if ((String) p.getComboBox_45().getSelectedItem() == "Heavy") {
                    col.setCb46("Heavy");
                    col.setCb46v(heavy);
                }

                if (col.getCb45v() == minimal)
                    col.setTb23(12 / max);
                else if (col.getCb45v() == partial)
                    col.setTb23(8 / max);
                else
                    col.setTb23(0);
                p.getTextField_22().setText(col.getPformatter().format(col.getTb23()));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_46().getSelectedItem() == "Minimal") {
                    col.setCb47("Minimal");
                    col.setCb47v(minimal);
                } else if ((String) p.getComboBox_46().getSelectedItem() == "Partial") {
                    col.setCb47("Partial");
                    col.setCb47v(partial);
                } else if ((String) p.getComboBox_46().getSelectedItem() == "Full") {
                    col.setCb47("Full");
                    col.setCb47v(full);
                }

                if ((String) p.getComboBox_47().getSelectedItem() == "Light") {
                    col.setCb48("Light");
                    col.setCb48v(light);
                } else if ((String) p.getComboBox_47().getSelectedItem() == "Medium") {
                    col.setCb48("Medium");
                    col.setCb48v(medium);
                } else if ((String) p.getComboBox_47().getSelectedItem() == "Heavy") {
                    col.setCb48("Heavy");
                    col.setCb48v(heavy);
                }

                if (col.getCb47v() == minimal)
                    col.setTb24(15 / max);
                else if (col.getCb47v() == partial)
                    col.setTb24(10 / max);
                else
                    col.setTb24(0);
                p.getTextField_23().setText(col.getPformatter().format(col.getTb24()));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_48().getSelectedItem() == "Minimal") {
                    col.setCb49("Minimal");
                    col.setCb49v(minimal);
                } else if ((String) p.getComboBox_48().getSelectedItem() == "Partial") {
                    col.setCb49("Partial");
                    col.setCb49v(partial);
                } else if ((String) p.getComboBox_48().getSelectedItem() == "Full") {
                    col.setCb49("Full");
                    col.setCb49v(full);
                }

                if ((String) p.getComboBox_49().getSelectedItem() == "Light") {
                    col.setCb50("Light");
                    col.setCb50v(light);
                } else if ((String) p.getComboBox_49().getSelectedItem() == "Medium") {
                    col.setCb50("Medium");
                    col.setCb50v(medium);
                } else if ((String) p.getComboBox_49().getSelectedItem() == "Heavy") {
                    col.setCb50("Heavy");
                    col.setCb50v(heavy);
                }

                if (col.getCb49v() == minimal)
                    col.setTb25(15 / max);
                else if (col.getCb49v() == partial)
                    col.setTb25(10 / max);
                else
                    col.setTb25(0);
                p.getTextField_24().setText(col.getPformatter().format(col.getTb25()));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_52().getSelectedItem() == "Minimal") {
                    col.setCb53("Minimal");
                    col.setCb53v(minimal);
                } else if ((String) p.getComboBox_52().getSelectedItem() == "Partial") {
                    col.setCb53("Partial");
                    col.setCb53v(partial);
                } else if ((String) p.getComboBox_52().getSelectedItem() == "Full") {
                    col.setCb53("Full");
                    col.setCb53v(full);
                }

                if ((String) p.getComboBox_53().getSelectedItem() == "Light") {
                    col.setCb54("Light");
                    col.setCb54v(light);
                } else if ((String) p.getComboBox_53().getSelectedItem() == "Medium") {
                    col.setCb54("Medium");
                    col.setCb54v(medium);
                } else if ((String) p.getComboBox_53().getSelectedItem() == "Heavy") {
                    col.setCb54("Heavy");
                    col.setCb54v(heavy);
                }
                a = (col.getCb53v() * col.getCb54v()) / max;
                col.setTb27(a);
                p.getTextField_26().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_54().getSelectedItem() == "Minimal") {
                    col.setCb55("Minimal");
                    col.setCb55v(minimal);
                } else if ((String) p.getComboBox_54().getSelectedItem() == "Partial") {
                    col.setCb55("Partial");
                    col.setCb55v(partial);
                } else if ((String) p.getComboBox_54().getSelectedItem() == "Full") {
                    col.setCb55("Full");
                    col.setCb55v(full);
                }

                if ((String) p.getComboBox_55().getSelectedItem() == "Light") {
                    col.setCb56("Light");
                    col.setCb56v(light);
                } else if ((String) p.getComboBox_55().getSelectedItem() == "Medium") {
                    col.setCb56("Medium");
                    col.setCb56v(medium);
                } else if ((String) p.getComboBox_55().getSelectedItem() == "Heavy") {
                    col.setCb56("Heavy");
                    col.setCb56v(heavy);
                }
                a = (col.getCb55v() * col.getCb56v()) / max;
                col.setTb28(a);
                p.getTextField_27().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////
                // Added section.
                ///////////////////

                if ((String) p.getComboBox_56().getSelectedItem() == "Minimal") {
                    col.setCb57("Minimal");
                    col.setCb57v(minimal);
                } else if ((String) p.getComboBox_56().getSelectedItem() == "Partial") {
                    col.setCb57("Partial");
                    col.setCb57v(partial);
                } else if ((String) p.getComboBox_56().getSelectedItem() == "Full") {
                    col.setCb57("Full");
                    col.setCb57v(full);
                }

                if ((String) p.getComboBox_57().getSelectedItem() == "Light") {
                    col.setCb58("Light");
                    col.setCb58v(light);
                } else if ((String) p.getComboBox_57().getSelectedItem() == "Medium") {
                    col.setCb58("Medium");
                    col.setCb58v(medium);
                } else if ((String) p.getComboBox_57().getSelectedItem() == "Heavy") {
                    col.setCb58("Heavy");
                    col.setCb58v(heavy);
                }
                a = (col.getCb57v() * col.getCb58v()) / max;
                col.setTb29(a);
                p.getTextField_28().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_58().getSelectedItem() == "Minimal") {
                    col.setCb59("Minimal");
                    col.setCb59v(minimal);
                } else if ((String) p.getComboBox_58().getSelectedItem() == "Partial") {
                    col.setCb59("Partial");
                    col.setCb59v(partial);
                } else if ((String) p.getComboBox_58().getSelectedItem() == "Full") {
                    col.setCb59("Full");
                    col.setCb59v(full);
                }

                if ((String) p.getComboBox_59().getSelectedItem() == "Light") {
                    col.setCb60("Light");
                    col.setCb60v(light);
                } else if ((String) p.getComboBox_59().getSelectedItem() == "Medium") {
                    col.setCb60("Medium");
                    col.setCb60v(medium);
                } else if ((String) p.getComboBox_59().getSelectedItem() == "Heavy") {
                    col.setCb60("Heavy");
                    col.setCb60v(heavy);
                }
                a = (col.getCb59v() * col.getCb60v()) / max;
                col.setTb30(a);
                p.getTextField_29().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////
                /*
                    if ((String)p.getComboBox_67().getSelectedItem() == "Minimal") {
                        col.setCb65("Minimal");
                        col.setCb65v(minimal);
                    } else if ((String)p.getComboBox_67().getSelectedItem() == "Partial") {
                        col.setCb65("Partial");
                        col.setCb65v(partial);
                    } else if ((String)p.getComboBox_67().getSelectedItem() == "Full") {
                        col.setCb65("Full");
                        col.setCb65v(full);
                    }

                    if ((String)p.getComboBox_66().getSelectedItem() == "Light") {
                        col.setCb66("Light");
                        col.setCb66v(light);
                    } else if ((String)p.getComboBox_66().getSelectedItem() == "Medium") {
                        col.setCb66("Medium");
                        col.setCb66v(medium);
                    } else if ((String)p.getComboBox_66().getSelectedItem() == "Heavy") {
                        col.setCb66("Heavy");
                        col.setCb66v(heavy);
                    }
                    a = (col.getCb65v() * col.getCb66v()) / max;
                    col.setTb33(a);
                    p.getTextField_31().setText(col.getPformatter().format(a));
                    */

                if ((String) p.getComboBox_67().getSelectedItem() == "Minimal") {
                    col.setCb66("Minimal");
                    col.setCb66v(minimal);
                } else if ((String) p.getComboBox_67().getSelectedItem() == "Partial") {
                    col.setCb66("Partial");
                    col.setCb66v(partial);
                } else if ((String) p.getComboBox_67().getSelectedItem() == "Full") {
                    col.setCb66("Full");
                    col.setCb66v(full);
                }

                if ((String) p.getComboBox_66().getSelectedItem() == "Light") {
                    col.setCb69("Light");
                    col.setCb69v(light);
                } else if ((String) p.getComboBox_66().getSelectedItem() == "Medium") {
                    col.setCb69("Medium");
                    col.setCb69v(medium);
                } else if ((String) p.getComboBox_66().getSelectedItem() == "Heavy") {
                    col.setCb69("Heavy");
                    col.setCb69v(heavy);
                }
                a = (col.getCb66v() * col.getCb69v()) / max;
                col.setTb33(a);
                p.getTextField_31().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////

                if ((String) p.getComboBox_62().getSelectedItem() == "Minimal") {
                    col.setCb67("Minimal");
                    col.setCb67v(minimal);
                } else if ((String) p.getComboBox_62().getSelectedItem() == "Partial") {
                    col.setCb67("Partial");
                    col.setCb67v(partial);
                } else if ((String) p.getComboBox_62().getSelectedItem() == "Full") {
                    col.setCb67("Full");
                    col.setCb67v(full);
                }

                if ((String) p.getComboBox_63().getSelectedItem() == "Light") {
                    col.setCb68("Light");
                    col.setCb68v(light);
                } else if ((String) p.getComboBox_63().getSelectedItem() == "Medium") {
                    col.setCb68("Medium");
                    col.setCb68v(medium);
                } else if ((String) p.getComboBox_63().getSelectedItem() == "Heavy") {
                    col.setCb68("Heavy");
                    col.setCb68v(heavy);
                }
                a = (col.getCb67v() * col.getCb68v()) / max;
                col.setTb34(a);
                p.getTextField_32().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////
                /*
                    if ((String)p.getComboBox_50().getSelectedItem() == "Minimal") {
                        col.setCb69("Minimal");
                        col.setCb69v(minimal);
                    } else if ((String)p.getComboBox_50().getSelectedItem() == "Partial") {
                        col.setCb69("Partial");
                        col.setCb69v(partial);
                    } else if ((String)p.getComboBox_50().getSelectedItem() == "Full") {
                        col.setCb69("Full");
                        col.setCb69v(full);
                    }

                    if ((String)p.getComboBox_51().getSelectedItem() == "Light") {
                        col.setCb70("Light");
                        col.setCb70v(light);
                    } else if ((String)p.getComboBox_51().getSelectedItem() == "Medium") {
                        col.setCb70("Medium");
                        col.setCb70v(medium);
                    } else if ((String)p.getComboBox_51().getSelectedItem() == "Heavy") {
                        col.setCb70("Heavy");
                        col.setCb70v(heavy);
                    }
                    a = (col.getCb69v() * col.getCb70v()) / max;
                    col.setTb35(a);
                    p.getTextField_25().setText(col.getPformatter().format(a));
                    */

                if ((String) p.getComboBox_50().getSelectedItem() == "Minimal") {
                    col.setCb70("Minimal");
                    col.setCb70v(minimal);
                } else if ((String) p.getComboBox_50().getSelectedItem() == "Partial") {
                    col.setCb70("Partial");
                    col.setCb70v(partial);
                } else if ((String) p.getComboBox_50().getSelectedItem() == "Full") {
                    col.setCb70("Full");
                    col.setCb70v(full);
                }

                if ((String) p.getComboBox_51().getSelectedItem() == "Light") {
                    col.setCb71("Light");
                    col.setCb71v(light);
                } else if ((String) p.getComboBox_51().getSelectedItem() == "Medium") {
                    col.setCb71("Medium");
                    col.setCb71v(medium);
                } else if ((String) p.getComboBox_51().getSelectedItem() == "Heavy") {
                    col.setCb71("Heavy");
                    col.setCb71v(heavy);
                }
                a = (col.getCb70v() * col.getCb71v()) / max;
                col.setTb35(a);
                p.getTextField_25().setText(col.getPformatter().format(a));

                /////////////////////////////////////////////////////////////////////////////////////////////CCCCCCCCCCC
                /*
                    if ((String)p.getComboBox_65().getSelectedItem() == "Minimal") {
                        col.setCb71("Minimal");
                        col.setCb71v(minimal);
                    } else if ((String)p.getComboBox_65().getSelectedItem() == "Partial") {
                        col.setCb71("Partial");
                        col.setCb71v(partial);
                    } else if ((String)p.getComboBox_65().getSelectedItem() == "Full") {
                        col.setCb71("Full");
                        col.setCb71v(full);
                    }

                    if ((String)p.getComboBox_64().getSelectedItem() == "Light") {
                        col.setCb72("Light");
                        col.setCb72v(light);
                    } else if ((String)p.getComboBox_64().getSelectedItem() == "Medium") {
                        col.setCb72("Medium");
                        col.setCb72v(medium);
                    } else if ((String)p.getComboBox_64().getSelectedItem() == "Heavy") {
                        col.setCb72("Heavy");
                        col.setCb72v(heavy);
                    }
                    a = (col.getCb71v() * col.getCb72v()) / max;
                    col.setTb36(a);
                    p.getTextField_33().setText(col.getPformatter().format(a));
                    */

                if ((String) p.getComboBox_65().getSelectedItem() == "Minimal") {
                    col.setCb72("Minimal");
                    col.setCb72v(minimal);
                } else if ((String) p.getComboBox_65().getSelectedItem() == "Partial") {
                    col.setCb72("Partial");
                    col.setCb72v(partial);
                } else if ((String) p.getComboBox_65().getSelectedItem() == "Full") {
                    col.setCb72("Full");
                    col.setCb72v(full);
                }

                if ((String) p.getComboBox_64().getSelectedItem() == "Light") {
                    col.setCb73("Light");
                    col.setCb73v(light);
                } else if ((String) p.getComboBox_64().getSelectedItem() == "Medium") {
                    col.setCb73("Medium");
                    col.setCb73v(medium);
                } else if ((String) p.getComboBox_64().getSelectedItem() == "Heavy") {
                    col.setCb73("Heavy");
                    col.setCb73v(heavy);
                }
                a = (col.getCb72v() * col.getCb73v()) / max;
                col.setTb36(a);
                p.getTextField_33().setText(col.getPformatter().format(a));

                col.setTb31(col.getTb1() + col.getTb2() + col.getTb3() + col.getTb4() + col.getTb5() + col.getTb6() + col.getTb7() + col.getTb8() + col.getTb9() + col.getTb10() + col.getTb11() + col.getTb12() + col.getTb13() + col.getTb14() + col.getTb15() + col.getTb16() + col.getTb18() + col.getTb18() + col.getTb19() + col.getTb20()
                        + col.getTb21() + col.getTb22() + col.getTb23() + col.getTb24() + col.getTb25() + col.getTb27() + col.getTb28() + col.getTb29() + col.getTb30() + col.getTb33() + col.getTb34() + col.getTb35() + col.getTb36());

                p.getTextField_30().setText(col.getPformatter().format(col.getTb31()));

            }
        });
    }

    /*
      * Pass the two Combo boxes and the setter function name from data collection.
      */
    private void setDataCollectionValues(JComboBox c1, JComboBox c2, String m1, String m2) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Class[] argTypes = new Class[]{double.class};

        Method mc1 = DataCollection.class.getDeclaredMethod(m1, argTypes);

        if ((String) c1.getSelectedItem() == "Minimal") {
            mc1.invoke(col, minimal);
        } else if ((String) c1.getSelectedItem() == "Partial") {
            mc1.invoke(col, partial);
        } else if ((String) c1.getSelectedItem() == "Full") {
            mc1.invoke(col, full);
        }

        Method mc2 = col.getClass().getDeclaredMethod(m2, argTypes);

        if ((String) c2.getSelectedItem() == "Light") {
            mc2.invoke(col, light);
        } else if ((String) c2.getSelectedItem() == "Medium") {
            mc2.invoke(col, medium);
        } else if ((String) c2.getSelectedItem() == "Heavy") {
            mc2.invoke(col, heavy);
        }
    }

    private void setDataCollectionValuesCal(JComboBox c1, JComboBox c2, String m1, String m2, String m3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        double first = 0;
        double second = 0;
        Class[] argTypes = new Class[]{double.class};

        Method mc1 = DataCollection.class.getDeclaredMethod(m1, argTypes);

        if ((String) c1.getSelectedItem() == "Minimal") {
            mc1.invoke(col, minimal);
            first = minimal;
        } else if ((String) c1.getSelectedItem() == "Partial") {
            mc1.invoke(col, partial);
            first = partial;
        } else if ((String) c1.getSelectedItem() == "Full") {
            mc1.invoke(col, full);
            first = full;
        }

        Method mc2 = col.getClass().getDeclaredMethod(m2, argTypes);

        if ((String) c2.getSelectedItem() == "Light") {
            mc2.invoke(col, light);
            second = light;
        } else if ((String) c2.getSelectedItem() == "Medium") {
            mc2.invoke(col, medium);
            second = medium;
        } else if ((String) c2.getSelectedItem() == "Heavy") {
            mc2.invoke(col, heavy);
            second = heavy;
        }

        Method mc3 = col.getClass().getDeclaredMethod(m3, argTypes);
        double a = (first * second) / max;
        mc3.invoke(col, a);
    }

    /*
      * Return next panel.
      */
    public WizardPanelDescriptor getNextDescriptor() {
        return (new WizardSavePanel(1));
    }

    /*
      * Return prev panel
      */
    public WizardPanelDescriptor getPrevDescriptor() {
        return null;
    }

    /* The Buttons */
    public void nextbtnAction(ActionEvent event) {
//		DataCollection col = this.wiz.getDataCollection();
////		//Call Calculate.
////		//this.wiz.getDataCollection().populateWithTestData();
////		this.wiz.getDataCollection().calculate_full_loading();
////		//Where to save?
////	    JFileChooser chooser = new JFileChooser();
////	    int returnVal = chooser.showSaveDialog(null);
////	    if(returnVal == JFileChooser.APPROVE_OPTION) {
////	       System.out.println("Save PDF To: " +
////	            chooser.getSelectedFile().getPath());
////	       //URL url = this.getClass().getResource("assets/iisDocument.rtf");
////	       	//RTFDocument rtf = new RTFDocument("/home/steven/Desktop/iisDocument.rtf", this.wiz.getDataCollection()); //Should be a Stream from the JAR.
////	       TemplateEngine eengine1 = new TemplateEngine(this.wiz.getDataCollection());
////	       try {
////	    	   eengine1.createPDF(eengine1.processFile("/assets/main.html"), chooser.getSelectedFile().getPath());
////	       } catch (IOException e) {
////	    	   e.printStackTrace();
////	       } catch (DocumentException e) {
////	    	   e.printStackTrace();
////	       }
////	       //TemplateEngine eengine2 = new TemplateEngine(this.wiz.getDataCollection());
////	       //eengine2.processFile("/assets/full_loading.html");
////	       //RTFDocument rtf = new RTFDocument(this.wiz.getDataCollection(), this.getClass().getResourceAsStream("/assets/iisDocument.rtf")); //Should be a Stream from the JAR.
////	       //PdfiText f = new PdfiText(chooser.getSelectedFile().getPath());
////	       //rtf.setOutput(f); //Output type (Pdf)
////	      // rtf.produce(null);
////	      // f.end();
////	       int short_msg;
////	       short_msg = JOptionPane.showConfirmDialog(null, "Do you want to save the loadings document?\n",
////	    		   "Save Loadings PDF", JOptionPane.YES_NO_OPTION);
////	       if (short_msg == JOptionPane.YES_OPTION) {
////	    	   //Now the other one...
////	    	   returnVal = chooser.showSaveDialog(null);
////	    	   if(returnVal == JFileChooser.APPROVE_OPTION) {
////	    	       TemplateEngine eengine2 = new TemplateEngine(this.wiz.getDataCollection());
////	    	       try {
////	    	    	   eengine1.createPDF(eengine2.processFile("/assets/full_loading.html"), chooser.getSelectedFile().getPath());
////	    	       } catch (IOException e) {
////	    	    	   e.printStackTrace();
////	    	       } catch (DocumentException e) {
////	    	    	   e.printStackTrace();
////	    	       }
////	    		   //RTFDocument rtf_loadings = new RTFDocument(this.wiz.getDataCollection(), this.getClass().getResourceAsStream("/assets/full_loading.rtf"));
////	    		   //PdfiText f_loadings = new PdfiText(chooser.getSelectedFile().getPath());
////	    		   //rtf_loadings.setOutput(f_loadings);
////	    		   //rtf_loadings.produce(null);
////	    		   //f_loadings.end();
////				}
////	       }
//		//Call Calculate.
//		//this.wiz.getDataCollection().populateWithTestData();
//		//I'm not calling caluclate_fund_data() here since it was called by the Fund Data Panel.
//		
//		col.calculate_fund_data();
//		col.calculate_long_loading();
//		final TemplateEngine eengine = new TemplateEngine(col);
//		final Loading l = new Loading(this.getWizard().getWizardDialog().getFrame());
//		l.setLocationRelativeTo(this.getWizard().getWizardDialog().getFrame());
//	    final JFileChooser chooser = new JFileChooser();
//	    int returnVal = chooser.showSaveDialog(null);
//	    if(returnVal == JFileChooser.APPROVE_OPTION) {
//	       System.out.println("Save PDF To: " +
//	            chooser.getSelectedFile().getPath());
//	       
//	       SwingWorker worker = new SwingWorker() {
//
//	    	   public String doInBackground() throws Exception {
//	    	     Thread.sleep(1000);
//	    	     eengine.createPDF(eengine.processFile("/assets/main.html"), chooser.getSelectedFile().getPath());
//	    	     return null;
//	    	   }
//
//	    	   public void done() {
//	    	     SwingUtilities.invokeLater(new Runnable() {
//	    	       public void run() {
//	    	         l.setVisible(false);
//	    	         l.dispose();
//	    	       }
//	    	     });
//	    	   }
//
//	    	 };
//	    	 worker.execute();
//	    	 l.setVisible(true);
//	    }
//	    
//		l.setLocationRelativeTo(this.getWizard().getWizardDialog().getFrame());
//		
//	    returnVal = chooser.showSaveDialog(null);
//	    if(returnVal == JFileChooser.APPROVE_OPTION) {
//	       System.out.println("Save PDF To: " +
//	            chooser.getSelectedFile().getPath());
//	       SwingWorker worker = new SwingWorker() {
//
//	    	   public String doInBackground() throws Exception {
//	    	     Thread.sleep(1000);
//	    	     eengine.createPDF(eengine.processFile("/assets/full_loading.html"), chooser.getSelectedFile().getPath());
//	    	     return null;
//	    	   }
//
//	    	   public void done() {
//	    	     SwingUtilities.invokeLater(new Runnable() {
//	    	       public void run() {
//	    	         l.setVisible(false);
//	    	         l.dispose();
//	    	       }
//	    	     });
//	    	   }
//
//	    	 };
//	    	 worker.execute();
//	    	 l.setVisible(true);
//	    }		
//	       System.exit(0);
    }
}
