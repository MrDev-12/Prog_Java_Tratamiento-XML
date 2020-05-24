
package dam105t3_xml;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Dam105t3e314 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        File file = new File("archivos" + File.separator + "libreria.xml");

        try (

                FileInputStream fis = new FileInputStream(file);

                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        ) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.newDocument();
            

            // Creacion nodo raiz

            Element raiz = doc.createElement("agenda");

            doc.appendChild(raiz);


            // Creacion nodos hijos

            Element contacto1 = doc.createElement("contacto");

            contacto1.appendChild(doc.createTextNode("Julian Perez"));

            raiz.appendChild(contacto1);


            Element contacto2 = doc.createElement("contacto");

            contacto2.appendChild(doc.createTextNode("Ana Lopez"));

            raiz.appendChild(contacto2);


            // Guardar en archivo XML

            File exitFile = new File("archivos" + File.separator + "agenda.xml");

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(exitFile));

        } catch (Exception e) {

            e.printStackTrace();
            
        }

    }
    
}
