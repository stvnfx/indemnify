/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.indemnity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;

/*
 * Please use utils instead.
 * Loads and saves file and keeps track of saved files to be deleted.
 * TODO: Remove from project, use Utils instead.
 */
public class TempSystem {
    private static TempSystem instance = null;
    private HashMap<String, String> filelist;
    private int bytesRead = 0;

    public int getBytesRead() {
        return bytesRead;
    }

    public int getNumberOfFilesInTemp() {
        return filelist.size();
    }

    protected TempSystem() {
        filelist = new HashMap<String, String>();
    }

    public static TempSystem getInstance() {
        if (instance == null) {
            instance = new TempSystem();
        }
        return instance;
    }

    public String getInternalFile(String internalname, String ext) {
        if (filelist.get(internalname) != null) {
            return getLocation() + filelist.get(internalname);
        }
        String filename = getTempFileString(ext);
        filelist.put(internalname, filename);
        createPlainCopy(this.getClass().getResourceAsStream(internalname), getLocation() + filename);
        return getLocation() + filename;
    }

    private void createPlainCopy(InputStream i, String filename) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filename);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            int read = 0;
            while ((read = i.read()) != -1) {
                bytesRead++;
                out.write((char) read);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File tempfile = new File(filename);
        tempfile.deleteOnExit();
    }

    public void removeAll() {
        if (filelist.isEmpty())
            return;
        Object[] arr = filelist.keySet().toArray();
        int size = filelist.entrySet().toArray().length;
        for (int i = 0; i < size; i++) {
            String filename = (String) arr[i];
            File f = new File(getLocation() + filelist.get(filename));
            f.delete();
        }
    }

    public Object getFileList() {
        return filelist.clone();
    }

    public String getTempFileString(String ext) {
        Random a = new Random();

        String[] bt = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "_", "-"};

        int c = 0;
        while (c < 8) {
            c = a.nextInt(15);
        }

        String out = "";
        for (int i = 0; i < c; i++) {
            out += a.nextInt(9) + bt[a.nextInt(bt.length)];
        }

        return out + "." + ext;
    }

    public String getLocation() {
        return System.getProperty("java.io.tmpdir") + "//";
    }
}
