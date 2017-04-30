package by.htp.myrentalagency.list;

import by.htp.myrentalagency.entity.Rent;
import by.htp.myrentalagency.menu.ConsolMenu;

public class RentList implements Lists{
	
	private Rent[] units;
	
	public RentList(){
		units = new Rent[10];
	}

	public Rent[] getUnits() {
		return units;
	}
	
	public void setUnits(Rent[] units) {
		this.units = units;
	}
	
	public void initRentFile(String path) {
	}	
	public void add(Rent newRent){
		int emptyCount=0;
		for(int x = 0;x<units.length;x++){
			if(units[x]==null)
				emptyCount++;
		}
		if(emptyCount>0){
			for(int i = 0; i<units.length;i++){
				if(units[i]==null){
					units[i]=newRent;
					break;	
				}
			}
		}
		else{
			Rent[] newArray = new Rent[units.length+1];
			for(int i = 0;i < units.length;i++){
				newArray[i] = units[i];
			}
			newArray[units.length] = newRent;
			units = newArray;
		}
	}
	
	public void remove(int id){
		for(int i = 0;i<units.length;i++){
			if(units[i]!=null){
				if(units[i].getId()==id){
					units[i]=null;
				}
			}
		}
	}
	
	public void print(){
		for(Rent x:units){
			if(x!=null)
				ConsolMenu.consolMessage(x.toString());
		}
		ConsolMenu.consolMessage("");
	}

}
