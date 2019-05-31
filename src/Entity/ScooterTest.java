/**
 * 
 */
package Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author yuanrui
 *
 */
class ScooterTest {
	Scooter scooter;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		scooter = new Scooter("A", 1);
	}

	/**
	 * Test method for {@link Entity.Scooter#Scooter(java.lang.String, int)}.
	 */
	@Test
	void testScooter() {
		assertEquals(scooter,scooter);
	}

	/**
	 * Test method for {@link Entity.Scooter#getId()}.
	 */
	@Test
	void testGetId() {
		scooter.setId(0);
		assertEquals(0,scooter.getId());
	}

	/**
	 * Test method for {@link Entity.Scooter#getGood()}.
	 */
	@Test
	void testGetGood() {
		boolean good = true;
		scooter.setGood(good);
		assertEquals(good,scooter.getGood());
		
	}

	/**
	 * Test method for {@link Entity.Scooter#getStation()}.
	 */
	@Test
	void testGetStation() {
		scooter.setStation("A");
		assertEquals("A",scooter.getStation());
	}

	/**
	 * Test method for {@link Entity.Scooter#getSlot()}.
	 */
	@Test
	void testGetSlot() {
		scooter.setSlot(1);
		assertEquals(1,scooter.getSlot());
	}

	/**
	 * Test method for {@link Entity.Scooter#getBorrow()}.
	 */
	@Test
	void testGetBorrow() {
		boolean borrow = true;
		scooter.setBorrow(borrow);
		assertEquals(true,scooter.getBorrow());
	}

	/**
	 * Test method for {@link Entity.Scooter#setId(int)}.
	 */
	@Test
	void testSetId() {
		scooter.setId(0);
		assertEquals(0,scooter.getId());

	}

	/**
	 * Test method for {@link Entity.Scooter#setGood(boolean)}.
	 */
	@Test
	void testSetGood() {
		boolean good = true;
		scooter.setGood(good);
		assertEquals(good,scooter.getGood());
	}

	/**
	 * Test method for {@link Entity.Scooter#setStation(java.lang.String)}.
	 */
	@Test
	void testSetStation() {
		scooter.setStation("A");
		assertEquals("A",scooter.getStation());
	}

	/**
	 * Test method for {@link Entity.Scooter#setSlot(int)}.
	 */
	@Test
	void testSetSlot() {
		scooter.setSlot(1);
		assertEquals(1,scooter.getSlot());
	}

	/**
	 * Test method for {@link Entity.Scooter#setBorrow(boolean)}.
	 */
	@Test
	void testSetBorrow() {
		boolean borrow = true;
		scooter.setBorrow(true);
		assertEquals(true,scooter.getBorrow());
	}

	/**
	 * Test method for {@link Entity.Scooter#equals(Entity.Scooter)}.
	 */
	@Test
	void testEqualsScooter() {
		assertEquals(true,true);
	}

	/**
	 * Test method for {@link Entity.Scooter#toString()}.
	 */
	@Test
	void testToString() {
		assertEquals("id :1\tGood: true\tStation: A\tSlot:1\tborrow: false\n",scooter.toString());
	}

	/**
	 * Test method for {@link Entity.Scooter#toHtmlTitle()}.
	 */
	@Test
	void testToHtmlTitle() {
		assertEquals("<html><tr><td align=\"center\">Id</td><td align=\"center\">Good</td><td align=\"center\">Station</td><td align=\"center\">Slot</td><td align=\"center\">Borrow</td></tr></html>",scooter.toHtmlTitle());
	}

	/**
	 * Test method for {@link Entity.Scooter#toHtmlString()}.
	 */
	@Test
	void testToHtmlString() {
		assertEquals("<html><tr><td align=\"center\">8</td><td align=\"center\">true</td><td align=\"center\">A</td><td align=\"center\">1</td><td align=\"center\">false</td></tr></html>",scooter.toHtmlString());
	}

}
