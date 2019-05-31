package Gui;
import control.Control;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**  
* @Title: ModifyPanel.java  
* @Package   
* @Description:   
* @author bby  
* @date May 12, 2019  
* @version V1.0  
*/

/**
* @Title ModifyPanel.java
* @author Boyuan Bai
* @version 1.0
* @Createtime May 12, 2019 10:11:14 PM
* @Discription:
* 
*/
/**  
* @ClassName: ModifyPanel  
* @Description: the panel to add or modify or remove a station and slot
* @author Boyuan Bai  
* @date May 12, 2019  
*    
*/
public class ModifyPanel extends JPanel {
	private JTextField station;
	private JTextField empty;
	private JTextField availble;
	private JFrame frame;
	private Control c;
	/**
	 * Create the panel.
	 */
	public ModifyPanel(JFrame frame,Control c) {
		this.frame=frame;
		this.c=c;
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		JLabel lblStationName = new JLabel("Station Name:");
		lblStationName.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblStationName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStationName.setBackground(new Color(248, 248, 255));
		lblStationName.setBounds(146, 63, 124, 30);
		add(lblStationName);
		
		station = new JTextField();
		station.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		station.setHorizontalAlignment(SwingConstants.CENTER);
		station.setBounds(146, 95, 124, 21);
		add(station);
		station.setColumns(10);
		
		JLabel lblEmptySlot = new JLabel("Empty slot:");
		lblEmptySlot.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmptySlot.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblEmptySlot.setBackground(new Color(248, 248, 255));
		lblEmptySlot.setBounds(146, 126, 124, 29);
		add(lblEmptySlot);
		
		empty = new JTextField();
		empty.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		empty.setHorizontalAlignment(SwingConstants.CENTER);
		empty.setBounds(146, 155, 124, 21);
		add(empty);
		empty.setColumns(10);
		
		JLabel lblAvalibleSlot = new JLabel("Avalible slot:");
		lblAvalibleSlot.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblAvalibleSlot.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvalibleSlot.setBounds(146, 186, 124, 34);
		add(lblAvalibleSlot);
		
		availble = new JTextField();
		availble.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		availble.setHorizontalAlignment(SwingConstants.CENTER);
		availble.setBounds(146, 216, 124, 21);
		add(availble);
		availble.setColumns(10);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c.Modify(station.getText().trim(), Integer.parseInt(empty.getText().trim()), Integer.parseInt(availble.getText().trim())))
					JOptionPane.showMessageDialog(null,"Success!","Warning",JOptionPane.WARNING_MESSAGE);
				else{
					JOptionPane.showMessageDialog(null,"Login Fail","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				availble.setText("");
				empty.setText("");
				station.setText("");
			}
		});
		submit.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		submit.setBounds(306, 215, 97, 23);
		add(submit);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
//				setVisible(false);
				frame.getContentPane().add(new AdCheckPanel(frame,c));
				frame.repaint();
				frame.setVisible(true);
			}
		});
		back.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		back.setBounds(306, 28, 97, 23);
		add(back);

	}

}
