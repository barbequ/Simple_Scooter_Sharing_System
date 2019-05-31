package Entity;
import java.util.Date;
import java.text.*;
/**
 * 
* @ClassName: Record  
* @Description: the entity class for customer record
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class Record implements java.io.Serializable{
	private Date date;
	private String operation;//1:borrow 2:return
	private int fine;
	private String qmNumber;
	private String station;
	private int slot;
	public Record(String qmNumber,int state,int fine) {
		date=new Date();
		this.qmNumber=qmNumber;
		if(state==1) {
			this.operation="borrow";
			fine=0;
		}else {
			this.operation="return";
			this.fine=fine;
		}
	}
	public Record(String qmNumber,int state) {
		date=new Date();
		this.qmNumber=qmNumber;
		this.fine=0;
		if(state==1) {
			this.operation="borrow";
		}else {
			this.operation="return";
		}
		
	}
	public Record(String qmNumber,String operation,String station,int slot,int fine) {
		this.qmNumber=qmNumber;
		date=new Date();
		this.operation=operation;
		this.fine=fine;
		this.station=station;
		this.slot=slot;
	}
	public String getQmNumber() {
		return qmNumber;
	}
	public int getFine() {
		return fine;
	}
	public Date getDate() {
		return date;
	}
	public String getOperation() {
		return operation;
	}
	public void setQmNumber(String qmNumber) {
		this.qmNumber=qmNumber;
	}
	public void setFine(int fine) {
		this.fine=fine;
	}
	public void setOperation(String operation) {
		this.operation=operation;
	}
	public void setDate(Date date) {
		this.date=date;
	}
	public String toString() {
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return "Date: "+ft.format(date)+"\t"+"QM Number: "+qmNumber+"\t"+"Operation: "+operation+"\t"+"station: "+station+"\tslot: "+slot+ "\tFine: "+fine+"\n";
	}
	public String toHtmlString() {
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return "<html><tr><td align=\"center\">"+ft.format(date)+"</td><td align=\"center\">"+qmNumber+"</td><td align=\"center\">"+operation+"</td><td align=\"center\">"+station+"</td><td align=\"center\">"+slot+ "</td><td align=\"center\">"+fine+"</td></tr></html>";
	}
	public static String toHtmltitle() {
		return "<html><tr><td align=\"center\">date"+"</td><td align=\"center\">QM number"+"</td><td align=\"center\">Operation"+"</td><td align=\"center\">Station"+"</td><td align=\"center\">Slot"+ "</td><td align=\"center\">Fine"+"</td></tr></html>";
	}
}
