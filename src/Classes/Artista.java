package Classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Artista {

    private int id;
    private String nombre;
    private int ventastotales;
    private Disco discoMasVendido;
    private List<Disco> discos;

    public Artista(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.discos = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVentastotales() {
        this.ventastotales = 0;

        discos.forEach(disco -> {this.ventastotales += disco.getVentasTotales();});

        return ventastotales;
    }

    public Disco getDiscoMasVendido(){
        return discoMasVendido;
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public void registrarDisco(Disco disco) {
        this.discos.add(disco);
    }

    public void calcularDiscoMasVendido() {
        if(discos.isEmpty()) return;

        this.discoMasVendido = discos.stream().max(Comparator.comparingInt(Disco::getVentasTotales)).orElse(null);
    }

    public String mostrarArtista(){
        return "Nombre: " + nombre +
                "\nDiscos: " + discos.size() +
                "\nVentas: " + ventastotales;

    }

}
