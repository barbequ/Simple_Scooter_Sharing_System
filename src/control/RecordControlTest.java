/**
 * 
 */
package control;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Entity.Record;

/**
 * @author yuanrui
 *
 */
class RecordControlTest {
	String recpath="D:\\Group_work\\record.dat";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for {@link control.RecordControl#getCusRecord(java.lang.String)}.
	 */
	@Test
	void testGetCusRecord() {
		ArrayList<Record> list=FileControl.<Record>ReadFile(recpath);
		assertNotNull(list);
	}

	/**
	 * Test method for {@link control.RecordControl#RecordControl()}.
	 */
	@Test
	void testRecordControl() {
		ArrayList<Record> list=FileControl.<Record>ReadFile(recpath);
		assertNotNull(list);
	}

	/**
	 * Test method for {@link control.RecordControl#RecordControl(java.util.ArrayList)}.
	 */
	@Test
	void testRecordControlArrayListOfRecord() {
		ArrayList<Record> list=FileControl.<Record>ReadFile(recpath);
		assertNotNull(list);
	}

	/**
	 * Test method for {@link control.RecordControl#getFineRecord()}.
	 */
	@Test
	void testGetFineRecord() {
		ArrayList<Record> newList=new ArrayList<Record>();
		assertNotNull(newList);
	}

}
