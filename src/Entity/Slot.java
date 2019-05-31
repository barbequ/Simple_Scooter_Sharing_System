package Entity;
/**
 * the entity class for slot
* @ClassName: Slot  
* @Description: 
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class Slot implements java.io.Serializable{
	private boolean empty;
	private Scooter scooter;
	private int id;
	private String station;
	public Slot(int id,boolean empty,Scooter scooter,String station) {
		this.setId(id);
		this.empty=empty;
		this.setScooter(scooter);
		this.station=station;
	}
	public boolean getEmpty() {
		return empty;
	}
	public String getStation() {
		return station;
	}
	public void setEmpty(boolean empty) {
		this.empty=empty;
	}
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id want to set id
	 */
	public void setId(int id) {
		this.id = id;
	}
	public void setStation(String station) {
		this.station=station;
	}
	/**
	 * @return scooter
	 */
	public Scooter getScooter() {
		return scooter;
	}
	/**
	 * @param scooter want to set scooter
	 */
	public void setScooter(Scooter scooter) {
		this.scooter = scooter;
	}
}
