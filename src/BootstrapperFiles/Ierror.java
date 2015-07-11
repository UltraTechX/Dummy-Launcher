package BootstrapperFiles;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ierror extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField Error;
	
	
	//constructor
	public Ierror(String title, InterruptedException Err){
	 
	super(title);
	 
	this.init(Err);
	
	this.setSize(800, 150);
	this.setVisible(true);
	}//end constructor
	
	void init(InterruptedException Err){
		 
		JLabel Error = new JLabel("Err : " + Err);
		 
		JPanel panel = new JPanel();
		panel.add(Error);
		this.add(panel);
		 this.pack();
		}
}
