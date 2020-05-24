
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
import org.xml.sax.InputSource;
import org.w3c.dom.*;

public class Dam105t3e313 {

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

                Element element = (Element) listaLibros.item(i);

                element.removeChild(element.getElementsByTagName("isbn").item(0));

                element.removeChild(element.getElementsByTagName("dimensiones").item(0));

                if (element.getElementsByTagName("tematica").item(0) != null) {

                    element.removeChild(element.getElementsByTagName("tematica").item(0));

                }

                element.removeChild(element.getElementsByTagName("precio").item(0));

            }

            File exitFile = new File("archivos" + File.separator + "libreriaResumen.xml");

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(exitFile));

        } catch (Exception e) {

            e.printStackTrace();
            
        }

    }
    
}
