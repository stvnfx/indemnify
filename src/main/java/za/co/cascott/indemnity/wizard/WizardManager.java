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

import za.co.cascott.indemnity.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@Deprecated
public class WizardManager {
    private static Logger logger = Logger.getLogger(WizardManager.class.getName());

    HashMap<Object, WizardPanelDescriptor> wizardPanelCollection;
    Wizard wizard;
    private WizardPanelDescriptor currentDescriptor;
    JPanel wizardPanel;

    public WizardManager() {
        wizardPanelCollection = new HashMap<Object, WizardPanelDescriptor>();
        wizard = new Wizard();
    }

    public void setupButtons(WizardPanelDescriptor paneldescriptor) {
        //Register
        wizard.getWizardDialog().getBtnNext().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                currentDescriptor.nextbtnAction(arg0);
                WizardPanelDescriptor tmp = currentDescriptor.getNextDescriptor();
                if (tmp != null) {
                    WizardPanelDescriptor a = (WizardPanelDescriptor) wizardPanelCollection.get(tmp.getPanelDescriptorIdentifier());
                    if (a != null)
                        wizardPanelCollection.put(a.getPanelDescriptorIdentifier(), tmp);
                    currentDescriptor = tmp;
                    tmp.setWizard(wizard);
                    tmp.setup();
                    goNext();
                }
            }
        });

        wizard.getWizardDialog().getBtnBack().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                currentDescriptor.prevbtnAction(arg0);
                WizardPanelDescriptor tmp = currentDescriptor.getPrevDescriptor();
                if (tmp != null) {
                    WizardPanelDescriptor a = wizardPanelCollection.get(tmp.getPanelDescriptorIdentifier());
//					System.out.println("FrE");
//					System.out.println(a);
                    if (a != null) {
                        wizardPanelCollection.put(a.getPanelDescriptorIdentifier(), tmp);
                        currentDescriptor = a;
                    } else {
                        currentDescriptor = tmp;
                    }
                    goBack();
                }
            }
        });

        wizard.getWizardDialog().getBtnCancel().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (currentDescriptor.cancelbtnAction(arg0) == 1) {
                    shutdown();
                    Main.getChannel().publish("shutdown");
                }
            }
        });

        wizard.getWizardDialog().getBtnAddSampleData().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                currentDescriptor.testbtnAction(arg0);
            }
        });
    }

    private void shutdown() {
        wizard.hideWizard();
        wizardPanelCollection.clear();
        wizard = null;
    }

    private void refreshMainPanel() {
        logger.log(Level.FINER, "Refreshing Main Panel");
        //wizard.getWizardDialog().setSize(currentDescriptor.getPanel().getBounds().width, currentDescriptor.getPanel().getBounds().height);
        //wizard.getMainPanel().repaint();
        //wizard.getMainPanel().revalidate();
        wizard.getContentPanel().repaint();
        wizard.getContentPanel().revalidate();
        //currentDescriptor.getPanel().setSize(wizard.getWizardDialog().getSize().width, wizard.getWizardDialog().getSize().height);

        currentDescriptor.complete();
        wizard.getContentPanel().remove(1);
        wizard.getContentPanel().add(currentDescriptor.getPanel(), BorderLayout.CENTER);
        //wizard.getWizardDialog().setSize(currentDescriptor.getPanel().getSize());
        //wizard.getWizardDialog().setSize(wizard.getContentPanel().getComponent(1).getSize());
        wizard.getWizardDialog().setSize(currentDescriptor.getSize());
    }

    public void goNext() {
        logger.log(Level.FINER, "Next Panel");
        //wizard.getMainPanel().removeAll();
        //wizard.getMainPanel().removeAll();
        //wizard.getWizardDialog().getBtnNext().setText(currentDescriptor.getBtnNextText());
        //wizard.getMainPanel().add(currentDescriptor.getPanel());
        wizard.getContentPanel().remove(1);
        wizard.getContentPanel().add(currentDescriptor.getPanel(), BorderLayout.CENTER);
        refreshMainPanel();
    }

    public void goBack() {
        logger.log(Level.FINER, "Previous Panel");
        //wizard.getMainPanel().removeAll();
        //wizard.getMainPanel().add(currentDescriptor.getPanel());
        wizard.getContentPanel().remove(1);
        wizard.getContentPanel().add(currentDescriptor.getPanel(), BorderLayout.CENTER);
        refreshMainPanel();
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void registerFirstWizardDescriptor(WizardPanelDescriptor paneldescriptor) {
        logger.log(Level.FINER, "First Panel Registered");
        wizardPanelCollection.put((Object) paneldescriptor.getPanelDescriptorIdentifier(), paneldescriptor);
        currentDescriptor = paneldescriptor;
        currentDescriptor.setWizard(wizard);
        currentDescriptor.setup();
        wizard.getMainPanel().add(wizardPanelCollection.get(paneldescriptor.getPanelDescriptorIdentifier()).getPanel());
        setupButtons(paneldescriptor);
        refreshMainPanel();
    }

    /*
      * Start's the wizard (The first Descriptor should have been provided).
      */
    public void startWizard() {
        logger.log(Level.FINER, "Starting Wizard.");
        if (currentDescriptor == null)
            throw new NoDescriptorSetException();
        wizard.showWizard();
    }
}
