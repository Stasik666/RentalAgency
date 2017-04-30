package by.htp.myrentalagency.list;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import by.htp.myrentalagency.entity.*;
import by.htp.myrentalagency.entity.equipment.*;
import by.htp.myrentalagency.file.WorkFile;
import by.htp.myrentalagency.entity.accessories.*;
import by.htp.myrentalagency.logic.Lists;
import by.htp.myrentalagency.menu.ConsolMenu;

public class RentStation implements Lists{

	private Product[] units;
	
	public RentStation() {  
		units = new Product[10];
	}

	public Product[] getUnits() {
		return units;
	}
	
	@Override
	public void initializeListFromFile(String path) {
		BufferedReader readFromFile = null;
		String line;
		try {
			readFromFile = new BufferedReader(new FileReader(path));
			while ((line = readFromFile.readLine()) != null) {
				String[] data = line.split(", ");
				add(createNewProduct(data));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (readFromFile != null)
				try {
					readFromFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
 
	}

	private Product createNewProduct(String[] data){
		Product newProduct = null;
		switch (data[1]){
		case "Glasses":
			newProduct =  new Glasses(data);
			break;
		case "Gloves":
			newProduct =  new Gloves(data);
			break;
		case "GlovesWinter":
			newProduct =  new GlovesWinter(data);
			break;
		case "Helmet":
			newProduct =  new Helmet(data);
			break;
		case "Protection":
			newProduct =  new Protection(data);
			break;
		case "Skipoles":
			newProduct =  new Skipoles(data);
			break;
		case "Bike":
			newProduct =  new Bike(data);
			break;
		case "Skies":
			newProduct =  new Skies(data);
			break;
		case "Skate":
			newProduct =  new Skate(data);
			break;
			
		}
		return newProduct;
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
