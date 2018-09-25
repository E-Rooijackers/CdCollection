import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class Parser
{
    public Document getXML(List<Album> albums)
    {
    	try {
            DocumentBuilderFactory dbFactory =
            DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            
            // root element
            Element rootElement = doc.createElement("albums");
            doc.appendChild(rootElement);
            
            for(int i = 0; i < albums.size(); i++)
            {
            	Element album = doc.createElement("album");
            	
            	Element name = doc.createElement("name");
            	name.setNodeValue(albums.get(i).name);
            	album.appendChild(name);
            	
            	Element artist = doc.createElement("artist");
            	name.setNodeValue(albums.get(i).artist);
            	album.appendChild(artist);
            	
            	Element genre = doc.createElement("genre");
            	name.setNodeValue(albums.get(i).genre);
            	album.appendChild(genre);
            	
            	Element year = doc.createElement("year");
            	year.setNodeValue("" + albums.get(i).year);
            	album.appendChild(year);
            	
            }
            
            
            
            rootElement.appendChild(album);

            // setting attribute to element
            Attr attr = doc.createAttribute("company");
            attr.setValue("Ferrari");
            supercar.setAttributeNode(attr);

            // carname element
            Element carname = doc.createElement("carname");
            Attr attrType = doc.createAttribute("type");
            attrType.setValue("formula one");
            carname.setAttributeNode(attrType);
            carname.appendChild(doc.createTextNode("Ferrari 101"));
            supercar.appendChild(carname);

            Element carname1 = doc.createElement("carname");
            Attr attrType1 = doc.createAttribute("type");
            attrType1.setValue("sports");
            carname1.setAttributeNode(attrType1);
            carname1.appendChild(doc.createTextNode("Ferrari 202"));
            supercar.appendChild(carname1);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\cars.xml"));
            transformer.transform(source, result);
            
            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
         } catch (Exception e) {
            e.printStackTrace();
         }
    }
    
    public List<Album> getData(Document doc)
    {
        List<Album> albums = new ArrayList<Album>();
        
    	try
	    {
	        doc.getDocumentElement().normalize();
            doc.getDocumentElement();
            
            XPath xPath = XPathFactory.newInstance().newXPath();
	    
            XPathExpression exp = xPath.compile("//Albums/Album");
            
            NodeList nlAlbums = (NodeList)exp.evaluate(doc, XPathConstants.NODESET);
            for(int i = 0; i < nlAlbums.getLength(); i++)
            {
            	NodeList nlAlbum = nlAlbums.item(i).getChildNodes();
            	for(int n = 0; n < nlAlbum.getLength(); n++)
            	{
            		Album album = new Album();
            		switch (nlAlbum.item(n).getNodeName().toLowerCase())
            		{
            			case "name":
            				album.name = nlAlbum.item(n).getNodeValue();
            				break;
            			case "artist":
            				album.artist = nlAlbum.item(n).getNodeValue();
            				break;
            			case "genre":
            				album.genre = nlAlbum.item(n).getNodeValue();
            				break;
            			case "year":
            				album.year = Integer.parseInt(nlAlbum.item(n).getNodeValue());
            				break;
            			default:
            				System.out.println("XML document not as expected in Parser.getXmlData()");
            				break;
            		}
            		
            		albums.add(album);
            	}
            }
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
		
		return albums;
    }
}