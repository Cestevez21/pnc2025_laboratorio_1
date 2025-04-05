package Classes;

public class Disco {
    private int artista;
    private String titulo;
    private int ventasTotales;

    public Disco(int artista, String titulo, int ventasTotales) {
        this.artista = artista;
        this.titulo = titulo;
        this.ventasTotales = ventasTotales;
    }

    public void setArtista(int artista){
        this.artista = artista;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setVentasTotales(int ventasTotales){
        this.ventasTotales = ventasTotales;
    }

    public int getArtista(){
        return artista;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getVentasTotales(){
        return ventasTotales;
    }

    public void registrarVentaDisco(int cantidadDiscos){
        this.ventasTotales += cantidadDiscos;
    }

    public void InfoDisco(){
         System.out.println(
                 "Titulo: " + this.titulo +
                 "\nArtista: " + this.artista +
                 "\nVentas: " + this.ventasTotales
         );
    }
}
