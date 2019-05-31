package Entity;

/**
* @Title Admin.java
* @author Boyuan Bai
* @version 1.0
* @Createtime May 13, 2019 12:21:26 PM
* @Discription:
* 
*/
/**  
* @ClassName: Admin  
* @Description: the entity class for administrator
* @author Boyuan Bai  
* @date May 13, 2019  
*    
*/
public class Admin extends User implements java.io.Serializable{

	/**  
	* Create a new object Admin.  
	*  
	* @param qmnumber
	* @param fullname
	* @param email  
	*/
	public Admin(String qmnumber, String fullname, String email) {
		super(qmnumber, fullname, email);
		// TODO Auto-generated constructor stub
	}

}
