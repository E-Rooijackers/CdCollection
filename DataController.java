import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class DataController
{
	public static Document getXMLDoc()
	{
		Parser parser = new Parser();
		Document doc = parser.getXML(GetData.getAlbums());
		return doc;
	}
}