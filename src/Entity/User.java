package Entity;
/**
 * 
* @ClassName: User  
* @Description: the entity superclass for user
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class User implements java.io.Serializable{
	private String qmnumber;
	private String fullName;
	private String email;
	public User(String qmnumber,String fullname,String email) {
		this.setQmnumber(qmnumber);
		this.setFullName(fullname);
		this.setEmail(email);
	}
	
	/**
	 * @return qmnumber
	 */
	public String getQmnumber() {
		return qmnumber;
	}

	/**
	 * @param qmnumber wang to set qmnumber
	 */
	public void setQmnumber(String qmnumber) {
		this.qmnumber = qmnumber;
	}

	/**
	 * @return fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName want to set fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email want to set email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @Discription judge the customer
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 13, 20192019
	 * @param s
	 * @return
	 * boolean
	 */
	public boolean equals(User s) {
		if(this.getQmnumber().equals(s.getQmnumber())&&this.getFullName().contentEquals(s.getFullName())&&this.getEmail().contentEquals(s.getEmail())) return true;
		return false;
	}

	public String toString() {
		return "QM Number: "+getQmnumber()+"\n"+"Full Name:"+getFullName()+"\n"+"Email: "+
	getEmail()+"\n";
	}

	public String toHtmlString() {
		return "<html><tr><td align=\"center\">"+getQmnumber()+"</td><td align=\"center\">"+getFullName()+"</td><td align=\"center\">"+
	getEmail()+"</td>";
	}
	public static String toHtmlTitle() {
		return "<html><tr><td align=\"center\">Qm number</td><td align=\"center\">FullName</td><td align=\"center\">Email</td>";
	}
}
