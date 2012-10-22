package za.co.cascott;

import org.apache.jdbm.DB;
import org.apache.jdbm.DBMaker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    public static class Database {
        private static Logger logger = Logger.getLogger(Database.class.getName());

        private static HashMap<String, DB> databases = new HashMap<>();

        private static DB getDatabase(String dbname) {
            logger.log(Level.FINEST, "Getting Named Database " + dbname);
            DB database = databases.get(dbname);
            if (database == null) {
                File nd = new File(System.getProperty("user.home") + "/.indemnify");
                nd.mkdir();
                database = DBMaker.openFile(System.getProperty("user.home") + "/.indemnify/" + dbname).make();
                databases.put(dbname, database);
            }
            return database;
        }

        public static SortedMap<String, String> getMap(String dbname) {
            DB database = getDatabase(dbname);
            SortedMap<String, String> map;
            try {
                map = database.createTreeMap("data");
            } catch (IllegalArgumentException e) {
                map = database.getTreeMap("data");
            }
            return map;
        }

        public static void save(String dbname) {
            logger.log(Level.FINEST, "Saving " + dbname);
            DB database = databases.get(dbname);
            if (database != null) {
                database.commit();
            }
        }

        public static void defragAll() {
            logger.log(Level.FINEST, "Starting Defrag.");
            Iterator it = databases.values().iterator();
            if (it.hasNext()) {
                DB db = (DB) it.next();
                db.defrag(true);
            }
            logger.log(Level.FINEST, "Defrag Completed.");
        }


        public static void close(String dbname) {
            logger.log(Level.FINEST, dbname + " Database Closing");
            DB database = databases.get(dbname);
            if (database == null) {
                logger.log(Level.FINEST, dbname + " does not exist anyway. Removing from list.");
                databases.remove(dbname);
            } else {
                logger.log(Level.FINEST, "Defrag " + dbname);
                database.defrag(false); //Quick defrag
                logger.log(Level.FINEST, "Close " + dbname);
                database.close();
            }
        }

    }

    public static class TempFiles {
        private static Logger logger = Logger.getLogger(TempFiles.class.getName());

        private static TempFiles instance = null;
        private transient HashMap<String, String> filelist;
        private int bytesRead = 0;

        public int getBytesRead() {
            return bytesRead;
        }

        public int getNumberOfFilesInTemp() {
            return filelist.size();
        }

        protected TempFiles() {
            filelist = new HashMap<String, String>();
        }

        public static TempFiles getInstance() {
            if (instance == null) {
                instance = new TempFiles();
            }
            return instance;
        }

        public String getInternalFile(final String internalname) {
            if (filelist.get(internalname) != null) {
                return getLocation() + filelist.get(internalname);
            }
            final String filename = Utils.getRandomString(15);
            filelist.put(internalname, filename);
            createPlainCopy(this.getClass().getResourceAsStream(internalname), getLocation() + filename);
            return getLocation() + filename;
        }

        private void createPlainCopy(final InputStream i, final String filename) {
            logger.log(Level.FINEST, "Creating Plain Copy");
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(filename);
            } catch (IOException e1) {
            }
            try {
                int read = 0;
                while ((read = i.read()) != -1) {
                    bytesRead++;
                    out.write((char) read);
                }
                out.close();
            } catch (IOException e) {
                logger.log(Level.SEVERE, "IO Error: " + e.getMessage());
                e.printStackTrace();
            }
            File tempfile = new File(filename);
            tempfile.deleteOnExit();
            logger.log(Level.FINEST, "File set for delete Afterwards");
        }

        public void removeAll() {
            logger.log(Level.FINEST, "Remove All Files");
            if (filelist.isEmpty()) {
                logger.log(Level.FINEST, "File List is empty");
                return;
            }
            Object[] arr = filelist.keySet().toArray();
            int size = filelist.entrySet().toArray().length;
            for (int i = 0; i < size; i++) {
                String filename = (String) arr[i];
                logger.log(Level.FINEST, "Deleting " + filename);
                File f = new File(getLocation() + filelist.get(filename));
                f.delete();
            }
        }

        public Object getFileList() {
            return filelist.clone();
        }


        public String getLocation() {
            logger.log(Level.FINEST, "Temp Dir: " + System.getProperty("java.io.tmpdir") + "//");
            return System.getProperty("java.io.tmpdir") + "//";
        }
    }

    /**
     * Return random String
     */
    public static String getRandomString(final int length) {
        Random random = new Random();

        String[] allowedChars = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "_", "-"};

        StringBuffer outBuffer = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int counter = 0;
            while (counter == 0) {
                counter = random.nextInt(3);
                if (counter == 1) {
                    outBuffer.append(random.nextInt(9));
                } else if (counter == 2) {
                    outBuffer.append(allowedChars[random.nextInt(allowedChars.length)]);
                }
            }
        }
        return outBuffer.toString();
    }

}
