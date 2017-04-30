package by.htp.myrentalagency.file;
	
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.myrentalagency.entity.Tenant;
import by.htp.myrentalagency.menu.ConsolMenu;

public class TenantHandler extends DefaultHandler{
	
	private List<Tenant> tenantList = new ArrayList<Tenant>();
	private Tenant tenant;
	private StringBuilder text;
	
	public List<Tenant> getTenantList() {
		return tenantList;
	}

	public void startDocument() throws SAXException {
		ConsolMenu.consolMessage("Parsing the list of clients started.");
	}

	public void endDocument() throws SAXException {
		ConsolMenu.consolMessage("Parsing ended.");
	}

	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {
		text = new StringBuilder();
		if (qName.equals("tenant")){
			tenant = new Tenant();
		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName)throws SAXException {
		TagName tagName = TagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch(tagName){
			case NAME:
				tenant.setName(text.toString());
				break;
			case DATEBIRTH:
				tenant.setDateBirth(text.toString());
				break;
			case ADDRESS:
				tenant.setAddress(text.toString());
				break;
			case TENANT:
				tenantList.add(tenant);
				tenant = null;
				break;
			default:
				break;
		}	

	}

	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void error(SAXParseException exception) {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw (exception);
	}

}