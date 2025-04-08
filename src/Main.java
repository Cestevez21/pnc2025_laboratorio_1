import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.Artista;
import Classes.Disco;
import Classes.GestorArtista;
import Classes.GestorDisco;

public class Main {

    static GestorArtista TodosArtistas = new GestorArtista();
    static GestorDisco TodosDiscos = new GestorDisco();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int  option;
        do {
            mostrarMenu();
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: ingresarArtista(); break;
                case 2: ingresarDisco(); break;
                case 3: comprarDisco(); break;
                case 4: artistaConDiscoMasVendido(); break;
                case 5: verDiscoConXVenas(); break;
                case 6: mostrarTodosArtistas(); break;
                case 7: mostrarTodosDiscos(); break;
                default: System.out.println("Saliendo..."); break;
            }
        } while (option > 0 && option < 8);

    }

    public static void mostrarMenu(){
        System.out.print(
                "\n1.)Ingresar Artista." +
                        "\n2.)Ingresar Disco." +
                        "\n3.)Comprar Disco." +
                        "\n4.)Ver \"Artista\" con mas discos vendidos." +
                        "\n5.)Ver Disco con mas de X cantidades vendidas." +
                        "\n6.)Ver todos los Artistas." +
                        "\n7.)Ver todos los discos." +
                        "\n8.)Salir.\n" +
                        "> "
        );
    }

    public static void mostrarTodosArtistas(){

        if(TodosArtistas.getArtistas().isEmpty()) {
            System.out.println("No hay artistas.");
        }  else {
            System.out.println("\nTodos los artistas:");
            for (Artista artista: TodosArtistas.getArtistas()){
                System.out.println(artista.getId()+".)"+artista.getNombre());
            }
        }

    }

    public static void mostrarTodosDiscos(){
        List<Disco> discos = TodosDiscos.getDiscos();

        if(discos.isEmpty()){
            System.out.println("No hay discos.");
        } else {
            System.out.println("\nTodos los discos:");

            for (int i = 0; i < discos.size(); i++){
                System.out.println((i+1)+".)"+discos.get(i).getTitulo()+"["+discos.get(i).getArtista().getNombre()+"]");
            }
        }
    }

    public static void ingresarArtista(){
        System.out.print("\nIngrese el nombre del artista: ");
        String nombreArtista = sc.nextLine();
        int idArtista = TodosArtistas.getArtistas().size() + 1;

        Artista artista = new Artista(idArtista, nombreArtista);

        TodosArtistas.setArtistas(artista);

        System.out.println("\nEl artista se ha ingresado correctamente.");
    }

    public static void ingresarDisco(){
        System.out.println("\nLista de Artistas: ");

        for (Artista artista : TodosArtistas.getArtistas()){
            System.out.println(artista.getId()+".) "+artista.getNombre());
        }

        System.out.print("Seleccione el ID del artista: ");

        int idArtista = sc.nextInt();
        sc.nextLine();

        Artista artista = TodosArtistas.getArtista(idArtista - 1);

        System.out.print("\nIngrese el nombre del disco: ");
        String nombreDisco = sc.nextLine();

        Disco disco = new Disco(artista, nombreDisco);
        artista.registrarDisco(disco);
        TodosDiscos.setDiscos(disco);

        System.out.println("El disco se ha registrado correctamente.");
    }

    public static void comprarDisco(){
        List<Disco> discos = TodosDiscos.getDiscos();
        System.out.println("\nLista de Discos: ");

        for (int i = 0; i < discos.size(); i++){
            System.out.println((i + 1) + ".)" + discos.get(i).getTitulo());
        }

        System.out.print("\nSelecciona el ID del disco que deseas comprar: ");
        int idDisco = sc.nextInt();
        sc.nextLine();

        System.out.println("Disco seleccionado: " + discos.get(idDisco - 1).getTitulo().toUpperCase() +"\nCuantas copias deseas comprar?");
        int copias = sc.nextInt();
        sc.nextLine();

        Disco disco = discos.get(idDisco - 1);
        disco.registrarVentaDisco(copias);

        System.out.println("La compra se ha realizado con exito.");
    }

    public static void artistaConDiscoMasVendido(){
        Artista mejorArtista = TodosArtistas.getArtistaConMasVentas();

        if(mejorArtista != null){
            System.out.println("\nEl artista con mas ventas totales es");
            System.out.println(mejorArtista.mostrarArtista());
        } else {
            System.out.println("No hay artistas registrados");
        }
    }

    public static void verDiscoConXVenas(){
        System.out.print("\nIngresa el minimo de ventas: ");
        int ventas = sc.nextInt();
        sc.nextLine();

        List<Disco> discosFiltrados = TodosDiscos.getDiscosConXVentas(ventas);

        if (discosFiltrados.isEmpty()){
            System.out.println("No hay discos con mas de "+ventas+" ventas.");
        } else {
            discosFiltrados.forEach(Disco::InfoDisco);
        }
    }

}