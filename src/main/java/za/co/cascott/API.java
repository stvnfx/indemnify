/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;
import za.co.cascott.indemnity.GlobalProperties;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: steven
 * Date: 8/8/12
 * Time: 3:09 PM
 */
public class API {

    public final static int REGISTER = 0;
    public final static int LOGGING = 1;
    public final static int STARTUP = 2;
    public final static int FEEDBACK = 3;
    public final static int BUG = 4;
    public final static int UPDATE = 5;
    public final static int MESSAGE = 6;

    //TODO: Change this to a working url.
    private static String url = "127.0.0.1:8084";
    private static String application = "indemnify";

    private static Logger logger = Logger.getLogger("API");

    public API() {
    }

    //You Get JSON Back.
    public static String doRequest(int type) {
        URIBuilder builder = new URIBuilder();
        DefaultHttpClient httpclient =  new DefaultHttpClient();
        HttpGet httpget = null;
        System.out.println("Starting Request");

        switch (type) {

//            case API.BUG:
//                builder.setScheme("http").setHost(url).setPath("/" + application + "/bugreport")
//                        .setParameter("specialid", Utils.Database.getMap("database").get("SpecialID"))
//                        .setParameter("ver", GlobalProperties.getInstance().getVersion())
//                        .setParameter("dt", new Date().toString());
//                break;
//
//            case API.FEEDBACK:
//                builder.setScheme("http").setHost(url).setPath("/" + application + "/feedback")
//                        .setParameter("q", "iidemo");
//                break;
//
//            case API.LOGGING:
//                builder.setScheme("http").setHost(url).setPath("/" + application + "/logging")
//                        .setParameter("q", "iidemo");
//                break;
//
//            case API.MESSAGE:
//                builder.setScheme("http").setHost(url).setPath("/" + application + "/message")
//                        .setParameter("q", "iidemo");
//                break;

            case API.REGISTER:
                builder.setScheme("http").setHost(url).setPath("/" + application + "/register")
                        .setParameter("specialid", Utils.Database.getMap("database").get("SpecialID"))
                        .setParameter("ver", GlobalProperties.getInstance().getVersion())
                        .setParameter("dt", new Date().toString());
                break;

            case API.STARTUP:
                builder.setScheme("http").setHost(url).setPath("/" + application + "/startup")
                        .setParameter("specialid", Utils.Database.getMap("database").get("SpecialID"))
                        .setParameter("sessionid", GlobalProperties.getSessionID())
                        .setParameter("ver", GlobalProperties.getInstance().getVersion())
                        .setParameter("dt", new Date().toString());
                break;

//            case API.UPDATE:
//                builder.setScheme("http").setHost(url).setPath("/" + application + "/update")
//                        .setParameter("q", "iidemo");
//                break;

        }

        HttpResponse response1 = null;

        try {
            URI uri = builder.build();
            httpget = new HttpGet(uri);
            response1 = httpclient.execute(httpget);
            System.out.println(httpget.getURI());
        } catch (URISyntaxException e) {
        } catch (ClientProtocolException e) {
        } catch (HttpHostConnectException e) {
            logger.log(Level.WARNING, "Host Down or no internet?. Unable to connect.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Connection Issues. Cannot Connect?");
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            httpget.releaseConnection();
        }

        //return response1.getStatusLine().toString();
		return null;
    }

}
