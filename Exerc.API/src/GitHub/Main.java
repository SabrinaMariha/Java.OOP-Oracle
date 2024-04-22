package GitHub;

import ViaCEP.BuscaPorCEPAPIViaCEP;
import ViaCEP.BuscaPorEnderecoAPIViaCEP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja buscar um endereço pelo CEP ou um CEP pelo endereço? (Digite 'endereço' ou 'cep')");
        String decisao = sc.nextLine();
        BuscaPorCEPAPIViaCEP busca = new BuscaPorCEPAPIViaCEP();
        BuscaPorEnderecoAPIViaCEP buscaEndereco = new BuscaPorEnderecoAPIViaCEP();
        if(decisao.equalsIgnoreCase("cep")) {

            try {
                busca.BuscarPorCep();
            } catch (Exception e) {
                System.out.println("Erro ao buscar o CEP.");
                System.out.println(e.getMessage());
            }
        }else if(decisao.equalsIgnoreCase("endereço")) {
            try {
            buscaEndereco.BuscarPorEndereco();

            } catch (Exception e) {
                System.out.println("Erro ao buscar o CEP.");
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("Opção inválida.");
        }
    }
}
