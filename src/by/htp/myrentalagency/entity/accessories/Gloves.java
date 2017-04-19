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
	public String toString() {
		return super.toString() +", Size = " + size;
	} 
	
}
