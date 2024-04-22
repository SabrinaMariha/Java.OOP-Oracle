package ViaCEP;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaPorCEPAPIViaCEP {
    public void BuscarPorCep() throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();
        Scanner sc = new Scanner(System.in);
        List<CEP> listaCeps = new ArrayList<>();
        var busca="";


        while(!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite o CEP ou Sair para encerrar: ");
            busca = URLEncoder.encode(sc.nextLine(), "UTF-8");
            if(busca.equalsIgnoreCase("sair"))  break;
            String URL = "https://viacep.com.br/ws/" + busca + "/json/";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(URL))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                cepAPI cepapi = gson.fromJson(json, cepAPI.class);
                CEP cep = new CEP(cepapi);
                System.out.println(cep);
                listaCeps.add(cep);

            } catch (IllegalArgumentException e) {
                System.out.println("Argumento inválido. Por favor verifique o CEP.");
                System.out.println(e.getMessage());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                System.out.println("Erro ao buscar o CEP.");
                System.out.println(e.getMessage());
            }
        }
            FileWriter writer = new FileWriter("CEPS.json");
            writer.write(gson.toJson(listaCeps));
            writer.close();
            sc.close();
    }

}
