package Gui;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import control.Control;
import control.SimpleCommRxTx;

import javax.swing .JOptionPane;
import java.util.Timer;
import java.io.*;
import java.util.*;
import gnu.io.*; 
/**
 * 
* @ClassName: Mpanel  
* @Description: the main panel for user
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class Mpanel extends JPanel {
	private JTextField QMtext;
	private JFrame frame;
	private Control c;
	private Timer t=new Timer();
	/**
	 * Create the panel.
	 */
	public Mpanel(JFrame frame,Control c) {
		this.setFrame(frame);
		this.c=c;
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		

		JLabel QmNumber = new JLabel("QM Number:");
		QmNumber.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		QmNumber.setHorizontalAlignment(SwingConstants.CENTER);
		QmNumber.setBounds(80, 72, 123, 36);
		add(QmNumber);
		
		QMtext = new JTextField();
		QMtext.setHorizontalAlignment(SwingConstants.CENTER);
		QMtext.setBounds(93, 128, 103, 21);
		add(QMtext);
		QMtext.setColumns(10);
		
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=QMtext.getText().trim();
				if(c.login(s)) {
					if(c.getCus(s).getFine()>0) {
						JOptionPane.showMessageDialog(null,"Login Fail, you have fine","ERROR",JOptionPane.ERROR_MESSAGE);
						return;
					}
					t.cancel();
					frame.getContentPane().removeAll();
//					setVisible(false);
					frame.getContentPane().add(new StationPanel(frame,c,c.getCus(s)));
					frame.repaint();
					frame.setVisible(true);

				}else {
					QMtext.setText("");
					JOptionPane.showMessageDialog(null,"Login Fail","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		Login.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		Login.setBounds(270, 52, 97, 23);
		add(Login);
		
		JButton Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.cancel();
				frame.getContentPane().removeAll();
//				setVisible(false);
				frame.getContentPane().add(new RegisterPanel(frame,c));
				frame.repaint();
				frame.setVisible(true);
			}
		});
		Register.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		Register.setBounds(270, 97, 97, 23);
		add(Register);
		
		JButton Search = new JButton("Search");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=QMtext.getText().trim();
				if(c.login(s)) {
					t.cancel();
					frame.getContentPane().removeAll();
//					setVisible(false);
					frame.getContentPane().add(new RecordPanel(frame,c,c.getCus(s)));
					frame.repaint();
					frame.setVisible(true);

				}else {
					QMtext.setText("");
					JOptionPane.showMessageDialog(null,"Login Fail","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		Search.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		Search.setBounds(270, 141, 97, 23);
		add(Search);
		
		JButton Admin = new JButton("Admin");
		Admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(QMtext.getText().trim().equals(c.getAdmin().getQmnumber())) {
					t.cancel();
					frame.getContentPane().removeAll();
//					setVisible(false);
					frame.getContentPane().add(new AdCheckPanel(frame,c));
					frame.repaint();
					frame.setVisible(true);
					
				}else {
					QMtext.setText("");
					JOptionPane.showMessageDialog(null,"Login Fail","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Admin.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		Admin.setBounds(270, 187, 97, 23);
		add(Admin);
		
		JButton Exist = new JButton("Exit");
		Exist.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		Exist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.exit();
				System.exit(0);
			}
		});
		Exist.setBounds(99, 187, 97, 23);
		add(Exist);
		t.schedule(new TimerTask() {
			public void run() {
				String s=SimpleCommRxTx.go();
				System.out.println(s);
				if(!s.equals("")&&s!=null) QMtext.setText(s);
				if(c.login(s)) {
					System.out.println("success!");
					frame.getContentPane().removeAll();
					frame.getContentPane().add(new StationPanel(frame,c,c.getCus(s)));
					frame.repaint();
					frame.setVisible(true);
					cancel();

				}
			}
		},0, 1000);
		
	}
	/**
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * @param frame want to set frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
