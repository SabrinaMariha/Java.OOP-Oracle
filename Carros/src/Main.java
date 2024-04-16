public class Main {
    public static void main(String[] args) {
        ModeloCarro modeloCarro = new ModeloCarro();

        modeloCarro.setNomeModelo("Sedan");
        modeloCarro.setQntMarchas(5);
        modeloCarro.definePrecos();
        System.out.println(modeloCarro.ficha());
        modeloCarro.comparacaoPrecos();


    }
}