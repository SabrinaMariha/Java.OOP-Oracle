package GitHub;

public class ErroAoEncontrarNome extends RuntimeException {
    private String mensagem;
    public ErroAoEncontrarNome(String mensagem) {
        this.mensagem = mensagem;
    }
    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
