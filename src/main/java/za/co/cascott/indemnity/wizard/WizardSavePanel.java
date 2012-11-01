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

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.PropertiesManager;
import za.co.cascott.fop.FOP;
import za.co.cascott.indemnity.Main;
import za.co.cascott.indemnity.input.html.TemplateEngine;
import za.co.cascott.template.engine.MustacheEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class WizardSavePanel extends WizardPanelDescriptor {
    //XHTMLPanel xpanel;
    JPanel xpanel;
    private int type;
    private SwingController controller;

    public WizardSavePanel(final int type) {
        this.type = type;
        JPanel newPanel = new JPanel();
        JPanel btnPanel = new JPanel();
        newPanel.setLayout(new BorderLayout(0, 0));
        JButton btnSaveReport = new JButton("Generate Report");
        btnSaveReport.setIcon(new ImageIcon(WizardSavePanel.class.getResource("/assets/icons/document-pdf-text.png")));
        btnSaveReport.setBounds(10, 11, 104, 23);
        btnSaveReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                genReport();
            }
        });
        btnPanel.add(btnSaveReport);

        JButton btnSaveLoading = new JButton("Generate Loading Report");
        btnSaveLoading.setIcon(new ImageIcon(WizardSavePanel.class.getResource("/assets/icons/document-pdf-text.png")));
        btnSaveLoading.setBounds(124, 11, 104, 23);
        btnSaveLoading.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (type == 0)
                    genShort();
                else if (type == 1)
                    genLong();
            }
        });
        btnPanel.add(btnSaveLoading);
        xpanel = new JPanel();
        controller = new SwingController();
        Properties props = new Properties();
        props.setProperty(PropertiesManager.PROPERTY_SHOW_UTILITY_SAVE, "false");
        props.setProperty(PropertiesManager.PROPERTY_SHOW_TOOLBAR_ANNOTATION, "false");
        props.setProperty("application.showLocalStorageDialogs", "false");
        props.setProperty("application.toolbar.show.utility.print", "false");
        props.setProperty("application.utilitypane.show.annotation", "false");

        PropertiesManager properties =
                new PropertiesManager(System.getProperties(), props,
                        ResourceBundle.getBundle(PropertiesManager.DEFAULT_MESSAGE_BUNDLE));

        controller.updateDocumentView();
        SwingViewBuilder factory = new SwingViewBuilder(controller, properties);

        xpanel.setLayout(new BorderLayout());

        xpanel.add(factory.buildViewerPanel(), BorderLayout.CENTER);

        //xpanel = new XHTMLPanel();
        xpanel.setPreferredSize(new Dimension(375, 100));

        JScrollPane scrollPane = new JScrollPane(xpanel);
        scrollPane.setPreferredSize(new Dimension(375, 100));

        newPanel.add(btnPanel, BorderLayout.NORTH);
        newPanel.add(scrollPane, BorderLayout.CENTER);

        setPanel(newPanel);
    }

    @Override
    public void complete() {
        //Note we remove this two times because number 4 becomes 3 after 3 gets removed.
        size = new Dimension(748, 570);
        this.getWizard().getWizardDialog().getHeaderPanel().remove(3);
        this.wiz.getWizardDialog().getBtnNext().setText("Exit");
        this.wiz.getWizardDialog().getBtnReaderButton().setVisible(false);
        this.wiz.getWizardDialog().getBtnAddSampleData().setVisible(false);
        this.wiz.getWizardDialog().getBtnCancel().setVisible(false);
    }

    @Override
    public WizardPanelDescriptor getNextDescriptor() {
        // TODO Auto-generated method stub
        return super.getNextDescriptor();
    }

    @Override
    public WizardPanelDescriptor getPrevDescriptor() {
        // TODO Auto-generated method stub
        return super.getPrevDescriptor();
    }

    private void genLong() {
        this.wiz.getDataCollection().calculate_fund_data();
        this.wiz.getDataCollection().calculate_long_loading();

        final Loading l = new Loading(this.getWizard().getWizardDialog().getFrame());
        l.setLocationRelativeTo(this.getWizard().getWizardDialog().getFrame());
        final JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("Loading Report"));
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("Save PDF To: " +
                    chooser.getSelectedFile().getPath());
            final String outpath;

            //If file name does not end in a pdf add pdf as extention.
            if (!chooser.getSelectedFile().getPath().endsWith(".pdf"))
                outpath = chooser.getSelectedFile().getPath() + ".pdf";
            else
                outpath = chooser.getSelectedFile().getPath();

            SwingWorker worker = new SwingWorker() {

                public String doInBackground() throws Exception {
                    URL ref = null;
                    try {
                        MustacheEngine templateEngine = new MustacheEngine();
                        templateEngine.setVariables(getWizard().getDataCollection().getModel());
                        FOP.getInstance().processFile("/assets/fo/full_loading.fo", outpath, templateEngine);
                        ref = new File(outpath).toURL();
                        controller.openDocument(ref);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        l.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Unable to save to location. The path does not exist or the file is in use.\n" +
                                "Please select another location to save the file.", "Error", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                    return null;
                }

                public void done() {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            l.setVisible(false);
                            l.dispose();
                        }
                    });
                }

            };
            worker.execute();
            l.setVisible(true);
        }
    }

    private void genShort() {
        this.wiz.getDataCollection().calculate_fund_data();
        this.wiz.getDataCollection().calculate_short_loading();

        final Loading l = new Loading(this.getWizard().getWizardDialog().getFrame());
        l.setLocationRelativeTo(this.getWizard().getWizardDialog().getFrame());
        final JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("Loading Report"));
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("Save PDF To: " +
                    chooser.getSelectedFile().getPath());
            final String outpath;
            if (!chooser.getSelectedFile().getPath().endsWith(".pdf"))
                outpath = chooser.getSelectedFile().getPath() + ".pdf";
            else
                outpath = chooser.getSelectedFile().getPath();

            SwingWorker worker = new SwingWorker() {
                public String doInBackground() throws Exception {
                    URL ref = null;
                    try {
                        MustacheEngine templateEngine = new MustacheEngine();
                        templateEngine.setVariables(getWizard().getDataCollection().getModel());
                        FOP.getInstance().processFile("/assets/fo/short_loading.fo", outpath, templateEngine);
                        ref = new File(outpath).toURL();
                        controller.openDocument(ref);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        l.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Unable to save to location. The path does not exist or the file is in use.\n" +
                                "Please select another location to save the file.", "Error", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                    return null;
                }

                public void done() {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            l.setVisible(false);
                            l.dispose();
                        }
                    });
                }

            };
            worker.execute();
            l.setVisible(true);
        }
    }

    private void genReport() {
        this.wiz.getDataCollection().calculate_fund_data();
        if (this.type == 0)
            this.wiz.getDataCollection().calculate_short_loading();
        else if (this.type == 1)
            this.wiz.getDataCollection().calculate_long_loading();

        final Loading l = new Loading(this.getWizard().getWizardDialog().getFrame());
        l.setLocationRelativeTo(this.getWizard().getWizardDialog().getFrame());
        final JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("Report"));
        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("Save PDF To: " +
                    chooser.getSelectedFile().getPath());
            final String outpath;
            if (!chooser.getSelectedFile().getPath().endsWith(".pdf"))
                outpath = chooser.getSelectedFile().getPath() + ".pdf";
            else
                outpath = chooser.getSelectedFile().getPath();

            SwingWorker worker = new SwingWorker() {

                public String doInBackground() throws Exception {
                    FOP fop = FOP.getInstance();

                    URL ref = null;
                    try {
                        MustacheEngine templateEngine = new MustacheEngine();
                        templateEngine.setVariables(getWizard().getDataCollection().getModel());
                        FOP.getInstance().processFile("/assets/fo/main.fo", outpath, templateEngine);
                        ref = new File(outpath).toURL();
                        controller.openDocument(ref);
                        //xpanel.setDocument(ref.toExternalForm());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        l.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Unable to save to location. The path does not exist or the file is in use.\n" +
                                "Please select another location to save the file.", "Unable to Save", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                    return null;
                }

                public void done() {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            l.setVisible(false);
                            l.dispose();
                        }
                    });
                }

            };
            worker.execute();
            l.setVisible(true);
        }
    }

    @Override
    public void nextbtnAction(ActionEvent event) {
        Main.getChannel().publish("shutdown");
//        System.exit(0);
    }

    @Override
    public void prevbtnAction(ActionEvent event) {
        super.prevbtnAction(event);
    }

    @Override
    public int cancelbtnAction(ActionEvent event) {
        return super.cancelbtnAction(event);
    }

    @Override
    public void testbtnAction(ActionEvent event) {
        super.testbtnAction(event);
    }

    @Override
    public String getBtnNextText() {
        return super.getBtnNextText();
    }

    @Override
    public String getBtnBackText() {
        return super.getBtnBackText();
    }

    @Override
    public String getBtnCancelText() {
        return super.getBtnCancelText();
    }

}
