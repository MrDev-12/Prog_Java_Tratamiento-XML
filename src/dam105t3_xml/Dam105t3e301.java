
package dam105t3_xml;

import java.util.Scanner;
import java.util.*;


public class Dam105t3e301 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        try {

            System.out.print("Introduce un número entero: ");
            int entero = teclado.nextInt();

            System.out.println("Número Entero en Hexadecimal: " + Integer.toHexString(entero));
            
        } catch (InputMismatchException e) {

            System.out.println("El valor introducido no es correcto");

        }

    }
    
}
