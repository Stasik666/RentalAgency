package by.htp.myrentalagency.entity.accessories;

import by.htp.myrentalagency.entity.Category;

public class Helmet extends Accessories{
	
	private double size;
	private String color;
	
	public Helmet(String[] data){
		super(Category.valueOf(data[2]), data[4], Double.parseDouble(data[5]), Integer.parseInt(data[6]));
		size = Double.parseDouble(data[7]);
		color = data[8];
		setItemName(data[1]);
	}
	
	public Helmet(Category category,String title, double price, int year,double size,String color) {
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((color == null) ? 0 : color.hashCode());
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
		Helmet other = (Helmet) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() +", Size=" + size + ", Color=" + color;
	}
	
	
}
