
package dam105t3_xml;

import java.util.ArrayList;

public class Libro implements Comparable {
    
    private String ISBN;
    private String nombre;
    private double precio;
    private ArrayList <String> arrayAutores;

    Libro(String isbn, String nom, double prec, ArrayList <String> autores) {
        
        ISBN = isbn;
        nombre = nom;
        precio = prec;
        arrayAutores = autores;
        
    }

    @Override
    public int compareTo(Object o) {

        Libro lib = (Libro) o;

        return this.nombre.compareToIgnoreCase(lib.nombre);
    }

    @Override
    public String toString() {

        return "ISBN: " + ISBN + ", Nombre: " + nombre + ", Precio: " + precio + ", Autores: " + arrayAutores;

    }

}
