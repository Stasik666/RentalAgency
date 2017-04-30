package by.htp.myrentalagency.entity.equipment;

import by.htp.myrentalagency.entity.Category;


public class Skies extends Equipment{
	
	private double length;
	
	public Skies(String[] data){
		
		super(Category.BICYCLING,data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]),
				Double.parseDouble(data[7]),data[8]);
		length = Double.parseDouble(data[9]);
		setItemName(data[1]);
	}
	
	public Skies(String title, double price, int year,
			double weight, String color, double lenght) {
		super(Category.SKIES, title, price, year,weight,color);			
		this.length = lenght;
		this.setItemName("Skies");
	}
	
	public Skies() {
		super();
		this.setItemName("Skies");
	}

	public double getLenght() {
		return length;
	}
	public void setLenght(double lenght) {
		this.length = lenght;
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
		Skies other = (Skies) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", Length=" + length;
	}
	
}
