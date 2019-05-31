package Entity;
import java.util.ArrayList;
import java.util.Date;
/**
 * 
* @ClassName: Customer  
* @Description: the entity class for customer
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class Customer extends User implements java.io.Serializable{
	private int fine;
	private int totaltime;
	private int unittime;
	private int weektime;
	private int weekborrow;
	private boolean borrow;
	private Date borrowtime;
	private Scooter scooter;
	/**
	 * 
	* Create a new object Customer.  
	*  
	* @param qmnumber
	* @param fullname
	* @param email
	 */
	public Customer(String qmnumber,String fullname,String email) {
		super(qmnumber,fullname,email);
		this.setFine(0);
		this.setTotaltime(0);
		this.setUnittime(0);
		this.setWeektime(0);
		this.setWeekborrow(0);
		this.setBorrow(true);
		this.setBorrowtime(new Date());
		this.scooter=null;
		
	}
	/**
	 * 
	 * @Discription user to get his report
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 25, 20192019
	 * @param record
	 * @return
	 * ArrayList<Record>
	 */
	public ArrayList<Record> getRecord(ArrayList<Record> record) {
		ArrayList<Record> n=new ArrayList<Record>();
		for(Record c:record) {
			if(c.getQmNumber().equals(this.getQmnumber())) n.add(c);
		}
		return n;
	}
	/**
	 * 
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Create May 25, 20192019
	 * @return
	 */
	public ArrayList<Record> getReport(ArrayList<Record> record){
		ArrayList<Record> n=new ArrayList<Record>();
		Date now=new Date();
		for(Record c:record) {
			if(c.getQmNumber().equals(this.getQmnumber())) 
				if(now.getDay()-c.getDate().getDay()<=7) n.add(c);
		}
		return n;
	}
	public String toString() {
		return super.toString()+"total time: "+getTotaltime()+"\n"+"unit time: "+getUnittime()+"\n"+"borrow: "+isBorrow()+"\n"
	+"\n";
	}
	public String toHtmlString() {
		return super.toHtmlString()+"<td align=\"center\">"+getTotaltime()+"</td><td align=\"center\">"+getUnittime()+"</td><td align=\"center\">"+isBorrow()+"</td>"
	+"<td align=\"center\">"+fine+"</td><td align=\"center\">"+weektime+"</td><td align=\"center\">"+weekborrow+"</td>"+"</tr></html>";
	}
	public static String toHtmlTitle() {
		return User.toHtmlTitle()+"<td align=\"center\">Total time</td><td align=\"center\">Unit time</td><td align=\"center\">Borrow</td><td align=\"center\">Fine</td><td align=\"center\">Week time</td><td align=\"center\">Borrow time</td></tr></html>";		
	}
	/**
	 * @return borrowtime
	 */
	public Date getBorrowtime() {
		return borrowtime;
	}
	/**
	 * @param borrowtime want to set borrowtime
	 */
	public void setBorrowtime(Date borrowtime) {
		this.borrowtime = borrowtime;
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
	/** 
	 * @return fine
	 */
	public int getFine() {
		return fine;
	}
	/**
	 * @param fine want to set fine
	 */
	public void setFine(int fine) {
		this.fine = fine;
	}
	/**
	 * @return totaltime
	 */
	public int getTotaltime() {
		return totaltime;
	}
	/**
	 * @param totaltime want to set totaltime
	 */
	public void setTotaltime(int totaltime) {
		this.totaltime = totaltime;
	}
	/**
	 * @return unittime
	 */
	public int getUnittime() {
		return unittime;
	}
	/**
	 * @param unittime want to set unittime
	 */
	public void setUnittime(int unittime) {
		this.unittime = unittime;
	}
	/**
	 * @return weektime
	 */
	public int getWeektime() {
		return weektime;
	}
	/**
	 * @param weektime want to set weektime
	 */
	public void setWeektime(int weektime) {
		this.weektime = weektime;
	}
	/**
	 * @return weekborrow
	 */
	public int getWeekborrow() {
		return weekborrow;
	}
	/**
	 * @param weekborrow want to set weekborrow
	 */
	public void setWeekborrow(int weekborrow) {
		this.weekborrow = weekborrow;
	}
	/**
	 * @return borrow
	 */
	public boolean isBorrow() {
		return borrow;
	}
	/**
	 * @return borrow
	 */

	public boolean getBorrow() {
		return borrow;
	}
	/**
	 * @param borrow want to set borrow
	 */
	public void setBorrow(boolean borrow) {
		this.borrow = borrow;
	}
}
