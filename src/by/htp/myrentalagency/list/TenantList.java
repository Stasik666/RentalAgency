package by.htp.myrentalagency.list;

import by.htp.myrentalagency.entity.Tenant;
import by.htp.myrentalagency.menu.ConsolMenu;

public class TenantList implements Lists{
	
	private Tenant[] tenantList; //The list of the clients;
	
	public TenantList() {
		tenantList = new Tenant[10];
	}

	public Tenant[] getTenantList() {
		return tenantList;
	}
	
	
	public void setTenantList(Tenant[] tenantList) {
		this.tenantList = tenantList;
	}
	
	public  void add(Tenant newTenant) {  
		int emptyCount=0;
		for(int x = 0;x<this.tenantList.length;x++){
			if(this.tenantList[x]==null)
				emptyCount++;
		}
		if(emptyCount>0){
			for(int i = 0; i<this.tenantList.length;i++){
				if(this.tenantList[i]==null){
					this.tenantList[i]=newTenant;
					break;	
				}
			}
		}
		else{
			Tenant[] newArray = new Tenant[tenantList.length+1];
			for(int i = 0;i < tenantList.length;i++){
				newArray[i] = tenantList[i];
			}
			newArray[tenantList.length] = newTenant;
			tenantList = newArray;
		}
	}
	
	public void remove(int id){
		for(int i = 0;i<tenantList.length;i++){
			if(tenantList[i]!=null){
				if(tenantList[i].getId()==id){
					tenantList[i]=null;
				}
			}
		}
	}
	
	@Override
	public void print(){
		for(Tenant x:tenantList){
			if(x!=null)
				ConsolMenu.consolMessage(x.toString());
		}
		ConsolMenu.consolMessage("");
	}
}
