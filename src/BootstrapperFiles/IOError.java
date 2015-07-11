package BootstrapperFiles;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IOError extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField Error;
	
	
	//constructor
	public IOError(String title, IOException Err){
	 
	super(title);
	 
	this.init(Err);
	
	this.setSize(800, 150);
	this.setVisible(true);
	}//end constructor
	
	void init(IOException Err){
		 
		JLabel Error = new JLabel("Err : " + Err);
		 
		JPanel panel = new JPanel();
		panel.add(Error);
		this.add(panel);
		 this.pack();
		}
}
