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
import za.co.cascott.indemnity.TempSystem;
import za.co.cascott.indemnity.pdfreader.PDFReader;
import za.co.cascott.ui.Logger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WizardDialog extends JFrame {

    private final JPanel contentPanel = new JPanel();

    private JPanel mainPanel;
    private JButton btnNext;
    private JButton btnBack;
    private JButton btnCancel;
    private JPopupMenu mnu;

    boolean changed = true;
    int w = 0;
    int h = 0;
    private JLabel lblshortformAssessmentOf;
    private JPanel panel;
    private JMenuItem btnAddSampleData;
    private JMenuItem btnReg;
    private JMenuItem btnCalcRPN;
    private JMenuItem btnCalc;
    private JMenuItem saveinput;
    private JMenuItem saveasinput;
    private JMenuItem btnLogger;

    private JButton btnReaderButton;
    private Component horizontalStrut;
    private JButton btnOptions;

    public JPanel getContentPanel() {
        return contentPanel;
    }

    /**
     * Create the dialog.
     */
    public WizardDialog() {
        createUI();
    }

    private void createUI() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(WizardDialog.class.getResource("/assets/icons/32.png")));
        setBounds(100, 100, 705, 525);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        contentPanel.setLayout(new BorderLayout(0, 0));
        this.setTitle("...");

        panel = new JPanel();
        panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        panel.setMinimumSize(new Dimension(20, 20));
        contentPanel.add(panel, BorderLayout.NORTH);
        panel.setLayout(new MigLayout("", "[203px][5px][285px][203px][5px][285px]", "[62px][][24px]"));
        {

            JLabel wizzardImage = new JLabel("");
            wizzardImage.setAlignmentY(Component.TOP_ALIGNMENT);
            wizzardImage.setAlignmentX(Component.CENTER_ALIGNMENT);
            wizzardImage.setIcon(new ImageIcon(WizardDialog.class.getResource("/assets/iNdemnifyLogoTransparent.png")));
            panel.add(wizzardImage, "cell 0 0,alignx left,aligny center");
        }
        {
            lblshortformAssessmentOf = new JLabel("<html>\r\n<center>\r\nLoading...\r\n</center>\r\n</html>");
            lblshortformAssessmentOf.setAlignmentX(Component.RIGHT_ALIGNMENT);
            lblshortformAssessmentOf.setHorizontalAlignment(SwingConstants.CENTER);
            lblshortformAssessmentOf.setForeground(new Color(140, 26, 26));
            lblshortformAssessmentOf.setFont(new Font("Calibri", Font.BOLD, 13));
            panel.add(lblshortformAssessmentOf, "cell 2 0 4 1,alignx center,aligny top");
        }
        {
            Component verticalStrut = Box.createVerticalStrut(10);
            panel.add(verticalStrut, "cell 2 1");
        }
        {
            JPanel panel_1 = new JPanel();
            panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            panel.add(panel_1, "cell 0 2 6 1,growx,aligny top");
            panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            {
                JLabel lblPleaseCompleteAll = new JLabel("Please complete all sections of the form and then select <Next> to proceed\r\n");
                lblPleaseCompleteAll.setFont(new Font("Tahoma", Font.BOLD, 11));
                lblPleaseCompleteAll.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel_1.add(lblPleaseCompleteAll);
            }
        }
        {
            mainPanel = new ImagePanel("/assets/bgpanel.png");
            contentPanel.add(mainPanel, BorderLayout.CENTER);
            mainPanel.setAutoscrolls(true);
            mainPanel.addContainerListener(new ContainerAdapter() {
                @Override
                public void componentAdded(ContainerEvent arg0) {
                    changed = true;
                }
            });
            mainPanel.addPropertyChangeListener(new PropertyChangeListener() {
                public void propertyChange(PropertyChangeEvent arg0) {

                }
            });
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBorder(new MatteBorder(1, 0, 0, 0, (Color) SystemColor.scrollbar));
            FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT);
            buttonPane.setLayout(fl_buttonPane);
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                btnReaderButton = new JButton("Read PF130");
                btnReaderButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        Runnable toRun = new Runnable() {
                            public void run() {
                                try {
                                    PDFReader pdfr = PDFReader.getInstance();
                                    @SuppressWarnings("deprecation")
                                    final URL ref = new File(TempSystem.getInstance().getInternalFile("/assets/docs/pf130/PF130.pdf", "pdf")).toURL(); //Deprecated? Looks like since Java 6.
                                    pdfr.openDocument(ref.getFile());
                                    pdfr.showViewer();
                                } catch (MalformedURLException err) {
                                } catch (NullPointerException err) {
                                }
                            }
                        };
                        (new Thread(toRun)).start();


                    }
                });
                {
                    mnu = new JPopupMenu();

                    btnLogger = new JMenuItem();
                    btnLogger.setIcon(new ImageIcon(WizardDialog.class.getResource("/assets/icons/report--exclamation.png")));
                    btnLogger.setText("View Logger");
                    mnu.add(btnLogger);
                    btnLogger.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Logger.getInstance().setVisible(true);
                        }
                    });

                    mnu.add(new JSeparator());

                    btnAddSampleData = new JMenuItem();
                    btnAddSampleData.setIcon(new ImageIcon(WizardDialog.class.getResource("/assets/icons/document--pencil.png")));
                    btnAddSampleData.setText("Add Sample Data");
                    mnu.add(btnAddSampleData);

                    mnu.add(new JSeparator());

                    JMenuItem about = new JMenuItem();
                    about.setIcon(new ImageIcon(WizardDialog.class.getResource("/assets/icons/question.png")));
                    about.setText("About");
                    about.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            About a = new About();
                            a.setVisible(true);
                        }
                    });
                    mnu.add(about);

                    btnOptions = new JButton("Options");
                    btnOptions.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            mnu.show(btnOptions, 0, (int) btnOptions.getSize().getHeight());
                        }
                    });
                    btnOptions.setIcon(new ImageIcon(WizardDialog.class.getResource("/assets/icons/toolbox.png")));
                    buttonPane.add(btnOptions);
                }
                btnReaderButton.setIcon(new ImageIcon(WizardDialog.class.getResource("/assets/icons/document-text 16x16.png")));
                buttonPane.add(btnReaderButton);
            }
            {
                horizontalStrut = Box.createHorizontalStrut(20);
                buttonPane.add(horizontalStrut);
            }
            {
                btnBack = new JButton("Back");
                btnBack.setIcon(new ImageIcon(WizardDialog.class.getResource("/assets/icons/arrow-180.png")));
                buttonPane.add(btnBack);
            }
            {
                btnNext = new JButton("Next");
                btnNext.setIcon(new ImageIcon(WizardDialog.class.getResource("/assets/icons/arrow.png")));
                btnNext.setActionCommand("OK");
                buttonPane.add(btnNext);
                getRootPane().setDefaultButton(btnNext);
            }
            {
                btnCancel = new JButton("Cancel");
                btnCancel.setIcon(new ImageIcon(WizardDialog.class.getResource("/assets/icons/cross.png")));
                btnCancel.setActionCommand("Cancel");
                buttonPane.add(btnCancel);
            }
        }

        //moved to bottom.
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (changed) {
                    changed = false;
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getBtnNext() {
        return btnNext;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void getSet() {
        btnNext.setText("Save");
    }

    public JFrame getFrame() {
        return this;
    }

    public JLabel getTopLabel() {
        return lblshortformAssessmentOf;
    }

    public JPanel getHeaderPanel() {
        return panel;
    }

    public JMenuItem getBtnAddSampleData() {
        return btnAddSampleData;
    }

    public JButton getBtnReaderButton() {
        return btnReaderButton;
    }

    public JMenuItem getSaveinput() {
        return saveinput;
    }

    public JMenuItem getSaveasinput() {
        return saveasinput;
    }

}
