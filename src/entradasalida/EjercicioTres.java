package entradasalida;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Lara
 */
public class EjercicioTres {
    private static double generarNumeroAleatorio(int minimo, int maximo){
        return minimo + (Math.random() * (maximo-minimo));
    }
    
    private static void generarArchivoNumerosAleatorios(String archivo, int cantidadDeNumeros, int minimo, int maximo){
        try{
            FileWriter escritorArchivo = new FileWriter(archivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
            for(int i=1; i<=cantidadDeNumeros; i++){
                bufferEscritura.write(generarNumeroAleatorio(minimo, maximo)+"\n");
            }
            bufferEscritura.close();
        } catch(FileNotFoundException ex){
            System.err.println(ex.getMessage());
        } catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args){
        String archivo = Utiles.RUTA+"numerosAleatorios.txt";
        int cantidadDeNumeros = 100;
        int minimo = -100;
        int maximo = 100;
        generarArchivoNumerosAleatorios(archivo, cantidadDeNumeros, minimo, maximo);
        System.out.println("El contenido del archivo es:\n");
        Utiles.mostrarContenido(archivo);
    }
}
