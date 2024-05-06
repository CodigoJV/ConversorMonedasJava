import java.util.Scanner;

public class Input {

    public void datos(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese su divisa actual: ");
        var codigoMoneda1 = teclado.nextLine();
        System.out.println("Ingrese la divisa a la que quiere convertir: ");
        var codigoMoneda2 = teclado.nextLine();
        System.out.println("Ingrese la cantidad: ");
        var cantidad = teclado.nextDouble();

        Conversor conversor = new Conversor();
        conversor.convertir(codigoMoneda1, codigoMoneda2, cantidad);
    }
}
