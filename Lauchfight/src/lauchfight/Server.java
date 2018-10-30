package lauchfight;

import java.net.ServerSocket;
import java.util.ArrayList;


public class Server {
    
    static ServerSocket finalServerSocket;
    
    static ArrayList<ServerThread> th = new ArrayList<ServerThread>();
    static LauchFightOnline lfo;
    
    public static void main(String[] args) {
        lfo = new LauchFightOnline();
        lfo.setUp();
        
        int port = 8187;

        //Create multiple ServerSockets to connect to a server
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }

        finalServerSocket = serverSocket;

        //for every player that wants to connect to the server
        th.add(new ServerThread());
        th.add(new ServerThread());
        th.add(new ServerThread());
        
        th.stream().forEach((a) -> {
        	a.start();
        });
        
    }
    
    
    public void gameLoop() {
    	
    	while(true) {
    		
    		lfo.gameLoop();
    		
    		
    	}
    	
    }
    
}
