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
import java.awt.*;

public class WizardDefaultPositionPanel extends WizardPanelDescriptor {
    public WizardDefaultPositionPanel() {
        JPanel newPanel = new DefaultPositionPanel();
        setPanel(newPanel);
    }

    @Override
    public void complete() {
        size = new Dimension(541, 275);
        this.getWizard().getWizardDialog().getTopLabel().setText("<html><center><font size=5>Select an overall default position</font><br><font size=3>&copy; 2012 CA Scott Consulting Actuary &ndash; All rights reserved</font></center></html>");
        this.getWizard().getWizardDialog().getBtnAddSampleData().setEnabled(false);
        //Note we remove this two times because number 4 becomes 3 after 3 gets removed.
        this.getWizard().getWizardDialog().getHeaderPanel().remove(3);
        this.getWizard().getWizardDialog().getHeaderPanel().remove(3);
        ((MigLayout) this.getWizard().getWizardDialog().getHeaderPanel().getLayout()).setRowConstraints("[fill]");
        ((DefaultPositionPanel) this.getPanel()).dcMin.setSelected(true);
        ((DefaultPositionPanel) this.getPanel()).rdbtnLight.setSelected(true);
        this.wiz.getDataCollection().dc = "minimal";
        this.wiz.getDataCollection().rw = "light";
    }

    public WizardPanelDescriptor getNextDescriptor() {
        if (((DefaultPositionPanel) this.getPanel()).dc != null)
            this.wiz.getDataCollection().dc = ((DefaultPositionPanel) this.getPanel()).dc;
        if (((DefaultPositionPanel) this.getPanel()).rw != null)
            this.wiz.getDataCollection().rw = ((DefaultPositionPanel) this.getPanel()).rw;
        return (new WizardShortRiskLoadingPanel());
    }

    public WizardPanelDescriptor getPrevDescriptor() {
        return null;
    }
}
