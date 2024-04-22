package ViaCEP;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscaPorEnderecoAPIViaCEP {
    public void BuscarPorEndereco() throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();
        Scanner sc = new Scanner(System.in);
        List<Endereco> listaEnderecos = new ArrayList<>();
        boolean decisao;
        do {
            System.out.println("Será necessário o nome da rua, UF e cidade para buscar o endereço.");
            System.out.println("Digite o nome da rua: ");
            var rua = (sc.nextLine()).replace(" ","+");
            System.out.println("Digite a UF: ");
            var UF= sc.nextLine();
            System.out.println("Digite o nome da cidade: ");
            var cidade = (sc.nextLine()).toUpperCase().replace(" ","%20");
            String URL = "https://viacep.com.br/ws/"+UF+"/"+cidade+"/"+rua+"/json/";
            System.out.println(URL);
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(URL))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                json = json.substring(1, json.length() - 1);
                EnderecoAPI enderecoAPI = gson.fromJson(json,EnderecoAPI.class);
                Endereco endereco = new Endereco(enderecoAPI);
                listaEnderecos.add(endereco);
            }catch (IllegalArgumentException e) {
                System.out.println("Argumento inválido. Por favor verifique o CEP.");
                System.out.println(e.getMessage());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }catch (Exception e) {
                System.out.println("Erro ao buscar o CEP.");
                System.out.println(e.getMessage());
            }
            System.out.println("Deseja buscar outro endereço? (Digite 1 para SIM ou 0 para NÂO)");
            decisao=(sc.nextInt()==1);
            sc.nextLine();
        } while (decisao);

        FileWriter escrita = new FileWriter("Enderecos.json");
        escrita.write(gson.toJson(listaEnderecos));
        escrita.close();
        sc.close();
    }
}
