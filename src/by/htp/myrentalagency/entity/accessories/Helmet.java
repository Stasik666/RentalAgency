package by.htp.myrentalagency.entity.accessories;

import by.htp.myrentalagency.entity.Category;

public class Helmet extends Accessories{
	
	private double size;
	private String color;
	
	public Helmet(String[] data){
		super(Category.valueOf(data[2]), data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]));
		size = Double.parseDouble(data[7]);
		color = data[8];
	}
	
	public Helmet(Category category,String title, double price, int year,int size,String color) {
		super(category,title, price, year);
		this.size = size;
		this.color = color;
		this.setItemName("Helmet");
	}

	public double getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() +", Size=" + size + ", Color=" + color;
	}
	
	
}
