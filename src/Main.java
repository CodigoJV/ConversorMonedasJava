
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean control = true;

        System.out.println("""
                     ╔==============================╗
                     ║      Conversor de divisas    ║
                     ╚==============================╝""");

        while (control) {
            System.out.println("""                            
                    Seleccione una opcion:
                    1. Iniciar
                    2. Lista de divisas
                    3. Salir""");
            try {
                int eleccion = Integer.parseInt(teclado.nextLine());

                switch (eleccion) {
                    case 1:
                        Input input = new Input();
                        input.datos();
                        break;
                    case 2:
                        Divisas divisas = new Divisas();
                        divisas.listaDivisas();
                        break;
                    case 3:
                        System.out.println("Adios!");
                        control = false;
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;
                }
            } catch (NumberFormatException e){
                System.out.println("Ingrese una opcion valida");
            }
        }
    }
}