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
import javax.swing.border.EtchedBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;

/**
 * User: steven
 * Date: 8/8/12
 * Time: 9:44 AM
 */
public class Logger extends JDialog {

    private static Logger instance;
    private JTextPane textPane = null;

    private StyledDocument doc;
    private SimpleAttributeSet error;
    private SimpleAttributeSet warning;
    private SimpleAttributeSet info;

    private SimpleAttributeSet errorI;
    private SimpleAttributeSet warningI;
    private SimpleAttributeSet infoI;

    private boolean isPaused = false;


    protected Logger() {
        //setLayout(new BorderLayout());
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBorder(new EtchedBorder());

        textPane =  new JTextPane();
        textPanel.add(textPane, BorderLayout.CENTER);
        doc = textPane.getStyledDocument();

        error = new SimpleAttributeSet();
        StyleConstants.setForeground(error, Color.RED);
        StyleConstants.setBold(error, true);

        errorI = new SimpleAttributeSet();
//        Icon errorIcon = new ImageIcon(Logger.class.getResource("/assets/icons/exclamation-red.png"));
//        StyleConstants.setIcon(errorI, errorIcon);

        warning = new SimpleAttributeSet();
        StyleConstants.setForeground(warning, Color.ORANGE);

        warningI = new SimpleAttributeSet();
//        Icon exclamationIcon = new ImageIcon(Logger.class.getResource("/assets/icons/exclamation.png"));
//        StyleConstants.setIcon(warningI, exclamationIcon);

        info = new SimpleAttributeSet();
        StyleConstants.setForeground(info, Color.DARK_GRAY);
        //StyleConstants.setItalic(info, true);

        infoI = new SimpleAttributeSet();
//        Icon infoIcon = new ImageIcon(Logger.class.getResource("/assets/icons/information.png"));
//        StyleConstants.setIcon(infoI, infoIcon);

        add(textPanel, BorderLayout.CENTER);
        add(sideButtons(), BorderLayout.WEST);

        setDefaultCloseOperation(1);
        setSize(300, 400);
    }

    public static Logger getInstance() {
        if (instance != null)
            return instance;
        instance = new Logger();
        return instance;
    }

    private JPanel sideButtons() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));

        //TODO: These need to be icons.
        LoggerButton clearButton = new LoggerButton();
//        clearButton.setIcon(new ImageIcon(Logger.class.getResource("/assets/icons/terminal--minus.png")));
        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textPane.setText("");
            }

        });

        LoggerButton scrollToBottomButton = new LoggerButton();
//        scrollToBottomButton.setIcon(new ImageIcon(Logger.class.getResource("/assets/icons/control-double-270.png")));

        LoggerButton stopLoggingButton = new LoggerButton();
//        stopLoggingButton.setIcon(new ImageIcon(Logger.class.getResource("/assets/icons/control-stop-square.png")));
        stopLoggingButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPaused == true) {
                    add(Level.WARNING, "Logging already stopped.");
                    return;
                }
                add(Level.INFO, "Logging Stopped.");
                isPaused = true;
            }

        });

        LoggerButton startLoggingButton = new LoggerButton();
//        startLoggingButton.setIcon(new ImageIcon(Logger.class.getResource("/assets/icons/control.png")));
        startLoggingButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isPaused == false) {
                    add(Level.WARNING, "Logging already running.");
                    return;
                }
                add(Level.INFO, "Logging Started.");
                isPaused = false;
            }

        });

        buttonsPanel.add(startLoggingButton);
        buttonsPanel.add(stopLoggingButton);
        buttonsPanel.add(scrollToBottomButton);
        buttonsPanel.add(clearButton);

        return buttonsPanel;
    }

    public synchronized void add(Level level, String message) {
        if (isPaused)
            return;
        try {
            if (level == Level.WARNING) {
                doc.insertString(doc.getLength(), " ", warningI);
                doc.insertString(doc.getLength(), " " + message + "\n", warning);
            } else if (level == Level.INFO) {
                doc.insertString(doc.getLength(), " ", infoI);
                doc.insertString(doc.getLength(), " " + message + "\n", info);
            } else if (level == Level.SEVERE) {
                doc.insertString(doc.getLength(), " ", errorI);
                doc.insertString(doc.getLength(), " " + message + "\n", error);
            } else {
                doc.insertString(doc.getLength(), " " + message + "\n", info);
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

}
