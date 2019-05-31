package Gui;
import control.*;
import Entity.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 
* @ClassName: StationPanel  
* @Description: the panel to select station and show the station message
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class StationPanel extends JPanel {
	private JFrame frame;
	private Control c;
	private Customer customer;
	private Timer t=new Timer();
	public Mythread my;
	/**
	 * Create the panel.
	 */
	public StationPanel(JFrame frame,Control c,Customer customer) {
		this.frame=frame;
		this.c=c;
		this.customer=customer;
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		SimpleCommRxTx.send('T');
		my=new Mythread();
		my.start();
		JButton Back = new JButton("Back");
		Back.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
//				setVisible(false);
				frame.getContentPane().add(new Mpanel(frame,c));
				frame.repaint();
				frame.setVisible(true);
				my.stop();
				}
		});
		Back.setBounds(325, 10, 97, 23);
		add(Back);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(26, 43, 399, 37);
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblAvailable = new JLabel("Name");
		lblAvailable.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblAvailable.setBackground(new Color(248, 248, 255));
		lblAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAvailable);
		
		JLabel lblName = new JLabel("Empty");
		lblName.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblName.setBackground(new Color(248, 248, 255));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblName);
		
		JLabel lblEmpty = new JLabel("Available");
		lblEmpty.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblEmpty.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEmpty);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 78, 399, 113);
		add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(c.AvaStation());
		textPane.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		scrollPane.setViewportView(textPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 189, 399, 101);
		add(scrollPane_1);
		
		JPanel station = new JPanel();
		station.setBackground(new Color(255, 255, 255));
		station.setForeground(new Color(0, 0, 0));
		ArrayList<Station> s=c.getStation();
		int size=s.size();
		station.setLayout(new GridLayout(0, 2, 3, 3));
		JButton sta[]=new JButton[size];
		for(int i=0;i<size;i++) {
			Station now=s.get(i);
			sta[i]=new JButton(now.getName());
			sta[i].setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
			sta[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.getContentPane().removeAll();
//					setVisible(false);
					frame.getContentPane().add(new SlotPanel(frame,c,now,customer));
					frame.repaint();
					frame.setVisible(true);
					my.stop();
				}
			});
			station.add(sta[i]);
		}
		
		scrollPane_1.setViewportView(station);

	}
	public class Mythread extends Thread{
		public void run() {
			String s=SimpleCommRxTx.go();
			System.out.println(s);
			if(s.equals("A")||s.equals("B")||s.equals("C")||s.equals("D")) {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new SlotPanel(frame,c,c.getStation(s),customer));
				frame.repaint();
				frame.setVisible(true);
				stop();
			}

		} 
	}
}
