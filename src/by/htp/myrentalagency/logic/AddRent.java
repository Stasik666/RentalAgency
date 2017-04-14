package by.htp.myrentalagency.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import by.htp.myrentalagency.entity.Product;
import by.htp.myrentalagency.entity.Rent;
import by.htp.myrentalagency.entity.Tenant;
import by.htp.myrentalagency.entity.accessories.Accessories;
import by.htp.myrentalagency.entity.equipment.Equipment;
import by.htp.myrentalagency.list.*;
import by.htp.myrentalagency.menu.ConsolMenu;

public final class AddRent {
	private RentList rentList;
	private TenantList tenant;
	
	private RentStation rentStation;
	private RentUnit rentUnit;
	
	public  AddRent(RentList rentList,TenantList tenant,RentStation rentStation,RentUnit rentUnit){
		this.rentList = rentList;
		this.tenant = tenant;
		this.rentStation = rentStation;
		this.rentUnit = rentUnit;
	}
	
	public RentUnit getRentUnit() {
		return rentUnit;
	}

	public void setRentUnit(RentUnit rentUnit) {
		this.rentUnit = rentUnit;
	}

	public RentList getRentList() {
		return rentList;
	}

	public TenantList getTenant() {
		return tenant;
	}

	public RentStation getRentStation() {
		return rentStation;
	}
	
	public void setRentList(RentList rentList) {
		this.rentList = rentList;
	}

	public void setTenant(TenantList tenant) {
		this.tenant = tenant;
	}

	public void setRentStation(RentStation rentStation) {
		this.rentStation = rentStation;
	}

	public void addNewRent(BufferedReader reader) throws IOException{ //General logic method
		Tenant newClient = null;
		Equipment newEquipment = null;
		Accessories[] accessories = null;
		int lease=0;
		Date currentDate = java.util.Calendar.getInstance().getTime();
		
		newClient = checkTenant(newClient,reader);  
		
		newEquipment = printAvalibleEquipment(newEquipment,reader);
		
		
		switch(newEquipment.getCategory()) {
	    case SKATES_BICYCLING: 
	    	accessories = getAccessories(newClient,"Gloves","Protection","Helmet");
	    	newClient.addItems(newEquipment);
			break;
		case SKATES: 
			accessories = getAccessories(newClient,"Gloves","Protection","Helmet");
			newClient.addItems(newEquipment);
			break;
		case BICYCLING: 
			accessories = getAccessories(newClient,"Gloves","Protection","Helmet");
			newClient.addItems(newEquipment);
			break;
		case SKIES:
			accessories = getAccessories(newClient,"GlovesWinter","Skipoles","Glasses");
			newClient.addItems(newEquipment);
			break;
		}
		
		lease = enterTimeOfRent(lease,reader);
		
		moveItem(newEquipment.getId());
		
		rentList.add(new Rent(newClient,newEquipment,accessories,currentDate,lease));
		
		ConsolMenu.consolMessage("Client:" + newClient.getName() + "\n" +  " Equipment: " + "\n" + newEquipment + "\n" + " Accessories: " + "\n" + Arrays.toString(accessories) + "\n" + " Date: " + currentDate +
				" Lease:" + lease);
		ConsolMenu.consolMessage("Complete");
	
	}
	
	private Tenant checkTenant(Tenant newClient,BufferedReader reader) throws IOException{
		ConsolMenu.consolMessage("Enter the name and surname of customer");
		String name = reader.readLine();
		int x = 0;
		for(Tenant client:tenant.getTenantList()){
			if(client!=null){
				if(client.getName().equals(name)){
					ConsolMenu.consolMessage("The customer was found in the database");
					int countNull = 0;
					for(Equipment item:client.getEquipment()){
						if(item==null){
							countNull++;
						}
					}
					if(countNull==0){
						ConsolMenu.consolMessage("Exceeded the limit on rentable items");
						ConsolMenu.launchMenu(this);
					}
					else{
						newClient = client;
						x=1;
						break;
					}
				}
			}
		}
		if(x==0){
			ConsolMenu.consolMessage("Adding client to the database" + "\n" + "Enter his date of birth");
			String dateBird = reader.readLine();
			ConsolMenu.consolMessage("Enter his address");
			String address = reader.readLine();
			newClient = new Tenant(name,dateBird,address);
			tenant.add(newClient);	
		}
		return newClient;
	}
	
	public Equipment printAvalibleEquipment(Equipment newEquipment,BufferedReader reader)throws IOException{
		ConsolMenu.consolMessage("The list of availible equipment");
		for(Product item:rentStation.getUnits()){
			if(item!=null)
				if(item.getItemType().equals("Equipment"))
				ConsolMenu.consolMessage(item.toString());
		}
		while(true)
			try{
				boolean x = false;
				ConsolMenu.consolMessage("enter the ID of the desired Equipment");
				int id = Integer.parseInt(reader.readLine());
				for(Product item:rentStation.getUnits()){
					if(item!=null){
						if(item.getItemType().equals("Equipment"))
							if(item.getId()==id){
								ConsolMenu.consolMessage(item.toString());
								newEquipment =(Equipment) item;
								x=true;
								break;
							}
						}
					}
				if(x!=true){
					ConsolMenu.consolMessage("The id was not found");
					continue;
				}
				break;
			}
			catch(NumberFormatException e){
				System.out.println("Invalid id");
			}
		return newEquipment;
	}
	
	public int enterTimeOfRent(int lease,BufferedReader reader){
		try{
			ConsolMenu.consolMessage("Enter the number of days of rent");
			lease = Integer.parseInt(reader.readLine());
		}
		catch(Exception e){
			ConsolMenu.consolMessage("Invalid number");
		}
		return lease;
	}
	
	private Accessories[] getAccessories(Tenant newClient,String a,String b,String c){
		
		Accessories first=null;
		Accessories second=null;
		Accessories third=null;
		for(Product item: rentStation.getUnits()){
			if(item!=null){
				if(item.getItemType().equals("Accessories"))
					if(item.getItemName().equals(a)){
					first =(Accessories)item;
					break;
				}		
			}
		}
		for(Product item:rentStation.getUnits()){
			if(item!=null){
				if(item.getItemType().equals("Accessories"))
					if(item.getItemName().equals(b)){
					second =(Accessories) item;
					break;
				}		
			}
		}
		for(Product item:rentStation.getUnits()){
			if(item!=null){
				if(item.getItemType().equals("Accessories"))
					if(item.getItemName().equals(c)){
					third =(Accessories) item;
					break;
				}		
			}
		}
		if(first==null||second==null||third==null){
			ConsolMenu.consolMessage("Not enough accessories");
			ConsolMenu.launchMenu(this);
		}
		else{
			ConsolMenu.consolMessage("The list of the accessories" + "\n" + "1)" + first + "\n" + "2)" + second + "\n" + "3)" + third);
			newClient.addAccessories(first);
			newClient.addAccessories(second);
			newClient.addAccessories(third);
			moveItem(first.getId());
			moveItem(second.getId());
			moveItem(third.getId());
		}
		Accessories[] accessories = new Accessories[3];
			accessories[0]=first;
			accessories[1]=second;
			accessories[2]=third;
			return accessories;
		}
	
	private void moveItem(int id)   { //moves the objects from the list of available items into the list rent
		for(Product item: rentStation.getUnits()){
			if(item!=null){
				if(item.getId()==id){
					rentStation.remove(id);
					rentUnit.add(item);
				}
			}	
		}	
	}
}
	

