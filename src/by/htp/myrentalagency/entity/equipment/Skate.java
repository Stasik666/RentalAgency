package by.htp.myrentalagency.entity.equipment;

import by.htp.myrentalagency.entity.Category;


public class Skate extends Equipment{

	private double length;
	
	public Skate(String[] data){
		
		super(Category.BICYCLING,data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]),
				Double.parseDouble(data[7]),data[8]);
		length = Double.parseDouble(data[9]);
		setItemName(data[1]);
	}

	public Skate(String title, double price, int year,
			double weight, String color, double length) {
		super(Category.SKATES, title, price, year, weight,color);
		this.length = length;
		this.setItemName("Skate");
	}
	
	public double getLength() {
		return length;
	}
	public void setLenght(double length) {
		this.length = length;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(length);
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
		Skate other = (Skate) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", Length=" + length;
	}

}
	
