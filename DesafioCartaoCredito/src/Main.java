
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor do limite: ");
        double limite = sc.nextDouble();
        Cartao cartao = new Cartao(limite);
        boolean continuar=true;
        do {
                System.out.println("Digite o valor da compra: ");
                double valor = sc.nextDouble();
                System.out.println("Digite a descrição da compra: ");
                String descricao = sc.nextLine();
                ItemCompra item = new ItemCompra(valor, descricao);
                cartao.comprar(item);
                System.out.println("Deseja continuar a comprar? 0 para sair, 1 para continuar: ");
                continuar = (sc.nextInt() == 1);

        }while(continuar);
        cartao.ordenarPeloPreco();
        System.out.println(cartao);

    }
}