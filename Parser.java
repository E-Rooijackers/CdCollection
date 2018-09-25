import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class Parser
{
    public Document getXmlDoc(List<Album> albums)
    {
        return albums;
    }
    
    public List<Album> getXmlData(Document doc)
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
            				album.year = nlAlbum.item(n).getNodeValue();
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