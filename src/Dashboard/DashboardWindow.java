package Dashboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;




public class DashboardWindow extends JFrame{
	JMenuBar menuBar;
	JMenuItem menuItem;
	static JMenu menu;
	static JPanel Desc = new JPanel();
	static JMenu dm = new JMenu("Dashboard");
	static JLabel slabel = new JLabel();
	static JPanel status = new JPanel();
	static JPanel frame = new JPanel();
	static JPanel games = new JPanel();
	static JPanel apps = new JPanel();
	static JMenuItem Exit = new JMenuItem("Exit");
	static JMenuBar menubar = new JMenuBar();
	static JTextArea descText = new JTextArea();
	static JButton run = new JButton("run");
	static JButton resize = new JButton("resize");
	
	static JTextArea tlabel = new JTextArea();
	
	static ActionListener ral;
	
	static SpringLayout springLayout = new SpringLayout();

	public static JProgressBar pbar;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DashboardWindow(String title, int operations){
		super(title);

		pbar = new JProgressBar(0, operations);

		Color gray = new Color(41, 39, 39);
		Color white = new Color(199, 197, 197);
		Color ngray = new Color(32, 32, 32);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		System.out.println("screen width : " + width + ", screen height : " + height);

		
		Desc.setLayout(springLayout);
		menubar.setBackground(gray);
		menubar.setForeground(gray);
		menubar.setBorderPainted(false);
		menubar.setBorder(BorderFactory.createEmptyBorder());
		pbar.setBackground(gray);

		slabel.setText("  :   No Tasks Right Now");
		//slabel.setSize(278, 15);
		slabel.setBackground(gray);
		//slabel.setLocation(0, 253);
		slabel.setForeground(white);




		dm.setBackground(gray);
		dm.setForeground(white);
		dm.setBorderPainted(false);
		dm.setBorder(BorderFactory.createEmptyBorder());



		Exit.setBackground(gray);
		Exit.setForeground(white);
		Exit.setBorderPainted(false);
		Exit.setBorder(BorderFactory.createEmptyBorder());

		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});

		dm.add(Exit);



		menubar.add(dm);

		setJMenuBar(menubar);

		Dimension prefSize = pbar.getPreferredSize();
		prefSize.height = (int) (height / 76.8);
		pbar.setPreferredSize(prefSize);




		frame.setBackground(gray);


		this.add(frame);



		status.setBackground(gray);

		status.setBorder(BorderFactory.createDashedBorder(null));

		status.setPreferredSize(new Dimension((int) (width / 6.75), (int) (height / 9.5)));

		status.add(pbar);

		status.add(slabel, BorderLayout.PAGE_END);


		add(status, BorderLayout.PAGE_END);



		games.setBackground(ngray);

		games.setBorder(BorderFactory.createEmptyBorder());

		games.setPreferredSize(new Dimension((int) (width / 6.5), (int) (height / 9.5)));

		run.setBorderPainted(false);

		run.setBackground(gray);

		run.setFont(new Font("Arial", Font.PLAIN, 18));
		run.setForeground(white);
		ral = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
				
	};
	
	run.addActionListener(ral);
	
	
		//run.setAlignmentX(Component.CENTER_ALIGNMENT);
		run.setVisible(false);
		springLayout.putConstraint(SpringLayout.WEST, run, (int) (width / 80), SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, run, (int) (height / 20), SpringLayout.NORTH, this);
		Desc.add(run);

		tlabel.setBackground(ngray);
		//slabel.setLocation(0, 253);
		tlabel.setForeground(white);
		springLayout.putConstraint(SpringLayout.WEST, tlabel, (int) (width / 80), SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, tlabel, (int) (height / 80), SpringLayout.NORTH, this);
		tlabel.setFont(new Font("Arial", Font.PLAIN, 18));
		Desc.add(tlabel);
		
		apps.setLayout(new BoxLayout(apps, BoxLayout.Y_AXIS));


		apps.setBackground(ngray);

		apps.setBorder(BorderFactory.createEtchedBorder());
		apps.setPreferredSize(new Dimension((int) (width / 4.5), 0));



		Desc.setBackground(ngray);

		Desc.setBorder(BorderFactory.createEtchedBorder());
		Desc.setPreferredSize(new Dimension((int) (width / 1.65), 0));

		//		apps.setAlignmentX(CENTER_ALIGNMENT);
		//descText.setAlignmentX(Component.CENTER_ALIGNMENT);
		descText.setBackground(ngray);
		springLayout.putConstraint(SpringLayout.WEST, descText, (int) (width / 80), SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, descText, (int) (height / 8.5), SpringLayout.NORTH, this);
		Desc.add(descText);

		add(Desc, BorderLayout.LINE_END);

		add(apps, BorderLayout.LINE_START);

		add(games, BorderLayout.CENTER);


		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(new Dimension((int) (width / 1.35), (int) (height / 1.3)));


		springLayout.putConstraint(SpringLayout.WEST, resize, (int) (width / 80), SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.NORTH, resize, (int) (height / 8.5), SpringLayout.NORTH, this);

		





		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
		Dashboard.initializerTasks();
	}

	public static void PBarValue(int Value){
		pbar.setValue(Value);

	}

	public static void ChangeText(String text){
		slabel.setText(text);
	}

	public static void PWaitTrue(){
		pbar.setIndeterminate(true);
	}

	public static void PWaitFalse(){
		pbar.setIndeterminate(false);
	}

	public static void PSetMax(int max){
		pbar.setMaximum(max);
	}



}


