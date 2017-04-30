package by.htp.myrentalagency.file;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.htp.myrentalagency.entity.*;
import by.htp.myrentalagency.entity.accessories.*;
import by.htp.myrentalagency.entity.equipment.*;
import by.htp.myrentalagency.menu.ConsolMenu;

public class ProductHandler extends DefaultHandler{
	private List<Product> productList = new ArrayList<Product>();
	private Product product;
	private StringBuilder text;
	
	public List<Product> getProductList() {
		return productList;
	}

	public void startDocument() throws SAXException {
		ConsolMenu.consolMessage("Parsing started.");
	}

	public void endDocument() throws SAXException {
		ConsolMenu.consolMessage("Parsing ended.");
	}

	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {
		text = new StringBuilder();
		TagName tagName = TagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch(tagName){
		case BIKE:
			product = new Bike();
			break;
		case SKATE:
			product = new Skate();
			break;
		case SKIES:
			product = new Skies();
			break;
		case GLASSES:
			product = new Glasses();
			break;
		case GLOVES:
			product = new Gloves();
			break;
		case GLOVESWINTER:
			product = new GlovesWinter();
			break;
		case HELMET:
			product = new Helmet();
			break;
		case PROTECTION:
			product = new Protection();;
			break;
		case SKIPOLES:
			product = new Skipoles(); ;
			break;					
		default:
			break;
		}	
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName)throws SAXException {
		TagName tagName = TagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch(tagName){
			case CATEGORY:
				product.setCategory(Category.valueOf(text.toString()));
				break;
			case TITLE:
				product.setTitle(text.toString());
				break;
			case PRICE:
				product.setPrice(Double.parseDouble(text.toString()));
				break;
			case YEAR:
				product.setPrice(Integer.parseInt(text.toString()));
				break;
			case SIZE:
				
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
