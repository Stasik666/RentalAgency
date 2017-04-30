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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment other = (Equipment) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", Weight=" + weight + ", Color=" + color;
	}
	
}

