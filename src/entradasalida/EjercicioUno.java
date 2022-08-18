package entradasalida;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Lara
 */
public class EjercicioUno {

    private static String eliminarEspacios(String textoACambiar){
        String textoCambiado = "";
        int longitudTexto = textoACambiar.length();
        char caracterActual;
        for(int i=0; i<longitudTexto; i++){
            caracterActual = textoACambiar.charAt(i);
            if(caracterActual != ' '){
                //Lo incluyo en el nuevo String
                textoCambiado+=caracterActual;
            }
        }
        return textoCambiado;
    }
    
    private static void eliminarEspaciosDeArchivo(String archivoACambiar, String archivoCambiado){
        String lineaActual;
        try {
            FileReader lectorArchivo = new FileReader(archivoACambiar);
            FileWriter escritorArchivo = new FileWriter(archivoCambiado);
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
            lineaActual = bufferLectura.readLine();
            while(lineaActual != null){
                bufferEscritura.write(eliminarEspacios(lineaActual));
                lineaActual = bufferLectura.readLine();
            }
            bufferLectura.close();
            bufferEscritura.close();
        } catch(FileNotFoundException ex){
            System.err.println(ex.getMessage());
        } catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args){
        String archivo = Utiles.RUTA+"conEspacios.txt";
        String salida = Utiles.RUTA+"sinEspacios.txt";
        eliminarEspaciosDeArchivo(archivo, salida);
        System.out.println("Archivo original:\n");
        Utiles.mostrarContenido(archivo);
        System.out.println("\n Version sin espacios:\n");
        Utiles.mostrarContenido(salida);
    }
}
