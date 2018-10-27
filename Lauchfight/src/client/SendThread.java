package client;

import java.util.ArrayList;

import lauchfight.LauchFightOnline;

public class SendThread extends Thread{
	
    LauchFightOnline lfo;
	
	public void run() {
		
		lfo = new LauchFightOnline();

        lfo.setUp();

		while(true) {
			String[] pos = lfo.tickGame(InputThread.actions).split("_");
			
			ArrayList<FixObject> buff = new ArrayList<FixObject>();
			
			for (int i = 0; i < pos.length; i++) {
				// add to obs
				buff.add(new FixObject(pos[i]));
			}
			
			Client.obs = buff;
			
			
		}
		
		
	}

}
