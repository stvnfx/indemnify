package za.co.cascott.splashscreen;

import org.pushingpixels.trident.Timeline;
import za.co.cascott.indemnity.Main;
import za.co.cascott.ui.LightProgressBar;
import za.co.cascott.ui.Spinner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public final class SplashScreen extends JFrame implements ISplashScreen {

    private ImagePanel contentPane;
    LightProgressBar tpr;
    JLabel lblVersionHeader;
    final Timeline slowProgress;
    private int lastValue = 0;

    public SplashScreen() {
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setPreferredSize(new Dimension(474, 301));
        setTitle("Test");
        contentPane = new ImagePanel("/assets/splash.png");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        tpr = new LightProgressBar();
        contentPane.add(tpr, BorderLayout.SOUTH);

        lblVersionHeader = new JLabel("Version:");
        lblVersionHeader.setForeground(new Color(64, 64, 64));
        lblVersionHeader.setFont(new Font("Dialog", Font.PLAIN, 12));
        contentPane.add(lblVersionHeader, BorderLayout.NORTH);
        slowProgress = new Timeline(tpr);
    }

    @Override
    public void showSplashScreen() {
        setVisible(true);
    }

    @Override
    public void hideSplashScreen() {
        setVisible(false);
    }

    @Override
    public void setVersion(String version) {
        lblVersionHeader.setText("Version: " + version);
    }


    public void setIndeterminate(boolean in) {
        //progressBar.setIndeterminate(in);
    }

    @Override
    public void setProgressBarText(String text) {
        tpr.setText(text);
    }

    @Override
    public void setCenter(Boolean center) {
        if (center)
            setLocationRelativeTo(null);
    }

    @Override
    public void setProgressBarValue(int value) {
        if (!slowProgress.isDone()) {
            slowProgress.suspend();
            slowProgress.cancel();
        }
        slowProgress.addPropertyToInterpolate("Color", new Color(160, 82, 80), new Color(77, 107, 118));
        slowProgress.addPropertyToInterpolate("Value", lastValue, value);
        slowProgress.setDuration(200);
        slowProgress.play();
        lastValue = value;
    }
}
