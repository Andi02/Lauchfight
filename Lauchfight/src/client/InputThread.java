package client;

import java.util.ArrayList;

import lauchfight.LauchFightOnline;

public class InputThread extends Thread {
	


    
	static String actions = "";

	public void run() {
		
		//start the Send therad
		SendThread st = new SendThread();
		st.start();
		
        
		while (true) {

			String actionsBuffer = "";

			int x = 0;
			int y = 0;
			// check inputs
			if (Screen.W) {
				y = -1;
			}
			if (Screen.S) {
				y = 1;
			}
			if (Screen.A) {
				x = -1;
			}
			if (Screen.D) {
				x = 1;
			}

			// move the x pos
			actionsBuffer += "addX "+Client.player+" " + x + "_";
			actionsBuffer += "addY "+Client.player+" " + y + "_";

			if (Screen.MouseBut1) {
				actionsBuffer += "attack "+Client.player+" 0 " + Screen.MouseX + " " + Screen.MouseY + "_";
			}
			if (Screen.MouseBut2) {
				actionsBuffer += "attack "+Client.player+" 1 " + Screen.MouseX + " " + Screen.MouseY + "_";
			}
			
			actions = actionsBuffer;
			// System.out.println(obs.size());
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException ex) {
			}

		}

	}

}
