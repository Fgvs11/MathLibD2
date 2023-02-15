
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

        for (int i = 1; i <= valorAbsoluto(exp); i++){
            resultado = resultado * valor;
        }
       if(exp < 0){
            return 1/resultado;
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
        es = 0.5*(exponente(10,-1*(cifraSig-2)));
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

    public double redondear(double valor, int cs){
        double ans =(valor * exponente(10, cs));
        double aux = ans - (int)ans;
        if(aux >= .5){
            return ((int) ans + 1) * exponente(10, -cs);
        }
        return ((int) ans) * exponente(10, -cs);
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
    //Coseno
    public double cos(double angulo, int cs){
        errorMeta(cs);
        System.out.println(es);
        System.out.printf("%-10.10s | %-30.30s | %-10.10s\n","0","1","-");
        int n = 1;
        
        double x = 1, xi;
        while(true){
            xi = x + exponente(-1,n) * exponente(angulo,2*n)/factorial(2*n);
            xi = redondear(xi, cs +1 );
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
