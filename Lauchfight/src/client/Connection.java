package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connection {
	
	Socket socket;
	InputStream inputToServer;
	OutputStream outputFromServer;
	Scanner input;
	PrintWriter printWriter;

	public Connection() {

		final String host = "192.168.43.85";
		final int portNumber = 8187;
		System.out.println("Creating socketimport java.io.InputStreamReader; to '" + host + "' on port " + portNumber);
		
		
		try {
			socket = new Socket(host, portNumber);
			inputToServer = socket.getInputStream();
			outputFromServer = socket.getOutputStream();

			input = new Scanner(inputToServer, "UTF-8");
			printWriter = new PrintWriter(new OutputStreamWriter(outputFromServer, "UTF-8"), true);
		} catch (Exception e) {
		}

	}
	
	public String readWrite(String action) {
		
		printWriter.println(action);
		
		try {
			//get the return
			String s = input.nextLine();
			//System.out.println(s);
			return s;
		}catch(Exception e) {
			return " ";
		}
			
	}

}
