package by.htp.myrentalagency.entity.accessories;

import by.htp.myrentalagency.entity.Category;

public class Skipoles extends Accessories{
	
	private double length;
	
	public Skipoles(String[] data){
		super(Category.valueOf(data[2]), data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]));
		length = Double.parseDouble(data[7]);
		setItemName(data[1]);
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
		Skipoles other = (Skipoles) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", Length=" + length;
	}
	
	
}
