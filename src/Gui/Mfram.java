package Gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.*;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
/**
 * 
* @ClassName: Mfram  
* @Description: the main frame for panels
* @author Boyuan Bai  
* @date May 25, 2019  
*
 */
public class Mfram {

	private JPanel contentPane;
	private Mpanel homepage;
	private JFrame frame;
	private Control c;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mfram fr = new Mfram();
					fr.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mfram() {
		setC(new Control());
		frame=new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				c.exit();
				SimpleCommRxTx.send('0');
				SimpleCommRxTx.ser.close();
				System.exit(0);
			}
		});
		frame.setTitle("Scooter System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(700, 200, 497, 379);

		
	}
	public void go() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setVisible(true);
		homepage= new Mpanel(frame,c);
		contentPane.add(homepage);
		homepage.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		frame.setVisible(true);
//		SimpleCommRxTx.main(null);
	}

	/**
	 * @return homepage
	 */
	public Mpanel getHomepage() {
		return homepage;
	}

	/**
	 * @param homepage want to set homepage
	 */
	public void setHomepage(Mpanel homepage) {
		this.homepage = homepage;
	}

	/**
	 * @return c
	 */
	public Control getC() {
		return c;
	}

	/**
	 * @param c want to set c
	 */
	public void setC(Control c) {
		this.c = c;
	}
}
