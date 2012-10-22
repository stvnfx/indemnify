/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

/*
 * Created on Jun 24, 2005
 */
package za.co.cascott.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * @author Christopher Butler
 */
public class Titlepane extends JPanel {
    private Titlebar titlebar;
    private JComponent contentPane;

    public Titlepane(String title) {
        setLayout(new BorderLayout());

        titlebar = createTitlebar(title);
        add(titlebar, BorderLayout.NORTH);
        setContentPane(createContentPane());
    }

    public String getTitle() {
        return titlebar.getText();
    }

    public void setTitle(String title) {
        titlebar.setTitle(title);
    }

    public JLabel getTitlebar() {
        return titlebar;
    }

    protected Titlebar createTitlebar(String title) {
        return new Titlebar(title, new Color(160, 82, 80));
    }

    public void setContentPane(JComponent comp) {
        if(contentPane!=null)
            remove(contentPane);
        if(comp!=null)
            add(comp, BorderLayout.CENTER);
        contentPane = comp;
    }

    protected JComponent createContentPane() {
        JPanel pane = new JPanel();
        pane.setBorder(new LineBorder(Color.DARK_GRAY));
        pane.setBackground(Color.WHITE);
        return pane;
    }
}
