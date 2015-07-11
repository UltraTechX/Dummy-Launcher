package BootstrapperFiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class StartupWindow extends JFrame{
	JPanel frame = new JPanel();
	JLabel status = new JLabel();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JProgressBar pbar;

	public StartupWindow(String title, int operations){
		super(title);
		
		
		
		Color gray = new Color(41, 39, 39);
		Color white = new Color(199, 197, 197);
		

		pbar = new JProgressBar(0, operations);
		
		status.setText("Starting Up...");
		status.setSize(278, 15);
		status.setBackground(gray);
		status.setLocation(0, 253);
		status.setForeground(white);
		
		
		frame.add(new JLabel());
		
		pbar.setBackground(gray);
		frame.setBackground(gray);
		this.setBackground(gray);

        
		ImageIcon icon = new ImageIcon(new File("src/BootstrapperFiles/startup.png").getAbsolutePath());
		
		Dimension prefSize = pbar.getPreferredSize();
		prefSize.height = 10;
		pbar.setPreferredSize(prefSize);
		
		add(new JLabel(icon), BorderLayout.NORTH);
		
		add(pbar, BorderLayout.SOUTH);
		
		add(status);

		add(frame);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 278);


		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	

	public static void PBarValue(int Value){
		pbar.setValue(Value);
		
	}
	
	public void Close(){
		this.setVisible(false);
		this.dispose();
	}
	
	public void ChangeText(String text){
		status.setText(text);
	}
	

	
}

