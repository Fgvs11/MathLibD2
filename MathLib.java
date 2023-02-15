public class MathLib{
    private double resultado, es,ea, resulRaiz = 1, aux =1;
    //char resultadoChar[] = new char[10];
    private int exponente;

    //Metodos auxiliares
    public double exponente(double valor, int exp) {
        resultado = 1;
        for (int i = 1; i <= exp; i++){
            resultado = resultado * valor;
        }
       if (valor==10) {
            return 1/resultado;
        }
       exponente = exp;
        return resultado;
    }
    
    public int factorial(int numero){
	   if(numero == 0){
		   return 1;
	   }
	   return numero * factorial(numero - 1);
    }
    
    public double conGR(double grados){ //Convertir grados a radianes
        return grados * 3.14159265358979323846264338327950288/180;
    }

    public void errorMeta(int cifraSig) {
        es = 0.5*(exponente(10,cifraSig-2));
    }
    public double errorPorcentual(double acutal, double anterior) {
        ea = ((acutal-anterior)/acutal)*100;
        if (ea < 0) {
            ea = ea*-1;
        }
        return ea;
    }

    public double obtenerGrados(double angulo, int opc){
        if (opc == 1){
            return conGR(angulo);
        }
        return angulo;
    }

    public double valorAbsoluto(double a){
        if(a < 0){
            return -1 * a;
        }
        return a;
    }
    //Metodos de alexius
    public double raizCuadrada(double numero){
        do {
            resulRaiz = 0.5*(resulRaiz + numero/resulRaiz);
            ea = errorPorcentual(resulRaiz,aux);
            aux = resulRaiz;;
            if (ea < es) {
                return resulRaiz;
            }
        }while(true);
    }

    /* public char[] convertir() {
        for (int i = 0; i <= exponente; i++) {
            resultadoChar[i] = (String.valueOf(resulRaiz).charAt(i));
        }
        return resultadoChar;
    }
     */

    //Coseno
    public double cos(double angulo, int cs){
        System.out.printf("%-10.10s | %-30.30s | %-10.10s\n","0","1","-");
        int n = 1;
        errorMeta(cs);
        double x = 1, xi;
        while(true){
            xi = x + exponente(-1,n) * exponente(angulo,2*n)/factorial(2*n);
            Double auxcos = valorAbsoluto((valorAbsoluto(xi) - valorAbsoluto(x))/ valorAbsoluto(xi) * 100);
            System.out.printf("%-10.10s | %-30.30s | %."+cs+"f%s\n",String.valueOf(n),String.valueOf(xi),auxcos, "%");
            if(auxcos < es){
                return xi;
            }
            n++;
            x = xi;
        }
    }
}
