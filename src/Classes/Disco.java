package Classes;

public class Disco {
    private Artista artista;
    private String titulo;
    private int ventasTotales;

    public Disco(Artista artista, String titulo) {
        this.artista = artista;
        this.titulo = titulo;
        this.ventasTotales = 0;
    }

    public void setArtista(Artista artista){
        this.artista = artista;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setVentasTotales(int ventasTotales){
        this.ventasTotales = ventasTotales;
    }

    public Artista getArtista(){
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

        Artista artista = this.artista;
        artista.getVentastotales();
        artista.calcularDiscoMasVendido();
    }

    public void InfoDisco(){
        System.out.println(
                "\nTitulo: " + this.titulo +
                        "\nArtista: " + this.artista.getNombre() +
                        "\nVentas: " + this.ventasTotales
        );
    }
}
