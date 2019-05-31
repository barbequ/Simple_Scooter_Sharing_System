/**  
* @Title: SimoleCommRxTx.java  
* @Package control  
* @Description:   
* @author bby  
* @date May 20, 2019  
* @version V1.0  
*/  

package control;
/**
* @Title SimoleCommRxTx.java
* @author Boyuan Bai
* @version 1.0
* @Createtime May 20, 2019 9:06:57 PM
* @Discription:
* 
*/
/**  
* @ClassName: SimoleCommRxTx  
* @Description: the control class for serial communication
* @author Boyuan Bai  
* @date May 20, 2019  
*    
*/
import java.io.*;
import java.util.*;
import gnu.io.*; 


public class SimpleCommRxTx {
    static CommPortIdentifier portId;
    static CommPort com;
    public static SerialPort ser;

    static CommPortIdentifier portId1;
    static CommPort com1;
    static SerialPort ser1;
    public Mythread mythread;
    static {
    	try {
 			// TODO: identify the COM port from Windows' control panel
             portId = CommPortIdentifier.getPortIdentifier("COM3");

             com = portId.open("MCS51COM", 2000);
             ser = (SerialPort)com;
 			// Baud rate = 9600, Data bits = 8, 1 stop bit, Parity OFF
             ser.setSerialPortParams(2400, SerialPort.DATABITS_8, 
                                     SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
         } catch (Exception e){
             e.printStackTrace(System.out);
         }

    }

    public static void main(String[] args) {
		/*
		 * String str=""; while(!str.equals("7777")) { str=go();
		 * System.out.println(str); }
		 */
    	System.out.println(go3('5'));
//    	send('3');
//    	new SimpleCommRxTx().dodo();
    		 
    	}
    public void dodo() {
		mythread=new Mythread();
		mythread.start();
		System.out.println(go3('5'));
//    	send('5');
    }
    public class Mythread extends Thread{
    	public void run() {
    		send('5');
    		this.stop();
    	}
    }
    public static String go() {
        String s="";
         try {
             InputStream comIn = ser.getInputStream();
            char ch=0;
             while(ch!='\n') {
            	 while(comIn.available()==0);
            	 ch=(char) comIn.read();
            	 if(ch!='\r'&&ch!='\n') s+=ch;
             }
            System.out.println(s);
             comIn.close();
         } catch (Exception e) {
             e.printStackTrace(System.out);
         }
 //        ser.close(); 
         return s;
     }
    public static String go2() {
        String s="";
    	try {
 			// TODO: identify the COM port from Windows' control panel
             portId1 = CommPortIdentifier.getPortIdentifier("COM5");

             com1 = portId1.open("MCS51COM", 2000);
             ser1 = (SerialPort)com1;
 			// Baud rate = 9600, Data bits = 8, 1 stop bit, Parity OFF
             ser1.setSerialPortParams(2400, SerialPort.DATABITS_8, 
                                     SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
         } catch (Exception e){
             e.printStackTrace(System.out);
         }

 		/*
 		// Wait for 1 second if 8051 needs time to initialise
         try { 
             Thread.sleep(1000);
         } catch (InterruptedException e){}
 		*/

         try {
 			// Test TX: send out chars 'D', 'O', 'G', 'S'
             OutputStream comOut = ser1.getOutputStream();
 			/*
 			 * comOut.write('D'); comOut.write('O'); comOut.write('G'); comOut.write('S');
 			 */
 			// Test RX: display first 4 chars received
             InputStream comIn = ser1.getInputStream();
            char ch=0;
             while(ch!='\n') {
            	 while(comIn.available()==0) ;
            	 ch=(char) comIn.read();
            	 if(ch!='\r'&&ch!='\n') s+=ch;
             }
  //           System.out.println(s);
 			// close the streams
             comIn.close();
             comOut.close();
         } catch (Exception e) {
             e.printStackTrace(System.out);
         }
 		// close the port
         ser1.close(); 
         return s;
     }
    public static void send(char a) {
		/*
		 * String s=""; try { portId = CommPortIdentifier.getPortIdentifier("COM3"); com
		 * = portId.open("MCS51COM", 2000); ser = (SerialPort)com;
		 * ser.setSerialPortParams(2400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
		 * SerialPort.PARITY_NONE); } catch (Exception e){
		 * e.printStackTrace(System.out); }
		 * 
		 */ 		/*
 		// Wait for 1 second if 8051 needs time to initialise
         try { 
             Thread.sleep(1000);
         } catch (InterruptedException e){}
 		*/

         try {
 			// Test TX: send out chars 'D', 'O', 'G', 'S'
             OutputStream comOut = ser.getOutputStream();
 			
 			  comOut.write(a);
 			  
             comOut.close();
 //            ser.close(); 

             return;

         } catch (Exception e) {
             e.printStackTrace(System.out);
         }
         return;
    }
    public static void send2(char a) {
 		/*
 		 * String s=""; try { portId = CommPortIdentifier.getPortIdentifier("COM3"); com
 		 * = portId.open("MCS51COM", 2000); ser = (SerialPort)com;
 		 * ser.setSerialPortParams(2400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
 		 * SerialPort.PARITY_NONE); } catch (Exception e){
 		 * e.printStackTrace(System.out); }
 		 * 
 		 */ 		/*
  		// Wait for 1 second if 8051 needs time to initialise
          try { 
              Thread.sleep(1000);
          } catch (InterruptedException e){}
  		*/

          try {
  			// Test TX: send out chars 'D', 'O', 'G', 'S'
              OutputStream comOut = ser.getOutputStream();
  			
  			  comOut.write(a);
  			  
              comOut.close();
//              ser.close(); 
//
              return;

          } catch (Exception e) {
              e.printStackTrace(System.out);
          }
          ser.close(); 
        return;
     }

    public static String go3(char a) {
        String s="";

         try {
             InputStream comIn = ser.getInputStream();
            char ch=0;
             while(ch!='\n') {
            	 if(comIn.available()==0) {
            		 send(a);
            		 Mythread.sleep(1000);
            	 }else {
                	 ch=(char) comIn.read();
                	 if(ch!='\r'&&ch!='\n') s+=ch;

            	 }
             }
             comIn.close();
         } catch (Exception e) {
             e.printStackTrace(System.out);
         }
 		// close the port
         ser.close(); 
         return ""+s.charAt(s.length()-1);
     }
    public static String go4(){
        String s="";
        try {
            InputStream comIn = ser.getInputStream();
           char ch=0;
            while(ch!='\n') {
           	 while(comIn.available()==0);
           	 ch=(char) comIn.read();
           	 if(ch!='\r'&&ch!='\n') s+=ch;
            }
           System.out.println(s);
            comIn.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        ser.close(); 
        return s;

    }
}
