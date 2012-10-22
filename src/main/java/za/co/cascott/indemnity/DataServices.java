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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.UUID;

//Singleton.

public class DataServices {
    //This should be collected from a file on the wbserver.
    private String apiAddress = "http://10.10.0.10:8084/api/indemnify/";

    private static String currentSID;

    private static DataServices instance;

    HttpURLConnection connection = null;

    protected DataServices() {
    }

    private String encode(String toEncode) throws UnsupportedEncodingException {
        return URLEncoder.encode(toEncode, "UTF-8");
    }

    public static DataServices getInstance() {
        if (instance == null)
            instance = new DataServices();
        return instance;
    }

    public static String get_sid() {
        if (currentSID == null)
            return UUID.randomUUID().toString();
        else
            return currentSID;
    }

    public boolean hasSid() {
        if (currentSID != null)
            return false;
        else
            return true;
    }

    public String requestFromUrl(String req) {
        return null;
    }


    public void feedBack(String fullname, String email, String message) {

    }

    public void firstRegister() {

    }

    public String updateChecker() {
        return null;
    }

    /*
      * Example:
      * 	send("http://example.com/test/", [
      * 		["param1","value1"],["param2","value2"]
      * 	])
      */
    private String send(final String apiurl, final String urlParameters) {

        URL url;
        try {
            url = new URL(apiAddress + "?" + urlParameters);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //connection.setDoInput(true);
            //  connection.setDoOutput(true);
            //Send request
            //DataOutputStream wr = new DataOutputStream (
            //            connection.getOutputStream ());

            //wr.writeBytes (urlParameters);
            //wr.flush ();
            //wr.close ();
//		      //Get Response	
//		      InputStream is = connection.getInputStream();
//		      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//		      String line;
//		      StringBuffer response = new StringBuffer(); 
//		      while((line = rd.readLine()) != null) {
//		        response.append(line);
//		        response.append('\r');
//		      }
//		      rd.close();
            //return response.toString();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return "";
    }

    /*
      * Send Some information back from the WelcomeDialog to us so we can save it.
      */
    public void firstTimeRun(String fname, String lname, String email, Boolean newsletter, Boolean updateNotify) {
        final String apicall = "welcome";

        String urlparams = "";
        try {
            urlparams =
                    "sid=" + encode("123-" + get_sid()) +
                            "$fname=" + encode(fname) +
                            "&lname=" + encode(lname) +
                            "&email=" + encode(email) +
                            "&nl=" + encode(newsletter.toString()) +
                            "&un=" + encode(updateNotify.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("The Call:" + apiAddress + apicall + "?" + urlparams);
        System.out.println("The Return:" + send(apiAddress + apicall, urlparams));
        GlobalProperties.getInstance().getSettings().setProperty("firstrun_sent", "false");
    }

}
