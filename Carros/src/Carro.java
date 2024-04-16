import java.util.Scanner;

/*Crie uma classe Carro com métodos para representar um modelo específico ao longo de três anos.
 Implemente métodos para definir o nome do modelo, os preços médios para cada ano, e calcular e exibir o
 menor e o maior preço. Adicione uma subclasse ModeloCarro para criar instâncias específicas, utilizando-a
 na classe principal para definir preços e mostrar informações.*/
public class Carro {
    Scanner sc = new Scanner(System.in);
    private String nomeModelo;
    double[] precos = new double[3];

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public void definePrecos() {
        for(int i=0;i<3;i++){
            System.out.println("Digite o preco do ano "+(2021+i)+":");
            this.precos[i]= sc.nextDouble();
        }
        sc.close();
    }

    public void comparacaoPrecos(){
        int indiceDoMaior=0,indiceDoMenor=0;
        double maior=precos[0];
        double menor =precos[0];

        for(int i=1;i<precos.length;i++){
            if(precos[i]>maior){
                maior=precos[i];
                indiceDoMaior=i;
            }
            if(precos[i]<menor){
                menor=precos[i];
                indiceDoMenor=i;
            }
        }
           System.out.println("O modelo "+ this.nomeModelo +" do ano "+(2021+indiceDoMaior)+" é o que tem o maior preço: \n"
                              +precos[indiceDoMaior]+
                              "\nO modelo "+ this.nomeModelo +" do ano "+(2021+indiceDoMenor)+"é o que tem o menor preço: \n"
                              +precos[indiceDoMenor]);
    }

    public String ficha(){
        return String.format("Modelo: %s\n" +
                             "Preços:\n" +
                             "Ano 2021: %.2f\n" +
                             "Ano 2022: %.2f\n" +
                             "Ano 2023: %.2f\n",
                this.nomeModelo,
                this.precos[0],
                this.precos[1],
                this.precos[2]);
    }

}