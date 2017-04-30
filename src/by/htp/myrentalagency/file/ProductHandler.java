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
	private StringBuilder text;
	private Category category;
	private String title;
	private Double price;
	private int year;
	private double weight;
	private String color;
	private String type;
	private double size;
	private double length;
	
	public List<Product> getProductList() {
		return productList;
	}

	public void startDocument() throws SAXException {
		ConsolMenu.consolMessage("Parsing the list of equipments started.");		
	}

	public void endDocument() throws SAXException {
		ConsolMenu.consolMessage("Parsing ended.");
	}

	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {
		text = new StringBuilder();
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName)throws SAXException {
		TagName tagName = TagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch(tagName){
			case CATEGORY:
				category = (Category.valueOf(text.toString()));
				break;
			case TITLE:
				title = text.toString();
				break;
			case PRICE:
				price = (Double.parseDouble(text.toString()));
				break;
			case YEAR:
				year = Integer.parseInt(text.toString());
				break;
			case WEIGHT:
				weight = Double.parseDouble(text.toString());
				break;
			case COLOR:
				color = text.toString();
				break;
			case TYPE:
				type = text.toString();
				break;
			case SIZE:
				size = Double.parseDouble(text.toString());
				break;
			case LENGTH:
				length = Double.parseDouble(text.toString());
				break;
			case BIKE:
				productList.add(new Bike(title,price,year,weight,color,type));
				break;
			case SKATE:
				productList.add(new Skate(title,price,year,weight,color,length));
				break;
			case SKIES:
				productList.add(new Skies(title,price,year,weight,color,length));
				break;
			case GLASSES:
				productList.add(new Glasses(category,title,price,year,type));
				break;
			case GLOVES:
				productList.add(new Gloves(category,title,price,year,size));
				break;
			case GLOVESWINTER:
				productList.add(new GlovesWinter(category,title,price,year,size));
				break;
			case HELMET:
				productList.add(new Helmet(category,title,price,year,size,color));
				break;
			case PROTECTION:
				productList.add(new Protection(category,title,price,year,size));
				break;
			case SKIPOLES:
				productList.add(new Skipoles(category,title,price,year,length));
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
