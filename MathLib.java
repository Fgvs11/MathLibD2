public class MathLib{
    double resultado, es,ea, resulRaiz = 1, aux =1;
    //char resultadoChar[] = new char[10];
    int exponente;


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
