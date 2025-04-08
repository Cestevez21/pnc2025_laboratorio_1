import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Classes.Artista;
import Classes.Disco;
import Classes.GestorArtista;
import Classes.GestorDisco;

public class Main {

    static GestorArtista TodosArtistas = new GestorArtista();
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
                        "\n4.)Ver \"Artista\" con \"Disco\" mas vendido." +
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


    public static void ingresarArtista(){
        System.out.print("\nIngrese el nombre del artista: ");
        String nombreArtista = sc.nextLine();
        int idArtista = TodosArtistas.getArtistas().size() + 1;

        Artista artista = new Artista(idArtista, nombreArtista);

        TodosArtistas.setArtistas(artista);

        System.out.println("\nEl artista se ha ingresado correctamente.");
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

}