package za.co.cascott.splashscreen;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImagePanel extends JPanel {

    private static Logger logger = Logger.getLogger(ImagePanel.class.getName());
    private Image bgimage;

    public ImagePanel(String url) {
        if (url == null) {
            logger.log(Level.SEVERE, "No Image Provided.");
            return;
        } else {
            try {
                this.bgimage = new ImageIcon(ImagePanel.class.getResource(url)).getImage();
            } catch (NullPointerException e) {
                logger.log(Level.SEVERE, "Image could not be set.");
            }
        }
    }

    public void paintComponent(Graphics g) {
        if (bgimage != null)
            g.drawImage(bgimage, 0, 0, null);
    }

}
