package Gui;
import javax.swing.JPanel;
import control.Control;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import Entity.*;


/**
* @Title AdCheckPanel.java
* @author Boyuan Bai
* @version 1.0
* @Createtime May 12, 2019 10:02:36 PM
* @Discription:
* 
*/
/**  
* @ClassName: AdCheckPanel  
* @Description: 
* @author Boyuan Bai  
* @date May 12, 2019  
*    
*/
public class AdCheckPanel extends JPanel {
	private JFrame frame;
	private Control c;
	/**
	 * Create the panel.
	 */
	public AdCheckPanel(JFrame frame,Control c) {
		this.frame=frame;
		this.c=c;
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		JButton email = new JButton("Email");
		email.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
//				setVisible(false);
				frame.add(new EmailPanel(frame,c));
				frame.repaint();
				frame.setVisible(true);
			}
		});
		email.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		email.setBounds(173, 81, 97, 23);
		add(email);
		
		JButton modify = new JButton("Modify");
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
//				setVisible(false);
				frame.add(new ModifyPanel(frame,c));
				frame.repaint();
				frame.setVisible(true);
			}
		});
		modify.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		modify.setBounds(173, 138, 97, 23);
		add(modify);
		
		JButton repair = new JButton("Repair");
		repair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Station s:c.getStation()) {
					s.repair();
				}
				JOptionPane.showMessageDialog(null,"Repair Success","WARNING",JOptionPane.WARNING_MESSAGE);
			}
		});
		repair.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		repair.setBounds(173, 200, 97, 23);
		add(repair);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
//				setVisible(false);
				frame.add(new Mpanel(frame,c));
				frame.repaint();
				frame.setVisible(true);
			}
		});
		back.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		back.setBounds(343, 10, 97, 23);
		add(back);

	}

}
