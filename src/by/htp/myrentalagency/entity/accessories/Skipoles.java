package by.htp.myrentalagency.entity.accessories;

import by.htp.myrentalagency.entity.Category;

public class Skipoles extends Accessories{
	
	private double length;
	
	public Skipoles(String[] data){
		super(Category.valueOf(data[2]), data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]));
		length = Double.parseDouble(data[7]);
	}
	
	public Skipoles(Category category, String title, double price, int year,double length) {
		super(category, title, price, year);
		this.length = length;
		this.setItemName("Skipoles");
	}

	public double getLenght() {
		return length;
	}

	public void setLenght(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return super.toString() + ", Length=" + length;
	}
	
	
}
