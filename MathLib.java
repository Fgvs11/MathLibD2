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
}
