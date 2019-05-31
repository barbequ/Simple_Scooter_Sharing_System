/**
 * 
 */
package Gui;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import control.Control;

/**
 * @author yuanrui
 *
 */
class EmailPanelTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		JFrame frame = new JFrame();
		Control c = new Control();
		EmailPanel p = new EmailPanel(frame ,c);
	}

	/**
	 * Test method for {@link Gui.EmailPanel#EmailPanel(javax.swing.JFrame, control.Control)}.
	 */
	@Test
	void testEmailPanel() {
		JFrame frame = new JFrame();
		Control c = new Control();
		EmailPanel p = new EmailPanel(frame ,c);
		
		assertNotNull(p);
	}

}
