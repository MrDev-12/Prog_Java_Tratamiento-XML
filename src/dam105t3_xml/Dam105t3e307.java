
package dam105t3_xml;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import org.w3c.dom.*;


public class Dam105t3e307 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        File file = new File("archivos" + File.separator + "libreria.xml");

        try (

            FileInputStream fis = new FileInputStream(file);
            
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        ) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.parse(new InputSource(isr));

            NodeList listaLibros = doc.getElementsByTagName("libro");

            for (int i = 0; i < listaLibros.getLength(); i++) {

                int x = i + 1;

                Element element = (Element) listaLibros.item(i);

                String nombre;

                if (element.getElementsByTagName("titulo").item(0) != null) {

                    nombre = element.getElementsByTagName("titulo").item(0).getTextContent();

                }

                else {

                    nombre = "Sin Título";

                }

                System.out.println("- Libro " + x + ": " + nombre);

                
                Element dimensiones = (Element) element.getElementsByTagName("dimensiones").item(0);

                String alto, ancho, paginas;

                if (!dimensiones.getAttribute("alto").equals("")) {

                    alto = dimensiones.getAttribute("alto");

                }

                else {

                    alto = "?";

                }

                if (!dimensiones.getAttribute("ancho").equals("")) {

                    ancho = dimensiones.getAttribute("ancho");

                }

                else {

                    ancho = "?";

                }

                if (!dimensiones.getAttribute("paginas").equals("")) {

                    paginas = dimensiones.getAttribute("paginas");

                }

                else {

                    paginas = "?";

                }

                System.out.println("    Dimensiones: " + ancho + " cm x " + alto + " cm");

                System.out.println("    Páginas: " + paginas);

                System.out.println("\n");
                
            }

        } catch (Exception e) {

            e.printStackTrace();
            
        }

    }
    
}
