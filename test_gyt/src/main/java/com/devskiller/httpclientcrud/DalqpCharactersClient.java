package com.devskiller.httpclientcrud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import com.devskiller.httpclientcrud.model.Character;
import com.devskiller.httpclientcrud.model.Character.Details;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.io.File;
import java.net.*;
import java.net.http.HttpRequest;
import java.util.*;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class DalqpCharactersClient {

    private final String username;
    private final String password;
    private final HttpClient client;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public DalqpCharactersClient(String username, String password) {
        this.username = username;
        this.password = password;
        client = HttpClient.newHttpClient();
    }

    public HttpResponse<String> getCharactersByRace(String race) {
       
        try{

       


        }catch(Exception ex){
            ex.printStackTrace();
        }    
        return null;
    }

    // this is time consuming operation therefore send the request asynchronously
    public CompletableFuture<HttpResponse<String>> getCharacterDetails(String name) {
        return null;
    }

    public HttpResponse<String> createCharacter(String name, String race) {
        
        try{
                   
        Character car = new Character(name,race);
        var param = name;
        //var param = "car";
        OBJECT_MAPPER.writeValue(new File("D:\\Software_Install\\XAMPP\\htdocs\\prueba\\characters\\"+param+".json"), car);
        
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost/prueba/characters/"+param+".json")).build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
               
        System.out.println(response.body());
        return response;
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public HttpResponse<Void> deleteCharacterByName(String name) {
        return null;
    }
}
