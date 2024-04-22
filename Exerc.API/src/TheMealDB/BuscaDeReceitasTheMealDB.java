package TheMealDB;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscaDeReceitasTheMealDB {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome da receita: ");
        var nomeReceita = URLEncoder.encode(sc.nextLine(), "UTF-8");


        String URL = "https://www.themealdb.com/api/json/v1/1/search.php?s="+nomeReceita + "&limit=1";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        String json = response.body();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();

        ListaReceitasAPI receitas = gson.fromJson(json, ListaReceitasAPI.class);
        ReceitaAPI primeirareceita= receitas.getMeals().get(0);
        Receita receita = new Receita(primeirareceita);
        System.out.println(receita);

        sc.close();
    }
}