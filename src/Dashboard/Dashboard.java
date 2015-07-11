package Dashboard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import BootstrapperFiles.IOError;
import BootstrapperFiles.Ierror;

public class Dashboard {
	public static File cp;


	ActionListener ral;

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static int width = (int) screenSize.getWidth();
	static int height = (int) screenSize.getHeight();

	public static void initializerTasks(){
		DashboardWindow.ChangeText("Preforming Initializer Tasks...");
		DashboardWindow.PWaitTrue();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.err.println("CRITICAL ERROR!!! Error : " + e);
			Ierror window = new Ierror("*INTERRUPTION*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			DashboardWindow.ChangeText("Error");
		}
		CheckAppsFolder();
		FindApps();
		DashboardWindow.PWaitFalse();
		DashboardWindow.ChangeText("Nothing to do right now");


	}



	public static void CheckAppsFolder(){
		File file = new File("C:\\Program Data\\Dummy Launcher\\apps");
		if(file.exists()){
			if(file.getPath() == "C:\\Program Data\\Dummy Launcher\\apps"){
			}
		}else{
			InstallAppsFolder();
		}
	}

	public static void InstallAppsFolder(){
		File file = new File("C:\\Program Data\\Dummy Launcher\\apps");
		file.mkdirs();
		System.out.println("App Folder created At " + file.getPath());
	}




	static FilenameFilter filter = new FilenameFilter() {

		@Override
		public boolean accept(File dir, String name) {
			if (name.startsWith("app_") && dir.toString() == "C:\\Program Data\\Dummy Launcher\\apps"){
				if(name.endsWith(".jar")){

					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}



	};

	public static void FindApps(){
		for (File c : new File("C:\\Program Data\\Dummy Launcher\\apps").listFiles(filter)) {
			//ProcessBuilder pb = new ProcessBuilder("java", "-jar", c.getAbsolutePath());
			//@SuppressWarnings("unused")
			//Process p = pb.start();
			final Color white = new Color(199, 197, 197);
			final Color gray = new Color(41, 39, 39);
			final Color ngray = new Color(32, 32, 32);
			String title1 = c.getName();

			String title = title1.substring(0, title1.length() - 3);
			JButton label1 = new JButton(title.substring(4, title.length() - 1));

			label1.setBorderPainted(false);

			label1.setBackground(gray);

			label1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JButton src = (JButton) e.getSource();
					DashboardWindow.tlabel.setText(src.getText());
					DashboardWindow.tlabel.revalidate();
					
					String pathString = "C:\\Program Data\\Dummy Launcher\\apps\\app_" + src.getText() + ".dsc";
					String fileString = "C:\\Program Data\\Dummy Launcher\\apps\\app_" + src.getText() + ".jar";
					Path toDsc = Paths.get(pathString);
					File file = new File(pathString);	
					File filee = new File(fileString);
					cp = filee;
					System.out.println(file.getAbsolutePath());
					System.out.println(filee.getAbsolutePath());
					if (file.exists()){

						try {
							String desc = new String(Files.readAllBytes(toDsc));

							DashboardWindow.descText.setForeground(white);
							DashboardWindow.descText.setBackground(ngray);
							DashboardWindow.descText.setEditable(false);
							DashboardWindow.descText.setText(desc);

							DashboardWindow.descText.repaint();
							DashboardWindow.apps.revalidate();
							DashboardWindow.run.setVisible(true);
						} catch (IOException e1) {
							System.err.println("CRITICAL ERROR!!! Error : " + e1);
							IOError window = new IOError("*CRITICAL ERROR*", e1);
							window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							DashboardWindow.ChangeText("Error");
						}
					}else{
						DashboardWindow.descText.setForeground(white);
						DashboardWindow.descText.setBackground(ngray);
						DashboardWindow.descText.setEditable(false);
						DashboardWindow.descText.setText("There is no description for this program");

						DashboardWindow.descText.repaint();
						DashboardWindow.apps.revalidate();
						DashboardWindow.run.setVisible(true);
					}

					DashboardWindow.run.removeActionListener(DashboardWindow.ral);

					

					DashboardWindow.ral = new ActionListener (){

						@SuppressWarnings({ "unused" })
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton src = (JButton) e.getSource();


							ProcessBuilder pb = new ProcessBuilder("java", "-jar", cp.getAbsolutePath());
							try {
								Process p = pb.start();
							} catch (IOException er) {
								System.err.println("CRITICAL ERROR!!! Error : " + e);
								IOError window = new IOError("*IO ERROR*", er);
								window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								DashboardWindow.ChangeText("Error");
							}
						}

					};

					DashboardWindow.run.addActionListener(DashboardWindow.ral);
					DashboardWindow.run.setVisible(true);
				}

			});
			// set styling here

			label1.setFont(new Font("Arial", Font.PLAIN, 12));
			label1.setForeground(white);
			//label1.setAlignmentX(Component.CENTER_ALIGNMENT);
			//DashboardWindow.springLayout.putConstraint(SpringLayout.WEST, label1, (int) (width / 3), SpringLayout.WEST, label1);
			DashboardWindow.apps.add(label1);

		}
	}


}