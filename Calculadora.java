import java.util.Scanner;

public class Calculadora{
    public static int opcex;
    public static double angulo;
    public static Scanner leer = new Scanner(System.in);
    public static int cs;
    public static void main(String[] args) {

        // Declaracion de variables-objetos
        
        MathLib math = new MathLib();
        int opc;
        double raiz, euler;

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
                    System.out.println("El resultado es: " + raiz);
                    break;
                case 2: // Seno (x)
                    msjRadianes("seno");    
                    math.errorMeta(cs);
                    System.out.printf("%-10.10s | %-30.30s | %-30.30s\n","n","sen(" + angulo + ((opcex == 1)?"°)":")"),"ea");
                    System.out.printf("El resultado es: %."+ (cs +1) +"f", math.seno(math.obtenerGrados(angulo, opcex)), cs);
                    break;
                case  3: // Coseno (x)
                    msjRadianes("coseno");
                    System.out.printf("%-10.10s | %-30.30s | %-30.30s\n","n","cos(" + angulo + ((opcex == 1)?"°)":")"),"ea");
                    System.out.printf("El resultado es: %."+ (cs +1) +"f", math.cos(math.obtenerGrados(angulo,opcex), cs));
                    break;
                case  4: // Tangente (x)
                    msjRadianes("tangente");
                    System.out.printf("El resultado es: %."+ (cs +1) +"f", math.tan(math.obtenerGrados(angulo,opcex), cs));
                    break;
                case  5: // e^x
                    System.out.print("Ingrese las cifras significativas deseadas: ");
                    cs = leer.nextInt();
                    math.errorMeta(cs);
                    System.out.print("Ingrese el exponente a calcular de e: ");
                    euler = math.euler(leer.nextDouble(),cs);
                    System.out.println("El resultado es: " + euler);
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

    public static void msjRadianes(String aux) {
        System.out.print("Ingrese el angulo del "+ aux +": ");
        angulo = leer.nextDouble();
        System.out.print("En que se encuentra el angulo: [1]Grados [2]Radianes: ");
        do {
            opcex = leer.nextInt();
            if (opcex == 1 || opcex == 2) {
                break;
            }
            System.out.print("Opcion invalida... Ingrese un [1]Grados o [2]Radianes: ");
        } while (true);
        System.out.print("Ingrese las cifras significativas deseadas: ");
        cs = leer.nextInt();
    }
}
