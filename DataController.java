import org.json.JSONArray;
import org.w3c.dom.Document;

class DataController
{
	public static Document getXMLDoc()
	{
		Parser parser = new Parser();
		Document doc = parser.getXML(GetData.getAlbums());
		return doc;
	}
	
	public static JSONArray getJSON()
	{
		Parser parser = new Parser();
		JSONArray jsar = parser.getJSON(GetData.getAlbums());
		return jsar;
	}
}