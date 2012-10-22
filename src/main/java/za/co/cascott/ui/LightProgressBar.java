package za.co.cascott.ui;

import javax.swing.*;
import java.awt.*;

public class LightProgressBar extends JPanel {

    Color currentColor = new Color(160, 82, 80);
    boolean hasText = false;
    String text;
    int value = 0;

    public LightProgressBar() {}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(currentColor);
        g2.drawRect(0, 0, getWidth() - 2, getHeight() - 1);

        g2.setColor(currentColor.brighter());
        g2.fillRect(1, 1, (((getWidth() * value) / 100) - 3), getHeight() - 2);

        if (hasText) {
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            g2.setColor(currentColor.darker());
            g2.drawString(text, 1, 9);
        }
        g2.dispose();
    }

    public void setText(String t) {
        hasText = true;
        text = t;
    }

    public void setColor(Color c) {
        currentColor = c;
    }

    public void setValue(int v) {
        value = v;
        repaint();
    }

}
