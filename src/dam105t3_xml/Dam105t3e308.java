
package dam105t3_xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import org.w3c.dom.*;

public class Dam105t3e308 {

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

            ArrayList<Libro> arrayLibros = new ArrayList<>();

            NodeList listaLibros = doc.getElementsByTagName("libro");

            for (int i = 0; i < listaLibros.getLength(); i++) {

                Element element = (Element) listaLibros.item(i);

                String isbn = element.getElementsByTagName("isbn").item(0).getTextContent();

                String nombre = element.getElementsByTagName("titulo").item(0).getTextContent();

                double precio = Double.parseDouble(element.getElementsByTagName("precio").item(0).getTextContent());

                ArrayList<String> autores = new ArrayList<>();

                NodeList listaAutores = element.getElementsByTagName("autor");

                for (int j = 0; j < listaAutores.getLength(); j++) {

                    autores.add(listaAutores.item(j).getTextContent());

                }

                arrayLibros.add(new Libro(isbn, nombre, precio, autores));

            }
            
            Collections.sort(arrayLibros);

            for (int i = 0; i < arrayLibros.size(); i++) {

                System.out.println(arrayLibros.get(i).toString());
                
            }

        } catch (Exception e) {

            e.printStackTrace();
            
        }

    }
    
}
