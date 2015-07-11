package Testers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class StartupWindowTest extends JFrame{
	
	public static void main(String[] args){
		new StartupWindowTest("Startup");
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JProgressBar pbar;

	public StartupWindowTest(String title){
		super(title);

		JPanel frame = new JPanel();

		pbar = new JProgressBar(0, 1);
		
		pbar.setValue(1);
		
		frame.add(new JLabel());

        
		ImageIcon icon = new ImageIcon(new File("C:\\Program Data\\Dummy Launcher\\pictures\\startup.png").getAbsolutePath());
		
		Dimension prefSize = pbar.getPreferredSize();
		prefSize.height = 10;
		pbar.setPreferredSize(prefSize);
		
		add(new JLabel(icon), BorderLayout.NORTH);
		
		add(pbar, BorderLayout.SOUTH);

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
}

