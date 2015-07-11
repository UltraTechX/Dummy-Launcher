package Testers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;

import BootstrapperFiles.Vererror;

public class ErrTest {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			String ver = new String(Files.readAllBytes(Paths.get("C:\\Program Files\\Dummy Launcher\\version.txt")));
		} catch (IOException e) {
			System.err.println("CRITICAL ERROR!!! Error : " + e);
			Vererror window = new Vererror("*CRITICAL ERROR*", e);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	}

}
