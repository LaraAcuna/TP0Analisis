package algoritmia;

import java.util.Scanner;
/**
 *
 * @author Lara
 */
public class EjercicioTres {

    private static int contarDivisores(int numero){
        int cantidadDivisores = 0;
        for(int i=1; i<=numero; i++){
            if(numero%i == 0)
                cantidadDivisores++;
        }
        return cantidadDivisores;
    }
    
    private static boolean esPrimo(int numero){
        return contarDivisores(numero) == 2; 
    }
    
    private static int contarPrimos(int desde, int hasta){
        int cantidadPrimos = 0;
        for(int numero=desde; numero<=hasta; numero++){
            if(esPrimo(numero))
                cantidadPrimos++;
        }
        return cantidadPrimos;
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numero;
        System.out.println("Ingrese un numero entero");
        numero = scanner.nextInt();
        System.out.println("La cantidad de primos entre 1 y "+numero+" es: "+contarPrimos(1, numero));
    }
}
