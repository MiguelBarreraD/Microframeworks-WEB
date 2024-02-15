package org.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    HttpServer server;

    @Before
    public void setup() {
        server = HttpServer.getInstance();
    }

    @Test
    public void shouldResponseHtmlFiles() {
        byte[] response = null;
        try {
            URI uri = new URI("/index.html");
            response = server.httpOkResponseBody(uri);
        } catch (IOException | URISyntaxException e ) {
            e.printStackTrace();
        }
        assertNotNull(response);
    }

    @Test
    public void shouldResponseCssFiles() {
        byte[] response = null;
        try {
            URI uri = new URI("/css/styles.css");
            response = server.httpOkResponseBody(uri);
        } catch (IOException | URISyntaxException e ) {
            e.printStackTrace();
        }
        assertNotNull(response);
    }


    @Test
    public void shouldNotResponseHtmlFiles() {
        byte[] response = null;
        try {
            URI uri = new URI("/dontExist.html");
            response = server.httpOkResponseBody(uri);
        } catch (IOException | URISyntaxException e ) {
            e.printStackTrace();
        }
        assertNull(response);
    }

}
