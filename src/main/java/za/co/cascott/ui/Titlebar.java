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
 * Created on Jul 6, 2005
 */
package za.co.cascott.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;

/**
 * @author Christopher Butler
 */
public class Titlebar extends JLabel {

    public Titlebar() {
        super();
        init();
    }

    public Titlebar(String text) {
        super(text);
        init();
    }

    public Titlebar(String text, Color bgColor) {
        super(text);
        init();
        setBackground(bgColor);
        setForeground(Color.white);
    }

    private void init() {
        setOpaque(true);
        setBorder(new BasicBorders.ButtonBorder(Color.ORANGE, Color.white, Color.black, Color.white));
    }

    protected void paintBorder(Graphics g) {
        int w = getWidth();
        int h = getHeight();

        g.setColor(getBackground().brighter());
        g.drawLine(0, 0, w, 0);
        g.setColor(getBackground().brighter().brighter());
        g.drawLine(0, 0, w+1, 0);

        g.setColor(getBackground().brighter());
        g.drawLine(0, 0, 0, h);

        g.setColor(getBackground().darker());
        g.drawLine(0, h, w, h);
    }

    public void setTitle(String title) {
        if(title==null)
            title = "";
        title = title.trim();
        setText(title);
    }
}
