package com.conradcrates.pulselivetechnicalchallenge.backend;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Conrad on 02/10/2017.
 */

public class RestClient {

    private static final String TAG = RestClient.class.getSimpleName();

    public String getData(String urlPath){
        String result = null;
        try{
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            InputStream is = new BufferedInputStream(conn.getInputStream());
            result = convertStreamToString(is);
        } catch (IOException e){
            Log.e(TAG, e.getMessage());
        }
        return result;
    }

    private String convertStreamToString(InputStream is){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String s;
        try{
            while ((s = reader.readLine()) != null){
                sb.append(s).append("\n");
            }
        } catch (IOException e){
            Log.e(TAG, e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e){
                Log.e(TAG, e.getMessage());
            }
        }
        return sb.toString();
    }
}