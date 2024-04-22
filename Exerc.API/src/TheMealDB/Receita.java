package TheMealDB;

import org.jetbrains.annotations.NotNull;

public class Receita {
    String nome;
    String instrucao;
    String area;
    String Youtube;
    public Receita(String nome, String instrucao, String area, String strYoutube) {
        this.nome = nome;
        this.instrucao = instrucao;
        this.area = area;
        this.Youtube = strYoutube;
    }

    public Receita() {
    }

    public Receita(ReceitaAPI receita) {
        this.nome = receita.strMeal();
        this.instrucao = receita.strInstructions();
        this.area = receita.strArea();
        this.Youtube = receita.strYoutube();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    @Override
    public String toString() {
       String intrucoes=getInstrucao().replace(".","\n");
        return "Meal: " + getNome() + "\n" +
                "Area: " + getArea() + "\n" +
                "Instructions: \n" + intrucoes +"\n" +
                "Video Youtube: " + Youtube + "\n";
    }
}
