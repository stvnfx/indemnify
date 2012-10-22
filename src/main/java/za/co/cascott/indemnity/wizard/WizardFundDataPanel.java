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
import java.awt.*;
import java.awt.event.ActionEvent;

public class WizardFundDataPanel extends WizardPanelDescriptor {
    private boolean canGoNext = false;

    public WizardFundDataPanel() {
        JPanel newPanel = new FundDatePanel();
        setPanel(newPanel);
    }

    @Override
    public void complete() {
        size = new Dimension(668, 525);
        this.getWizard().getWizardDialog().getTopLabel().setText("<html><center><font size=5>Assessment of level of indemnity<br> insurance cover required by the Fund</font><br><font size=3>&copy; 2012 CA Scott Consulting Actuary &ndash; All rights reserved</font></center></html>");

        JPanel panel = this.getWizard().getWizardDialog().getHeaderPanel();
        JPanel panel_1 = new JPanel();
        //panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.add(panel_1, "cell 0 3 6 1,growx,aligny top");
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        {
            JLabel lblPleaseCompleteAll = new JLabel("<html><center>Please complete pages 1 and 2 - All fields are compulsory</center></html>");
            lblPleaseCompleteAll.setForeground(new Color(140, 26, 26));
            lblPleaseCompleteAll.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 11));
            lblPleaseCompleteAll.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel_1.add(lblPleaseCompleteAll);
        }

        FundDatePanel p = ((FundDatePanel) this.getPanel());
        p.getNoDeathBens().setSelectedIndex(9);
        p.getNoMbrShares().setSelectedIndex(9);

    }

    @Override
    public void nextbtnAction(ActionEvent event) {
        /*DefaultPosition defPos = new DefaultPosition();
          defPos.setModal(true);
          defPos.setVisible(true);*/

        //Set colors back to normal
        //Validate the data.
        canGoNext = false;
        FundDatePanel p = ((FundDatePanel) this.getPanel());
        DataCollection c = wiz.getDataCollection();

        try {
            String fundName = p.getFundName().getText();
            if (fundName.isEmpty()) {
                //JOptionPane.showMessageDialog(null, "Fund Name cannot be empty.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getFundName());
                return;
            } else
                c.setFundName(fundName);

            String partEmp = p.getPartEmp().getText();
            if (isNumberOnly(partEmp)) {
                //JOptionPane.showMessageDialog(null, "Number of participating employers cannot be empty or contain letters.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getPartEmp());
                return;
            } else
                c.setPartEmp(Integer.parseInt(partEmp));

            String noPortfolios = p.getNoPortfolios().getText();
            if (isNumberOnly(noPortfolios)) {
                //JOptionPane.showMessageDialog(null, "Number of Portfolios cannot be empty or contain letters.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getNoPortfolios());
                return;
            }
            c.setNoPortfolios(Integer.parseInt(noPortfolios));

            String annPremium = p.getAnnPremium().getText();
            if (isNumberOnly(annPremium)) {
                //JOptionPane.showMessageDialog(null, "Annual premium cannot be empty or contain letters.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getAnnPremium());
                return;
            }
            c.setAnnPremium(Integer.parseInt(annPremium));

            String indemnityLimit = p.getIndemnityLimit().getText();
            if (isNumberOnly(indemnityLimit)) {
                //JOptionPane.showMessageDialog(null, "Indemnity limit cannot be empty or contain letters.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getIndemnityLimit());
                return;
            }
            c.setIndemnityLimit(Long.parseLong(indemnityLimit));

            String firstAmount = p.getFirstAmount().getText();
            if (isNumberOnly(firstAmount)) {
                //JOptionPane.showMessageDialog(null, "First amount payable cannot be empty or contain letters.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getFirstAmount());
                return;
            }
            c.setFirstAmount(Long.parseLong(firstAmount));

            String highClaim = p.getHighClaim().getText();
            if (isNumberOnly(highClaim)) {
                //JOptionPane.showMessageDialog(null, "High Claim cannot be empty or contain letters.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getHighClaim());
                return;
            }
            c.setHighClaim(Long.parseLong(highClaim));

            String aggClaim = p.getAggClaim().getText();
            if (isNumberOnly(aggClaim)) {
                //JOptionPane.showMessageDialog(null, "Aggregate Claim cannot be empty or contain letters.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getAggClaim());
                return;
            }
            c.setAggClaim(Long.parseLong(aggClaim));

            String noMembers = p.getNoMembers().getText();
            if (isNumberOnly(noMembers)) {
                //JOptionPane.showMessageDialog(null, "Number of Members cannot be empty or contain letters.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getNoMembers());
                return;
            }
            c.setNoMembers(Integer.parseInt(noMembers));

            String annCons = p.getAnnCons().getText();
            if (isNumberOnly(annCons)) {
                //JOptionPane.showMessageDialog(null, "Annual Contributions cannot be empty or contain letters.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getAnnCons());
                return;
            }
            c.setAnnCons(Long.parseLong(annCons));

            String valInvest = p.getValInvest().getText();
            if (isNumberOnly(valInvest)) {
                //JOptionPane.showMessageDialog(null, "Value of Investments cannot be empty or contain letters.");
                JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                setErrorColor(p.getValInvest());
                return;
            }
            c.setValInvest(Long.parseLong(valInvest));

            int count = (Integer) p.getNoDeathBens().getSelectedItem();
            c.setNoDeathBens(count);
            if (count > 0) {
                String db1 = p.getDb1().getText();
                if (isNumberOnly(db1)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getDb1());
                    return;
                } else
                    c.setDb1(Long.parseLong(db1));
            }

            if (count > 1) {
                String db2 = p.getDb2().getText();
                if (isNumberOnly(db2)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getDb2());
                    return;
                } else
                    c.setDb2(Long.parseLong(db2));
            }

            if (count > 2) {
                String db3 = p.getDb3().getText();
                if (isNumberOnly(db3)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getDb3());
                    return;
                } else
                    c.setDb3(Long.parseLong(db3));
            }

            if (count > 3) {
                String db4 = p.getDb4().getText();
                if (isNumberOnly(db4)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getDb4());
                    return;
                } else
                    c.setDb4(Long.parseLong(db4));
            }

            if (count > 4) {
                String db5 = p.getDb5().getText();
                if (isNumberOnly(db5)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getDb5());
                    return;
                } else
                    c.setDb5(Long.parseLong(db5));
            }

            if (count > 5) {
                String db6 = p.getDb6().getText();
                if (isNumberOnly(db6)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getDb6());
                    return;
                } else
                    c.setDb6(Long.parseLong(db6));
            }

            if (count > 6) {
                String db7 = p.getDb7().getText();
                if (isNumberOnly(db7)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getDb7());
                    return;
                } else
                    c.setDb7(Long.parseLong(db7));
            }

            if (count > 7) {
                String db8 = p.getDb8().getText();
                if (isNumberOnly(db8)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getDb8());
                    return;
                } else
                    c.setDb8(Long.parseLong(db8));
            }

            if (count > 8) {
                String db9 = p.getDb9().getText();
                if (isNumberOnly(db9)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getDb9());
                    return;
                } else
                    c.setDb9(Long.parseLong(db9));
            }

            if (count > 9) {
                String db10 = p.getDb10().getText();
                if (isNumberOnly(db10)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getDb10());
                    return;
                } else
                    c.setDb10(Long.parseLong(db10));
            }

            //////////////////////////////////////////////////////////////
            count = (Integer) p.getNoMbrShares().getSelectedItem();
            c.setNoMbrShares(count);
            if (count > 0) {
                String ms1 = p.getMs1().getText();
                if (isNumberOnly(ms1)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getMs1());
                    return;
                } else
                    c.setMs1(Long.parseLong(ms1));
            }

            if (count > 1) {
                String ms2 = p.getMs2().getText();
                if (isNumberOnly(ms2)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getMs2());
                    return;
                } else
                    c.setMs2(Long.parseLong(ms2));
            }

            if (count > 2) {
                String ms3 = p.getMs3().getText();
                if (isNumberOnly(ms3)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getMs3());
                    return;
                } else
                    c.setMs3(Long.parseLong(ms3));
            }

            if (count > 3) {
                String ms4 = p.getMs4().getText();
                if (isNumberOnly(ms4)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getMs4());
                    return;
                } else
                    c.setMs4(Long.parseLong(ms4));
            }

            if (count > 4) {
                String ms5 = p.getMs5().getText();
                if (isNumberOnly(ms5)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getMs5());
                    return;
                } else
                    c.setMs5(Long.parseLong(ms5));
            }

            if (count > 5) {
                String ms6 = p.getMs6().getText();
                if (isNumberOnly(ms6)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getMs6());
                    return;
                } else
                    c.setMs6(Long.parseLong(ms6));
            }

            if (count > 6) {
                String ms7 = p.getMs7().getText();
                if (isNumberOnly(ms7)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getMs7());
                    return;
                } else
                    c.setMs7(Long.parseLong(ms7));
            }

            if (count > 7) {
                String ms8 = p.getMs8().getText();
                if (isNumberOnly(ms8)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getMs8());
                    return;
                } else
                    c.setMs8(Long.parseLong(ms8));
            }

            if (count > 8) {
                String ms9 = p.getMs9().getText();
                if (isNumberOnly(ms9)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getMs9());
                    return;
                } else
                    c.setMs9(Long.parseLong(ms9));
            }

            if (count > 9) {
                String ms10 = p.getMs10().getText();
                if (isNumberOnly(ms10)) {
                    JOptionPane.showMessageDialog(null, "Some fields are incorrect or empty.");
                    setErrorColor(p.getMs10());
                    return;
                } else
                    c.setMs10(Long.parseLong(ms10));
            }
            c.setCoverFrom(p.getCoverFrom().getDate());
            c.setCoverTo(p.getCoverTo().getDate());
            c.setRetroDate(p.getRetroDate().getDate());
            c.setEffectiveDate(p.getEffectiveDate().getDate());
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Some fields have data that can't be parsed.\nPlease remove any special characters.");
            return;
        } catch (java.lang.Exception e) {
            JOptionPane.showMessageDialog(null, "Unknown Error. Read Report.");
            e.printStackTrace();
            return;
        }
        canGoNext = true;
    }

    private void setErrorColor(JComponent c) {
        Color errcolor = new Color(255, 181, 181); //Soft-ish red color
        c.setBackground(errcolor);
    }

    private boolean isNotEmpty(String a) {
        if (a.isEmpty())
            return false;
        return true;
    }

    private boolean isNumberOnly(String a) {
        if (isNotEmpty(a)) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isNegativeNumber(String a) {
        if (Integer.parseInt(a) < 1) {
            return true;
        }
        return false;
    }

    protected void setup() {
        //Disable Back button
        wiz.disableBack();

        FundDatePanel p = ((FundDatePanel) this.getPanel());

        //Set Defaults
        p.getPreservationFundNo().doClick();
        p.getInvestmentChoice().addItem("Yes");
        p.getInvestmentChoice().addItem("No");

        p.getClaimsYN().addItem("Yes");
        p.getClaimsYN().addItem("No");

        //1 - 10
        for (int i = 1; i < 11; i++) {
            p.getNoDeathBens().addItem(i);
            p.getNoMbrShares().addItem(i);
        }

        //TODO: Add Input error handling.
    }

    @Override
    public void testbtnAction(ActionEvent event) {
        final FundDatePanel p = ((FundDatePanel) this.getPanel());
        final DataCollection c = wiz.getDataCollection();
        c.populateWithTestData();

        p.getEffectiveDate().setDate(c.getEffectiveDate());
        p.getCoverFrom().setDate(c.getCoverFrom());
        p.getCoverTo().setDate(c.getCoverTo());
        p.getRetroDate().setDate(c.getRetroDate());
//		try {
//			
//			p.getCoverFrom().setDate(testDate);
//			//p.getCoverTo().setDate(c.getCoverTo());
//			//p.getRetroDate().setDate(c.getRetroDate());
//			//p.getEffectiveDate().setDate(c.getEffectiveDate());
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}

        //Set Sample Values.
        p.getFundName().setText(c.getFundName());
        //p.getEffectiveDate().setValue(c.getEffectiveDate());
        p.getPreservationFundNo().doClick();
        p.getPartEmp().setText(String.valueOf(c.getPartEmp()));
        p.getNoPortfolios().setText(Integer.toString(c.getNoPortfolios()));
        p.getIndemnityLimit().setText(c.getZformatter().format(c.getIndemnityLimit()));
        p.getAnnPremium().setText(c.getZformatter().format(c.getAnnPremium()));
        p.getFirstAmount().setText(c.getZformatter().format(c.getFirstAmount()));

        //Second page.
        p.getNoMembers().setText(Integer.toString(c.getNoMembers()));
        p.getAnnCons().setText(c.getZformatter().format(c.getAnnCons()));
        p.getValInvest().setText(c.getZformatter().format(c.getValInvest()));
        p.getHighClaim().setText(c.getZformatter().format(c.getHighClaim()));
        p.getAggClaim().setText(c.getZformatter().format(c.getAggClaim()));

        p.getNoDeathBens().setSelectedIndex(9);
        p.getNoMbrShares().setSelectedIndex(9);
        p.getDb1().setText(c.getZformatter().format(c.getDb1()));
        p.getDb2().setText(c.getZformatter().format(c.getDb2()));
        p.getDb3().setText(c.getZformatter().format(c.getDb3()));
        p.getDb4().setText(c.getZformatter().format(c.getDb4()));
        p.getDb5().setText(c.getZformatter().format(c.getDb5()));
        p.getDb6().setText(c.getZformatter().format(c.getDb6()));
        p.getDb7().setText(c.getZformatter().format(c.getDb7()));
        p.getDb8().setText(c.getZformatter().format(c.getDb8()));
        p.getDb9().setText(c.getZformatter().format(c.getDb9()));
        p.getDb10().setText(c.getZformatter().format(c.getDb10()));

        p.getMs1().setText(c.getZformatter().format(c.getMs1()));
        p.getMs2().setText(c.getZformatter().format(c.getMs2()));
        p.getMs3().setText(c.getZformatter().format(c.getMs3()));
        p.getMs4().setText(c.getZformatter().format(c.getMs4()));
        p.getMs5().setText(c.getZformatter().format(c.getMs5()));
        p.getMs6().setText(c.getZformatter().format(c.getMs6()));
        p.getMs7().setText(c.getZformatter().format(c.getMs7()));
        p.getMs8().setText(c.getZformatter().format(c.getMs8()));
        p.getMs9().setText(c.getZformatter().format(c.getMs9()));
        p.getMs10().setText(c.getZformatter().format(c.getMs10()));

        /*
           * Reset the data collection because we don't need it anymore. We re-add them later.
           */
        this.wiz.newDataCollection();
    }

    @Override
    public void prevbtnAction(ActionEvent event) {
        //Disabled Back
    }

    public WizardPanelDescriptor getNextDescriptor() {
        //TODO: Remove this unused block?
        //defPos.setVisible(true);
        //defPos.setModal(true);
        //int dCompvalue = defPos.getCompl();
        //int dCompvalue = defPos.getCompl();
        if (canGoNext) {
//			this.wiz.getDataCollection().caluclate_fund_data();
//			int short_msg;
//			int continue_msg = JOptionPane.showConfirmDialog(null, "The Report has now been populated. Do you want to complete the Risk Assessment Now?",
//					"Complete the Risk Assessment?", JOptionPane.YES_NO_OPTION);
//			if (continue_msg == JOptionPane.YES_OPTION) {
//				short_msg = JOptionPane.showConfirmDialog(null, "Do you want to complete the short-form version of the Risk Assessment?\n" +
//						"(9 questions instead of 33)",
//						"Complete the Short-form Risk Assessment?", JOptionPane.YES_NO_OPTION);
//				if (short_msg == JOptionPane.YES_OPTION) {
//					return (new WizardDefaultPositionPanel());
//				} else {
//					return (new WizardRiskLoadingPanel());
//				}
//			} else {
//			    JFileChooser chooser = new JFileChooser();
//			    int returnVal = chooser.showSaveDialog(null);
//			    if(returnVal == JFileChooser.APPROVE_OPTION) {
//			       System.out.println("Save PDF To: " +
//			            chooser.getSelectedFile().getPath());
//			       TemplateEngine eengine1 = new TemplateEngine(this.wiz.getDataCollection());
//			       try {
//			    	   eengine1.createPDF(eengine1.processFile("/assets/main.html"), chooser.getSelectedFile().getPath());
//			       } catch (IOException e) {
//			    	   e.printStackTrace();
//			       } catch (DocumentException e) {
//			    	   e.printStackTrace();
//			       }
//			    }
//			}

            int short_msg = JOptionPane.showConfirmDialog(null, "Do you want to complete the short-form version of the Risk Assessment?\n" +
                    "(9 questions instead of 33)",
                    "Complete the Short-form Risk Assessment?", JOptionPane.YES_NO_OPTION);
            if (short_msg == JOptionPane.YES_OPTION) {
                return (new WizardDefaultPositionPanel());
            } else {
                return (new WizardRiskLoadingPanel());
            }
        }
        return null;
    }
}
