package entradasalida;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Lara
 */
public class Utiles {
    
    static final String RUTA = "src/entradasalida/archivos/";
    
    public static void mostrarContenido(String archivo){
        String lineaActual;
        try{
            FileReader lectorArchivo = new FileReader(archivo);
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            lineaActual = bufferLectura.readLine();
            while(lineaActual != null){
                System.out.println(lineaActual);
                lineaActual = bufferLectura.readLine();
            }
            bufferLectura.close();
        } catch(FileNotFoundException ex){
            System.err.println(ex.getMessage());
        } catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static void mostrarBinarioDeEnteros(String archivo){  
        try{
            ObjectInputStream flujoLectura = null;
            try{
                FileInputStream lectorArchivo = new FileInputStream(archivo);
                flujoLectura = new ObjectInputStream(lectorArchivo);
                while(true){
                    System.out.println(flujoLectura.readInt());
                }
            } catch(EOFException e) {
                flujoLectura.close();
            } catch(IOException ex){
                System.err.println(ex.getMessage());
            }
        } catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
