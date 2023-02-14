import java.util.Arrays;
import java.util.Scanner;

public class Calculadora{
    public static void main(String[] args) {

        // Declaracion de variables-objetos
        Scanner leer = new Scanner(System.in);
        MathLib math = new MathLib();
        int opc;
        double raiz;

        // Menu MathLibs
        do {
            System.out.println("\n|--------- MathLib ---------|");
            System.out.println("[1] Raiz cuadrada de x");
            System.out.println("[2] Seno (x)");
            System.out.println("[3] Coseno (x)");
            System.out.println("[4] Tangente (x)");
            System.out.println("[5] e^x");
            System.out.println("[6] Ln(x)");
            System.out.println("[7] Salir");
            System.out.print("Opcion a elegir [1-7]: ");
            opc = leer.nextInt();

            switch (opc) {
                case 1: // Raiz cuadrada de x
                    System.out.print("Ingrese las cifras significativas deseadas: ");
                    math.errorMeta(leer.nextInt());
                    System.out.print("Ingrese el numero a calular: ");
                    raiz = math.raizCuadrada(leer.nextDouble());
                    //System.out.println("El resultado es: " + Arrays.toString(math.convertir()));
                    System.out.print("El resultado es completo es : " + raiz);
                    break;
                case 2: // Seno (x)
                    break;
                case  3: // Coseno (x)
                    break;
                case  4: // Tangente (x)
                    break;
                case  5: // e^x
                    break;
                case  6: // Ln(x)
                    break;
                case  7: // Salir
                    System.out.println("Gracias por utilizar el programa...");
                    System.out.print("Fernando Genaro Vizcaino Sanchez\nAlejandro Estrada Ponce");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Rango no valido [1-7]...");
            }
        } while (true);
    }
}
