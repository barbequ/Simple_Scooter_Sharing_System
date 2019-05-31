package control;
/**  
* @Title: Control.java  
* @Package   
* @Description:   
* @author bby  
* @date May 12, 2019  
* @version V1.0  
*/

import java.util.ArrayList;
import java.util.Date;

import Entity.Admin;
import Entity.Customer;
import Entity.Record;
import Entity.Scooter;
import Entity.Slot;
import Entity.Station;

import java.io.*;
import java.util.regex.*;
/**  
* @ClassName: Control  
* @Description:the system's control class 
* @author Boyuan Bai  
* @date May 12, 2019  
*    
*/
public class Control implements java.io.Serializable{
	/**
	 * create a arraylist to store the customers
	 */
	private ArrayList<Customer> customer;
	private ArrayList<Scooter> scooter;
	private ArrayList<Station> station;
	private ArrayList<Record> record;
	private Admin admin;
	private String cuspath="D:\\Group_work\\customer.dat";
	private String scopath="D:\\Group_work\\scooter.dat";
	private String stapath="D:\\Group_work\\station.dat";
	private String recpath="D:\\Group_work\\record.dat";
	/**
	 * 
	* Create a new object Control.  
	*
	 */
	public Control() {
		setAdmin(new Admin("12345","admin","123@qq.com"));
		fileCreate();
		this.customer=FileControl.<Customer>ReadFile(cuspath);
		this.station=FileControl.<Station>ReadFile(stapath);
		this.scooter=FileControl.<Scooter>ReadFile(scopath);
		this.setRecord(FileControl.<Record>ReadFile(recpath));
		Scooter.setId(scooter.size());
		if(record.size()>0)
			if(new Date().getDay()-record.get(record.size()-1).getDate().getDay()>0)
				for(Customer c:customer) {
					if(c.isBorrow()==true &&c.getFine()==0 ) {
						c.setTotaltime(0);
						c.setUnittime(0);
					}
				}
	}
	/**
	 * 
	 * @Discription if there isn't folder create the folder and files to save the data 
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 24, 20192019
	 * void
	 */
	public void fileCreate() {
		try {
			File file=new File("D:\\Group_work");
			if((!file.exists())&&(!file.isDirectory())) file.mkdirs();
			File cus=new File(cuspath);
			InitFile(cus);
			File sta=new File(stapath);
			InitFile(sta);
			File sco=new File(scopath);
			InitFile(sco);
			File rec=new File(recpath);
			InitFile(rec);
			
		}catch(Exception e) {
			e.printStackTrace();
		} 
	}
	/**
	 * 
	 * @Discription create a new file
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 24, 20192019
	 * @param file
	 * void
	 */
	public void InitFile(File file) {
		try {
			if(!file.exists()) {
				file.createNewFile();
				FileOutputStream fos=new FileOutputStream(file);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(null); 
				oos.close();
				fos.close();

			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return customer
	 */
	public ArrayList<Customer> getCustomer() {
		return customer;
	}

	/**
	 * @param customer want to set customer
	 */
	public void setCustomer(ArrayList<Customer> customer) {
		this.customer = customer;
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
	 * @return station
	 */
	public ArrayList<Station> getStation() {
		return station;
	}

	/**
	 * @param station want to set station
	 */
	public void setStation(ArrayList<Station> station) {
		this.station = station;
	}
	/**
	 * @Discription login the system
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 13, 20192019
	 * @param s
	 * @return
	 * boolean
	 */
	public boolean login(String s) {
		for (Customer c:customer) {
			if(c.getQmnumber().trim().equals(s.trim())) return true;
		}
		return false;
	}
	/**
	 * 
	 * @Discription register function
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 13, 20192019
	 * @param qmnumber
	 * @param fullname
	 * @param email
	 * @return
	 * boolean
	 */
	public boolean register(String qmnumber,String fullname,String email) {
		if(checkString(qmnumber,fullname,email)) {
			Customer cus=new Customer(qmnumber,fullname,email);
			customer.add(cus);
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @Discription check string whether legal
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 13, 20192019
	 * @return
	 * boolean
	 */
	public boolean checkString(String qm,String fullname,String email) {
		if(qm==null||qm.equals("")||fullname==null||fullname.equals("")||email.equals("")||email==null)
			return false;
		if(!isEmail(email)) return false;
		if(qm.length()!=9) return false;
		try {
			Integer.parseInt(qm);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 
	 * @Discription check the Email address whether legal
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 24, 20192019
	 * @param str
	 * @return
	 * boolean
	 */
    public static boolean isEmail( String str ) {
        String regex = "[a-zA-Z0-9_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}" ;
        return match( regex ,str );
    }
    /**
     * 
     * @Discription match the string
     * @author Boyuan Bai
     * @version 1.0
     * @Lastupdate May 24, 20192019
     * @param regex
     * @param str
     * @return
     * boolean
     */
    private static boolean match( String regex ,String str ){
        Pattern pattern = Pattern.compile(regex);
        Matcher  matcher = pattern.matcher( str );
        return matcher.matches();
    }
	/**
	 * 
	 * @Discription search customer's record
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 13, 20192019
	 * @param id
	 * @return
	 * String
	 */
	public String search(String id) {
		String total="";
		for(Record r:getRecord()) {
			if(r.getQmNumber().contentEquals(id)) total+=r.toString();
		}
		return total;
	}
	/**
	 * 
	 * @Discription
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 24, 20192019
	 * @param name
	 * @param empty
	 * @param available
	 * @return
	 * boolean
	 */
	public boolean Modify(String name,int empty,int available) {
		boolean flag=false;
		System.out.println(name+empty+available);
		for(Station s:station) {
			if(s.getName().equals(name)) {
				s.modifyStation(empty, available);
				if(empty==0&&available==0) {
					System.out.println("i want to remove");
					station.remove(s);
				}
				flag=true;
				return true;
			}
		}
		if(!flag) { 
			station.add(new Station(name,empty,available,scooter));
			flag=true;
		}
		return flag;
	}
	/**
	 * 
	 * @Discription print the information of available station
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 24, 20192019
	 * @return
	 * String
	 */
	public String AvaStation() {
//		String total="<html>";
//		for(Station s:station) total+="<tr>"+s.toString()+"</tr>";
//		return total+"</html>";
		String total="";
		for(Station s:station) total+=s.toString();
		return total;

	}
	/**
	 * 
	 * @Discription borrow a scooter from a station
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 24, 20192019
	 * @param c
	 * @param s
	 * @return
	 * boolean
	 */
	public boolean borrow(Customer c,Slot s) {
		c.setBorrowtime(new Date());
		c.setWeekborrow(c.getWeekborrow()+1);
		c.setBorrow(false);
		getRecord().add(new Record(c.getQmnumber(),"borrow",s.getStation(),s.getId(),0));
		return true;
	}
	/**
	 * 
	 * @Discription return a scooter to a station
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 24, 20192019
	 * @param c
	 * @param s
	 * @return
	 * boolean
	 */
	public boolean retureSlot(Customer c,Slot s) {
		Date now=new Date();
		int unittime=(int)((now.getTime()-c.getBorrowtime().getTime())/1000/60);
		c.setBorrow(true);
		c.setWeekborrow(c.getWeekborrow()+1);
		c.setWeektime(c.getWeektime()+unittime);
		c.setTotaltime(c.getTotaltime()+unittime);
		c.setUnittime(unittime);
		if(c.getTotaltime()>120||c.getUnittime()>30) c.setFine(100);
		getRecord().add(new Record(c.getQmnumber(),"return",s.getStation(),s.getId(),c.getFine()));
		return true;
	}
	
	/**
	 * 
	 * @Discription save the files when exit the system
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 24, 20192019
	 * void
	 */
	public void exit() {
		FileControl.<Customer>WriteFile(customer,cuspath);
		FileControl.<Station>WriteFile(station,stapath);
		FileControl.<Scooter>WriteFile(scooter,scopath);
		FileControl.<Record>WriteFile(record,recpath);

	}
	/**
	 * 
	 * @Discription find a customer by pin
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 13, 20192019
	 * @param s
	 * @return
	 * Customer
	 */
	public Customer getCus(String s) {
		for (Customer c:customer) {
			if(c.getQmnumber().trim().equals(s.trim())) return c;
		}
		return null;
	}
	/**
	 * 
	 * @Discription get customer by name 
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 13, 20192019
	 * @param s
	 * @return
	 * Customer
	 */
	public Customer getCusByname(String s) {
		for (Customer c:customer) {
			if(c.getFullName().trim().equals(s.trim())) return c;
		}
		return null;
	}
	/**
	 * 
	 * @Discription get customer By customer
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 13, 20192019
	 * @param s
	 * @return
	 * Customer
	 */
	public Customer getCus(Customer s) {
		for (Customer c:customer) {
			if(c.equals(s)) return c;
		}
		return null;
	}
	public Station getStation(String s) {
		for(Station st:station) {
			if(st.getName().equals(s)) return st;
			
		}
		return null;
	}

	/**
	 * @return admin
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * @param admin want to set admin
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 * @return record
	 */
	public ArrayList<Record> getRecord() {
		return record;
	}

	/**
	 * @param record want to set record
	 */
	public void setRecord(ArrayList<Record> record) {
		this.record = record;
	}
}
