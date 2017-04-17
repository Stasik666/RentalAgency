package by.htp.myrentalagency.file;


import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

public class WorkFile {

	public static void writeToFile(String fileName, Object[] list) {
	    File file = new File(fileName);
	 
	    try {
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	        	for(Object item: list){
	        		 out.print(item);
	        	}
	        } finally {
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
			
}
