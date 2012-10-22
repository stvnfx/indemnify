/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.indemnity.pdfreader;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.PropertiesManager;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;
import java.util.ResourceBundle;

public class PDFReaderDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private SwingController controller;

    public PDFReaderDialog() {
        contentPane = new JPanel();
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));
        setContentPane(contentPane);
        setModal(false);
        setTitle("Reader");
        getRootPane().setDefaultButton(buttonOK);

        controller = new SwingController();
        Properties props = new Properties();
        props.setProperty(PropertiesManager.PROPERTY_SHOW_UTILITY_SAVE, "false");
        props.setProperty(PropertiesManager.PROPERTY_SHOW_TOOLBAR_ANNOTATION, "false");
        props.setProperty("application.showLocalStorageDialogs", "false");
        props.setProperty("application.toolbar.show.utility.print", "false");
        props.setProperty("application.utilitypane.show.annotation", "false");

        PropertiesManager properties =
                new PropertiesManager(System.getProperties(), props,
                        ResourceBundle.getBundle(PropertiesManager.DEFAULT_MESSAGE_BUNDLE));

        controller.updateDocumentView();
        SwingViewBuilder factory = new SwingViewBuilder(controller, properties);

        contentPane.setLayout(new BorderLayout());

        contentPane.add(factory.buildViewerPanel(), BorderLayout.CENTER);
    }

    public void openDocument(String filename) {
        controller.openDocument(filename);
    }
}
