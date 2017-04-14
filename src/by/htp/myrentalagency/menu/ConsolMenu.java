package by.htp.myrentalagency.menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import by.htp.myrentalagency.entity.Rent;
import by.htp.myrentalagency.logic.AddRent;

public class ConsolMenu {
	
	public ConsolMenu(AddRent addRent){
		launchMenu(addRent);
	}
	
	public static void consolMessage(String message){  //This method displays a message to the console
		System.out.println(message);
	}
	
	public static void launchMenu(AddRent addRent){	//This method invokes the console menu
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int x = 0;
		while(x==0){
			ConsolMenu.consolMessage("Please, enter the command number"+"\n"+"1)Add new rent"+"\n" + "2)Print the list of available items" + "\n" + 
			"3)Print out the list of items rented" + "\n" + "4)Print the list of the clients" + "\n" + "5)To print the list of existing deals" + "\n" +
			"6)Display to the console a report about the equipment that was hired for a certain period of time" + "\n" + "7)Exit the programm"+"\n");
			try{
				int y = Integer.parseInt(reader.readLine());
				if (y==1){
					addRent.addNewRent(reader);	
				}
				else	if(y==2){
					addRent.getRentStation().print();
				}
				else	if(y==3){
					addRent.getRentUnit().print();
				}
				else	if(y==4){
					addRent.getTenant().print();
				}
				else	if(y==5){
					addRent.getRentList().print();
				}
				else	if(y==6){
					try{
						ConsolMenu.consolMessage("enter the number of the past hours");
						int hour = Integer.parseInt(reader.readLine());
						for(Rent rent: addRent.getRentList().getUnits()){
							if(System.currentTimeMillis()-rent.getDate().getTime()<=hour){
								ConsolMenu.consolMessage(rent.toString());
							}
						}
					}
					catch(Exception e){
						ConsolMenu.consolMessage("Invalid data"+"\n");
						continue;
					}
				}
				else	if(y==7){
					ConsolMenu.consolMessage("Good bye");
					System.exit(0);
				}		
				else{
					ConsolMenu.consolMessage("Invalid number");
					continue;
				}
				 
			}
			catch(Exception e){
				ConsolMenu.consolMessage("Invalid number"+"\n");
				continue;
			}
		}
	}
}