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
import za.co.cascott.indemnity.GlobalProperties;

import javax.swing.*;

/**
 * Wizard System.
 * <p/>
 * Note: You should no longer use this class since it will be removed and
 * decoupled from the Indemnify application.
 *
 * @author Steven Fourie
 */
@Deprecated
public class Wizard {
    private WizardDialog wizzardDlg;

    //TODO: Remove DataCollection from Wizzard. It should not be Here.
    private DataCollection dt;

    @Deprecated
    public Wizard() {
        wizzardDlg = new WizardDialog();
        wizzardDlg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wizzardDlg.setTitle("CA Scott Indemnity Insurance - v" + GlobalProperties.getInstance().getVersion());
        dt = new DataCollection();
    }


    @Deprecated
    public void showWizard() {
        wizzardDlg.setVisible(true);
    }

    @Deprecated
    public void hideWizard() {
        wizzardDlg.setVisible(false);
    }

    @Deprecated
    public WizardDialog getWizardDialog() {
        return wizzardDlg;
    }

    @Deprecated
    public final void setWizardTitle() {

    }

    @Deprecated
    public final JPanel getContentPanel() {
        return wizzardDlg.getContentPanel();
    }

    @Deprecated
    public final JPanel getMainPanel() {
        return wizzardDlg.getMainPanel();
    }

    @Deprecated
    public final void setWindowTitle(String title) {
        wizzardDlg.setTitle(title);
    }

    @Deprecated
    public final void disableBack() {
        wizzardDlg.getBtnBack().setEnabled(false);
        wizzardDlg.getBtnBack().setVisible(false);
    }

    @Deprecated
    public final void disableNext() {
        wizzardDlg.getBtnNext().setEnabled(false);
        wizzardDlg.getBtnNext().setVisible(false);
    }

    @Deprecated
    public void setDataCollection(DataCollection data) {
        dt = data;
    }

    @Deprecated
    public DataCollection getDataCollection() {
        return dt;
    }

    @Deprecated
    public void setNextText(String string) {
        wizzardDlg.getSet();
    }

    @Deprecated
    public void newDataCollection() {
        dt = new DataCollection();
    }

    @Deprecated
    public void disableTestData() {
        wizzardDlg.getBtnAddSampleData().setEnabled(false);
    }

    @Deprecated
    public void disableSave() {
        wizzardDlg.getSaveinput().setEnabled(false);
    }

    @Deprecated
    public void disableSaveAs() {
        wizzardDlg.getSaveasinput().setEnabled(false);
    }

    @Deprecated
    public void enableTestData() {
        wizzardDlg.getBtnAddSampleData().setEnabled(true);
    }

    @Deprecated
    public void enableSave() {
        wizzardDlg.getSaveinput().setEnabled(true);
    }

    @Deprecated
    public void enableSaveAs() {
        wizzardDlg.getSaveasinput().setEnabled(true);
    }
}
