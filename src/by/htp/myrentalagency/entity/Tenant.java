package by.htp.myrentalagency.entity;

import java.util.Arrays;

import by.htp.myrentalagency.entity.accessories.Accessories;
import by.htp.myrentalagency.entity.equipment.Equipment;
import by.htp.myrentalagency.menu.ConsolMenu;

public class Tenant {

	private static int tenantCount; 
	
	private final int id;
	private String name;
	private String dateBirth;
	private String address;
	private int numberOfItem = 3;
	private Equipment[] equipment;
	private Accessories[] accessories;
	
	public Tenant(String name, String dateBirth, String address) {
		id=++tenantCount;
		this.name = name;
		this.dateBirth = dateBirth;
		this.address = address;
		equipment = new Equipment[numberOfItem];
		accessories = new Accessories[10];
	}
	public Tenant(String[] dataTenant){
		id=++tenantCount;
		name = dataTenant[1] ;
		dateBirth = dataTenant[2];
		address = dataTenant[3];
	
		
	}
	
	public void addAccessories(Accessories item){  
		int emptyCount=0;
		for(int x = 0;x<accessories.length;x++){
			if(accessories[x]==null)
				emptyCount++;
		}
		if(emptyCount>0){
			for(int i = 0; i<accessories.length;i++){
				if(accessories[i]==null){
					accessories[i]=item;
					break;	
				}
			}
		}
		else{
			Accessories[] newArray = new Accessories[accessories.length+1];
			for(int i = 0;i < accessories.length;i++){
				newArray[i] = accessories[i];
			}
			newArray[accessories.length] = item;
			accessories = newArray;
		}
	}
	
	public void addItems(Equipment items){
		int emptyCount=0;
		for(int x = 0;x<equipment.length;x++){
			if(equipment[x]==null)
				emptyCount++;
		}
		if(emptyCount>0){
			for(int i = 0; i<equipment.length;i++){
				if(equipment[i]==null){
					equipment[i]=items;
					break;	
				}
			}
		}
		else{
			ConsolMenu.consolMessage("Exceeded the limit on rentable items");
			
		}
	}
	
	public Equipment[] getEquipment() {
		return equipment;
	}

	public Accessories[] getAccessories() {
		return accessories;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Tenant id=" + id + ", name=" + name + ", dateBirth=" + dateBirth + ", address=" + address + "\n" + ", Rented items: "
	+ Arrays.toString(equipment) + "\n" + ", Accessories: " + Arrays.toString(accessories);
	}	
	
}
