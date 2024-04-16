package modelo;

public class Audio implements Reproduzivel {
    private String titulo;
    private int totalReproducoes;
    private int classificacao;
    private int totalCurtidas;
    private int volume = 10;

    public void curte() {
        this.totalCurtidas++;
    }

    public void reproduz() {
        this.totalReproducoes++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public int getTotalCurtidas() {
        return totalCurtidas;
    }


    @Override
    public void abaixarVolume() {
        System.out.println("Abaixando volume...");
        this.volume--;
        System.out.println("Volume: " + volume);
    }

    @Override
    public void aumentarVolume() {
        System.out.println("Aumentando volume...");
        this.volume++;
        System.out.println("Volume: " + volume);
    }
}
