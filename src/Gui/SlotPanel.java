package Gui;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import Entity.*;
import control.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.Font;
/**
 * 
* @ClassName: SlotPanel  
* @Description: the panel to select the slot to borrow or return a bike
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class SlotPanel extends JPanel implements ActionListener{
	private Control c;
	private Station station;
	private Customer customer;
	private JFrame frame;
	private int random;
	private Timer t = new Timer();
	private Timer t2 = new Timer();
	private JButton sl[];
	private JButton repair;
	private Slot s;
	/**
	 * Create the panel.
	 */
	public SlotPanel (JFrame frame,Control c,Station station,Customer customer) {
		this.frame=frame;
		this.c=c;
		this.station=station;
		this.customer=customer;
		setBackground(new Color(248, 248, 255));
		setForeground(new Color(0, 0, 0));
		SimpleCommRxTx.send('C');
		repair = new JButton("Repair");
		repair.setBounds(204, 10, 97, 23);
		repair.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		repair.addActionListener(this);
		setLayout(null);
		add(repair);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(324, 10, 97, 23);
		btnBack.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.cancel();
				t2.cancel();
				frame.getContentPane().removeAll();
//				setVisible(false);
				frame.getContentPane().add(new Mpanel(frame,c));
				frame.repaint();
				frame.setVisible(true);
			}
		});
		add(btnBack);
		
		JLabel timer = new JLabel("60");
		timer.setBounds(91, 5, 72, 33);
		timer.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		add(timer);
		
		JPanel slotPanel = new JPanel();
		slotPanel.setBounds(10, 45, 430, 245);
		slotPanel.setBackground(new Color(248, 248, 255));
		add(slotPanel);
		slotPanel.setLayout(new GridLayout(0, 4, 3, 3));
		
		ArrayList<Slot> slot;
		if(customer.getBorrow()) slot=station.getAvaslot();
		else slot=station.getEmpslot();
		if(slot.size()==0) return;
		sl=new JButton[slot.size()];
		random=new Random().nextInt(slot.size());
		this.s=slot.get(random);
		for(int i=0;i<slot.size();i++) {
			sl[i]=new JButton(""+slot.get(i).getId());
			sl[i].setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
			sl[i].setOpaque(true);
			sl[i].setBorderPainted(false);
			sl[i].addActionListener(this);
			slotPanel.add(sl[i]);
		}
		add(slotPanel);
		SimpleCommRxTx.send((char)(slot.get(random).getId()+'1'));

		JLabel lblBorrow = new JLabel();
		lblBorrow.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorrow.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblBorrow.setBounds(23, 10, 58, 23);
		if(customer.getBorrow()) lblBorrow.setText("Borrow:");
		else lblBorrow.setText("Return:");
		add(lblBorrow);
		t.schedule(new TimerTask() {
	        public void run() {
	            int m=Integer.parseInt(timer.getText());
	            if(m<=0) {
	            	JOptionPane.showMessageDialog(null,"Overtime","Warning",JOptionPane.ERROR_MESSAGE);
					frame.getContentPane().removeAll();
//					setVisible(false);
					frame.getContentPane().add(new Mpanel(frame,c));
					frame.repaint();
					frame.setVisible(true);
	            	t2.cancel();
	            	cancel();
					SimpleCommRxTx.send('0');
					SimpleCommRxTx.send('H');
	            }
	        	timer.setText(""+(m-1));
	        	if(m%2==0) {
	        		sl[random].setBackground(Color.RED);
//	        		my=new Mythread();
//	        		my.start();
	        		try {
		        		//my.wait();

	        		}catch(Exception e){e.printStackTrace();}
//	        		SimpleCommRxTx.ser.close();

	        	}else sl[random].setBackground(null);
	        }
		},0, 1000);
		t2.schedule(new TimerTask() {
			public void run() {
//				SimpleCommRxTx.send((char)(s.getId()+'1'));
//				System.out.println((char)(s.getId()+'1'));
				String st=SimpleCommRxTx.go();
				System.out.println(st);
				SimpleCommRxTx.send2('0');
				int m=-1;
				try {
					m=Integer.parseInt(st.trim());
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("false");
					return;
				}
				if(m==s.getId()) {
					boolean borrow=customer.getBorrow();
					if(borrow) {
						Slot s=station.getAvaslot().get(random);
						Scooter d=s.getScooter();
						d.setBorrow(true);
						customer.setScooter(d);
						s.setEmpty(true);
						station.getScooter().remove(d);
						station.getAvaslot().remove(s);
						station.getEmpslot().add(s);
						station.setAvailable(station.getAvaslot().size());
						station.setEmpty(station.getEmpslot().size());
						c.borrow(customer,s);
					}else {
						Slot s=station.getEmpslot().get(random);
						Scooter d=customer.getScooter();
						d.setBorrow(false);
						d.setStation(station.getName());
						d.setSlot(s.getId());
						customer.setScooter(null);
						s.setEmpty(false);
						s.setScooter(d);
						station.getScooter().add(d);
						station.getEmpslot().remove(s);
						station.getAvaslot().add(s);
						station.setAvailable(station.getAvaslot().size());
						station.setEmpty(station.getEmpslot().size());
						c.retureSlot(customer,s);
					}
//					JOptionPane.showMessageDialog(null,"Succes","Warning",JOptionPane.WARNING_MESSAGE);
					frame.getContentPane().removeAll();
//					setVisible(false);
					frame.getContentPane().add(new Mpanel(frame,c));
					frame.repaint();
					frame.setVisible(true);
					t.cancel();
					SimpleCommRxTx.send('H');
					cancel();
				}
			}
		},0, 100);

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sl[random]) {
			boolean borrow=customer.getBorrow();
			if(borrow) {
				Slot s=station.getAvaslot().get(random);
				Scooter d=s.getScooter();
				d.setBorrow(true);
				customer.setScooter(d);
				s.setEmpty(true);
				station.getScooter().remove(d);
				station.getAvaslot().remove(s);
				station.getEmpslot().add(s);
				station.setAvailable(station.getAvaslot().size());
				station.setEmpty(station.getEmpslot().size());
				c.borrow(customer,s);
			}else {
				Slot s=station.getEmpslot().get(random);
				Scooter d=customer.getScooter();
				d.setBorrow(false);
				d.setStation(station.getName());
				d.setSlot(s.getId());
				customer.setScooter(null);
				s.setEmpty(false);
				s.setScooter(d);
				station.getScooter().add(d);
				station.getEmpslot().remove(s);
				station.getAvaslot().add(s);
				station.setAvailable(station.getAvaslot().size());
				station.setEmpty(station.getEmpslot().size());
				c.retureSlot(customer,s);
			}
//			JOptionPane.showMessageDialog(null,"Succes","Warning",JOptionPane.WARNING_MESSAGE);
			frame.getContentPane().removeAll();
//			setVisible(false);
			frame.getContentPane().add(new Mpanel(frame,c));
			frame.repaint();
			frame.setVisible(true);
			t.cancel();
			t2.cancel();
			SimpleCommRxTx.send('0');
			SimpleCommRxTx.send2('H');
		}
		if(e.getSource()==repair) {
			if(customer.getBorrow()) {
				t.cancel();
				t2.cancel();
				Scooter sc=s.getScooter();
				sc.setGood(false);
				sc.setBorrow(false);
				station.getAvaslot().remove(s);
				station.getBadslot().add(s);
				station.setAvailable(station.getAvaslot().size());
				frame.getContentPane().removeAll();
//				setVisible(false);
				frame.getContentPane().add(new SlotPanel(frame,c,station,customer));
				frame.repaint();
				frame.setVisible(true);
				JOptionPane.showMessageDialog(null,"Repair Succes","Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
		

	
}
