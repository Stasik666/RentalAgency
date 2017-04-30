package by.htp.myrentalagency.entity;

import java.util.Arrays;
import java.util.Date;

import by.htp.myrentalagency.entity.accessories.Accessories;
import by.htp.myrentalagency.entity.equipment.Equipment;

public class Rent {
	private static int itemCount;
	
	private final int id;
	
	private Tenant tenant;
	private Equipment equipment;
	private Accessories[] accesories;
	private int lease;
	private Date date;
	
	public Rent(Tenant tenant,Equipment equipment,Accessories[] accessories,Date date,int lease){
		this.tenant = tenant;
		this.equipment = equipment;
		this.accesories = accessories;
		this.lease = lease;
		this.date = date;
		id =++itemCount;
		
	}
	
	public int getId() {
		return id;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Accessories[] getAccesories() {
		return accesories;
	}

	public void setAccesories(Accessories[] accesories) {
		this.accesories = accesories;
	}

	public int getLease() {
		return lease;
	}

	public void setLease(int lease) {
		this.lease = lease;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Rent" + " " + id + " tenant=" + tenant.getName() + " dateBirth= " + tenant.getDateBirth() + " Address= " + tenant.getAddress() + "\n" + 
	", equipment=" + equipment + "\n" + ", accesories="
				+ Arrays.toString(accesories) + "\n" + ", Date=" + date+ ", lease=" + lease;
	}
	
}
