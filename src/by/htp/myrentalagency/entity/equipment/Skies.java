package by.htp.myrentalagency.entity.equipment;

import by.htp.myrentalagency.entity.Category;


public class Skies extends Equipment{
	
	private double length;
	
	public Skies(String[] data){
		
		super(Category.BICYCLING,data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]),
				Double.parseDouble(data[7]),data[8]);
		length = Double.parseDouble(data[9]);
		setItemName(data[2]);
	}
	
	public Skies(String title, double price, int year,
			double weight, String color, double lenght) {
		super(Category.SKIES, title, price, year,weight,color);			
		this.length = lenght;
		this.setItemName("Skies");
	}
	
	public double getLenght() {
		return length;
	}
	public void setLenght(double lenght) {
		this.length = lenght;
	}

	@Override
	public String toString() {
		return super.toString() + ", Length=" + length;
	}
	
}
