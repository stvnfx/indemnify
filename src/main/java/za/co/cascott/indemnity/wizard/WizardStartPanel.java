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

import za.co.cascott.indemnity.TempSystem;
import za.co.cascott.ui.StartPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WizardStartPanel extends WizardPanelDescriptor {
    private boolean canGoNext = false;

    public WizardStartPanel() {
        StartPage newPanel = new StartPage();
        setPanel(newPanel);
    }

    @Override
    public void complete() {
        size = new Dimension(668, 525);
        this.getWizard().getWizardDialog().getTopLabel().setText("<html></html>");
        //this.getWizard().getWizardDialog().getHeaderPanel().remove(3);
        //((MigLayout)this.getWizard().getWizardDialog().getHeaderPanel().getLayout()).setRowConstraints("[fill]");
    }

    @Override
    public void nextbtnAction(ActionEvent event) {

    }

    //Call to set new xhtml data but uses a file from jar.
    public void setInternalPage(String injarname) {
        final StartPage hw = ((StartPage) this.getPanel());
        try {
            @SuppressWarnings("deprecation")
            final URL ref = new File(TempSystem.getInstance().getInternalFile(injarname, "xhtml")).toURL(); //Deprecated? Looks like since Java 6
            //hw.getXhtmlpanel().setDocument(ref.toExternalForm());
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Error. Could not load internal xhtml object.");
            e.printStackTrace();
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error. Could not load internal xhtml object.");
            e.printStackTrace();
        }
    }

    protected void setup() {
        //Disable Back button
        wiz.disableBack();
        wiz.disableTestData();
//        wiz.disableSave();
//        wiz.disableSaveAs();

        //setInternalPage("/assets/welcome.html");
    }

    @Override
    public void prevbtnAction(ActionEvent event) {
        //Disabled Back
    }

    public WizardPanelDescriptor getNextDescriptor() {
        StartPanel p = ((StartPanel) this.getPanel());
        if (p.getRdbtnFullReport().isSelected()) {
            wiz.enableTestData();
            wiz.enableSave();
            wiz.enableSaveAs();
            return (new WizardFundDataPanel());
        } else if (p.getRdbtnLongForm().isSelected()) {
            wiz.enableSave();
            wiz.enableSaveAs();
        } else if (p.getRdbtnShortForm().isSelected()) {
            wiz.enableSave();
            wiz.enableSaveAs();
        } else if (p.getRdbtnLoadSavedData().isSelected()) {
            //We don't enable buttons since we loading...
        }
        return null;
    }
}
