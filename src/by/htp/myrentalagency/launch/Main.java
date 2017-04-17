package by.htp.myrentalagency.launch;

import by.htp.myrentalagency.list.RentList;
import by.htp.myrentalagency.list.RentStation;
import by.htp.myrentalagency.list.RentUnit;
import by.htp.myrentalagency.list.TenantList;
import by.htp.myrentalagency.logic.AddRent;
import by.htp.myrentalagency.menu.ConsolMenu;

public class Main {

	public static void main(String[] args){
		RentStation rent = new RentStation();
		TenantList tenant = new TenantList(); // The list of the client
		RentList rentList = new RentList();
		RentUnit rentUnit = new RentUnit();
		AddRent addRent = new AddRent(rentList,tenant,rent,rentUnit);
		
		String availableEquipment = "src/data/AvailableEquipment";
		String clientData = "src/data/ClientData";
		
		tenant.initializeListFromFile(clientData);
		rent.initializeListFromFile(availableEquipment);
		ConsolMenu menu = new ConsolMenu(addRent);
		
	}
	
	
		

		/*rent.add(new Bike("Super1000",1000.0,2014,5.2,"green","mountain"));
		rent.add(new Skies("SimbleSkies",200,2010,1.2,"red",2.4));
		rent.add(new Skate("BackToTheFuture",150,2117,1.5,"blue",0.8));
		rent.add(new Bike("Super1000",1000.0,2014,5.2,"green","mountain"));
		rent.add(new Skies("SimbleSkies",200,2010,1.2,"red",2.4));
		
		tenant.add(new Tenant("Lenin Vladimir","22.04.1870","Mavzoley"));
		tenant.add(new Tenant("Dart Vaider","23.08.2560","Star of Death"));
		
		rent.add(new Gloves(Category.SKATES_BICYCLING,"Defender",30.50,2017,23));
		rent.add(new Protection(Category.SKATES_BICYCLING,"Degender",45.30,2017,14.5));
		rent.add(new Helmet(Category.SKATES_BICYCLING,"Defender",60.2,2017,6,"Green"));
		rent.add(new Gloves(Category.SKATES_BICYCLING,"Defender",30.50,2017,22));
		rent.add(new Protection(Category.SKATES_BICYCLING,"Degender",45.30,2017,14.5));
		rent.add(new Helmet(Category.SKATES_BICYCLING,"Defender",60.2,2017,5,"Blue"));
		rent.add(new Gloves(Category.SKATES_BICYCLING,"Defender",30.50,2017,24));
		rent.add(new Protection(Category.SKATES_BICYCLING,"Degender",45.30,2017,14.5));
		rent.add(new Helmet(Category.SKATES_BICYCLING,"Defender",60.2,2017,4,"red"));
		rent.add(new GlovesWinter(Category.SKIES,"Defender",42.4,2017,23));
		rent.add(new Skipoles(Category.SKIES,"Oscar",40.5,2017,1.5));
		rent.add(new Glasses(Category.SKIES,"Oscar",20.3,2017,"Mask"));
		rent.add(new GlovesWinter(Category.SKIES,"Defender",42.4,2017,22));
		rent.add(new Skipoles(Category.SKIES,"Oscar",38.5,2017,1.4));
		rent.add(new Glasses(Category.SKIES,"Oscar",15.6,2017,"Open"));
		
		//rent.print();
		//tenant.print();
		
		
		*/
	}

