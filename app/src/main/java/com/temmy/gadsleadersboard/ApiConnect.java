package com.temmy.gadsleadersboard;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ApiConnect {

    public static String getJson(URL url) throws IOException{
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
                InputStream stream = connection.getInputStream();
                Scanner scanner = new Scanner(stream);
                scanner.useDelimiter("\\A");
                boolean hasData = scanner.hasNext();
                if (hasData){
                    return scanner.next();
                }
                else {
                    return null;
                }
        }

        catch (Exception e){
            Log.d("error", e.getMessage());
            return null;
        }

        finally {
            connection.disconnect();
        }
    }
}
