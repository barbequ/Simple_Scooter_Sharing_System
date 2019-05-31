/**  
* @Title: UserTest.java  
* @Package Entity  
* @Description:   
* @author bby  
* @date May 25, 2019  
* @version V1.0  
*/  

package Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
* @Title UserTest.java
* @author Boyuan Bai
* @version 1.0
* @Createtime May 25, 2019 3:40:57 PM
* @Discription:
* 
*/
/**  
* @ClassName: UserTest  
* @Description: 
* @author Boyuan Bai  
* @date May 25, 2019  
*    
*/
class UserTest {

	/**
	 * @Discription
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 25, 20192019
	 * @throws java.lang.Exception
	 * void
	 */
	private User u;
	@BeforeEach
	void setUp() throws Exception {
		u=new User("161188265","baiboyuan","baiboyuan@bupt.edu.cn");
	}

	/**
	 * Test method for {@link Entity.User#User(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	final void testUser() {
		assertEquals(u,u);
	}

	/**
	 * Test method for {@link Entity.User#getQmnumber()}.
	 */
	@Test
	final void testGetQmnumber() {
		assertEquals("161188265",u.getQmnumber());
	}

	/**
	 * Test method for {@link Entity.User#setQmnumber(java.lang.String)}.
	 */
	@Test
	final void testSetQmnumber() {
		u.setQmnumber("161188266");
		assertEquals("161188266",u.getQmnumber());
	}

	/**
	 * Test method for {@link Entity.User#getFullName()}.
	 */
	@Test
	final void testGetFullName() {
		assertEquals("baiboyuan",u.getFullName());
	}

	/**
	 * Test method for {@link Entity.User#setFullName(java.lang.String)}.
	 */
	@Test
	final void testSetFullName() {
		u.setFullName("bai");
		assertEquals("bai",u.getFullName());
	}

	/**
	 * Test method for {@link Entity.User#getEmail()}.
	 */
	@Test
	final void testGetEmail() {
		u.getEmail();
		assertEquals("baiboyuan@bupt.edu.cn",u.getEmail());
	}

	/**
	 * Test method for {@link Entity.User#setEmail(java.lang.String)}.
	 */
	@Test
	final void testSetEmail() {
		u.setEmail("a@a.a.a");
		assertEquals("a@a.a.a",u.getEmail());
	}

	/**
	 * Test method for {@link Entity.User#equals(Entity.User)}.
	 */
	@Test
	final void testEqualsUser() {
		User utest =new User("161188265","baiboyuan","baiboyuan@bupt.edu.cn");
		assertEquals(true,u.equals(utest));
	}

	/**
	 * Test method for {@link Entity.User#toString()}.
	 */
	@Test
	final void testToString() {
		assertEquals("QM Number: 161188265\n"+"Full Name:baiboyuan\n"+"Email: baiboyuan@bupt.edu.cn\n",u.toString());
	}

	/**
	 * Test method for {@link Entity.User#toHtmlString()}.
	 */
	@Test
	final void testToHtmlString() {
		assertEquals("<html><tr><td align=\"center\">161188265</td><td align=\"center\">baiboyuan</td><td align=\"center\">"+
				"baiboyuan@bupt.edu.cn</td>",u.toHtmlString());
	}

	/**
	 * Test method for {@link Entity.User#toHtmlTitle()}.
	 */
	@Test
	final void testToHtmlTitle() {
		assertEquals("<html><tr><td align=\"center\">Qm number</td><td align=\"center\">FullName</td><td align=\"center\">Email</td>",u.toHtmlTitle());
	}

}
