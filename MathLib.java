
public class MathLib{
    private double es;
    private double ea;
    private double resulRaiz = 1;
    private double aux =1;
    private double resultadoEuler;
    private double radianes;
    private boolean auxSeno;
    private int t;

    //Metodos auxiliares
    public double exponente(double valor, int exp) {
        double resultado = 1;

        for (int i = 1; i <= exp; i++){
            resultado = resultado * valor;
        }
       if (valor==10) {
            return 1/ resultado;
        }
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
            aux = resulRaiz;
            if (ea < es) {
                return resulRaiz;
            }
        }while(true);
    }

    public double euler(double numero) {
        resultadoEuler = 1 + numero;
        t = 2;
        do {
            resultadoEuler += (exponente(numero,t))/factorial(t);
            ea = errorPorcentual(resultadoEuler,aux);
            System.out.println("ea = " + ea);
            aux = resultadoEuler;
            t++;
            if (ea < es) {
                return resultadoEuler;
            }
        }while (true);
    }

    public double seno(double numero) {
        radianes = conGR(numero);
        aux = radianes;
        t = 3;
        auxSeno = true;
        radianes -= (exponente(radianes,t))/factorial(t);
        System.out.println("radianesSEXO = " + radianes);
        do {
            ea = errorPorcentual(radianes,aux);
            if (auxSeno) {
                t = t+2;
                aux = radianes;
                radianes += (exponente(radianes,t))/factorial(t);
                auxSeno = false;
                System.out.println("ea = " + ea);
                System.out.println("radianes = " + radianes);
            } else {
                t = t+2;
                aux = radianes;
                radianes -= (exponente(radianes,t))/factorial(t);
                auxSeno = true;
                System.out.println("ea = " + ea);
                System.out.println("radianes = " + radianes);
            }
            if (ea < es) {
                return radianes;
            }
        }while(true);
    }

}
