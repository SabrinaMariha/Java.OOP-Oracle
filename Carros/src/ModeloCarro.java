public class ModeloCarro extends Carro{
    int qntMarchas;

    public int getQntMarchas() {
        return qntMarchas;
    }

    public void setQntMarchas(int qntMarchas) {
        this.qntMarchas = qntMarchas;
    }

    @Override
    public String ficha(){
        return String.format("Modelo: %s\n" +
                             "Preços:\n" +
                             "Ano 2021: %.2f\n" +
                             "Ano 2022: %.2f\n" +
                             "Ano 2023: %.2f\n"+
                            "Quantas marchas:%d\n",
                this.getNomeModelo(),
                this.precos[0],
                this.precos[1],
                this.precos[2],
                this.qntMarchas);
    }
}
