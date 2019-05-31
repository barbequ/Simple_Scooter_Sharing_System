package control;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * 
* @ClassName: FileControl  
* @Description: the control class for file operation
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class FileControl implements java.io.Serializable{
	public static <s> ArrayList<s> ReadFile(String path) {		
		ArrayList<s> list=new ArrayList<s>();
//		System.out.println("input");

		try {
			File file=new File(path);
//			System.out.println("in");
			if(file.exists()) {
//				System.out.println("in2");
				FileInputStream fis=new FileInputStream(file);
//				System.out.println("in3");
				ObjectInputStream ois=new ObjectInputStream(fis);
//				System.out.println("in4");
//				System.out.println(fis.available());
				while(fis.available()>0) {
					s n=(s)ois.readObject();
					if(n!=null) list.add(n);
//					System.out.println(n);
				}
				ois.close();
				fis.close();
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static <s> void addFile(s object,String path) {
		try {
			File file=new File(path);
			if(file.exists()) {
				FileOutputStream fos=new FileOutputStream(file,true);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				fos.getChannel().truncate(fos.getChannel().position()-4);
				oos.writeObject(object);
				oos.close();
				fos.close();
			} else{
				file.createNewFile();
				FileOutputStream fos=new FileOutputStream(file);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(object);
				oos.close();
				fos.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static <s> void WriteFile(ArrayList<s> list,String path) {		
		try {
			File file=new File(path);
			if(!file.exists()) file.createNewFile();
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.flush();
			for(s r:list){
				oos.writeObject(r); 
//				System.out.println(r);

			}
			oos.writeObject(null);
			oos.close();
			fos.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
