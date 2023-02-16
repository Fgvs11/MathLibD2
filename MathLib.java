
public class MathLib{
    private double es;
    private double ea;
    private double resulRaiz = 1;
    private double aux =1;
    private double t;

    //Metodos auxiliares
    
    public double factorial(double numero){
        double factorial = 1.0d;
        while (numero != 0) {
            factorial *= numero--;
        }
        
        return factorial;
    }
    
    public double conGR(double grados){ //Convertir grados a radianes
        return grados * Math.PI/180;
    }

    public void errorMeta(int cifraSig) {
        es = 0.5*(Math.pow(10,-1*Math.abs(cifraSig-2)));
    }
    public double errorPorcentual(double acutal, double anterior) {
        ea = ((acutal-anterior)/acutal)*100;
        return Math.abs(ea);
    }

    public double obtenerGrados(double angulo, int opc){
        if (opc == 1){
            angulo =  conGR(angulo);
            if(angulo < 0){
                while(angulo < -360){
                    angulo += 360;
                }
            }else{
                while(angulo > 360){
                    angulo -= 360;
                }
            }
            return angulo;
        }
        if(angulo < 0){
            while(angulo < -2*Math.PI){
                angulo += 2*Math.PI;
            }
        }else{
            while(angulo > 2*Math.PI){
                angulo -= 2*Math.PI;
            }
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
        double resultadoEuler = 1 + numero;
        t = 2;
        System.out.printf("%-10.10s | %-30.30s | %-30.30s\n","n","e^(" + numero + ((numero == 1)?"°)":")"),"ea");
        System.out.printf("%-10.10s | %-30.30s | %-10.10s\n","0","1","-");
        do {
            System.out.printf("%-10.10s | %-30.30s | %."+cs+"f%s\n",t,aux,ea, "%");
            resultadoEuler += Math.pow(numero,t)/factorial(t);
            ea = errorPorcentual(resultadoEuler,aux);
            aux = resultadoEuler;
            t++;
            if (ea < es) {
                return resultadoEuler;
            }
        }while (true);
    }
    
    //Seno
    public double seno(double numero, int cs) {
        t = 3;
        double radianes = (numero) - (Math.pow(numero, t) / factorial(t));
        ea = errorPorcentual(radianes,aux);
        aux = radianes;
        double n = 1;
        System.out.printf("%-10.10s | %-30.30s | %-10.10s\n","0","1","-");
        boolean auxSeno = true;
        do {
            t = t+2;
            if (auxSeno) {
                radianes += (Math.pow(numero,t))/factorial(t);
                ea = errorPorcentual(radianes,aux);
                aux = radianes;
                auxSeno = false;
            } else {
                radianes -= (Math.pow(numero,t))/factorial(t);
                ea = errorPorcentual(radianes,aux);
                aux = radianes;
                auxSeno = true;
            }
            System.out.printf("%-10.10s | %-30.30s | %."+cs+"f%s\n",n,radianes,ea, "%");
            if (ea < es) {
                return radianes;
            }
            n++;
        }while(true);
    }

    //Coseno
    public double cos(double angulo, int cs){
        errorMeta(cs);
        System.out.printf("%-10.10s | %-30.30s | %-10.10s\n","0","1","-");
        double n = 1;
        double x = 1, xi;
        while(true){
            double factorial = factorial(2*n);
            xi = Math.pow(-1,n)/factorial * Math.pow(angulo,2*n);
            x += xi;
            double auxcos = Math.abs(xi / x) * 100;
            System.out.printf("%-10.10s | %-30.30s | %."+cs+"f%s\n",n,x,auxcos, "%");
            if(auxcos < es){
                return x;
            }
            n++;
        }
    }
    //Tangente
    public double tan(double angulo, int cs, String aux){
        System.out.printf("%-10.10s | %-30.30s | %-30.30s\n","n","sin(" + angulo + aux,"ea");
        double seno = seno(angulo,cs);
        System.out.printf("\n%-10.10s | %-30.30s | %-30.30s\n","n","cos(" + angulo + aux,"ea");
        double cos = cos(angulo, cs);
        return seno/cos ;
    }
    //Ln(x)
    public double ln(double a, int cs){
        errorMeta(cs);
        double n = 1;
        double x = 0, xi;
        while(true){
            double p1 = Math.pow((a-1)/(a+1),(2*n-1));
            double p2 = (2*n-1);
            double p3 = 1/p2; 
            xi = p3*p1;
            x += xi;
            double auxln = 2*Math.abs(xi / x) * 100;
            System.out.printf("%-10.10s | %-30.30s | %."+cs+"f%s\n",n,(2*x),auxln, "%");
            if(auxln < es || a == 1){
                return 2*x;
            }
            n++;
        }
        
        
    }
}
