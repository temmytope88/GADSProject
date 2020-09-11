package com.temmy.gadsleadersboard;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class Dataquery extends AsyncTask<URL, Void, String> {
     ProgressBar ProgressBar;
     TextView text;

    public Dataquery(android.widget.ProgressBar progressBar, TextView text) {
        ProgressBar = progressBar;
        this.text = text;
    }
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

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ProgressBar.setVisibility(View.INVISIBLE);
        if(result == null){
            text.setVisibility(View.VISIBLE);
        }
        else {
            text.setVisibility(View.INVISIBLE);
           }
        }

}

