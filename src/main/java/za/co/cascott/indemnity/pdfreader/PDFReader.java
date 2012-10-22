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

import za.co.cascott.indemnity.TempSystem;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFReader {
    private static Logger logger = Logger.getLogger(PDFReader.class.getName());

    private PDFReaderDialog dialog;
    private static PDFReader instance = null;

    private PDFReader() {
        dialog = new PDFReaderDialog();
    }

    public static PDFReader getInstance() {
        if (instance == null) {
            instance = new PDFReader();
        }
        return instance;
    }

    public void showViewer() {
        logger.log(Level.FINEST, "Showing PDF Viewer");
        if (dialog.isVisible()) {
            logger.log(Level.FINEST, "Already open, Bringing to front.");
            dialog.toFront();
        }
        dialog.setVisible(true);
    }

    public void hideViewer() {
        logger.log(Level.FINEST, "Hiding PDF Viewer");
        dialog.setVisible(false);
    }

    public void openDocument(String filename) {
        dialog.openDocument(filename);
    }

    public void openInternalDefaultDocument() {
        logger.log(Level.FINEST, "Opening Default PDF Document");
        PDFReader pdfr = PDFReader.getInstance();
        @SuppressWarnings("deprecation")
        URL ref = null;
        try {
            ref = new File(TempSystem.getInstance().getInternalFile("assets/docs/pf130/PF130.pdf", "pdf")).toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        pdfr.openDocument(ref.getFile());
    }

    public void openInternalDocument(String filename) {
        logger.log(Level.FINEST, "Opening PDF Document " + filename);
        PDFReader pdfr = PDFReader.getInstance();
        @SuppressWarnings("deprecation")
        URL ref = null;
        try {
            ref = new File(TempSystem.getInstance().getInternalFile(filename, "pdf")).toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        pdfr.openDocument(ref.getFile());
        pdfr.showViewer();
    }
}