package GitHub;

public class PerfilUser {
    private String name;
    private String bio;

    public PerfilUser(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public PerfilUser(PerfilAPI perfilapi) {
        if (perfilapi.name()==null){
             throw new ErroAoEncontrarNome("Nome de usuário não encontrado.");
        }
            this.bio = perfilapi.bio();
            this.name = perfilapi.name();
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }


    @Override
    public String toString() {
        return "Perfil GitHub" + "\n" +
                "Nome: " + name + "\n" +
                "Bio: " + bio;
    }
}
