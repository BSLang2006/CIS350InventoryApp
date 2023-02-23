import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.*;
import java.util.*;

public class HttpRequests {

    private static final String POSTS_API_URL = "http://localhost:3000/categories";

    String url ="Http://localhost:4200";
    public static void main(String[] args) throws IOException, InterruptedException 
    {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request  = HttpRequest.newBuilder()
            .GET()
            .header("accept", "application/json")
            .uri(URI.create(POSTS_API_URL))
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println(response.body());
}
}