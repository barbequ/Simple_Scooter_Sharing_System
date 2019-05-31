package Gui;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import control.Control;
import javax.swing.JOptionPane;


/**
* @Title RegisterPanel.java
* @author Boyuan Bai
* @version 1.0
* @Createtime May 12, 2019 9:35:02 PM
* @Discription:
* 
*/
/**  
* @ClassName: RegisterPanel  
* @Description: the panel for a customer to register
* @author Boyuan Bai  
* @date May 12, 2019  
*    
*/
public class RegisterPanel extends JPanel {
	private JTextField qnmumber;
	private JTextField fullname;
	private JTextField email;
	private JFrame frame;
	private Control c;
	/**
	 * Create the panel.
	 */
	public RegisterPanel(JFrame frame,Control c) {
		this.c=c;
		this.frame=frame;
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		JLabel lblQmNumber = new JLabel("QM Number :");
		lblQmNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblQmNumber.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblQmNumber.setBounds(76, 63, 97, 24);
		add(lblQmNumber);
		
		qnmumber = new JTextField();
		qnmumber.setBounds(230, 63, 108, 21);
		add(qnmumber);
		qnmumber.setColumns(10);
		
		JLabel lblFullName = new JLabel("Full Name :");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblFullName.setBounds(76, 110, 96, 24);
		add(lblFullName);
		
		fullname = new JTextField();
		fullname.setBounds(230, 110, 108, 21);
		add(fullname);
		fullname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblEmail.setBounds(76, 164, 97, 24);
		add(lblEmail);
		
		email = new JTextField();
		email.setBounds(230, 164, 108, 21);
		add(email);
		email.setColumns(10);
		
		JButton Submit = new JButton("Submit");
		Submit.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.login(qnmumber.getText().trim())) {
					JOptionPane.showMessageDialog(null,"The User has already registered!","Warning",JOptionPane.WARNING_MESSAGE);
					return;
				}
				boolean flag=c.register(qnmumber.getText().trim(), fullname.getText().trim(), email.getText().trim());
				if(flag) {
					JOptionPane.showMessageDialog(null,"Succes!","Warning",JOptionPane.WARNING_MESSAGE);
					frame.getContentPane().removeAll();
					frame.add(new Mpanel(frame,c));
					frame.repaint();
					frame.setVisible(true);

				}
				else JOptionPane.showMessageDialog(null,"String ilegal","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		});
		Submit.setBounds(165, 216, 97, 23);
		add(Submit);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				frame.add(new Mpanel(frame,c));
				frame.repaint();
				frame.setVisible(true);
			}
		});
		back.setBounds(317, 20, 97, 23);
		add(back);

	}
}
