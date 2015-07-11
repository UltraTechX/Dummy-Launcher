package BootstrapperFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JFrame;

import Dashboard.loadDashboard;

public class Bootstrapper {
	static StartupWindow Startup = new StartupWindow("Startup", 20);
	public static void main(String[] args) {
		versionCheck();
	}

	private static void versionCheck(){
		Startup.ChangeText("Checking Version...");
		StartupWindow.PBarValue(1);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			System.err.println("CRITICAL ERROR!!! Error : " + e);
			Ierror window = new Ierror("*INTERRUPTION*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Startup.ChangeText("Error");
		}
		File file = new File("C:\\Program Data\\Dummy Launcher\\version.dat");
		if(file.exists()){
			StartupWindow.PBarValue(2);
			if(file.getPath() == "C:\\Program Data\\Dummy Launcher\\version.dat"){
				try {
					Thread.sleep(255);
				} catch (InterruptedException e) {
					System.err.println("CRITICAL ERROR!!! Error : " + e);
					Ierror window = new Ierror("*INTERRUPTION*", e);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Startup.ChangeText("Error");
				}
				StartupWindow.PBarValue(3);
				String ver = "";
				StartupWindow.PBarValue(4);
				try {
					ver = new String(Files.readAllBytes(Paths.get("C:\\Program Data\\Dummy Launcher\\version.dat")));
				} catch (IOException e) {
					System.err.println("CRITICAL ERROR!!! Error : " + e);
					Vererror window = new Vererror("*CRITICAL ERROR*", e);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Startup.ChangeText("Error");
				}

				String curver = BootstrapperSettings.build + "";
				if(ver.equals(curver)){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.err.println("CRITICAL ERROR!!! Error : " + e);
						Ierror window = new Ierror("*INTERRUPTION*", e);
						window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						Startup.ChangeText("Error");
					}
					try {
						Thread.sleep(386);
					} catch (InterruptedException e) {
						System.err.println("CRITICAL ERROR!!! Error : " + e);
						Ierror window = new Ierror("*INTERRUPTION*", e);
						window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						Startup.ChangeText("Error");
					}
					StartupWindow.PBarValue(5);
					System.out.println("good version, continuing...");
					CheckVETester();					
				}else{
					System.out.println("old or bad version detected, try updating it...");
					Startup.ChangeText("Bad Version...");
				}
			}
		}else{
			StartupWindow.PBarValue(2);
			Startup.ChangeText("Setting Version");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.err.println("CRITICAL ERROR!!! Error : " + e);
				Ierror window = new Ierror("*INTERRUPTION*", e);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Startup.ChangeText("Error");
			}
			try{
				file = new File("C:\\Program Data\\Dummy Launcher\\version.dat");
				file.getParentFile().mkdirs();
				FileWriter writer = new FileWriter(file);
				writer.write(BootstrapperSettings.build + "");
				writer.close();
				System.out.println("Version Reference Created! At " + file.getPath());
				CheckVETester();
			} catch (IOException e) {
				System.err.println("Something went wrong, please try again. ERROR : " + e);
				Vererror window = new Vererror("*CRITICAL ERROR*", e);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Startup.ChangeText("Error");
			}
		}
	}

	


	private static void CheckVETester(){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			System.err.println("CRITICAL ERROR!!! Error : " + e);
			Ierror window = new Ierror("*INTERRUPTION*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Startup.ChangeText("Error");
		}
		StartupWindow.PBarValue(11);
		//checking files for startup
		File file = new File("C:\\Program Data\\Dummy Launcher\\testers\\VETester.java");
		if(file.exists()){
			StartupWindow.PBarValue(12);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.err.println("CRITICAL ERROR!!! Error : " + e);
				Ierror window = new Ierror("*INTERRUPTION*", e);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Startup.ChangeText("Error");
			}
			if(file.getPath() == "C:\\Program Data\\Dummy Launcher\\testers\\VETester.java"){
				StartupWindow.PBarValue(13);
				StartupPicCheck();
			}
		}else{
			StartupWindow.PBarValue(12);
			InstallVETester();
		}
	}

	private static void InstallVETester(){
		StartupWindow.PBarValue(14);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			System.err.println("CRITICAL ERROR!!! Error : " + e);
			Ierror window = new Ierror("*INTERRUPTION*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Startup.ChangeText("Error");
		}
		try{
			File file = new File("C:\\Program Data\\Dummy Launcher\\testers\\VETester.java");
			file.getParentFile().mkdirs();
			FileWriter writer = new FileWriter(file);
			writer.write("package Testers;\n" +
					"\n" +
					"import java.io.IOException;\n" +
					"import java.nio.file.Files;\n" +
					"import java.nio.file.Paths;\n" +
					"\n" +
					"import javax.swing.JFrame;\n" +
					"\n" +
					"import Bootstrapper.Vererror;\n" +
					"\n" +
					"public class ErrTest {\n" +
					"\n" +
					"	public static void main(String[] args) {\n" +
					"		try {\n" +
					"			String ver = new String(Files.readAllBytes(Paths.get(\"C:\\Program Files\\Dummy Launcher\\version.txt\")));\n" +
					"		} catch (IOException e) {\n" +
					"			System.err.println(\"CRITICAL ERROR!!! Error : \" + e);\n" +
					"			Vererror window = new Vererror(\"*CRITICAL ERROR*\", e);\n" +
					"			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n" +
					"		}\n" +
					"\n" +
					"	}\n" +
					"\n" +
					"}\n"
					);
			System.out.println("VETester created At " + file.getPath());
			writer.close();
			StartupPicCheck();
		}catch(IOException e){
			StartupWindow.PBarValue(14);
			System.err.println("Something went wrong, please try again. ERROR : " + e);
			Vererror window = new Vererror("*CRITICAL ERROR*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Startup.ChangeText("Error");
		}

	}





	private static void StartupPicCheck(){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			System.err.println("CRITICAL ERROR!!! Error : " + e);
			Ierror window = new Ierror("*INTERRUPTION*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Startup.ChangeText("Error");
		}
		StartupWindow.PBarValue(15);
		File file = new File("C:\\Program Data\\Dummy Launcher\\pictures\\startup.png");
		if(file.exists()){
			StartupWindow.PBarValue(16);
			if(file.getPath() == "C:\\Program Data\\Dummy Launcher\\pictures\\startup.png"){
				StartupWindow.PBarValue(20);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					System.err.println("CRITICAL ERROR!!! Error : " + e);
					Ierror window = new Ierror("*INTERRUPTION*", e);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Startup.ChangeText("Error");
				}
				try {
					Startup.ChangeText("Done!");
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					System.err.println("Something went wrong, please try again. ERROR : " + e);
					Ierror window = new Ierror("*INTERRUPTED*", e);
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					Startup.ChangeText("Error");
				}
				Startup.Close();
				loadDashboard.LoadDashboard();
			}
		}else{
			StartupWindow.PBarValue(16);
			InstallStartupPic();
		}
	}

	private static void InstallStartupPic(){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			System.err.println("CRITICAL ERROR!!! Error : " + e);
			Ierror window = new Ierror("*INTERRUPTION*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Startup.ChangeText("Error");
		}
		StartupWindow.PBarValue(18);
		String path = new File("src/BootstrapperFiles/startup.png").getAbsolutePath();

		String[] newNames = {"startup.png"};

		Path source = Paths.get(path); //original file
		Path targetDir = Paths.get("C:\\Program Data\\Dummy Launcher\\pictures"); 
		StartupWindow.PBarValue(19);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			System.err.println("CRITICAL ERROR!!! Error : " + e);
			Ierror window = new Ierror("*INTERRUPTION*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Startup.ChangeText("Error");
		}
		try{
			Files.createDirectories(targetDir);//in case target directory didn't exist
			StartupWindow.PBarValue(20);
			for (String name : newNames) {
				Path target = targetDir.resolve(name);// create new path ending with `name` content
				System.out.println("Startup Picture created at " + target);
				Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
				// I decided to replace already existing files with same name
			}
			StartupWindow.PBarValue(20);
			Thread.sleep(2000);
			Startup.ChangeText("Done!");
			Startup.Close();
			loadDashboard.LoadDashboard();
		}catch(IOException e){
			StartupWindow.PBarValue(19);
			System.err.println("Something went wrong, please try again. ERROR : " + e);
			Vererror window = new Vererror("*CRITICAL ERROR*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Startup.ChangeText("Error");
		} catch (InterruptedException e) {
			System.err.println("Something went wrong, please try again. ERROR : " + e);
			Ierror window = new Ierror("*INTERRUPTION*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Startup.ChangeText("Error");
		}

	}






}





