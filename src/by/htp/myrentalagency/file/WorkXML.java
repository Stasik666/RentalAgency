package by.htp.myrentalagency.file;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import by.htp.myrentalagency.entity.Tenant;
import by.htp.myrentalagency.list.TenantList;

public class WorkXML {
	
	public static void initializationTenantXML(TenantList list){
		 try {	
	         File inputFile = new File("resourse/TenantXML.xml");
	         DocumentBuilderFactory dbFactory 
	            = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         System.out.println("Root element :" 
	            + doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName("tenant");
	         System.out.println("----------------------------");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            
	            System.out.println("\nCurrent Element :" 
	               + nNode.getNodeName());
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               list.add(new Tenant(eElement.getElementsByTagName("name").item(0).getTextContent(),
	            		   eElement.getElementsByTagName("dateBirth").item(0).getTextContent(),
	            		   eElement.getElementsByTagName("address").item(0).getTextContent()));
	               System.out.println("Id : "  + eElement.getElementsByTagName("id").item(0).getTextContent());
	               System.out.println("Name : " 
	               + eElement
	                  .getElementsByTagName("name")
	                  .item(0)
	                  .getTextContent());
	               System.out.println("DateBirth : " 
	               + eElement
	                  .getElementsByTagName("dateBirth")
	                  .item(0)
	                  .getTextContent());
	               System.out.println("Address : " 
	               + eElement
	                  .getElementsByTagName("address")
	                  .item(0)
	                  .getTextContent());
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
}
