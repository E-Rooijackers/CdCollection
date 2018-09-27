import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

class CdCollector
{
    public static DataController dataController;
    public static GraphicalUserInterface gui;
    
    public static void main(String[] args) throws TransformerException
    {
        dataController = new DataController();
        gui = new GraphicalUserInterface();
        
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        
        gui.show();
        if(args.length > 0)
        {
        	if(args[0].equals("xml"))
        	{
        		DOMSource source = new DOMSource(dataController.getXMLDoc());
        		StreamResult consoleResult = new StreamResult(System.out);
                transformer.transform(source, consoleResult);
        	}
        	else if(args[0].equals("json"))
        	{
        		System.out.println(dataController.getJSON().toString());
        	}
        }
        
        //StreamResult result = new StreamResult(new File("C:\\albums\\albums.xml"));
        //transformer.transform(source, result);
        
        // Output to console for testing
        
        
        
    }
}