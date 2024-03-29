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
            opc = vInt();

            switch (opc) {
                case 1: // Raiz cuadrada de x
                    math.errorMeta(vCs());
                    System.out.print("Ingrese el numero a calular: ");
                    raiz = math.raizCuadrada(vDouble());
                    System.out.println("El resultado es: " + raiz);
                    break;
                case 2: // Seno (x)
                    msjRadianes("seno");    
                    math.errorMeta(cs);
                    System.out.printf("%-10.10s | %-30.30s | %-30.30s\n","n","sin(" + angulo + ((opcex == 1)?"°)":")"),"ea");
                    System.out.printf("El resultado es: %."+ (cs +1) +"f", math.seno(math.obtenerGrados(angulo, opcex),cs), cs);
                    break;
                case  3: // Coseno (x)
                    msjRadianes("coseno");
                    System.out.printf("%-10.10s | %-30.30s | %-30.30s\n","n","cos(" + angulo + ((opcex == 1)?"°)":")"),"ea");
                    System.out.printf("El resultado es: %."+ (cs +1) +"f", math.cos(math.obtenerGrados(angulo,opcex), cs));
                    break;
                case  4: // Tangente (x)
                    msjRadianes("tangente");
                    System.out.printf("El resultado es: %."+ (cs +1) +"f", math.tan(math.obtenerGrados(angulo,opcex), cs,((opcex == 1)?"°)":")")));
                    break;
                case  5: // e^x
                    cs = vCs();
                    math.errorMeta(cs);
                    System.out.print("Ingrese el exponente a calcular de e: ");
                    euler = math.euler(vDouble(),cs);
                    System.out.println("El resultado es: " + euler);
                    break;
                case  6: // Ln(x)
                    System.out.print("Ingrese el numero al que sacarle el ln: ");
                    double x = vDouble();
                    cs = vCs();
                    System.out.printf("%-10.10s | %-30.30s | %-30.30s\n","n","ln(x)","ea");
                    System.out.printf("El resultado es: %."+ (cs +1) +"f", math.ln(x,cs), cs);
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
        angulo = vDouble();
        System.out.print("En que se encuentra el angulo: [1]Grados [2]Radianes: ");
        do {
            opcex = vInt();
            if (opcex == 1 || opcex == 2) {
                break;
            }
            System.out.print("Opcion invalida... Ingrese un [1]Grados o [2]Radianes: ");
        } while (true);
        cs = vCs();
    }

    public static double vDouble(){
        while(true){
            try {
                String aux = leer.nextLine();
                double ans = Double.parseDouble(aux);
                return ans;
            } catch (Exception e) {
                System.out.print("Error, dato invalido... Por favor ingrese un numero con punto flotante valido: ");
            }
        }
    }
    public static int vInt(){
        while(true){
            try {
                String aux = leer.nextLine();
                int ans = Integer.parseInt(aux);
                return ans;
            } catch (Exception e) {
                System.out.print("Error, dato invalido... Por favor ingrese un numero entero valido: ");
            }
        }
    }

    public static int vCs(){
        while(true){
            System.out.print("Ingrese las cifras significativas deseadas: ");
            int aux = vInt();
            if(aux > 0){
                return aux;
            }
            System.out.print("Numero no valido...");
        }
    }
}
