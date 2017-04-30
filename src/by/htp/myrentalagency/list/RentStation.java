package by.htp.myrentalagency.list;

import by.htp.myrentalagency.entity.*;
import by.htp.myrentalagency.menu.ConsolMenu;

public class RentStation implements Lists{

	private Product[] units;
	
	public RentStation() {  
		units = new Product[10];
	}

	public Product[] getUnits() {
		return units;
	}
	
	public void add(Product units) {
		
		int emptyCount=0;
		for(int x = 0;x<this.units.length;x++){
			if(this.units[x]==null)
				emptyCount++;
		}
		if(emptyCount>0){
			for(int i = 0; i<this.units.length;i++){
				if(this.units[i]==null){
					this.units[i]=units;
					break;	
				}
			}
		}
		else{
			Product[] newArray = new Product[this.units.length+1];
			for(int i = 0;i < this.units.length;i++){
				newArray[i] = this.units[i];
			}
			newArray[this.units.length] = units;
			this.units = newArray;
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
	

	@Override
	public void print(){
		for(Product x:units){
			if(x!=null)
				ConsolMenu.consolMessage(x.toString());
		}
		ConsolMenu.consolMessage("");
	}
}
