package control;
import java.util.ArrayList;

import Entity.Scooter;
/**
 * 
* @ClassName: ScooterControl  
* @Description: the control class for scooter
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class ScooterControl implements java.io.Serializable{
	
	public static ArrayList<Scooter> getScooter(String path,String station) {
		ArrayList<Scooter> scooter=FileControl.<Scooter>ReadFile(path);
		ArrayList<Scooter> belong=new ArrayList<Scooter>();
		for(Scooter s:scooter) {
			if(s.getStation().equals(station)&&s.getBorrow()==false) belong.add(s);
		}
		return belong;
	}
	public static ArrayList<Scooter> addScooter(ArrayList<Scooter> s,Scooter scooter){
		s.add(scooter);
		return s;
	}
	public static void removeScooter(ArrayList<Scooter> s,Scooter scooter){
		s.remove(s);
	}

}
