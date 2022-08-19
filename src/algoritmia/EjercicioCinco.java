package algoritmia;

/**
 *
 * @author Lara
 */
public class EjercicioCinco {
    
    private static int generarEnteroAleatorio(int minimo, int maximo){
        return (int) (minimo + Math.random() * (maximo - minimo));
    }
    
    private static int[] generarArregloAleatorio(int tamanio){
        int[] arreglo = new int[tamanio];
        for(int i=0; i<tamanio; i++){
            arreglo[i] = generarEnteroAleatorio(1, 1000);
        }
        return arreglo;
    }
    
    private static int[] crearFusionDeArreglos(int[] arregloA, int[]arregloB){
        int tamanioA = arregloA.length;
        int tamanioB = arregloB.length;
        int tamanio =  tamanioA + tamanioB;
        int[] arregloC = new int[tamanio];
        for(int i=0; i<tamanioA; i++){
            arregloC[i] = arregloA[i];
        }
        for(int i=0; i<tamanioB; i++){
            arregloC[(i+tamanioA)] = arregloB[i];
        }
        Utiles.mezclar(arregloC, 1, tamanioA, tamanio);
        return arregloC;
    }
    
    public static void main(String[] args){
        int tamanioA = 100;
        int tamanioB = 60;
        int[] arregloA = generarArregloAleatorio(tamanioA);
        int[] arregloB = generarArregloAleatorio(tamanioB);
        Utiles.mergeSort(arregloA);
        Utiles.burbujaMejorado(arregloB);
        int[] arregloC = crearFusionDeArreglos(arregloA, arregloB);
        System.out.println("El arreglo A es: ");
        Utiles.mostrarArreglo(arregloA);
        System.out.println("\n El arreglo B es: ");
        Utiles.mostrarArreglo(arregloB);
        System.out.println("\n El arreglo C es: ");
        Utiles.mostrarArreglo(arregloC);
    }
}
