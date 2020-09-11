package com.temmy.gadsleadersboard;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class Dataquery extends AsyncTask<URL, Void, String> {


    String result = null;

    @Override
    protected String doInBackground(URL... urls) {
         URL searchURL = urls[0];

         try{
             result = ApiConnect.getJson(searchURL);
         }
         catch (IOException e) {
             e.printStackTrace();
         }
         return result;
    }

}

