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
import za.co.cascott.indemnity.GlobalProperties;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class About extends JDialog {

    public About() {
        setTitle("About");
        setBounds(100, 100, 467, 429);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        getContentPane().add(panel_1, BorderLayout.SOUTH);

        JButton btnClose = new JButton("Close");
        btnClose.setIcon(new ImageIcon(About.class.getResource("/assets/icons/cross_bw.png")));
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel_1.add(btnClose);

        ImagePanel panel_2 = new ImagePanel("/assets/cal1.png");
        panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new MigLayout("", "[][]", "[][][][]"));

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(About.class.getResource("/assets/icons/48.png")));
        panel_2.add(label, "cell 0 0");

        JLabel lblNewLabel = new JLabel("<html>\r\n<h3>Indemnify</h3>");
        panel_2.add(lblNewLabel, "cell 1 0");

        JLabel lblNewLabel_1 = new JLabel("<html>\nFidelity Insurance Assessment.</b><br>\r\n&copy; 2012 CA Scott Consulting Actuary &ndash; All rights reserved\r\n</html>");
        panel_2.add(lblNewLabel_1, "cell 1 1");

        JLabel lblSupportSupportcascottcozaPhone = new JLabel(
                "<html>\nSupport: <i>support@cascott.co.za<i><br>\nPhone: <i>+27 (0) 11 787 4955<i><br>\nWeb: <i>http://cascott.co.za/<i><br>" +
                        "<br><br>Version: " + GlobalProperties.getInstance().getVersion() +
                        "<br>Build Date: " + GlobalProperties.getInstance().getBuildtime() +
                        "<br><br>ICEpdf - http://www.icesoft.org/projects/ICEpdf/overview.jsf" +
                        "<br><br>Some icons by Yusuke Kamiyamane. http://p.yusukekamiyamane.com/"
        );
        panel_2.add(lblSupportSupportcascottcozaPhone, "cell 1 2");

        JLabel label_1 = new JLabel("");
        label_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    java.awt.Desktop.getDesktop().browse(new URI("https://twitter.com/#!/CAScott_Actuary"));
                } catch (IOException | URISyntaxException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        label_1.setToolTipText("Twitter");
        label_1.setIcon(new ImageIcon(About.class.getResource("/assets/twitter.png")));
        panel_2.add(label_1, "flowx,cell 1 3");

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setEnabled(false);
        lblNewLabel_2.setToolTipText("Facebook");
        lblNewLabel_2.setIcon(new ImageIcon(About.class.getResource("/assets/fb.png")));
        //panel_2.add(lblNewLabel_2, "cell 1 3");

        JLabel label_2 = new JLabel("");
        label_2.setEnabled(false);
        label_2.setToolTipText("Google+");
        label_2.setIcon(new ImageIcon(About.class.getResource("/assets/g-plus.png")));
        //panel_2.add(label_2, "cell 1 3");
    }

}
