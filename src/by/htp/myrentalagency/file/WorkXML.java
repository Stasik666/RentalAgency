package by.htp.myrentalagency.file;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.htp.myrentalagency.entity.Tenant;
import by.htp.myrentalagency.list.RentStation;
import by.htp.myrentalagency.list.TenantList;

public class WorkXML {
	
	public static void initializationTenantXML(TenantList list){
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
	
	public static void initializationProductXML(RentStation rent){
		 try {	
			 File inputFile = new File("resourse/dataxml/AvailableEquipmentXML.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         NodeList nList = doc.getElementsByTagName("product");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	        	 Node nNode = nList.item(temp);
	             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	 Element eElement = (Element) nNode;
	            	
	             }
	         }
	     } 
		 catch (Exception e) {
	         e.printStackTrace();
	     }
	}
	
	
}
