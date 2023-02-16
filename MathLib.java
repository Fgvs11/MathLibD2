
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
    
    public double factorial(int numero){
	   if(numero == 0){
		   return 1;
	   }
	   return numero * factorial(numero - 1);
    }
    
    public double conGR(double grados){ //Convertir grados a radianes
        return grados * Math.PI/180;
    }

    public void errorMeta(int cifraSig) {
        es = 0.5*(Math.pow(10,-1*Math.abs(cifraSig-2)));
    }
    public double errorPorcentual(double acutal, double anterior) {
        ea = (acutal-anterior/acutal)*100;
        return Math.abs(ea);
    }

    public double obtenerGrados(double angulo, int opc){
        if (opc == 1){
            return conGR(angulo);
        }
        return angulo;
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

    public double euler(double numero, int cs) {
        resultadoEuler = 1 + numero;
        t = 2;
        do {
            resultadoEuler += Math.pow(numero,t)/Math.pow(numero,t);
            ea = errorPorcentual(resultadoEuler,aux);
            System.out.println("ea = " + ea);
            aux = resultadoEuler;
            t++;
            if (ea < es) {
                return resultadoEuler;
            }
        }while (true);
    }
    
    //Seno
    public double seno(double numero) {
        radianes = numero;
        aux = radianes;
        t = 3;
        auxSeno = true;
        radianes -= (Math.pow(radianes,t))/factorial(t);
        System.out.println("radianesSEXO = " + radianes);
        do {
            ea = errorPorcentual(radianes,aux);
            if (auxSeno) {
                t = t+2;
                aux = radianes;
                radianes += (Math.pow(radianes,t))/factorial(t);
                auxSeno = false;
                System.out.println("ea = " + ea);
                System.out.println("radianes = " + radianes);
            } else {
                t = t+2;
                aux = radianes;
                radianes -= (Math.pow(radianes,t))/factorial(t);
                auxSeno = true;
                System.out.println("ea = " + ea);
                System.out.println("radianes = " + radianes);
            }
            if (ea < es) {
                return radianes;
            }
        }while(true);
    }

    //Coseno
    public double cos(double angulo, int cs){
        errorMeta(cs);
        System.out.println(es);
        System.out.printf("%-10.10s | %-30.30s | %-10.10s\n","0","1","-");
        int n = 1;
        double x = 1, xi;
        while(true){
            xi = (Math.pow(-1,n) * Math.pow(angulo,2*n)/factorial(2*n));
            x += xi;
            double auxcos = Math.abs(xi / x) * 100;
            System.out.printf("%-10.10s | %-30.30s | %."+cs+"f%s\n",String.valueOf(n),String.valueOf(x),auxcos, "%");
            if(auxcos < es){
                return x;
            }
            n++;
        }
    }
    //Tangente
    public double tan(double angulo, int cs){
        return seno(angulo)/ cos(angulo, cs);
    }

    public double ln(double a, int cs){
        errorMeta(cs);
        int n = 1;
        double x = 0, xi;
        while(true){
            xi = 1/(2*n-1)*Math.pow((a-1)/(a+1),(2*n-1));
            x += xi;
            double auxln = 2*Math.abs(xi / x) * 100;
            System.out.printf("%-10.10s | %-30.30s | %."+cs+"f%s\n",String.valueOf(n),String.valueOf(x),auxln, "%");
            if(auxln < es || a == 1){
                return x;
            }
            n++;
        }
        
        
    }
}
