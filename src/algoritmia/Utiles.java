package algoritmia;

/**
 *
 * @author Lara
 */
public class Utiles {
    /*public static int[] mezclarArreglosOrdenados(int[] arreglo, int[] arreglo){
        int tamanoA = arreglo.length;
        int tamanoB = arreglo.length;
        int nuevoTamano = tamanoA+tamanoB;
        int punteroMitadIzq = 0;
        int punteroMitadDer = 0;
        int[] nuevoArreglo = new int[nuevoTamano];
        int colocar;
        boolean recorrioIzq, recorrioDer; //Indican si el arreglo ya fue recorrido en su totalidad. Es su puntero correspondiente iguala el tamaño del arreglo.
        for(int i=0; i<nuevoTamano; i++){
            recorrioIzq = tamanoA == punteroMitadIzq;
            recorrioDer = tamanoB == punteroMitadDer;
            if(!recorrioIzq && !recorrioDer){
                if(arreglo[punteroMitadIzq]<arreglo[punteroMitadDer]){
                    colocar = arreglo[punteroMitadIzq];
                    punteroMitadIzq++;
                }else{
                    colocar = arreglo[punteroMitadDer];
                    punteroMitadDer++;
                }
            }else if(recorrioIzq){
                colocar = arreglo[punteroMitadDer];
                punteroMitadDer++;
            }else{
                colocar = arreglo[punteroMitadIzq];
                punteroMitadIzq++;
            }
            nuevoArreglo[i] = colocar;
        }
        return nuevoArreglo;
    }*/
    
    public static int[] crearCopiaDeArreglo(int[] arregloACopiar){
        int tamanioArreglo = arregloACopiar.length;
        int[] arregloCopia = new int[tamanioArreglo];
        for(int i=0; i<tamanioArreglo; i++){
            arregloCopia[i] = arregloACopiar[i];
        }
        return arregloCopia;
    }
    
    public static void mezclar(int[] arreglo, int topeIzq, int medio, int topeDer){
        int[] copiaDeArreglo = crearCopiaDeArreglo(arreglo);
        int punteroMitadIzq = (topeIzq-1);
        int punteroMitadDer = medio;
        int colocar;
        boolean recorrioIzq, recorrioDer; //Indican si la mitad ya fue recorrida en su totalidad.
        for(int i=(topeIzq-1); i<topeDer; i++){
            recorrioIzq = punteroMitadIzq == medio;
            recorrioDer = punteroMitadDer == topeDer;
            if(!recorrioIzq && !recorrioDer){
                if(copiaDeArreglo[punteroMitadIzq]<copiaDeArreglo[punteroMitadDer]){
                    colocar = copiaDeArreglo[punteroMitadIzq];
                    punteroMitadIzq++;
                }else{
                    colocar = copiaDeArreglo[punteroMitadDer];
                    punteroMitadDer++;
                }
            }else if(recorrioIzq){
                colocar = copiaDeArreglo[punteroMitadDer];
                punteroMitadDer++;
            }else{
                colocar = copiaDeArreglo[punteroMitadIzq];
                punteroMitadIzq++;
            }
            arreglo[i] = colocar;
        }
    }
    
    public static void mergeSortRecursivo(int[] arreglo, int topeIzq, int topeDer){
        int mitad;
        
        if(topeIzq<topeDer){
            mitad = (topeIzq + topeDer)/2;
            mergeSortRecursivo(arreglo, topeIzq, mitad);
            mergeSortRecursivo(arreglo, (mitad+1), topeDer);
            mezclar(arreglo, topeIzq, mitad, topeDer);
        }
    }

    public static void mergeSort(int[] arreglo){
        mergeSortRecursivo(arreglo, 1, arreglo.length);
    }
    
    public static void burbujaMejorado(int[] arreglo){
        int tamanioSinOrdenar = arreglo.length;
        boolean seguirOrdenando;
        int izquierda, derecha;
        do{
            seguirOrdenando = false;
            for(int i=0; i<(tamanioSinOrdenar-1); i++){
                izquierda = arreglo[i];
                derecha = arreglo[i+1];
                if(izquierda>derecha){
                    arreglo[i] = derecha;
                    arreglo[i+1] = izquierda;
                    seguirOrdenando = true;
                }
            }
            tamanioSinOrdenar--;
        }while(seguirOrdenando);
    }
    
     public static void mostrarArreglo(int[] arreglo){
        for(int i=0; i<arreglo.length; i++){
                System.out.print(arreglo[i]+" ");
        }
    }
}
