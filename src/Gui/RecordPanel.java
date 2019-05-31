package Gui;
import javax.swing.JPanel;
import control.*;
import Entity.*;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
* @Title RecordPanel.java
* @author Boyuan Bai
* @version 1.0
* @Createtime May 12, 2019 9:47:59 PM
* @Discription:
* 
*/
/**  
* @ClassName: RecordPanel  
* @Description: the panel to show customers record and report
* @author Boyuan Bai  
* @date May 12, 2019  
*    
*/
public class RecordPanel extends JPanel {
	private JFrame frame;
	private Control c;
	private Customer customer;
	/**
	 * Create the panel.
	 */
	public RecordPanel(JFrame frame,Control c,Customer customer) {
		this.frame=frame;
		this.c=c;
		this.customer=customer;
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Record/Report");
		scrollPane.setBackground(new Color(248,248,255));
		scrollPane.setForeground(new Color(248,248,255));
		scrollPane.setBounds(37, 38, 385, 194);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		scrollPane.setViewportView(panel);
		JLabel label = new JLabel("");
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(248,248,255));
		label.setForeground(new Color(0, 0, 0));
		label.setBackground(new Color(248, 248, 255));
		String s=Record.toHtmltitle();
		ArrayList<Record> rec=customer.getRecord(c.getRecord());
		for(Record r:rec) {
			s+=r.toHtmlString();
		}
		label.setText(s);

		JLabel lblFine = new JLabel("Fine:");
		lblFine.setHorizontalAlignment(SwingConstants.CENTER);
		lblFine.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		lblFine.setBackground(new Color(248, 248, 255));
		lblFine.setBounds(37, 242, 62, 25);
		add(lblFine);
		
		JLabel fine = new JLabel(""+customer.getFine());
		fine.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		fine.setBackground(new Color(248, 248, 255));
		fine.setHorizontalAlignment(SwingConstants.CENTER);
		fine.setBounds(113, 238, 58, 32);
		add(fine);
		
		JButton pay = new JButton("Pay");
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.setFine(0);
				customer.setTotaltime(0);
				customer.setUnittime(0);;
				fine.setText(""+customer.getFine());
			}
		});
		pay.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		pay.setBounds(181, 243, 97, 23);
		add(pay);
		
		JButton back = new JButton("Back");
		back.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
//				setVisible(false);
				frame.getContentPane().add(new Mpanel(frame,c));
				frame.repaint();
				frame.setVisible(true);
			}
		});
		back.setBounds(325, 10, 97, 23);
		add(back);
		
		JButton Report = new JButton("Report");
		Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s="<html><tr><td align=\"center\">Weekly use times</td><td align=\"center\">Weekly total time</td></tr></html>";
				s+="<html><tr><td align=\"center\">"+customer.getWeektime()+"</td><td align=\"center\">"+customer.getWeekborrow()+"</td></tr></html>";
				ArrayList<Record> report=customer.getReport(c.getRecord());
				s+=Record.toHtmltitle();
				for(Record r:report) {
					s+=r.toHtmlString();
				}
				label.setText(s);
			}
		});
		Report.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 15));
		Report.setBounds(311, 241, 97, 23);
		add(Report);
		

	}
}
