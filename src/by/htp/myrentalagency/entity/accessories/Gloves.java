package by.htp.myrentalagency.entity.accessories;

import by.htp.myrentalagency.entity.Category;

public class Gloves extends Accessories{
	
	private double size;
	
	public Gloves(String[] data){
		super(Category.valueOf(data[2]), data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]));
		size = Double.parseDouble(data[7]);
		setItemName(data[1]);
	}
	
	public Gloves(Category category,String title,double price,int year,double size){
		super(category,title,price,year);
		this.size = size;
		this.setItemName("Gloves");
	}

	public double getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(size);
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
		Gloves other = (Gloves) obj;
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() +", Size = " + size;
	} 
	
}
