package com.temmy.gadsleadersboard;

import java.net.MalformedURLException;
import java.net.URL;


public class ApiBuilder {

    public static final String Base_API_URL = "https://gadsapi.herokuapp.com";

    public static  URL ApiBuilder (String extension){
            String fullURL = Base_API_URL + extension;
            URL url = null;
            try {
                url = new URL(fullURL);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
            return url;
    }
}
