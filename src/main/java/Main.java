import org.json.JSONObject;

import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpResponse<String> response = null;
        try {
            String endPoint = "https://gorest.co.in/public/v2/users";
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert response != null;
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Body: " + response.body());

        System.out.println("---------------------------TROVA UTENTE PRECISO---------------------------------");
        try {
            String endPoint = "https://gorest.co.in/public/v2/users/816774";
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Body: " + response.body());



        System.out.println("---------------------------CREA UTENTE--------------------------");

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "Gianna");
        jsonObj.put("gender", "female");
        jsonObj.put("email", "devv_shar@prstill.org");
        jsonObj.put("status", "active");
        String jsonStr = jsonObj.toString();


        try {
            String endPoint = "https://gorest.co.in/public/v2/users";
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().uri(uri)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer token")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonStr))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Body: " + response.body());

        System.out.println("---------------------------CREA POST UTENTE--------------------------");

        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("title", "Titolobello");
        jsonObj2.put("body", "Ciao al mondo");

        String jsonStr2 = jsonObj2.toString();


        try {
            String endPoint = "https://gorest.co.in/public/v2/users/798936/posts";
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().uri(uri)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer token")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonStr2))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Status Code: "+ response.statusCode());
        System.out.println("Body: "+ response.body());


        System.out.println("---------------------------CREA TODO UTENTE--------------------------");

        JSONObject jsonObj3 = new JSONObject();
        jsonObj3.put("status", "pending");
        jsonObj3.put("title", "TitoloBello");

        String jsonStr3 = jsonObj3.toString();


        try {
            String endPoint = "https://gorest.co.in/public/v2/users/798936/todos";
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().uri(uri)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer token")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonStr3))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Status Code: "+ response.statusCode());
        System.out.println("Body: "+ response.body());

        System.out.println("---------------------------MODIFICA EMAIL UTENTE ESISTENTE--------------------------");

        JSONObject jsonObj4 = new JSONObject();
        jsonObj4.put("email", "giulia88@mail.com");
        String jsonStr4 = jsonObj4.toString();


        try {
            String endPoint = "https://gorest.co.in/public/v2/users/798936";
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().uri(uri)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer token")
                    .PUT(HttpRequest.BodyPublishers.ofString(jsonStr4))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Status Code: "+ response.statusCode());
        System.out.println("Body: "+ response.body());


        System.out.println("---------------------------RECUPERA POST UTENTE--------------------------");
        try {
            String endPoint = "https://gorest.co.in/public/v2/users/798936/posts";
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().uri(uri)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer token")
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Status Code: "+ response.statusCode());
        System.out.println("Body: "+ response.body());


        System.out.println("---------------------------RECUPERA TODO UTENTE--------------------------");
        try {
            String endPoint = "https://gorest.co.in/public/v2/users/798936/todos";
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().uri(uri)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer token")
                    .GET()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Status Code: "+ response.statusCode());
        System.out.println("Body: "+ response.body());

        System.out.println("---------------------------ELIMINA UTENTE--------------------------");
        try {
            String endPoint = "https://gorest.co.in/public/v2/users/798936";
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().uri(uri)
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer token")
                    .DELETE()
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Status Code: "+ response.statusCode());
        System.out.println("Body: "+ response.body());
    }
}

