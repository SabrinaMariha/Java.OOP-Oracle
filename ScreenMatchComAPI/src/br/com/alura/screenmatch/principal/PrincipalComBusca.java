package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmbd;
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

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        var busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//trata detalhes de diferença
                //de letras maiusculas e minusculas dos campos na API
                .setPrettyPrinting()
                .create();

        while(!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite o nome do filme ou sair para encerrar: ");
            busca = URLEncoder.encode(sc.nextLine(), "UTF-8");

            if(busca.equalsIgnoreCase("sair"))  break;

            String URL="https://www.omdbapi.com/?t=" + busca + "&apikey=2c14cefc";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(URL))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                TituloOmbd meuTituloOmbd = gson.fromJson(json, TituloOmbd.class);
                Titulo meuTitulo = new Titulo(meuTituloOmbd);
                System.out.println(meuTitulo);
                titulos.add(meuTitulo);

            } catch (IOException e) {
                System.out.println("Erro ao buscar o titulo");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Argumento da busca inválido.");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro ao criar o titulo");
                System.out.println(e.getMessage());
            }
        }
        FileWriter escrita = new FileWriter("titulos.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        sc.close();
    }
}
