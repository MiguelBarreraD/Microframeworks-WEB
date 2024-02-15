package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

import org.example.API.MovieAPI;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static org.example.HttpServer.get;
import static org.example.HttpServer.post;

public class MisServicios {
    public static void main(String[] args) throws IOException, URISyntaxException {
        get("/movie", (req) -> {
            JsonObject response = null;
            MovieAPI movieAPI = new MovieAPI();
            try {
                response = movieAPI.getMovie(req);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response.toString().getBytes();
        });

        post("/name", (req) -> {
            return "{\"mensaje\": \"Se añadió el nombre\"}".getBytes();
        });

        HttpServer.getInstance().main(args);
    }
}
