/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.indemnity.input.html;

import com.floreysoft.jmte.Engine;
import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;
import za.co.cascott.indemnity.DataCollection;

import java.io.*;
import java.util.Map;
import java.util.Random;

/*
 * Takes input processes it and makes a temp copy so that the PDF can created from the new file.
 * Do NOT use this class. Use za.co.cascott.template.* Classes instead.
 * 
 * NOTE: JMTE Template Engine wont be used anymore. 
 * 
 * TODO: Remove for Version 2.0
 */
@Deprecated
public class TemplateEngine {
    private Map<String, Object> model;
    private Engine engine;
    private String lastGenFileString = "";

    public TemplateEngine(DataCollection c) {
        this.model = c.getModel();
        engine = new Engine();
        engine.setExprStartToken("$(");
        engine.setExprEndToken(")");
    }

    public String getLastGenFileString() {
        return lastGenFileString;
    }

    public void createPDF(File f, String output) throws IOException, DocumentException {
        String outputFile = output;
        String tempname = getTempDirectory() + getTempFileName() + ".pdf";
        OutputStream os = new FileOutputStream(tempname);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(f);
        renderer.layout();
        renderer.createPDF(os);

        //WaterMarker wm = new WaterMarker(tempname, outputFile);
        //wm.addWaterMark("", createPlainCopy(this.getClass().getResourceAsStream("/assets/sample_grey_400x300.png")));
        //wm.addWaterMark("", "");
        //wm.closeAll();
    }

    /*
      * Returns a copy of a file inside a jar.
      */
    public File processFile(String internal) {
        InputStream asset = this.getClass().getResourceAsStream(internal);
        return createCopy(asset);
    }

    public String createPlainCopy(InputStream i) {
        String tempname = getTempDirectory() + getTempFileName();
        File tempfile = new File(tempname);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(tempfile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            int read = 0;
            while ((read = i.read()) != -1) {
                out.write((char) read);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempname;
    }

    public File createCopy(InputStream i) {
        String tempname = getTempDirectory() + getTempFileName();
        lastGenFileString = tempname;
        File tempfile = new File(tempname);
        FileWriter out = null;
        StringBuffer buffer = new StringBuffer();
        try {
            out = new FileWriter(tempfile);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            int read = i.read();
            while (read != -1) {
                buffer.append((char) read);
                read = i.read();
            }
            out.write(engine.transform(buffer.toString(), this.model));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File name: " + tempname);

        System.out.println("The buffer capacity: " + buffer.capacity());
        return tempfile;
    }

    private void deleteFile(File f) {
        f.delete();
    }

    public String getTempDirectory() {
        return System.getProperty("java.io.tmpdir") + "/";
    }

    public String getTempFileName() {
        Random a = new Random();

        String[] bt = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "_", "-"};

        int c = 0;
        while (c < 5) {
            c = a.nextInt(8);
        }

        String out = "";
        for (int i = 0; i < c; i++) {
            out += a.nextInt(9) + bt[a.nextInt(bt.length)];
        }
        //out += ext[a.nextInt(2)];
        return out;
    }
}
