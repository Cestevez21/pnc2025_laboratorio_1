package Classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorArtista {

    private List<Artista> artistas;

    public GestorArtista() {
        this.artistas = new ArrayList<>();
    }

    public void setArtistas(Artista artista) {
        this.artistas.add(artista);
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public Artista getArtista(int index) {
        return artistas.get(index);
    }

    public Artista getArtistaConMasVentas(){
        return artistas.stream().max(Comparator.comparingInt(Artista::getVentastotales)).orElse(null);
    }
}
