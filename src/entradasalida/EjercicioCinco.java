package entradasalida;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Lara
 */
public class EjercicioCinco {
    private static int generarEnteroAleatorio(int minimo, int maximo){
        return (int) (minimo + Math.random() * (maximo - minimo));
    }
    
    private static boolean existeNumero(ArrayList coleccion, Integer numero){
        //https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#contains-java.lang.Object-
        return coleccion.contains(numero);
    }
   
    private static boolean generarArchivoNumerosUnicos(String archivo, int cantidadDeNumeros, int minimo, int maximo){
        //El archivo es binario
        //https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
        boolean generado = false;
        if(cantidadDeNumeros <= (maximo-minimo)){
            ArrayList numerosUnicos = new ArrayList();
            try {
                FileOutputStream escritorArchivo = new FileOutputStream(archivo);
                ObjectOutputStream flujoEscritura = new ObjectOutputStream(escritorArchivo);
                int numeroAleatorio;
                int i = 1;
                while (i <= cantidadDeNumeros) {
                    numeroAleatorio = new Integer(generarEnteroAleatorio(minimo, maximo));
                    if (!existeNumero(numerosUnicos, numeroAleatorio)) {
                        numerosUnicos.add(numeroAleatorio);
                        flujoEscritura.writeInt(numeroAleatorio);
                        i++;
                    }
                }
                flujoEscritura.close();
                generado = true;
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }else{
            System.out.println("Colocar más numeros de los que incluye el rango");
        }
        return generado;
    }
    
    public static void main(String[] args){
        String archivo = Utiles.RUTA+"numerosSinRepetir";
        int cantidadDeNumeros = 100;
        int minimo = 1;
        int maximo = 1000;
        if(generarArchivoNumerosUnicos(archivo, cantidadDeNumeros, minimo, maximo)){
            System.out.println("El contenido del archivo es:\n");
            Utiles.mostrarBinarioDeEnteros(archivo);
        }
    }
}
