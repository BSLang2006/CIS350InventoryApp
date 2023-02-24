import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpRequests {

    //install Json-server with the command "npm install -g json-server"
    //Navigate to the project containing db.json and type "json-server --watch db.json"
    //By default it will serve the DB at http://localhost:3000
    //To view the liquors database navigate to http://localhost:3000/liquors

    private static final String POSTS_API_URL = "http://localhost:3000/liquors";

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