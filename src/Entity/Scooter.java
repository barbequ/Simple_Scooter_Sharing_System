package Entity;
import java.io.*;
/**
 * 
* @ClassName: Scooter  
* @Description: the entity class for scooter
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class Scooter implements java.io.Serializable{
	private static int id=0;
	private boolean good;
	private String station;
	private int slot;
	private boolean borrow;
	public Scooter(String station,int slot) {
		id++;
		this.good=true;
		this.station=station;
		this.slot=slot;
		this.borrow=false;
/*		try {
			FileWriter fi=new FileWriter("./file/record.txt");
			BufferedWriter writer=new BufferedWriter(fi);
			writer.write(""+id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	*/	
	}
	public static int getId() {
		return id;
	}
	public boolean getGood() {
		return good;
	}
	public String getStation() {
		return station;
	}
	public int getSlot() {
		return slot;
	}
	public boolean getBorrow() {
		return borrow;
	}
	public static void setId(int value) {
		id=value;
	}
	public void setGood(boolean good) {
		this.good=good;
	}
	public void setStation(String station) {
		this.station=station;
	}
	public void setSlot(int slot) {
		this.slot=slot;
	}
	public void setBorrow(boolean borrow) {
		this.borrow=borrow;
	}
	public boolean equals(Scooter s) {
		if(s.getId()==this.id) return true;
		return false;
	}
	public String toString() {
		return "id :"+id+"\tGood: "+good+"\tStation: "+station+"\tSlot:"+slot+"\tborrow: "+borrow+"\n";
	}
	public static String toHtmlTitle() {
		return "<html><tr><td align=\"center\">Id</td><td align=\"center\">Good</td><td align=\"center\">Station</td><td align=\"center\">Slot</td><td align=\"center\">Borrow</td></tr></html>";
	}
	public String toHtmlString() {
		return "<html><tr><td align=\"center\">"+id+"</td><td align=\"center\">"+good+"</td><td align=\"center\">"+station+"</td><td align=\"center\">"+slot+"</td><td align=\"center\">"+borrow+"</td></tr></html>";
	}

}
