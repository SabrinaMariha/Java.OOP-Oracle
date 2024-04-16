package principal;

import modelo.*;

public class Principal {
    public static void main(String[] args) {
        int i;
        Musica musica = new Musica();
        musica.setTitulo("Forever");
        musica.setCantor("Kiss");

        for (i = 0; i < 1000; i++) {
            musica.reproduz();
        }
        for (i = 0; i < 1000; i++) {
            musica.curte();
        }
        Podcast meupodcast = new Podcast();
        meupodcast.setApresentador("Marcus Mendes");
        meupodcast.setTitulo("bolhaDev");

        for (i = 0; i < 5000; i++) {
            meupodcast.reproduz();
        }
        for (i = 0; i < 1000; i++) {
            meupodcast.curte();
        }

        for (i = 0; i < 5; i++) {
            musica.abaixarVolume();
        }
        MinhasPreferidas preferidas = new MinhasPreferidas();
        preferidas.inclui(musica);
        preferidas.inclui(meupodcast);
    }


}
