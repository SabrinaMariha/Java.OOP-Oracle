import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nAleatorio=0, nTentativa=0,maxTentativas=5,i;
        nAleatorio= new Random().nextInt(100);

        System.out.println("Bem-vindo ao jogo de adivinhação! Você tem 5 tentativas para adivinhar o número secreto de 0 a 100.");

        for( i=0;i<maxTentativas;i++){
            do{
                System.out.println("Digite um número de 0 a 100 para sua "+(i+1)+"ª tentativa:");
                nTentativa=sc.nextInt();
            }while(nTentativa>100 || nTentativa<0);

            if(nTentativa==nAleatorio){
                System.out.println("Parabéns, você acertou o número secreto com " + (i+1) +" tentativa(s)!");
                break;
            }else if(nTentativa<nAleatorio){
                System.out.println("O número secreto é maior que "+nTentativa);
            }else{
                System.out.println("O número secreto é menor que "+nTentativa);
            }
        }
        if(i==5)  System.out.println("Que pena! suas chances acabaram, o número secreto era: "+nAleatorio);
        sc.close();
    }
}