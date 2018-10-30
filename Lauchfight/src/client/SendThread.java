package client;

import java.util.ArrayList;

import lauchfight.LauchFightOnline;

public class SendThread extends Thread{
	
    LauchFightOnline lfo;
    Connection con;
	
	public void run() {
		
		//Online: 
		con = new Connection();
		
		//Ofline
		lfo = new LauchFightOnline();

        lfo.setUp();

		while(true) {
			//Online: 
			String[] pos = con.readWrite(InputThread.actions).split("_");
			//Ofline: String[] pos = lfo.tickGame(InputThread.actions).split("_");
			ArrayList<FixObject> buff = new ArrayList<FixObject>();
			
			for (int i = 0; i < pos.length; i++) {
				// add to obs
				buff.add(new FixObject(pos[i]));
			}
			
			Client.obs = buff;
			
			try {
				Thread.sleep(1);
			}catch(Exception e) {}
		}
		
		
	}

}
