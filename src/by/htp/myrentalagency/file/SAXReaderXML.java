package by.htp.myrentalagency.file;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.myrentalagency.entity.Product;
import by.htp.myrentalagency.entity.Tenant;
import by.htp.myrentalagency.list.RentStation;
import by.htp.myrentalagency.list.TenantList;

public abstract class SAXReaderXML {
		
	public static void initTenantXML(TenantList list) {
		
		XMLReader reader;
		try {
			reader = XMLReaderFactory.createXMLReader();
			TenantHandler handler = new TenantHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource("resourse/dataxml/TenantXML.xml"));
			List<Tenant> tenantList = handler.getTenantList();
			for (Tenant tenant : tenantList) {
				list.add(tenant);
			}
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initProductXML(RentStation list) {
		
		XMLReader reader;
		try {
			reader = XMLReaderFactory.createXMLReader();
			ProductHandler handler = new ProductHandler();
			reader.setContentHandler(handler);
			reader.parse(new InputSource("resourse/dataxml/AvailableEquipmentXML.xml"));
			List<Product> productList = handler.getProductList();
			for (Product product : productList) {
				list.add(product);
			}
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
