package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MovieAPI {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String URL = "http://www.omdbapi.com/?apikey=2c3152c3&t=";

    public JsonObject getMovie(String nameMovie) throws IOException {
        System.out.println(nameMovie);
        String movie = nameMovie.split("=")[1];
        System.out.println("==============" + movie + "==============");
        URL obj = new URL(URL + movie);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code: " + responseCode);
        StringBuffer response = new StringBuffer();

        if (responseCode == HttpURLConnection.HTTP_OK) { 
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } else {
            System.out.println("GET request not worked");
        }
        return JsonParser.parseString(response.toString()).getAsJsonObject();
    }
}
