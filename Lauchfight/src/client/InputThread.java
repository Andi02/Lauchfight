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
			actionsBuffer += "addX 1 " + x + "_";
			actionsBuffer += "addY 1 " + y + "_";

			if (Screen.MouseBut1) {
				actionsBuffer += "attack 1 0 " + Screen.MouseX + " " + Screen.MouseY + "_";
			}
			if (Screen.MouseBut2) {
				actionsBuffer += "attack 1 1 " + Screen.MouseX + " " + Screen.MouseY + "_";
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
