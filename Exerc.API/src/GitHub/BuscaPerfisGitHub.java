package GitHub;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscaPerfisGitHub {
    public static void main(String[] args) throws UnsupportedEncodingException, ErroAoEncontrarNome {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome de usuário: ");
        var busca = URLEncoder.encode(sc.nextLine(), "UTF-8");

        String URL="https://api.github.com/users/" +busca;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
            PerfilAPI perfilapi = gson.fromJson(json, PerfilAPI.class);
            PerfilUser perfil = new PerfilUser(perfilapi);
            System.out.println(perfil);
        }catch (IllegalArgumentException e) {
            System.out.println("Argumento inválido. Por favor verifique o nome de usuário.");
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ErroAoEncontrarNome e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao buscar o perfil.");
            System.out.println(e.getMessage());
        } finally {
            sc.close();
            System.out.println("Fim da busca.");
        }
    }
}
