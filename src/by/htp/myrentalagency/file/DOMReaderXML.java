package by.htp.myrentalagency.file;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.htp.myrentalagency.entity.Category;
import by.htp.myrentalagency.entity.Tenant;
import by.htp.myrentalagency.entity.accessories.Glasses;
import by.htp.myrentalagency.entity.accessories.Gloves;
import by.htp.myrentalagency.entity.accessories.GlovesWinter;
import by.htp.myrentalagency.entity.accessories.Helmet;
import by.htp.myrentalagency.entity.accessories.Protection;
import by.htp.myrentalagency.entity.accessories.Skipoles;
import by.htp.myrentalagency.entity.equipment.Bike;
import by.htp.myrentalagency.entity.equipment.Skate;
import by.htp.myrentalagency.entity.equipment.Skies;
import by.htp.myrentalagency.list.RentStation;
import by.htp.myrentalagency.list.TenantList;

public abstract class DOMReaderXML {
	
	public static void initTenant(TenantList list){
		 try {	
			 File inputFile = new File("resourse/dataxml/TenantXML.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         NodeList nList = doc.getElementsByTagName("tenant");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	 Element eElement = (Element) nNode;
	            	 list.add(new Tenant(eElement.getElementsByTagName("name").item(0).getTextContent(),
	            			 			 eElement.getElementsByTagName("dateBirth").item(0).getTextContent(),
	            			 			 eElement.getElementsByTagName("address").item(0).getTextContent()));
	             }
	         }
	     } 
		 catch (Exception e) {
	         e.printStackTrace();
	     }
	}
	
	public static void initProduct(RentStation rent){
		 try {	
			 
			 File inputFile = new File("resourse/dataxml/AvailableEquipmentXML.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         NodeList nList = doc.getElementsByTagName("bike");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	            	rent.add(new Bike(eElement.getElementsByTagName("title").item(0).getTextContent(),
	            					  Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
   			 			              Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()),
   			 			              Double.parseDouble(eElement.getElementsByTagName("weight").item(0).getTextContent()),
         			 			      eElement.getElementsByTagName("color").item(0).getTextContent(),
         			 			      eElement.getElementsByTagName("type").item(0).getTextContent()));    	
	            	
	             }
	         }
	         nList = doc.getElementsByTagName("skate");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	            	rent.add(new Skate(eElement.getElementsByTagName("title").item(0).getTextContent(),
	            					  Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
   			 			              Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()),
   			 			              Double.parseDouble(eElement.getElementsByTagName("weight").item(0).getTextContent()),
         			 			      eElement.getElementsByTagName("color").item(0).getTextContent(),
         			 			      Double.parseDouble(eElement.getElementsByTagName("length").item(0).getTextContent()))); 
	            	
	             }
	         }
	         nList = doc.getElementsByTagName("skies");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	            	rent.add(new Skies(eElement.getElementsByTagName("title").item(0).getTextContent(),
	            					  Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
   			 			              Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()),
   			 			              Double.parseDouble(eElement.getElementsByTagName("weight").item(0).getTextContent()),
         			 			      eElement.getElementsByTagName("color").item(0).getTextContent(),
         			 			      Double.parseDouble(eElement.getElementsByTagName("length").item(0).getTextContent()))); 
	            	
	             }
	         }
	         nList = doc.getElementsByTagName("gloves");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	            	rent.add(new Gloves(Category.valueOf(eElement.getElementsByTagName("category").item(0).getTextContent()),
	            						eElement.getElementsByTagName("title").item(0).getTextContent(),
	            						Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
	            						Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()),
	            						Double.parseDouble(eElement.getElementsByTagName("size").item(0).getTextContent()))); 
	            	
	             }
	         }
	         nList = doc.getElementsByTagName("glasses");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	            	rent.add(new Glasses(Category.valueOf(eElement.getElementsByTagName("category").item(0).getTextContent()),
	            						eElement.getElementsByTagName("title").item(0).getTextContent(),
	            						Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
	            						Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()),
	            						eElement.getElementsByTagName("type").item(0).getTextContent())); 
	            	
	             }
	         }
	         nList = doc.getElementsByTagName("gloveswinter");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	            	rent.add(new GlovesWinter(Category.valueOf(eElement.getElementsByTagName("category").item(0).getTextContent()),
	            						eElement.getElementsByTagName("title").item(0).getTextContent(),
	            						Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
	            						Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()),
	            						Double.parseDouble(eElement.getElementsByTagName("size").item(0).getTextContent()))); 
	            	
	             }
	         }
	         nList = doc.getElementsByTagName("helmet");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	            	rent.add(new Helmet(Category.valueOf(eElement.getElementsByTagName("category").item(0).getTextContent()),
	            						eElement.getElementsByTagName("title").item(0).getTextContent(),
	            						Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
	            						Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()),
	            						Double.parseDouble(eElement.getElementsByTagName("size").item(0).getTextContent()),
	            						eElement.getElementsByTagName("color").item(0).getTextContent())); 
	            	
	             }
	         }
	         nList = doc.getElementsByTagName("protection");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	            	rent.add(new Protection(Category.valueOf(eElement.getElementsByTagName("category").item(0).getTextContent()),
	            						eElement.getElementsByTagName("title").item(0).getTextContent(),
	            						Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
	            						Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()),
	            						Double.parseDouble(eElement.getElementsByTagName("size").item(0).getTextContent()))); 	            	
	             }
	         }
	         nList = doc.getElementsByTagName("skipoles");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	            	rent.add(new Skipoles(Category.valueOf(eElement.getElementsByTagName("category").item(0).getTextContent()),
	            						eElement.getElementsByTagName("title").item(0).getTextContent(),
	            						Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
	            						Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent()),
	            						Double.parseDouble(eElement.getElementsByTagName("length").item(0).getTextContent()))); 	
	             } 
	         }
		 }
		 catch (Exception e) {
	         e.printStackTrace();
	     }
	}
	
	
}
