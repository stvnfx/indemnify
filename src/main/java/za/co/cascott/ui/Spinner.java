/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.pushingpixels.trident.Timeline;
import org.pushingpixels.trident.interpolator.KeyTimes;
import org.pushingpixels.trident.interpolator.KeyValues;

/**
 * Simple little spinner, activity indicator.
 */
public class Spinner extends JComponent {

    private Timeline drawTimeline = null;
    private Timeline colorTimeline = null;
    private int angle = 0;
    private Color currentColor = null;

    public Spinner() {
        this.setSize(16, 16);

        colorTimeline = new Timeline(this);
        currentColor = new Color(160, 82, 80);
        colorTimeline.addPropertyToInterpolate("Color", new Color(160, 82, 80), new Color(77, 107, 118));
        colorTimeline.setDuration(500);
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                colorTimeline.play();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                colorTimeline.playReverse();
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_SPEED);

        g2.setColor(currentColor.darker());
        g2.drawOval(0, 0, 16, 16);
        //Fill the Oval
        g2.setColor(currentColor);
        g2.fillArc(0, 0, 16, 16, angle-50, angle);


        g2.dispose();
    }

    public void setColor(Color newColor) {
        currentColor = newColor;
    }

    /**
     * Pauses the animation.
     */
    public void pause() {
        drawTimeline.suspend();
        drawTimeline.cancel();
    }

    public void start() {
        drawTimeline = new Timeline(this);

        drawTimeline.addPropertyToInterpolate("Angle", 0, 360);
        drawTimeline.setDuration(2500);
        drawTimeline.playLoop(Timeline.RepeatBehavior.LOOP);
    }

    public void setAngle(int newAngle) {
        this.angle = newAngle;
        repaint();
    }


}
