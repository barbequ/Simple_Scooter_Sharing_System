package control;
import java.util.ArrayList;

import Entity.Record;
/**
 * 
* @ClassName: RecordControl  
* @Description: the control class for search record
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class RecordControl implements java.io.Serializable{
	private ArrayList<Record> record;
	public static ArrayList<Record> getCusRecord(String qmNumber){
		ArrayList<Record> list=FileControl.<Record>ReadFile("./file/record.dat");
		ArrayList<Record> newList=new ArrayList<Record>();
		for(Record r:list){
			if(r.getQmNumber().equals(qmNumber)) newList.add(r); 
		}
		return newList;
	}
	public RecordControl() {
		record=FileControl.ReadFile("./file/record.dat");
	}
	public RecordControl(ArrayList<Record> record) {
		this.record=record;
	}
	/**
	 * @Discription get the fine record
	 * @author Boyuan Bai
	 * @version 1.0
	 * @Lastupdate May 13, 20192019
	 * @return
	 * ArrayList<Record>
	 */
	public ArrayList<Record> getFineRecord(){
		ArrayList<Record> newList=new ArrayList<Record>();
		for(Record r:record){
			if(r.getFine()>0) newList.add(r); 
		}
		return newList;
	}
}
