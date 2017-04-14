package by.htp.myrentalagency.entity.equipment;

import by.htp.myrentalagency.entity.Category;
import by.htp.myrentalagency.entity.Product;

public abstract class Equipment extends Product{
	
	private double weight;
	private String color;
	
	
	
	public Equipment(Category category, String title, double price, int year,double weight,String color) {
		super(category,title,price,year);
		this.weight = weight;
		this.color=color;
		this.setItemType("Equipment");
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + " Weight=" + weight + ", Color=" + color;
	}
	
}

