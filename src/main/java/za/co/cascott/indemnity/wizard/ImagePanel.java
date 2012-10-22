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

public class ImagePanel extends JPanel {

    private Image bgimage;
    int tx = 0;
    int ty = 0;

    public ImagePanel(String url) {
        if (url == null)
            return;
        try {
            this.bgimage = new ImageIcon(ImagePanel.class.getResource(url)).getImage();
        } catch (NullPointerException e) {
        }

        repaint();
    }

    public void paintComponent(Graphics g) {
        if (bgimage != null) {
            g.drawImage(bgimage, tx, ty, null);
        }
    }

    public void move(int x, int y) {
        tx = x;
        ty = y;
        repaint();
    }

}
