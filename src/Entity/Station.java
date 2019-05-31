package Entity;
import java.util.ArrayList;
/**
 * 
* @ClassName: Station  
* @Description: the entity class for station
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class Station implements java.io.Serializable{
	private String name;
	private ArrayList<Scooter> scooter;
	private ArrayList<Slot> empslot;
	private ArrayList<Slot> avaslot;
	private ArrayList<Slot> badslot;
	private int empty;
	private int available;
	private int total;
	public Station(String name,int empty,int available,ArrayList<Scooter> scooter) {
		this.setName(name);
		this.setEmpty(empty);
		this.setAvailable(available);
		this.total=empty+available;
		this.scooter=scooter;
		empslot=new ArrayList<Slot>();
		avaslot=new ArrayList<Slot>();
		badslot=new ArrayList<Slot>();
		for(int i=0;i<empty;i++) {
//			Scooter sc=new Scooter(name,i);
			Slot s=new Slot(i,true,null,name);
			empslot.add(s);
		}
		for(int i=0;i<available;i++) {
			Scooter sc=new Scooter(name,i);
			Slot s=new Slot(i+empty,false,sc,name);
			avaslot.add(s);
			scooter.add(sc);
		}
	}
	
	public void modifyStation(int empty,int available) {
		if(badslot.size()>0) {
			for(int i=0;i<badslot.size();i++) {
				Slot s=badslot.get(i);
				Scooter sc=s.getScooter();
				s.setEmpty(false);
				sc.setGood(true);
				sc.setBorrow(false);
				avaslot.add(s);
				badslot.remove(s);
			}
		}
		for(int i=0;i<empslot.size();i++) {
//			System.out.println("EMPTY:"+empslot.size());
			empslot.remove(i);
		}
		for(int i=0;i<avaslot.size();i++) {
			Scooter sc=avaslot.get(i).getScooter();
			avaslot.remove(i);
			scooter.remove(sc);
		}
		if(empty==0&&available==0) return;
		ArrayList<Slot> empnew=new ArrayList<Slot>();
		ArrayList<Slot> avanew=new ArrayList<Slot>();
		for(int i=0;i<empty;i++) {
//			Scooter sc=new Scooter(name,i);
			Slot s=new Slot(i,true,null,name);
			empnew.add(s);
		}
		for(int i=0;i<available;i++) {
			Scooter sc=new Scooter(name,i);
			Slot s=new Slot(i+empty,false,sc,name);
			avanew.add(s);
			scooter.add(sc);
		}
		this.setAvaslot(avanew);
		this.setEmpslot(empnew);
		this.setAvailable(available);
		this.setEmpty(empty);
		this.total=available+empty;
	}
	public void repair() {
		if(badslot.size()>0) {
			for(int i=0;i<badslot.size();i++) {
				Slot s=badslot.get(i);
				Scooter sc=s.getScooter();
				s.setEmpty(false);
				sc.setGood(true);
				sc.setBorrow(false);
				avaslot.add(s);
				badslot.remove(s);
			}
			this.available=avaslot.size();
		}

	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name want to set name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return scooter
	 */
	public ArrayList<Scooter> getScooter() {
		return scooter;
	}

	/**
	 * @param scooter want to set scooter
	 */
	public void setScooter(ArrayList<Scooter> scooter) {
		this.scooter = scooter;
	}

	/**
	 * @return empslot
	 */
	public ArrayList<Slot> getEmpslot() {
		return empslot;
	}

	/**
	 * @param empslot want to set empslot
	 */
	public void setEmpslot(ArrayList<Slot> empslot) {
		this.empslot = empslot;
	}

	/**
	 * @return avaslot
	 */
	public ArrayList<Slot> getAvaslot() {
		return avaslot;
	}

	/**
	 * @param avaslot want to set avaslot
	 */
	public void setAvaslot(ArrayList<Slot> avaslot) {
		this.avaslot = avaslot;
	}

	/**
	 * @return badslot
	 */
	public ArrayList<Slot> getBadslot() {
		return badslot;
	}

	/**
	 * @param badslot want to set badslot
	 */
	public void setBadslot(ArrayList<Slot> badslot) {
		this.badslot = badslot;
	}
	public boolean equals(Station s) {
		if(s.getName().equals(this.getName())) return true;
		return false;
	}
	public String toString() {
		return "              "+name+"\t\t            "+getEmpty()+"\t\t        "+getAvailable()+"\n";
	}
	public String toHtmlString() {
		return "<html><tr align=\"justify\"><td align=\"justify\">"+name+"</td><td align=\"justify\">"+getEmpty()+"\t\t</td><td align=\"justify\">"+getAvailable()+"</td></tr></html>";
//		return "<html><tr align=\"justify\"><td align=\"left\">"+name+"</td><td align=\"center\">"+getEmpty()+"\t\t</td><td align=\"right\">"+getAvailable()+"</td></tr></html>";
	}
	public static String toHtmlTitle() {
		return "<html><tr><td align=\"center\">Name</td><td align=\"center\">Empty</td><td align=\"center\">Available</td></tr></html>";
	}
	/**
	 * @return empty
	 */
	public int getEmpty() {
		return empty;
	}

	/**
	 * @param empty want to set empty
	 */
	public void setEmpty(int empty) {
		this.empty = empty;
	}

	/**
	 * @return available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param available want to set available
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * @return total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total want to set total
	 */
	public void setTotal(int total) {
		this.total = total;
	}
}
