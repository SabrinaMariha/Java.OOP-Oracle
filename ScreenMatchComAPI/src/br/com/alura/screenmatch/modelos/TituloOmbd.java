package br.com.alura.screenmatch.modelos;

public record TituloOmbd(String Title, String Year, String Runtime) {
    @Override
    public String toString() {
        return  "Nome:'" + Title + '\'' +
                ", Ano de lançamento:'" + Year + '\'' +
                ", Duração:'" + Runtime + " minutos" + '\'';
    }
}

