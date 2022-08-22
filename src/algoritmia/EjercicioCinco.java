package algoritmia;

/**
 *
 * @author lara.acuna
 */
public class EjercicioCinco {
    
    private static int generarEnteroAleatorio(int minimo, int maximo){
        return (int) (minimo + Math.random() * (maximo - minimo));
    }
    
    private static int intentarAdivinar(int minimo, int maximo){
        //intento adivinar tomando la mitad de los dos numeros
        int mitad = (minimo + maximo)/2;
        System.out.print("La mitad de "+minimo+" y "+maximo+" es "+mitad);
        if(minimo == mitad || maximo == mitad){
            System.out.print(" (ya no lo puedo partir mas)");
        }
        System.out.println("");
        return mitad;
    }
    
    private static void simularJuego(int numero, int minimo, int maximo){
        int cantidadDeIntentos = 1;
        System.out.println("El numero a adivinar: "+numero);
        System.out.println("///////");
        int intento = intentarAdivinar(minimo, maximo);
        int intentoAnterior = intento;
        System.out.println("intento nro "+cantidadDeIntentos+": "+intento);
        System.out.println("///////");
        while(intento!=numero){
            System.out.println("///////");
            System.out.println("El numero a adivinar: "+numero);
            System.out.println("Antes intenté: "+intentoAnterior);
            if(numero>intento){
                minimo = intento;
            }else{
                maximo = intento;
            }
            intento = intentarAdivinar(minimo, maximo);
            if(intento == intentoAnterior){
                System.out.println("pero ya lo intenté antes.");
                if(numero>intento){
                    intento++;
                }else{
                    intento--;
                }
            }
            intentoAnterior = intento;
            cantidadDeIntentos++;
            System.out.println("intento nro "+cantidadDeIntentos+": "+intento);
            System.out.println("///////");
        }
        System.out.println("Lo adivine en "+cantidadDeIntentos+" intentos");
    }
    
    public static void main(String[] args){
        int minimo = 1;
        int maximo = 1000000;
        int numeroSecreto;
        numeroSecreto = 750000;
        //numeroSecreto = minimo;
        //numeroSecreto = generarEnteroAleatorio(minimo, maximo);
        //numeroSecreto = 750001;
        //numeroSecreto = maximo;
        simularJuego(numeroSecreto, minimo, maximo);
    }
}
