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
import org.xhtmlrenderer.simple.XHTMLPanel;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    private XHTMLPanel xhtmlpanel;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rdbtnFullReport;
    private JRadioButton rdbtnShortForm;
    private JRadioButton rdbtnLongForm;
    private JRadioButton rdbtnLoadSavedData;

    /**
     * Create the panel.
     */
    public StartPanel() {
        setLayout(new MigLayout("", "[grow][]", "[grow]"));

        xhtmlpanel = new XHTMLPanel();

        JScrollPane scrollPane = new JScrollPane(xhtmlpanel);
        scrollPane.setPreferredSize(new Dimension(0, 0));
        add(scrollPane, "cell 0 0,grow");

        JPanel panel_1 = new JPanel();
        add(panel_1, "cell 1 0,grow");
        panel_1.setLayout(new MigLayout("", "[123px]", "[23px][][][]"));

        rdbtnFullReport = new JRadioButton("Full Report (default)");
        buttonGroup.add(rdbtnFullReport);
        panel_1.add(rdbtnFullReport, "cell 0 0,alignx left,aligny top");

        rdbtnLongForm = new JRadioButton("Long Form");
        buttonGroup.add(rdbtnLongForm);
        panel_1.add(rdbtnLongForm, "cell 0 1,alignx left,aligny top");

        rdbtnShortForm = new JRadioButton("Short Form");
        buttonGroup.add(rdbtnShortForm);
        panel_1.add(rdbtnShortForm, "cell 0 2,alignx left,aligny top");

        rdbtnLoadSavedData = new JRadioButton("Load Saved Data");
        rdbtnLoadSavedData.setToolTipText("Load Saved data from a previous session.");
        buttonGroup.add(rdbtnLoadSavedData);
        panel_1.add(rdbtnLoadSavedData, "cell 0 3,alignx left,aligny top");

    }

    public XHTMLPanel getXhtmlpanel() {
        return xhtmlpanel;
    }

    public JRadioButton getRdbtnFullReport() {
        return rdbtnFullReport;
    }

    public JRadioButton getRdbtnShortForm() {
        return rdbtnShortForm;
    }

    public JRadioButton getRdbtnLongForm() {
        return rdbtnLongForm;
    }

    public JRadioButton getRdbtnLoadSavedData() {
        return rdbtnLoadSavedData;
    }
}
