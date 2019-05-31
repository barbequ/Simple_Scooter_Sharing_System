/**
 * 
 */
package control;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Entity.Scooter;
import control.*;

/**
 * @author yuanrui
 *
 */
class ScooterControlTest {
	String path;
	public Control c;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		c=new Control();
	}

	/**
	 * Test method for {@link control.ScooterControl#getScooter(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testGetScooter() {
		path = "D:\\Group_work\\scooter.dat";
		ArrayList<Scooter> scooter=FileControl.<Scooter>ReadFile(path);

		assertNotNull(scooter);
	}

	/**
	 * Test method for {@link control.ScooterControl#addScooter(java.util.ArrayList, Entity.Scooter)}.
	 */
	@Test
	void testAddScooter() {
		path = "D:\\Group_work\\scooter.dat";
		ArrayList<Scooter> scooter=FileControl.<Scooter>ReadFile(path);

		assertNotNull(scooter);
	}


}
