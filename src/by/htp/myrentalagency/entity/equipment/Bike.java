package by.htp.myrentalagency.entity.equipment;

import by.htp.myrentalagency.entity.Category;


public class Bike extends Equipment{
	
	private String type;
	
	public Bike(String[] data){
		
		super(Category.BICYCLING,data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]),
				Double.parseDouble(data[7]),data[8]);
		type = data[7];
		setItemName(data[1]);
	}
	
	public Bike(String title, double price, int year,
			double weight, String color, String type) {
		super(Category.BICYCLING, title, price, year,weight,color);
		this.type = type;
		this.setItemName("Bike");
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



    @Override
	public String toString() {
		return  super.toString() + ", Type=" + type;
	}
	
}
