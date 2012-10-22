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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/* You should override this class */
@Deprecated
public abstract class WizardPanelDescriptor {
    private static Logger logger = Logger.getLogger(WizardPanelDescriptor.class.getName());

    private static final String PANEL_IDENTIFIER = "defaultPanelIdentifier";
    private JPanel panel;
    private Object panelIdentifier;
    protected String nextBtnText;
    protected String backBtnText;
    protected Wizard wiz;

    public Dimension size;

    public WizardPanelDescriptor() {
        this.nextBtnText = "Next";
        this.backBtnText = "Back";
        this.panelIdentifier = PANEL_IDENTIFIER;
        size = new Dimension(400, 400);
    }

    //Called after your added and refreshed.
    public void complete() {

    }

    public final JPanel getPanel() {
        return this.panel;
    }

    protected final void setPanel(JPanel newPanel) {
        this.panel = newPanel;
    }

    protected final void setWizard(Wizard w) {
        this.wiz = w;
    }

    protected final Wizard getWizard() {
        return this.wiz;
    }

    protected void setup() {
        //Setup dialogs and wiz here.
    }

    /**
     * Returns the unique Object-based identifier for this panel descriptor.
     *
     * @return The Object-based identifier
     */
    public final Object getPanelDescriptorIdentifier() {
        return this.panelIdentifier;
    }

    /* You should set the following your self with the WizardManager. */
    /*
      * Return next panel.
      */
    public WizardPanelDescriptor getNextDescriptor() {
        return null;
    }

    /*
      * Return prev panel
      */
    public WizardPanelDescriptor getPrevDescriptor() {
        return null;
    }

    /*
      * The Buttons
      * These buttons are just for making quick decisions on the next descriptor or
      * not.
      * */

    public void nextbtnAction(ActionEvent event) {
    }

    public void prevbtnAction(ActionEvent event) {
    }

    //This is for making any decisions based on the input...
    public void anyAction(ActionEvent event) {
    }


    public int cancelbtnAction(ActionEvent event) {
        logger.log(Level.FINEST, "Cancel Button Pressed.");
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            return 1;
        } else {
            return 0;
        }
    }

    public void testbtnAction(ActionEvent event) {
    }

    public String getBtnNextText() {
        return nextBtnText;
    }

    public String getBtnBackText() {
        return "Back";
    }

    public String getBtnCancelText() {
        return backBtnText;
    }

    public Dimension getSize() {
        return size;
    }
}
