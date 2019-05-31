package Gui;
import javax.swing.JPanel;
import control.Control;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Entity.*;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;


/**
 * 
* @ClassName: EmailPanel  
* @Description: the panel for administrator to send email
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class EmailPanel extends JPanel {
	private JFrame frame;
	private Control c;
	private JLabel message;
	/**
	 * Create the panel.
	 */
	public EmailPanel(JFrame frame,Control c) {
		this.frame=frame;
		this.c=c;
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 48, 403, 201);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		message = new JLabel("");
		message.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(message, BorderLayout.CENTER);
		String total=Customer.toHtmlTitle();
		for(Customer cus:c.getCustomer()) {
//			if(cus.getFine()>0) total+=cus.toString();
			total+=cus.toHtmlString();
		}
		message.setText(total);
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
//				setVisible(false);
				frame.getContentPane().add(new AdCheckPanel(frame,c));
				frame.repaint();
				frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		btnBack.setBounds(330, 10, 97, 23);
		add(btnBack);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Email send","WARNING",JOptionPane.WARNING_MESSAGE);
				message.setText("");
			}
		});
		btnEmail.setBounds(177, 259, 97, 23);
		add(btnEmail);

	}

}
